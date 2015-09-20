package assign4;

import static org.junit.Assert.*;
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
	  
	//////// sort(String s) ////////
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
	public void testSortWithShortInput() {
		// Passing a string containing less than two characters
		// to AnagramUtil.sort(String s) should throw an exception
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sort("a");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sort("A");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sort("");
	}
	
	@Test
	public void testSortWithValidIdenticalInput() {
		assertEquals("abcd", AnagramUtil.sort("abcd"));
		assertEquals("abcd", AnagramUtil.sort("ABCD"));
	}
	
	@Test
	public void testSortWithValidReverseInput() {
		assertEquals("abcd", AnagramUtil.sort("dcba"));
		assertEquals("abcd", AnagramUtil.sort("DCBA"));
	}
	
	@Test
	public void testSortWithTwoCharIdenticalInput() {
		assertEquals("ab", AnagramUtil.sort("ab"));
		assertEquals("ab", AnagramUtil.sort("AB"));
	}
	
	@Test
	public void testSortWithTwoCharReverseInput() {
		assertEquals("ab", AnagramUtil.sort("ba"));
		assertEquals("ab", AnagramUtil.sort("BA"));
	}
	
	@Test
	public void testSortWithFullAlphabet() {
		assertEquals("abcdefghijklmnopqrstuvwxyz", AnagramUtil.sort("zyxwvutsrqponmlkjihgfedcba"));
		assertEquals("abcdefghijklmnopqrstuvwxyz", AnagramUtil.sort("ZYXWVUTSRQPONMLKJIHGFEDCBA"));
	}
	
	//////// areAnagrams(String s1, String s2) ////////
	@Test
	public void testAreAnagramsNullInput() {
		// Passing null to AnagramUtil.sort(String s) should throw an exception
		exception.expect(NullPointerException.class);
		AnagramUtil.areAnagrams(null, null);
	}
	
	@Test
	public void testAreAnagramsNonAlphabetInput() {
		// Passing a string containing characters other than a to z and A to Z
		// to AnagramUtil.sort(String s) should throw an exception
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.areAnagrams("ab%bc", "cb%ba");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.areAnagrams("ab bc", "cb ba");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.areAnagrams("ab1bc", "cb1ba");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.areAnagrams(" ", " ");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.areAnagrams("1234", "4321");
	}
	
	@Test
	public void testAreAnagramsWithShortInput() {
		// Passing a string containing less than two characters
		// to AnagramUtil.sort(String s) should throw an exception
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.areAnagrams("a", "a");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.areAnagrams("A", "A");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.areAnagrams("", "");
	}
}
