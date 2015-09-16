package assign3;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of Priority Queue, this class will take a sorted list of a
 * generic type and perform enque/deque operations using binary sort
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, BlueJay45
 */
public class MyPriorityQueue<E> implements PriorityQueue<E> {

	private MyContainer container;
	private Comparator<? super E> priorityComparator = null;

	public MyPriorityQueue(Comparator<? super E> c) {
		container = new MyContainer();
		container.items = new Object[100];
		container.size = 0;
		this.priorityComparator = c;
	}

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
		E minimumElement = ((E) container.items[container.size]);
		container.items[container.size] = null;
		container.size--;

		return minimumElement;
	}

	@Override
	public void insert(E item) {

		// If the container is too large to fit another element, resize the
		// container
		if (container.items.length == container.size) {
			doubleContainerSize();
		}

		// Add item to the container if it is the only item currently in the
		// queue
		if (container.size == 0) {
			container.items[container.size++] = item;
			container.items.toString();
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
	 * @param item
	 */
	private int findInsertionPoint(E newItem) {
		int first = 0;
		int last = container.size - 1;
		int middle = (first + last) / 2;

		while (first <= last) {
			// If the new item is smaller than the middle item, skip searching the first half of the list
			if (myCompare(newItem, (E) container.items[middle]) == -1) {
				// If the list there isn't another item further down the list to compare against, return the next location rightward
				if (middle == last) {
					return middle + 1;
				} else {
					first = middle + 1;
				}
			// If the current item is the same size as the new item, assume current spot as the new insertion point
			} else if (myCompare(newItem, (E) container.items[middle]) == 0) {
				return middle;
			}
			// If the new item is larger than the current item
			else if (myCompare(newItem, (E) container.items[middle]) == 1) {
				// If the list there isn't another item further down the list to compare against, return the next location leftward
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

	private void shiftList(int point) {
		// Create a new array with an additional space for the new item
		Object[] shiftedArray = new Object[container.items.length + 1];

		// Copy items from old array into new one, from the beginning of the list up until the point of insertion
		for (int i = 0; i < point; i++) {
			shiftedArray[i] = container.items[i];
		}

		// Copy the items from the current queue to the new queue, shifted one space to the right
		for (int i = point + 1; i < shiftedArray.length; i++) {
			shiftedArray[i] = container.items[i - 1];
		}

		// Set the current list to reference the newly shifted array
		container.items = shiftedArray;
		container.size++;
	}

	/**
	 * Compares two objects Provides separate comparison logic depending on
	 * which constructor was used
	 * 
	 * @param e1
	 * @param e2
	 * @return
	 */
	private int myCompare(E e1, E e2) {
		// If comparator was NOT used to construct the queue
		if (priorityComparator == null) {
			return ((Comparable<? super E>) e1).compareTo(e2);
		}
		// If comparator was used to construct the queue
		return priorityComparator.compare(e1, e2);
	}

	/**
	 * Increases the size of the container by a factor of 2 Utilized when the
	 * priority queue becomes too large for its container
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
	 *            -- the collection of elements to insert
	 */
	@Override
	public void insertAll(Collection<? extends E> coll) {
		priorityComparator = null;
		container.size = coll.size();
		container.items = new Object[container.size * 2];

		// Add the collection to the array
		int i = 0;
		for (E element : coll) {
			if (element.equals(null)) {
				break;
			}

			container.items[i] = element;
		}
	}

	/**
	 * @return the number of elements in this priority queue
	 */
	@Override
	public int size() {
		return container.size;
	}

	/**
	 * @return true if this priority queue contains no elements
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

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public void printContainer() {
		String queue = null;

		for (int i = 0; i < container.size; i++) {
			System.out.print(container.items[i] + " ");
		}
		if(container.size == 0) {
			System.out.println("container is empty");
		}
		else {
			System.out.println();
		}
	}

}
