package day25.tc.student.contoller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day25.tc.student.vo.Student;

public class StudentController3 {
	private List<Student> list = new ArrayList<Student>();
	private Scanner sc = new Scanner(System.in);
	
	public void run() {
			int menu;
			do {
			//메뉴 출력
			printMenu();
			//메뉴 선택 : 메뉴를 입력받음
			menu = sc.nextInt();
			//선택된 메뉴에 따른 기능 실행
			runMenu(menu);
		}while(menu != 3);	
			sc.close();
	}
	private void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생등록");
		System.out.println("2. 학생확인");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}
	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			//학생 전체를 확인
			print();
			break;
		case 3:
			System.out.println("종료!");
			break;
		default:
		}
	}
	public void insertStudent() {
		String num, name, major;
		Student tmp;
		//학번(문자열, 공백이 없는)
		System.out.println("학번 : ");
		num = sc.next();
		//이름(문자열, 공백이 있는)
		sc.nextLine();
		System.out.println("이름 : ");
		name = sc.nextLine();
		//과(문자열, 공백이 있는)
		System.out.println("전공 : ");
		major = sc.nextLine();
		//학생정보 리스트에 저장
		//입력한 정보를 이용하여 학생 객체를 생성
		tmp = new Student(num, name, major);
		//리스트에 학생 객체를 추가
		list.add(tmp);
		System.out.println(list);
	}
	public void print(){
		for(Student tmp2 : list) {
			System.out.println(tmp2);
		}
	}
}
