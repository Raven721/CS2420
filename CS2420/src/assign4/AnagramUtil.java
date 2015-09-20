package assign4;

import java.util.Comparator;

/**
 * A utility that determines the largest anagrams in a list of words. 
 * 
 * This class assumes all inputs are single words and not phrases, punctuation is not permitted.
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

		// Check that the input string is valid
		if(s == null){
			throw new NullPointerException();
		}
		else if(!s.matches("[a-zA-Z]+")) {
			throw new IllegalArgumentException("Input string contains non-alphabetized characters");
		}
		else if(s.length() < 2) {
			throw new IllegalArgumentException("Input string is too short(< 2 characters) to be considered an anagram");
		}
		
		// Impose that all strings are lower case, assume that anagrams are case-insensitive
		s = s.toLowerCase();
		
		// Copy individual letters from input string into an char array
		char[] letters = s.toCharArray();
		char tmp;
		
		// Utilize the insertion sort algorithm to rearrange letters in char array in alphabetical order
		for(int i = 1; i < letters.length; i++) {
			tmp = letters[i];
			int j = i;
					
			// While the current letter is 'smaller' than the letter to its left, swap the letters
			for(; j > 0 && tmp < letters[j - 1]; j--) {
				letters[j] = letters[j - 1];
			}
			letters[j] = tmp;
		}
		
		// Return the char array reassembled as a single string
		return new String(letters);
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
		
		T tmp;
		
		// Cycle through the array elements starting at the second element
		for(int i = 1; i < arr.length; i++) {
			tmp = arr[i];
			int j = i;
			
			// While the current letter is 'smaller' than the letter to its left, swap the letters
			for(; j > 0 && c.compare(arr[j], tmp) > 0; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = tmp;
		}
	}
	
	/**
	 * Returns true if the two input strings are anagrams of each other
	 * Otherwise, return false
	 * 
	 * Utilizes the sort(String s) method
	 * 
	 * @param s1
	 * @param s2
	 */
	public static boolean areAnagrams(String s1, String s2) {
		if(sort(s1).equals(sort(s2))) {
			return true;
		}	
		return false;
	}
	
	/**
	 * Returns the largest group of anagrams in the input array of words, in no particular order
	 * Returns an empty array if there are no anagrams in the input array.
	 * 
	 * If multiple groups of anagrams are of equal size, return the first group of anagrams.
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
