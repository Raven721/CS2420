package assign9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * A testing suite for the BinarySearchTree class.
 * 
 * @author Tim Ellenberger, ellenber
 * @author John Strasser, strasser
 * @version 11/05/2015
 */
public class BinarySearchTreeTester {

	BinarySearchTree<Integer> tree;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		tree = new BinarySearchTree<Integer>();
		
		tree.add(12);
		tree.add(45);
		tree.add(93);
		tree.add(32);
	}
	
	//////// add(Type item) /////////
	@Test
	public void testBSTaddAll()
	{
		// Adding a collection of items should work the same as the regular add method
		tree = new BinarySearchTree<Integer>();

		Collection<Integer> coll = new ArrayList<Integer>();
		coll.add(12);
		coll.add(45);
		coll.add(93);
		coll.add(32);
		
		tree.addAll(coll);
		
		assertTrue(tree.containsAll(coll));
		assertEquals("[12, 32, 45, 93]", tree.toArrayList().toString());
	}
	
	//////// toArrayList() /////////
	@Test
	public void testBSTtoArrayList() {
		// Returning the nodes of an in-order traversal should return a sorted list of the tree items
		assertEquals("[12, 32, 45, 93]", tree.toArrayList().toString());
	}

	//////// first() /////////
	@Test
	public void testBSTFirst() {
		// The first item in the tree should be the smallest
		assertEquals((Integer) 12, tree.first());
	}

	//////// last() /////////
	@Test
	public void testBSTLast() {
		// The last item in the tree should be the largest
		assertEquals((Integer) 93, tree.last());
	}
	
	//////// size() /////////
	@Test
	public void testBSTSize() {
		// The size of this tree should be 4 items
		assertEquals(4, tree.size());
	}
	
	//////// contains(Type item) /////////
	@Test
	public void testBSTContains() {
		// This tree should contain 12, 45, 93 and 32
		assertTrue(tree.contains(12));
		assertTrue(tree.contains(45));
		assertTrue(tree.contains(93));
		assertTrue(tree.contains(32));
	}
	
	//////// containsAll(Collection c) /////////
	@Test
	public void testBSTContainsAll() {
		// This tree should contain 12, 45, 93 and 32
		Collection<Integer> coll = new ArrayList<Integer>();
		
		coll.add(12);
		coll.add(45);
		coll.add(93);
		coll.add(32);
		
		assertTrue(tree.containsAll(coll));
	}
	
	//////// isEmpty() /////////
	@Test
	public void testBSTisEmpty() {
		// A tree with zero items (size of 0), should return true when asked if the tree is empty
		tree = new BinarySearchTree<Integer>();
		
		assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());
	}
	
	//////// generateDotFromBST(String filename)  /////////
	@Test
	public void testGenerateDotFromBST(){
		tree = new BinarySearchTree<Integer>();
		tree.add(12);
		tree.add(45);
		tree.add(93);
		tree.add(32);
		tree.add(9);
		tree.add(2);
		tree.add(5);
		tree.add(78);
		tree.add(112);
		tree.add(113);
		tree.add(116);
		tree.add(31);	
		
		tree.generateDotFromBST("src/assign9/ref/test.dot");
		
		tree.remove(5);
		tree.generateDotFromBST("src/assign9/ref/test2.dot");
	}

}
