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
		JOIN
	RESERVATION ON RV_MS_NUM = MS_NUM
		LEFT JOIN -- 예약과 예약 리스트를 JOIN하는게 아니라 예약 리스트와 좌석을 JOIN
	RESERVATION_LIST ON SE_NUM = RL_SE_NUM
WHERE
	MS_NUM = 8 AND RL_SE_NUM IS NULL;
