package day4.practice;

import java.util.Scanner;

public class IfSeasonEx {

	public static void main(String[] args) {
		/* 월을 입력받아 입력받은 월의 계절을 출력하세요.
		 * 3,4,5 : 봄 / 6,7,8 : 여름 / 9,10,11 : 가을 / 12,1,2 : 겨울
		 * 그 외 : 잘못된 월
		 * 월이 3이거나 월이 4이거나 월이 5이면 봄이라고 출력하고(월이 3이상이고 5이하이면)
		 * 월이 6이거나 월이 7이거나 월이 8이면 여름이라고 출력하고(월이 6이상이고 8이하이면)
		 * 월이 9이거나 월이 10이거나 월이 11이면 가을이라고 출력하고(월이 9이상이고 11이하이면)
		 * 월이 12이거나 월이 1이거나 월이 2이면 겨울이라고 출력하고(월이 12이거나 월이 1이상이고 2이하이면)
		 * 아니면 잘못된 월이라고 출력
		 */
		int month;
		Scanner sc = new Scanner(System.in);
		System.out.println("input month : ");
		month = sc.nextInt();
		
		//월이 3이거나 월이 4이거나 월이 5이면 봄이라고 출력하고
		//If뒤에 month == 3 || month == 4 || month == 5 로 작성해도 됨
		if(month >=3 && month <= 5) {
			System.out.println("Spring!");
		}
		//월이 6이거나 월이 7이거나 월이 8이면 여름이라고 출력하고
		else if(month >=6 && month <= 8) {
			System.out.println("Summer!");
		}
		//월이 9이거나 월이 10이거나 월이 11이면 가을이라고 출력하고
		else if(month >=9 && month <= 11) {
			System.out.println("fall!");
		}
		//월이 12이거나 월이 1이거나 월이 2이면 겨울이라고 출력하고
		//If뒤에 month ==12 || month >= 1 && month <= 2 로 작성해도 됨
		//단, 범위가 클 때 || 와 && 가 섞여 있을 경우 문제가 될 수 있다.
		//따라서, &&(먼저 해야하는) 부분을 괄호쳐준다. ex) month ==12 || (month >= 1 && month <= 2)
		else if(month == 12 || month == 1 || month == 2) {
			System.out.println("Winter!");
		}
		//아니면 잘못된 월이라고 출력
		else {
			System.out.println("Wrong month! ");
		}
		
		sc.close();
		
	}

}
