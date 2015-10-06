package assign6;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * A JUnit test class for the MyLinkedList class.
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 10/8/2015
 */
public class MyLinkedListTester {
	
	MyLinkedList<Integer> intList;
	MyLinkedList<String> stringList;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		intList = new MyLinkedList<Integer>();
		stringList = new MyLinkedList<String>();
	}
	
	///////////   add(int index, E element)    ////////////
	@Test
	public void testAddWithValidInput() {
		intList.add(0, 5);
		intList.add(1, 5);
		intList.add(2, 5);
		intList.add(3, 5);
		intList.add(4, 5);
		intList.add(5, 5);
		intList.add(4, 5);
		intList.add(3, 5);
		intList.add(2, 5);
		intList.add(1, 5);
		intList.add(0, 5);
		
		// Exception should be thrown if the input index is < 0 or greater than the size of the LinkedList
		exception.expect(IndexOutOfBoundsException.class);
		intList.add(-1, 1234);
		
		exception.expect(IndexOutOfBoundsException.class);
		intList.add(3, 1234);
	}
	
	@Test
	public void testAddWithInvalidInput() {
		intList.addFirst(1);
		intList.addFirst(1);
		
		// Exception should be thrown if the input index is < 0 or greater than the size of the LinkedList
		exception.expect(IndexOutOfBoundsException.class);
		intList.add(-1, 1234);
		
		exception.expect(IndexOutOfBoundsException.class);
		intList.add(3, 1234);
	}
	
	////////////   indexOf(E element)  ///////////
	@Test
	public void testIndexOfWithEmptyList() {
		// Should return a -1 since the item being searched for does not exist in the list
		assertEquals(-1, intList.indexOf(1));
		assertEquals(-1, stringList.indexOf("Won't be found"));
	}
	
	@Test
	public void testIndexOfWithNonEmptyListNotFound() {
		// Should return a -1 since the item being searched for does not exist in the list
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		
		assertEquals(-1, intList.indexOf(123));
		assertEquals(-1, stringList.indexOf("Won't be found"));
	}
	
	@Test
	public void testIndexOfItem() {
		// Should return the index of the recurring item toward at the beginning(left) of the list
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		
		assertEquals(0, intList.indexOf(40));
		assertEquals(0, stringList.indexOf("Newest Item"));
	}
	
	////////////   lastIndexOf(E element)  ///////////
	@Test
	public void testLastIndexOfWithEmptyList() {
		// Should return a -1 since the item being searched for does not exist in the list
		assertEquals(-1, intList.lastIndexOf(1));
		assertEquals(-1, stringList.lastIndexOf("Won't be found"));
	}
	
	@Test
	public void testLastIndexOfWithNonEmptyListNotFound() {
		// Should return a -1 since the item being searched for does not exist in the list
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		
		assertEquals(-1, intList.lastIndexOf(400));
		assertEquals(-1, stringList.lastIndexOf("Won't be found"));
	}
	
	@Test
	public void testLastIndexOfItem() {
		// Should return the index of the recurring item toward at the end(right) of the list
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		
		assertEquals(4, intList.lastIndexOf(40));
		assertEquals(4, stringList.lastIndexOf("Newest Item"));
	}
	
	////////////    int size()   ////////////
	@Test
	public void testSizeWithEmptyList() {
		// An empty list should have a size of 0
		assertEquals(0, intList.size());
		assertEquals(0, stringList.size());
	}
	
	@Test
	public void testSizeWithNonEmptyList() {
		// A list with four elements should return 4
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		
		assertEquals(4, intList.size());
		assertEquals(4, stringList.size());
	}
	
	////////////// isEmpty   //////////////
	@Test
	public void testIsEmptyWithEmptyList() {
		// Should return true if the list is empty
		assertTrue(intList.isEmpty());
		assertTrue(stringList.isEmpty());
	}
	
	@Test
	public void testIsEmptyWithNonEmptyList() {
		// Should return false if the list is not empty
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		
		assertFalse(intList.isEmpty());
		assertFalse(stringList.isEmpty());
	}
	
	/////////////  clear()  //////////////
	@Test
	public void testClearWithNonEmptyList() {
		// Clearing the list should report a length of zero
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		
		assertEquals(4, intList.toArray().length);
		intList.clear();
		assertEquals(0, intList.toArray().length);
	}
	
	@Test
	public void testClearWithEmptyList() {
		// Clearing the list should report a length of zero
		intList.clear();
		assertEquals(0, intList.toArray().length);
	}
	
	///////////// toArray() //////////////
	@Test
	public void testToArrayWithNonEmptyLength() {
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		
		assertEquals(4, intList.toArray().length);
	}
	
	@Test
	public void testToArrayWithEmptyListLength() {
		assertEquals(0, intList.toArray().length);
	}
	
	@Test
	public void testToArrayOrderWithValidIntegerInput() {
		// The most recently added element should be the first element in the array
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		
		Object[] objArr = intList.toArray();
		
		assertEquals(40, objArr[0]);
		assertEquals(30, objArr[1]);
		assertEquals(20, objArr[2]);
		assertEquals(10, objArr[3]);
	}
	
	@Test
	public void testToArrayOrderWithValidStringInput() {
		// The most recently added element should be the first element in the array
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		Object[] objArr = stringList.toArray();
		
		assertEquals("Newest Item", objArr[0]);
		assertEquals("Second Newest Item", objArr[1]);
		assertEquals("Third Newest Item", objArr[2]);
		assertEquals("Fourth Newest Item", objArr[3]);
	}
}
