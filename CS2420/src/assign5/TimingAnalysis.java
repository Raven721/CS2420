package assign5;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
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
 * @version 10/1/2015
 */
public class TimingAnalysis {

	public static void main(String[] args) {
		// Run timing analysis on the changing sort times as
		// insertionSortThreshold changes
		timeMergeSortThresholdExperiment();

		// Run timing analysis on the changing sort times as
		// pivotStrategy changes
		timeQuickSortThresholdExperiment();

		// Run timing analysis on mergesort(ArrayList<T> array) with best
		timeBestCaseMergeSort();
		// Run timing analysis on mergesort(ArrayList<T> array)
		timeAverageCaseMergeSort();
		// Run timing analysis on mergesort(ArrayList<T> array)
		timeWorstCaseMergeSort();

		// Run timing analysis on quicksort(ArrayList<T> array) with best case, under each pivot strategy
		timeBestCaseQuickSort(0);
		timeBestCaseQuickSort(1);
		timeBestCaseQuickSort(2);
		// Run timing analysis on quicksort(ArrayList<T> array) with best average, under each pivot strategy
		timeAverageCaseQuickSort(0);
		timeAverageCaseQuickSort(1);
		timeAverageCaseQuickSort(2);
		// Run timing analysis on quicksort(ArrayList<T> array) with best worst, under each pivot strategy
		timeWorstCaseQuickSort(0);
		timeWorstCaseQuickSort(1);
		timeWorstCaseQuickSort(2);
	}

	/**
	 * Run timing analysis on the changing sort times as insertionSortThreshold
	 * changes on a permuted list
	 */
	private static void timeMergeSortThresholdExperiment() {
		long startTime, midptTime, stopTime;
		long timesToLoop = 200;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println(
				"----------------------  Timing Analysis: mergesort Threshold Experiment ------------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop);
		System.out.println("\nThreshold\tN\tT(N)  \t|\tInsertion Sort Threshold");
		System.out.println(
				"------------------------------------------------------------------------------------------------");

		for (int k = 5; k >= 1; k--) {
			System.out.println("\t\t\t---------- InsertionSort Threshold: " + k + " -------------\n");
			for (int N = 1000000; N <= 20000000; N += 1000000) {
				ArrayList<Integer> sortedList = SortUtil.generatePermutedOrder(N);

				// Set the threshold, print the threshold
				if (k == 1) {
					SortUtil.setInsertionSortThreshold(1);
					System.out.print("(1)\t");
				} else if (k == 2) {
					SortUtil.setInsertionSortThreshold(N / 2);
					System.out.print("(N / 2)\t");
				} else if (k == 3) {
					SortUtil.setInsertionSortThreshold(N / 4);
					System.out.print("(N / 4)\t");
				} else if (k == 4) {
					SortUtil.setInsertionSortThreshold(N / 10);
					System.out.print("(N / 10)\t");
				} else if (k == 5) {
					SortUtil.setInsertionSortThreshold(N / 20);
					System.out.print("(N / 20)\t");
				}

				System.out.print(N + "\t");

				// let things stabilize
				startTime = System.nanoTime();
				while (System.nanoTime() - startTime < 1000000000)
					;

				// time the mergesort routine
				startTime = System.nanoTime();
				for (int i = 0; i < timesToLoop; i++) {
					SortUtil.mergesort(sortedList);
				}
				midptTime = System.nanoTime();

				// time the empty loop
				for (int i = 0; i < timesToLoop; i++) {
				}

				stopTime = System.nanoTime();

				// compute the average time
				double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

				System.out.println(formatter.format(avgTime) + "\t|\t" + formatter.format(k));
			}

			System.out.println(
					"------------------------------------------------------------------------------------------------");
		}
	}

	/**
	 * Run timing analysis on the changing sort times as insertionSortThreshold
	 * changes on a permuted list
	 */
	private static void timeQuickSortThresholdExperiment() {
		long startTime, midptTime, stopTime;
		long timesToLoop = 200;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println(
				"-----------------------  Timing Analysis: quicksort Pivot Experiment ---------------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop);
		System.out.println("\nPivot  \t\tN\tT(N)  \t|\tInsertion Sort Threshold");
		System.out.println(
				"------------------------------------------------------------------------------------------------");

		for (int k = 0; k <= 2; k++) {
			System.out.println("\t\t\t---------- Pivot Strategy: " + k + " -------------\n");
			for (int N = 100000; N <= 2000000; N += 100000) {
				ArrayList<Integer> sortedList = SortUtil.generatePermutedOrder(N);
				SortUtil.setInsertionSortThreshold(N / 20);

				// Set the pivot, print the pivot
				if (k == 0) {
					SortUtil.setPivotStrategy(0);
					System.out.print("Middle Element\t");
				} else if (k == 1) {
					SortUtil.setPivotStrategy(1);
					System.out.print("First Element\t");
				} else if (k == 2) {
					SortUtil.setPivotStrategy(2);
					System.out.print("Median of Three\t");
				}
				System.out.print(N + "\t");

				// let things stabilize
				startTime = System.nanoTime();
				while (System.nanoTime() - startTime < 1000000000)
					;

				// time the mergesort routine
				startTime = System.nanoTime();
				for (int i = 0; i < timesToLoop; i++) {
					SortUtil.quicksort(sortedList);
				}
				midptTime = System.nanoTime();

				// time the empty loop
				for (int i = 0; i < timesToLoop; i++) {
				}

				stopTime = System.nanoTime();

				// compute the average time
				double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

				// System.out.println(avgTime);
				System.out.println(formatter.format(avgTime) + "\t|\t" + formatter.format(k));
			}

			System.out.println(
					"------------------------------------------------------------------------------------------------");
		}
	}

	/**
	 * Runs a timing analysis on the mergesort method with a best case problem
	 * set
	 */
	private static void timeBestCaseMergeSort() {
		long startTime, midptTime, stopTime;
		long timesToLoop = 200;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println(
				"---------------------------  Timing Analysis: mergesort(Best Case)  ----------------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(NlogN)");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println(
				"------------------------------------------------------------------------------------------------");

		for (int N = 100000; N <= 2000000; N += 100000) {

			SortUtil.setInsertionSortThreshold(N / 20);
			ArrayList<Integer> sortedList = SortUtil.generateSortedOrder(N);

			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;

			// time the mergesort routine
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				SortUtil.mergesort(sortedList);
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
							+ "\t\t" + formatter.format(avgTime / (N * (Math.log10(N) / Math.log10(2)))) + "\t\t"
							+ formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N)) + "\t\t"
							+ formatter.format(avgTime / (N * N * N)));
		}

		System.out.println(
				"------------------------------------------------------------------------------------------------");
	}

	/**
	 * Runs a timing analysis on the mergesort method with an average
	 * case(Permuted) problem set
	 */
	private static void timeAverageCaseMergeSort() {
		long startTime, midptTime, stopTime;
		long timesToLoop = 200;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println(
				"---------------  Timing Analysis: mergesort(Average Case: Permuted Order List)  ----------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(NlogN)");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println(
				"------------------------------------------------------------------------------------------------");

		for (int N = 100000; N <= 2000000; N += 100000) {

			SortUtil.setInsertionSortThreshold(N / 20);
			ArrayList<Integer> sortedList = SortUtil.generatePermutedOrder(N);

			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;

			// time the mergesort routine
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				SortUtil.mergesort(sortedList);
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
							+ "\t\t" + formatter.format(avgTime / (N * (Math.log10(N) / Math.log10(2)))) + "\t\t"
							+ formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N)) + "\t\t"
							+ formatter.format(avgTime / (N * N * N)));
		}

		System.out.println(
				"------------------------------------------------------------------------------------------------");
	}

	/**
	 * Runs a timing analysis on the mergesort method with a worst
	 * case(descending order) problem set
	 */
	private static void timeWorstCaseMergeSort() {
		long startTime, midptTime, stopTime;
		long timesToLoop = 200;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println(
				"----------------  Timing Analysis: mergesort(Worst Case: Descending Order List)  ---------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(NlogN)");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println(
				"------------------------------------------------------------------------------------------------");

		for (int N = 100000; N <= 2000000; N += 100000) {

			SortUtil.setInsertionSortThreshold(N / 20);
			ArrayList<Integer> reverseSortedList = SortUtil.generateReverseSortedOrder(N);

			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;

			// time the mergesort routine
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				SortUtil.mergesort(reverseSortedList);
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
							+ "\t\t" + formatter.format(avgTime / (N * (Math.log10(N) / Math.log10(2)))) + "\t\t"
							+ formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N)) + "\t\t"
							+ formatter.format(avgTime / (N * N * N)));
		}

		System.out.println(
				"------------------------------------------------------------------------------------------------");
	}

	/**
	 * Runs a timing analysis on the quicksort method with a best case problem
	 * set
	 */
	private static void timeBestCaseQuickSort(int pivotStrategy) {
		long startTime, midptTime, stopTime;
		long timesToLoop = 200;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println(
				"------------------  Timing Analysis: quicksort(Best Case: Sorted Order List)  ------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | pivotStrategy: " + pivotStrategy);
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println(
				"------------------------------------------------------------------------------------------------");

		for (int N = 100000; N <= 2000000; N += 100000) {

			// Set the static fields
			SortUtil.setInsertionSortThreshold(N / 20);
			SortUtil.setPivotStrategy(pivotStrategy);
			ArrayList<Integer> sortedList = SortUtil.generateSortedOrder(N);

			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;

			// time the quicksort routine
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				SortUtil.quicksort(sortedList);
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
							+ "\t\t" + formatter.format(avgTime / (N * (Math.log10(N) / Math.log10(2)))) + "\t\t"
							+ formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N)) + "\t\t"
							+ formatter.format(avgTime / (N * N * N)));
		}

		System.out.println(
				"------------------------------------------------------------------------------------------------");
	}

	/**
	 * Runs a timing analysis on the mergesort method with an average
	 * case(Permuted) problem set
	 */
	private static void timeAverageCaseQuickSort(int pivotStrategy) {
		long startTime, midptTime, stopTime;
		long timesToLoop = 200;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println(
				"---------------  Timing Analysis: quicksort(Average Case: Permuted Order List)  ----------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | pivotStrategy: " + pivotStrategy);
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println(
				"------------------------------------------------------------------------------------------------");

		for (int N = 100000; N <= 2000000; N += 100000) {

			SortUtil.setInsertionSortThreshold(N / 20);
			SortUtil.setPivotStrategy(pivotStrategy);
			
			ArrayList<Integer> sortedList = SortUtil.generatePermutedOrder(N);

			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;

			// time the quicksort routine
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				SortUtil.quicksort(sortedList);
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
							+ "\t\t" + formatter.format(avgTime / (N * (Math.log10(N) / Math.log10(2)))) + "\t\t"
							+ formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N)) + "\t\t"
							+ formatter.format(avgTime / (N * N * N)));
		}

		System.out.println(
				"------------------------------------------------------------------------------------------------");
	}

	/**
	 * Runs a timing analysis on the quicksort method with a worst
	 * case(descending order) problem set
	 */
	private static void timeWorstCaseQuickSort(int pivotStrategy) {
		long startTime, midptTime, stopTime;
		long timesToLoop = 200;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println(
				"----------------  Timing Analysis: quicksort(Worst Case: Descending Order List)  ---------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | pivotStrategy: " + pivotStrategy);
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println(
				"------------------------------------------------------------------------------------------------");

		for (int N = 100000; N <= 2000000; N += 100000) {

			// Set the static fields
			SortUtil.setInsertionSortThreshold(N / 20);
			SortUtil.setPivotStrategy(pivotStrategy);
			
			ArrayList<Integer> reverseSortedList = SortUtil.generateReverseSortedOrder(N);

			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;

			// time the quicksort routine
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				SortUtil.quicksort(reverseSortedList);
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
							+ "\t\t" + formatter.format(avgTime / (N * (Math.log10(N) / Math.log10(2)))) + "\t\t"
							+ formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N)) + "\t\t"
							+ formatter.format(avgTime / (N * N * N)));
		}

		System.out.println(
				"------------------------------------------------------------------------------------------------");
	}
}
