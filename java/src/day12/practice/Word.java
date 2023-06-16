package day12.practice;

/* 한 단어를 관리하는 클래스
 *  - 단어
 *  - 뜻(여러개)
 *  */

public class Word {
	//멤버 변수
	private String title;
	private String meaning[];
	private int meaningCount; // 뜻이 저장되어 있는 개수
	//생성자
	public Word(String title, String meaning) {
		this.title = title;
		this.meaning = new String[5]; // 기본 5개
		this.meaning[0] = meaning; 
		meaningCount++;
	}
	//단어만 추가하고 뜻은 나중에 추가할 수 있도록 단어 생성자 따로 만듦
	public Word(String title) {
		this.title = title;
		this.meaning = new String[5]; // 뜻은 안넣더라도 배열은 만들어 두는 것이 좋음
	}
	public Word(Word w) {
		this.title = w.title;
		this.meaning = new String[5]; //기본 5개
		for(int i = 0 ; i < w.meaningCount; i++) {
			meaning[i] = w.meaning[i];
		}
		meaningCount = w.meaningCount;
	}
	
	//메서드
	/** 단어와 뜻을 출력하는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메서드명 : print
	 */
	public void print() {
		System.out.println("word : " + title);
		System.out.println("meaning : ");
		for(int i = 0; i < meaningCount ; i++) {
				System.out.println(i + 1 + ". " + meaning[i]);
			}
		}
	/** 뜻을 추가하는 메서드
	 * 매개변수 : 추가될 뜻 => String meaning
	 * 리턴타입 : 없음 => void
	 * 메서드명 : addMeaning
	 */
	public void addMeaning(String meaning) {
		//뜻이 다 찼으면 다 찼다고 출력하고 종료
		if(meaningCount == this.meaning.length) {
			System.out.println("");
			return;
		}
		this.meaning[meaningCount] = meaning;
		meaningCount++;
	}
	
	/** 뜻을 제거하는 메서드
	 * 매개변수 : 제거할 뜻의 번호 => int num 
	 * 리턴타입 : 없음 => void
	 * 메서드명 : removeMeaning
	 */
	public void removeMeaning(int num) {
		if(num > meaningCount || num < 1) {
			System.out.println("I can't work.");
			return;
		}
		//num-1번지 부터 하나씩 당겨와서 덮어쓰기함.
		for(int i = num-1 ; i<meaningCount -1 ; i++) {
			meaning[i] = meaning[i+1];
		}
		//마지막에 쓸모없는 데이터를 지움
		meaning[meaningCount-1] = null; // 해당 식은 써도 되고 안써도 됨
		//제거 됐으면 뜻 개수를 하나 줄임
		meaningCount--;
	}
	/* getter */
	public String getTitle() {
		return title;
	}
	
}
