package assign4;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * This class demonstrates how use formulas to compare the empirically observed
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
 * @version 9/24/2015
 */
public class TimingAnalysis {

	public static void main(String[] args) {
		long startTime, midptTime, stopTime;
		long timesToLoop = 100; // Small to allow for quick demo in lecture

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("-----------------------------------------------------------------------------------");

		for (int N = 1000; N <= 20000; N += 1000) { 

			String[] wordList1 = generateStringArray(N);
			String[] wordList2 = generateStringArray(N);
			
			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;

			// time the routine
			startTime = System.nanoTime();
			for (long i = 0; i < timesToLoop; i++) {
				for(int j = 0; j < N; j++) {
					AnagramUtil.areAnagrams(wordList1[j], wordList2[j]);
					//AnagramUtil.getLargestAnagramGroup(wordList1);
				}
			}
			midptTime = System.nanoTime();

			// time the empty loops
			for (long i = 0; i < timesToLoop; i++) {
				for (int j = 0; j < N; j++) {
					
				}
			}

			stopTime = System.nanoTime();
			
			if(((midptTime - startTime) - (stopTime - midptTime)) < 1) {
				N-= 100000;
				continue;
			}

			// compute the average time
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

			System.out.println(
					formatter.format(avgTime) + "\t|\t" + formatter.format(avgTime / (Math.log10(N) / Math.log10(2)))
							+ "\t\t" + formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N))
							+ "\t\t" + formatter.format(avgTime / (N * N * N)));
		}
	}

	/**
	 * Returns an string array of a specified size, filled with randomly
	 * generated strings in length varying from 2 to 6 characters. Characters
	 * range from a to z
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
			randLength = rn.nextInt(6 - 2 + 1) + 2;
			for (int j = 0; j < randLength; j++) {
				randNum = (rn.nextInt(122 - 97 + 1) + 97);
				c = (char) randNum;	
				arr[i] += c;
			}
		}

		return arr;
	}
}
