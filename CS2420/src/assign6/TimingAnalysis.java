package assign6;

import java.text.DecimalFormat;
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
		
		// Run timing analysis on addFirst(E element)
		timeAddFirst();

	}
	
	/**
	 * Runs a timing analysis on the areAnagrams method with an increasing problem size
	 */
	private static void timeAddFirst() {
		long startTime, midptTime, stopTime;
		long timesToLoop = 150; 
		MyLinkedList<String> list = new MyLinkedList<String>();

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println("--------------------  Timing Analysis: void addFirst(E element)  -------------------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(1)");
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