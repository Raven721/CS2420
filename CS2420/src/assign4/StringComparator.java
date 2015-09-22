package assign4;

import java.util.Comparator;

/**
 * Comparator class that compares two strings.
 * A string is considered less than another string if its sorted characters alphabetically precedes the other strings sorted characters.
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 9/24/2015
 */
public class StringComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if((AnagramUtil.sort(o1)).compareTo(AnagramUtil.sort(o2)) < 0) {
			return -1;
		}
		else {
			return 1;
		}
	}
}
