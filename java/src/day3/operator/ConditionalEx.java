package day3.operator;

public class ConditionalEx {

	public static void main(String[] args) {
		//나이가 20살 이상이면 성인, 아니면 미성년자를 출력하는 코드를 작성하세요.
		int age = 30;
		String str;
		
		str = age >= 20 ? "adult" : "minor";
		//조건문으로 쓰면 4줄 나오는데 위와 같이 쓰면 1줄로 끝남
		System.out.println(age + " years old is a " + str);
		

	}

}
