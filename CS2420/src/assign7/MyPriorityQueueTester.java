package assign7;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit Tests for the MyPriorityQueue class
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 10/22/2015
 */
public class MyPriorityQueueTester {

	@Test
	public void testMyPriorityQueueInteger() {
		MyPriorityQueue<Integer> queue = new MyPriorityQueue<Integer>();
		
		queue.insert(15);
		queue.insert(45);
		queue.insert(85);
		queue.insert(790);
		queue.insert(123);
		queue.insert(4);
		queue.insert(42);

		assertEquals((Integer)4, queue.findMin());
	}
	
	@Test
	public void testMyPriorityQueueString() {
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>();
		
		queue.insert("gggg");
		queue.insert("cccc");
		queue.insert("aaaa");
		queue.insert("ffff");
		queue.insert("bbbb");
		queue.insert("dddd");
		queue.insert("eeee");

		assertEquals("aaaa", queue.findMin());
	}
	
	@Test
	public void testMyPriorityQueueChar() {
		MyPriorityQueue<Character> queue = new MyPriorityQueue<Character>();
		
		queue.insert('g');
		queue.insert('a');
		queue.insert('c');
		queue.insert('b');
		queue.insert('e');
		queue.insert('d');
		queue.insert('f');

		assertEquals((Character)'a', queue.findMin());
	}
}
