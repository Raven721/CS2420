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
	
	////////////    int size()   //////////////
	@Test
	public void testSize() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();

		list.addFirst(1);
		list.addFirst(1);
				
		assertEquals(2, list.size());
		
		list.removeFirst();
		assertEquals(1, list.size());
		
		list.removeFirst();
		assertEquals(0, list.size());
	}
	
	/////////// test exceptions ///////////////
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
