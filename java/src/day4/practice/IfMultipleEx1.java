package day4.practice;

import java.util.Scanner;

public class IfMultipleEx1 {

	public static void main(String[] args) {
		/* 정수 num를 입력받아 num가 2의 배수인지 아닌지 판별하는 코드를 작성하세요.
		 * */
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("input num : ");
		num = sc.nextInt();
		
		if(num % 2 == 0) {
			System.out.println("A multiple of 2");
		}
		else {
			System.out.println("Not multiples of 2");
		}
		sc.close();
		
	}

}
