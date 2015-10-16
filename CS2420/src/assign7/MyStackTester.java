package assign7;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit Tests for the MyStack class
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 10/22/2015
 */
public class MyStackTester {
	
	MyStack<Integer> stack;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		stack = new MyStack<Integer>();
	}
	
	//////// void clear() ////////
	@Test
	public void testClearWithEmptyStack() {
		// Stack have zero items before and after the clear method is invoked on the stack
		assertEquals(0, stack.size());
		stack.clear();
		assertEquals(0, stack.size());
	}
	
	@Test
	public void testClearWithPopulatedStack() {
		// Stack have three items before and zero items after the clear method is invoked on the stack
		stack.push(1);
		stack.push(1);
		stack.push(1);
		
		assertEquals(3, stack.size());
		stack.clear();
		assertEquals(0, stack.size());
	}

	//////// boolean isEmpty() ////////
	@Test
	public void testIsEmptyWithEmptyStack() {
		// A stack with zero items should return true when isEmpty() is invoked on it
		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testIsEmptyWithPopulatedStack() {
		// A stack with three items should return false when isEmpty() is invoked on it
		stack.push(1);
		stack.push(1);
		stack.push(1);
		
		assertEquals(3, stack.size());
		assertFalse(stack.isEmpty());
	}

	//////// E peek() ////////
	@Test
	public void testPeekWithEmptyStack() {
		// The peek() method should throw an exception if the stack is empty
		assertTrue(stack.isEmpty());
		
		exception.expect(NoSuchElementException.class);
		stack.peek();
	}
	
	@Test
	public void testPeekWithPopulatedStack() {
		// The peek() method should return the last item added to the stack if the stack is not empty
		stack.push(10);
		stack.push(50);
		stack.push(100);
		
		assertEquals(3, stack.size());
		assertEquals((Integer)100, stack.peek());
		
		// The size of the stack should be the same size after invoking the peek() method
		assertEquals(3, stack.size());
	}

	//////// E pop() ////////
	@Test
	public void testPopkWithEmptyStack() {
		// The pop() method should throw an exception if the stack is empty
		assertTrue(stack.isEmpty());
		
		exception.expect(NoSuchElementException.class);
		stack.pop();
	}
	
	@Test
	public void testPopWithPopulatedStack() {
		// The pop() method should return the last item added to the stack and then remove it if the stack is not empty
		stack.push(10);
		stack.push(50);
		stack.push(100);
		
		assertEquals(3, stack.size());
		assertEquals((Integer)100, stack.pop());
		
		// The size of the stack should be the same size after invoking the peek() method
		assertEquals(2, stack.size());
		
		// The top item on the stack should be the last item added to the stack before 100
		assertEquals((Integer)50, stack.peek());
		
	}

	//////// void push(E item) ////////
	@Test
	public void testPushWithEmptyStack() {
		// The push() method should add an element to an empty stack
		assertTrue(stack.isEmpty());
		
		stack.push(10);
		assertFalse(stack.isEmpty());
		
		assertEquals((Integer)10, stack.peek());
	}
	
	@Test
	public void testPushWithPopulatedStack() {
		// The push method should add an element to a stack already containing elements
		assertTrue(stack.isEmpty());
		
		stack.push(10);
		assertFalse(stack.isEmpty());
		assertEquals((Integer)10, stack.peek());
		
		stack.push(50);
		assertFalse(stack.isEmpty());
		assertEquals((Integer)50, stack.peek());
		
		stack.push(100);
		assertFalse(stack.isEmpty());
		assertEquals((Integer)100, stack.peek());
	}

	//////// int size() ////////
	@Test
	public void testSizeWithEmptyStack() {
		// size() should return zero if the stack is empty
		assertTrue(stack.isEmpty());
		
		assertEquals(0, stack.size());
	}
	
	@Test
	public void testSizeWithPopulatedStack() {
		// size() should return zero if the stack is empty
		// The push method should add an element to a stack already containing elements
		assertTrue(stack.isEmpty());
		
		stack.push(10);
		assertEquals(1, stack.size());
		
		stack.push(50);
		assertEquals(2, stack.size());
		
		stack.push(100);
		assertEquals(3, stack.size());
		
		stack.pop();
		assertEquals(2, stack.size());
		
		stack.pop();
		assertEquals(1, stack.size());
		
		stack.pop();
		assertEquals(0, stack.size());
	}
}
