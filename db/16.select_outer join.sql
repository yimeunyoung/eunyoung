/*
INNER JOIN : 두 테이블이 외래키로 연결 되었을 때, 양쪽다 데이터가 있는 경우
OUTER JOIN : 두 테이블이 외래키로 연결 되었을 때, 한 테이블을 기준으로 연결할 때 사용 
	

- 상품별 리뷰수를 조회하는 경우, 리뷰가 등록이 안된 상품들은 INNER JOIN을 이용하여 리뷰수를 알수가 없음

- OUTER JOIN 문법 : 기준 테이블이 매우 중요. 
  INNER JOIN은 A JOIN B, B JOIN A가 같지만
  OUTER JOIN은 A OUTER JOIN B, B OUTER JOIN A는 결과가 다름 
- 종류 : LEFT, RIGHT
- LEFT JOIN : 기준 테이블을 기준으로 연결
- RIGHT JOIN : 참조 테이블을 기준으로 연결

A LEFT JOIN B == B RIGHT JOIN A

SELECT * FROM 기준테이블 
	JOIN 참조테이블 
    ON 기준테이블.외래키 = 참조테이블.기본키
[WHERE절]
[GROUP BY절]
[HAVING절]
[ORDER BY절]
[LIMIT절]
*/
-- RIGHT JOIN : 제품별 리뷰 개수를 조회하는 쿼리(리뷰가 등록된 제품만 조회)
select 
	op_pr_code as 제품코드, 
    count(re_num) as 리뷰수
from 
	review
		right join 
    `option` on re_op_num = op_num 
group by op_pr_code;

-- INNER JOIN : 제품별 옵션의 개수를 조회하는 쿼리(제품명, 옵션수)
select 
	pr_name as 제품명, 
    count(*) as 옵션수
from 
	product
		join 
	`option`on op_pr_code = pr_code 
group by pr_code;

-- 모르겠음????? OUTER JOIN : 제품별 판매량(반품, 환불을 제외한)을 조회하는 쿼리(제품명, 판매량)
select 
	pr_name as 제품명, 
    ifnull(sum(ol_amount), 0) as 판매량
from 
	product
		join 
	`option` on op_pr_code = pr_code
		left join 
	order_list on ol_op_num = op_num
		left join
	`order` on or_num = ol_or_num
where
	or_state is null or or_state not in ('반품', '환불')
group by pr_code;

-- OUTER JOIN : 제품 옵션별 판매량(반품, 환불을 제외한)을 조회하는 쿼리(제품명, 옵션명, 판매량, 총 판매금액)
select 
	pr_name as 제품명, 
    op_name as 옵션명,
    ifnull(sum(ol_amount), 0) as 판매량,
	pr_price * ifnull(sum(ol_amount), 0) as '총 판매금액'
from 
	product
		join 
	`option` on op_pr_code = pr_code
		left join 
	order_list on ol_op_num = op_num
		left join
	`order` on or_num = ol_or_num
where
	or_state is null or or_state not in ('반품', '환불')
group by op_num;

-- 옵션별 리뷰수를 조회하는 쿼리(제품명, 옵션명, 리뷰수)
select 
	pr_name as 제품명,
    op_name as 옵션명,
    count(re_num) as 리뷰수
from 
	review
		right join 
	`option` on re_op_num = op_num
		join
	product on op_pr_code = pr_code 
	group by op_num;
