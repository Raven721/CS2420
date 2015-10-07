package assign6;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 * Timing Analysis for MyLinkedList class.
 * 
 * This class uses formulas to compare and display the empirically observed
 * running time of a method/algorithm to the expected Big-O behavior.
 * 
 * Let T(N) be the running time observed, and let F(N) be the Big-O expected.
 * 
 * If T(N) / F(N) converges to a positive value, then F(N) correctly represents
 * the growth rate of the running times.
 * 
 * If T(N) / F(N) converges to 0, then F(N) is an overestimate of the growth
 * rate of the running times.
 * 
 * If T(N) / F(N) converges to infinity, then F(N) is an underestimate of the
 * growth rate of the running times.
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @author Erin Parker
 * @version 10/8/2015
 */
public class TimingAnalysis {

	public static void main(String[] args) {
		System.out.println("Hello World test meow what");
		
		// Run timing analysis on MyLinkedList's addFirst(E element)
		timeAddFirstLinkedList();
		
		// Run timing analysis on ArrayList's addFirst(E element)
		timeAddFirstArrayList();
		
		// Run timing analysis on MyLinkedList's get(int index) method
		timeGetLinkedList();
		
		// Run timing analysis on ArrayList's get(int index) method
		timeGetArrayList();
		
		// Run timing analysis on MyLinkedList's get(int index) method
		timeRemoveLinkedList();
		
		// Run timing analysis on ArrayList's get(int index) method
		timeRemoveArrayList();
	}
	
	/**
	 * Runs a timing analysis on the MyLinkedList's add(int index, e element) method with an increasing problem size
	 */
	private static void timeAddFirstLinkedList() {
		long startTime, midptTime, stopTime;
		long timesToLoop = 150; 
		MyLinkedList<String> list = new MyLinkedList<String>();

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println("--------------------  Timing Analysis: void addFirst(E element)  -------------------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(1)");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("------------------------------------------------------------------------------------------------");

		for (int N = 10000; N <= 200000; N += 10000) { 

			String[] wordList = generateStringArray(N);
			
			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;
						
			// time the routine areAnagrams
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				for(int j = 0; j < N; j++)
					list.addFirst(wordList[j]);
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
	 */
	private static void timeAddFirstArrayList() {
		long startTime, midptTime, stopTime;
		long timesToLoop = 150; 
		ArrayList<String> list = new ArrayList<String>();

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println("--------------------  Timing Analysis: void addArrayList(0, item)  -------------------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(N)");
		System.out.println("\t\t\t This is the worst case since the array must be resized and shifted on each insert.");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("------------------------------------------------------------------------------------------------");

		for (int N = 1000; N <= 20000; N += 1000) { 

			String[] wordList = generateStringArray(N);
			
			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;
						
			// time the routine areAnagrams
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				for(int j = 0; j < N; j++)
					list.add(0, wordList[j]);
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
	 */
	private static void timeGetLinkedList() {
		long startTime, midptTime, stopTime;
		long timesToLoop = 150; 
		MyLinkedList<String> list = new MyLinkedList<String>();

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println("--------------------  Timing Analysis: void timeGetLinkedList(int index) -----------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(N)");
		System.out.println("\t\t\t This get method must cycle through the entire LinkedList to get to the right index.");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("------------------------------------------------------------------------------------------------");

		for (int N = 1000; N <= 20000; N += 1000) { 

			String[] wordList = generateStringArray(N);
			
			for(int i = 0; i < wordList.length; i++) {
				list.add(i, wordList[i]);
			}
			
			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;
						
			// time the routine areAnagrams
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				for(int j = 0; j < N; j++)
					list.get(j);
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
	 */
	private static void timeGetArrayList() {
		long startTime, midptTime, stopTime;
		long timesToLoop = 150; 
		ArrayList<String> list = new ArrayList<String>();

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println("--------------------  Timing Analysis: timeGetArrayList(int index)  ----------------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(1)");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("------------------------------------------------------------------------------------------------");

		for (int N = 1000; N <= 20000; N += 1000) { 

			String[] wordList = generateStringArray(N);
			
			for(int i = 0; i < wordList.length; i++) {
				list.add(i, wordList[i]);
			}
			
			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;
						
			// time the routine areAnagrams
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				for(int j = 0; j < N; j++)
					list.get(j);
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
	 * Runs a timing analysis on MyLinkedList's remove(int index) method with an increasing problem size
	 */
	private static void timeRemoveLinkedList() {
		long startTime, midptTime, stopTime;
		long timesToLoop = 150; 
		MyLinkedList<String> list = new MyLinkedList<String>();

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println("--------------------  Timing Analysis: void timeGetLinkedList(int index) -----------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(N)");
		System.out.println("\t\t\t This remove method must cycle through the entire LinkedList to get to the right index.");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("------------------------------------------------------------------------------------------------");

		for (int N = 1000; N <= 20000; N += 1000) { 

			String[] wordList = generateStringArray(N);
			
			for(int i = 0; i < wordList.length; i++) {
				list.add(i, wordList[i]);
			}
			
			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;
						
			// time the routine areAnagrams
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				for(int j = 0; j < N; j++)
					list.remove(j);
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
	 * Runs a timing analysis on ArrayList's remove(int index) method with an increasing problem size
	 */
	private static void timeRemoveArrayList() {
		long startTime, midptTime, stopTime;
		long timesToLoop = 150; 
		ArrayList<String> list = new ArrayList<String>();

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println("--------------------  Timing Analysis: void timeGetLinkedList(int index) -----------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(1)");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("------------------------------------------------------------------------------------------------");

		for (int N = 1000; N <= 20000; N += 1000) { 

			String[] wordList = generateStringArray(N);
			
			for(int i = 0; i < wordList.length; i++) {
				list.add(i, wordList[i]);
			}
			
			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;
						
			// time the routine areAnagrams
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				for(int j = 0; j < N; j++)
					list.remove(j);
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
	 * generated strings ranging from 4 to 6 characters in length. 
	 * Characters range from a to z
	 * 
	 * @param size
	 *            Number of words to generate and return in a string array
	 */
	private static String[] generateStringArray(int size) {

		String[] arr = new String[size];
		Random rn = new Random();
		int randNum;
		int randLength;
		char c;

		// Number of words to generate
		for (int i = 0; i < arr.length; i++) {
			// Initialize value at i to non-null
			arr[i] = "";
			
			// Length of word to generate
			randLength = rn.nextInt(6 - 4 + 1) + 4;
			for (int j = 0; j < randLength; j++) {
				randNum = (rn.nextInt(122 - 97 + 1) + 97);
				c = (char) randNum;	
				arr[i] += c;
			}
		}

		return arr;
	}
}