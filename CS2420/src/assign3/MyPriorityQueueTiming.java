package assign3;

import java.text.DecimalFormat;
import java.util.Random;


/**
 * An implementation of Priority Queue, this class will take a sorted list of a
 * generic type and perform enque/deque operations using binary sort
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 */
public class MyPriorityQueueTiming<E>
{
	public static void main(String[] args)
	{
		//timeMyPriorityQueue("findMin()", 300, 1000, 20000, 1000);
		timeMyPriorityQueue("insert(E item)", 200, 10000, 200000, 10000);
	  
	}
	
	private static void timeMyPriorityQueue(String timingMethod, int timesToLoop, int nStart, int nStop, int nStep) {
		long startTime, midptTime, stopTime;
		boolean retry = false;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E00");

		System.out.println("------------------- MyPriorityQueue Timing Analysis: " + timingMethod + " ----------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(1)");
		System.out.println("\nN\tT(N)\t\t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println("---------------------------------------------------------------------------------------------------------");

		for (int N = nStart; N <= nStop; N += nStep) {

			// Create a data set to work with
			String[] wordList = generateStringArray(N);
			MyPriorityQueue<String> queue = generateQueue(wordList);
			
			if(!retry) {
				System.out.print(N + "\t");
			}
		
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
			
			if(avgTime <= 0){
				retry = true;
				N -= 100000;
				continue;
			} else {
				retry = false;
			}

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
