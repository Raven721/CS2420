package assign5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A robust utility for sorting various types ArrayLists using QuickSort and MergeSort algorithms.
 *
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 10/1/2015
 */
public class SortUtil {
	
	/**
	 * Performs a mergesort on an ArrayList of a given type
	 * 
	 * @param arr 
	 * 			  The array of a given type to be sorted
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> msArray) {
		
	}
	
	/**
	 * Performs a quicksort on an ArrayList of a given type
	 * 
	 * @param arr 
	 * 			  The array of a given type to be sorted
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> qsArray) {
		
	}
	
	/**
	 * Generates a list of a specified length, containing integers in sorted order (1 to n in ascending order)
	 * 
	 * @param size
	 * 			   The number of elements to include in the generated ArrayList
	 * @return
	 * 		   Returns an ArrayList<Integer> object containing the specified number of elements in sorted order
	 */
	public static ArrayList<Integer> generateSortedOrder(int size) {
		// Throw exception if size is less than 2
		if(size < 2) {
			throw new IllegalArgumentException("Invalid Size: input is less than 2");
		}
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		
		// Add elements from 1 to size to ArrayList (Smallest to biggest)
		for(int i = 1; i <= size; i++)
			sortedList.add(i);
		
		return sortedList;
	}
	
	/**
	 * Generates a list of a specified length, containing integers from 1 to n in permuted order
	 * 
	 * @param size
	 * 			   The number of elements to include in the generated ArrayList
	 * @return
	 * 		   Returns an ArrayList<Integer> object containing the specified number of random elements
	 */
	public static ArrayList<Integer> generatePermutedOrder(int size) {
		// Throw exception if size is less than 2
		if(size < 2) {
			throw new IllegalArgumentException("Invalid Size: input is less than 2");
		}
		
		ArrayList<Integer> permutedList = new ArrayList<Integer>();
		
		// Add elements from 1 to size to ArrayList
		for(int i = 1; i <= size; i++)
			permutedList.add(i);
		
		// Shuffle the ArrayList
		Collections.shuffle(permutedList);
		
		return permutedList;
	}
	
	/**
	 * Generates a list of a specified length, containing integers in reverse sorted order (1 to n in descending order)
	 * 
	 * @param size
	 * 			   The number of elements to include in the generated ArrayList
	 * @return
	 * 		   Returns an ArrayList<Integer> object containing the specified number of elements in reverse-sorted order
	 */
	public static ArrayList<Integer> generateReverseSortedOrder(int size) {
		// Throw exception if size is less than 2
		if(size < 2) {
			throw new IllegalArgumentException("Invalid Size: input is less than 2");
		}
		
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		
		// Add elements from size to 1 to ArrayList (Biggest to smallest)
		for(int i = size; i >= 1; i--)
			sortedList.add(i);
		
		return sortedList;
	}
	
}
