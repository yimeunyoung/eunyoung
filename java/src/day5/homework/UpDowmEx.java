package day5.homework;

import java.util.Scanner;

public class UpDowmEx {

	public static void main(String[] args) {
		/* 1~100사이의 랜덤한 정수를 생성하고, 이 정수를 맞추는 게임을 구현하세요.
		 * 랜덤한 수 : 45
		 * input : 50
		 * Down!
		 * input : 40
		 * Up!
		 * input : 45
		 * Good!
		 */
		
	int min = 1, max = 100;
	int num = min - 1;//1~100이 아닌 정수로 초기화 하면됨. 최소값 -1을 해서 랜덤으로 나올 수 없는 수로 초기화
	//max를 먼저 5로 입력하고 랜덤 실행 시 5를 벗어나지 않는지 먼저 테스트 후 100으로 변경
	int random;
	Scanner sc = new Scanner(System.in);
	//랜덤한 수를 생성 (및 출력)
	random = (int)(Math.random() * (max - min + 1) + min);
	System.out.println(random);
	//반복문(맞출때까지) => 입력한 정수가 정답이 아니면 반복
	
	while(random != num) {
		//정수를 입력
		System.out.println("input(1~100) : ");
		num = sc.nextInt();
		//정수와 정답을 비교하여 판별
		//num가 random보다 크면 Down!, num가 random 보다 작으면 Up!, 아니면 Good!
		if(num > random) {
			System.out.println("Down!");
		}else if(num < random){
			System.out.println("Up!");
		}else{
			System.out.println("Good!");
				}
	}
	sc.close();

	}

}
