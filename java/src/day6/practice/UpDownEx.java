package day6.practice;

import java.util.Scanner;

public class UpDownEx {

	public static void main(String[] args) {
		/* UpDown 게임을 하는 코드를 작성하세요.
		 * 한판이 끝나면 더 할건지를 물어서 n을 입력하면 종료, y를 입력하면 이어서 게임이 진행.
		 
		 * 랜덤한 수 : 45
		 * input : 50
		 * Down!
		 * input : 40
		 * Up!
		 * input : 45
		 * game again? (y/n) :
		 */
		
	int min = 1, max = 100;
	char menu;
	int num, random;
	Scanner sc = new Scanner(System.in);
	/* 외부 반복문 : 게임을 더 진행할건지 결정하는 반복문
	 * 반복횟수 : 입력받은 문자가 n이 아니면 반복
	 * 규칙성 : Up Down 게임 한판 진행
	 * */
	do {
		//랜덤한 수 생성
		random = (int)(Math.random() * (max - min + 1) + min);
		System.out.println(random);
		/* 내부 반복문 : Up Dwon 게임 진행하는 반복문
		 * 반복횟수 : 입력받은 숫자가 랜덤한 숫자와 일치하지 않으면 반복
		 * 규칙성 : 입력받은 숫자가 정답보다 크면 Down!, 작으면 Up! 맞으면 Good!을 출력
		 * */
		do {
			//입력
			System.out.println("input : ");
			num = sc.nextInt();
			
			//판별한 후 결과 출력
			if(num > random) {
				System.out.println("Down!");
			}else if(num < random) {
				System.out.println("Up!");
			}else {
				System.out.println("Good!");
			}
		}while(random != num);
		//menu를 선택(더할건지 말건지)
		System.out.println("continue?(y/n) : ");
		menu = sc.next().charAt(0);
	}while(menu != 'n');
	
	sc.close();
	
	}

}
