package assign1; /* DO NOT modify the package declaration. */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A library of useful functions for calculating numerical statistics on numbers and lists
 * of numbers.
 * 
 * @author Tim Ellenberger, ellenber
 * @version 9/3/15
 */
public class MathLibrary { /* DO NOT modify the interface of MathLibrary. */

	/**
	 * Calculates the mean of an ArrayList of numbers.
	 * 
	 * @param list the ArrayList<Double> containing the number to be parsed for calculation
	 * @return the mean value of list. If list is null, empty, or contains a null element, return 0.0
	 */
	public static double mean(ArrayList<Double> list) {
		// Return 0.0 if array list is null, is empty, or contains a null element
		if (list == null) {
			return 0.0;
		} else if (list.isEmpty()) {
			return 0.0;
		} else {
			for (Double currentNum : list) {
				if (currentNum == null) {
					return 0.0;
				}
			}
		}

		// Sum the values of all elements in the array list
		double sum = 0;
		for (Double currentNum : list) {
			sum += currentNum;
		}

		// Return the mean value of the array list
		return sum / (list.size());
	}

	/**
	 * Calculates the median of an array of double-precision floating-point numbers
	 * 
	 * @param arr the array of numbers to be parsed to find the median
	 * @return the median of an array list of doubles. If arr is null or empty, return 0.0
	 */
	public static double median(double[] arr) {
		// Return 0.0 if array is null or empty
		if (arr == null) {
			return 0.0;
		} else if (arr.length == 0) {
			return 0.0;
		}

		// Sort the array in ascending order
		Arrays.sort(arr);

		// Calculate median of array
		int midpoint = arr.length / 2;
		// If the length of the array is odd
		if (arr.length % 2 == 1) {
			return arr[midpoint];
		// If the length of the array is even
		} else {
			return (arr[midpoint - 1] + arr[midpoint]) / 2.0;
		}
	}

	/**
	 * Calculates the mode of a two dimensional array of integers
	 * 
	 * (Note: If the input array is null or empty, return 0. If all elements are
	 * unique, return the element in the first row and first column. If there is
	 * a tie for the mode, return any of the most frequently occurring values.)
	 * 
	 * @param arr A two-dimensional array of integers that are used to calculate the mode 
	 * @return Integer value of the mode of a two-dimensional array of integers. If the array is null or empty, return 0
	 */
	public static int mode(int[][] arr) {
		// Return 0 if array is null or empty
		if (arr == null) {
			return 0;
		}
		else if(arr.length == 0) {
			return 0;
		}

		int mode = 0, frequency = 0;

		// Iterate through the input array
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int counter = 0;
				
				// Iterate through a new array for every value in the input array
				for (int k = 0; k < arr.length; k++) {
					for (int l = 0; l < arr[i].length; l++) {
						if (arr[i][j] == arr[k][l]) {
							counter++;
						}
					}
				}
				
				// If the counted frequency of a number is greater than the current max frequency, update the max
				if (counter > frequency) {
					mode = arr[i][j];
					frequency = counter;
				}
			}
		}
		return mode;
	}

	/**
	 * Calculates the greatest common divisor of two integers
	 * 
	 * @param a Integer input to be calculated
	 * @param b Integer input to be calculated
	 * @return Integer value of the GCD between two integers. If either inputs are zero or negative, return -1
	 */
	public static int gcd(int a, int b) {
		// If either inputs are not positive, return -1
		if (a < 1 || b < 1) {
			return -1;
		}

		int gcd = 0;
		
		// If the two inputs are equal, the greatest common divisor are themselves.
		if (a == b) {
			gcd = a;
		// The largest number that can be evaluated as the GCD is the smallest of the two inputs
		} else if (a < b) {
			for (int i = 1; i <= a; i++) {
				if (a % i == 0 && b % i == 0) {
					gcd = i;
				}
			}
		} else if (b < a) {
			for (int i = 1; i <= b; i++) {
				if (a % i == 0 && b % i == 0) {
					gcd = i;
				}
			}
		}
		return gcd;
	}

	/**
	 * Calculates the least common multiple of two integers
	 * 
	 * @param a Integer input to be calculated
	 * @param b Integer input to be calculated
	 * @return Integer value of the LCM between two integer inputs. If either inputs are zero or negative, return -1
	 */
	public static int lcm(int a, int b) {
		// Return -1 if either input integers are not positive
		if (a < 1 || b < 1) {
			return -1;
		}

		int lcm = 0;

		// If both inputs are equal to each other, the LCM is the value of the inputs
		if (a == b) {
			lcm = a;
		// Depending on which input number is larger, the pattern for finding the LCM adjusts accordingly	
		} else if (a > b) {
			for (int i = b; i > 0; i--) {
				if ((a * i) % b == 0) {
					lcm = i * a;
				}
			}
		} else if (b > a) {
			for (int i = a; i > 0; i--) {
				if (b * i % a == 0) {
					lcm = i * b;
				}
			}
		}
		return lcm;
	}

	/**
	 * Calculates the first prime integer following a specified integer
	 * 
	 * @param n
	 * @return Integer value of the next prime number following the input integer. If the input integer is zero or negative, return -1
	 */
	public static int nextPrime(int n) {

		// Return -1 if input integer is not positive
		if (n < 1) {
			return -1;
		}

		boolean isPrime = false;

		// Keep iterating until a prime number is found.
		while (!isPrime) {
			
			// Increment the input integer to attempt to validate the next integer as prime.
			n++;
			
			// Initially set to false, isPrime will close the loop after the first iteration that doesn't resolve to a non-prime number below.
			isPrime = true;
			
			// A prime number is only divisible by 1 and itself. Iterate from 2 to 1 less than n in order to find the next prime number. 
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					isPrime = false;
					break;
				}
			}
		}
		return n;
	}
}