package assign4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * A utility that determines the largest anagrams in a list of words.
 * 
 * This class assumes all inputs are single words and not phrases, punctuation
 * is not permitted. It is assumed that the word list provided to the class does
 * not contain duplicates.
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 9/24/2015
 */
public class AnagramUtil {

	private static Scanner in;

	/**
	 * Returns the sorted version of an input string using insertion sort.
	 * 
	 * @param s
	 *            The string to be sorted
	 */
	public static String sort(String s) {

		// Check that the input string is valid
		if (s == null) {
			throw new NullPointerException();
		} else if (!s.matches("[a-zA-Z]+")) {
			throw new IllegalArgumentException("Input string contains non-alphabetized characters");
		} else if (s.length() < 2) {
			throw new IllegalArgumentException("Input string is too short(< 2 characters) to be considered an anagram");
		}

		// Impose that all strings are lower case, assume that anagrams are
		// case-insensitive
		s = s.toLowerCase();

		// Copy individual letters from input string into an char array
		char[] letters = s.toCharArray();
		char tmp;

		// Utilize the insertion sort algorithm to rearrange letters in char
		// array in alphabetical order
		for (int i = 1; i < letters.length; i++) {
			tmp = letters[i];
			int j = i;

			// While the current letter is 'smaller' than the letter to its
			// left, swap the letters
			for (; j > 0 && tmp < letters[j - 1]; j--) {
				letters[j] = letters[j - 1];
			}
			letters[j] = tmp;
		}

		// Return the char array reassembled as a single string
		return new String(letters);
	}
	
	/**
	 * Returns the sorted version of an input string using the Arrays.sort method
	 * 
	 * @param s
	 *            The string to be sorted
	 */
	public static String sortUsingArraySortMethod(String s) {

		// Check that the input string is valid
		if (s == null) {
			throw new NullPointerException();
		} else if (!s.matches("[a-zA-Z]+")) {
			throw new IllegalArgumentException("Input string contains non-alphabetized characters");
		} else if (s.length() < 2) {
			throw new IllegalArgumentException("Input string is too short(< 2 characters) to be considered an anagram");
		}

		// Impose that all strings are lower case, assume that anagrams are
		// case-insensitive
		s = s.toLowerCase();

		// Copy individual letters from input string into an char array
		char[] letters = s.toCharArray();
		
		// Sort the character array using Arrays.sort(char[] c)
		Arrays.sort(letters);

		// Return the character array reassembled as a single string
		return new String(letters);
	}

	/**
	 * A generic method that sorts the input array using an insertion sort and
	 * the input Comparator object
	 * 
	 * @param arr
	 *            The array to be sorted
	 * @param c
	 *            A Comparator object that is used to compare the array elements
	 */
	public static <T> void insertionSort(T[] arr, Comparator<? super T> c) {

		// Cycle through the array elements starting at the second element
		for (int i = 1; i < arr.length; i++) {
			T current = arr[i];
			int j = i - 1;

			// While the current letter is 'smaller' than the letter to its
			// left, swap the letters
			while ((j > -1) && (c.compare(current, arr[j])) < 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = current;
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
		if (sort(s1).equals(sort(s2))) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the largest group of anagrams in the input array of words, in no
	 * particular order Returns an empty array if there are no anagrams in the
	 * input array.
	 * 
	 * If multiple groups of anagrams are of equal size, return the first group
	 * of anagrams.
	 * 
	 * Utilizes areAnagrams(String s1, String s2) and insertionSort(T[] arr,
	 * Comparator<? super T c)
	 * 
	 * @param s
	 *            String array of words to be analyzed
	 */
	public static String[] getLargestAnagramGroup(String[] s) {

		// Return empty array is the input array is also empty.
		if (s == null) {
			return new String[0];
		}

		// Rearranges the elements in the input string array so that anagrams sit adjacent to each other.
		insertionSort(s, new StringComparator());

		// Find the most recurring string in the newly sorted string array.
		String prev = s[0], mostCommon = null;
		int num = 0, max = 0;
		for (int i = 0; i < s.length; i++) {
			if (areAnagrams(prev, s[i])) {
				num++;
			} else {
				if (num > max) {
					max = num;
					mostCommon = s[i - 1];
				}
				num = 1;
				prev = s[i];
			}
		}
		
		// If the highest frequency word occurs only once, then there are no anagrams in the list.
		// Return an empty string array.
		if(max == 1) {
			return new String[0];
		}

		ArrayList<String> tmp = new ArrayList<String>();

		// Add all items from the input array that match the most occurring anagram of anagramList.
		for (int i = 0; i < s.length; i++) {
			if (areAnagrams(mostCommon, s[i])) {
				tmp.add(s[i]);
			}
		}

		return tmp.toArray(new String[tmp.size()]);
	}

	/**
	 * Returns the largest group of anagrams of a list inside of a text file
	 * Returns an empty array if the file is empty or does not exist
	 * 
	 * It is assumed that the file contains one word per line. Utilizes
	 * getLargestAnagramGroup(String[] s)
	 * 
	 * @param filename
	 *            Name of text file containing a list of words
	 */
	public static String[] getLargestAnagramGroup(String filename) {

		try {
			File f = new File(filename);
			in = new Scanner(f);

			ArrayList<String> words = new ArrayList<String>();

			// Return an empty array if the file exists but is empty
			if (!in.hasNext())
				return new String[0];

			// Copy each new word in the file into an arrayList
			while (in.hasNext())
				words.add(in.nextLine());

			// Convert arrayList of words into an array
			String[] array = words.toArray(new String[words.size()]);

			return getLargestAnagramGroup(array);
		}

		// Return an empty array if the file does not exist
		catch (IOException e) {
			return new String[0];
		}
	}
	
	/**
	 * Returns the largest group of anagrams of a list inside of a text file
	 * Returns an empty array if the file is empty or does not exist
	 * 
	 * It is assumed that the file contains one word per line. Utilizes
	 * getLargestAnagramGroup(String[] s)
	 * 
	 * @param filename
	 *            Name of text file containing a list of words
	 */
	public static String[] getLargestAnagramGroupUsingSortMethod(String filename) {

		try {
			File f = new File(filename);
			in = new Scanner(f);

			ArrayList<String> words = new ArrayList<String>();

			// Return an empty array if the file exists but is empty
			if (!in.hasNext())
				return new String[0];

			// Copy each new word in the file into an arrayList
			while (in.hasNext())
				words.add(in.nextLine());

			// Convert arrayList of words into an array
			String[] array = words.toArray(new String[words.size()]);

			return getLargestAnagramGroupUsingSortMethod(array);
		}

		// Return an empty array if the file does not exist
		catch (IOException e) {
			return new String[0];
		}
	}

	/**
	 * Returns the largest group of anagrams in the input array of words, in no particular order. 
	 * Returns an empty array if there are no anagrams in the input array.
	 * 
	 * If multiple groups of anagrams are of equal size, return the first group
	 * of anagrams.
	 * 
	 * Utilizes areAnagrams(String s1, String s2) and Arrays.sort() with the included custom StringComparator class
	 * 
	 * @param s
	 *            String array of words to be analyzed
	 */
	public static String[] getLargestAnagramGroupUsingSortMethod(String[] s) {

		// Return empty array is the input array is also empty.
		if (s == null) {
			return new String[0];
		}

		// Rearranges the elements in the input string array so that anagrams sit adjacent to each other.
		Arrays.sort(s, new ArraySortStringComparator());

		// Find the most recurring string in the newly sorted string array.
		String prev = s[0], mostCommon = null;
		int num = 0, max = 0;
		for (int i = 0; i < s.length; i++) {
			if (areAnagrams(prev, s[i])) {
				num++;
			} else {
				if (num > max) {
					max = num;
					mostCommon = s[i - 1];
				}
				num = 1;
				prev = s[i];
			}
		}
				
		// If the highest frequency word occurs only once, then there are no anagrams in the list.
		// Return an empty string array.
		if(max == 1) {
			return new String[0];
		}

		ArrayList<String> tmp = new ArrayList<String>();

		// Add all items from the input array that match the most occurring anagram of anagramList.
		for (int i = 0; i < s.length; i++) {
			if (areAnagrams(mostCommon, s[i])) {
				tmp.add(s[i]);
			}
		}

		return tmp.toArray(new String[tmp.size()]);
	}
}
