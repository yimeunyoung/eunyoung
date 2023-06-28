package day21.practice;

public class MethodEx {

	public static void main(String[] args) {
	System.out.println(sum(1));
	System.out.println(sum(1,2));
	System.out.println(sum(1,2,3,4,5));
	}
	
	/* 여러개의 정수의 합을 알려주는 메서드 */
	public static int sum(int ... nums) {//매개변수에 double num을 추가할 때 가변 매개변수 앞에 써야함 => 가변 매개변수는 맨 끝에 사용해야 에러 안남
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum;
	}
}
