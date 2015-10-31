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
	 * The default constructor for a BinarySearchTree
	 */
	public BinarySearchTree() {
		rootNode = null;
		size = 0;
	}

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
		// Disregard the new node and break the recursion as the new node won't
		// be added to the BST
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
		int initialSize = size();

		// Attempt to insert every item in this collection into this BST
		for (Type t : items) {
			// Throw an exception if the current item is null
			if (t == null) {
				throw new NullPointerException();
			}

			add(t);
		}

		// If this BST's size has increased by at least one node, return true
		return (size() > initialSize);
	}

	/**
	 * Removes all items from this set. The set will be empty after this method
	 * call.
	 */
	@Override
	public void clear() {
		rootNode = null;
		size = 0;
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
		// Throw exception if item is null
		if (item == null) {
			throw new NullPointerException();
		}

		BinaryNode<Type> currentNode = new BinaryNode<Type>(item);

		// If this BinarySearchTree is empty, it cannot contain this item
		if (isEmpty()) {
			return false;
		}

		// If this BST is not empty, traverse through the tree recursively
		return contains(currentNode, rootNode);
	}

	/**
	 * A helper method for the contains(Type item) method that recursively
	 * traverses this binary search tree and compares the current node with a
	 * node to be found in the tree.
	 * 
	 * @param searchNode
	 *            The node to be searched for in this binary search tree.
	 * @param currentNode
	 *            The current node for comparison in this binary search tree.
	 * @return True if this binary search tree contains the searchNode.
	 */
	private boolean contains(BinaryNode<Type> searchNode, BinaryNode<Type> currentNode) {
		// Compare the newNode to the currentNode in the tree
		int compareNodes = (searchNode.getData()).compareTo(currentNode.getData());

		// If the search node is equivalent to the current node...
		// Stop the search and return true
		if (compareNodes == 0) {
			return true;
		}

		// If the search node is greater than the current node...
		// Traverse to the right child of the current node
		if (compareNodes > 0) {
			if (searchNode.getLeftChild() != null) {
				return contains(searchNode, currentNode.getLeftChild());
			}
		}

		// If the search node is less than the current node...
		// Traverse to the left child of the current node
		if (compareNodes < 0) {
			if (searchNode.getRightChild() != null) {
				return contains(searchNode, currentNode.getRightChild());
			}
		}

		// If the search node is never found after traversing the BST, return false
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
		// Attempt to search for every item in this collection in this BST
		for (Type t : items) {
			// Throw an exception if the current item is null
			if (t == null) {
				throw new NullPointerException();
			}

			// If the current item is not in this binary search tree, return
			// false
			if (!contains(t)) {
				return false;
			}
		}

		return true;
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
		// If this binary search tree is empty, throw an exception
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		// Return the left-most node in this binary search tree
		return rootNode.getLeftmostNode().getData();
	}

	/**
	 * Returns true if this set contains no items.
	 * 
	 * @return True if this set contains no items.
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0);
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
		// If this binary search tree is empty, throw an exception
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		// Return the right-most node in this binary search tree
		return rootNode.getRightmostNode().getData();
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
		return size;
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
