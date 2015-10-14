package assign7;

import java.util.NoSuchElementException;

/**
 * A priority queue that supports access of the minimum element only.
 * ALL METHODS ARE O(1).
 * 
 * @author Erin Parker and ??
 * 
 * @param <E>
 *            -- the type of elements contained in this priority queue
 */
public class MyPriorityQueue<E extends Comparable<? super E>> {

	public MyPriorityQueue() {
		// FILL IN to create empty priority queue
	}
	
	/**
	 * Returns, but does not remove, the minimum element in this priority
	 * queue.  Throws NoSuchElementException if the priority queue is empty.
	 */
	public E findMin() throws NoSuchElementException {
		// FILL IN
		return null;
	}

	/**
	 * Inserts the specified item into this priority queue.
	 */
	public void insert(E item) {
		// FILL IN
	}

	/**
	 * Returns the number of items in this priority queue.
	 */
	public int size() {
		// FILL IN
		return 0;
	}

	/**
	 * Returns true if this priority queue contains no items.
	 */
	public boolean isEmpty() {
		// FILL IN
		return false;
	}

	/**
	 * Removes all of the items from this priority queue.
	 */
	public void clear() {
		// FILL IN
	}
}
