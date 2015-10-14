package assign3;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * An implementation of Priority Queue, this class will take a sorted list of a
 * generic type and perform enque/deque operations using binary sort
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 9/17/2015
 */
public class MyPriorityQueue<E> implements PriorityQueue<E> {

	private MyContainer container;
	private Comparator<? super E> priorityComparator = null;

	/**
	 * Constructor for MyPriorityQueue() that implements the provided comparator for the items.
	 */
	public MyPriorityQueue(Comparator<? super E> c) {
		container = new MyContainer();
		container.items = new Object[100];
		container.size = 0;
		this.priorityComparator = c;
	}

	/**
	 * Constructor for MyPriorityQueue() that implements the natural ordering for the items.
	 */
	public MyPriorityQueue() {
		container = new MyContainer();
		container.items = new Object[100];
		container.size = 0;
	}

	/**
	 * Retrieves, but does not remove, the minimum element in this priority
	 * queue.
	 * 
	 * @return the minimum element or null if the queue is empty
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E findMin() {
		if (isEmpty()) {
			return null;
		}

		return (E) container.items[container.size - 1];
	}

	/**
	 * Retrieves and removes the minimum element in this priority queue.
	 * 
	 * @return the minimum element or null if the queue is empty
	 */
	@Override
	public E deleteMin() {

		// Return null if the queue is empty
		if (isEmpty()) {
			return null;
		}

		// Cache the minimum element so that it can be destroyed in the queue
		@SuppressWarnings("unchecked")
		E minimumElement = ((E) container.items[container.size - 1]);
		container.items[container.size - 1] = null;
		container.size--;

		return minimumElement;
	}

	/**
	 * Inserts a new item into the priority queue while maintaining the order of the list.
	 * If the container is too small to accommodate the new item, it doubles the size of the container.
	 * If the container is empty, it adds the new item into the container. 
	 * 
	 * @param 
	 * 		item to be inserted into the queue
	 */
	@Override
	public void insert(E item) {

		// If the item to be inserted is null, throw a NullPointerException
		if (item == null) {
			throw new NullPointerException();
		}
		
		// If the container is too large to fit another element, resize the
		// container
		if (container.items.length == container.size) {
			doubleContainerSize();
		}

		// Add item to the container if it is the only item currently in the
		// queue
		if (container.size == 0) {
			container.items[container.size++] = item;
			return;
		}

		// Find the location in the list to insert the new item
		int insertionPoint = findInsertionPoint(item);

		// Shift the items in the list to make room for the new item at the
		// insertion point
		shiftList(insertionPoint);

		// Insert new item into the list
		container.items[insertionPoint] = item;

	}

	/**
	 * Returns the index value which represents the insertion point in a list to
	 * insert an item while maintaining the list order.
	 * 
	 * The list is assumed to be in order of descending value
	 * 
	 * @param newItem
	 * 				New item to be inserted into the priority queue
	 */
	@SuppressWarnings("unchecked")
	private int findInsertionPoint(E newItem) {
		int first = 0;
		int last = container.size - 1;
		int middle = (first + last) / 2;

		while (first <= last) {
			// If the new item is smaller than the middle item, skip searching
			// the first half of the list
			if (myCompare(newItem, (E) container.items[middle]) <= -1) {
				// If the list there isn't another item further down the list to
				// compare against, return the next location rightward
				if (middle == last) {
					return middle + 1;
				} else {
					first = middle + 1;
				}
				// If the current item is the same size as the new item, assume
				// current spot as the new insertion point
			} else if (myCompare(newItem, (E) container.items[middle]) == 0) {
				return middle;
			}
			// If the new item is larger than the current item
			else if (myCompare(newItem, (E) container.items[middle]) >= 1) {
				// If the list there isn't another item further down the list to
				// compare against, return the next location leftward
				if (middle == first) {
					return middle;
				} else {
					last = middle - 1;
				}
			}
			middle = (first + last) / 2;
		}

		// If an error occurs, return -1
		return -1;
	}

	/**
	 * Moves items in the queue to make room for a new item to be inserted
	 * 
	 * @param point
	 *            The index of the array where the new item will be inserted
	 *            into the queue
	 */
	private void shiftList(int point) {
		// Create a new array with an additional space for the new item
		Object[] shiftedArray = new Object[container.items.length + 1];

		// Copy items from old array into new one, from the beginning of the
		// list up until the point of insertion
		for (int i = 0; i < point; i++) {
			shiftedArray[i] = container.items[i];
		}

		// Copy the items from the current queue to the new queue, shifted one
		// space to the right
		for (int i = point + 1; i < shiftedArray.length; i++) {
			shiftedArray[i] = container.items[i - 1];
		}

		// Set the current list to reference the newly shifted array
		container.items = shiftedArray;
		container.size++;
	}

	/**
	 * Compares two objects and provides separate comparison logic depending on
	 * which constructor was used.
	 * If the first object is larger then the second, it returns greater than zero.
	 * If the first object is smaller then the second, it returns less than zero.
	 * If the first object is equal to the second object, it returns zero.
	 * 
	 * @param e1
	 * 			The first object of the comparison.
	 * @param e2
	 * 			The second object of the comparison.
	 */
	@SuppressWarnings("unchecked")
	private int myCompare(E e1, E e2) {
		// If comparator was NOT used to construct the queue
		if (priorityComparator == null) {
			return ((Comparable<? super E>) e1).compareTo(e2);
		}
		// If comparator was used to construct the queue
		return priorityComparator.compare(e1, e2);
	}

	/**
	 * Increases the size of the container by a factor of 2. This method is utilized when the
	 * priority queue becomes too large for its container.
	 */
	public void doubleContainerSize() {

		// Create a new array object
		Object[] resizedArray = new Object[container.items.length * 2];

		// Copy the small array into its resized container
		for (int i = 0; i < container.size; i++)
			resizedArray[i] = container.items[i];

		// update the reference to point to the new array
		container.items = resizedArray;

	}

	/**
	 * Inserts the specified elements into this priority queue.
	 * 
	 * @param coll
	 *            the collection of elements to insert
	 */
	@Override
	public void insertAll(Collection<? extends E> coll) {
		// Add the collection to the array
		for (E element : coll) {
			insert(element);
		}
	}

	/**
	 * @return the number of items in this priority queue
	 */
	@Override
	public int size() {
		return container.size;
	}

	/**
	 * @return true if this priority queue contains no items.
	 */
	@Override
	public boolean isEmpty() {
		return container.size == 0;
	}

	/**
	 * Removes all of the elements from this priority queue. The queue will be
	 * empty when this call returns.
	 */
	@Override
	public void clear() {
		container.items = new Object[100];
		container.size = 0;
	}

	/**
	 * @return an iterator over the elements in this priority queue, where the
	 *         elements are returned in sorted (descending) order
	 */
	@Override
	public Iterator<E> iterator() {
		return new MyPriorityQueueIterator<E>(container);
	}

}
