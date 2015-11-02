package assign9;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class SpellCheckerTester {

	@Test
	public void testAddToDict() {
		SpellChecker mySC = new SpellChecker();
		// Run the test file through, no matches as empty dictionary
		File documentToCheck = new File("src/assign9/ref/hello_world.txt");
		List<String> misspelled = mySC.spellCheck(documentToCheck);
		// all words should show up here
		assertEquals(7, misspelled.size());
		
		// Now add hello and world
		mySC.addToDictionary("HeLlo");
		mySC.addToDictionary("WORLD");
		
		// No re-run and 2 less words should show up
		misspelled = mySC.spellCheck(documentToCheck);
		// all words should show up here
		assertEquals(7-2, misspelled.size());
	}
	
	@Test
	public void testRemoveFromDict() {
		SpellChecker mySC = new SpellChecker();

		// run the dictionary against a zero dictionary - output should match
		File documentToCheck = new File("src/assign9/ref/dictionary.txt");
		List<String> misspelledWords = mySC.spellCheck(documentToCheck);
		// expect all do not match, as dictionary emtpy
		assertEquals(2914, misspelledWords.size());

		// now add dictionary.txt as the dictionary
		mySC = new SpellChecker(new File("src/assign9/ref/dictionary.txt"));

		misspelledWords = mySC.spellCheck(documentToCheck);
		// expect all match, as dictionary = file
		assertEquals(0, misspelledWords.size());

		// Now test removing words from dictionary
		mySC.removeFromDictionary("khaKI");
		mySC.removeFromDictionary("ecLiPSE");
		misspelledWords = mySC.spellCheck(documentToCheck);
		// expect all match except 2, as dictionary = file
		assertEquals(2, misspelledWords.size());
		assertTrue(misspelledWords.contains("khaki"));
		assertTrue(misspelledWords.contains("eclipse"));

		// Now add them back in
		mySC.addToDictionary("KHAki");
		mySC.addToDictionary("ECLipSE");
		misspelledWords = mySC.spellCheck(documentToCheck);
		// expect all match, as dictionary = file
		assertEquals(0, misspelledWords.size());
	}
	
	@Test
	public void testConstructorWordList() {
		SpellChecker mySC = new SpellChecker();

		// run the file against an empty dictionary - get back all words
		List<String> misspelled = mySC.spellCheck(new File("src/assign9/ref/good_luck.txt"));
		// expect all words returned, as dictionary empty
		assertEquals(37, misspelled.size());

		// Now initialize with this list as the dict
		mySC = new SpellChecker(misspelled);
		// run the file against dictionary
		misspelled = mySC.spellCheck(new File("src/assign9/ref/good_luck.txt"));
		// expect zero, as dict == file
		assertEquals(0, misspelled.size());
	}
	
	@Test
	public void testSpellCheckerWithSortedFile() {
		SpellChecker mySC = new SpellChecker();
		// run dictionary against empty dictionary to get all words
		List<String> misspelled = mySC.spellCheck(new File("src/assign9/ref/dictionary.txt"));
		assertEquals(2914, misspelled.size());
		
		misspelled.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		});
		
		// now insert them sorted
		mySC = new SpellChecker(misspelled);
		
		// Now re-test, we should not find any misspelled words
		misspelled = mySC.spellCheck(new File("src/assign9/ref/dictionary.txt"));
		assertEquals(0, misspelled.size());
	}
	
	@Test
	public void testReverseSortedFile() {
		SpellChecker mySC = new SpellChecker();
		// run dictionary against empty dictionary to get all words
		List<String> misspelled = mySC.spellCheck(new File("src/assign9/ref/dictionary.txt"));
		assertEquals(2914, misspelled.size());
		
		misspelled.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareToIgnoreCase(o1);
			}
		});
		
		// now insert them sorted
		mySC = new SpellChecker(misspelled);
		
		// Now re-test, we should not find any misspelled words
		misspelled = mySC.spellCheck(new File("src/assign9/ref/dictionary.txt"));
		assertEquals(0, misspelled.size());
	}
}
