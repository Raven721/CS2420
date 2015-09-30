package assign5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A robust utility for sorting various types ArrayLists using QuickSort and
 * MergeSort algorithms.
 *
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 10/1/2015
 */
public class SortUtil {

	// If the insertion sort threshold is never set, default to 0
	private static int MergeToInsertionThreshold = 0;
	private static int pivotChoice = 0;

	/**
	 * Method for setting the threshold list size when the merge sort should
	 * utilize an insertion sort
	 * 
	 * @param size
	 *            Desired length of sub-array in the mergesort method to switch
	 *            over to insertion sort
	 */
	public static void setThreshold(int size) {
		MergeToInsertionThreshold = size;
	}

	/**
	 * Performs a mergesort on an ArrayList of a given type
	 * 
	 * @param <T>
	 *            Generic object that implements Comparable
	 * @param arr
	 *            The array of a given type to be sorted
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> array) {

		// Throw an exception if the input array is null
		if (array == null)
			throw new NullPointerException("Input array is null");

		// Throw an exception if the input array has less than two elements
		if (array.size() < 2)
			throw new IllegalArgumentException("Input array contains less than 2 elements");

		// Throw an exception if the input array contains a null element
		for (T element : array) {
			if (element == null) {
				throw new NullPointerException("Input array contains a null element");
			}
		}

		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) new Comparable[array.size()];
		

		// mergesort(Array to sort, subArray, leftEnd, rightEnd)
		mergesort(array, tempArray, 0, array.size() - 1);
	}

	/**
	 * Helper method that recursively works through the mergesort
	 * 
	 * @param <T>
	 *            Generic object that implements Comparable
	 * @param array
	 *            The ArrayList that is to be sorted
	 * @param tempArray
	 *            Temporary array to place the merged result
	 * @param leftEnd
	 *            Array index of left end of subArray
	 * @param rightEnd
	 *            Array index of right end of subArray
	 */
	private static <T extends Comparable<? super T>> void mergesort(ArrayList<T> array, T[] tempArray, int leftEnd,
			int rightEnd) {

		if (leftEnd + MergeToInsertionThreshold > rightEnd) {
			insertionSort(array, leftEnd, rightEnd);
		} else {
			int center = (leftEnd + rightEnd) / 2;
			mergesort(array, tempArray, leftEnd, center);
			mergesort(array, tempArray, center + 1, rightEnd);
			mergeSubArrays(array, tempArray, leftEnd, center + 1, rightEnd);
		}
	}

	/**
	 * Helper method that merges two sorted halves of a sub-array
	 * 
	 * @param <T>
	 *            Generic object that implements Comparable
	 * @param array
	 *            Array to be sorted
	 * @param tempArray
	 *            A temporary cache to store the merge results
	 * @param leftPos
	 *            The left-most index of the sub-array
	 * @param rightPos
	 *            The right-most index of the sub-array
	 * @param rightEnd
	 *            The right-most index of the sub-array
	 */
	private static <T extends Comparable<? super T>> void mergeSubArrays(ArrayList<T> array, T[] tempArray, int leftPos,
			int rightPos, int rightEnd) {
		
		int leftEnd = rightPos - 1;
		int tempPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		// Main loop
		while (leftPos <= leftEnd && rightPos <= rightEnd) { 
			if (array.get(leftPos).compareTo(array.get(rightPos)) <= 0)
				tempArray[tempPos++] = array.get(leftPos++);
			else
				tempArray[tempPos++] = array.get(rightPos++);
		}
		
		// Write while loop for left sub-array
		while (leftPos <= leftEnd)
			tempArray[tempPos++] = array.get(leftPos++);

		// Write while loop for right sub-array
		while (rightPos <= rightEnd)
			tempArray[tempPos++] = array.get(rightPos++);

		// Copy from tempArray array back to array
		for (int i = 0; i < numElements; i++, rightEnd--)
			array.set(rightEnd, tempArray[rightEnd]);
	}

	/**
	 * Helper method that performs an insertion sort algorithm on an input array
	 * between two indexes
	 * 
	 * @param <T>
	 *            Generic object that implements Comparable
	 * @param array
	 *            Array to be sorted using insertion sort
	 * @param leftEnd
	 *            Index of the left-most element in the input array to be sorted
	 * @param rightEnd
	 *            Index of the right-most element in the input array to be
	 *            sorted
	 */
	private static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> array, int leftEnd, int rightEnd) {
		// Cycle through the input array between the two input indexes leftEnd
		// and rightEnd
		for (int i = leftEnd + 1; i <= rightEnd; i++) {
			T current = array.get(i);
			int j = i;

			// Compare and swap elements
			for (; j > leftEnd && current.compareTo(array.get(j - 1)) < 0; j--)
				array.set(j, array.get(j - 1));

			array.set(j, current);
		}
	}

	public static <T extends Comparable<? super T>> void swapReferences(ArrayList<T> arr, int index1, int index2) {
		T tmp = arr.get(index1);
		arr.set(index1, arr.get(index2));
		arr.set(index2, tmp);
	}

	/**
	 * Performs a quicksort on an ArrayList of a given type
	 * 
	 * @param <T>
	 *            Generic object that implements Comparable
	 * @param arr
	 *            The array of a given type to be sorted
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> array) {
		quicksort(array, 0, array.size() - 1);
	}

	private static <T extends Comparable<? super T>> void quicksort(ArrayList<T> array, int left, int right) {
		if (left + MergeToInsertionThreshold > right) {
			insertionSort(array, left, right);
		} else {
			// Sort low, middle, high
			int middle = left + (right - left) / 2;
			T pivot;
			if (pivotChoice == 0) {
				if (array.get(right).compareTo(array.get(middle)) < 0) {
					swapReferences(array, middle, right);
				}
				swapReferences(array, middle, right - 1);
			} else if (pivotChoice == 1) {
				int quarter = left + (right - left) / 4;
				if (array.get(right).compareTo(array.get(quarter)) < 0) {
					swapReferences(array, quarter, right);
				}
				swapReferences(array, quarter, right - 1);
			} else if (pivotChoice == 2) {
				if (array.get(middle).compareTo(array.get(left)) < 0) {
					swapReferences(array, left, middle);
				}
				if (array.get(right).compareTo(array.get(left)) < 0) {
					swapReferences(array, left, right);
				}
				if (array.get(right).compareTo(array.get(middle)) < 0) {
					swapReferences(array, middle, right);
				}

				swapReferences(array, middle, right - 1);
			} else {
				System.err.println("Invalid pivot choice. Choice defaulted to 1");
				swapReferences(array, left, right - 1);
			}

			pivot = array.get(right - 1);
			int i;
			int j;
			for (i = left - 1, j = right - 1;;) {
				while (i < right - 1 && array.get(++i).compareTo(pivot) < 0)
					;
				while (j > left && pivot.compareTo(array.get(--j)) < 0)
					;
				if (i >= j) {
					break;
				}

				swapReferences(array, i, j);
			}

			swapReferences(array, i, right - 1);

			quicksort(array, left, i - 1);
			quicksort(array, i + 1, right);
		}
	}

	public static void setPivotChoice(int choice) {
		pivotChoice = choice;
	}

	/**
	 * Generates a list of a specified length, containing integers in sorted
	 * order (1 to n in ascending order)
	 * 
	 * @param size
	 *            The number of elements to include in the generated ArrayList
	 * @return Returns an ArrayList<Integer> object containing the specified
	 *         number of elements in sorted order
	 */
	public static ArrayList<Integer> generateSortedOrder(int size) {
		// Throw exception if size is less than 2
		if (size < 2) {
			throw new IllegalArgumentException("Invalid Size: input is less than 2");
		}
		ArrayList<Integer> sortedList = new ArrayList<Integer>();

		// Add elements from 1 to size to ArrayList (Smallest to biggest)
		for (int i = 1; i <= size; i++)
			sortedList.add(i);

		return sortedList;
	}

	/**
	 * Generates a list of a specified length, containing integers from 1 to n
	 * in permuted order
	 * 
	 * @param size
	 *            The number of elements to include in the generated ArrayList
	 * @return Returns an ArrayList<Integer> object containing the specified
	 *         number of random elements
	 */
	public static ArrayList<Integer> generatePermutedOrder(int size) {
		// Throw exception if size is less than 2
		if (size < 2) {
			throw new IllegalArgumentException("Invalid Size: input is less than 2");
		}

		ArrayList<Integer> permutedList = new ArrayList<Integer>();

		// Add elements from 1 to size to ArrayList
		for (int i = 1; i <= size; i++)
			permutedList.add(i);

		// Shuffle the ArrayList
		Collections.shuffle(permutedList);

		return permutedList;
	}

	/**
	 * Generates a list of a specified length, containing integers in reverse
	 * sorted order (1 to n in descending order)
	 * 
	 * @param size
	 *            The number of elements to include in the generated ArrayList
	 * @return Returns an ArrayList<Integer> object containing the specified
	 *         number of elements in reverse-sorted order
	 */
	public static ArrayList<Integer> generateReverseSortedOrder(int size) {
		// Throw exception if size is less than 2
		if (size < 2) {
			throw new IllegalArgumentException("Invalid Size: input is less than 2");
		}

		ArrayList<Integer> sortedList = new ArrayList<Integer>();

		// Add elements from size to 1 to ArrayList (Biggest to smallest)
		for (int i = size; i >= 1; i--)
			sortedList.add(i);

		return sortedList;
	}
}
