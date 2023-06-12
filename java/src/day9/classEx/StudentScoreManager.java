package day9.classEx;

import java.util.Scanner;

public class StudentScoreManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.close();
		//korScore를 인스턴스, 객체라고 표현
		//생성자는 매개변수를 조금 더 쉽게 초기화 시키는 역할을 함
		//Score1 korScore = new Score1(1,2,"korean Language");
		Score1 korScore = new Score1();
		korScore.title = "korean Language";
		korScore.grade = 1;
		korScore.semester = 2;
		Score1 engScore = new Score1(1,2,"English");
		System.out.println(engScore.title);
	}

}
//성적 클래스
class Score1{
	String title;//과목명
	int grade;//학년 
	int semester;//학기
	double total;//총점수
	double midExam;//중간고사
	double finalExam;//기말고사
	double performance;//수행평가
	//Score1 클래스의 기본 생성자 => 생성자가 없으면 이 기본생성자가 자동 생성됨
	public Score1() {
		/* title의 기본값은? null
		 * grade의 기본값은? 0
		 * total의 기본값은? 0.0
		 */
		title = ""; //빈문자열("")과 null은 다름
		grade = 1;
		semester = 1;
	}
	public Score1(int _grade, int _semester, String _title) {
		grade = _grade;
		semester = _semester;
		title = _title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getMidExam() {
		return midExam;
	}
	public void setMidExam(double midExam) {
		this.midExam = midExam;
	}
	public double getFinalExam() {
		return finalExam;
	}
	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}
	public double getPerformance() {
		return performance;
	}
	public void setPerformance(double performance) {
		this.performance = performance;
	}
	public Score1(String title, int grade, int semester, double total, double midExam, double finalExam,
			double performance) {
		this.title = title;
		this.grade = grade;
		this.semester = semester;
		this.total = total;
		this.midExam = midExam;
		this.finalExam = finalExam;
		this.performance = performance;
	}
	
}
//학생 클래스
class Student1{
	String name;//이름
	String residentNumber;//주민번호(0)
	int grade;//학년
	int classNum;//반
	int number;//번호
	int admissionYear;//입학년도
	Score1 korScore, engScore, mathScore;//국어, 영어, 수학 성적
	public Student1(String name, String residentNumber, int grade, int classNum, int number, int admissionYear,
			Score1 korScore, Score1 engScore, Score1 mathScore) {
	}

}