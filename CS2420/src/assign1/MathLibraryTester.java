package assign1;

import static org.junit.Assert.*;
import static assign1.MathLibrary.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit testing suite for the MathLibrary class.
 * 
 * @author Tim Ellenberger, ellenber
 * @version 9/3/15
 */

public class MathLibraryTester {
	private double[] arrOddLength;
	private double[] arrEvenLength;
	private double[] arrShort;
	private double[] arrNull;
	private double[] arrEmpty;
	
	private ArrayList<Double> list;
	private ArrayList<Double> listShort;
	private ArrayList<Double> listNull;
	private ArrayList<Double> listEmpty;
	
	private int[][] arr_2d;
	private int[][] arr_2d_Short;
	private int[][] arr_2d_Null;
	private int[][] arr_2d_Empty;
	
	// Initialize objects before each test
	@Before
	public void initialize() {
		arrOddLength = new double[] { 3.4, 9.0, 7.8, 1.2, 5.6 };
		arrEvenLength = new double[] { 3.4, 9.0, 7.8, 1.2, 5.6, 9.8 };
		arrShort = new double[] { 3.4 };
		arrNull = null;
		arrEmpty = new double[] {  };
		
		list = new ArrayList<Double>(Arrays.asList(3.4, 9.0, 7.8, 1.2, 5.6));
		listShort = new ArrayList<Double>(Arrays.asList(0.0));
		listNull = new ArrayList<Double>(Arrays.asList());
		listNull.add(null);
		listEmpty = new ArrayList<Double>(Arrays.asList());
		
		arr_2d = new int[][] { { 3, 9, 7 }, { 1, 5, 9 }, { 3, 7, 3 } };
		arr_2d_Short = new int[][] { { 3, 9, 7 } };
		arr_2d_Null = null;
		arr_2d_Empty = new int[][] {  };
	}

	// mean(ArrayList<Double> list) testing
	@Test
	public void testMeanWithValidInput() {
		assertEquals(5.4, mean(list), .001);
	}
	
	@Test
	public void testMeanWithNullInput() {
		assertEquals(0.0, mean(null), .001);
	}
	
	@Test
	public void testMeanWithNullElementInput() {
		assertEquals(0.0, mean(listNull), .001);
	}
	
	@Test
	public void testMeanWithEmptyInput() {
		assertEquals(0.0, mean(listEmpty), .001);
	}
	
	@Test
	public void testMeanWithOneNumberList() {
		assertEquals(listShort.get(0), mean(listShort), .001);
	}

	// median(double[] arr) testing
	@Test
	public void testMedianWithOddListLength() {
		assertEquals(5.6, median(arrOddLength), .001);
	}
	
	@Test
	public void testMedianWithEvenListLength() {
		assertEquals(6.7, median(arrEvenLength), .001);
	}
	
	@Test
	public void testMedianWithNullInput() {
		assertEquals(0.0, median(arrNull), .001);
	}
	
	@Test
	public void testMedianWithEmptyInput() {
		assertEquals(0.0, median(arrEmpty), .001);
	}
	
	@Test
	public void testMedianWithOneNumberList() {
		assertEquals(arrShort[0], median(arrShort), .001);
	}

	// mode(int[][] arr) testing
	@Test
	public void testModeWithValidInput() {
		assertEquals(3, mode(arr_2d));
	}
	
	@Test
	public void testModeWithNullInput() {
		assertEquals(0, mode(arr_2d_Null));
	}
	
	@Test
	public void testModeWithEmptyInput() {
		assertEquals(0, mode(arr_2d_Empty));
	}
	
	@Test
	public void testModeWithOneNumberList() {
		assertEquals(3, mode(arr_2d_Short));
	}

	// gcd(int a, int b) testing
	@Test
	public void testGCDWithValidInput() {
		assertEquals(6, gcd(18, 24));
	}
	
	@Test
	public void testGCDWithValidInputInverted() {
		assertEquals(6, gcd(24, 18));
	}
	
	@Test
	public void testGCDWithNegativeInput() {
		assertEquals(-1, gcd(-18, 24));
	}
	
	@Test
	public void testGCDWithZeroInput() {
		assertEquals(-1, gcd(0, 24));
	}
	
	@Test
	public void testGCDWithIdenticalInputs() {
		assertEquals(18, gcd(18, 18));
	}

	// lcm(int a, int b) testing
	@Test
	public void testLCMWithValidInput() {
		assertEquals(42, lcm(21, 6));
	}
	
	@Test
	public void testLCMWithValidInputInverted() {
		assertEquals(42, lcm(6, 21));
	}
	
	@Test
	public void testLCMWithNegativeInput() {
		assertEquals(42, lcm(21, 6));
	}
	
	@Test
	public void testLCMWithZeroInput() { 
		assertEquals(-1, lcm(-21, 6));
	}
	
	@Test
	public void testLCMWithIdenticalInputs() {
		assertEquals(6, lcm(6, 6));
	}

	// nextPrime(int n) testing
	@Test
	public void testNextPrimeWithEvenInput() {
		assertEquals(29, nextPrime(24));
	}
	
	@Test
	public void testNextPrimeWithOdd() {
		assertEquals(29, nextPrime(24));
	}
	
	@Test
	public void testNextPrimeWithNegativeInput() {
		assertEquals(-1, nextPrime(-24));
	}
	
	@Test
	public void testNextPrimeWithZeroInput() {
		assertEquals(-1, nextPrime(0));
	}
}
