package assign2;

import java.util.GregorianCalendar;

/**
 * A generic library book is a book together with a holder 
 * (a representation of the person who has the book checked out) 
 * and a due date, both of which can change as needed. Holder can be represented by any type.
 * 
 * @author Erin Parker
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, JayM
 * @since 9/10/2015
 */
public class LibraryBookGeneric<Type> extends Book {

	private Type holder;
	private GregorianCalendar dueDate;

	/**
	 * Constructor
	 * 
	 * @param isbn
	 * @param author
	 * @param title
	 */
	public LibraryBookGeneric(long isbn, String author, String title) {
		super(isbn, author, title);
	}

	/**
	 * Returns Type name of person who has check out book
	 */
	public Type getHolder() {

		return this.holder;
	}

	/**
	 * Returns a due date for book represented by a Gregorian Calendar object
	 */
	public GregorianCalendar getDueDate() {

		return this.dueDate;
	}

	/**
	 * Sets the library book's due date to the specified due date
	 */
	public void setDueDate(GregorianCalendar dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * Sets the Type and ID of the book holder
	 */
	public void setHolder(Type holder) {
		this.holder = holder;
	}

	/**
	 * Checks in library book by setting the holder and due date to null, 
	 * returns true after book is checked in
	 * returns false if book is still checked out by holder
	 * 
	 */
	public boolean checkIn() {
		if(this.holder != null) {
			this.setHolder(null);
			this.setDueDate(null);
			
			return true;
		}
		return false;
	}

	/**
	 * Checks out a book by setting its holder and due date. 
	 * Returns true after the book is checked out, returns false otherwise.
	 * 
	 * @param holder
	 * @param day
	 * @param month
	 * @param year
	 */
	public boolean checkOut(Type holder, int day, int month, int year) {
		if(this.holder == null) {
			this.setHolder(holder);
			this.setDueDate(new GregorianCalendar(year, month, day));
			
			return true;
		}
		return false;
	}
}
