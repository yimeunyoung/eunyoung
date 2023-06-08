package day7.breakEx;

public class HelloWorldEx {

	public static void main(String[] args) {
		//Hello World! 5번 출력
		//항상 break와 continue문에는 if 문이 따라올 수 밖에 없다
		int i = 1;
		while(true) {
			System.out.println("Hello World!");
			if(i == 5) {
				break;
			}
			i++;
		}
		
		
	}

}
