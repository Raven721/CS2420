package assign2;

import java.util.GregorianCalendar;

public class LibraryBookGeneric<Type> extends Book {

	private Type holder;
	private GregorianCalendar dueDate;

	public LibraryBookGeneric(long isbn, String author, String title) {
		super(isbn, author, title);
	}

	public Type getHolder() {

		return this.holder;
	}

	public GregorianCalendar getDueDate() {

		return this.dueDate;
	}

	public void setDueDate(GregorianCalendar dueDate) {
		this.dueDate = dueDate;
	}

	public void setHolder(Type holder) {
		this.holder = holder;
	}

	public boolean checkIn() {
		if(this.holder != null) {
			this.setHolder(null);
			this.setDueDate(null);
			
			return true;
		}
		return false;
	}

	public boolean checkOut(Type holder, int day, int month, int year) {
		if(this.holder == null) {
			this.setHolder(holder);
			this.setDueDate(new GregorianCalendar(day, month, year));
			
			return true;
		}
		return false;
		
	}

}
