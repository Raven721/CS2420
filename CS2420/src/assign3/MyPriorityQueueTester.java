package assign3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/**
 * A testing suite for the priority queue implementation
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 */
public class MyPriorityQueueTester {

	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	//////// Comparator Insert ////////
	@Test
	public void testInsertIntegerToSortedArrayListComparator() {

		MyPriorityQueue<Integer> queue = new MyPriorityQueue<Integer>(new IntegerComparator());
		ArrayList<Integer> listToCompareAgainst = new ArrayList<Integer>();
		Iterator<Integer> itr = queue.iterator();
		
		Random rn = new Random();
		int randomNum;
		
		// Insert 100 random numbers into the queue and an array list, the numbers range between 1 to 200
		for(int i = 0; i < 100; i++) {
			randomNum = rn.nextInt(200 - 1 + 1) + 1;
			queue.insert(randomNum);
			listToCompareAgainst.add(randomNum);
		}
		
		// Sort the ArrayList using Collections.sort
		Collections.sort(listToCompareAgainst, Collections.reverseOrder());
		
		//Compare the item order of the sorted ArrayList to the item order of the priority queue
		for(Integer item: listToCompareAgainst) {
			assertEquals(item, itr.next());
		}
	}
	
	@Test
	public void testInsertIntegerDuplicateComparator() {

		MyPriorityQueue<Integer> queue = new MyPriorityQueue<Integer>(new IntegerComparator());
		ArrayList<Integer> listToCompareAgainst = new ArrayList<Integer>();
		Iterator<Integer> itr = queue.iterator();
		
		Random rn = new Random();
		int randomNum;
		
		// Insert 100 random numbers into the queue and an array list, the numbers range between 1 to 200
		for(int i = 0; i < 100; i++) {
			randomNum = rn.nextInt(200 - 1 + 1) + 1;
			queue.insert(randomNum);
			listToCompareAgainst.add(randomNum);
		}
		
		// Insert Duplicate numbers into both lists
		queue.insert(12);
		queue.insert(12);
		queue.insert(12);
		queue.insert(12);
		
		listToCompareAgainst.add(12);
		listToCompareAgainst.add(12);
		listToCompareAgainst.add(12);
		listToCompareAgainst.add(12);
		
		// Sort the ArrayList using Collections.sort
		Collections.sort(listToCompareAgainst, Collections.reverseOrder());
		
		//Compare the item order of the sorted ArrayList to the item order of the priority queue
		for(Integer item: listToCompareAgainst) {
			assertEquals(item, itr.next());
		}
	}
	
	@Test
	public void testInsertStringToSortedArrayListComparator() {

		MyPriorityQueue<String> queue = new MyPriorityQueue<String>(new StringComparator());
		ArrayList<String> listToCompareAgainst = new ArrayList<String>();
		Iterator<String> itr = queue.iterator();
		
		// Insert 10 random Strings into the queue and an array list, in the same order
		queue.insert("Apple");
		listToCompareAgainst.add("Apple");
		queue.insert("Kiwi");
		listToCompareAgainst.add("Kiwi");
		queue.insert("Orange");
		listToCompareAgainst.add("Orange");
		queue.insert("Grape");
		listToCompareAgainst.add("Grape");
		queue.insert("Mango");
		listToCompareAgainst.add("Mango");
		queue.insert("Squash");
		listToCompareAgainst.add("Squash");
		queue.insert("Tomato");
		listToCompareAgainst.add("Tomato");
		queue.insert("Potato");
		listToCompareAgainst.add("Potato");
		queue.insert("Walnut");
		listToCompareAgainst.add("Walnut");
		queue.insert("Lemon");
		listToCompareAgainst.add("Lemon");
		
		// Sort the ArrayList using Collections.sort
		Collections.sort(listToCompareAgainst, Collections.reverseOrder());
		
		//Compare the item order of the sorted ArrayList to the item order of the priority queue
		for(String item: listToCompareAgainst) {
			assertEquals(item, itr.next());
		}
	}
	
	@Test
	public void testInsertStringDuplicateComparator() {

		MyPriorityQueue<String> queue = new MyPriorityQueue<String>(new StringComparator());
		ArrayList<String> listToCompareAgainst = new ArrayList<String>();
		Iterator<String> itr = queue.iterator();
		
		// Insert 10 random Strings into the queue and an array list, in the same order
		queue.insert("Apple");
		listToCompareAgainst.add("Apple");
		queue.insert("Apple");
		listToCompareAgainst.add("Apple");
		queue.insert("Apple");
		listToCompareAgainst.add("Apple");
		queue.insert("Grape");
		listToCompareAgainst.add("Grape");
		queue.insert("Mango");
		listToCompareAgainst.add("Mango");
		queue.insert("Squash");
		listToCompareAgainst.add("Squash");
		queue.insert("Tomato");
		listToCompareAgainst.add("Tomato");
		queue.insert("Potato");
		listToCompareAgainst.add("Potato");
		queue.insert("Walnut");
		listToCompareAgainst.add("Walnut");
		queue.insert("Lemon");
		listToCompareAgainst.add("Lemon");
		
		// Sort the ArrayList using Collections.sort
		Collections.sort(listToCompareAgainst, Collections.reverseOrder());
		
		//Compare the item order of the sorted ArrayList to the item order of the priority queue
		for(String item: listToCompareAgainst) {
			assertEquals(item, itr.next());
		}
	}
	
	@Test
	public void testInsertAllWithStringComparator() {
		
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>(new StringComparator());
		List<String> listToCompareAgainst = new ArrayList<String>();
		Iterator<String> itr = queue.iterator();
		
		// Insert 10 random Strings into the queue and an array list, in the same order
		listToCompareAgainst.add("Apple");
		listToCompareAgainst.add("Apple");
		listToCompareAgainst.add("Apple");
		listToCompareAgainst.add("Grape");
		listToCompareAgainst.add("Mango");
		listToCompareAgainst.add("Squash");
		listToCompareAgainst.add("Tomato");
		listToCompareAgainst.add("Potato");
		listToCompareAgainst.add("Walnut");
		listToCompareAgainst.add("Lemon");
		
		queue.insertAll(listToCompareAgainst);
		
		// Sort the ArrayList using Collections.sort
		Collections.sort(listToCompareAgainst, Collections.reverseOrder());
		
		//Compare the item order of the sorted ArrayList to the item order of the priority queue
		for(String item: listToCompareAgainst) {
			assertEquals(item, itr.next());
		}
	}
	
	//////// Comparable Insert ////////
	@Test
	public void testInsertIntegerToSortedArrayListComparable() {

		MyPriorityQueue<Integer> queue = new MyPriorityQueue<Integer>();
		ArrayList<Integer> listToCompareAgainst = new ArrayList<Integer>();
		Iterator<Integer> itr = queue.iterator();
		
		Random rn = new Random();
		int randomNum;
		
		// Insert 100 random numbers into the queue and an array list, the numbers range between 1 to 200
		for(int i = 0; i < 100; i++) {
			randomNum = rn.nextInt(200 - 1 + 1) + 1;
			queue.insert(randomNum);
			listToCompareAgainst.add(randomNum);
		}
		
		// Sort the ArrayList using Collections.sort
		Collections.sort(listToCompareAgainst, Collections.reverseOrder());
		
		//Compare the item order of the sorted ArrayList to the item order of the priority queue
		for(Integer item: listToCompareAgainst) {
			assertEquals(item, itr.next());
		}
	}
	
	@Test
	public void testInsertIntegerDuplicateComparable() {

		MyPriorityQueue<Integer> queue = new MyPriorityQueue<Integer>();
		ArrayList<Integer> listToCompareAgainst = new ArrayList<Integer>();
		Iterator<Integer> itr = queue.iterator();
		
		Random rn = new Random();
		int randomNum;
		
		// Insert 100 random numbers into the queue and an array list, the numbers range between 1 to 200
		for(int i = 0; i < 100; i++) {
			randomNum = rn.nextInt(200 - 1 + 1) + 1;
			queue.insert(randomNum);
			listToCompareAgainst.add(randomNum);
		}
		
		// Insert Duplicate numbers into both lists
		queue.insert(12);
		queue.insert(12);
		queue.insert(12);
		queue.insert(12);
		
		listToCompareAgainst.add(12);
		listToCompareAgainst.add(12);
		listToCompareAgainst.add(12);
		listToCompareAgainst.add(12);
		
		// Sort the ArrayList using Collections.sort
		Collections.sort(listToCompareAgainst, Collections.reverseOrder());
		
		//Compare the item order of the sorted ArrayList to the item order of the priority queue
		for(Integer item: listToCompareAgainst) {
			assertEquals(item, itr.next());
		}
	}
	
	@Test
	public void testInsertStringToSortedArrayListComparable() {

		MyPriorityQueue<String> queue = new MyPriorityQueue<String>();
		ArrayList<String> listToCompareAgainst = new ArrayList<String>();
		Iterator<String> itr = queue.iterator();
		
		// Insert 10 random Strings into the queue and an array list, in the same order
		queue.insert("Apple");
		listToCompareAgainst.add("Apple");
		queue.insert("Kiwi");
		listToCompareAgainst.add("Kiwi");
		queue.insert("Orange");
		listToCompareAgainst.add("Orange");
		queue.insert("Grape");
		listToCompareAgainst.add("Grape");
		queue.insert("Mango");
		listToCompareAgainst.add("Mango");
		queue.insert("Squash");
		listToCompareAgainst.add("Squash");
		queue.insert("Tomato");
		listToCompareAgainst.add("Tomato");
		queue.insert("Potato");
		listToCompareAgainst.add("Potato");
		queue.insert("Walnut");
		listToCompareAgainst.add("Walnut");
		queue.insert("Lemon");
		listToCompareAgainst.add("Lemon");
		
		// Sort the ArrayList using Collections.sort
		Collections.sort(listToCompareAgainst, Collections.reverseOrder());
		
		//Compare the item order of the sorted ArrayList to the item order of the priority queue
		for(String item: listToCompareAgainst) {
			assertEquals(item, itr.next());
		}
	}
	
	@Test
	public void testInsertStringDuplicateComparable() {

		MyPriorityQueue<String> queue = new MyPriorityQueue<String>();
		ArrayList<String> listToCompareAgainst = new ArrayList<String>();
		Iterator<String> itr = queue.iterator();
		
		// Insert 10 random Strings into the queue and an array list, in the same order
		queue.insert("Apple");
		listToCompareAgainst.add("Apple");
		queue.insert("Apple");
		listToCompareAgainst.add("Apple");
		queue.insert("Apple");
		listToCompareAgainst.add("Apple");
		queue.insert("Grape");
		listToCompareAgainst.add("Grape");
		queue.insert("Mango");
		listToCompareAgainst.add("Mango");
		queue.insert("Squash");
		listToCompareAgainst.add("Squash");
		queue.insert("Tomato");
		listToCompareAgainst.add("Tomato");
		queue.insert("Potato");
		listToCompareAgainst.add("Potato");
		queue.insert("Walnut");
		listToCompareAgainst.add("Walnut");
		queue.insert("Lemon");
		listToCompareAgainst.add("Lemon");
		
		// Sort the ArrayList using Collections.sort
		Collections.sort(listToCompareAgainst, Collections.reverseOrder());
		
		//Compare the item order of the sorted ArrayList to the item order of the priority queue
		for(String item: listToCompareAgainst) {
			assertEquals(item, itr.next());
		}
	}
	
	//////// findMin ////////
	@Test
	public void testFindMinWithEmptyQueue() {
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>(new StringComparator());

		assertNull(queue.findMin());
	}
	
	@Test
	public void testFindMinWithStringComparator() {
		
		MyPriorityQueue<String> queue3 = new MyPriorityQueue<String>(new StringComparator());
		queue3.insert("aardvark");
		queue3.insert("castle");
		queue3.insert("speaker");
		queue3.insert("xylophone");

		assertEquals("aardvark", queue3.findMin());
	}
	
	////// isEmpty //////
	@Test
	public void testEmptyWithEmptyQueue() {
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>(new StringComparator());

		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void testEmptyWithNotEmptyQueue() {
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>(new StringComparator());
		queue.insert("aardvark");

		assertEquals("aardvark", queue.findMin());
	}
	
	////// doubleContainerSize //////
	@Test
	public void testDoubleContainerSize() {

		MyPriorityQueue<Integer> queue = new MyPriorityQueue<Integer>(new IntegerComparator());
		
		Random rn = new Random();
		int randomNum;
		
		// Insert 99 random numbers into the queue
		for(int i = 0; i < 99; i++) {
			randomNum = rn.nextInt(200 - 1 + 1) + 1;
			queue.insert(randomNum);
		}
		
		assertEquals(99, queue.size());
		
		// Insert two additional items into the queue
		// The initial array size of the container is capable of holding a maximum of 99 items, the array doubles after inserting the 100th item
		queue.insert(2);
		queue.insert(2);
		
		assertEquals(101, queue.size());
		
	}
	
	////// deleteMin //////
	@Test
	public void testdeleteMinEmptyQueue() {
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>(new StringComparator());

		assertNull(queue.deleteMin());
	}
	
	@Test
	public void testDeleteMinWithPopulatedQueue() {
		
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>(new StringComparator());
		queue.insert("aardvark");
		queue.insert("castle");
		queue.insert("speaker");
		queue.insert("xylophone");

		// Find the initial minimum and size of the queue 
		assertEquals("aardvark", queue.findMin());
		assertEquals(4, queue.size());
		
		// Delete minimum item
		assertEquals("aardvark", queue.deleteMin());
		
		// Check the new minimum and size of queue
		assertEquals("castle", queue.findMin());
		assertEquals(3, queue.size());
		
	}
	
	@Test
	public void testDeleteMinWithOneItemQueue() {
		
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>(new StringComparator());
		queue.insert("aardvark");

		// Find the initial minimum and size of the queue 
		assertEquals("aardvark", queue.findMin());
		assertEquals(1, queue.size());
		
		// Delete minimum item
		assertEquals("aardvark", queue.deleteMin());
		
		// Check the new minimum and size of queue
		assertNull(queue.findMin());
		assertEquals(0, queue.size());
		
	}
	
	////// Iterator //////
	@Test
	public void testClearWithEmptyQueue() {
		
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>(new StringComparator());
		
		// Check the initial minimum and size of queue
		assertNull(queue.findMin());
		assertEquals(0, queue.size());
		
		// Clear the queue
		queue.clear();
		
		// Check the new minimum and size of queue
		assertNull(queue.findMin());
		assertEquals(0, queue.size());
		
	}
	
	@Test
	public void testClearWithPopulatedQueue() {
		
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>(new StringComparator());
		queue.insert("aardvark");
		queue.insert("castle");
		queue.insert("speaker");
		queue.insert("xylophone");

		// Find the initial minimum and size of the queue 
		assertEquals("aardvark", queue.findMin());
		assertEquals(4, queue.size());
		
		// Delete minimum item
		queue.clear();
		
		// Check the new minimum and size of queue
		assertNull(queue.findMin());
		assertEquals(0, queue.size());
	}
	
	////// Iterator //////
	@Test
    public void testIteratorNextEmptyQueueException() {
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>();
		Iterator<String> itr = queue.iterator();

		// Make sure that an exception is thrown whenever the iterator attempts to iterate to the next item if one doesnt exist
        thrown.expect(NoSuchElementException.class);
        itr.next();
    }
	
	@Test
    public void testIteratorNextPopulatedQueue() {
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>();
		Iterator<String> itr = queue.iterator();
		
		queue.insert("cat");
		
        assertEquals("cat", itr.next());
    }
	
	@Test
    public void testIteratorHasNextEmptyQueue() {
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>();
		Iterator<String> itr = queue.iterator();
		
        assertFalse(itr.hasNext());
    }
	
	@Test
    public void testIteratorHasNextPopulatedQueue() {
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>();
		Iterator<String> itr = queue.iterator();
		
		queue.insert("cat");
		
        assertTrue(itr.hasNext());
    }
	
	@Test
    public void testIteratorRemoveEmptyQueueException() {
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>();
		Iterator<String> itr = queue.iterator();

		// Make sure that an exception is thrown whenever the iterator attempts to remove an item from an empty queue
        thrown.expect(IllegalStateException.class);
        itr.remove();
    }
	
	@Test
    public void testIteratorRemovePopulatedQueue() {
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>();
		Iterator<String> itr = queue.iterator();

		// Add item to queue
		queue.insert("Hello");
		queue.insert("GoodBye");
		
		// Iterate to the last item in list
		itr.next();
		itr.next();
		
		// Remove item from queue
        itr.remove();
        
        // Read the next item in queue, verify that the last item in the queue has been removed
        assertEquals(1, queue.size());
        assertEquals("Hello", queue.findMin());
    }
	
	@Test
	public void testIterator() {
		
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>();
		queue.insert("cat");
		queue.insert("dog");
		queue.insert("bird");
		queue.insert("fish");

		Iterator<String> itr = queue.iterator();
		assertEquals("fish", itr.next());
		assertEquals("dog", itr.next());
		assertEquals("cat", itr.next());
		assertEquals("bird", itr.next());

		// restart the iteration
		itr = queue.iterator();
		itr.next(); 
		itr.remove(); 
	}
}
