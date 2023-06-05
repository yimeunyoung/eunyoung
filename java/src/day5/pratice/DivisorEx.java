package day5.pratice;

import java.util.Scanner;

public class DivisorEx {

	public static void main(String[] args) {
		//정수 num의 약수를 출력하는 코드를 작성하세요.
		//약수 : A를 B로 나누었을 때 나머지가 0이면 B는 A의 약수이다.
		//12의 약수 : 1, 2, 3, 4, 6, 12
 		
		//<힌트>
		/* 정수 num의 약수를 출력하는 코드를 작성하세요.
 		 * 반복횟수 : i는 1(모든 약수의 시작)부터 num(마지막 약수)까지 1씩 증가
 		 * 규칙성 : i가 num의 약수이면 i를 출력
 		 *         => num을 i로 나누었을 때 나머지가 0과 같다면 i를 출력
 		 */
		int num, i; 
		Scanner sc = new Scanner(System.in);
		//정수 입력
		System.out.println("input positive number : ");
		num = sc.nextInt();
		//반복문, i는 1부터 num까지 1씩 증가
		i = 1; //i를 초기화
		while(i <= num) {
			//num를 i로 나누었을 때 나머지가 0과 같다면 i를 출력
			if(num % i == 0) {
				System.out.println(i);
			}
			++i;
		}
		
		sc.close();
		
	}

}
