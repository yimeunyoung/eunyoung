package day15.practice.shop.vo;

import lombok.Data;

@Data
public class Customer {
	//멤버변수 
	private String customerId; //고객이 추가되면 자동으로 발급
	private String name;
	private String phoneNumber;
	
	//고객 아이디 발급을 위한 클래스 변수
	//등록된 고객수
	private static int count;// static을 붙일 경우, 객체를 새로 만들어도 초기화가 되는 것이 아님 => 즉 공유가 됨, 하나만 존재함 
							 // 없으면, 새로운 객체가 각각 생성되어 초기화 됨
	//고객 아이디 앞 부분
	private final static String CID = "CID"; // 고객 아이디 앞에 CID가 붙게 되어 예를들어, CID0000의 형태를 갖춤
	//고객 아이디 뒷 부분 숫자의 최대 길이
	private final static int MAX_SIZE = 5;
	
	//생성자
	public Customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		generateCustomerId(); //고객아이디 생성하는 메서드 만들기 -> customerId 발급 완료
	}

	private void generateCustomerId() {
		//1 => 00001 // 1을 최대 5자리까지 맞춰주는 작업
		//1 => "1" // 숫자를 문자열 1로 만들기
		String num = ""+ ++count; // 문자열 + 정수 => 문자열
		//"1".length == 1
		int length = num.length();
		for(int i = 0; i < MAX_SIZE - length; i++) {
			//A = A+B 일때 A+=B를 쓸 수 있다. 따라서 아래의 식은 해당식 적용 불가
			num = "0" + num;
		}
		customerId = CID+num;
	}
	public void print() {
		System.out.println("고객번호 : " + customerId);
		System.out.println("고객이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
	}


}
