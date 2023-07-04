package day25.quiz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Quiz {

	public static void main(String[] args) {
	ArrayList<Point> list = new ArrayList<>();
	list.add(new Point(1,2));
	//정수형 변수 x,y가 선언되지 않음
	int x =1, y = 2;
	list.add(new Point(x,y));
	list.add(new Point(3,4));
	}
}

class Point{
	int x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Test2{ 	
	public static void main(String[] args) {
	//List 인터페이스는 List 인터페이스를 구현한 구현 클래스 ArrayList의 객체를 관리할 수 있다.
	//List는 제네릭 클래스. 멤버의 타입이 정해지지 않고 객체를 생성할 때 정해지는 클래스
	//제네릭 클래스는 <>에 클래스명이 들어가야함. 기본 자료형X => 래퍼 클래스를 이용
	List<Integer> list = new ArrayList<>();
	list.add(1);
	list.add(2);
	}
}
class Test3 {
	public static void main(String[] args) {
	//HashSet은 List의 구현클래스가 아니기 때문에 HashSet의 객체를 List가 관리할 수 없다.
	//따라서, ArrayList 혹은 LinkedList로 변경해야함
	List<Integer> list = new ArrayList<>(); //List - HashSet은 구현관계가 아니다 Set - HashSet은 가능
	//3은 int.3이 자동으로 박싱되서 Integer의 객체로 저장
	list.add(3);
	list.add((int)4);
	//5를 박싱으로 Integer의 객체로 변환 후 저장
	list.add((Integer)5);
	}
}
class Test4 {
	public static void main(String[] args) {
	//num가 짝수인지 홀수인지 판별하는 예제
	int num = 3;
	
	if(num % 2 == 0)
		System.out.println("짝수");
	//else 옆에 ; 때문에 else문의 실행문이 없음. 홀수는 num값과 상관없이 출력
	//;을 제거
	else 
		System.out.println("홀수");
	}
}

class Test5 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		//Collection 인터페이스에 있는 메서드 : add, size
		//Collection 인터페이스에 자식으로 List와 Set 이 있음
		set.add(1);
		set.add(2);
		for(int i = 0; i<set.size(); i++) {
			//get은 List에 있는 메서드. set에는 없는 메서드
		//	System.out.println(set.get(i));
		}
		/*향상된 for문을 이용해야함
		for(Intget tmp : set) {
			System.out.println(tmp);
		}*/
	}
}
class Test6 {
	public static void main(String[] args) {
		//평균 예제
		int kor = 100, eng = 90, math = 34;
		//에러가 발생. 실수를 정수형 변수에 저장하려고 했기 때문에(자동으로 형변환 X)
		//int를 double로 변환
		double avg = (kor + eng + math)/3.0;
		System.out.println("평균 : " + avg);
	}
}
class Test7 {
	public static void main(String[] args) {
		System.out.println(sum(10,20));
		System.out.println(sum(10.4,12.2));
	}
	//메서드 오버로딩 : 메서드명이 같고 매개변수가 다를 때 가능
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	//이미 sum(정수,정수)가 있기 때문에 아래 메서드는 오버로딩 될 수 없음.
	public static double sum(double num1, double num2) {
		return num1 + num2;
	}
}
class Test8 {
	public static void main(String[] args) {
		int num = 3;
		System.out.println(num + "는 짝수인가? " + isEven(num));
	}
	//홀짝을 판별하는 메서드
	//메서드는 리턴타입이 있으면, 어떠한 상황에서라도 반드시 해당 타입으로 리턴을 해줘야 함.
	//아래 코드는 홀수일 때 리턴을 안하여 에러발생.
	public static boolean isEven(int num) {
		if(num % 2 == 0) {
			return true;
		}
		return false;
	}
}
class Test9 {
	public static void main(String[] args) {
		//0부터 차례대로 저장하는 예제
		//배열을 생성하지 않아서 저장할 수 없음.
		int [] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
	}
}
class Test10 {
	public static void main(String[] args) {
		PhoneNumber pn1 = new PhoneNumber("Hong", null);
		//기본생성자가 없어서 에러 발생. 생성자가 있기 때문에 기본 생성자가 자동으로 추가되지 X
		//따라서 아래에 기본 생성자를 만들거나 pn2에 생성자 기재하기
		PhoneNumber pn2 = new PhoneNumber();
	}
}

class PhoneNumber{
	private String name, number;
	
	//기본 생성자 만들기
	public PhoneNumber(){}
	
	public PhoneNumber(String name, String number) {
		this.name = name;
		this.number = number;
	}
	//toString 메서드는 Object 클래스에게서 상속을 받음
	/* public String toString(){
	 * 			return xxx;
	 * }
	 */
	@Override
	//오버라이드하려면 메서드 선언부가 같아야 함. 그런데 매개변수가 다름
	//해결방법1.@Override을 제거 -> 메서드 오버로딩이 되기 때문에
	//해결방법2.매개변수를 제거
	public String toString() {
		return "이름 : " + name + ",번호 : " + number;
	}
}

class Test11 {

	public static void main(String[] args) {
		TestProgram tp = new TestProgram();
		tp.print();
	}

}
interface Program{
	void run();
}
class TestProgram implements Program{
	
	int num;
	
	void print() {
		System.out.println(num);
	}
	//Program 인터페이스를 구현한 클래스이기 때문에 인터페이스에 있는 추상메서드를 반드시 오버라이딩 해야함
	@Override
	public void run() {
		
	}
}