package assign3;

import java.util.Comparator;

class NaturalComparator<E extends Comparable<E>> implements Comparator<E> {
	  public int compare(E a, E b) {
	    return a.compareTo(b);
	  }
}
