package day8.practice;

import java.util.Scanner;

public class MethodMultipleEx {

	public static void main(String[] args) {
		// 정수 num를 입력받아 2,3,6의 배수인지 아닌지 판별하는 코드를 작성하세요.
		//System.out.println(MethodEvenNumberEx.isMultiple(4,2)); => 아직 안배움
		
		int num1;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input number : ");
		num1 = sc.nextInt();
		
		if(isMultiple(num1, 6)) {
			System.out.println(num1 + " is a multiple of 6. ");
		}else if(isMultiple(num1, 2)) {
		System.out.println(num1 + " is a multiple of 2. ");
		}else if(isMultiple(num1, 3)) {
			System.out.println(num1 + " is a multiple of 3. ");
		}else {
			System.out.println(num1 + " is not a multiple of 2,3,6. ");
		}
		
		sc.close();
	}
	/** 정수 num를 입력받아 2,3,6의 배수인지 아닌지 판별
	 * 매개변수 : 판별할 정수 => int num
	 * 리턴타입 : 2,3,6의 배수인지(참) 아닌지(거짓) => boolean  
	 * 메서드명 : MethodMultiple
	 */
	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0;
	}
}
