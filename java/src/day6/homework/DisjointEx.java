package day6.homework;

import java.util.Scanner;

public class DisjointEx {

	public static void main(String[] args) {
		/* 두 정수를 입력받아 두 정수가 서로소 관계인지 판별하는 코드를 작성하세요.
		 * 반복횟수 : i는 1부터 num1까지 1씩 증가
		 * 규칙성 : i가 num1의 약수이고 i가 num2의 약수이면 i를 gcd에 저장
		 * 		num1을 i로 나누었을 때 나머지가 0과 같고
		 * 		num2를 i로 나누었을 때 나머지가 0과 같다면
		 * 		i를 gcd에 저장
		 * 반복문 종료 후 : gcd가 1이면 disjoint를 출력하고,
		 *               아니면 Not disjoint를 출력
		 * 서로소 : 최대 공약수가 1인 두 수의 관계
		 * input 2 numbers : 3 4
		 * Disjoint!(서로소)
		 * input 2 numbers : 8 4
		 * Not disjoint!(서로소 아님)
		 * */
		
		int num1, num2, i = 1, gcd = 1; //gcd는 최소 공약수가 1이기 때문에 1로 초기값 설정
		Scanner sc = new Scanner(System.in);
		//두 정수를 입력
		System.out.println("input 2 numbers : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		//반복문(최대공약수를 구하기 위한) : i가 num1까지
		while(i <= num1) {
			//num1을 i로 나누었을 때 나머지가 0과 같고 num2를 i로 나누었을 때 나머지가 0과 같다면
			if(num1 % i == 0 && num2 % i == 0) {
				//i를 gcd에 저장
				gcd = i; // 오른쪽에 있는 i를 왼쪽에 있는 gcd에 저장한다는 의미
			}
			//i를 1증가
			i++;
		}
		//gcd가 1이면 disjoint를 출력하고,
		if(gcd == 1) {
		System.out.println("Disjoint!");
		//아니면 Not disjoint를 출력
		}else {
			System.out.println("Not disjoint!");
		}
		
		sc.close();
		
	}
}

//위의 while을
for( i = 1, gcd = 1 ; i <= num1 ; i++ ) {

	if(num1 % i == 0 && num2 % i == 0) {
			gcd =1; 로 써도 무관 
	}
	}