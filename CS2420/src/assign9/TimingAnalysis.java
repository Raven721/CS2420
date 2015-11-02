package assign9;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Performs a timing analysis on various methods in the BinarySearchTree class
 * and compares these results to Java's TreeSet class.
 * 
 * This class uses formulas to compare and display the empirically observed
 * running time of a method/algorithm to the expected Big-O behavior.
 * 
 * @author Tim Ellenberger, ellenber
 * @author John Strasser, strasser
 * @author Erin Parker
 * @version 10/29/2015
 */
public class TimingAnalysis {

	public static void main(String[] args) {
		int timesToLoop = 2000;
		boolean rand = false;
		
		//Time a sorted BST for finding all elements
		timeBSTContains(timesToLoop, 2000, 22000, 2000, rand, "Contains");
		
		//Time a random BST for finding all elements
		rand = true;
		timeBSTContains(timesToLoop, 2000, 22000, 2000, rand, "Contains");
		
		/////////// BinarySearchTree vs Java's TreeSet /////////////
		
		
	}

	private static void timeBSTContains(int timesToLoop, int startSize, int stopSize, int stepSize, boolean random, String timingMethod) {
		long startTime, midptTime, stopTime;
		
		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out
				.println("------------------- GraphUtil Timing Analysis: " + timingMethod + (random ? " Inserted Radomized" : " Inserted in-order") + " ----------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | ");
		System.out.println("\nN\tT(N)\t\t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");

		for (int n = startSize; n <= stopSize; n += stepSize) {

			// Create a data set to work with
			List<Integer> setData = new LinkedList<>();
			for (int i = 0; i <n; i++) {
				setData.add(i);
			}
			// random will randomly permute the elements
			if(random) {
				Collections.shuffle(setData);
			}
			
			BinarySearchTree<Integer> myBST = new BinarySearchTree<>();
			myBST.addAll(setData);
			
			System.out.print(n + "\t");

			// Let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;

			// Time the routine
			Random rnd = new Random();
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				myBST.contains(rnd.nextInt(n));
			}

			midptTime = System.nanoTime();
			int temp;
			// Time the empty loops
			for (int i = 0; i < timesToLoop; i++) {
				temp = rnd.nextInt(n);
			}

			stopTime = System.nanoTime();

			// Compute the average time
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

			System.out.println(formatter.format(avgTime) + "\t\t|\t"
					+ formatter.format(avgTime / (Math.log10(n) / Math.log10(2))) + "\t\t"
					+ formatter.format(avgTime / (n * (Math.log10(n) / Math.log10(2)))) + "\t\t"
					+ formatter.format(avgTime / n) + "\t\t"
					+ formatter.format(avgTime / (n * n)) + "\t\t"
					+ formatter.format(avgTime / (n * n * n)));
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");	
	}
	
	
}
