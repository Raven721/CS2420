package assign3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import org.junit.Test;


/**
 * A testing suite for the priority queue implementation
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, BlueJay45
 */
public class MyPriorityQueueTester {

	
	@Test
	public void testFindMinWithShortQueue() {
		
		Comparator<String> b = null;
		MyPriorityQueue<String> set = new MyPriorityQueue<String>(b);
		//set.insert("cat");
		
		//assertEquals("cat",(set.findMin()));
		
		Collection<String> c = new ArrayList<String>();
		c.add("cat");
		c.add("dog");
		c.add("fish");
		
		set.insertAll(c);
		System.out.println(set.findMin());
		//deleteMin returns the item that was deleted
		//assertEquals("cat", set.deleteMin());
		//assertEquals("cat", set.deleteMin());
		//assertNull(set.findMin());
		
	}
}
