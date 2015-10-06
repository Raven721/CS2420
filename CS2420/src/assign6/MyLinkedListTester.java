package assign6;

import static org.junit.Assert.*;

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

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	////////////    int size()   ////////////
	@Test
	public void testSize() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();

		list.add(0, 1234);
		list.addFirst(1);
		list.addFirst(1);
				
		assertEquals(3, list.size());
		
		list.removeFirst();
		assertEquals(2, list.size());
		
		list.removeFirst();
		assertEquals(1, list.size());
	}
	
	///////////   add(int index, E element)    ////////////
	@Test
	public void testAddWithValidInput() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.add(0, 5);
		list.add(1, 5);
		list.add(2, 5);
		list.add(3, 5);
		list.add(4, 5);
		list.add(5, 5);
		list.add(4, 5);
		list.add(3, 5);
		list.add(2, 5);
		list.add(1, 5);
		list.add(0, 5);
		
		// Exception should be thrown if the input index is < 0 or greater than the size of the LinkedList
		exception.expect(IndexOutOfBoundsException.class);
		list.add(-1, 1234);
		
		exception.expect(IndexOutOfBoundsException.class);
		list.add(3, 1234);
	}
	
	@Test
	public void testAddWithInvalidInput() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.addFirst(1);
		list.addFirst(1);
		
		// Exception should be thrown if the input index is < 0 or greater than the size of the LinkedList
		exception.expect(IndexOutOfBoundsException.class);
		list.add(-1, 1234);
		
		exception.expect(IndexOutOfBoundsException.class);
		list.add(3, 1234);
	}
}
