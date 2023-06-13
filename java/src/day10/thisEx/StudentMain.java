package day10.thisEx;

public class StudentMain {

	public static void main(String[] args) {
		Student1.printCount();		
		
		Student1 std1 = new Student1(1,1,1,"hong");
		Student1.printCount();		
		
		Student1 std2 = new Student1(1,1,2,"lim");
		Student1.printCount();		
		
		//std2.studentCount = 1; // 이렇게 쓰는 것은 문법적으로는 실행 가능하지만 권장하지 않음(위의 방식대로 쓰는 것이 좋음)
		//System.out.println(Student1.studentCount); // = System.out.println(Std1.studentCount);
		std1.print();
		//student1.print(); // 에러발생. static이 print에는 안붙어서
		std2.print();
		System.out.println(std1);
		System.out.println(std2);
	} 
}
class Student1{
	private static int studentCount;
	private int grade, classNum, number;
	private String name;
	//아래 생성자는 매개변수가 있고, 매개변수의 이름이 멤버변수와 같기 때문에
	//멤버변수를 호출할 때 this를 반드시 붙여야 함
	public Student1(int grade, int classNum, int number, String name) {  //생성자 만들기 => 우클릭 -> source => generate constructor using field
		//this.grade = grade;
		//this.classNum = classNum;
		//this.number = number;
		//this.name = name;
		//studentCount++;  //객체를 생성할때마다 studentCount를 1씩 증가
	//기본 생성자 만들기 => 기본 생성자는 멤버 변수가 없기 때문에 this 를 안써도 됨(써도 되고 안써도 됨)
	}
	public Student1() {
		//멤버변수와 이름이 같은 지역 변수를 만들수도 있다(하지만 비추천)
		//int grade = 10;
		//this.grade = grade;
		this(1,1,1,"");
		name = ""; // this 생성자 앞에 코드가 오면 안됨(에러남). 따라서 해당 코드는 this 생성자 밑에 써야함
		/*this.grade = 1;
		grade = 1;  
		classNum = 1;
		number = 1;
		name = "";
		*/
	}
		public void print() {
			System.out.println("====================");
			System.out.println("grade   : " + grade);
			System.out.println("classNum   : " + classNum);
			System.out.println("number   : " + number);
			System.out.println("name   : " + name);
			//클래스 변수 사용 가능
			System.out.println("count    : " + studentCount);
			//클래스 메서드 사용 가능
			printCount();
		}
		public static void printCount() {
			//클래스 변수 사용 가능
			System.out.println("Registered student count : " + studentCount);
			//객체 변수 사용 불가능(직접)
			//grade = 1;
			//객체 매서드 사용 불가능(직접)
			//print();
			//객체를 생성 후 호출해서 사용 가능
			Student1 std1 = new Student1();
			std1.name = "hong";
			std1.print();
		}
	}
