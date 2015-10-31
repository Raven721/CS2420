package assign9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * ????????????????????
 * 
 * @author Tim Ellenberger, ellenber
 * @author John Strasser, strasser
 * @author Erin Parker
 * @version 11/05/2015
 */
public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {
	// The root node of this BST
	private BinaryNode<Type> rootNode;

	// The number of items currently in this BST
	private int size;

	/**
	 * Ensures that this set contains the specified item.
	 * 
	 * @param item
	 *            - the item whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that
	 *         is, if the input item was actually inserted); otherwise, returns
	 *         false
	 * @throws NullPointerException
	 *             if the item is null
	 */
	@Override
	public boolean add(Type item) {
		// Throw exception if item is null
		if (item == null) {
			throw new NullPointerException();
		}

		BinaryNode<Type> currentNode = new BinaryNode<Type>(item);

		// If this BST is empty, set the current node as the root
		if (rootNode == null) {
			rootNode = currentNode;
			
			size++;
			return true;
		}

		// If the BST is not empty, begin recursion to find
		// an appropriate place for the new node in the tree.
		return add(currentNode, rootNode);
	}

	/**
	 * A helper method for the add(Type item) method that recursively finds the
	 * proper placement for a new node in a balanced search tree.
	 * 
	 * @param newNode
	 *            The node to be inserted into this balanced search tree.
	 * @param parentNode
	 *            The current node in the balanced search tree to be compared
	 *            with the incoming new node.
	 * @return True if the new node has found its proper placement and has been
	 *         inserted into the balanced search tree.
	 */
	private boolean add(BinaryNode<Type> newNode, BinaryNode<Type> parentNode) {
		// Compare the newNode to the currentNode in the tree
		int compareNodes = (newNode.getData()).compareTo(parentNode.getData());

		// If the new node is greater than the parent...
		// Add new node as right child
		if (compareNodes > 0) {
			if (parentNode.getRightChild() == null) {
				parentNode.setLeftChild(newNode);
				newNode.setParent(parentNode);

				size++;
				return true;
			}
		}
		// If the new node is lesser than the parent...
		// Add new node as left child
		if (compareNodes < 0) {
			if (parentNode.getLeftChild() == null) {
				parentNode.setLeftChild(newNode);
				newNode.setParent(parentNode);
				
				size++;
				return true;
			}
		}

		// If the new node and parent node are equal...
		// Disregard the new node and break the recursion as the new node won't be added to the BST
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
	 * @throws NullPointerException
	 *             if any of the items is null
	 */
	@Override
	public boolean addAll(Collection<? extends Type> items) {
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
	 * @throws NullPointerException
	 *             if the item is null
	 */
	@Override
	public boolean contains(Type item) {
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
	 * @throws NullPointerException
	 *             if any of the items is null
	 */
	@Override
	public boolean containsAll(Collection<? extends Type> items) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns the first (i.e., smallest) item in this set.
	 * 
	 * @return The first item in this set.
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	@Override
	public Type first() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns true if this set contains no items.
	 * 
	 * @return True if this set contains no items.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns the last (i.e., largest) item in this set.
	 * 
	 * @return The last item in this set.
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	@Override
	public Type last() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Ensures that this set does not contain the specified item.
	 * 
	 * @param item
	 *            - the item whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that
	 *         is, if the input item was actually removed); otherwise, returns
	 *         false
	 * @throws NullPointerException
	 *             if the item is null
	 */
	@Override
	public boolean remove(Type item) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Ensures that this set does not contain any of the items in the specified
	 * collection.
	 * 
	 * @param items
	 *            - the collection of items whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that
	 *         is, if any item in the input collection was actually removed);
	 *         otherwise, returns false
	 * @throws NullPointerException
	 *             if any of the items are null
	 */
	@Override
	public boolean removeAll(Collection<? extends Type> items) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns the number of items in this set.
	 * 
	 * @return The number of items in this set.
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns an ArrayList containing all of the items in this set, in sorted
	 * order.
	 * 
	 * @return An ArrayList<Type> containing all of the items in this set, in
	 *         sorted order.
	 */
	@Override
	public ArrayList<Type> toArrayList() {
		// TODO Auto-generated method stub
		return null;
	}

}
