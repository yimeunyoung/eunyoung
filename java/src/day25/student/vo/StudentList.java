package day25.student.vo;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentList {
	//학번, 학과, 이름
	private String studentNum;
	private String major;
	private String name;
	
	
	@Override
	public String toString() {
		return "StudentList [studentNum=" + studentNum + ", major=" + major + ", name=" + name + "]";
	}
	
	

	

}
