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
	
	private static int MergeToInsertionThreshold = 0;
	
	/**
	 * Method for setting the threshold list size when the merge sort should utilize an insertion sort
	 * @param size
	 * 			  Desired length of sub-array in the mergesort method to switch over to insertion sort
	 */
	public static void setThreshold(int size) {
		MergeToInsertionThreshold = size;
	}
	
	/**
	 * Performs a mergesort on an ArrayList of a given type
	 * 
	 * @param arr 
	 * 			  The array of a given type to be sorted
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> array) {
		
		@SuppressWarnings("unchecked")
		T[] subArray = (T[]) new Comparable[array.size()];
		
		// mergesort(Array to sort, subArray, leftEnd, rightEnd) 
		mergesort(array, subArray, 0, array.size() - 1);
	}
	
	/**
	 * Helper method that recursively works through the mergesort 
	 * 
	 * @param <T> 
	 * 				Generic object that implements Comparable
	 * @param array 
	 * 				The ArrayList that is to be sorted
	 * @param subArray 
	 * 				Temporary array to place the merged result
	 * @param leftEnd 
	 * 				Array index of left end of subArray
	 * @param rightEnd 
	 * 				Array index of right end of subArray
	 */
	private static <T extends Comparable<? super T>> void mergesort
			(ArrayList<T> array, T[] subArray, int leftEnd, int rightEnd) {
		
		if(leftEnd +  MergeToInsertionThreshold > rightEnd)
			insertionSort(array, leftEnd, rightEnd);
		else{
			int center = (leftEnd + rightEnd) / 2;
			mergesort(array, subArray, leftEnd, center);
			mergesort(array, subArray, center + 1, rightEnd);
			mergeSubArrays(array, subArray, leftEnd, center + 1, rightEnd);
		}
	}
	
	public static <T extends Comparable<? super T>> void mergeSubArrays
			(ArrayList<T> array, T[] tempArray, int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tempPos = leftPos;
		int numElements = rightEnd - leftPos + 1;
		
		// Main loop
		while(leftPos <= leftEnd && rightPos <= rightEnd)
			if(array.get(leftPos).compareTo(array.get(rightPos)) <= 0)
				tempArray[tempPos + 1] = array.get(leftPos + 1);
			else
				tempArray[tempPos + 1] = array.get(rightPos + 1);
		
		// Write while loop for left sub-array
		while(leftPos <= leftEnd)
			tempArray[tempPos + 1] = array.get(leftPos + 1);
		
		// Write while loop for right sub-array
		while(rightPos <= rightEnd)
			tempArray[tempPos + 1] = array.get(rightPos + 1);
		
		// Copy from temp array back to array
		for(int i = 0; i < numElements; i++, rightEnd--)
			array.set(rightEnd, tempArray[rightEnd]);
	}
	
	/**
	 * Helper method that performs an insertion sort algorithm on an input array between two indexes
	 * 
	 * @param array
	 * 				Array to be sorted using insertion sort
	 * @param leftEnd
	 * 				Index of the left-most element in the input array to be sorted
	 * @param rightEnd
	 * 				Index of the right-most element in the input array to be sorted
	 */
	private static <T extends Comparable<? super T>> void insertionSort
			(ArrayList<T> array, int leftEnd, int rightEnd) {
		// Cycle through the input array between the two input indexes leftEnd and rightEnd
		for(int i = leftEnd + 1; i <= rightEnd; i++) {
			T current = array.get(i);
			int j = i;
			
			// Compare and swap elements
			for(; j > leftEnd && current.compareTo(array.get(j - 1)) < 0; j--) 
				array.set(j, array.get(j - 1));
			
			array.set(j, current);
		}
	}
	
	/**
	 * Performs a quicksort on an ArrayList of a given type
	 * 
	 * @param arr 
	 * 			  The array of a given type to be sorted
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> array) {
		
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
