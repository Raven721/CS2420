package assign3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;

import org.junit.Test;


/**
 * A testing suite for the priority queue implementation
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, BlueJay45
 */
public class MyPriorityQueueTester {

	@Test
	public void testSortRandomIntegers() {

		MyPriorityQueue<Integer> queue1 = new MyPriorityQueue<Integer>(new IntegerComparator());
		Random rn = new Random();
		
		// Insert 200 random numbers into the queue, the numbers range between 1 to 200
		for(int i = 0; i < 200; i++) {
			queue1.insert(rn.nextInt(200 - 1 + 1) + 1);
		}
		
		queue1.printContainer();
		//assertEquals((Integer)2, queue1.findMin());	
		
		queue1.clear();
		queue1.printContainer();
		assertEquals(null, queue1.findMin());
	}
	
	@Test
	public void testFindMinWithZeroInput() {
		
		MyPriorityQueue<Integer> queue2 = new MyPriorityQueue<Integer>(new IntegerComparator());
		queue2.insert(-191);
		queue2.insert(12);
		queue2.insert(-4);
		queue2.insert(1);
		queue2.insert(0);
		queue2.insert(-1);
		
		queue2.printContainer();
		assertEquals((Integer)(-191), queue2.findMin());
		
	}
}
