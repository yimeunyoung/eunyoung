package day5.switchex;

public class Evenex {

	public static void main(String[] args) {
		// 홀짝 예제를 switch문으로
		int num = 4;
		//num를 2로 나눈 나머지 값을 활용
		switch(num % 2) {
		case 0:
			System.out.println(num + " is a even number. ");
			break;
		default:
			System.out.println(num + " is a odd number. ");
		}
		
		
	}

}
