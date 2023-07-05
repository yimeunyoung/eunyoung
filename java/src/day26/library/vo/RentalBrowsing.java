package day26.library.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

//대출 열람(도서대출 기록)
@Data
public class RentalBrowsing implements Serializable {
	/* 도서대출
	 * -도서
	 * -대출일
	 * -반납예정일
	 * -반납일
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1811304241338780528L;
	
	private Book book; //대출 도서
	private Date rentalDate;//대출일 //java.util.Date 추가
	private Date returnDate;//반납일 
	
	public RentalBrowsing(Book book, Date date, int rentalPeriod) {
		this.book = book;
		this.rentalDate = date;
	}
	public String getRentalDateStr() {
			SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
			return format.format(rentalDate);
	 }

	public void ReturnBrowsing(Book book, Date date) {
		this.book = book;
		this.returnDate = date;
	}
	public String getReturnDateStr() {
			SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
			return format.format(returnDate);
	 }

}
