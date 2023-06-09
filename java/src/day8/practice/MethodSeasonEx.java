package day8.practice;

import java.util.Scanner;

public class MethodSeasonEx {

	public static void main(String[] args) {
		/* 월을 입력받아 계절을 출력하는 코드를 작성하세요.
		 * 단 메서드 이용
		 * Spring : 3, 4, 5
		 * Summer : 6, 7, 8
		 * Fall : 9, 10, 11
		 * Winter : 1, 2, 12
		 * Wrong Month : 그 외
		 */
		
		int month;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input month : ");
		month = sc.nextInt();
		
		//첫 번째 방법
		String season = getSeason(month);
		System.out.println(month + " is " + season);

		//두 번째 방법
		System.out.println(month + " is " + getSeason(month));
		//=> 둘 중 1개 방법으로 써도 됨
		
		
		Season(month);
		
		sc.close();
		
	}
	/**월이 주어지면 주어진 월에 맞는 계절을 알려주는 메서드
	 * 매개변수 : 월 => int month
	 * 리턴타입 : 계절 => String
	 * 메서드명 : getSeason
	 */
	public static String getSeason(int month) {
		if(month == 3 || month == 4 || month == 5) {
			return("Spring!");
		}
		//month가 6이거나 7이거나 8이면 Summer 출력
		else if(month == 6 || month == 7 || month == 8) {
			return("Summer!");
		}
		//month가 9이거나 10이거나 11이면 Fall 출력
		else if(month == 9 || month == 10 || month == 11) {
			return("Fall!");
		}
		//month가 1이거나 2이거나 12이면 Winter 출력
		else if(month == 1 || month == 2 || month == 12) {
			return("Winter!");
		}
		//아니면 Wrong month 출력
		else {
			return("Wrong month!");
		}
	}
	
	
	//void로 하면 sysout으로 써도 되고 위와 같이 string으로 쓰면 return으로 기재해야함
	public static void Season(int num1) {
		switch(num1){
		case 3: case 4: case 5:
			System.out.println("Spring!");
			break;
		case 6: case 7: case 8:
			System.out.println("Summer!");
			break;		
		case 9: case 10: case 11:
			System.out.println("Fall!");
			break;
		case 1: case 2: case 12:
			System.out.println("Winter!");
			break;	
			default:
			System.out.println("Wrong month!");
		}
	}
	
}
