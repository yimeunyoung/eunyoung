package day17.interfaceEx;

public interface RunInterface {
	/*public final static //자동으로 붙음 */int NUM = 10;//클래스 상수 => 클래스를 이용하여 호출 //값을 꼭 입력해줘야하고, 대문자로 써야함
	/*public abstract*/ void run(); // 추상메서드이기 때문에 구현불가
	default void stop() {
		System.out.println("program stop!");
	}
}
