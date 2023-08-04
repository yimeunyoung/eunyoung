/*
join 문법
-- 테이블1의 외래키가 테이블2의 기본키를 참조하는 경우
-- JOIN은 일반적으로 외래키와 기본키를 연결하지만, 상황에 따라서는 외래키가 아닌 속성을 기본키와 연결할 수 있음

SELECT 
	테이블1.속성명1, 테이블1.속성명2,...,테이블2.속성명1, 테이블2.속성명2,...
FROM
	테이블1
INNER JOIN | LEFT JOIN | RIGHT JOIN -- INNER 조인과 OUTER 조인 둘다 가능
	테이블2
ON
	테이블1.외래키 = 테이블2.기본키
[INNER JOIN | LEFT JOIN | RIGHT JOIN
	테이블3
ON
	테이블1.외래키 = 테이블2.기본키]

[WHERE절]
[GROUP BY절]
[HAVING절]
[ORDER BY절]
[LIMIT절]

*/
SELECT 
    course.*, title
FROM
    course
JOIN
    subject 
ON 
	subject_code = code;
    
-- 대학물리를 수강하는 학생들 수를 조회하는 쿼리
select subject_code as 과목코드, count(*) as 수강생수 from course where subject_code in (select code from subject where title = '대학물리') group by subject_code;

SELECT 
    subject_code as 과목코드 , count(*) as 수강생
FROM
    course
JOIN
    subject 
ON 
	subject_code = code
where	
	title = '대학물리'
GROUP BY subject_code;

-- 유재석 학생이 수강하는 과목의 수를 조회하는 쿼리
SELECT 
    student_num as 유재석학번, count(*) as 수강과목수
FROM
    course
WHERE
    student_num = (SELECT num FROM student WHERE NAME = '유재석')
GROUP BY student_num;

SELECT 
    student_num as 유재석학번, count(*) as 수강과목수
FROM
    course
JOIN
    student
ON 
	student_num = student.num -- num이 겹치기 때문에 앞에 테이블 이름(student)라고 붙여줌
where	
	name = '유재석'
GROUP BY student_num;
    
-- 유재석 학생이 수강하는 과목명을 조회하는 쿼리
SELECT 
    name as 이름, title as 수강과목
FROM
    course
JOIN
    student
ON 
	student_num = student.num
JOIN
	subject
ON 
	subject_code = code
WHERE
	name = '유재석';
    
-- 이순신 교수님이 강의하는 과목명을 조회
SELECT 
   distinct professor_name as 교수님성함, title as 강의명
FROM
    course
JOIN
	subject
ON 
	subject_code = code
WHERE
	professor_name = '이순신';
    
    