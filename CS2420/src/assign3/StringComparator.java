package assign3;

import java.util.Comparator;

/**
 * Comparator class that compares two strings.
 * In this class, a string is considered greater than another string if it alphabetically precedes the other.
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 9/17/2015
 *
 */
public class StringComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if (o1.compareToIgnoreCase(o2) > 0) {
			return 1;
		} else if (o1.compareToIgnoreCase(o2) < 0) {
			return -1;
		} else
			return 0;
	}
}
