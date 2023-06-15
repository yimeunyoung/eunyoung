package day12.practice;

public class VocabularyNoteEx {

	public static void main(String[] args) {
		// 영어 단어장을 만들기 위해 필요한 클래스를 만들고 테스트해보세요.
		Word word1 = new Word("vocabulary", "the words that make up a language");
		word1.print();
		word1.addMeaning("all of the wofds known and used by a person");
		word1.print();
		word1.removeMeaning(1);
		word1.print();
	}
}

