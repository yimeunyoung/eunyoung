/*
update : 데이터 수정

update 테이블 set 속성1 = 값1, 속성2 = 값2, ..., 속성n = 값n where 기본키 = 값;

update
	테이블
set
	속성1 = 값1,
    속성2 = 값2,
    ...,
    속성n = 값n
where
	기본키 = 값;
*/
-- MSC001 과목이 0학점 0시간이어서 3학점 4시간으로 변경하는 쿼리
-- 아래의 코드에 ctrl + b를 누르면 자동으로 위의 코드처럼 변함
update subject set point = 3, time = 4 where code = 'MSC001'; 

-- 학번이 홍길동인 학생의 정보를 학번이 '2023135002', 이름은 '하하', 전공은 '방송학과' 로 수정하는 쿼리 
update student set num = '2023135002', name = '하하', major = '방송학과' where num = '홍길동';






