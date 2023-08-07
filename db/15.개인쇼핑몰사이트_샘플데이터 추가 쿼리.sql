USE SHOPPINGMALL;

-- 회원아이디가 abc123, 비번이 1234, 번호가 011-1234-5678, 이름이 홍길동 
-- 주소가 서울시 강남구 KH빌딩, 주소 상세가 6층 361반, 우편번호가 01234인 회원이 가입을 했을 때 쿼리 작성
-- 권한은 ADMIN, USER 중 하나 
INSERT INTO MEMBER(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY, ME_NAME)
	VALUES('abc123','1234','011-1234-5678','서울시 강남구 KH빌딩', '6층 361반', '01234', 'USER', '홍길동');

INSERT INTO MEMBER(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY, ME_NAME)
	VALUES('admin','admin','011-1111-1111','서울시 강북구 KH빌딩', '3층 101호', '01231', 'ADMIN', '임꺽정');
INSERT INTO MEMBER(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY, ME_NAME)
	VALUES('qwe123','qwe1234','011-9999-5678','서울시 강남구 KH빌딩', '1층 161반', '01234', 'USER', '고길동');

-- 제품코드가 ABC001, 제품명이 KH무선마우스, 제품설명이 KH무선마우스입니다., 가격이 15000원
-- 종류가 무선 / 유선인 제품을 등록하는 쿼리를 작성 
-- PRODUCT 테이블과 OPTION테이블에 데이터를 추가 
INSERT INTO PRODUCT VALUES('ABC001','KH무선마우스','KH무선마우스입니다.', 15000);
INSERT INTO `OPTION`(OP_NAME, OP_PR_CODE) VALUES('무선', 'ABC001'),('유선','ABC001');

-- 제품 코드가 ABC001인 제품의 제품 정보와 옵션을 조회하는 쿼리 
SELECT 
    *
FROM
    PRODUCT
        JOIN
    `OPTION` ON PR_CODE = OP_PR_CODE
WHERE
    PR_CODE = 'ABC001';
    
-- 제품 코드가 ABC001인 제품 중에서 유선 제품이 10개 들어오고, 무선 제품이 5개 들어왔을 때 사용해야하는 쿼리
UPDATE `OPTION` 
SET 
    OP_AMOUNT = 10
WHERE
    OP_PR_CODE = 'ABC001' AND OP_NAME ='유선';
    
UPDATE `OPTION` 
SET 
    OP_AMOUNT = 5
WHERE
    OP_PR_CODE = 'ABC001' AND OP_NAME = '무선';

-- abc123 회원이 배송지를 다음과 같이 등록(배송지명 : 집, 주소: 서울시 강남구 123번지, 
-- 상세 : KH아파트 101동 101호, 우편번호 : 12345)하는 쿼리
insert into address(ad_name,ad_addr, ad_addr_detail, ad_post,ad_me_id)
VALUES('집', '서울시 강남구 123번지', 'KH아파트 101동 101호','12345', 'abc123');

-- abc회원이 ABC001 제품 중 유선을 3개 장바구니에 담았을 때 쿼리
insert into basket(ba_amount, ba_me_id, ba_op_num) select 3, 'abc123', op_num from `option` where op_pr_code = 'ABC001' and op_name ='유선';
-- abc123 회원이 ABC001 제품 중 유선을 1개 장바구니에 담았을 때 쿼리
UPDATE `basket` 
SET 
    ba_amount = 1
WHERE
    ba_me_id = 'abc123' AND ba_op_num = (select op_num from `option` where op_pr_code = 'abc001' and op_name = '유선');
    
-- abc123회원이 ABC001 제품 중 무선을 2개 구매하고 배송지로 집을 선택했을 때
-- 실행해야 하는 모든 쿼리 작성 
-- 1. 주문 내역을 추가 => 주문 리스트에서 주문 내역 번호가 필요하기 때문
insert into `order`(or_total, or_price, or_use_point, or_save_point, or_me_id, or_ad_num)
	values(15000*2, 15000*2, 0, 3000, 'abc123', 1);
-- 2. 주문 리스트에 구매 목록을 추가
insert into order_list(ol_amount, ol_price, ol_or_num, ol_op_num)
	values(2, 15000*2, 1, 1);
-- 3. 제품 수량을 수정
update `option` set op_amount = op_amount - 2 where op_num = 1;
-- 4. 마일리지(포인트) 적립
-- 4-1. 마일리지 내역 추가
insert into point(po_content, po_amount, po_me_id)
	values('제품 구매에 의한 적립', 3000, 'abc123');
-- 4-2. 회원 정보에 포인트 수정 
update member set me_point = me_point + 3000 where me_id = 'abc123';

-- 제품 코드가 ABC002, 제품명 KH키보드, 제품상세가 혁신적인 KH키보드, 제품 가격이 30000원
-- 제품 종류가 '기계식', '일반'인 제품을 등록하는 쿼리
-- 1. 제품 추가
insert into product VALUES('ABC002', 'KH키보드', '혁신적인 KH키보드', 30000);
-- 2. 옵션 추가
insert into `option`(op_name, op_pr_code) values('기계식', 'ABC002'),('일반', 'ABC002');

-- 제품 코드가 ABC002, 종류가 기계식인 제품이 100개, 
update `option` set op_amount = op_amount + 100 WHERE OP_PR_CODE = 'ABC002' AND OP_NAME ='기계식';
-- 제품 코드가 ABC002, 종류가 일반인 제품이 50개 입고 됐을 때 쿼리
update `option` set op_amount = op_amount + 50 WHERE OP_PR_CODE = 'ABC002' AND OP_NAME ='일반';

-- qwe123회원이 ABC001 제품 중 무선을 2개 장바구니에 담고 (옵션 번호를 알면 value / 모르면 select로 씀)
insert into basket(ba_amount, ba_me_id, ba_op_num) 
	select 2, 'qwe123', op_num 
		from `option` 
		where op_pr_code = 'ABC001' 
			and op_name ='무선';
-- 이어서 ABC002 제품 중 기계식을 3개 장바구니에 담았을 때 쿼리를 작성
insert into basket(ba_amount, ba_me_id, ba_op_num) 
	select 3, 'qwe123', op_num 
		from `option` 
        where op_pr_code = 'ABC002' 
			and op_name ='기계식';
            
-- qwe123회원이 장바구니에 담긴 모든 제품을 구매했을 때 쿼리(구매시 포인트 사용은 X)
-- 배송지를 집으로, 서울시 강남구 KH빌딩 1층 161반, 우편번호는 01234를 등록 후 구매
insert into address(ad_name, ad_addr, ad_addr_detail, ad_post, ad_me_id) 
	values('집', '서울시 강남구 KH빌딩', '', '01234', 'qwe123');
-- 1. 주문 테이블에 추가 
insert into `order`(or_total, or_price, or_use_point, or_save_point, or_me_id, or_ad_num)
select 15000*2 + 30000*3, 15000*2 + 30000*3, 0, (15000*2 + 30000*3)/10, 'qwe123', ad_num 
	from address
    where ad_me_id = 'qwe123' and ad_name = '집';
-- 2. 주문 리스트에 구매 목록을 추가
insert into order_list(ol_amount, ol_price, ol_or_num, ol_op_num)
	select 2, pr_price*2, 2, op_num 
    from `option`
    join product
    on op_pr_code = pr_code
    where 
		op_pr_code = 'ABC001' and op_name = '무선';
        
insert into order_list(ol_amount, ol_price, ol_or_num, ol_op_num)
	select 3, pr_price*3, 2, op_num 
    from `option`
    join product
    on op_pr_code = pr_code
    where 
		op_pr_code = 'ABC002' and op_name = '기계식';
-- 3. 옵션 테이블에 수정(수량)
update `option` set op_amount = op_amount - 2 where op_pr_code = 'ABC001' and op_name = '무선';
update `option` set op_amount = op_amount - 3 where op_pr_code = 'ABC002' and op_name = '기계식';

-- qwe123회원이 구매(환불, 반품을 제외한)한 제품명과 옵션명 목록을 확인하는 쿼리
select 
	or_me_id as 주문아이디, 
	pr_name as 제품명,
	op_name as 옵션명,
    pr_price as 제품가격,
    ol_amount as 구매수량
from `order`
    join order_list on ol_or_num = or_num
    join `option` on ol_op_num = op_num
    join product on op_pr_code = pr_code
    where or_state not in ('환불', '반품') and or_me_id = 'qwe123';

-- abc123 회원이 장바구니에 담은 제품과 옵션명, 수량을 확인하는 쿼리
select 
	ba_me_id as 회원아이디, 
	pr_name as 제품명,
	op_name as 옵션명,
    ba_amount as 수량
from basket
    join `option` on ba_op_num = op_num
    join product on op_pr_code = pr_code
    where ba_me_id = 'abc123';

-- abc123회원이 등록한 배송지 정보를 조회하는 쿼리
select * from address where ad_me_id = 'abc123';

-- 등록된 모든 제품을 검색하는 쿼리
select * from product;

-- KH가 제품명에 포함된 제품들을 검색하는 쿼리 (2가지 방법)
select * from product where pr_name like '%KH%';
select * from product where pr_name like concat('%', 'KH', '%');

-- KH가 제품명에 포함된 제품들 중에서 1페이지에 해당하는 제품들을 검색하는 쿼리( 한 페이지에는 제품이 최대 5개)
select * from product where pr_name like '%KH%' limit 0, 5;
-- KH가 제품명에 포함된 제품들 중에서 2페이지에 해당하는 제품들을 검색하는 쿼리( 한 페이지에는 제품이 최대 5개)
select * from product where pr_name like '%KH%' limit 5, 5;

-- abc123회원이 제품을 받고 구매 확정을 눌렀을 때 쿼리
-- 주문을 구매확정으로 수정 (현재 구매건에 대해서만 구매확정을 해야하기 때문에 아이디가 아닌 or_num으로 선택)
update `order` set or_state = '구매확정' where or_num = 1;
-- 포인트 내역에 적립 내용을 추가
insert into point(po_content, po_amount, po_me_id)
	values('제품 구매에 의한 적립', 3000, 'abc123');
-- 회원 정보에 포인트 누적 
update member set me_point = me_point + 3000 where me_id = 'abc123';

-- abc123회원이 구매확정한 ABC001제품 중 무선인 제품에 '좋은 마우스입니다.' 라고 리뷰를 등록했을 때 쿼리.
insert into review(re_content, re_thumb, re_op_num, re_me_id) value('좋은 마우스입니다.', null, 1, 'abc123');

-- abc123회원이 작성한 모든 리뷰를 조회하는 쿼리.
select * from review where re_me_id = 'abc123';

-- abc123회원이 작성한 리뷰가 있는 제품명을 조회
select pr_name as 리뷰제품 from review 
	join `option` on re_op_num = op_num 
    join product on op_pr_code = pr_code 
    where re_me_id = 'abc123';

-- 제품 코드가 ABC001이고, 옵션명이 무선인 제품에 달린 리뷰를 조회
select re_content as 리뷰 from review 
	join `option` on re_op_num = op_num 
    where op_pr_code = 'ABC001' and op_name = '무선';

-- 제품명이 KH무선마우스인 제품의 리뷰 개수를 조회하는 쿼리 작성(select로 작성 방법)
select count(*) as 'KH무선마우스 리뷰수' from review 
	join `option` on re_op_num = op_num 
    join product on op_pr_code = pr_code 
    where pr_name = 'KH무선마우스';
-- 서브쿼리로 작성하는 방법    
select count(*) as 'KH무선마우스 리뷰수' from review 
	join `option` on re_op_num = op_num 
where 
	op_pr_code = (select pr_code from product where pr_name = 'KH무선마우스');

-- 제품별 리뷰 개수를 조회하는 쿼리
select op_pr_code as 제품코드, count(*) as 리뷰수 from review
	join `option` on re_op_num = op_num 
    group by op_pr_code;
    
    
