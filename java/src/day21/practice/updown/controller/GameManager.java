package day21.practice.updown.controller;

import java.util.ArrayList;
import java.util.Comparator;
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
	private final static int EXIT = 3;
	
	//다른 메서드에서 매번 객체를 생성하는게 번거로워서 멤버로 가지고 있음
	private Scanner sc = new Scanner(System.in);
	
	//기록을 저장하는 리스트
	private ArrayList<RecordGame> list = new ArrayList<>();
	
	@Override
	public void printMenu() {
		System.out.println("1. play");
		System.out.println("2. record");
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
		switch(menu) {
		case 1:
			playGame();
			break;
		case 2: 
			recordGame();
			break;
		case 3: break;
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
		int num = min - 1;
		int random;
		Scanner sc = new Scanner(System.in);
		
		random = (int)(Math.random() * (max - min + 1) + min);
		System.out.println(random);
		int count = 0;
		while(random != num) {
			System.out.println("input(1~100) : ");
			num = sc.nextInt();
			if(num > random) {
				System.out.println("Down!");
			}else if(num < random){
				System.out.println("Up!");
			}else{
				System.out.println("Good!");
			}
			count++; //플레이 횟수
		}
		//기록 : 아이디(입력), 플레이 횟수
		//아이디 입력
		System.out.println("Record ID : ");
		String id = sc.next();
		//어떻게 저장해서 관리할 건가?
		RecordGame rec = new RecordGame(id, count);
		list.add(rec); //리스트에 추가
		//sort(); //정렬
		list.sort(new Comparator<RecordGame>() {

			@Override
			public int compare(RecordGame o1, RecordGame o2) {
				return o1.getCount() - o2.getCount();
			}
			
		});
	}
	
	private void sort() { // 버블정렬 이용
		for(int i = 0; i<list.size()-1; i++) {
			for(int j = 0; j<list.size()-1; j++) {
				if(list.get(j).getCount() > list.get(j+1).getCount()) {//record 게임 안에 있는 횟수를 비교
					RecordGame tmp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, tmp);
				}
			}
		}
	}
}
