package assign4;

import java.util.Comparator;

/**
 * A utility that determines the largest anagrams in a list of words. 
 * 
 * This class assumes all inputs are single words and not phrases, punctuation is not permitted
 * It is assumed that the word list provided to the class does not contain duplicates.
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 9/24/2015
 */
public class AnagramUtil {
	
	/**
	 * Returns the sorted version of an input string using insertion sort. 
	 * @param s
	 * 			The string to be sorted
	 */
	public static String sort(String s) {
		
		return s;
	}
	
	/**
	 * A generic method that sorts the input array using an insertion sort
	 * and the input Comparator object
	 * 
	 * @param arr
	 * 			 The array to be sorted 
	 * @param c
	 * 			 A Comparator object that is used to compare the array elements
	 */
	public static <T> void insertionSort(T[] arr, Comparator<? super T> c) {
		
	}
	
	/**
	 * Returns true if the two input strings are anagrams of each other
	 * Otherwise, return false
	 * 
	 * Utilizes the sort(String s) method
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean areAnagrams(String s1, String s2) {
		
		return false;
	}
	
	/**
	 * Returns the largest group of anagrams in the input array of words, in no particular order
	 * 
	 * Returns an empty array if there are no anagrams in the input array.
	 * 
	 * Utilizes areAnagrams(String s1, String s2) and insertionSort(T[] arr, Comparator<? super T c)
	 * 
	 * @param s
	 * 		   String array of words to be analyzed
	 */
	public static String[] getLargestAnagramGroup(String[] s) {
		
		return s;
	}
	
	/**
	 * Returns the largest group of anagrams of a list inside of a text file
	 * Returns an empty array if the file is empty or does not exist
	 * 
	 * It is assumed that the file contains one word per line.
	 * Utilizes getLargestAnagramGroup(String[] s)
	 * 
	 * @param filename
	 * 				  Name of text file containing a list of words
	 */
	public static String[] getLargestAnagramGroup(String filename) {
		
		return null;
	}

	
}
