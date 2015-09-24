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
	 * If the first parameter is larger than the second, return 1
	 * If the first parameter is smaller than the second, return -1
	 * If both parameters are equivalent, return 0
	 */
	@Override
	public int compare(Integer arg0, Integer arg1) {
		if (arg0 < arg1) {
			return -1;
		} else
			return 1;
	}
}
