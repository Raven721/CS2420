package assign2;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Testing class for LibraryGeneric.
 * 
 * @author Erin Parker and ??
 */
public class LibraryGenericTester {

	@Test
	public void testNameID() {
		// test a library that uses names (String) to id patrons
		LibraryGeneric<String> lib1 = new LibraryGeneric<String>();
		lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		lib1.add(9780446580342L, "David Baldacci", "Simple Genius");

		String patron1 = "Jane Doe";

		// first checkout
		assertTrue(lib1.checkout(9780330351690L, patron1, 1, 1, 2008));

		// second checkout
		assertTrue(lib1.checkout(9780374292799L, patron1, 1, 1, 2008));

		// lookup holder
		ArrayList<LibraryBookGeneric<String>> booksCheckedOut1 = lib1.lookup(patron1);
		assertNotNull(booksCheckedOut1);
		assertEquals(2, booksCheckedOut1.size());
		assertTrue(booksCheckedOut1.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild")));
		assertTrue(booksCheckedOut1.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat")));
		assertEquals(patron1, booksCheckedOut1.get(0).getHolder());
		assertEquals(new GregorianCalendar(2008, 1, 1), booksCheckedOut1.get(0).getDueDate());
		assertEquals(patron1, booksCheckedOut1.get(1).getHolder());
		assertEquals(new GregorianCalendar(2008, 1, 1), booksCheckedOut1.get(1).getDueDate());

		// checkin holder
		assertTrue(lib1.checkin(patron1));
	}

	@Test
	public void testPhoneNumberID() {
		// test a library that uses phone numbers (PhoneNumber) to id patrons
		LibraryGeneric<PhoneNumber> lib2 = new LibraryGeneric<PhoneNumber>();
		lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		lib2.add(9780446580342L, "David Baldacci", "Simple Genius");

		PhoneNumber patron2 = new PhoneNumber("801.555.1234");

		// first checkout
		assertTrue(lib2.checkout(9780330351690L, patron2, 1, 1, 2008));

		// second checkout
		assertTrue(lib2.checkout(9780374292799L, patron2, 1, 1, 2008));

		ArrayList<LibraryBookGeneric<PhoneNumber>
		> booksCheckedOut2 = lib2.lookup(patron2);
		// lookup holder
		assertNotNull(booksCheckedOut2 == null);
		assertEquals(2, booksCheckedOut2.size());
		assertTrue(booksCheckedOut2.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild")));
		assertTrue(booksCheckedOut2.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat")));
		assertEquals(patron2, booksCheckedOut2.get(0).getHolder());
		assertEquals(new GregorianCalendar(2008, 1, 1), booksCheckedOut2.get(0).getDueDate());
		assertEquals(patron2, booksCheckedOut2.get(1).getHolder());
		assertEquals(new GregorianCalendar(2008, 1, 1), booksCheckedOut2.get(1).getDueDate());

		// checkin holder
		assertTrue(lib2.checkin(patron2));

	}
}
