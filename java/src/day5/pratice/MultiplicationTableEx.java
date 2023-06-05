package day5.pratice;

public class MultiplicationTableEx {

	public static void main(String[] args) {
		/*구구단 2단을 출력하는 코드를 작성하세요.
		 * 반복횟수 : i는 1부터 9까지 1씩 증가
		 * 규칙성 : 2 x i = 2*i
		 * 2 x 1 = 2
		 * 2 x 2 = 4
		 * ...
		 * 2 x 9 = 18
		 * */
		int i = 1;
		while(i <= 9) {
			System.out.println("2 X " + i + " = " + 2*i);
			++i;
		}
		
		
	}

}
