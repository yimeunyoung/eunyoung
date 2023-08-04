USE SHOPPINGMALL;

-- 회원 아이디가 abc123, 비번이 1234, 번호가 011-1234-5678, 
-- 주소가 서울시 강남구 KH빌딩, 주소 상세가 6층 361반, 우편번호가 01234, 이름이 홍길동인 회원이 가입을 했을 때 쿼리
-- 권한은 ADMIN, USER 중 하나
insert into member(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY, ME_NAME)
	values('abc123','1234','011-1234-5678', '서울시 강남구 KH빌딩', '6층 361반', '01234', 'USER', '홍길동');
    
insert into member(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY, ME_NAME)
	values('admin','admin','011-1111-1111', '서울시 강북구 KH빌딩', '3층 101호', '01231', 'ADMIN', '임꺽정');
    
insert into member(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY, ME_NAME)
	values('qwe123','qwe1234','011-9999-2222', '서울시 강서구 KH빌딩', '2층 201호', '01236', 'USER', '유재석');
    
-- 제품코드가 ABC001, 제품명이 KH무선마우스, 제품설명이 KH무선마우스입니다. 가격이 15000원
-- 종류가 무선 / 유선인 제품을 등록하는 쿼리를 작성 
insert into product(PR_CODE, PR_NAME, DETAIL, PR_PRICE)
	values('ABC001','KH무선마우스','KH무선마우스입니다.', '15000원');
insert into product(PR_CODE, PR_NAME, DETAIL, PR_PRICE)
	values('ABC002','KH유선마우스','KH유선마우스입니다.', '17000원');
insert into product(PR_CODE, PR_NAME, DETAIL, PR_PRICE)
	values('ABC003','KC무선마우스','KC무선마우스입니다.', '20000원');