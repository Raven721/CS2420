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

	//////// generateReverseSortedOrder(int size) ////////
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
		// Because the generatePermutedOrder(int size) method initially creates
		// a list from 1 to size,
		// the ordering of the elements in the output ArrayList should not be in
		// ascending order
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

	//////// mergesort(ArrayList<T> array) ////////
	@Test
	public void testMergeSortWithNullInputArray() {
		// Exception should be thrown if the input array is null

		ArrayList<Integer> nullList = null;

		exception.expect(NullPointerException.class);
		SortUtil.mergesort(nullList);
	}

	@Test
	public void testMergeSortWithNullInputArrayElement() {
		// Exception should be thrown if the input array contains a null element

		ArrayList<Integer> nullElementList = new ArrayList<Integer>();

		nullElementList.add(1);
		nullElementList.add(2);
		nullElementList.add(3);
		nullElementList.add(4);
		nullElementList.add(5);
		nullElementList.add(null);
		nullElementList.add(7);
		nullElementList.add(8);
		nullElementList.add(9);
		nullElementList.add(10);

		exception.expect(NullPointerException.class);
		SortUtil.mergesort(nullElementList);
	}

	@Test
	public void testMergeSortWithInvalidArrayLength() {
		// Exception should be thrown if the input array contains less than 2
		// elements

		ArrayList<Integer> nullList = new ArrayList<Integer>();

		exception.expect(IllegalArgumentException.class);
		SortUtil.mergesort(nullList);
	}

	 @Test
	 public void testMergeSortWithValidPermutatedList() {
		 ArrayList<Integer> unsortedList = SortUtil.generatePermutedOrder(10);
		 ArrayList<Integer> sortedList = SortUtil.generateSortedOrder(10);
	
		 SortUtil.setInsertionSortThreshold(5);
	
		 SortUtil.mergesort(unsortedList);
		 assertEquals(sortedList, unsortedList);
	 }
	 
	 @Test
	 public void testMergeSortWithValidSortedList() {
		 ArrayList<Integer> unsortedList = SortUtil.generateSortedOrder(10);
		 ArrayList<Integer> sortedList = SortUtil.generateSortedOrder(10);
	
		 SortUtil.setInsertionSortThreshold(5);
	
		 SortUtil.mergesort(unsortedList);
		 assertEquals(sortedList, unsortedList);
	 }
	 
	 @Test
	 public void testMergeSortWithValidReverseSortedList() {
		 ArrayList<Integer> unsortedList = SortUtil.generateReverseSortedOrder(10);
		 ArrayList<Integer> sortedList = SortUtil.generateSortedOrder(10);
	
		 SortUtil.setInsertionSortThreshold(5);
	
		 SortUtil.mergesort(unsortedList);
		 assertEquals(sortedList, unsortedList);
	 }
	 
	 @Test
	 public void testMergeSortWithValidCharacterList() {
		 ArrayList<Character> unsortedList = new ArrayList<Character>();
		 ArrayList<Character> sortedList = new ArrayList<Character>();
		 
		 unsortedList.add('f');
		 unsortedList.add('e');
		 unsortedList.add('d');
		 unsortedList.add('c');
		 unsortedList.add('b');
		 unsortedList.add('a');
		 
		 sortedList.add('a');
		 sortedList.add('b');
		 sortedList.add('c');
		 sortedList.add('d');
		 sortedList.add('e');
		 sortedList.add('f');
	
		 SortUtil.setInsertionSortThreshold(5);
	
		 SortUtil.mergesort(unsortedList);
		 assertEquals(sortedList, unsortedList);
	 }
	 
	 @Test
	 public void testMergeSortWithValidStringList() {
		 ArrayList<String> unsortedList = new ArrayList<String>();
		 ArrayList<String> sortedList = new ArrayList<String>();
		 
		 unsortedList.add("facade");
		 unsortedList.add("epsilon");
		 unsortedList.add("delta");
		 unsortedList.add("cantelope");
		 unsortedList.add("beta");
		 unsortedList.add("alpha");
		 
		 sortedList.add("alpha");
		 sortedList.add("beta");
		 sortedList.add("cantelope");
		 sortedList.add("delta");
		 sortedList.add("epsilon");
		 sortedList.add("facade");
	
		 SortUtil.setInsertionSortThreshold(5);
	
		 SortUtil.mergesort(unsortedList);
		 assertEquals(sortedList, unsortedList);
	 }

	//////// quicksort(ArrayList<T> array) ////////
	@Test
	public void testQuickSortWithValidPermutedList() {
		ArrayList<Integer> unsortedList = SortUtil.generatePermutedOrder(10);
		ArrayList<Integer> sortedList = SortUtil.generateSortedOrder(10);

		// Test with pivot choice 0
		SortUtil.setPivotChoice(0);

		SortUtil.quicksort(unsortedList);
		assertEquals(sortedList, unsortedList);
		
		// Test with pivot choice 1
		unsortedList = SortUtil.generatePermutedOrder(10);
		SortUtil.setPivotChoice(1);

		SortUtil.quicksort(unsortedList);
		assertEquals(sortedList, unsortedList);
		
		// Test with pivot choice 2
		unsortedList = SortUtil.generatePermutedOrder(10);
		SortUtil.setPivotChoice(2);

		SortUtil.quicksort(unsortedList);
		assertEquals(sortedList, unsortedList);
	}
	
	@Test
	public void testQuickSortWithValidSortedList() {
		ArrayList<Integer> unsortedList = SortUtil.generateSortedOrder(10);
		ArrayList<Integer> sortedList = SortUtil.generateSortedOrder(10);
		
		// Test with pivot choice 0
		SortUtil.setPivotChoice(0);

		SortUtil.quicksort(unsortedList);
		assertEquals(sortedList, unsortedList);
		
		// Test with pivot choice 1
		unsortedList = SortUtil.generateSortedOrder(10);
		SortUtil.setPivotChoice(1);

		SortUtil.quicksort(unsortedList);
		assertEquals(sortedList, unsortedList);
		
		// Test with pivot choice 2
		unsortedList = SortUtil.generateSortedOrder(10);
		SortUtil.setPivotChoice(2);

		SortUtil.quicksort(unsortedList);
		assertEquals(sortedList, unsortedList);
	}
	
	@Test
	public void testQuickSortWithValidReverseSortedList() {
		ArrayList<Integer> unsortedList = SortUtil.generateReverseSortedOrder(10);
		ArrayList<Integer> sortedList = SortUtil.generateSortedOrder(10);
		
		// Test with pivot choice 0
		SortUtil.setPivotChoice(0);

		SortUtil.quicksort(unsortedList);
		assertEquals(sortedList, unsortedList);
		
		// Test with pivot choice 1
		unsortedList = SortUtil.generateReverseSortedOrder(10);
		SortUtil.setPivotChoice(1);

		SortUtil.quicksort(unsortedList);
		assertEquals(sortedList, unsortedList);
		
		// Test with pivot choice 2
		unsortedList = SortUtil.generateReverseSortedOrder(10);
		SortUtil.setPivotChoice(2);

		SortUtil.quicksort(unsortedList);
		assertEquals(sortedList, unsortedList);
	}
	
	@Test
	public void testQuickSortWithValidCharacterList() {
		 ArrayList<Character> unsortedList = new ArrayList<Character>();
		 ArrayList<Character> sortedList = new ArrayList<Character>();
		 
		 unsortedList.add('f');
		 unsortedList.add('e');
		 unsortedList.add('d');
		 unsortedList.add('c');
		 unsortedList.add('b');
		 unsortedList.add('a');
		 
		 sortedList.add('a');
		 sortedList.add('b');
		 sortedList.add('c');
		 sortedList.add('d');
		 sortedList.add('e');
		 sortedList.add('f');
	
		 SortUtil.quicksort(unsortedList);
		 assertEquals(sortedList, unsortedList);
	 }
	
	 @Test
	 public void testQuickSortWithValidStringList() {
		 ArrayList<String> unsortedList = new ArrayList<String>();
		 ArrayList<String> sortedList = new ArrayList<String>();
		 
		 unsortedList.add("facade");
		 unsortedList.add("epsilon");
		 unsortedList.add("delta");
		 unsortedList.add("cantelope");
		 unsortedList.add("beta");
		 unsortedList.add("alpha");
		 
		 sortedList.add("alpha");
		 sortedList.add("beta");
		 sortedList.add("cantelope");
		 sortedList.add("delta");
		 sortedList.add("epsilon");
		 sortedList.add("facade");
	
		 SortUtil.quicksort(unsortedList);
		 assertEquals(sortedList, unsortedList);
	 }
	 
	//////// setPivotChoice(int choice) ////////
	@Test
	public void testPivotChoiceWithInvalidInput() {
		// Exception should be thrown if the input is not between 0 and 2
		exception.expect(IllegalArgumentException.class);
		SortUtil.setPivotChoice(-1);
		
		exception.expect(IllegalArgumentException.class);
		SortUtil.setPivotChoice(3);
	}
}
