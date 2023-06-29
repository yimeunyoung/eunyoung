package day22.lambda;

public class LambdaEx1 {

	public static void main(String[] args) {
		InterfaceA a = new InterfaceA() {//'InterfaceA'까지만 쓴 상태에서 ctrl + space 누르면 Override 자동생성
			
			@Override
			public int getMax(int num1, int num2) {
				return num1 >= num2 ? num1 : num2;
			}
		};
		System.out.println(a.getMax(10, 20));
		
		InterfaceA b = (num1, num2)->{ // 람다식을 이용하여 객체를 만드는 방법
			return num1 >= num2 ? num1 : num2;
		};
		System.out.println(b.getMax(10, 20 ));

		InterfaceA c = (num1, num2)-> num1 >= num2 ? num1 : num2;
		System.out.println(c.getMax(10, 20));
		}
}
	interface InterfaceA{
	int getMax(int num1, int num2);
	
}