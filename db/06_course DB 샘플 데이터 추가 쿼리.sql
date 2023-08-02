/*
다음 학생 정보를 추가하는 쿼리를 작성해서 추가하세요.
학번 : 2023160001, 이름 : 홍길동, 전공 : 컴퓨터공학과
학번 : 2023160002, 이름 : 임꺽정, 전공 : 컴퓨터공학과
학번 : 2023160003, 이름 : 고길동, 전공 : 컴퓨터공학과
학번 : 2023160004, 이름 : 이하니, 전공 : 컴퓨터공학과
학번 : 2023135001, 이름 : 영심이, 전공 : 방송학과
학번 : 2023135002, 이름 : 유재석, 전공 : 방송학과
학번 : 2023135003, 이름 : 유하하, 전공 : 방송학과
*/
insert into student(num, name, major)
values('2023160001','홍길동','컴퓨터공학과'),
('2023160002','임꺽정','컴퓨터공학과'),
('2023160003','고길동','컴퓨터공학과'),
('2023160004','이하니','컴퓨터공학과'),
('2023135001','영심이','방송학과'),
('2023135002','유재석','방송학과'),
('2023135003','유하하','방송학과');

/*
다음 과목 정보를 추가하는 쿼리를 작성하고 실행하세요.
코드 : MSC001, 학점 : 3, 시수 : 4, 대학수학기초
코드 : MSC002, 학점 : 3, 시수 : 3, 대학물리
코드 : BSE001, 학점 : 2, 시수 : 3, 영어
코드 : BSE002, 학점 : 2, 시수 : 3, 글쓰기
코드 : COM001, 학점 : 3, 시수 : 4, 컴퓨터개론
코드 : MED001, 학점 : 3, 시수 : 4, 미디어개론
*/
insert into subject(code, point, time, title) values
('MSC001', 3, 4, '대학수학기초'),
('MSC002', 3, 3, '대학물리'),
('BSE001', 2, 3, '영어'),
('BSE002', 2, 3, '글쓰기'),
('COM001', 3, 4, '컴퓨터개론'),
('MED001', 3, 4, '미디어개론');

/*
다음 강의 정보를 추가하는 쿼리를 작성하고 실행하세요.
-- 모든 컴공과 학생이 대학수학기초를 수강
코드 : MSC001, 학번 : 2023160001, 강의실 : '미정', 교수님 : '미정', 시간표 : '월1,2,수1,2', 연도 : 2023, 학기 : 1
코드 : MSC001, 학번 : 2023160002, 강의실 : '미정', 교수님 : '미정', 시간표 : '월1,2,수1,2', 연도 : 2023, 학기 : 1
코드 : MSC001, 학번 : 2023160003, 강의실 : '미정', 교수님 : '미정', 시간표 : '월1,2,수1,2', 연도 : 2023, 학기 : 1
코드 : MSC001, 학번 : 2023160004, 강의실 : '미정', 교수님 : '미정', 시간표 : '월1,2,수1,2', 연도 : 2023, 학기 : 1
-- 컴공과 학생 중 홍길동, 임꺽정 학생이 대학물리를 수강
코드 : MSC001, 학번 : 2023160001, 강의실 : '361', 교수님 : '이순신', 시간표 : '월3,4,5', 연도 : 2023, 학기 : 1
코드 : MSC001, 학번 : 2023160002, 강의실 : '361', 교수님 : '이순신', 시간표 : '월3,4',5, 연도 : 2023, 학기 : 1
-- 모든 학생이 영어를 수강
코드 : BSE001, 학번 : 2023160001, 강의실 : '본관 101호', 교수님 : '김영철', 시간표 : '화1,2,3', 연도 : 2023, 학기 : 1
코드 : BSE001, 학번 : 2023160002, 강의실 : '본관 101호', 교수님 : '김영철', 시간표 : '화1,2,3', 연도 : 2023, 학기 : 1
코드 : BSE001, 학번 : 2023160003, 강의실 : '본관 101호', 교수님 : '김영철', 시간표 : '화1,2,3', 연도 : 2023, 학기 : 1
코드 : BSE001, 학번 : 2023160004, 강의실 : '본관 101호', 교수님 : '김영철', 시간표 : '화1,2,3', 연도 : 2023, 학기 : 1
코드 : BSE001, 학번 : 2023135001, 강의실 : '본관 101호', 교수님 : '김영철', 시간표 : '화1,2,3', 연도 : 2023, 학기 : 1
코드 : BSE001, 학번 : 2023135002, 강의실 : '본관 101호', 교수님 : '김영철', 시간표 : '화1,2,3', 연도 : 2023, 학기 : 1
코드 : BSE001, 학번 : 2023135003, 강의실 : '본관 101호', 교수님 : '김영철', 시간표 : '화1,2,3', 연도 : 2023, 학기 : 1
-- 방송학과 학생 중 유재석 학생이 글쓰기를 수강
코드 : BSE002, 학번 : 2023135002, 강의실 : '미디어관 201호', 교수님 : '한석봉', 시간표 : '화1,2,3', 연도 : 2023, 학기 : 1
-- 모든 컴공학생이 컴퓨터 개론을 수강
코드 : COM001, 학번 : , 강의실 : '컴퓨터관 301호', 교수님 : '김박사', 시간표 : '금1,2,3,4', 연도 : 2023, 학기 : 1
-- 모든 방송학과 학생이 미디어 개론을 수강
코드 : MED001, 학번 : , 강의실 : '미디어관 301호', 교수님 : '박영화', 시간표 : '목1,2,3,4', 연도 : 2023, 학기 : 1
*/
-- 모든 컴공과 학생이 대학수학기초를 수강
insert into course(subject_code, student_num, room, professor_name, schedule, year, semester)
select 
	'MSC001', num, '미정', '미정', '월1,2,수1,2', 2023, 1 
from 
	student
where 
	major='컴퓨터공학과';
-- 모든 학생이 영어를 수강
insert into course(subject_code, student_num, room, professor_name, schedule, year, semester)
select 
	'BSE001', num, '본관 101호', '김영철', '화1,2,3', 2023, 1 
from 
	student;
-- 모든 컴공학생이 컴퓨터 개론을 수강
insert into course(subject_code, student_num, room, professor_name, schedule, year, semester)
select 
	'COM001', num, '컴퓨터관 301호', '김박사', '금1,2,3,4', 2023, 1 
from 
	student
where 
	major='컴퓨터공학과';
-- 모든 방송학과 학생이 미디어 개론을 수강
insert into course(subject_code, student_num, room, professor_name, schedule, year, semester)
select 
	'MED001', num, '미디어관 301호', '박영화', '목1,2,3,4', 2023, 1 
from 
	student
where 
	major='방송학과';
-- 컴공과 학생 중 홍길동, 임꺽정 학생이 대학물리를 수강
insert into course(subject_code, student_num, room, professor_name, schedule, year, semester)
values('MSC002', '2023160001', '361', '이순신', '월3,4,5', 2023, 1),
('MSC002', '2023160002', '361', '이순신', '월3,4,5', 2023, 1);
-- 방송학과 학생 중 유재석 학생이 글쓰기를 수강
insert into course(subject_code, student_num, room, professor_name, schedule, year, semester)
values('BSE002', '2023135002', '미디어관 201호', '한석봉', '화1,2,3', 2023, 1);





