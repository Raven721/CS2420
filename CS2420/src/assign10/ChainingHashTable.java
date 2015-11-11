package assign10;

import java.util.Collection;

/**
 * A class representation of a hash table of String objects that uses separate
 * chaining to resolve collisions.
 * 
 * @author Tim Ellenberger, ellenber
 * @author ???
 * @version 11/19/2015
 */
public class ChainingHashTable implements Set<String> {
	
	/** Constructs a hash table of the given capacity that uses the hashing function
	 * specified by the given functor.
	 */
	public ChainingHashTable(int capacity, HashFunctor functor) {
		
	}
	
	/**
	 * Ensures that this set contains the specified item.
	 * 
	 * @param item
	 *            - the item whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that
	 *         is, if the input item was actually inserted); otherwise, returns
	 *         false
	 */
	@Override
	public boolean add(String item) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Ensures that this set contains all items in the specified collection.
	 * 
	 * @param items
	 *            - the collection of items whose presence is ensured in this
	 *            set
	 * @return true if this set changed as a result of this method call (that
	 *         is, if any item in the input collection was actually inserted);
	 *         otherwise, returns false
	 */
	@Override
	public boolean addAll(Collection<? extends String> items) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Removes all items from this set. The set will be empty after this method
	 * call.
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	/**
	 * Determines if there is an item in this set that is equal to the specified
	 * item.
	 * 
	 * @param item
	 *            - the item sought in this set
	 * @return true if there is an item in this set that is equal to the input
	 *         item; otherwise, returns false
	 */
	@Override
	public boolean contains(String item) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Determines if for each item in the specified collection, there is an item
	 * in this set that is equal to it.
	 * 
	 * @param items
	 *            - the collection of items sought in this set
	 * @return true if for each item in the specified collection, there is an
	 *         item in this set that is equal to it; otherwise, returns false
	 */
	@Override
	public boolean containsAll(Collection<? extends String> items) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns true if this set contains no items.
	 * 
	 * @return true if this set contains no items.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns the number of items in this set.
	 * 
	 * @return the number of items in this set.
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
