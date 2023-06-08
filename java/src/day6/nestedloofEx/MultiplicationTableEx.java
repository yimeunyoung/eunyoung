package day6.nestedloofEx;

public class MultiplicationTableEx {

	public static void main(String[] args) {
		//구구단 2단부터 9단까지 출력하는 코드를 작성하세요.
		int i, j = 0; // 첫번째 for문에서 실행이 안될 경우에는 두 번째 for문에서 초기화가 안되기 때문에 j는 초기화 해야함.
		/* 외부 반복문
		 * 반복횟수 : i는 2부터 9까지 1씩 증가
		 * 규칙성 : i단이 출력
		 */
		for( i = 2 ; i <=9 ; i++ ) {
			//i단 출력
			/* 내부 반복문
			 * 반복횟수 : j는 1부터 9까지 1씩 증가
			 * 규칙성 : i x j = i*j를 출력
			 */
			for( j = 1 ; j <=9 ; j++ ) {
				System.out.println(i + " X " + j + " = " + i*j);
			}
		}
		//이 위치에서 i와 j의 값은 얼마? i : 10 , j : 10 // => 위의 식을 빠져나왔을 때의 값, i랑 j 모두 9까지일때 반복이 되므로 10이 될 경우에는 빠져나오게 됨
		System.out.println("i : " + i + ", j : " + j);
		
	}

}
