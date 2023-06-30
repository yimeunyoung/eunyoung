package day22.practice.phone.vo;

import java.util.Objects;
import java.util.regex.Pattern;

import lombok.Data;

//한 사람의 전화번호
@Data
public class PhoneNumber {
	private String name;
	private String number; // 010-1234-5678 // '-'가 들어가기때문에 String(문자열)로 정의

	//생성자 -> 이 코드에서는 아래의 메서드 먼저 만든 후 생성자 만들기(checkNumber 때문에)
	public PhoneNumber(String name, String number) {
		this.name = name;
		this.number = "";
		if(checkNumber(number)) {
			this.number = number;
		}
		this.number = checkNumber(number)?number:""; //위의 3줄을 1줄로 줄이면 이렇게 씀
	}
	
	
	//전화번호가 010-xxxx-xxxx 패턴이 맞는지 확인해주는 메서드
	//외부에서도 객체생성없이 쓸 수 있게 static과 public을 붙여줌
	public static boolean checkNumber(String num){
		String regex ="^010(-\\d{4}){2}$"; //https://regex101.com/ 에서 정규표현식 확인 후 붙여넣기
		return Pattern.matches(regex, num); // 문자열이 정규표현식에 맞는지 아닌지 확인
	}
	
	//전화번호를 새로 추가할 때 패턴에 맞는지 확인하기 위해 setter을 따로 만들어줌
	//원래는 이 코드가 @Data에 자동으로 생성되지만 저장하기 전에 체크 넘버를 해줘야함
	public void setNumber(String number) {
		this.number = checkNumber(number)?number:this.number; // 위에서 쓴 빈문자열"" 대신 this.number를 씀
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneNumber other = (PhoneNumber) obj;
		return Objects.equals(name, other.name);
	}


	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

}
