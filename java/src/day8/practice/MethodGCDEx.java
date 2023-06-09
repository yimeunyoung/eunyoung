package day8.practice;

import java.util.Scanner;

public class MethodGCDEx {

	public static void main(String[] args) {
		//정수 num1과 num2를 입력받아 두 정수의 최대 공약수를 구하는 코드를 작성하세요.
			
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input 2 numbers : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();

		int gcd = gcd(num1, num2);
		
		System.out.println(num1 + " and " + num2 + " gcd : " + gcd);

		sc.close();
		
	}
	public static boolean ismultiple(int num1, int num2) {
		return num1 % num2 == 0;
	}
	/** 두 정수가 주어지면 두 정수의 최대 공약수를 알려주는 메서드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 최대 공약수 => 정수 => int
	 * 메서드명 : gcd
	 */	
		
	public static int gcd(int num1, int num2) {		
		// 원래는 1부터시작해서 최대공약수를 찾았는데 이번에는 뒤에서부터 시작해서 첫 번째로 나오는 공약수 추출
		for(int i = num1 ; i >= 1; i-- ) {
			//i가 num1의 약수이다 == num1은 i의 배수이다
			if(ismultiple(num1, i) && ismultiple(num2, i)) {
				return i;
			}
		}
		return 1; // 두 정수에 따라서 반복문이 한번도 실행되지 않을 수(num1 이 음수일 경우) 
        // 있기때문에 돌려주는 값 1을 설정
	}

}
