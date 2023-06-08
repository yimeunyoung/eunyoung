package day7.Method;

public class SumMethodEx {

	public static void main(String[] args) {
		/* 두 정수의 합을 구하는 함수(메서드)를 만드세요.
		 */
		int num1 = 1, num2 = 2;
		int res = sum(num1, num2);
		System.out.println(res);
	}
	/**
	 * 기능    : 두 정수가 주어지면 두 정수의 합을 알려주는 메서드
	 * 메서드명 : sum
	 * 리턴타입 : 두 정수의 합 => int 
	 * 매개변수 : 두 정수 => int num1, int num2 // 매개 변수는 생략하면 안됨
	 * @return
	 */
	/**
	 * 기능    : 두 정수가 주어지면 두 정수의 합을 알려주는 메서드
	 * @param num1 정수1
	 * @param num2 정수2
	 * @return 두 정수의 합
	 */
	public static int sum(int num1, int num2) {
		int res = num1 + num2;
		return res; //int의 기본값 0으로 많이 표현함 그리고 이후에 어떻게 구현할지 고민
		// return num1 + num2;  -> 위의 두 문장을 대체하여 쓸 수 있음
	}
}
