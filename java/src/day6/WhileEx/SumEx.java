package day6.WhileEx;

public class SumEx {

	public static void main(String[] args) {
	/* 1부터 n까지 합을 구하는 코드를 작성하세요.(n은 10)
	 * 반복횟수 : i는 1부터 n까지 1씩 증가
	 * 규칙성 : sum += i 
	 * 반복문 종료 후 : 누적합인 sum을 출력 
	 * sum0 = 0
	 * i = 1 일때 sum1 = sum0 + 1
	 * i = 2 일때 sum2 = sum1 + 2
	 * i = 3 일때 sum3 = sum2 + 3
	 * ...
	 * i = 10 일때 sum10 = sum9 + 10
	 * i = n   sum = sum + i => sum += i(외워두는게 좋음)
	 */
		
	int n = 10, sum = 0; //이 식에서 sum은 반드시 0으로 초기화
	int i = 1;  // i는 1부터
	while(i <= n) {//i는 n까지
		sum += i;
		i++; //1씩 증가
	}
		System.out.println("1~" + n + " sum : " + sum);
	}

}
