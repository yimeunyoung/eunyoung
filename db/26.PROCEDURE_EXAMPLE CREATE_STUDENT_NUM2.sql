-- 입학년도, 학과코드 주어졌을 때 학번을 생성해서 SELECT로 출력하는 프로시저를 작성
-- 순서는 해당 입학년도와 학과코드를 가진 학생들의 수를 세서 적용
DROP PROCEDURE IF EXISTS CREATE_STUDENT_NUM2;

DELIMITER //
CREATE PROCEDURE CREATE_STUDENT_NUM2(
IN _YEAR INT,
IN _DEP_CODE CHAR(3),
OUT _STUDENT_NUM CHAR(10) -- 최종학번
)
BEGIN
	DECLARE _ORDER_CHAR CHAR(3); -- 순서에 0을 채운 문자열 
    
    SET _ORDER_CHAR = (
		SELECT 
			LPAD(COUNT(*) + 1, 3, "0") 
        FROM 
			STUDENT
		WHERE 
			NUM LIKE CONCAT(_YEAR, _DEP_CODE, "%")
	);
    
    SET _STUDENT_NUM = CONCAT(_YEAR, _DEP_CODE, _ORDER_CHAR);
    -- SELECT _STUDENT_NUM;
END //
DELIMITER ;

-- 프로시저가 아닌 쿼리의 변수를 설정할 때에는 '@'를 사용
SET @STUDENT_NUM := 0;
-- 2023135004	 
CALL CREATE_STUDENT_NUM2(2023, "135", @STUDENT_NUM); -- 이 쿼리를 호출하면 자동으로 학번을 생성

SELECT @STUDENT_NUM;
/* 아래의 쿼리를 먼저 만든 후 위 SET문에 복붙한다.
SELECT LPAD(COUNT(*) + 1, 3, "0") FROM STUDENT
WHERE NUM LIKE CONCAT(2023, "135", "%"); 
*/