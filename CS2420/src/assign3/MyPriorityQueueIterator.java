package assign3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class that iterates through the priority queue
 * 
 * @author Erin Parker
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
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

	public E next() {
		if(!hasNext())
			throw new NoSuchElementException();  

		okToRemove = true; 

		return (E) container.items[currentPosition++]; 
	}

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
