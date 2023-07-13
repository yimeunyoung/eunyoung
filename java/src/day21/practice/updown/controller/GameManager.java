package day21.practice.updown.controller;

import java.util.ArrayList;
import java.util.Scanner;

import day21.practice.updown.vo.RecordGame;

public class GameManager implements Program {
	/* UpDown프로그램을 작성하고, 기록도 관리하는 기능을 추가하세요
	 * 1. play
	 * 2. record
	 * 3. exit
	 * select : 1
	 * ... //3번만에 맞춤
	 * record id : abc
	 * 1. play
	 * 2. record
	 * 3. exit
	 * select : 2
	 * 1. abc : 3
	 * */
	//리터럴 3에 이름을 붙여서 명확하게 전달하기 위해.
	private static final int EXIT = 3;
	
	//다른 메서드에서 매번 객체를 생성하는게 번거로워서
	private Scanner sc = new Scanner(System.in);

	//기록을 저장하는 리스트
	private ArrayList<RecordGame> list = new ArrayList<>();
	@Override
	public void printMenu() {

		System.out.println("1. Play");
		System.out.println("2. Record");
		System.out.println("3. EXIT");
		System.out.print("Select Menu : ");
		
	}

	@Override
	public void run() {
		System.out.println("Program Start!!");
		
		int menu;
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu);
			
		}while(menu != EXIT);
	}

	@Override
	public void runMenu(int menu) {
		switch (menu) {
		case 1:
			playGame();
			break;
		case 2:
			recordGame();
			break;
		case 3:break;
		default:
			System.out.println("Wrong menu!");
		}
		
	}

	private void recordGame() {
		for(RecordGame tmp : list) {
			System.out.println(tmp);
		}
		
	}

	private void playGame() {
		int min = 1, max = 100;
		int num = min - 1;//1~100이 아닌 정수로 초기화 하면 됨. 최소값 -1을 해서 랜덤으로 나올 수 없는 수
		int random;
		//랜덤한 수를 생성 (및 출력)
		random = (int)(Math.random()*(max - min + 1) + min);
		System.out.println(random);
		int count = 0;
		//반복문 : 맞출때까지 => 입력한 정수가 정답이 아니면 반복
		while(random != num) {
			//정수를 입력
			System.out.println("input(1~100) : ");
			num = sc.nextInt();
			
			//정수와 정답을 비교하여 판별
			//num가 random보다 크면 Down!,아니고 num가 random보다 작으면 Up!, 아니면 Good!
			if(num > random) {
				System.out.println("Down!");
			}else if(num < random) {
				System.out.println("Up!");
			}else {
				System.out.println("Good!");
			}
			count++;
		}
		//기록 : 아이디(입력), 플레이 횟수
		//아이디 입력
		
		
		if(list.size() == 5 &&  list.get(list.size()-1).getCount() <= count) {
			return;
		}
		if(list.size() == 5) {
			//마지막 기록을 삭제
			list.remove(list.size()-1);
		}
		System.out.print("Record ID : ");
		String id = sc.next();
		RecordGame rec = new RecordGame(id, count);
		list.add(rec);
		//sort();
		list.sort(null);
	}

}