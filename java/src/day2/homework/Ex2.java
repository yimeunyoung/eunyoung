package day2.homework;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		/*두 정수를 입력받아 두 정수의 산술 연산 결과를 출력하는 코드를 작성하세요. 단, 2번째 숫자는 0이 아님.
		 * 예 :	두 정수를 입력하세요. 
		 * 1 2 [엔터]
		 * 1 + 2 = 3
		 * 1 - 2 = -1
		 * 1 * 2 = 2
		 * 1 / 2 = 0.5
		 * 1 % 2 = 1
		 * */
		//안내 문구 출력
		System.out.println("Please enter two integers.");
		//두 정수를 입력하세요는 파파고에서 번역해서 붙여넣기 하면 됨
		//콘솔에서 입력받을 수 있는 스캐너 생성
		Scanner sc = new Scanner(System.in);
		//두 정수를 입력 받음
		//이 코드는 그냥 외우기
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		//두 정수의 산술 연산을 계산
		//int sum = num1 + num2;
		int sub = num1 - num2;
		int mul = num1 * num2;
		double div = num1 / (double)num2;
		//int mod = num1 % num2;
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		// 마지막에 num1 + num2 에 괄호를 안하면 3이 아니라 1,2 라는 결과가 나옴
		// num1 + num2 대신에 sum 으로 기재해도 상관 X
		// 위에 'int sum = num1 + num2;' 를 정의하지 않으려면 'System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));' 문장만 기재하면됨
		System.out.println(num1 + " - " + num2 + " = " + sub);
		System.out.println(num1 + " * " + num2 + " = " + mul);
		System.out.println(num1 + " / " + num2 + " = " + div);
		//System.out.println(num1 + " % " + num2 + " = " + mod);
		//%는 +보다 우선순위가 높기 때문에 ()을 생략해도 되지만 위에 +와 같은 형태로 보여주기 위해 ()를 붙임
		System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
		// *(곱하기) /(나누기)는 num1 % num2 에 괄호 안해도 되지만 처음 연습할 때는 + -와 같이 괄호 기재하는 것이 좋음
		// 형태가 같아야 복붙하기가 쉬움. 따라서 같은 형태로 작업하는 것이 좋음
		sc.close();
		

	}

}
