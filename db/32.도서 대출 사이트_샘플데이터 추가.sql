-- 도서 상태 샘플 데이터를 추가
INSERT INTO BOOK_STATE(BS_DESC) 
VALUES('예약가능'),('예약중'),('도서 상태에 의한 예약 불가능'),
('대출가능'),('대출중'),('도서 상태에 의한 대출 불가능');

-- 도서 샘플 데이터를 추가
-- 101.1ABC12 자바의 정석 남궁성 도우출판, 일반도서(대출/예약이 가능한 도서)
INSERT INTO BOOK(BO_NUM, BO_TYPE, BO_TITLE, BO_PUBLISHER, BO_AUTHOR, 
BO_POSSIBLE_LOAN, BO_POSSIBLE_RESERVATION)
VALUES('101.1ABC12', '코딩', '자바의 정석', '도우출판', '저자 : 남궁성', 4, 1),
('103.987DD', '코딩', 'DO IT! 점프 투 파이썬', '이지스퍼블리싱', '저자 : 박응용', 4, 3),
('500.ABC123 V1 1', '외국 소설', '해리포터와 마법사의 돌 1', '문학수첩', 
'저자 : J.K. 롤링저자/강동혁 엮은이 강동혁', 4, 1);

-- 회원 샘플 데이터를 추가
INSERT INTO MEMBER(ME_ID, ME_PW, ME_PHONE, ME_BIRTHDAY, ME_AUTHORITY)
	VALUES('ADMIN', 'ADMIN', '011-1234-5678', '2000-01-01', 'ADMIN'),
    ('QWE123', 'QWE123', '010-1111-2222', '2002-02-02', 'USER');

