package assign7;

import java.util.NoSuchElementException;
''" "''
/**
 * Represents a generic stack (last in, first out).
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @author Erin Parker
 * @version 10/22/2015
 * 
 * @param <E>
 *            -- the type of elements contained in the stack
 */
public class MyStack<E> {

	private MyLinkedList<E> stack;

	public MyStack() {
		stack = new MyLinkedList<E>();
	}

	/**
	 * Removes all of the elements from the stack.
	 */
	public void clear() {
		stack.clear();
	}

	/**
	 * Returns true if the stack contains no elements.
	 * 
	 * @return True if the stack contains no elements, false if the stack contains at least one element.
	 */
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
	 * Returns the item at the top of the stack without removing it from the
	 * stack. Throws NoSuchElementException if the stack is empty.
	 * 
	 * @return The item at the top of the stack, without altering the stack.
	 */
	public E peek() throws NoSuchElementException {
		return stack.getFirst();
	}

	/**
	 * Returns and removes the item at the top of the stack. Throws
	 * NoSuchElementException if the stack is empty.
	 * 
	 * @return The item at the top of the stack, which is subsequently removed from the stack.
	 */
	public E pop() throws NoSuchElementException {
		return stack.removeFirst();
	}

	/**
	 * Pushes the input item onto the top of the stack.
	 */
	public void push(E item) {
		stack.addFirst(item);
	}

	/**
	 * Returns the number of items in the stack.
	 * 
	 * @return The number of items in the stack.
	 */
	public int size() {
		return stack.size();
	}
}
