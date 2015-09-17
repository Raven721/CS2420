package assign3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class that iterates through the priority queue
 * 
 * @author Erin Parker
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 9/17/2015
 *
 * @param <E>
 */
public class MyPriorityQueueIterator<E> implements Iterator<E> {
	private int currentPosition;

	private MyContainer container;

	private boolean okToRemove;

	public MyPriorityQueueIterator(MyContainer _container) {
		container = _container;
		currentPosition = 0;
		okToRemove = false;  
	}

	/**
	 * Returns true if there exists an additional element to the right in the priority queue
	 */
	public boolean hasNext() {
		return currentPosition < container.size;  
	}

	/**
	 * Returns the next item in the priority queue
	 * 
	 * Throws a NoSuchElementException if the queue is empty or if there is no additional elements in the queue
	 */
	public E next() {
		if(!hasNext())
			throw new NoSuchElementException();  

		okToRemove = true; 

		return (E) container.items[currentPosition++]; 
	}

	/**
	 * Removes the last item iterated with the next() method from the priority queue
	 * 
	 * Throws an IllegalStateException if the last item to be iterated doesn't exist
	 */
	public void remove() {
		if(!okToRemove)   
			throw new IllegalStateException();

		for(int i = currentPosition; i < container.size; i++)
			container.items[i - 1] = container.items[i];

		container.size--;
		currentPosition--; 

		okToRemove = false; 
	}
	
}
