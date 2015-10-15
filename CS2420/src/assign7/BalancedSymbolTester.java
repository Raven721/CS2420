package assign7;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * Unit Tests for the BalancedSymbolChecker class
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 10/22/2015
 */
public class BalancedSymbolTester {

	@Test
	public void testCheckFile1() throws FileNotFoundException {
		System.out.println("----1----");
		System.out.println(BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class1.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 6 and column 1. Expected ), but read } instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class1.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFile2() throws FileNotFoundException {
		System.out.println("----2----");
		System.out.println(BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class2.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 7 and column 1. Expected  , but read } instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class2.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFile3() throws FileNotFoundException {
		System.out.println("----3----");
		System.out.println(BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class3.java"));
		System.out.println("---------");
		
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class3.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFile4() throws FileNotFoundException {
		System.out.println("----4----");
		System.out.println(BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class4.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: File ended before closing comment.";
		String actualOutput = BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class4.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFile5() throws FileNotFoundException {
		System.out.println("----5----");
		System.out.println(BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class5.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 3 and column 18. Expected ], but read } instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class5.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFile6() throws FileNotFoundException {
		System.out.println("----6----");
		System.out.println(BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class6.java"));
		System.out.println("---------");
		
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class6.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFile7() throws FileNotFoundException {
		System.out.println("----7----");
		System.out.println(BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class7.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 3 and column 33. Expected ], but read ) instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class7.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFile8() throws FileNotFoundException {
		System.out.println("----8----");
		System.out.println(BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class8.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 5 and column 30. Expected }, but read ) instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class8.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFile9() throws FileNotFoundException {
		System.out.println("----9----");
		System.out.println(BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class9.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 3 and column 33. Expected ), but read ] instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class9.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFile10() throws FileNotFoundException {
		System.out.println("----10----");
		System.out.println(BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class10.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 5 and column 10. Expected }, but read ] instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class10.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFile11() throws FileNotFoundException {
		System.out.println("----11----");
		System.out.println(BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class11.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at the end of file. Expected }.";
		String actualOutput = BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class11.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFile12() throws FileNotFoundException {
		System.out.println("----12----");
		System.out.println(BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class12.java"));
		System.out.println("---------");
		
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class13.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFile13() throws FileNotFoundException {
		System.out.println("----13----");
		System.out.println(BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class13.java"));
		System.out.println("---------");
		
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("C:\\Users\\timel\\Desktop\\Examples\\Class13.java");
		assertEquals(correctOutput, actualOutput);
	}

}
