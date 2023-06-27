package day20.homework.controller;

import java.util.Scanner;

import day17.interfaceEx.RunInterface;
import day20.homework.vo.VocabularyNote;

public class VocabularyNoteController implements RunInterface {
	
	private Scanner sc = new Scanner(System.in); // Scanner를 Controller의 멤버로 둠
	private VocabularyNote note = new VocabularyNote();
	
	public void run() {
		//반복(종료를 선택하기전까지)
		int menu;
		do {
			//메뉴 출력 => 메서드로 구현 1)
			printMenu();
			
			//메뉴 선택
			menu = sc.nextInt();
			
			//메뉴에 따른 기능 실행 메서드로 구현 2)
			runMenu(menu);
		} while(menu != 5);//선택한 메뉴가 5가 아닐때 반복
	
	
	sc.close();
	
	}
	//1)
	/**메뉴를 출력하는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printMenu
	 */
	private void printMenu() { // run에서 부르기 위한 메서드이기 때문에 private으로 씀
		System.out.println("메뉴");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 삭제");
		System.out.println("3. 단어 수정");
		System.out.println("4. 단어 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	//2)
	/**메뉴에 따른 기능을 실행하는 메서드
	 * 매개변수 : 메뉴 => int menu
	 * 리턴타입 : 없음 => void
	 * 메서드명 : runMenu
	 */
	private void runMenu(int menu) {
		switch(menu) {
		//메뉴가 1이면 단어 추가 기능을 실행
		case 1:
			System.out.println("==============");
			insertWord(); // 3번 메서드
			System.out.println("==============");
			break;
		//메뉴가 2이면 단어 삭제 기능을 실행
		case 2:
			System.out.println("==============");
			deleteWord();	// 6번 메서드		
			System.out.println("==============");
			break;
		//메뉴가 3이면 단어 수정 기능을 실행
		case 3:
			System.out.println("==============");
			updateWord(); // 7번 메서드
			System.out.println("==============");
			break;
		//메뉴가 4이면 단어 출력 기능을 실행
		case 4:
			System.out.println("==============");
			printWord(); //4번 메서드
			System.out.println("==============");
			break;
		//메뉴가 5이면 프로그램을 종료
		case 5:
			System.out.println("==============");
			System.out.println("프로그램 종료!");
			System.out.println("==============");
			break;
		//메뉴가 그 외이면 잘못된 메뉴라고 출력
		default:
			System.out.println("==============");
			System.out.println("잘못된 메뉴 선택!");
			System.out.println("==============");
		}

	}
	//3)
	private void insertWord() {
		//추가할 단어를 입력
		System.out.print("단어 : ");
		String title = sc.next();
		
		//단어에서 입력한 엔터를 처리
		sc.nextLine();
		
		//추가할 뜻을 입력
		System.out.print("뜻 : ");
		String meaning = sc.nextLine(); //nextLine은 알아서 다음줄로 넘어감
		
		//단어장에 추가 // day13.homework.vo VocabularyNote 메서드 3 수정함
		int result = note.insert(title, meaning);
		
		switch(result) {
		case 1: System.out.println("단어 추가 성공!"); break;
		case -1: System.out.println("의미 추가 성공!"); break;
		case 0: System.out.println("단어 추가 실패!"); break;
		}
	}
	
	//4)
	private void printWord() {
		//서브메뉴 출력
		printSubMenuPrint(); // 5번 메서드
		//서브메뉴 선택
		int submenu = sc.nextInt();
		switch(submenu) {
		//서브메뉴가 1이면 전체 출력
		case 1:
			note.print();
			break;
		//서브메뉴가 2이면 검색
		case 2:
			//검색할 단어
			System.out.print("검색 단어 : ");
			String title = sc.next();
			//출력
			note.search(title);
			break;
		}
	}
	//5)
	private void printSubMenuPrint() {
		System.out.println("==============");
		System.out.println("서브메뉴");
		System.out.println("1. 전체 출력");
		System.out.println("2. 단어 검색");
		System.out.print("서브 메뉴 선택 : ");
	}
	//6)
	private void deleteWord() { // vocabularyNote에 delete 메서드 수정
		//삭제할 단어 입력
		System.out.println("삭제 단어 : ");
		String title = sc.next(); //단어니까 next
		
		//해당 단어 삭제
		if(note.delete(title)) {
			System.out.println("단어 삭제 완료!");
		}else {
			System.out.println("단어 삭제 실패!");
		}
	}
	
	//7)
	private void updateWord() {
		//서브메뉴 출력
		printSubMenuUpdate(); // 메서드 8)
		//서브메뉴 입력
		int submenu = sc.nextInt();
		//서브메뉴에 따른 기능 실행
		switch(submenu) {
		//단어 수정
		case 1:
			//수정할 단어
			System.out.print("수정할 단어 : ");
			String word = sc.next();
			//수정될 단어
			System.out.print("수정될 단어 : ");
			String updateWord = sc.next();
			//단어장에 있는 단어 수정기능을 실행
			if(note.updateTitle(word, updateWord)){
				System.out.println("단어 수정 성공!");
			}else {
				System.out.println("단어 수정 실패!");
			}
				break;
		//뜻 수정
		case 2:
			//뜻을 수정할 단어를 입력
			System.out.print("단어 : ");
			String title = sc.next();
			//단어를 출력하고, 단어가 없으면 안내문구 출력 후 종료
			if(!note.search(title)) { // voca.note의 search 메서드
			System.out.println("없는 단어입니다.");
			return;
			}
			//수정할 뜻의 번호를 입력
			System.out.print("수정할 뜻 번호 선택 : ");
			int num = sc.nextInt();
			
			sc.nextLine(); //엔터 처리
			//수정될 뜻을 입력
			System.out.print("수정할 뜻 : ");
			String meaning = sc.nextLine();
			//단어장에서 수정
			if(!note.updateMeaning(title, num, meaning)) { // voca.note의 updateMeaning 메서드
				System.out.println("뜻 수정 실패!");
			}else {
				System.out.println("뜻 수정 성공!");
			}
			break;
		//뜻 삭제
		case 3:
			//뜻을 삭제할 단어를 입력
			System.out.print("단어 : ");
			String title2 = sc.next();
			//단어를 출력하고, 단어가 없으면 안내문구 출력 후 종료
			if(!note.search(title2)) { 
			System.out.println("없는 단어입니다.");
			return;
			}
			//삭제할 뜻의 번호를 입력
			System.out.print("삭제할 뜻 번호 선택 : ");
			int num2 = sc.nextInt();
			if(!note.deleteMeaning(title2, num2)){ // voca.note의 deleteMeaning 메서드
				System.out.println("뜻 삭제 실패!");
			}else {
				System.out.println("뜻 삭제 성공!");
			}
			break;
		}
	}
	
	//8)
	private void printSubMenuUpdate() {
		System.out.println("서브메뉴");
		System.out.println("1. 단어 수정");
		System.out.println("2. 뜻 수정");
		System.out.println("3. 뜻 삭제");
		System.out.print("서브 메뉴 선택 : ");
		}
}
