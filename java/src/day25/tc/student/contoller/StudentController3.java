package day25.tc.student.contoller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day25.tc.student.vo.Student;

public class StudentController3 {
	private List<Student> list = new ArrayList<Student>();
	private Scanner sc = new Scanner(System.in);

	public void run() {
			int menu;
			String fileName = "src/day25/tc.student/Student.txt";
			load(fileName);
			do {
			//메뉴 출력
			printMenu();
			//메뉴 선택 : 메뉴를 입력받음
			menu = sc.nextInt();
			//선택된 메뉴에 따른 기능 실행
			runMenu(menu);
		}while(menu != 3);
			save(fileName);
			sc.close();
	}
	
	private void load(String fileName) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
			while(true) {
				Student tmp = (Student)ois.readObject();
				list.add(tmp);
				}
			}catch(FileNotFoundException e) {
				System.out.println("불러올 파일이 없습니다.");
			}catch(EOFException e) {
				System.out.println("불러오기 완료.");
			}catch(IOException e) {
				e.printStackTrace();
			}catch(ClassNotFoundException e) {
				//ObjectInputStream을 이용하여 객체단위로 읽어올 때 클래스가 Serializable인터페이스를 구현하지 않으면 발생
				System.out.println("Student 클래스를 찾을 수 없습니다.");
			}
	}
	private void save(String fileName) { //자동 저장하려면 매개변수로 String fileName 추가
		//학생정보를 저장 => 리스트 => 하나씩 꺼내서 저장
		//저장 => OutputStream
		//객체단위로 저장 => ObjectOutputStream (day23 SerializableEx1 참고)
		try(FileOutputStream fos = new FileOutputStream("fileName"); //=> 상대경로와 절대경로 모두 가능
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				for(Student tmp : list) {
				oos.writeObject(tmp);
				}
		}catch(IOException e) {
			e.printStackTrace();
		}
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
	private void insertStudent() {
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
	private void print(){
		for(Student tmp2 : list) {
			System.out.println(tmp2);
		}
	}
}

