package day3.homework;

import java.util.Scanner;

public class Ex3_if {

	public static void main(String[] args) {
		 /*Are you a women? man
		 * input gender : W
		 * Are you a women?  woman
		 * */
		char gender;
		Scanner sc = new Scanner(System.in);
		System.out.println("input gender : ");
		gender = sc.next().charAt(0);
		String result = "";
		//gender가 M과 같다
		if(gender == 'M') {
			//System.out.println("Are you a women?" + "man");
			result = "man";
		}
		//gender가 W와 같다
		if(gender == 'W') {
			//System.out.println("Are you a women?" + "women");
			result = "woman";
		}
		
		System.out.println("Are you a women?" + result);
		
		sc.close();
		
	}

}
