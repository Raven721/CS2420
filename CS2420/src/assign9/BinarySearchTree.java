package assign9;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A class representation of a binary search tree.
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
	 * @param currentNode
	 *            The current node in the balanced search tree to be compared
	 *            with the incoming new node.
	 * @return True if the new node has found its proper placement and has been
	 *         inserted into the balanced search tree.
	 */
	private boolean add(BinaryNode<Type> newNode, BinaryNode<Type> currentNode) {
		// Compare the newNode to the currentNode in the tree
		int compareNodes = newNode.getData().compareTo(currentNode.getData());

		// If the new node is greater than the current node...
		// Try to add new node as right child
		if (compareNodes > 0) {
			if (currentNode.getRightChild() == null) {
				currentNode.setRightChild(newNode);
				newNode.setParent(currentNode);

				size++;
				return true;
			} else {
				return add(newNode, currentNode.getRightChild());
			}
		}
		// If the new node is lesser than the current node...
		// Try to add new node as left child
		if (compareNodes < 0) {
			if (currentNode.getLeftChild() == null) {
				currentNode.setLeftChild(newNode);
				newNode.setParent(currentNode);

				size++;
				return true;
			} else {
				return add(newNode, currentNode.getLeftChild());
			}
		}

		// If the new node and current node are equal...
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
		// Attempt to insert every item in this collection into this BST.
		// If the add method reports that an item was not added to this BST,
		// return false.
		for (Type t : items) {
			// Throw an exception if the current item is null
			if (t == null) {
				throw new NullPointerException();
			}

			// Attempt to add item from collection to tree
			add(t);
		}

		// If the size of the tree has increased by at least one node, return true;
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
		int compareNodes = searchNode.getData().compareTo(currentNode.getData());

		// If the search node is equivalent to the current node...
		// Stop the search and return true
		if (compareNodes == 0) {
			return true;
		}

		// If the search node is greater than the current node...
		// Traverse to the right child of the current node
		if (compareNodes > 0) {
			if (currentNode.getRightChild() != null) {
				return contains(searchNode, currentNode.getRightChild());
			}
		}

		// If the search node is less than the current node...
		// Traverse to the left child of the current node
		if (compareNodes < 0) {
			if (currentNode.getLeftChild() != null) {
				return contains(searchNode, currentNode.getLeftChild());
			}
		}

		// If the search node is never found after traversing the BST, return
		// false
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
	 * Searches for a node in this binary search tree using an input item.
	 * 
	 * @param searchItem
	 *            The item to be found in this binary search tree.
	 * @param currentNode
	 *            The current node for comparison to the searchItem.
	 * 
	 * @return The node containing the searchItem data.
	 */
	private BinaryNode<Type> findNode(Type searchItem, BinaryNode<Type> currentNode) {
		// Compare the search item to the currentNode in the tree
		int compareNodes = searchItem.compareTo(currentNode.getData());

		// If the search item is equivalent to the current node data...
		// Stop the search and return true
		if (compareNodes == 0) {
			return currentNode;
		}

		// If the search item is greater than the current node data...
		// Traverse to the right child of the current node
		if (compareNodes > 0) {
			if (currentNode.getRightChild() != null) {
				return findNode(searchItem, currentNode.getRightChild());
			}
		}

		// If the search item is less than the current node data...
		// Traverse to the left child of the current node
		if (compareNodes < 0) {
			if (currentNode.getLeftChild() != null) {
				return findNode(searchItem, currentNode.getLeftChild());
			}
		}

		// If the search item is never found, return null
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
		int initialSize = size();

		// Throw an exception if the input item is null
		if (item == null) {
			throw new NullPointerException();
		}

		// Check if the item to be removed is actually in this BST
		if (!contains(item)) {
			return false;
		}

		// If the BST only has a single node, clear the tree and return true
		if (size() == 1) {
			this.clear();
			return true;
		} 
		
		// If the tree is empty, it is impossible to remove anything
		if (isEmpty()) {
			return false;
		}

		// Find the node in the tree that needs to be removed
		// And begin the removal process
		remove(findNode(item, rootNode));

		return (size() < initialSize);
	}

	/**
	 * A helper method for the remove method, that does the actual node deletion
	 * from this binary search tree.
	 * 
	 * @param currentNode
	 *            The node to be removed from this binary search tree.
	 * @return True if the specified node is successfully removed from this
	 *         binary search tree.
	 */
	// TODO: Not thoroughly tested
	private boolean remove(BinaryNode<Type> currentNode) {

		// CASE A --leaf node: simply delete it
		if (currentNode.isLeafNode()) {
			return removeLeafNode(currentNode);
		}

		// CASE B(i) -- Node with one (left)child
		if (currentNode.hasLeftChildOnly()) {
			return removeNodeWithOneChild(currentNode);
		}

		// CASE B(ii) -- Node with one (right)child
		if (currentNode.hasRightChildOnly()) {
			return removeNodeWithOneChild(currentNode);
		}

		// CASE C -- Node with two children
		if (currentNode.hasTwoChildren()) {
			return removeNodeWithTwoChildren(currentNode);
		}

		return false;
	}

	/**
	 * Helper method of the remove method that removes a specified leaf node
	 * from this binary search tree.
	 * 
	 * @param currentNode
	 *            The leaf node to be removed from this binary search tree.
	 * @return True if the specified node was successfully removed.
	 */
	private boolean removeLeafNode(BinaryNode<Type> currentNode) {
		BinaryNode<Type> parentNode = currentNode.getParent();

		// Remove the parent node's reference to the current node
		if (currentNode.isLeftChild()) {
			parentNode.setLeftChild(null);

			size--;

			// Removal Successful
			return true;
		}

		if (currentNode.isRightChild()) {
			parentNode.setRightChild(null);

			size--;

			// Removal Successful
			return true;
		}

		return false;
	}

	/**
	 * Helper method of the remove method that removes a specified node with
	 * exactly one child from this binary search tree.
	 * 
	 * @param currentNode
	 *            The node to be removed from this binary search tree.
	 * @return True if the specified node was successfully removed.
	 */
	private boolean removeNodeWithOneChild(BinaryNode<Type> currentNode) {
		// CASE B(i) -- Node with one (left)child
		if (currentNode.hasLeftChildOnly()) {
			BinaryNode<Type> parentNode = currentNode.getParent();

			// Give currentNode's left child to currentNode's parent
			if (currentNode.isLeftChild()) {
				parentNode.setLeftChild(currentNode.getLeftChild());

				size--;

				// Removal Successful
				return true;
			}

			if (currentNode.isRightChild()) {
				parentNode.setRightChild(currentNode.getLeftChild());

				size--;

				// Removal Successful
				return true;
			}
		}

		// CASE B(ii) -- Node with one (right)child
		if (currentNode.hasRightChildOnly()) {
			BinaryNode<Type> parentNode = currentNode.getParent();

			// Give currentNode's left child to currentNode's parent
			if (currentNode.isLeftChild()) {
				parentNode.setLeftChild(currentNode.getRightChild());

				size--;

				// Removal Successful
				return true;
			}

			if (currentNode.isRightChild()) {
				parentNode.setRightChild(currentNode.getRightChild());

				size--;

				// Removal Successful
				return true;
			}
		}

		return false;
	}

	/**
	 * Helper method of the remove method that removes a specified node with
	 * exactly two children from this binary search tree.
	 * 
	 * @param currentNode
	 *            The node to be removed from this binary search tree.
	 * @return True if the specified node was successfully removed.
	 */
	private boolean removeNodeWithTwoChildren(BinaryNode<Type> currentNode) {
		// CASE C -- Node with two children
		if (currentNode.hasTwoChildren()) {
			// currentNode's successor is the smallest node in its right subtree
			BinaryNode<Type> successorNode = currentNode.getRightChild().getLeftmostNode();

			// Replace the node's data with that of the smallest node
			// of its right subtree (its successor)
			currentNode.setData(successorNode.getData());

			// Remove the successor node (guaranteed to have at most one child)
			return remove(successorNode);
		}

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
		int initialSize = size();
		// Attempt to remove each item in the collection from this BST.
		// If the remove method reports that an item hasn't
		// been removed, return false.
		for (Type t : items) {
			if (t == null) {
				throw new NullPointerException();
			}

			// Attempt to remove current collection item from tree
			remove(t);
		}

		// If the size of the tree has decreased by at least one node, return true
		return (size() < initialSize);
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
		ArrayList<Type> sortedNodeList = new ArrayList<Type>();

		// Return an empty list if this BST is empty
		if (isEmpty()) {
			return sortedNodeList;
		}

		// If this binary search tree isn't empty...
		// Begin recursive in-order traversal of the tree starting at the root
		inOrderTraversal(sortedNodeList, rootNode);

		return sortedNodeList;
	}

	/**
	 * A helper method for the toArrayList method that recursively performs an
	 * in-order traversal of this binary search tree, while storing each node as
	 * it is found into an ArrayList
	 * 
	 * @param sortedList
	 *            An ArrayList to store and return the list of sorted nodes in
	 *            this binary search tree.
	 * @param currentNode
	 *            The node currently being examined.
	 */
	private void inOrderTraversal(ArrayList<Type> sortedList, BinaryNode<Type> currentNode) {
		// Go to the left-most child in the tree before considering a
		// right-child
		if (currentNode.getLeftChild() != null) {
			inOrderTraversal(sortedList, currentNode.getLeftChild());
		}

		// Add the currently left-most child to the list
		sortedList.add(currentNode.getData());

		// If there are no more left-children, look for a right child
		if (currentNode.getRightChild() != null) {
			inOrderTraversal(sortedList, currentNode.getRightChild());
		}

	}

	/**
	 * Builds a dot file from this binary search tree.
	 * 
	 * @param filename
	 *            The path + filename where the dot file will be created.
	 */
	public void generateDotFromBST(String filename) {
		PrintWriter out = null;

		// Make sure the input file exists
		try {
			out = new PrintWriter(filename);
		} catch (IOException e) {
			System.out.println(e);
		}

		// Open the graph
		out.println("digraph G {");
		out.println("node [shape=circle, color=black]");

		ArrayList<String> nodeToNodeList = new ArrayList<String>();

		buildDotFromNodes(rootNode, nodeToNodeList);

		for (String s : nodeToNodeList) {
			out.println(s);
		}

		// Close the graph
		out.println("}");
		out.close();
	}

	/**
	 * Helper method for the generateDotFromBST method that recursively builds a
	 * list of nodes and their connected nodes for building the dot file.
	 * 
	 * @param currentNode
	 *            The current node being logged in the list.
	 * @param nodeToNodeList
	 *            List of nodes and their connections in this binary search
	 *            tree.
	 */
	private void buildDotFromNodes(BinaryNode<Type> currentNode, List<String> nodeToNodeList) {
		if (currentNode.getLeftChild() != null) {
			buildDotFromNodes(currentNode.getLeftChild(), nodeToNodeList);
			styleDotEdge(currentNode.getLeftChild(), nodeToNodeList);
			nodeToNodeList.add("\t" + currentNode.getData() + "->" + currentNode.getLeftChild().getData());
		}

		if (currentNode.getRightChild() != null) {
			buildDotFromNodes(currentNode.getRightChild(), nodeToNodeList);
			styleDotEdge(currentNode.getRightChild(), nodeToNodeList);
			nodeToNodeList.add("\t" + currentNode.getData() + "->" + currentNode.getRightChild().getData());
		}

	}

	/**
	 * Helper method for the buildDotFromNodes method that colors the edges of
	 * dot graph blue if it points to a left child or red if it points to a
	 * right child.
	 * 
	 * @param currentNode
	 *            The current node being pointed to in the dot graph.
	 * @param nodeToNodeList
	 *            The list of node connections in the dot graph.
	 */
	private void styleDotEdge(BinaryNode<Type> currentNode, List<String> nodeToNodeList) {
		if (currentNode.isLeftChild()) {
			nodeToNodeList.add("edge [dir=right color=\"blue\"]");
		} else if (currentNode.isRightChild()) {
			nodeToNodeList.add("edge [dir=right color=\"red\"]");
		} else {
			nodeToNodeList.add("edge [dir=right color=\"black\"]");
		}

	}

}
