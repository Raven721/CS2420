package assign4;

import java.util.Comparator;

/**
 * Comparator class that compares two integers. 
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 9/24/2015
 *
 */
public class IntegerComparator implements Comparator<Integer> {

	/**
	 * If the first parameter is smaller than the second, return -1
	 * If the first parameter is smaller than or equal to the second, return 1
	 */
	@Override
	public int compare(Integer arg0, Integer arg1) {
		if (arg0 < arg1) {
			return -1;
		} else
			return 1;
	}
}
