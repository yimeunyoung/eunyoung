-- 관리자를 등록하는 작업
-- 아이디 : admin, 비번 : admin, 이름 : 관리자, 번호 : 011-1111-2222, 생일 : 2000-01-01
-- 권한 : ADMIN
insert into member 
 values('admin', 'admin', '관리자', '011-1111-2222', '2000-01-01', 'ADMIN');
 
-- 관리자가 영화 오펜하이머를 등록하기 전에 사전에 해야하는 작업을 쿼리로 작성
-- 영화를 등록하기 위해 필요한 연령제한 데이터를 추가 : 전체관람가, 12세 관람가, 15세 관람가, 청소년 관람불가, 제한상영가
insert into age values('전체관람가'),('12세 관람가'),('15세 관람가'),('청소년 관람불가'),('제한상영가');
-- 감독/배우를 등록하기 위해서 필요한 국가 데이터를 추가
-- : 한국, 미국, 영국, 일본 등...
insert into country values('한국'), ('미국'), ('영국'), ('일본'), ('아일랜드');
-- 다른 데이터베이스 테이블에 있는 데이터를 가져와서 추가하는 쿼리
-- INSERT INTO COUNTRY SELECT COUNTRY FROM SAKILA.COUNTRY;

-- 영화를 등록하기 위해 필요한 장르 데이터를 추가
-- : 멜로, 드라마, 코미디, SF, 어드벤처, 스릴러, 공포, 액션, 범죄, 전쟁 등...
insert into genre
values ('스릴러'),('멜로'),('드라마'), ('코미디'), ('SF'), ('어드벤처'), ('공포'), ('액션'), ('범죄'), ('전쟁');

-- 관리자가 영화 오펜하이머를 등록하는 작업을 쿼리로 작성
-- 메인포스터를 먼저 등록 : 오펜하이머_메인포스터.jpg
insert into file(fi_name, fi_state) values('오펜하이머_메인포스터.JPG', '메인포스터');
-- 영화 정보를 등록 : 제목, 제목-영어, 개봉일, 런닝타임, 줄거리, 등록된 메인포스터 번호, 연령제한을 선택
insert into movie(mo_title, mo_title_eng, mo_opening_date, mo_running_time, mo_plot, mo_fi_num, mo_ag_name)
 values('오펜하이머', 'Oppenheimer', '2023-08-15', 180, 
 '세상을 구하기 위해 세상을 파괴할 지도 모르는 선택을 해야 하는 천재 과학자의 핵개발 프로젝트', 1, '15세 관람가');
-- 등록된 영화인이 아닌 경우는 영화인을 등록하고, 이미 등록되어 있으면 생략
-- 영화인을 등록(크리스토퍼 놀란, 킬리언 머피, 에밀리 블런트, 맷 데이먼, 로버트 다우니 주니어, 플로렌스 퓨, 
-- 조쉬 하트넷, 케이시애플렉, 라미 말렉, 케네스 브래너)
insert into film_person(fp_name, fp_thumbnail, fp_agency, fp_final_education, 
	fp_birthday, fp_ct_name)
	values ('크리스토퍼 놀란','크리스토퍼 놀란.JPG','','','1970-07-30','영국'),
    ('킬리언 머피','킬리언 머피.JPG','','','1974-05-25','아일랜드'),
    ('에밀리 블런트','에밀리 블런트.JPG','','','1983-02-23','영국'), 
    ('맷 데이먼','맷 데이먼.JPG','','','1970-10-08','미국'), 
    ('로버트 다우니 주니어','로버트 다우니 주니어.JPG','','','1965-04-04','미국'), 
	('플로렌스 퓨','플로렌스 퓨.JPG','','','1996-01-03','영국'), 
    ('조쉬 하트넷','조쉬 하트넷.JPG','','','1978-07-21','미국'), 
    ('케이시애플렉','케이시애플렉.JPG','','','1975-08-12','미국'), 
    ('라미 말렉','라미 말렉.JPG','','','1975-08-12','미국'), 
    ('케네스 브래너','케네스 브래너.JPG','','','1960-12-10','영국');
-- 역할을 등록
insert into role(ro_role, ro_fp_num, ro_mo_num)
 values('감독', 1, 1), 
 ('J.로버트 오펜하이머 역', 2,1), 
 ('키티 오펜하이머 역', 3,1), 
 ('레슬리 그로브스 역', 4,1),
 ('루이스 스트로스 역', 5,1), 
 ('진 태트록 역', 6,1), 
 ('배우', 7,1), 
 ('배우', 8,1), 
 ('배우', 9,1),
 ('닐스보어 역', 10,1);
-- 영화 장르에서 오펜하이머 장르를 추가
insert into movie_genre(mg_ge_name, mg_mo_num) values('드라마',1),('스릴러', 1);
-- 제작 국가에서 오펜하이머 제작국가를 추가
insert into country_production(cp_ct_name, cp_mo_num) values('미국',1),('영국',1),('아일랜드',1);
-- 트레일러와 스틸컷을 등록(오펜하이머_트레일러1.MP4, 오펜하이머_스틸컷.JPG,...)
insert into file(fi_name, fi_state)
values('오펜하이머_트레일러1.MP4','트레일러'),
('오펜하이머_트레일러2.MP4','트레일러'),
('오펜하이머_트레일러3.MP4','트레일러'),
('오펜하이머_스틸컷1.JPG','스틸컷'),
('오펜하이머_스틸컷2.JPG','스틸컷'),
('오펜하이머_스틸컷3.JPG','스틸컷'),
('오펜하이머_스틸컷4.JPG','스틸컷'),
('오펜하이머_스틸컷5.JPG','스틸컷');
-- 영화 파일에 오펜하이머에 어떤 트레일러와 스틸컷이 있는지 등록
insert into movie_file(mf_fi_num, mf_mo_num)
 values(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1);


-- 영화 콘크리트 유토피아를 등록(위에서 했던 영화 오펜하이머와 같은 방식으로 진행)  
-- 트레일러는 2개, 스틸컷은 3개 
-- 메인포스터 등록
insert into file(fi_name, fi_state) values('콘크리트 유토피아_메인포스터.jpg', '메인포스터');
-- 영화정보 등록 
insert into movie(mo_title, mo_title_eng, mo_opening_date, mo_running_time, mo_plot, 
	mo_fi_num, mo_ag_name)
	values('콘크리트 유토피아', 'Concrete Utopia', '2023-08-09', 130, 
 '“아파트는 주민의 것”', 10, '15세 관람가');
-- 영화인 등록(엄태화, 이병헌, 박서준, 박보영, 김선영, 박지후, 김도윤)
insert into film_person(fp_name, fp_thumbnail, fp_birthday, fp_ct_name)
	values ('엄태화','엄태화.JPG','1981-01-01','한국'),
    ('이병헌','이병헌.JPG','1970-07-12','한국'),
    ('박서준','박서준.JPG','1988-12-16','한국'), 
    ('박보영','박보영.JPG','1990-02-12','한국'), 
    ('김선영','김선영.JPG','1976-04-10','한국'), 
	('박지후','박지후.JPG','2003-11-07','한국'), 
    ('김도윤','김도윤.JPG','1981-08-07','한국');
-- 역할을 등록
insert into role(ro_role, ro_fp_num, ro_mo_num)
	values('감독', 11, 2), 
	('배우', 12,2), 
	('배우', 13,2), 
	('배우', 14,2),
	('배우', 15,2), 
	('배우', 16,2), 
	('배우', 17,2);
-- 영화 장르에서 콘크리트 유토피아 장르를 추가
insert into movie_genre(mg_ge_name, mg_mo_num) values('드라마',2);
-- 제작 국가에서 콘크리트 유토피아 제작국가를 추가
insert into country_production(cp_ct_name, cp_mo_num) values('한국',2);
-- 트레일러와 스틸컷을 등록(콘크리트 유토피아_트레일러1.MP4, 콘크리트 유토피아_스틸컷.JPG,...)
insert into file(fi_name, fi_state)
	values('콘크리트 유토피아1.MP4','트레일러'),
	('콘크리트 유토피아2.MP4','트레일러'),
	('콘크리트 유토피아_스틸컷1.JPG','스틸컷'),
	('콘크리트 유토피아_스틸컷2.JPG','스틸컷'),
	('콘크리트 유토피아_스틸컷3.JPG','스틸컷');
-- 영화 파일 등록
insert into movie_file(mf_fi_num, mf_mo_num)
	values(11,2),(12,2),(13,2),(14,2),(15,2);

-- <영화관 등록을위해 사전에 해야하는 작업>
-- 지역 데이터를 추가
insert into region 
	values('서울'),('경기'),('인천'),('강원'),('대전/충청'),('대구'),('부산/울산'),
    ('경상'),('광주/전라/제주');
-- 영화관 등록 : CGV강남 영화관을 등록, 2관, 24좌석
insert into theater(th_name, th_address, th_re_name, th_total_screen, th_total_seat)
	values('CGV강남', '서울특별시 강남구 강남대로 438', '서울', 2, 24);
-- 상영관 등록
-- 1관 6층, 총 10좌석
-- 2관(LCK관) 6층(LASER), 총 14좌석
insert into screen(sc_name, sc_total_seat, sc_th_num)
	values('1관 6층', 10, 1),
    ('2관(LCK관) 6층(LASER)', 14, 1);
-- 좌석을 등록
-- 1관 : A1, A2, A3, A4, B1, B2, B3, C1, C2, C3
-- 2관 : A1, A2, A3, A4, B1, B2, B3, B4, C1, C2, C3, C4, D1, D2
insert into seat(se_name, se_row, se_col, se_sc_num)
	values('A1','A','1',1),
    ('A2','A','2',1),
    ('A3','A','3',1),
    ('A4','A','4',1),
    ('B1','B','1',1),
    ('B2','B','2',1),
    ('B3','B','3',1),
    ('C1','C','1',1),
    ('C2','C','2',1),
    ('C3','C','3',1),
    ('A1','A','1',2),
    ('A2','A','2',2),
    ('A3','A','3',2),
    ('A4','A','4',2),
    ('B1','B','1',2),
    ('B2','B','2',2),
    ('B3','B','3',2),
	('B4','B','4',2),
    ('C1','C','1',2),
    ('C2','C','2',2),
    ('C3','C','3',2),
    ('C4','C','4',2),
    ('D1','D','1',2),
    ('D2','D','2',2);
-- CGV강남 영화관 영화 스케줄
-- 오펜하이머 1관 23년 8월 16일 09:00, 12:30, 16:00, 19:30
-- 콘크리트 유토피아 2관 23년 8월 16일 10:10, 12:50, 18:10, 20:50
insert into movie_schedule(ms_date, ms_start_time, ms_end_time, ms_possible_seat,
	ms_mo_num, ms_sc_num, ms_discount)
select '2023-08-16', '09:00:00', 
right(adddate('2023-08-16 09:00:00', interval mo_running_time+10 minute), 8), 10, 1, 1, 
     case when '09:00' <= '12:00' then 'Y' else 'N' end
from movie where mo_num = 1;

insert into movie_schedule(ms_date, ms_start_time, ms_end_time, ms_possible_seat,
	ms_mo_num, ms_sc_num, ms_discount)
select '2023-08-16', '12:30:00', 
right(adddate('2023-08-16 12:30:00', interval mo_running_time+10 minute), 8), 10, 1, 1, 
     case when '12:30' <= '12:00' then 'Y' else 'N' end
from movie where mo_num = 1;
    
insert into movie_schedule(ms_date, ms_start_time, ms_end_time, ms_possible_seat,
	ms_mo_num, ms_sc_num, ms_discount)
select '2023-08-16', '16:00:00', 
right(adddate('2023-08-16 16:00:00', interval mo_running_time+10 minute), 8), 10, 1, 1, 
     case when '16:00' <= '12:00' then 'Y' else 'N' end
from movie where mo_num = 1;

insert into movie_schedule(ms_date, ms_start_time, ms_end_time, ms_possible_seat,
	ms_mo_num, ms_sc_num, ms_discount)
select '2023-08-16', '19:30:00', 
right(adddate('2023-08-16 19:30:00', interval mo_running_time+10 minute), 8), 10, 1, 1, 
     case when '19:30' <= '12:00' then 'Y' else 'N' end
from movie where mo_num = 1;

insert into movie_schedule(ms_date, ms_start_time, ms_end_time, ms_possible_seat,
	ms_mo_num, ms_sc_num, ms_discount)
select '2023-08-16', '10:10:00', 
right(adddate('2023-08-16 10:10:00', interval mo_running_time+10 minute), 8), 14, 2, 2, 
     case when '10:10' <= '12:00' then 'Y' else 'N' end
from movie where mo_num = 2;

insert into movie_schedule(ms_date, ms_start_time, ms_end_time, ms_possible_seat,
	ms_mo_num, ms_sc_num, ms_discount)
select '2023-08-16', '12:50:00', 
right(adddate('2023-08-16 12:50:00', interval mo_running_time+10 minute), 8), 14, 2, 2, 
     case when '12:50' <= '12:00' then 'Y' else 'N' end
from movie where mo_num = 2;

insert into movie_schedule(ms_date, ms_start_time, ms_end_time, ms_possible_seat,
	ms_mo_num, ms_sc_num, ms_discount)
select '2023-08-16', '18:10:00', 
right(adddate('2023-08-16 18:10:00', interval mo_running_time+10 minute), 8), 14, 2, 2, 
     case when '18:10' <= '12:00' then 'Y' else 'N' end
from movie where mo_num = 2;

insert into movie_schedule(ms_date, ms_start_time, ms_end_time, ms_possible_seat,
	ms_mo_num, ms_sc_num, ms_discount)
select '2023-08-16', '20:50:00', 
right(adddate('2023-08-16 20:50:00', interval mo_running_time+10 minute), 8), 14, 2, 2, 
     case when '20:50' <= '12:00' then 'Y' else 'N' end
from movie where mo_num = 2;

-- <예매를 위해 사전에 해야하는 작업>
-- 요금 데이터를 추가
-- 성인 : 14000, 조조 : 12000
-- 청소년 : 11000, 조조 : 9000
insert into price(pr_type, pr_price, pr_discount_price)
	values('성인', 14000, 12000), ('청소년', 11000, 9000);
-- 회원 등록
-- 아이디 : abc123, 비번 : abc123, 이름 : 홍길동, 번호 : 011-1234-5678
-- 생일 : 2000-01-05, 권한 : USER인 회원이 회원가입
insert into member
	values('abc123', 'abc123', '홍길동', '011-1234-5678', '2000-01-05', 'USER');
-- abc123회원이 CGV강남에서 20:50에 시작하는 콘크리트 유토피아 영화를 성인 2명으로,
-- A1, A2 좌석을 예매했을 때 필요한 쿼리들
-- reservation에 예약 정보를 추가
insert into reservation(rv_num, rv_adult, rv_teenager, rv_me_id, rv_ms_num, rv_price)
select  '202308091614MS008001',2, 0, 'abc123', ms_num,
case
	when ms_discount = 'Y' then
		2 * 12000 + 0 * 9000
	else
		2 * 14000 + 0 * 11000
	end
from movie_schedule where ms_mo_num = 2 and ms_start_time = '20:50:00';
-- reservation_list에 예약 좌석 정보를 추가
insert into reservation_list(rl_rv_num, rl_se_num, rl_pr_num)
	values('202308091614MS008001', 11, 1),('202308091614MS008001', 12, 1);
-- movie_schedule에 예약 가능 좌석 수를 수정
update movie_schedule
set 
	ms_possible_seat = ms_possible_seat - 2 
where
	ms_num = 8;
-- movie에 예매율을 수정
UPDATE MOVIE 
SET 
    MO_RESERVATION_RATE = ROUND(
    (SELECT 
    SUM(RV_ADULT + RV_TEENAGER)
	FROM
		RESERVATION
			JOIN
		MOVIE_SCHEDULE ON RV_MS_NUM = MS_NUM
	WHERE
		MS_MO_NUM = 2) / 
    (SELECT 
		SUM(RV_ADULT + RV_TEENAGER)
	FROM
		RESERVATION
			JOIN
		MOVIE_SCHEDULE ON RV_MS_NUM = MS_NUM) * 100)
WHERE
    MO_NUM = 2;
    
-- 'abc123' 회원이 콘크리트 유토피아 리뷰를 다음과 같이 작성할 때 쿼리
-- 콘크리트 유토피아 재미 있어요 
/* 내가 작성한 쿼리 
INSERT INTO REVIEW(RE_CONTENT, RE_MO_NUM, RE_ME_ID)
	VALUES('"콘크리트 유토피아 재미 있어요"', 2, 'abc123'); 
*/
INSERT INTO REVIEW(RE_CONTENT, RE_MO_NUM, RE_ME_ID)
	SELECT
		'콘크리트 유토피아 재미 있어요', 2, 'abc123'
	FROM 
		MOVIE
	WHERE
		MO_TITLE = '콘크리트 유토피아';

-- abc123회원이 작성한 콘크리트 유토피아 리뷰를 admin회원이 추천을 클릭했을 때 필요한 쿼리
-- 단, 리뷰번호는 1번인걸 알고 있다고 가정
-- 1. 추천 테이블에 데이터 추가
INSERT INTO `LIKE`(LI_ME_ID, LI_RE_NUM) VALUES('admin', 1);
-- 2. 리뷰 테이블에 추천 수를 업데이트
UPDATE REVIEW 
SET RE_TOTAL_LIKE = (SELECT COUNT(*) FROM `LIKE` WHERE LI_RE_NUM = 1)
WHERE RE_NUM = 1;

-- admin회원이 1번 리뷰를 추천 취소 했을 때 필요한 쿼리
DELETE FROM `LIKE` WHERE LI_ME_ID = 'admin' AND LI_RE_NUM = 1;
UPDATE
	REVIEW
SET 
	RE_TOTAL_LIKE = (SELECT COUNT(*) FROM `LIKE` WHERE LI_RE_NUM = 1)
WHERE 
	RE_NUM = 1;
    
