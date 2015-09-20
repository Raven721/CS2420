package assign4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * JUnit class that tests the functionality of the AnagrumUtil class.
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 9/24/2015
 */
public class AnagramUtilTester {
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	  
	@Test
	public void testSortNullInput() {
		// Passing null to AnagramUtil.sort(String s) should throw an exception
		exception.expect(NullPointerException.class);
		AnagramUtil.sort(null);
	}
	
	@Test
	public void testSortNonAlphabetInput() {
		// Passing a string containing characters other than a to z and A to Z
		// to AnagramUtil.sort(String s) should throw an exception
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sort("ab%bc");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sort("ab bc");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sort("ab1bc");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sort(" ");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sort("1234");
	}
	
	@Test
	public void testSortWithValidIdenticalInput() {
		assertEquals("abcd", AnagramUtil.sort("abcd"));
	}
	
	@Test
	public void testSortWithValidReverseInput() {
		assertEquals("abcd", AnagramUtil.sort("dcba"));
	}
	
	@Test
	public void testSortWithTwoCharIdenticalInput() {
		assertEquals("ab", AnagramUtil.sort("ab"));
	}
	
	@Test
	public void testSortWithTwoCharReverseInput() {
		assertEquals("ab", AnagramUtil.sort("ba"));
	}


}
