package assign3;

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
		long startTime, midpointTime, stopTime;
		MyPriorityQueue<Integer> queue1 = new MyPriorityQueue<Integer>(new IntegerComparator());
		Random rn = new Random();
		
		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		startTime = System.nanoTime();
		while(System.nanoTime() - startTime < 1000000000) { // empty block
		}

		// Now, run the test.
		long timesToLoop = 1;

		startTime = System.nanoTime();

		for(long i = 0; i < timesToLoop; i++)
			for(double d = 1; d <= 10; d++)
				for(int size = 0; size < 2000; size++) {
					queue1.insert(rn.nextInt(200 - 1 + 1) + 1);
				}

		midpointTime = System.nanoTime();

		// Run an empty loop to capture the cost of running the loop.
		for(long i = 0; i < timesToLoop; i++) { // empty block
		}

		stopTime = System.nanoTime();

		// Compute the time, subtract the cost of running the loop
		// from the cost of running the loop and computing square roots.
		// Average it over the number of runs.
		double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / timesToLoop;

		System.out.println("It takes exactly " + averageTime + " nanoseconds to compute the findMin() method");
	  
	}
}
