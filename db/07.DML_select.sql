/*
select문 기본
select 속성명, ..., 속성명n from 테이블명;
=> 테이블에서 속성명1, ..., 속성명n의 값들을 조회
=> 전체를 조회하려면 *을 이용 => * = all을 의미

as : 속성 또는 테이블명을 일시적으로 변경해서 사용할 때 쓰는 키워드
속성명1 as 속성명2 => 속성명1을 일시적으로 속성명2로 사용
*/
use course;

-- 등록된 모든 학생의 모든 정보를 조회하는 쿼리
select * from student;
-- 등록된 모든 학생의 학번을 조회하는 쿼리 => as '학번'을 안쓰면 원래 속성명인 num으로 나옴
select num as '학번' from student;

/*
select 속성명1, ..., 속성명n from 테이블명 where 조건식;
=> 조건식을 만족하는 행(튜플)들만 검색해서 해당 행의 속성1, ...,속성n의 정보를 조회

where절
속성명1 = 값1 or 속성명2 = 값2 and 속성명3 = 값3

where절에 사용되는 연산자
= : 같다. null과 비교가 안됨(따라서 is null or is not null을 사용)
!= : 같지 않다. null과 비교가 안됨
<> : 같지 않다. null과 비교가 안됨
and : ~하고, 자바의 &&연산자
or : ~하거나, 자바의 ||연산자
is null : null인지 확인
is not null : null이 아닌지 확인
like : 와일드카드와 함께 사용되며, 값이 주어진 와일드카드가 포함된 문자열과 같은지를 비교할 때 사용

대표적인 와일드카드
_ : 한 글자를 의미
% : 0글자 이상을 의미

속성명 between A and B : 속성의 값이 A이상 B이하인 조건을 만족할 때 사용
=> 속성명 >= A and 속성명 <= B

속성명 in(값1, 값2,..., 값n) : 속성의 값이 값1이거나 값2이거나 ... 값n인 조건을 만족할 때 사용
=> 속성명 = 값1 or 속성명 = 값2 or ... or 속성명 = 값n
*/
/*
distinct : 중복된 결과를 제거하고 조회
select distinct 속성명 from 테이블명;
*/
/*
- ANY
where 속성명 비교연산자(=, >=, <=, !=, <, >) any(서브쿼리);
=> 속성이 서브쿼리 결과와 비교연산을 했을 때 서브쿼리 결과 중 하나이상 만족하면 조회 
where 속성명 = any(서브쿼리)
=> where 속성명 in(서브쿼리)

- SOME은 ANY와 같음

- ALL
where 속성명 비교연산자(>=, <=, !=, <, >) all(서브쿼리);
=> 속성이 서브쿼리 결과와 비교연산을 했을 때 서브쿼리 결과 모두를 만족하면 조회 
*/
/*
- 정렬 : ORDER BY
- order by는 where절과 group by절 뒤에 나와야 함
order by 속성명1 [정렬방법] [, 속성명2 정렬방법, ...]
=> 속성명1을 정렬방법을 기준으로 정렬하고, 속성명1의 값이 같으면 속성명2를 정렬방법을 기준으로 정렬...
- 정렬방법
	- ASC : 오름차순. 기본값. 행이 아래로 갈수록 값이 커짐
    - DESC : 내림차순. 행이 아래로 갈수록 값이 작아짐
*/
/*
LIMIT : 행(튜플)을 원하는 위치부터 원하는 개수를 가져오기 위한 방법
- 전체 검색 결과가 아닌 일부를 가져올 때 사용
- 위치가 order by절 뒤. 제일 마지막에 위치해야 함.
limit A;
=> 0번지부터 A개를 가져옴
limit A, B;
=> A번지부터 B개를 가져옴
*/
/*
GROUP BY절 : 같은 값을 가지는 행들을 묶어서 평균을 내거나 개수를 세틑 등의 작업(집계함수)을 할 때 사용
HAVING절 : 집계함수에 조건을 걸때 사용
	- 위치는 where절 다음. order by 앞.
자주 사용하는 집계함수
- avg(속성 또는 식) : 평균
- min(속성 또는 식) : 최소값
- max(속성 또는 식) : 최대값
- count(속성) : 행(튜플)의 개수
- count(distinct 속성) : 중복을 배제한 행의 개수
- sum(속성 또는 식) : 합
*/
-- WHERE절 : 컴퓨터공학과 학생들을 조회하는 쿼리
SELECT 
    *
FROM
    student
WHERE
    major = '컴퓨터공학과';
    
-- WHERE절 : 컴퓨터공학과가 아닌 학생들을 조회하는 쿼리
select * from student where major <> '컴퓨터공학과';
select * from student where major != '컴퓨터공학과';

-- WHERE절 : 학번이 2023135001인 학생이 듣는 수강정보를 조회하는 쿼리
select * from course where student_num = '2023135001';

-- WHERE절 : 학점이 3학점인 과목의 과목명을 조회하는 쿼리
select title from subject where point = 3;

-- LIKE : 이름이 3자(언더바 3개 입력해야함)인 학생 정보를 조회하는 쿼리
select * from student where name like '___';

-- LIKE : 성이 유씨인 학생 정보를 조회하는 쿼리(이 문제에서 더 정확한 답은 %를 쓰는 것)
select * from student where name like '유__'; -- 성이 유씨이고 3글자
select * from student where name like '유%'; -- 성이 유씨

-- 학생의 학번 : 입학년도 4자 + 학과코드 3자 + 번호 3자 
-- LIKE : 23학번 학생을 조회하는 쿼리
select * from student where num like '2023%';

-- 방송학과 코드 : 135
-- LIKE : 방송학과 학생을 조회하는 쿼리 (2가지 방법)
select * from student where major = '방송학과';
select * from student where num like '____135%';

-- BETWEEN A AND B : 학점이 2학점 이상 3학점 이하인 과목을 조회하는 쿼리 (2가지 방법)
select * from subject where point >= 2 and point <= 3; 
select * from subject where point between 2 and 3; 

-- IN / OR : 이순신 교수님과 한석봉 교수님이 강의하는 수강 정보를 조회하는 쿼리
select * from course where professor_name = '이순신' or professor_name = '한석봉'; 
select * from course where professor_name in('이순신','한석봉');

-- DISTINCT : 2023년에 수강하는 과목들의 과목코드를 조회하는 쿼리
select distinct subject_code from course where year = 2023;

-- 과목명이 글쓰기인 과목의 수강 정보를 조회하는 쿼리 
-- (동영상 다시 듣기, course에는 과목명 정보가 없기 때문에 where에 subject_code?? )
SELECT 
    *
FROM
    course
WHERE
    subject_code = (SELECT 
            code
        FROM
            subject
		where 
			title = '글쓰기');

-- ANY : 학점이 2학점 또는 3학점인 과목의 수강 정보를 조회 (다시 공부)
select * from course where subject_code = any(select code from subject where point in(2,3));
-- ALL :  글쓰기와 영어가 아닌 모든 과목의 수강 정보를 조회
select * from course
	where subject_code != all(select code from subject where title in('글쓰기','영어'));
select * from course -- ( 다시 확인)
	where subject_code in(select code from subject where title != '글쓰기' and title != '영어');

-- ORDER BY : 학생 정보를 이름순으로 오름차순 정렬하여 조회 (asc를 써도 되고 생략해도 됨)
select * from student order by name;
-- DESC : 학생 정보를 이름순으로 내림차순 정렬하여 조회
select * from student order by name desc;
-- 학생 정보를 전공, 이름순으로 오름차순 정렬하여 조회
select * from student order by major, name; 
select * from student order by major asc, name asc;

-- DISTINCT : 학생들이 소속된 과를 조회하는 쿼리
 select distinct major from student;

-- LIMIT : 학생들 정보를 학번순으로 오름차순 정렬 후 위에서 2명의 학생 정보를 조회하는 쿼리
select * from student order by num asc limit 2;
-- LIMIT : 학생들 정보를 학번순으로 오름차순 정렬 후 3번째, 4번째 학생 정보를 조회하는 쿼리(기본으로 오름차순이기 때문에 order by 안써도됨)
select * from student limit 2, 2;
-- LIMIT : 학생들 정보를 학번순으로 오름차순 정렬 후, 2명씩 보여줄 때 3번째 페이지에 있는 학생 정보를 조회하는 쿼리 ( 동영상 다시 들어야함)
select * from student limit 4, 2;


-- HAVING절 : 각 과별 학생수를 조회하는 쿼리 (동영상 다시 듣기)
SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
select major as 학과, count(num) as 학생수 from student group by major;
-- 과목별 수강 학생수를 과목코드, 수강생 수로 조회하는 쿼리 (수강생수에 띄어쓰기를 하고 싶으면 `` 또는 ''를 써주면 됨)
select subject_code as 과목코드, count(num) as '수강생 수' from course group by subject_code;
-- 과목별 수강생 수가 4명 이상인 과목의 과목 코드를 조회하는 쿼리
select subject_code as 과목코드, count(*) as 수강생수 from course group by subject_code having 수강생수 >= 4;

