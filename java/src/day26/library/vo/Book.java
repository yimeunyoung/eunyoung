package day26.library.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;
@Data
public class Book implements Serializable {
	 /* 도서
		 * -제목
		 * -저자
		 * -isbn
		 * -도서번호 
		 * */
	/**
	 * 
	 */
	private static final long serialVersionUID = -6424306556197258409L;
	
	private String num, title, author, isbn;
	private boolean rental; //대출 여부 관리
	
	
	
	public Book(String num, String title, String author, String isbn) {
		super();
		this.num = num;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {
		return "도서번호 : " + num + "\n" +
			   "도서제목 : " + title + "\n" +
			   "도서저자 : " + author + "\n" +
			   "ISBN : " + isbn;
		
	}

	public void rentalBook() {
		this.rental = true; // setRental(true);
	}
	public void returnBook() {
		this.rental = false; //setRental(false);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(num, other.num);
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
	
	
}
