package assign7;

import java.text.DecimalFormat;

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
		timeMyStack("clear()", 500, 1000, 10000, 1000);

		// Run timing analysis on MyStack's isEmpty() method
		timeMyStack("isEmpty()", 500, 1000, 10000, 1000);

		// Run timing analysis on MyStack's peek() method
		timeMyStack("peek()", 500, 1000, 10000, 1000);

		// Run timing analysis on MyStack's pop() method
		timeMyStack("pop()", 500, 1000, 10000, 1000);

		// Run timing analysis on MyStack's push(E item) method
		timeMyStack("push(E item)", 500, 1000, 10000, 1000);

		// Run timing analysis on MyStack's size() method
		timeMyStack("size()", 15, 500, 10000, 1000);

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
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println("----------------------------  Timing Analysis: " + timingMethod + " ----------------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(1)");
		System.out.println("\nN\t\tT(N)\t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("------------------------------------------------------------------------------------------------");

		for (int N = nStart; N <= nStop; N += nStep) {

			// Create arrays/data here...
			// Do Stuff
			
			System.out.print(N + "\t");
		
			// Let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;
			
			// Time the routine
			startTime = System.nanoTime();
			// Do stuff...
			
			midptTime = System.nanoTime();

			// Time the empty loops
			// Do stuff...
			
			stopTime = System.nanoTime();
			
			// Compute the average time
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

			System.out.println(
					formatter.format(avgTime) + "\t|\t" + formatter.format(avgTime / (Math.log10(N) / Math.log10(2)))
							+ "\t\t" + formatter.format(avgTime / (N * (Math.log10(N) / Math.log10(2)))) + "\t\t"
							+ formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N)) + "\t\t"
							+ formatter.format(avgTime / (N * N * N)));
		}
		System.out.println("------------------------------------------------------------------------------------------------");
	}
}
