package assign3;

import java.text.DecimalFormat;
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
 * If T(N) / F(N) converges to infinity, then F(N) is an underestimate of the growth
 * rate of the running times.
 * 
 * @author Erin Parker
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 9/17/2015
 */
public class TimingAnalysis {

  public static void main(String[] args) {
    long startTime, midptTime, stopTime;
    long timesToLoop = 3;   // Small to allow for quick demo in lecture
    
    MyPriorityQueue<Integer> queueComparableInteger = new MyPriorityQueue<Integer>();
    MyPriorityQueue<String> queueComparableString = new MyPriorityQueue<String>();
    
    MyPriorityQueue<Integer> queueComparatorInteger = new MyPriorityQueue<Integer>();
    MyPriorityQueue<String> queueComparatorString = new MyPriorityQueue<String>();

    // try computing T(N)/F(N), see if it converges
    DecimalFormat formatter = new DecimalFormat("0000E0");

    System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
    System.out
        .println("-----------------------------------------------------------------------------------");

    for (int N = 100; N <= 1000; N += 100) {   // Small to allow for quick demo in lecture

      System.out.print(N + "\t");

      // let things stabilize
      startTime = System.nanoTime();
      while (System.nanoTime() - startTime < 1000000000)
        ;

      // time the routine
      startTime = System.nanoTime();
      for (long i = 0; i < timesToLoop; i++)
    	  queueComparableInteger.findMin();
      midptTime = System.nanoTime();

      // time the empty loop
      for (long i = 0; i < timesToLoop; i++)
        ;

      stopTime = System.nanoTime();

      // compute the average time
      double avgTime = ((midptTime - startTime) - (stopTime - midptTime))
          / timesToLoop;

      System.out.println(formatter.format(avgTime) + "\t|\t"
          + formatter.format(avgTime / (Math.log10(N) / Math.log10(2))) + "\t\t"
          + formatter.format(avgTime / N) + "\t\t"
          + formatter.format(avgTime / (N * N)) + "\t\t "
          + formatter.format(avgTime / (N * N * N)));
    }
  }
}