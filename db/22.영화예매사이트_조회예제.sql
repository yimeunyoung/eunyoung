-- 영화 오펜하이머에 출연한 감독과 배우들을 조회하는 쿼리
select 
	mo_title as '영화제목',
	fp_name as '영화인',
    ro_role as '역할'    
from 
	film_person 
	join role on ro_fp_num = fp_num
	join movie on mo_num = ro_mo_num 
where 
	mo_title = '오펜하이머';

-- 영화 오펜하이머 기본 정보를 조회하는 쿼리 (제목, 제목(영문), 개봉일, 런닝타임, 줄거리, 연령제한, 예매율)
select 
	mo_title as '제목',
	mo_title_eng as '제목(영문)',
    mo_opening_date as '개봉일',  
	mo_running_time as '런닝타임',
    mo_plot as '줄거리',
    mo_ag_name as '연령제한',
    concat(mo_reservation_rate, '%') as '예매율'
from 
	movie 
where 
	mo_title = '오펜하이머';
    
-- 영화 오펜하이머의 트레일러와 스틸컷 파일의 개수를 조회하는 쿼리
select 
	mo_title as '영화제목',
	fi_state as '타입',
	count(*) as '트레일러와 스틸컷 파일 개수' -- inner join은 *로 해도 상관 X
from 
	file 
    join 
    movie_file
    on fi_num = mf_fi_num
    join
	movie
    on mf_mo_num = mo_num
where 
	mo_title = '오펜하이머'
group by fi_state;

-- abc123회원의 예매 내역을 조회하는 쿼리 (영화명, 시간, 좌석명)
select 
	mo_title as 영화명 , ms_start_time as 시간, se_name as 좌석명
from reservation
		join 
	reservation_list on rl_rv_num = rv_num
		join 
	seat on rl_se_num = se_num
		join 
	movie_schedule on ms_num = rv_ms_num
		join 
	movie on mo_num = ms_mo_num
where rv_me_id = 'abc123';

-- abc123회원의 예매 내역을 조회하는 쿼리 (영화명, 시간, 성인 X명, 청소년 X명)
select 
	mo_title as 영화명 , ms_start_time as 시간, 
    sum(rv_adult) as 성인수, sum(rv_teenager) as 청소년수 
from 
	reservation
		join 
	movie_schedule on ms_num = rv_ms_num
		join 
	movie on mo_num = ms_mo_num
where rv_me_id = 'abc123'
group by rv_num;

-- CGV강남 영화관에서 콘크리트 유토피아 20:50에 예매 가능한 좌석을 조회하는 쿼리
SELECT 
    SE_NAME
FROM
    SEAT
        JOIN
    SCREEN ON SE_SC_NUM = SC_NUM
		JOIN
	MOVIE_SCHEDULE ON MS_SC_NUM = SC_NUM
WHERE
	MS_NUM = 8 AND SE_NUM NOT IN(
	SELECT RL_SE_NUM FROM RESERVATION
		JOIN RESERVATION_LIST ON RL_RV_NUM = RV_NUM
		WHERE RV_MS_NUM = 8
    );
-- CGV강남 영화관에서 콘크리트 유토피아 20:50에 예매 가능한 좌석을 조회하는 쿼리(OUTER JOIN 이용)
SELECT 
    SE_NAME
FROM
    SEAT
        JOIN
    SCREEN ON SE_SC_NUM = SC_NUM
		JOIN
	MOVIE_SCHEDULE ON MS_SC_NUM = SC_NUM
		LEFT JOIN -- 영화 스케줄과 예약 리스트를 JOIN하는게 아니라 예약 리스트와 좌석을 JOIN
	RESERVATION_LIST ON SE_NUM = RL_SE_NUM
WHERE
	MS_NUM = 8 AND RL_SE_NUM IS NULL;
    
--  CGV강남 영화관에서 콘크리트 유토피아 20:50에 있는 좌석들과 좌석들 예매 여부를 조회하는 쿼리
SELECT 
	SE_NAME as '좌석 번호',
    case 
		when RL_SE_NUM is null then 'Y' -- case when ~ then ~ end는 '조건문'
		else 'N' 
	end as '예약 가능 여부'
FROM
    SEAT
        JOIN
    SCREEN ON SE_SC_NUM = SC_NUM
		JOIN
	MOVIE_SCHEDULE ON MS_SC_NUM = SC_NUM
		LEFT JOIN 
	RESERVATION_LIST ON SE_NUM = RL_SE_NUM
WHERE
	MS_NUM = 8;

-- !!복습하기 !!! 'abc123' 회원이 관람했던 영화 목록을 조회하는 쿼리
select mo_title as 관람영화 from reservation 
    join 
		movie_schedule on rv_ms_num = ms_num
    join 
		movie on ms_mo_num = mo_num 
where 
	rv_me_id = 'abc123' and now() >= concat(ms_date, ' ', ms_start_time)
group by mo_num; -- 같은 영화를 여러번 봐도 관람 영화 목록에는 1번만 출력

-- 예약 가능한 모든 상영 영화 정보를 조회하는 쿼리
SELECT 
    MO_TITLE AS 영화제목,
    MS_DATE AS 상영일,
	MS_START_TIME AS 상영시간,
    MO_AG_NAME AS 연령제한
FROM MOVIE_SCHEDULE
	JOIN MOVIE ON MO_NUM = MS_MO_NUM
 -- 스케줄 중에서 현재 시간이 상영시간 이전이어야 예약 가능. CONCAT을 사용하면 '2023-08-16 09:00:00'이 된다
WHERE
	 now() < concat(ms_date, ' ', ms_start_time) AND MS_POSSIBLE_SEAT > 0;

-- CGV에서 이벤트로, 한 영화를 여러번 본 회원 중 가장 많이본 회원 3명을 뽑으려고 한다.
-- 각 영화를 각 회원이 몇 번 봤는지 조회하는 쿼리
SELECT
	RV_ME_ID AS 회원아이디,
    MO_TITLE AS 영화,
    COUNT(RV_NUM) AS 예약횟수
FROM RESERVATION
		JOIN
	MOVIE_SCHEDULE ON RV_MS_NUM = MS_NUM
		JOIN
	MOVIE ON MS_MO_NUM = MO_NUM
WHERE now() >= concat(ms_date, ' ', ms_start_time)
GROUP BY RV_ME_ID, MS_MO_NUM;
    
-- 회원들 중 금액 사용이 가장 많은 3명의 회원을 조회하는 쿼리
-- 사용 금액이 같은 회원이 여러명인 경우 누구는 순위에 포함되고 누구는 순위에 포함되지 않을 수 있음
SELECT 
    ME_ID AS 아이디,
    SUM(CASE
			WHEN NOW() >= CONCAT(MS_DATE, ' ', MS_START_TIME) THEN RV_PRICE
			ELSE 0
		END)AS 누적금액
FROM
    RESERVATION
        JOIN
    MOVIE_SCHEDULE ON RV_MS_NUM = MS_NUM
        RIGHT JOIN
    MEMBER ON RV_ME_ID = ME_ID
GROUP BY RV_ME_ID
ORDER BY 누적금액 DESC
LIMIT 3;
-- 사용 금액이 같은 회원이 여러명인 경우 여러명 모두 등수에 포함되면 모두 받을 수 있다.
SELECT * FROM (
	SELECT 
		ME_ID AS 아이디,
		누적금액,
		RANK() OVER(ORDER BY 누적금액 DESC) AS 순위
	FROM
		(SELECT *, SUM(CASE
					WHEN NOW() >= CONCAT(MS_DATE, ' ', MS_START_TIME) THEN RV_PRICE
					ELSE 0
				END) AS 누적금액 FROM
		RESERVATION
			JOIN
		MOVIE_SCHEDULE ON RV_MS_NUM = MS_NUM
			RIGHT JOIN
		MEMBER ON RV_ME_ID = ME_ID
		GROUP BY RV_ME_ID
		) AS A
	) AS B
WHERE 순위 <= 3;

-- 영화인별로 배우로 참여한 영화 개수를 조회하는 쿼리
SELECT FP_NAME AS 영화인,
	   IFNULL(COUNT(RO_NUM),0) AS '참여영화수(배우)'
FROM FILM_PERSON
		LEFT JOIN
	(SELECT * FROM ROLE WHERE RO_ROLE = '배우') AS ROLE2 ON FP_NUM = RO_FP_NUM
		JOIN
	MOVIE ON RO_MO_NUM = MO_NUM
GROUP BY FP_NUM;

-- 각 스케줄별 예약한 좌석 수를 조회하는 쿼리 SCREEN MOVIE_SCHEDULE
SELECT 
		MO_TITLE AS 영화,
        MS_DATE AS 상영일,
        MS_START_TIME AS 상영시간,
	   SC_TOTAL_SEAT - ms_possible_seat AS 예약좌석
FROM MOVIE_SCHEDULE
		JOIN
	SCREEN ON  MS_SC_NUM = SC_NUM
		JOIN
	MOVIE ON MO_NUM = MS_MO_NUM;

-- 영화관별 상영 영화목록을 보여주는 쿼리
SELECT 
    TH_NAME AS 영화관명,
    MO_TITLE AS 영화
FROM
    MOVIE_SCHEDULE 
		JOIN
    SCREEN ON SC_NUM = MS_SC_NUM -- 영화관과 연결을 위해 먼저 상영관과 연결
		JOIN
	THEATER ON TH_NUM = SC_TH_NUM -- 영화관명을 조회하기 위해 영화관 연결
		JOIN
	MOVIE ON MS_MO_NUM = MO_NUM -- 영화 제목 조회를 위해 영화관 연결
WHERE
	NOW() < CONCAT(MS_DATE, ' ', MS_START_TIME) 
GROUP BY TH_NUM, MS_MO_NUM;

-- 오펜하이머를 상영하는 영화관을 조회하는 쿼리
SELECT
    MO_TITLE AS 영화,
	TH_NAME AS 영화관명
FROM
    MOVIE_SCHEDULE 
		JOIN
    SCREEN ON SC_NUM = MS_SC_NUM 
		JOIN
	THEATER ON TH_NUM = SC_TH_NUM 
		JOIN
	MOVIE ON MS_MO_NUM = MO_NUM 
WHERE
	NOW() < CONCAT(MS_DATE, ' ', MS_START_TIME) AND MO_TITLE = '오펜하이머'
GROUP BY TH_NUM;