package day21.homework;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import day21.practice.updown.controller.Program;
import day21.practice.updown.vo.RecordGame;

public class UpDown implements Program {
		/* UpDown 프로그램에서 기록을 최대 상위 5개까지 관리하도록 수정하세요.
	 * -게임 한 판 끝났을 때 기록이 상위 기록에 해당하면 아이디 입력 후 
	 * 기록하고, 상위 기록이 아니면 아이디를 입력하지 않음
	 */
	
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