package assign7;

import java.util.NoSuchElementException;

/**
 * A priority queue that supports access of the minimum element only. ALL
 * METHODS ARE O(1).
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @author Erin Parker
 * @version 10/22/2015
 * 
 * @param <E>
 *            -- the type of elements contained in this priority queue
 */
public class MyPriorityQueue<E extends Comparable<? super E>> {

	private MyStack<E> itemStack;
	private MyStack<E> minStack;

	public MyPriorityQueue() {
		itemStack = new MyStack<E>();
		minStack = new MyStack<E>();
	}

	/**
	 * Returns, but does not remove, the minimum element in this priority queue.
	 * Throws NoSuchElementException if the priority queue is empty.
	 */
	public E findMin() throws NoSuchElementException {
		return minStack.peek();
	}

	/**
	 * Inserts the specified item into this priority queue.
	 */
	public void insert(E item) {
		itemStack.push(item);

		// Add item to min stack if it is the first item
		if (minStack.isEmpty()) {
			minStack.push(item);
		} else {
			// If the new item is smaller than the last min, push the item to the minStack
			// Otherwise, push the last min to the minStack
			if(minStack.peek().compareTo(item) <= 0) {
				minStack.push(item);
			} else {
				minStack.push(minStack.peek());
			}
		}
	}

	/**
	 * Returns the number of items in this priority queue.
	 */
	public int size() {
		return this.size();
	}

	/**
	 * Returns true if this priority queue contains no items.
	 */
	public boolean isEmpty() {
		return this.isEmpty();
	}

	/**
	 * Removes all of the items from this priority queue.
	 */
	public void clear() {
		itemStack.clear();
		minStack.clear();
	}
}
