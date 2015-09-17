package assign3;

import java.util.Collection;
import java.util.Iterator;

/**
 * A priority queue that supports access of the minimum element only.
 * 
 * @author Erin Parker
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * 
 * @param <E>
 *            -- the type of elements contained in this priority queue
 */
public interface PriorityQueue<E> {

	/**
	 * Retrieves, but does not remove, the minimum element in this priority
	 * queue.
	 * 
	 * @return the minimum element or null if the queue is empty
	 */
	public E findMin();

	/**
	 * Retrieves and removes the minimum element in this priority queue.
	 * 
	 * @return the minimum element or null if the queue is empty
	 */
	public E deleteMin();

	/**
	 * Inserts the specified element into this priority queue.
	 * 
	 * @param item
	 *            -- the element to insert
	 */
	public void insert(E item);

	/**
	 * Inserts the specified elements into this priority queue.
	 * 
	 * @param coll
	 *            -- the collection of elements to insert
	 */
	public void insertAll(Collection<? extends E> coll);

	/**
	 * @return the number of elements in this priority queue
	 */
	public int size();

	/**
	 * @return true if this priority queue contains no elements
	 */
	public boolean isEmpty();

	/**
	 * Removes all of the elements from this priority queue. The queue will be
	 * empty when this call returns.
	 */
	public void clear();

	/**
	 * @return an iterator over the elements in this priority queue, where the
	 *         elements are returned in sorted (descending) order
	 */
	public Iterator<E> iterator();
}