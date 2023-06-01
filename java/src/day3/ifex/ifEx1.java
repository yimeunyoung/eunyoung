package day3.ifex;

public class ifEx1 {

	public static void main(String[] args) {
		//정수 num가 0이면 0입니다라고 출력하는 코드를 작성하세요.
		//'정수 num가 0이다' 를 풀어쓰면 '정수 num가 0과 같다'
		int num = 10;
		if(num == 0) {
			//0입니다라고 출력;
			System.out.println("0 is 0");
			//조건문은 참일 때 동작한다
			
		}
		//정수 num가 0이 아니면 num is not 0라고 출력하는 코드를 작성하세요.
		//num가 0이 아니다
		//num가 0과 같지 않다
		//if(num가 0이 아니다) { 는 아래와 같이 변경 가능
		if(num != 0) {
			System.out.println(num + " is not 0 " );
		}

	}

}
