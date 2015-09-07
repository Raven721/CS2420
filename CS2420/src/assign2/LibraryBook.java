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

	public void setDate(GregorianCalendar dueDate) {
		this.dueDate = dueDate;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public void checkedIn() {
		this.setHolder(null);
		this.setDate(null);
	}

	public void checkOut(String holder) {
		this.dueDate = new GregorianCalendar();
		this.dueDate.
		this.holder = holder;
	}

}
