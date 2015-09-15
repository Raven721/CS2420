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
		
		for(int i = container.size-1; i >= 0; i--) { // Start at End
			if(myCompare(item, (E) container.items[1]) == 1) { // If new item larger
				container.items[i+1] = container.items[i]; // Shift upward
			}
			else { // if smaller/equal value
				container.items[i+1] = item;
				container.size++;
				break; // done shifting
			}		
		}
		
		
		

		myCompare(item, (E) container.items[1]);
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
		System.out.println(priorityComparator.compare(e1, e2));
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
		return container.size == 1;
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

}
