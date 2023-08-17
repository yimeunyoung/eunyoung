-- !!복습!! QWE123회원이 자바의 정석을 예약했을 때 적용해야하는 쿼리
INSERT INTO RESERVATION(RE_RESERVATION_DATE, RE_ME_ID, RE_BO_NUM)
	SELECT DATE_FORMAT(NOW(), '%Y-%m-%d'), 'QWE123', BO_NUM FROM BOOK 
    WHERE BO_TITLE = '자바의 정석';

UPDATE BOOK 
SET 
	BO_POSSIBLE_RESERVATION = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '예약중')
WHERE
	BO_NUM = '101.1ABC12'; -- 업데이트하는 테이블이 BOOK인데 BOOK에서 조회해서 값을 가져올 수 없다.

-- 예약 가능한 도서를 조회하는 쿼리
SELECT 
	* 
FROM 
	BOOK 
WHERE 
	BO_POSSIBLE_RESERVATION = (SELECT 
			BS_NUM 
		FROM 
			BOOK_STATE 
		WHERE 
			BS_DESC = '예약가능');

-- 대출 가능한 도서를 조회하는 쿼리
SELECT 
	* 
FROM 
	BOOK 
WHERE 
	BO_POSSIBLE_LOAN = (SELECT 
			BS_NUM
		FROM 
			BOOK_STATE
		WHERE
			BS_DESC = '대출가능') 
	AND 
		BO_POSSIBLE_RESERVATION IN(SELECT 
			BS_NUM
		FROM 
			BOOK_STATE
		WHERE
			BS_DESC != '예약중') ;

 -- !!!복습!!! QWE123회원이 대출 가능한 도서를 조회하는 쿼리.
SELECT 
	BOOK.* 
FROM 
	BOOK 
		LEFT JOIN -- LEFT 조인 시 예약 테이블이 포함되기 때문에 '예약중' 확인 안해도 됨
    RESERVATION ON RE_BO_NUM = BO_NUM
WHERE 
	BO_POSSIBLE_LOAN = (SELECT 
			BS_NUM
		FROM 
			BOOK_STATE
		WHERE
			BS_DESC = '대출가능') 
	AND
	(RE_NUM IS NULL OR RE_ME_ID = 'QWE123');

-- !!!복습!!! QWE123회원이 예약한 자바의 정석을 대출했을 때 적용해야하는 쿼리
-- 대출 테이블에 데이터 추가
INSERT INTO LOAN(LO_DATE, LO_ME_ID, LO_BO_NUM, LO_EXPECTED_DATE)
	SELECT DATE_FORMAT(NOW(), '%Y-%m-%d'), 'QWE123', BO_NUM, 
    DATE_FORMAT(DATE_ADD(NOW(), INTERVAL 14 DAY), '%Y-%m-%d') 
    FROM BOOK 
    WHERE BO_TITLE = '자바의 정석';
-- 예약 테이블에 데이터를 삭제
DELETE FROM RESERVATION 
WHERE 
	RE_ME_ID = 'QWE123' 
	AND RE_BO_NUM = (SELECT 
		BO_NUM 
	FROM 
		BOOK 
	WHERE 
		BO_TITLE = '자바의 정석'); 
-- 도서 상태를 수정
UPDATE BOOK 
SET 
	BO_POSSIBLE_LOAN = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '대출중'), 
	BO_POSSIBLE_RESERVATION = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '예약가능')
WHERE
	BO_NUM = '101.1ABC12'; -- 업데이트하는 테이블이 BOOK인데 BOOK에서 조회해서 값을 가져올 수 없다.

-- 회원이 대출한 도서 수를 증가
UPDATE MEMBER
SET 
	ME_BOOK_COUNT = ME_BOOK_COUNT + 1
WHERE
	ME_ID = 'QWE123' ;

-- QWE123회원이 현재 대출한 도서를 조회하는 쿼리
SELECT * FROM BOOK
	JOIN 
	LOAN ON LO_BO_NUM = BO_NUM
WHERE LO_ME_ID = 'QWE123' AND LO_RETURN_DATE IS NULL;

-- QWE123회원이 자바의 정석을 반납했을 때 필요한 쿼리
-- 대출 테이블에 반납일을 수정
UPDATE LOAN 
SET 
	LO_RETURN_DATE = DATE_FORMAT(NOW(), '%Y-%m-%d') 
WHERE
	LO_ME_ID = 'QWE123' 
		AND LO_BO_NUM = (SELECT 
			BO_NUM 
		FROM 
			BOOK 
		WHERE
			BO_TITLE = '자바의 정석');
-- 도서 테이블에 해당 도서의 도서 상태를 수정
UPDATE BOOK
SET 
	BO_POSSIBLE_LOAN = (SELECT BS_NUM  FROM BOOK_STATE WHERE BS_DESC = '대출가능')
WHERE BO_NUM = '101.1ABC12';
-- 회원이 대출한 도서 수를 감소
UPDATE MEMBER
SET 
	ME_BOOK_COUNT = ME_BOOK_COUNT - 1
WHERE ME_ID = 'QWE123';
-- !!다시 공부!! 연체일을 계산해서 회원 테이블을 수정
UPDATE MEMBER
SET 
	ME_TOTAL_OVERDUE = ME_TOTAL_OVERDUE + (SELECT
			CASE
				WHEN DATEDIFF(LO_RETURN_DATE, LO_EXPECTED_DATE) < 1 THEN -- 빨리 반납한다고해서 마이너스로 되면 안되기 때문에 0으로 처리
					0
				ELSE
					DATEDIFF(LO_RETURN_DATE, LO_EXPECTED_DATE)
			END AS 연체일
		FROM LOAN 
		WHERE
			LO_ME_ID = 'QWE123' AND LO_BO_NUM = '101.1ABC12')
WHERE
	ME_ID = 'QWE123';
 
 -- !!다시 공부- 영상 봐야함(오후12시 수업)!! 회원이 대출한 모든 도서가 반납됐을 때 연체일이 있으면 다음날부터 연체 적용이 되도록 수정
UPDATE MEMBER
SET 
	ME_APPLY_OVERDUE = (SELECT 
			CASE
				WHEN
					ME_BOOK_COUNT = 0
						AND ME_TOTAL_OVERDUE != 0
				THEN
					DATE_FORMAT(DATE_ADD(NOW(),
								INTERVAL ME_TOTAL_OVERDUE DAY), 
							'%Y-%m-%d')
				ELSE NULL
			END AS T
		FROM
			(SELECT * FROM MEMBER) AS TMP -- 멤버 테이블에서 업데이트 하고 있기 때문에 중복되면 안되서 이름 바꿔서(TMP) 써줌
		WHERE 
			ME_ID = 'QWE123')
WHERE
	ME_ID = 'QWE123'; 
 
-- 각 회원들의 대출이 불가능한 기간을 조회하는 쿼리. 
-- 대출이 가능한 회원은 대출 가능으로 표시하고,
-- 대출이 불가능한 회원은 언제까지인지를 표시 하도록 작성
SELECT ME_ID AS 아이디, 
	CASE 
		WHEN ME_APPLY_OVERDUE IS NULL THEN '대출가능' 
		ELSE ME_APPLY_OVERDUE 
	END AS 대출불가일
FROM MEMBER;

-- 각 도서별 대출 횟수를 조회하는 쿼리
SELECT 
	BO_TITLE AS 도서명, COUNT(LO_NUM) AS 대출횟수 
FROM 
	BOOK 
		LEFT JOIN -- 0인 결과값까지 조회되게 하기 위해 OUTER JOIN 사용
    LOAN ON LO_BO_NUM = BO_NUM
GROUP BY BO_NUM ;

-- 학생별 연체 횟수를 조회하는 쿼리
SELECT 
    ME_ID AS 아이디, COUNT(LO_EXPECTED_DATE < LO_RETURN_DATE) AS 연체회수
FROM
	MEMBER 
		LEFT JOIN
	LOAN ON LO_ME_ID = ME_ID
GROUP BY ME_ID;

-- 도서를 가장 많이 대출한 회원을 조회하는 쿼리, 대출수가 같은 경우 아이디순으로 정렬 후 첫번째 회원을 선택
SELECT 
    ME_ID AS 아이디, COUNT(LO_NUM) AS 대출도서수
FROM
    MEMBER
        LEFT JOIN
    LOAN ON LO_ME_ID = ME_ID
GROUP BY ME_ID
ORDER BY 대출도서수 DESC, 아이디 ASC
LIMIT 1;

 