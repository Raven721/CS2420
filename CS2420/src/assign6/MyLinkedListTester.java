package assign6;

import static org.junit.Assert.*;

import org.junit.After;
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

	@After
	public void tearDown() throws Exception {
	}
	
	////////////    int size()   ////////////
	@Test
	public void testSize() {
		intList.add(0, 1234);
		intList.addFirst(1);
		intList.addFirst(1);
				
		assertEquals(3, intList.size());
		
		intList.removeFirst();
		assertEquals(2, intList.size());
		
		intList.removeFirst();
		assertEquals(1, intList.size());
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
	
	/////////////  clear()  //////////////
	@Test
	public void testClearWithNonEmptyList() {
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
		intList.clear();
		assertEquals(0, intList.toArray().length);
	}
	
	///////////// toArray() //////////////
	@Test
	public void testToArrayWithNonEmpty() {
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		
		assertEquals(4, intList.toArray().length);
	}
	
	@Test
	public void testToArrayWithEmptyList() {
		assertEquals(0, intList.toArray().length);
	}
}
