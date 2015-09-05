package assign2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

/**
 * Testing class for Library.
 * 
 * @author Erin Parker
 * 
 */
public class LibraryTester {

	// test an empty library
	Library lib = new Library();
	ArrayList<LibraryBook> booksCheckedOut = lib.lookup("Jane Doe");

	@Test
	public void testEmptyLibrary() {
		// lookup isbn
		assertNull(lib.lookup(978037429279L));

		// lookup holder
		assertNotNull(booksCheckedOut);
		assertEquals(0, booksCheckedOut.size());

		// empty library checkout
		assertFalse(lib.checkout(978037429279L, "Jane Doe", 1, 1, 2008));

		// empty library checkin(isbn)
		assertFalse(lib.checkin(978037429279L));

		// empty library checkin(holder)
		assertFalse(lib.checkin("Jane Doe"));
	}

	@Test
	public void testSmallLibrary() {
		// test a small library
		lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		lib.add(9780446580342L, "David Baldacci", "Simple Genius");

		// small library lookup isbn
		assertNull(lib.lookup(9780330351690L));

		// small library checkout
		assertTrue(lib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008));

		booksCheckedOut = lib.lookup("Jane Doe");
		// small library lookup holder
		assertNotNull(booksCheckedOut);
		assertTrue(booksCheckedOut.size() == 1);
		assertEquals(new Book(9780330351690L, "Jon Krakauer", "Into the Wild"), booksCheckedOut.get(0));
		assertEquals("Jane Doe", booksCheckedOut.get(0).getHolder());

		// small library checkin(isbn)
		assertTrue(lib.checkin(9780330351690L));

		// small library checkin(holder)
		assertFalse(lib.checkin("Jane Doe"));
	}

	@Test
	public void testMediumLibrary() {
		// test a medium library
		lib.addAll("Mushroom_Publishing.txt");

		// FILL IN
	}

	/**
	 * Returns a library of "dummy" books (random ISBN and placeholders for
	 * author and title).
	 * 
	 * Useful for collecting running times for operations on libraries of
	 * varying size.
	 * 
	 * @param size
	 *            -- size of the library to be generated
	 */
	public static ArrayList<LibraryBook> generateLibrary(int size) {
		ArrayList<LibraryBook> result = new ArrayList<LibraryBook>();

		for(int i = 0; i < size; i++) {
			// generate random ISBN
			Random randomNumGen = new Random();
			String isbn = "";
			for(int j = 0; j < 13; j++)
				isbn += randomNumGen.nextInt(10);

			result.add(new LibraryBook(Long.parseLong(isbn), "An author", "A title"));
		}

		return result;
	}

	/**
	 * Returns a randomly-generated ISBN (a long with 13 digits).
	 * 
	 * Useful for collecting running times for operations on libraries of
	 * varying size.
	 */
	public static long generateIsbn() {
		Random randomNumGen = new Random();

		String isbn = "";
		for(int j = 0; j < 13; j++)
			isbn += randomNumGen.nextInt(10);

		return Long.parseLong(isbn);
	}
}
