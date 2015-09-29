package assign5;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import org.junit.rules.ExpectedException;

/**
 * A utility for testing the various methods and output of the SortUtil class
 *
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 10/1/2015
 */
public class SortUtilTester {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	//////// generateSortedOrder(int size) ////////
	@Test
	public void testSortedOrderWithValidInput() {
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		int size = 10;
		
		sortedList.add(1);
		sortedList.add(2);
		sortedList.add(3);
		sortedList.add(4);
		sortedList.add(5);
		sortedList.add(6);
		sortedList.add(7);
		sortedList.add(8);
		sortedList.add(9);
		sortedList.add(10);
		
		assertEquals(sortedList, SortUtil.generateSortedOrder(size));
	}
	
	@Test
	public void testSortedOrderWithInvalidInput() {
		// Exception should be thrown if the input size is less than 2
		exception.expect(IllegalArgumentException.class);
		SortUtil.generateSortedOrder(1);
		
		exception.expect(IllegalArgumentException.class);
		SortUtil.generateSortedOrder(0);
		
		exception.expect(IllegalArgumentException.class);
		SortUtil.generateSortedOrder(-1);
	}
	
	////////generateReverseSortedOrder(int size) ////////
	@Test
	public void testReverseSortedOrderWithValidInput() {
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		int size = 10;
		
		sortedList.add(10);
		sortedList.add(9);
		sortedList.add(8);
		sortedList.add(7);
		sortedList.add(6);
		sortedList.add(5);
		sortedList.add(4);
		sortedList.add(3);
		sortedList.add(2);
		sortedList.add(1);
		
		assertEquals(sortedList, SortUtil.generateReverseSortedOrder(size));
	}
	
	@Test
	public void testReverseSortedOrderWithInvalidInput() {
		// Exception should be thrown if the input size is less than 2
		exception.expect(IllegalArgumentException.class);
		SortUtil.generateReverseSortedOrder(1);
				
		exception.expect(IllegalArgumentException.class);
		SortUtil.generateReverseSortedOrder(0);
				
		exception.expect(IllegalArgumentException.class);
		SortUtil.generateReverseSortedOrder(-1);
	}
	
	//////// generatePermutedOrder(int size) ////////
	@Test
	public void testPermutedOrderWithValidInput() {
		// Because the generatePermutedOrder(int size) method initially creates a list from 1 to size, 
		// the ordering of the elements in the output ArrayList should not be in ascending order 
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		int size = 10;
		
		sortedList.add(1);
		sortedList.add(2);
		sortedList.add(3);
		sortedList.add(4);
		sortedList.add(5);
		sortedList.add(6);
		sortedList.add(7);
		sortedList.add(8);
		sortedList.add(9);
		sortedList.add(10);
		
		assertNotEquals(sortedList, SortUtil.generatePermutedOrder(size));
	}
	
	@Test
	public void testPermutedOrderWithInvalidInput() {
		// Exception should be thrown if the input size is less than 2
		exception.expect(IllegalArgumentException.class);
		SortUtil.generatePermutedOrder(1);
		
		exception.expect(IllegalArgumentException.class);
		SortUtil.generatePermutedOrder(0);
		
		exception.expect(IllegalArgumentException.class);
		SortUtil.generatePermutedOrder(-1);
	}

}
