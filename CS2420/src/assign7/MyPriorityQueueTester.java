package assign7;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit Tests for the MyPriorityQueue class
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 10/22/2015
 */
public class MyPriorityQueueTester {

	MyPriorityQueue<Integer> queue;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		queue = new MyPriorityQueue<Integer>();
	}
	
	///////// E findMin() /////////
	@Test
	public void testFindMinWithEmptyQueue() {
		// findMin() should throw an exception if the queue is empty
		assertTrue(queue.isEmpty());
		
		exception.expect(NoSuchElementException.class);
		queue.findMin();
	}
	
	@Test
	public void testFindMinWithPopulatedQueue() {
		// findMin() should return the minimum item of the queue if it is not empty
		assertTrue(queue.isEmpty());
		
		queue.insert(45);
		queue.insert(6);
		queue.insert(3);
		queue.insert(8);
		
		assertEquals((Integer)3, queue.findMin());
	}
	
	
	///////// void insert(E item) /////////
	@Test
	public void testInsertWithEmptyQueue() {
		// insert(E item) should add item to the queue
		assertTrue(queue.isEmpty());
		
		queue.insert(45);
		queue.insert(6);
		queue.insert(3);
		queue.insert(8);
		
		assertEquals(4, queue.size());
	}
	
	@Test
	public void testInsertWithPopulatedQueue() {
		// insert(E item) should add items to the queue
		assertTrue(queue.isEmpty());
		
		queue.insert(45);
		assertEquals((Integer)45, queue.findMin()); 
		queue.insert(6);
		assertEquals((Integer)6, queue.findMin()); 
		queue.insert(3);
		assertEquals((Integer)3, queue.findMin()); 
		queue.insert(1);
		assertEquals((Integer)1, queue.findMin()); 
		
		assertEquals(4, queue.size());
	}
	
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
		// Insert should also work with String
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
		// Insert should also work with char
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
	
	///////// int size() /////////
	@Test
	public void testSizeWithEmptyQueue() {
		// size() should return zero if the queue is empty
		assertTrue(queue.isEmpty());
		assertEquals(0, queue.size());

	}
	
	@Test
	public void testSizeWithPopulatedQueue() {
		// the value returned by size should increment by one, each time a new item is added to the queue
		assertTrue(queue.isEmpty());
		
		queue.insert(45);
		assertEquals(1, queue.size());
		
		queue.insert(6);
		assertEquals(2, queue.size());
		
		queue.insert(3);
		assertEquals(3, queue.size());
		
		queue.insert(8);
		assertEquals(4, queue.size());
	}
	
	///////// boolean isEmpty() /////////
	@Test
	public void testIsEmptyWithEmptyQueue() {
		// isEmpty should return true if the queue contains zero items
		assertEquals(0, queue.size());
		
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void testIsEmptyWithPopulatedQueue() {
		// isEmpty should return false if the queue contains at least one item
		queue.insert(1);
		assertEquals(1, queue.size());
		
		assertFalse(queue.isEmpty());
	}
	
	///////// void clear() /////////
	@Test
	public void testClearWithEmptyQueue() {
		// clear() has no measurable effect on an empty queue
		assertEquals(0, queue.size());
		
		queue.clear();
		
		assertEquals(0, queue.size());
	}
	
	@Test
	public void testClearWithPopulatedQueue() {
		// clear() should clear all items from the queue if it isn't empty
		assertTrue(queue.isEmpty());
		
		queue.insert(15);
		queue.insert(45);
		queue.insert(85);
		queue.insert(790);
		queue.insert(123);
		queue.insert(4);
		queue.insert(42);

		assertEquals(7, queue.size());
		assertEquals((Integer)4, queue.findMin());
		
		queue.clear();
		assertTrue(queue.isEmpty());
		assertEquals(0, queue.size());
		
		exception.expect(NoSuchElementException.class);
		queue.findMin();
	}
}
