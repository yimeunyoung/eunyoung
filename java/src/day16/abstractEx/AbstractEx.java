package day16.abstractEx;

public class AbstractEx {

	public static void main(String[] args) {
		//추상 클래스를 이용하여 객체를 만들 수 없다.
		//A a = new A();
		/*구현되지 않은 추상메서드를 객체 생성후에 오버라이딩 해주면 가능. */
		//이 경우는 객체를 만드는데 하나의 객체만 만드는 경우에 사용함. 여러 개체를 만들때는 사용X
		A a = new A() {
			public void test() {
				System.out.println("class A Test.");
			}
		};
		a.test();
		A a2 = new A() {
			public void test() {
				System.out.println("class A Test.");
			}
		};
		a2.test();
		//ChildA1도 추상 클래스이기 때문에 ChildA1으로 객체를 생성할 수 없다.
		//ChildA1 ca1 = new ChildA1();
		/*추상 클래스를 상속받은 ChildA2는 일반 클래스 이기 때문에 객체를 생성할 수 있다. */
		//모든 기능이 구현되어 있다면 => 객체 생성 가능
		//모든 기능이 구현되어 있지 않다 => 추상 메서드가 있다 => 객체 생성이 불가능
		ChildA2 ca2 = new ChildA2();
		ca2.test();
		
		//다형성 : 하나의 객체에 여러 타입이 오는 것
		a = ca2; //업캐스팅에 의해 ca2객체를 a가 다룰 수 있다.
		a.test();
	
	}
	
}
/* 추상 클래스는 추상 메서드를 가지고 있음.
 * 추상 메서드가 있는 클래스에 abstract를 붙이지 않으면 에러 발생
 */
abstract class A{
	public abstract void test();
	//메서드에 final이 붙이면 메서드 오버라이딩이 불가
	public final void test2() { //final과 static이 함께 있을 때 순서는 상관없음 => final static / static final 
		System.out.println("Test2");
	}
}
/* 추상 클래스 상속 받는 방법1.
 * 추상클래스 A를 상속받은 자식 클래스는 추상 클래스로 만들어야 함*/
abstract class ChildA1 extends A{ // class 앞에 abstract 키워드 붙이기  
	/*final 메서드를 오버라이딩 할 수 없음.
	 *public void test2() {
		
	}
	*/
}

/* 추상 클래스 상속 받는 방법2. => 보통 2번째 방법을 많이 씀.=> 잘 기억해놓기!!!!!
 * 부모 클래스의 추상 메서드를 오버라이딩해서 재정의 해줌
 */
class ChildA2 extends A{

	@Override
	public void test() {
		System.out.println("테스트");
	}
	
}