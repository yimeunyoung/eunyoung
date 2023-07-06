package day26.library.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

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
	private Date estimatedDate;//반납예정일
	
	
	public RentalBrowsing(Book book, Date date, int rentalPeriod) {
		this.book = book;
		this.rentalDate = date;
		//대출 기한을 이용하여 반납 예정일을 추가
		calculateReturnDate(rentalPeriod);
	}
	
	private void calculateReturnDate(int rentalPeriod) {
		if(rentalDate == null) {
			return;
		}
		Long rentalDateMs = rentalDate.getTime(); //대출일을 밀리초로 환산
		Long periodMs = rentalPeriod * 24 * 60 * 60 * 1000L;
		//new Date() : 현재 시간을 Date객체로 생성
		//new Date(long a) : 1970년 1월 1일 0시를 기준으로 a 밀리초만큼 흐른 날짜
		estimatedDate = new Date(rentalDateMs + periodMs);
	}

	public String getRentalDateStr() {
			SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
			return format.format(rentalDate);
	 }
	
	public String getReturnDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(returnDate);
	}
	public String getEstimatedDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(estimatedDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentalBrowsing other = (RentalBrowsing) obj;
		return Objects.equals(book, other.book);
	}

	@Override
	public int hashCode() {
		return Objects.hash(book);
	}



}
