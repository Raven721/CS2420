package assign9;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class SpellCheckerTester {

	@Test
	public void test1() {
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
	public void testdictionarywordlist() {
		SpellChecker mySC = new SpellChecker();

		// run the file against an empty dictionary - get back all words
		List<String> misspelled = mySC.spellCheck(new File("src/assign9/ref/good_luck.txt"));
		// expect all words returned, as dictionary empty
		assertEquals(37, misspelled.size());

		// debug
		if (misspelled.size() != 0) {
			System.out.println("Words in error:");
			for (String w : misspelled) {
				System.out.println(w);
			}
		}

		// Now initialize with this list as the dict
		mySC = new SpellChecker(misspelled);
		// run the file against dictionary
		misspelled = mySC.spellCheck(new File("src/assign9/ref/good_luck.txt"));
		// expect zero, as dict == file
		if (misspelled.size() != 0) {
			System.out.println("Words in error:");
			for (String w : misspelled) {
				System.out.println(w);
			}
		}
		assertEquals(0, misspelled.size());
	}
	
	@Test
	public void testSortedFile() {
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
