package day4.homework;

import java.util.Scanner;

public class ScoreAverageEx {

	public static void main(String[] args) {
		//국어, 영어, 수학 성적을 입력받아 평균을 출력하는 코드를 작성하세요.
		//성적은 정수.

		int kor, eng, math;
		double avg;
		Scanner sc = new Scanner(System.in);

        //국어, 영어, 수학 순으로 성적을 입력
		System.out.println("input score ( kor, eng, math) ex : 100 90 80 : ");
		kor = sc.nextInt();
		eng = sc.nextInt();
		math = sc.nextInt();
		
		//평균을 계산
		//3이 리터럴 이라서 3.0으로 변경 해도 무관, 리터럴이 아닐 경우에는 (double)3.0로 형변환도 가능.
		avg = (kor + eng + math) / 3.0;
		
		//평균을 출력
		System.out.println("avg : " + avg);
		
		sc.close();
	}

}
