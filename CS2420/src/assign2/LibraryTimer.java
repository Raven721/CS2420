package assign2;

public class LibraryTimer {

	public static void main(String[] args) {
	    // Do 10000 lookups and use the average running time.
	    int timesToLoop = 10000;
	    
	    // For each problem size n . . .
	    for (int n = 1000; n <= 10000; n += 1000) {

	      // Generate a new "random" library of size n.
	      Library randLib = new Library();
	      randLib.addAll(generateLibrary(n));

	      long startTime, midpointTime, stopTime;

	      // First, spin computing stuff until one second has gone by.
	      // This allows this thread to stabilize.
	      startTime = System.nanoTime();
	      while (System.nanoTime() - startTime < 1000000000) { // empty block 
	      }

	      // Now, run the test.  
	      startTime = System.nanoTime();

	      for (int i = 0; i < timesToLoop; i++) {
	        randLib.lookup(generateIsbn());
	      }

	      midpointTime = System.nanoTime();

	      // Run a loop to capture the cost of running the "timesToLoop" loop and 
	      // generating a random ISBN.
	      for (long i = 0; i < timesToLoop; i++) { 
	        generateIsbn();
	      }

	      stopTime = System.nanoTime();

	      // Compute the time, subtract the cost of running the loop
	      // from the cost of running the loop and doing the lookups.
	      // Average it over the number of runs.
	      double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
	          / timesToLoop;

	      System.out.println(n + "\t" + averageTime);
	  }

	}

}
