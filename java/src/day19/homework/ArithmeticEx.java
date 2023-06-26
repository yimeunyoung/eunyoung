package day19.homework;

import java.util.Scanner;

public class ArithmeticEx {

	public static void main(String[] args) {
		//산술 연산하는 메서드를 만들고 테스트하는 코드를 작성하세요. 단 예외처리 이용
		int num1, num2;
		char op;
		Scanner sc = new Scanner(System.in);
		System.out.print("input ex) 1 + 2 : ");
		
		num1 = sc.nextInt();
		op = sc.next().charAt(0);
		num2 = sc.nextInt();
		arithmetic(num1, num2, op);

	
	}

public static void arithmetic(int num1, double num2, char op) {
	switch(op) {
	case '+':
		System.out.println("" + num1 + op + num2 + " = " + (num1 + num2));
		break;
	case '-':
		System.out.println("" + num1 + op + num2 + " = " + (num1 - num2));
		break;
	case '*':
		System.out.println("" + num1 + op + num2 + " = " + (num1 * num2));
		break;
	case '/':
		System.out.println("" + num1 + op + num2 + " = " + (num1 / (double)num2));
		break;
	case '%':
		System.out.println("" + num1 + op + num2 + " = " + (num1 % num2));
		break;
	default:
		System.out.println("Not operator!");
		}
	}
}