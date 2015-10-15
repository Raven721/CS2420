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

	////////// String checkFile(String filename) //////////
	///////// Provided Example Test Files //////////
	@Test
	public void testCheckFileWithExampleClass1() throws FileNotFoundException {
		System.out.println("----1----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class1.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 6 and column 1. Expected ), but read } instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class1.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass2() throws FileNotFoundException {
		System.out.println("----2----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class2.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 7 and column 1. Expected  , but read } instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class2.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass3() throws FileNotFoundException {
		System.out.println("----3----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class3.java"));
		System.out.println("---------");
		
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class3.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass4() throws FileNotFoundException {
		System.out.println("----4----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class4.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: File ended before closing comment.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class4.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass5() throws FileNotFoundException {
		System.out.println("----5----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class5.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 3 and column 18. Expected ], but read } instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class5.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass6() throws FileNotFoundException {
		System.out.println("----6----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class6.java"));
		System.out.println("---------");
		
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class6.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass7() throws FileNotFoundException {
		System.out.println("----7----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class7.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 3 and column 33. Expected ], but read ) instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class7.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass8() throws FileNotFoundException {
		System.out.println("----8----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class8.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 5 and column 30. Expected }, but read ) instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class8.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass9() throws FileNotFoundException {
		System.out.println("----9----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class9.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 3 and column 33. Expected ), but read ] instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class9.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass10() throws FileNotFoundException {
		System.out.println("----10----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class10.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 5 and column 10. Expected }, but read ] instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class10.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass11() throws FileNotFoundException {
		System.out.println("----11----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class11.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at the end of file. Expected }.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class11.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass12() throws FileNotFoundException {
		System.out.println("----12----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class12.java"));
		System.out.println("---------");
		
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class13.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass13() throws FileNotFoundException {
		System.out.println("----13----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class13.java"));
		System.out.println("---------");
		
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class13.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	////////// String checkFile(String filename) //////////
	///////// Created Test Files //////////
	@Test
	public void testCheckFileWithCreatedClass1() throws FileNotFoundException {
		System.out.println("----1----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class1.java"));
		System.out.println("---------");
		
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class1.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithCreatedClass2() throws FileNotFoundException {
		System.out.println("----2----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class2.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 7 and column 1. Expected  , but read } instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class2.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithCreatedClass3() throws FileNotFoundException {
		System.out.println("----3----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class3.java"));
		System.out.println("---------");
		
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class3.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithCreatedClass4() throws FileNotFoundException {
		System.out.println("----4----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class4.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: File ended before closing comment.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class4.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithCreatedClass5() throws FileNotFoundException {
		System.out.println("----5----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class5.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 3 and column 18. Expected ], but read } instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class5.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithCreatedClass6() throws FileNotFoundException {
		System.out.println("----6----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class6.java"));
		System.out.println("---------");
		
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class6.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithCreatedClass7() throws FileNotFoundException {
		System.out.println("----7----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class7.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 3 and column 33. Expected ], but read ) instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class7.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithCreatedClass8() throws FileNotFoundException {
		System.out.println("----8----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class8.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 5 and column 30. Expected }, but read ) instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class8.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithCreatedClass9() throws FileNotFoundException {
		System.out.println("----9----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class9.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 3 and column 33. Expected ), but read ] instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class9.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithCreatedClass10() throws FileNotFoundException {
		System.out.println("----10----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class10.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at line 5 and column 10. Expected }, but read ] instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class10.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithCreatedClass11() throws FileNotFoundException {
		System.out.println("----11----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class11.java"));
		System.out.println("---------");
		
		String correctOutput = "ERROR: Unmatched symbol at the end of file. Expected }.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class11.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithCreatedClass12() throws FileNotFoundException {
		System.out.println("----12----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class12.java"));
		System.out.println("---------");
		
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class12.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithCreatedClass13() throws FileNotFoundException {
		System.out.println("----13----");
		System.out.println(BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class13.java"));
		System.out.println("---------");
		
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class13.java");
		assertEquals(correctOutput, actualOutput);
	}
}
