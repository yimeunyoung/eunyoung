package day16.homework;

import lombok.Data;

@Data
public class Product {
		/*사이다, 콜라, 환타*/
		private String name; // 제품명
		private int price; //가격
		private int amount; // 수량

		//생성자
		public Product(String name, int price, int amount) {
			this.name = name;
			this.price = price;
			this.amount = amount;
		}

	/**제품 입고 기능 => 현재 수량에 주어진 수량을 누적 */	
	public void store(int amount) {
		//창고에 제품을 추가해야 하는데 음수가 오면 안됨
		if(amount < 0) {
			return;
		}
		accumulate(amount);
	}
	/** 제품 출고 기능 => 현재 수량에서 주어진 수량을 감소 */
	public void release(int amount) {
		if(amount < 0) {
			return;
		}
		accumulate(-amount);
	}

	private void accumulate(int amount) {
		this.amount += amount;
	}
}
