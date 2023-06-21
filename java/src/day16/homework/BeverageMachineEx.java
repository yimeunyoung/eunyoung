package day16.homework;

import java.util.Scanner;

public class BeverageMachineEx {
		/* 음료수를 뽑는 자판기 프로그램을 작성하세요.
			단 음료수 자판기에 음료수는 사이다, 콜라, 환타가 고정이라고 가정.
			메뉴를 선택하면 음료수와 잔액이 나옴(출력).
			1.금액 투입
			2.메뉴 선택
			3.제품 입고
			4.프로그램 종료
			
			메뉴 선택 : 2
			사이다
			콜라
			환타
			음료 선택 : 1
			사이다를 선택했습니다.
			사이다가 나옵니다. [금액이 충분한 경우]
			잔돈 xxx가 나옵니다.
			금액이 부족합니다. [금액이 부족한 경우]
			잔돈 xxx이 나옵니다.
		 */
		private Scanner sc = new Scanner(System.in);
		
	
	public void run() {
		int menu = -1;
		do {
			//금액 투입
			System.out.println("금액을 투입해주세요");
			//메뉴 선택
			printMenu();
			//선택한 메뉴에 따른 기능을 실행
			
		}while(menu != 4);
	}
	
//1)
 private void printMenu() {
	 System.out.println("=================");
	 System.out.println("메뉴");
	 System.out.println("1. 금액 투입");
	 System.out.println("2. 메뉴 선택");
	 System.out.println("3. 제품 입고");
	 System.out.println("4. 프로그램 종료");
	 System.out.print("메뉴 선택 : ");
 }
 private void runMenu(int menu) {
	 System.out.println("================");
	 switch(menu) {
	 case 1:
		 input();
		 break;
	 case 2:
		 selectMenu();
		 break;
	 case 3:
		 store();
		 break;
	 case 4:
		 System.out.println("프로그램 종료!");
		 break;
	 default:
		 System.out.println("잘못된 메뉴!");
	 }
	 
 }

private void store() {
	// TODO Auto-generated method stub
	
}

private void selectMenu() {
	// TODO Auto-generated method stub
	
}

private void input() {
	// TODO Auto-generated method stub
	
}
}