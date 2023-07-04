package day25.student.controller;

import java.util.ArrayList;
import java.util.Scanner;

import day25.student.vo.StudentList;
import day25.tc.student.vo.Student;

public class StudentManager implements Program {
	private Scanner sc = new Scanner(System.in); 
	private final static int EXIT = 3;
	private ArrayList<StudentList> list = new ArrayList<StudentList>();
	
	@Override
	public void printMenu() {
		System.out.println("Menu");
		System.out.println("1.Insert");
		System.out.println("2.Search");
		System.out.println("3.EXIT");
		System.out.print("Select Menu: ");
	}

	@Override
	public void run() {
		int menu;
		do {
			System.out.println("==========");
			printMenu();
			menu = sc.nextInt();
			
			runMenu(menu);
			System.out.println("==========");
		}while(menu != EXIT);
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			search();
			break;
		case 3:
			System.out.println("EXIT");
			break;
		default:System.out.println("Wrong Menu!");
		}
	}

	private void search() {//학생확인
		System.out.print("number : ");
		String studentNum = sc.next();
		sc.nextLine();
		System.out.print("name : ");
		String name = sc.nextLine();
		System.out.print("major : ");
		String major = sc.nextLine();
		
		for(StudentList tmp : list) {
			if(tmp.equals(new StudentList(name, studentNum, major))) { 
				System.out.println(tmp);
			}
		}
	}

	private void insert() {//학생등록
		Student tmp;

		System.out.print("number : ");
		String studentNum = sc.next();
		sc.nextLine();
		System.out.print("name : ");
		String name = sc.nextLine();
		System.out.print("major : ");
		String major = sc.nextLine();
		
	}

}
