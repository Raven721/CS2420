package assign2;

/**
 * Class representation of a book. The ISBN, author, and title can never change
 * once the book is created.
 * 
 * Note that ISBNs are unique.
 * 
 * @author Erin Parker
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, JayM
 * @since 9/10/2015
 */
public class Book {

	private long isbn;

	private String author;

	private String title;

	public Book(long _isbn, String _author, String _title) {
		this.isbn = _isbn;
		this.author = _author;
		this.title = _title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * @return the ISBN
	 */
	public long getIsbn() {
		return this.isbn;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Two books are considered equal if they have the same ISBN, author, and
	 * title.
	 * 
	 * @param other
	 *            -- the object begin compared with "this"
	 * @return true if "other" is a Book and is equal to "this", false otherwise
	 */
	public boolean equals(Object other) {

		if (other instanceof Book && this.getIsbn() == ((Book) other).getIsbn()
				&& this.getAuthor() == ((Book) other).getAuthor() && this.getTitle() == ((Book) other).getTitle()) {

			return true;
		}

		return false;
	}

	/**
	 * Returns a string representation of the book.
	 */
	public String toString() {
		return isbn + ", " + author + ", \"" + title + "\"";
	}
}