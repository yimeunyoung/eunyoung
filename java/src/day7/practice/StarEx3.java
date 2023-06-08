package day7.practice;

public class StarEx3 {

	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 코드를 작성하세요.
		 *      * i=1 공=4 *=1
		 *     ** i=2 공=3 *=2
		 *    *** i=3 공=2 *=3
		 *   **** i=4 공=1 *=4
		 *  ***** i=5 공=0 *=5
		 *            공=5-i *=i
		 * */
		
		/* 외부 반복문
		 * 반복횟수 : i는 1부터 5까지 1씩 증가 
		 * 실행문 : * i개를 출력 후 엔터
		 */
		for(int i = 1 ; i <= 5 ; i++) {
			/* 공백을 출력
			 * 내부 반복문
			 * 반복횟수 : j는 1부터 5-i까지 1씩 증가
			 * 규칙성 : ' '를 출력
			 */
			for(int j = 1 ; j <= 5-i ; j++) {
				System.out.print(' ');
			}
			/* i개를 출력
			 * 내부 반복문
			 * 반복횟수 : j는 1부터 i까지 1씩 증가
			 * 규칙성 : *을 출력
			 */
			for(int j = 1 ; j <= i ; j++) {
				System.out.print("*");
			}
			//엔터
			System.out.println();
		}
		
		
	}

}
