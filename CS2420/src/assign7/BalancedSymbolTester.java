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
		String correctOutput = "ERROR: Unmatched symbol at line 6 and column 1. Expected ), but read } instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class1.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass2() throws FileNotFoundException {
		String correctOutput = "ERROR: Unmatched symbol at line 7 and column 1. Expected  , but read } instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class2.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass3() throws FileNotFoundException {
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class3.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass4() throws FileNotFoundException {
		String correctOutput = "ERROR: File ended before closing comment.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class4.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass5() throws FileNotFoundException {
		String correctOutput = "ERROR: Unmatched symbol at line 3 and column 18. Expected ], but read } instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class5.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass6() throws FileNotFoundException {
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class6.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass7() throws FileNotFoundException {
		String correctOutput = "ERROR: Unmatched symbol at line 3 and column 33. Expected ], but read ) instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class7.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass8() throws FileNotFoundException {
		String correctOutput = "ERROR: Unmatched symbol at line 5 and column 30. Expected }, but read ) instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class8.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass9() throws FileNotFoundException {
		String correctOutput = "ERROR: Unmatched symbol at line 3 and column 33. Expected ), but read ] instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class9.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass10() throws FileNotFoundException {
		String correctOutput = "ERROR: Unmatched symbol at line 5 and column 10. Expected }, but read ] instead.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class10.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass11() throws FileNotFoundException {
		String correctOutput = "ERROR: Unmatched symbol at the end of file. Expected }.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class11.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass12() throws FileNotFoundException {
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class13.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithExampleClass13() throws FileNotFoundException {
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\ExampleTests\\Class13.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	////////// String checkFile(String filename) //////////
	////////// Created Test Files //////////
	////////// Test Parenthesis //////////
	@Test
	public void testCheckFileWithParenthesisAtBeginningOfFile() throws FileNotFoundException {
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class1.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithParenthesisContainingEscapeSequence() throws FileNotFoundException {
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class2.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithParenthesisUnclosedError() throws FileNotFoundException {
		String correctOutput = "ERROR: Unmatched symbol at the end of file. Expected '.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class3.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	////////// Test Quotation Marks //////////
	@Test
	public void testCheckFileWithQuotationAtBeginningOfFile() throws FileNotFoundException {
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class4.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithQuotationContainingEscapeSequence() throws FileNotFoundException {
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class5.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithQuotationUnclosedError() throws FileNotFoundException {
		String correctOutput = "ERROR: Unmatched symbol at the end of file. Expected \".";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class6.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	////////// Test Block Comments //////////
	@Test
	public void testCheckFileWithBlockCommentAtBeginningOfFile() throws FileNotFoundException {
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class7.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithBlockCommentContainingEscapeSequence() throws FileNotFoundException {
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class8.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithBlockCommentUnclosedError() throws FileNotFoundException {
		String correctOutput = "ERROR: File ended before closing comment.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class9.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	////////// Test Single Line Comments //////////
	@Test
	public void testCheckFileWithSingleLineCommentAtBeginningOfFile() throws FileNotFoundException {
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class10.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithSingleLineCommentContainingEscapeSequence() throws FileNotFoundException {
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class11.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithSingleLineCommentToTheRightOfStuff() throws FileNotFoundException {
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class12.java");
		assertEquals(correctOutput, actualOutput);
	}
	
	@Test
	public void testCheckFileWithBalancedSymbolCheckerClass() throws FileNotFoundException {
		String correctOutput = "No errors found. All symbols match.";
		String actualOutput = BalancedSymbolChecker.checkFile("src\\assign7\\Tests\\CreatedTests\\Class13.java");
		assertEquals(correctOutput, actualOutput);
	}
}
