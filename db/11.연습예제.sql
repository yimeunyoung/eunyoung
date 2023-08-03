-- 유재석 학생이 수강하는 수강정보를 조회하는 쿼리
select * from course where student_num in(select num from student where name = '유재석');

-- 영어를 수강하는 컴퓨터공학과 학생들의 수강정보를 조회하는 쿼리
SELECT 
    *
FROM
    course
WHERE
    subject_code = (SELECT 
            code
        FROM
            subject
        WHERE
            title = '영어')
        AND student_num IN (SELECT 
            num
        FROM
            student
        WHERE
            major = '컴퓨터공학과');

-- 수강생이 3명 이상인 과목의 과목코드를 조회하는 쿼리
select subject_code as 과목코드, count(*) as '수강생 수' from course group by subject_code having count(*) >= 3;


