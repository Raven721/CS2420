package assign6;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * A generic and bespoke implementation of a linked list.
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 10/8/2015
 * 
 * @param <E>
 *            -- the type of elements contained in the list
 */
public class MyLinkedList<E> implements List<E> {
			
	/**
	 * Represents a single node of a generic linked list
	 */
	private class Node {
		
		private E item;
		private Node next;
		private Node prev;
		
		/**
		 * Constructor for making an empty node, i.e. for making the head or tail
		 * of a linked list
		 */
		public Node() {
			this(null, null, null);
		}
		
		/**
		 * Constructor for making a new node that isn't the head or tail
		 * of a linked list
		 * 
		 * @param _item The data to be contained in the node
		 * @param _prev A reference to the node that precedes this one in the linked list
		 * @param _next A reference to the item following this node in the linked list
		 */
		public Node(E _item, Node _prev, Node _next) {
			this.item = _item;
			this.prev = _prev;
			this.next = _next;
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	/**
	 * Constructor that creates two empty nodes which will serve
	 * as the head and the tail of a linked list.
	 */
	public MyLinkedList() {
		head = new Node();
		tail = new Node();
		
		// Initially reference the head as the beginning and tail as the end of the linked list
		head.next = tail;
		tail.prev = head;
		
		// Number of nodes in the linked list sans the head and tail
		size = 0;
	}
	
	/**
	 * Inserts the specified element at the beginning of the list.
	 * O(1) for a doubly-linked list.
	 */
	//@Override
	public void addFirst(E element) {
		Node temp = new Node(element, head, head.next);
		head.next.prev = temp;
		head.next = temp;
		
		// Increase the size of the LinkedList after adding the specified element
		size++;
	}

	/**
	 * Inserts the specified element at the end of the list.
	 * O(1) for a doubly-linked list.
	 */
	@Override
	public void addLast(E o) {
		Node temp = new Node(o, tail.prev, tail);
		tail.prev.next = temp;
		tail.prev = temp;
		
		// Increase the size of the LinkedList after adding the specified element
		size++;
	}

	/**
	 * Inserts the specified element at the specified position in the list.
	 * Throws IndexOutOfBoundsException if index is out of range.
	 * O(N) for a doubly-linked list.
	 */
	@Override
	public void add(int index, E element) throws IndexOutOfBoundsException {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		
		if(index == 0) {
			this.addFirst(element);
			return;
		} else if(index == this.size()) {
			this.addLast(element);
			return;
		}
		
		Node currentNode = getNode(index);
			
		Node newNode = new Node(element, currentNode.prev, currentNode);
		
		// Insert the new node into the LinkedList
		newNode.prev = currentNode;
		newNode.next = currentNode.next;
		newNode.prev.next = newNode;
		newNode.next.prev = newNode;
		
		// Increase the size of the LinkedList after adding the specified element
		size++;
	}

	/**
	 * Returns the first element in the list.
	 * Throws NoSuchElementException if the list is empty.
	 * O(1) for a doubly-linked list.
	 * 
	 * @return The first element in the LinkedList
	 */
	@Override
	public E getFirst() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("The LinkedList contains no elements");
		}
		
		return get(0);
	}

	/**
	 * Returns the last element in the list.
	 * Throws NoSuchElementException if the list is empty.
	 * O(1) for a doubly-linked list.
	 * 
	 * @return The last element in the LinkedList
	 */
	@Override
	public E getLast() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("The LinkedList contains no elements");
		}
	
		return get(size);
	}

	/**
	 * Returns the element at the specified position in the list.
	 * Throws IndexOutOfBoundsException if index is out of range.
	 * O(N) for a doubly-linked list.
	 * 
	 * @return The element at the specified index in the LinkedList
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		
		return get(index);
	}

	/**
	 * Returns a randomly-selected element from the list.
	 * Throws NoSuchElementException if the list is empty.
	 * O(N) for a doubly-linked list.
	 * 
	 * @return A randomly selected element in the linked list
	 */
	@Override
	public E getRandom() throws NoSuchElementException {
		// Generates a random number between 0 and size
		return getNode((new Random()).nextInt(size)).item;
	}

	/**
	 * Removes and returns the first element from the list.
	 * Throws NoSuchElementException if the list is empty.
	 * O(1) for a doubly-linked list.
	 * 
	 * @return The first element in the LinkedList that is to be removed
	 */
	@Override
	public E removeFirst() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("The LinkedList contains no elements");
		}
		
		Node temp = head.next;
		temp.prev.next = head;
		head.next = temp.next;
		
		// Decrease the size of the LinkedList after removing the specified element
		size--;
		
		return temp.item;
	}

	/**
	 * Removes and returns the last element from the list.
	 * Throws NoSuchElementException if the list is empty.
	 * O(1) for a doubly-linked list.
	 * 
	 * @return The last element in the LinkedList that is to be removed
	 */
	@Override
	public E removeLast() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("The LinkedList contains no elements");
		}
		
		Node temp = tail.prev;
		temp.prev.next = tail;
		tail.prev = temp.prev;
		
		// Decrease the size of the LinkedList after removing the specified element
		size--;
		
		return temp.item;
	}

	/**
	 * Removes and returns the element at the specified position in the list.
	 * Throws IndexOutOfBoundsException if index is out of range.
	 * O(N) for a doubly-linked list.
	 * 
	 * @return The element to be removed from the LinkedList
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("The specified index is out of bounds");
		}
		
		Node temp = getNode(index);
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		
		// Decrease the size of the LinkedList after removing the specified element
		size--;
		
		return temp.item;
	}

	/**
	 * Helper method that retrieves the node in the linked list at a specified index
	 * 
	 * @param index The index of the node to be returned
	 * 
	 * @return The node at the specified index
	 */
	private MyLinkedList<E>.Node getNode(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("The specified index is out of bounds");
		}
		
		Node currentNode = head;
		
		// Traverse through the linked list up to the specified index
		for(int i = 0; i <= index; i++) {
			currentNode = currentNode.next;
		}
		
		return currentNode;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in the list, 
	 * or -1 if this list does not contain the element.
	 * O(N) for a doubly-linked list.
	 * 
	 * @return The index of the first occurrence of the specified element
	 */
	@Override
	public int indexOf(E element) {
		Node currentNode = head.next;
		
		// Traverse through the linked list, starting at the oldest node to the most recent node
		for(int i = 0; i < size; i++) {
			if(currentNode.item.equals(element)) {
				return i;
			}
			
			currentNode = currentNode.next;
		}
		
		// Return -1 if the element is not found in the LinkedList
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in this list, 
	 * or -1 if this list does not contain the element.
	 * O(N) for a doubly-linked list.
	 * 
	 * @return The index of the last occurrence of the specified element
	 */
	@Override
	public int lastIndexOf(E element) {
		Node currentNode = tail.prev;
		
		// Traverse through the linked list, starting at the most recent node to the oldest
		for(int i = size - 1; i >= 0; i--) {
			if(currentNode.item.equals(element)) {
				return i;
			}
			
			currentNode = currentNode.prev;
		}
		
		// Return -1 if the element is not found in the LinkedList
		return -1;
	}

	/**
	 * Returns the number of elements in this list.
	 * O(1) for a doubly-linked list.
	 * 
	 * @return The number of elements in the LinkedList
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns true if this collection contains no elements.
	 * O(1) for a doubly-linked list.
	 * 
	 * @return True if the LinkedList is empty
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Removes all of the elements from this list.
	 * O(1) for a doubly-linked list.
	 */
	@Override
	public void clear() {
		// Reset reference pointers
		head.next = tail;
		tail.prev = head;
		
		// Reset the number of nodes to baseline
		size = 0;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence 
	 * (from first to last element).
	 * O(N) for a doubly-linked list.
	 * 
	 * @Return An array of the node data in the linked list, in order from head to tail
	 */
	@Override
	public Object[] toArray() {
		Object[] nodeArray = new Object[size];
		Node currentNode = head.next;
		
		// Traverse through the LinkedList
		for(int i = 0; i < size; i++) {
			nodeArray[i] = currentNode.item;
			currentNode = currentNode.next;
		}
		
		return nodeArray;
	}
}
