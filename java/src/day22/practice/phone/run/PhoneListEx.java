package day22.practice.phone.run;

import day22.practice.phone.controller.PhoneManager;
import day22.practice.phone.vo.PhoneBook;

public class PhoneListEx {

	public static void main(String[] args) {
		/* 전화번호를 관리하는 프로그램을 작성하세요. 
		 * 1. 전화번호 등록
		 * 2. 전화번호 수정
		 * 3. 전화번호 검색
		 * 4. 프로그램 종료
		 * */

		PhoneManager pm = new PhoneManager();
		pm.run();
		
		/*PhoneBook pb = new PhoneBook();
		System.out.println(pb.insertPhone("Hong", "010-1234-5678"));
		System.out.println(pb.insertPhone("Lim", "010-123-456"));
		pb.print(p->true);
		System.out.println(pb.updateName("Hong", "Hong gil"));
		pb.print(p->true);
		System.out.println(pb.updateNumber("Hong gil", "010-1111-5555"));
		pb.print(p->true);
		System.out.println(pb.update("Hong gil", "Lim", "010-1111-6666"));
		pb.print(p->true);
		System.out.println(pb.delete("Lim"));
		pb.print(p->true);
		*/
		
	}

}
