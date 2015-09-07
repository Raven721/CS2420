package assign2;

import java.util.GregorianCalendar;

public class LibraryBook extends Book {
	
	public LibraryBook(long isbn, String author, String title) {
		super(isbn, author, title);
	}
	
	public String getHolder() {
		return null;
	}
	
	public GregorianCalendar getDueDate() {
		return null;
	}
	
	public Boolean checkedIn() {
		return null;
	}
	
	public Boolean checkedOut() {
		return null;
	}

}
