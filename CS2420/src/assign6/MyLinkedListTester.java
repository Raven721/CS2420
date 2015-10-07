package assign6;

import java.util.NoSuchElementException;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * A JUnit test class for the MyLinkedList class.
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 10/8/2015
 */
public class MyLinkedListTester {
	
	MyLinkedList<Integer> intList;
	MyLinkedList<String> stringList;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		intList = new MyLinkedList<Integer>();
		stringList = new MyLinkedList<String>();
	}
	
	///////////   addFirst(E o)   ////////////
	@Test
	public void testAddFirstWithEmptyList() {
		// Verify that the initial size of the list is 0
		assertEquals(0, intList.size());
		
		// Add item to list
		intList.addFirst(1);
		
		// Check that the list size has incremented
		assertEquals(1, intList.size());
		assertEquals((Integer)1, intList.get(0));
		
		// Add another item to the list
		intList.addFirst(2);
		
		// Check that the list size has incremented
		assertEquals(2, intList.size());
		
		// Check that the first item in the list is also the last item to be added
		assertEquals((Integer)2, intList.get(0));
	}
	
	///////////   addLast(E o)   ////////////
	@Test
	public void testAddLastWithEmptyList() {
		// Verify that the initial size of the list is 0
		assertEquals(0, intList.size());
		
		// Add item to list
		intList.addLast(1);
		
		// Check that the list size has incremented
		assertEquals(1, intList.size());
		assertEquals((Integer)1, intList.get(0));
		
		// Add another item to the list
		intList.addLast(2);
		
		// Check that the list size has incremented
		assertEquals(2, intList.size());
		
		// Check that the last item in the list is also the last item to be added
		assertEquals((Integer)2, intList.get(1));
	}
	
	///////////   add(int index, E element)    ////////////
	@Test
	public void testAddWithValidIntegerInput() {
		intList.add(0, 1);
		intList.add(1, 2);
		intList.add(2, 3);
		intList.add(3, 4);
		
		// Check that the added items are in the correct places in the list
		assertEquals((Integer)1, intList.get(0));
		assertEquals((Integer)2, intList.get(1));
		assertEquals((Integer)3, intList.get(2));
		assertEquals((Integer)4, intList.get(3));
		
		// Check the length of the linked list
		assertEquals(4, intList.size());
		
		// Insert an item into an occupied position
		intList.add(0, 10);
		
		// Check that the length of the linked list has incremented
		assertEquals(5, intList.size());
		
		// Check the new positions of the items
		assertEquals((Integer)10, intList.get(0));
		assertEquals((Integer)1, intList.get(1));
		assertEquals((Integer)2, intList.get(2));
		assertEquals((Integer)3, intList.get(3));
		assertEquals((Integer)4, intList.get(4));
	}
	
	@Test
	public void testAddWithValidStringInput() {
		stringList.add(0, "1");
		stringList.add(1, "2");
		stringList.add(2, "3");
		stringList.add(3, "4");
		
		// Check that the added items are in the correct places in the list
		assertEquals("1", stringList.get(0));
		assertEquals("2", stringList.get(1));
		assertEquals("3", stringList.get(2));
		assertEquals("4", stringList.get(3));
		
		// Check the length of the linked list
		assertEquals(4, stringList.size());
		
		// Insert an item into an occupied position
		stringList.add(0, "10");
		
		// Check that the length of the linked list has incremented
		assertEquals(5, stringList.size());
		
		// Check the new positions of the items
		assertEquals("10", stringList.get(0));
		assertEquals("1", stringList.get(1));
		assertEquals("2", stringList.get(2));
		assertEquals("3", stringList.get(3));
		assertEquals("4", stringList.get(4));
	}
	
	@Test
	public void testAddWithInvalidIndex() {
		// Exception should be thrown if the input index is < 0 or greater than the size of the LinkedList
		exception.expect(IndexOutOfBoundsException.class);
		intList.add(-1, 1234);
		
		exception.expect(IndexOutOfBoundsException.class);
		intList.add(400, 1234);
		
		exception.expect(IndexOutOfBoundsException.class);
		stringList.add(-1, "1234");
		
		exception.expect(IndexOutOfBoundsException.class);
		stringList.add(400, "1234");
	}
	
	/////////////  getFirst()   ///////////
	@Test
	public void testGetFirstWithEmptyList() {
		// Exception should be thrown if the input index is < 0 or greater than the size of the LinkedList
		exception.expect(NoSuchElementException.class);
		intList.getFirst();
		
		exception.expect(NoSuchElementException.class);
		stringList.getFirst();
	}
	
	@Test
	public void testGetFirstWithNonEmptyList() {
		// Check each element at each index to verify that the correct elements are being returned
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		
		assertEquals((Integer)40, intList.getFirst());
		assertEquals("Newest Item", stringList.getFirst());
	}
	
	/////////////  getLast()   ///////////
	@Test
	public void testGetLastWithEmptyList() {
		// Exception should be thrown if the input index is < 0 or greater than the size of the LinkedList
		exception.expect(NoSuchElementException.class);
		intList.getLast();
		
		exception.expect(NoSuchElementException.class);
		stringList.getLast();
	}
	
	@Test
	public void testGetLastWithNonEmptyList() {
		// Check each element at each index to veryify that the correct elements are being returned
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		
		assertEquals((Integer)10, intList.getLast());
		assertEquals("Fourth Newest Item", stringList.getLast());
	}
	
	/////////////  get(int index)   ///////////
	@Test
	public void testGetWithEmptyList() {
		// Exception should be thrown if the input index is < 0 or greater than the size of the LinkedList
		exception.expect(IndexOutOfBoundsException.class);
		intList.get(-1);
		
		exception.expect(IndexOutOfBoundsException.class);
		stringList.get(12);
	}
	
	@Test
	public void testGetWithNonEmptyList() {
		// Check each element at each index to veryify that the correct elements are being returned
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		
		assertEquals((Integer)40, intList.get(0));
		assertEquals("Newest Item", stringList.get(0));
		assertEquals((Integer)10, intList.get(3));
		assertEquals("Fourth Newest Item", stringList.get(3));
		assertEquals((Integer)30, intList.get(1));
		assertEquals("Second Newest Item", stringList.get(1));
		assertEquals((Integer)20, intList.get(2));
		assertEquals("Third Newest Item", stringList.get(2));
	}
	
	/////////////   removeFirst()   ///////////
	@Test
	public void testRemoveFirstWithEmptyList() {
		// Exception should be thrown removeLast attempts to operate on an empty list
		exception.expect(NoSuchElementException.class);
		intList.removeFirst();
		
		exception.expect(NoSuchElementException.class);
		stringList.removeFirst();
	}
	
	@Test
	public void testRemoveFirstWithNonEmptyList() {
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		
		// Check the size of the lists
		assertEquals(4, intList.size());
		assertEquals(4, stringList.size());
		
		// Remove the first element in these lists
		assertEquals((Integer)40, intList.removeFirst());
		assertEquals("Newest Item", stringList.removeFirst());
		
		// Check the first element has adjusted
		assertEquals((Integer)30, intList.getFirst());
		assertEquals("Second Newest Item", stringList.getFirst());
		
		// Check that the size of the lists have adjusted
		assertEquals(3, intList.size());
		assertEquals(3, stringList.size());
	}
	
	/////////////   removeLast()   ///////////
	@Test
	public void testRemoveLastWithEmptyList() {
		// Exception should be thrown removeLast attempts to operate on an empty list
		exception.expect(NoSuchElementException.class);
		intList.removeLast();
		
		exception.expect(NoSuchElementException.class);
		stringList.removeLast();
	}
	
	@Test
	public void testRemoveLastWithNonEmptyList() {
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		
		// Check the size of the lists
		assertEquals(4, intList.size());
		assertEquals(4, stringList.size());
		
		// Remove the last element in these lists
		assertEquals((Integer)10, intList.removeLast());
		assertEquals("Fourth Newest Item", stringList.removeLast());
		
		// Check the last element has adjusted
		assertEquals((Integer)20, intList.getLast());
		assertEquals("Third Newest Item", stringList.getLast());
		
		// Check that the size of the lists have adjusted
		assertEquals(3, intList.size());
		assertEquals(3, stringList.size());
	}
	
	/////////////   remove(int index)   ///////////
	@Test
	public void testRemoveOutOfBounds() {
		// Exception should be thrown if the input index is < 0 or greater than the size of the LinkedList
		exception.expect(IndexOutOfBoundsException.class);
		intList.remove(-1);
		
		exception.expect(IndexOutOfBoundsException.class);
		stringList.remove(12);
	}
	
	@Test
	public void testRemoveValidItem() {
		// Size should decrement after removing item
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		
		// Check the size of the list
		assertEquals(4, intList.size());
		assertEquals(4, stringList.size());
		
		// Remove the first item in the lists
		assertEquals((Integer)40, intList.remove(0));
		assertEquals("Newest Item", stringList.remove(0));
		
		// Re-check the size
		assertEquals(3, intList.size());
		assertEquals(3, stringList.size());
		
		// Verify the beginning of the list has adjusted correctly
		assertEquals((Integer)30, intList.getFirst());
		assertEquals("Second Newest Item", stringList.getFirst());
		
		// Verify the end of the list is still correct
		assertEquals((Integer)10, intList.getLast());
		assertEquals("Fourth Newest Item", stringList.getLast());
	}
	
	////////////   indexOf(E element)  ///////////
	@Test
	public void testIndexOfWithEmptyList() {
		// Should return a -1 since the item being searched for does not exist in the list
		assertEquals(-1, intList.indexOf(1));
		assertEquals(-1, stringList.indexOf("Won't be found"));
	}
	
	@Test
	public void testIndexOfWithNonEmptyListNotFound() {
		// Should return a -1 since the item being searched for does not exist in the list
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		
		assertEquals(-1, intList.indexOf(123));
		assertEquals(-1, stringList.indexOf("Won't be found"));
	}
	
	@Test
	public void testIndexOfItem() {
		// Should return the index of the recurring item toward at the beginning(left) of the list
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		
		assertEquals(0, intList.indexOf(40));
		assertEquals(0, stringList.indexOf("Newest Item"));
	}
	
	////////////   lastIndexOf(E element)  ///////////
	@Test
	public void testLastIndexOfWithEmptyList() {
		// Should return a -1 since the item being searched for does not exist in the list
		assertEquals(-1, intList.lastIndexOf(1));
		assertEquals(-1, stringList.lastIndexOf("Won't be found"));
	}
	
	@Test
	public void testLastIndexOfWithNonEmptyListNotFound() {
		// Should return a -1 since the item being searched for does not exist in the list
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		
		assertEquals(-1, intList.lastIndexOf(400));
		assertEquals(-1, stringList.lastIndexOf("Won't be found"));
	}
	
	@Test
	public void testLastIndexOfItem() {
		// Should return the index of the recurring item toward at the end(right) of the list
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		
		assertEquals(4, intList.lastIndexOf(40));
		assertEquals(4, stringList.lastIndexOf("Newest Item"));
	}
	
	////////////    int size()   ////////////
	@Test
	public void testSizeWithEmptyList() {
		// An empty list should have a size of 0
		assertEquals(0, intList.size());
		assertEquals(0, stringList.size());
	}
	
	@Test
	public void testSizeWithNonEmptyList() {
		// A list with four elements should return 4
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		
		assertEquals(4, intList.size());
		assertEquals(4, stringList.size());
	}
	
	////////////// isEmpty   //////////////
	@Test
	public void testIsEmptyWithEmptyList() {
		// Should return true if the list is empty
		assertTrue(intList.isEmpty());
		assertTrue(stringList.isEmpty());
	}
	
	@Test
	public void testIsEmptyWithNonEmptyList() {
		// Should return false if the list is not empty
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		
		assertFalse(intList.isEmpty());
		assertFalse(stringList.isEmpty());
	}
	
	/////////////  clear()  //////////////
	@Test
	public void testClearWithNonEmptyList() {
		// Clearing the list should report a length of zero
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		
		assertEquals(4, intList.toArray().length);
		intList.clear();
		assertEquals(0, intList.toArray().length);
	}
	
	@Test
	public void testClearWithEmptyList() {
		// Clearing the list should report a length of zero
		intList.clear();
		assertEquals(0, intList.toArray().length);
	}
	
	///////////// toArray() //////////////
	@Test
	public void testToArrayWithNonEmptyLength() {
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		intList.addFirst(12);
		
		assertEquals(4, intList.toArray().length);
	}
	
	@Test
	public void testToArrayWithEmptyListLength() {
		assertEquals(0, intList.toArray().length);
	}
	
	@Test
	public void testToArrayOrderWithValidIntegerInput() {
		// The most recently added element should be the first element in the array
		intList.addFirst(10);
		intList.addFirst(20);
		intList.addFirst(30);
		intList.addFirst(40);
		
		Object[] objArr = intList.toArray();
		
		assertEquals(40, objArr[0]);
		assertEquals(30, objArr[1]);
		assertEquals(20, objArr[2]);
		assertEquals(10, objArr[3]);
	}
	
	@Test
	public void testToArrayOrderWithValidStringInput() {
		// The most recently added element should be the first element in the array
		stringList.addFirst("Fourth Newest Item");
		stringList.addFirst("Third Newest Item");
		stringList.addFirst("Second Newest Item");
		stringList.addFirst("Newest Item");
		
		Object[] objArr = stringList.toArray();
		
		assertEquals("Newest Item", objArr[0]);
		assertEquals("Second Newest Item", objArr[1]);
		assertEquals("Third Newest Item", objArr[2]);
		assertEquals("Fourth Newest Item", objArr[3]);
	}
}
