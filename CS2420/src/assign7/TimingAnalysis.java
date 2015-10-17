package assign7;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Timing Analysis for the MyStack and MyPriorityQueue classes.
 * 
 * Execute this class to measure the time performance of all of MyStack's
 * methods and MyPriorityQueue's findMin and insert methods.
 * 
 * This class uses formulas to compare and display the empirically observed
 * running time of a method/algorithm to the expected Big-O behavior.
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @author Erin Parker
 * @version 10/22/2015
 */
public class TimingAnalysis {

	public static void main(String[] args) {
		// Run timing analysis on MyStack's clear() method
		timeMyStack("clear()", 320, 100000, 2000000, 100000);

		// Run timing analysis on MyStack's isEmpty() method
		timeMyStack("isEmpty()", 125, 100000, 2000000, 100000);

		// Run timing analysis on MyStack's peek() method
		timeMyStack("peek()", 250, 100000, 2000000, 100000);

		// Run timing analysis on MyStack's pop() method
		timeMyStack("pop()", 5000, 100000, 2000000, 100000);

		// Run timing analysis on MyStack's push(E item) method
		timeMyStack("push(E item)", 5000, 100000, 2000000, 100000);

		// Run timing analysis on MyStack's size() method
		timeMyStack("size()", 5000, 100000, 2000000, 100000);
		
		// Run timing analysis on MyPriorityQueue's findMin() method
		timeMyPriorityQueue("findMin()", 300, 100000, 2000000, 100000);

		// Run timing analysis on MyPriorityQueue's insert(E item) method
		timeMyPriorityQueue("insert(E item)", 5000, 100000, 2000000, 100000);
	}

	/**
	 * Runs a timing analysis on the MyStack's methods with an increasing
	 * problem size
	 * 
	 * @param timingMethod
	 *            The name of the method to be timed
	 * @param timesToLoop
	 *            The number of times to repeat the timing test for the same
	 *            problem size
	 * @param nStart
	 *            The initial problem size
	 * @param nStop
	 *            The ending problem size
	 * @param nStep
	 *            The amount to increment the problem size after each iteration
	 *            of the method
	 */
	private static void timeMyStack(String timingMethod, int timesToLoop, int nStart, int nStop, int nStep) {
		long startTime, midptTime, stopTime;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E00");

		System.out.println("----------------------------- MyStack Timing Analysis: " + timingMethod + " ----------------------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(1)");
		System.out.println("\nN\tT(N)\t\t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("---------------------------------------------------------------------------------------------------------");

		for (int N = nStart; N <= nStop; N += nStep) {

			// Create arrays/data here...
			// Create a randomly generated array of words, of uniform length
			String[] wordList = generateStringArray(N);
			
			// Create an ArrayList containing wordList
			MyStack<String> stack = generateStack(wordList);
			
			System.out.print(N + "\t");
		
			// Let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;
			
			// Time the routine
			startTime = System.nanoTime();
			if(timingMethod.equals("clear()")) {
				for (int i = 0; i < timesToLoop; i++) {
					stack.clear();
				}
			} else if(timingMethod.equals("isEmpty()")) {
				for (int i = 0; i < timesToLoop; i++) {
					stack.isEmpty();
				}
			} else if(timingMethod.equals("peek()")) {
				for (int i = 0; i < timesToLoop; i++) {
					stack.peek();
				}
			} else if(timingMethod.equals("pop()")) {
				for (int i = 0; i < timesToLoop; i++) {
					stack.pop();
				}
			} else if(timingMethod.equals("push(E item)")) {
				for (int i = 0; i < timesToLoop; i++) {
					stack.push("New Item");
				}
			} else if(timingMethod.equals("size()")) {
				for (int i = 0; i < timesToLoop; i++) {
					stack.size();
				}
			}
			
			midptTime = System.nanoTime();

			// Time the empty loops
			if(timingMethod.equals("clear()")) {
				for (int i = 0; i < timesToLoop; i++) {
				}
			} else if(timingMethod.equals("isEmpty()")) {
				for (int i = 0; i < timesToLoop; i++) {
				}
			} else if(timingMethod.equals("peek()")) {
				for (int i = 0; i < timesToLoop; i++) {
				}
			} else if(timingMethod.equals("pop()")) {
				for (int i = 0; i < timesToLoop; i++) {
				}
			} else if(timingMethod.equals("push(E item)")) {
				for (int i = 0; i < timesToLoop; i++) {
				}
			} else if(timingMethod.equals("size()")) {
				for (int i = 0; i < timesToLoop; i++) {
				}
			}
			
			stopTime = System.nanoTime();
			
			// Compute the average time
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

			System.out.println(
					formatter.format(avgTime) + "\t|\t" + formatter.format(avgTime / (Math.log10(N) / Math.log10(2)))
							+ "\t" + formatter.format(avgTime / (N * (Math.log10(N) / Math.log10(2)))) + "\t"
							+ formatter.format(avgTime / N) + "\t" + formatter.format(avgTime / (N * N)) + "\t"
							+ formatter.format(avgTime / (N * N * N)));
		}
		System.out.println("---------------------------------------------------------------------------------------------------------");
	}
	
	/**
	 * Runs a timing analysis on the MyStack's methods with an increasing
	 * problem size
	 * 
	 * @param timingMethod
	 *            The name of the method to be timed
	 * @param timesToLoop
	 *            The number of times to repeat the timing test for the same
	 *            problem size
	 * @param nStart
	 *            The initial problem size
	 * @param nStop
	 *            The ending problem size
	 * @param nStep
	 *            The amount to increment the problem size after each iteration
	 *            of the method
	 */
	private static void timeMyPriorityQueue(String timingMethod, int timesToLoop, int nStart, int nStop, int nStep) {
		long startTime, midptTime, stopTime;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E00");

		System.out.println("------------------- MyPriorityQueue Timing Analysis: " + timingMethod + " ----------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(1)");
		System.out.println("\nN\tT(N)\t\t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("------------------------------------------------------------------------------------------------");

		for (int N = nStart; N <= nStop; N += nStep) {

			// Create arrays/data here...
			// Create a randomly generated array of words, of uniform length
			String[] wordList = generateStringArray(N);
			
			// Create an ArrayList containing wordList
			MyPriorityQueue<String> queue = generateQueue(wordList);
			
			System.out.print(N + "\t");
		
			// Let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;
			
			// Time the routine
			startTime = System.nanoTime();
			if(timingMethod.equals("findMin()")) {
				for (int i = 0; i < timesToLoop; i++) {
					queue.findMin();
				}
			} else if(timingMethod.equals("insert(E item)")) {
				for (int i = 0; i < timesToLoop; i++) {
					queue.insert("New Item");
				}
			}
			
			midptTime = System.nanoTime();

			// Time the empty loops
			if(timingMethod.equals("findMin()")) {
				for (int i = 0; i < timesToLoop; i++) {
				}
			} else if(timingMethod.equals("insert(E item)")) {
				for (int i = 0; i < timesToLoop; i++) {
				}
			}
			
			stopTime = System.nanoTime();
			
			// Compute the average time
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

			System.out.println(
					formatter.format(avgTime) + "\t|\t" + formatter.format(avgTime / (Math.log10(N) / Math.log10(2)))
							+ "\t" + formatter.format(avgTime / (N * (Math.log10(N) / Math.log10(2)))) + "\t"
							+ formatter.format(avgTime / N) + "\t" + formatter.format(avgTime / (N * N)) + "\t"
							+ formatter.format(avgTime / (N * N * N)));
		}
		System.out.println("---------------------------------------------------------------------------------------------------------");
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
	 * Generic method for populating a MyStack stack from an array of items
	 * 
	 * @param itemList Array of items to be added to the MyStack 
	 * @return the populated MyStack
	 */
	private static MyStack<String> generateStack(String[] itemList) {
		MyStack<String> stack = new MyStack<String>();
		
		for(int i = 0; i < itemList.length; i++) {
			stack.push(itemList[i]);
		}
		
		return stack;
	}
	
	/**
	 * Generic method for populating a MyPriorityQueue queue from an array of items
	 * 
	 * @param itemList Array of items to be added to the MyPriorityQueue 
	 * @return the populated MyPriorityQueue
	 */
	private static MyPriorityQueue<String> generateQueue(String[] itemList) {
		MyPriorityQueue<String> queue = new MyPriorityQueue<String>();
		
		for(int i = 0; i < itemList.length; i++) {
			queue.insert(itemList[i]);
		}
		
		return queue;
	}
}
