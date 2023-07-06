package day27.student.vo;

import java.util.Objects;

import lombok.Data;

@Data
public class Student { 
	private String num, name; // 학번, 이름
	
	public Student(String num, String name) {
		this.num = num;
		this.name = name;
	}
	//복사생성자
	public Student(Student tmp) {
		this(tmp.num, tmp.name);
	}
	
	@Override
	public String toString() {
		return num + " " + name;
	}
	
	//학번으로만 객체가 같은지 판별
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(num, other.num);
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
	
	
	
}
