package assign6;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 * Timing Analysis for MyLinkedList class.
 * 
 * Run this class to compare the time performance of MyLinkedList vs ArrayList's
 * addFirst(element), get(index) and remove(index)
 * 
 * This class uses formulas to compare and display the empirically observed
 * running time of a method/algorithm to the expected Big-O behavior.
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @author Erin Parker
 * @version 10/8/2015
 */
public class TimingAnalysis {

	public static void main(String[] args) {
		
		// Run timing analysis on MyLinkedList's addFirst(E element)
		timeAddFirstLinkedList(1000, 1000, 20000, 1000);
		
		// Run timing analysis on ArrayList's addFirst(E element)
		timeAddFirstArrayList(1000, 1000, 20000, 1000);
		
		// Run timing analysis on MyLinkedList's get(int index) method
		timeGetLinkedList(5000, 1000, 20000, 1000);
		
		// Run timing analysis on ArrayList's get(int index) method
		timeGetArrayList(150, 1000, 20000, 1000);
		
		// Run timing analysis on MyLinkedList's remove(int index) method
		timeRemoveLinkedList(200, 1000, 20000, 1000);
		
		// Run timing analysis on ArrayList's remove(int index) method
		timeRemoveArrayList(1500, 1000, 20000, 1000);
	}
	
	/**
	 * Runs a timing analysis on the MyLinkedList's add(int index, e element) method with an increasing problem size
	 * 
	 * @param timesToLoop The number of times to repeat the timing test for the same problem size
	 * @param nStart The initial problem size
	 * @param nStop The ending problem size
	 * @param nStep The amount to increment the problem size after each iteration of the method
	 */
	private static void timeAddFirstLinkedList(int timesToLoop, int nStart, int nStop, int nStep) {
		long startTime, midptTime, stopTime;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println("--------------------  Timing Analysis: void addFirstLinkedList(E element)  ---------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(1)");
		System.out.println("\nN\t\tT(N)\t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("------------------------------------------------------------------------------------------------");

		for (int N = nStart; N <= nStop; N += nStep) { 

			// Create a randomly generated array of words, of uniform length
			String[] wordList = generateStringArray(N);
			
			// Create a LinkedList to add elements into
			MyLinkedList<String> list = new MyLinkedList<String>();
			
			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;
						
			// time the routine
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				list.addFirst(wordList[N/2]);
			}
			midptTime = System.nanoTime();

			// time the empty loops
			for (int i = 0; i < timesToLoop; i++) {
			}

			stopTime = System.nanoTime();

			// compute the average time
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

			System.out.println(
					formatter.format(avgTime) + "\t|\t" + formatter.format(avgTime / (Math.log10(N) / Math.log10(2)))
							+ "\t\t" + formatter.format(avgTime / (N * (Math.log10(N) /  Math.log10(2))) )
							+ "\t\t" + formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N))
							+ "\t\t" + formatter.format(avgTime / (N * N * N)));
		}
		
		System.out.println("------------------------------------------------------------------------------------------------");
	}
	
	/**
	 * Runs a timing analysis on Java's ArrayList add method with an increasing problem size
	 * 
	 * @param timesToLoop The number of times to repeat the timing test for the same problem size
	 * @param nStart The initial problem size
	 * @param nStop The ending problem size
	 * @param nStep The amount to increment the problem size after each iteration of the method
	 */
	private static void timeAddFirstArrayList(int timesToLoop, int nStart, int nStop, int nStep) {
		long startTime, midptTime, stopTime;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println("--------------------  Timing Analysis: void addFirstArrayList(0, item)  ------------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(N)");
		System.out.println("\t This is the worst case since the array must be resized and shifted on each insert.");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("------------------------------------------------------------------------------------------------");

		for (int N = nStart; N <= nStop; N += nStep) { 

			// Create a randomly generated array of words, of uniform length
			String[] wordList = generateStringArray(N);
			
			// Create an ArrayList to add elements into
			ArrayList<String> list = generateArrayList(wordList);
			
			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;
						
			// time the routine 
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				list.add(0, wordList[N/2]);
			}
			midptTime = System.nanoTime();

			// time the empty loops
			for (int i = 0; i < timesToLoop; i++) {
			}

			stopTime = System.nanoTime();

			// compute the average time
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

			System.out.println(
					formatter.format(avgTime) + "\t|\t" + formatter.format(avgTime / (Math.log10(N) / Math.log10(2)))
							+ "\t\t" + formatter.format(avgTime / (N * (Math.log10(N) /  Math.log10(2))) )
							+ "\t\t" + formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N))
							+ "\t\t" + formatter.format(avgTime / (N * N * N)));
		}
		
		System.out.println("------------------------------------------------------------------------------------------------");
	}
	
	/**
	 * Runs a timing analysis on MyLinkedList's get(int index) method with an increasing problem size
	 * 
	 * @param timesToLoop The number of times to repeat the timing test for the same problem size
	 * @param nStart The initial problem size
	 * @param nStop The ending problem size
	 * @param nStep The amount to increment the problem size after each iteration of the method
	 */
	private static void timeGetLinkedList(int timesToLoop, int nStart, int nStop, int nStep) {
		long startTime, midptTime, stopTime;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println("--------------------  Timing Analysis: void timeGetLinkedList(int index) -----------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(N)");
		System.out.println("\t This get method must cycle through the entire LinkedList to get to the right index.");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("------------------------------------------------------------------------------------------------");

		for (int N = nStart; N <= nStop; N += nStep) { 

			// Create a randomly generated array of words, of uniform length
			String[] wordList = generateStringArray(N);
			
			// Create a LinkedList containing wordList
			MyLinkedList<String> list = generateLinkedList(wordList);
			
			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;
						
			// time the routine 
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				list.get(N/2);
			}
			midptTime = System.nanoTime();

			// time the empty loops
			for (int i = 0; i < timesToLoop; i++) {
			}

			stopTime = System.nanoTime();

			// compute the average time
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

			System.out.println(
					formatter.format(avgTime) + "\t|\t" + formatter.format(avgTime / (Math.log10(N) / Math.log10(2)))
							+ "\t\t" + formatter.format(avgTime / (N * (Math.log10(N) /  Math.log10(2))) )
							+ "\t\t" + formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N))
							+ "\t\t" + formatter.format(avgTime / (N * N * N)));
		}
		
		System.out.println("------------------------------------------------------------------------------------------------");
	}
	
	/**
	 * Runs a timing analysis on the Java's ArrayList get(int index) method with an increasing problem size
	 * 
	 * @param timesToLoop The number of times to repeat the timing test for the same problem size
	 * @param nStart The initial problem size
	 * @param nStop The ending problem size
	 * @param nStep The amount to increment the problem size after each iteration of the method
	 */
	private static void timeGetArrayList(int timesToLoop, int nStart, int nStop, int nStep) {
		long startTime, midptTime, stopTime;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println("--------------------  Timing Analysis: timeGetArrayList(int index)  ----------------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(1)");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("------------------------------------------------------------------------------------------------");

		for (int N = nStart; N <= nStop; N += nStep) { 

			// Create a randomly generated array of words, of uniform length
			String[] wordList = generateStringArray(N);
			
			// Create an ArrayList containing wordList
			ArrayList<String> list = generateArrayList(wordList);
			
			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;
						
			// time the routine 
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				list.get(N/2);
			}
			midptTime = System.nanoTime();

			// time the empty loop
			for (int i = 0; i < timesToLoop; i++) {
			}

			stopTime = System.nanoTime();

			// compute the average time
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

			System.out.println(
					formatter.format(avgTime) + "\t|\t" + formatter.format(avgTime / (Math.log10(N) / Math.log10(2)))
							+ "\t\t" + formatter.format(avgTime / (N * (Math.log10(N) /  Math.log10(2))) )
							+ "\t\t" + formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N))
							+ "\t\t" + formatter.format(avgTime / (N * N * N)));
		}
		
		System.out.println("------------------------------------------------------------------------------------------------");
	}
	
	/**
	 * Runs a timing analysis on MyLinkedList's remove(int index) method with an increasing problem size
	 * 
	 * @param timesToLoop The number of times to repeat the timing test for the same problem size
	 * @param nStart The initial problem size
	 * @param nStop The ending problem size
	 * @param nStep The amount to increment the problem size after each iteration of the method
	 */
	private static void timeRemoveLinkedList(int timesToLoop, int nStart, int nStop, int nStep) {
		long startTime, midptTime, stopTime;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println("----------------------  Timing Analysis: timeRemoveLinkedList(int index) -----------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(N)");
		System.out.println("\t This remove method must traverse through the LinkedList to get to the right index.");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("------------------------------------------------------------------------------------------------");

		for (int N = nStart; N <= nStop; N += nStep) { 

			// Create a randomly generated array of words, of uniform length
			String[] wordList = generateStringArray(N);	
			
			// Create an ArrayList of LinkedLists
			ArrayList<MyLinkedList<String>> listArr = new ArrayList<MyLinkedList<String>>();
			
			// Populate the ArrayList with LinkedLists
			for(int i = 0; i < timesToLoop; i++) {
				listArr.add(generateLinkedList(wordList));
			}	
			
			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;
						
			// time the routine 
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				listArr.get(i).remove(N/2);
			}
			midptTime = System.nanoTime();

			// time the empty loop
			for (int i = 0; i < timesToLoop; i++) {
			}

			stopTime = System.nanoTime();

			// compute the average time
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

			System.out.println(
					formatter.format(avgTime) + "\t|\t" + formatter.format(avgTime / (Math.log10(N) / Math.log10(2)))
							+ "\t\t" + formatter.format(avgTime / (N * (Math.log10(N) /  Math.log10(2))) )
							+ "\t\t" + formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N))
							+ "\t\t" + formatter.format(avgTime / (N * N * N)));
		}
		
		System.out.println("------------------------------------------------------------------------------------------------");
	}
	
	/**
	 * Runs a timing analysis on ArrayList's remove(int index) method with an increasing problem size
	 * 
	 * @param timesToLoop The number of times to repeat the timing test for the same problem size
	 * @param nStart The initial problem size
	 * @param nStop The ending problem size
	 * @param nStep The amount to increment the problem size after each iteration of the method
	 */
	private static void timeRemoveArrayList(int timesToLoop, int nStart, int nStop, int nStep) {
		long startTime, midptTime, stopTime; 

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println("----------------------  Timing Analysis: timeRemoveArrayList(int index) ------------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(N)");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("------------------------------------------------------------------------------------------------");

		for (int N = nStart; N <= nStop; N += nStep) { 

			// Create a randomly generated array of words, of uniform length
			String[] wordList = generateStringArray(N);
			
			// Create an ArrayList of ArrayLists
			ArrayList<ArrayList<String>> listArr = new ArrayList<ArrayList<String>>();
			
			// Populate the ArrayList with ArrayLists, each containing wordList
			for(int i = 0; i < timesToLoop; i++) {
				listArr.add(generateArrayList(wordList));
			}	
			
			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;
						
			// time the routine 
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				listArr.get(i).remove(N/2);
			}
			midptTime = System.nanoTime();

			// time the empty loops
			for (int i = 0; i < timesToLoop; i++) {
			}

			stopTime = System.nanoTime();

			// compute the average time
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

			System.out.println(
					formatter.format(avgTime) + "\t|\t" + formatter.format(avgTime / (Math.log10(N) / Math.log10(2)))
							+ "\t\t" + formatter.format(avgTime / (N * (Math.log10(N) /  Math.log10(2))) )
							+ "\t\t" + formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N))
							+ "\t\t" + formatter.format(avgTime / (N * N * N)));
		}
		
		System.out.println("------------------------------------------------------------------------------------------------");
	}
	
	/**
	 * Returns a string array of a specified size, filled with randomly
	 * generated strings of length 5. 
	 * Characters range from a to z
	 * 
	 * @param size
	 *            Number of words to generate and return in a string array
	 */
	private static String[] generateStringArray(int size) {

		String[] arr = new String[size];
		Random rn = new Random();
		int randNum;
		int length = 5;
		char c;

		// Number of words to generate
		for (int i = 0; i < arr.length; i++) {
			// Initialize value at i to non-null
			arr[i] = "";
			
			// Length of word to generate
			for (int j = 0; j < length; j++) {
				randNum = (rn.nextInt(122 - 97 + 1) + 97);
				c = (char) randNum;	
				arr[i] += c;
			}
		}

		return arr;
	}
	
	/**
	 * Generic method for populating a LinkedList from an array of items
	 * 
	 * @param itemList Array of items to be added to the LinkedList 
	 * @return the populated LinkedList
	 */
	private static MyLinkedList<String> generateLinkedList(String[] itemList) {
		
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		for(int i = 0; i < itemList.length; i++) {
			list.add(i, itemList[i]);
		}
		
		return list;
	}
	
	/**
	 * Generic method for populating an ArrayList from an array of items
	 * 
	 * @param itemList Array of items to be added to the ArrayList 
	 * @return the populated ArrayList
	 */
	private static ArrayList<String> generateArrayList(String[] itemList) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i = 0; i < itemList.length; i++) {
			list.add(i, itemList[i]);
		}
		
		return list;
	}
}