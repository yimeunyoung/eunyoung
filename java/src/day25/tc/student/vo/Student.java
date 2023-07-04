package day25.tc.student.vo;

public class Student {
	private String num, name, major;
	
	public Student(String num, String name, String major) { // @AllArgsConstructor가 있으면 안만들어줘도 됨
		super();
		this.num = num;
		this.name = name;
		this.major = major;
	}

	// @Data가 있으면 안만들어도 됨

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "학번 : " + num + "\n이름 : " + name + "\n전공 : " + major;
	}
	
	
}
