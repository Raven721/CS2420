package assign2;

import java.util.GregorianCalendar;

public class LibraryBook extends Book {

	private String holder;
	private GregorianCalendar dueDate;

	public LibraryBook(long isbn, String author, String title) {
		super(isbn, author, title);
	}

	public String getHolder() {

		return this.holder;
	}

	public GregorianCalendar getDueDate() {

		return this.dueDate;
	}

	public void setDate(int day, int month, int year) {
		this.dueDate = new GregorianCalendar(year, month, day);
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public boolean checkIn() {
		if(this.holder != null) {
			this.setHolder(null);
			this.dueDate = null;
			
			return true;
		}
		return false;
	}

	public boolean checkOut(String holder, int day, int month, int year) {
		if(this.holder == null) {
			this.setHolder(holder);
			this.setDate(day, month, year);
			
			return true;
		}
		return false;
		
	}

}
