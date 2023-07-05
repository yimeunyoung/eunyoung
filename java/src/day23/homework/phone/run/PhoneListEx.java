package day23.homework.phone.run;

import day23.homework.phone.controller.PhoneManager;

public class PhoneListEx {

	public static void main(String[] args) {
		/*전화번호부 예제에서 파일 입출력을 적용하여 전화번호부를 파일에 저장하고 읽어오는 코드를 작성하세요.
		참고 package : day22.practice.phone
		save() : 전화번호부에 있는 전화번호들을 파일에 저장하는 기능. 프로그램 종료 전에 호출
		load() : 파일에 있는 전화번호들을 읽어와서 전화번호부에 저장하는 기능. run() 실행 후 반복문 전에 호출
		 * */
		PhoneManager pm = new PhoneManager();
		pm.run();
	}

}
