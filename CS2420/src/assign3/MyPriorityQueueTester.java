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

		MyPriorityQueue<String> set = new MyPriorityQueue<String>(new NaturalComparator<String>());
		set.insert("cat");
		set.insert("dog");
		set.insert("fish");
		set.insert("aardvark");
		
		System.out.println(set.toString());
		
		//assertEquals("cat",(set.findMin()));
		
		
		//deleteMin returns the item that was deleted
		//assertEquals("cat", set.deleteMin());
		//assertEquals("cat", set.deleteMin());
		//assertNull(set.findMin());
		
	}
}
