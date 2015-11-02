package assign9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

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
	
	//////// add(Type item) ////////
	@Test
	public void testadd() {
		// The tree should return the correct information after adding each item
		tree = new BinarySearchTree<Integer>();
		
		assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());
		
		tree.add(12);
		assertFalse(tree.isEmpty());
		assertTrue(tree.contains(12));
		assertEquals(1, tree.size());
		
		tree.add(45);
		assertFalse(tree.isEmpty());
		assertTrue(tree.contains(45));
		assertEquals(2, tree.size());
		
		tree.add(93);
		assertFalse(tree.isEmpty());
		assertTrue(tree.contains(45));
		assertEquals(3, tree.size());
		
		tree.add(32);
		assertFalse(tree.isEmpty());
		assertTrue(tree.contains(32));
		assertEquals(4, tree.size());
		
		assertEquals("[12, 32, 45, 93]", tree.toArrayList().toString());
	}
	
	@Test
	public void testaddWithNullItem() {
		// The add method should throw an exception when given a null item
		exception.expect(NullPointerException.class);
		tree.add(null);
	}
	
	//////// addAll(Collection c) /////////
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
		
		assertTrue(tree.addAll(coll));
		
		
		assertTrue(tree.containsAll(coll));
		assertEquals("[12, 32, 45, 93]", tree.toArrayList().toString());
	}
	
	@Test
	public void testBSTaddAllWithNullItem()
	{
		// Adding a collection to the tree with a null item should throw an exception 
		tree = new BinarySearchTree<Integer>();

		Collection<Integer> coll = new ArrayList<Integer>();
		coll.add(null);
		
		exception.expect(NullPointerException.class);
		tree.addAll(coll);
		
	}
	
	
	//////// removeAll(Collection c) /////////
	@Test
	public void testBSTremoveAll()
	{
		// Adding a bunch of items, and removing a few of them should pass all tests
		tree = new BinarySearchTree<Integer>();
		tree.add(12);
		tree.add(45);
		tree.add(93);
		tree.add(32);
		tree.add(9);
		tree.add(2);
		tree.add(3);
		tree.add(78);
		tree.add(112);
		tree.add(113);
		tree.add(116);
		tree.add(31);	
		tree.add(10);
		
		// Verify that these items currently exist in the tree
		assertTrue(tree.contains(12));
		assertTrue(tree.contains(45));
		assertTrue(tree.contains(93));
		assertTrue(tree.contains(32));
		
		// Verify the current size of the tree
		assertEquals(13, tree.size());

		Collection<Integer> coll = new ArrayList<Integer>();
		coll.add(12);
		coll.add(45);
		coll.add(93);
		coll.add(32);
		
		// Remove the above items from the tree
		assertTrue(tree.removeAll(coll));
		
		// Verify that these items are no longer in the tree
		assertFalse(tree.contains(12));
		assertFalse(tree.contains(45));
		assertFalse(tree.contains(93));
		assertFalse(tree.contains(32));
		
		// Verify the current size of the tree has shrunk by 4 items
		assertEquals(9, tree.size());
		
		assertEquals("[2, 3, 9, 10, 31, 78, 112, 113, 116]", tree.toArrayList().toString());
	}
	
	@Test 
	public void testBSTremoveAllWithEmptyTree() {
		// The current tree does not contain a value of 415
		tree = new BinarySearchTree<Integer>();
		
		Collection<Integer> coll = new ArrayList<Integer>();
		coll.add(415);
		
		// Verify that the tree does not contain a value of 415
		assertFalse(tree.contains(415));
		
		// Should return false because '415' is not in the tree
		assertFalse(tree.removeAll(coll));
	}
	
	@Test 
	public void testBSTremoveAllWithNonExistentNode() {
		// The current tree does not contain a value of 415
		tree = new BinarySearchTree<Integer>();
		tree.add(415);
		tree.add(12);
		
		Collection<Integer> coll = new ArrayList<Integer>();
		coll.add(35);
		coll.add(25);
		
		// Verify that the tree does not contain a value of 415
		assertFalse(tree.contains(35));
		assertFalse(tree.contains(25));
		
		// Should return false because none of the items in the collection are in the tree
		assertFalse(tree.removeAll(coll));
	}
	
	//////// toArrayList() /////////
	@Test
	public void testBSTtoArrayList() {
		// Returning the nodes of an in-order traversal should return a sorted list of the tree items
		assertEquals("[12, 32, 45, 93]", tree.toArrayList().toString());
	}
	
	@Test
	public void testBSTtoArrayListWithEmptyTree(){
		// An empty tree should result in toArrayList returns an empty list
		tree = new BinarySearchTree<Integer>();
		
		assertEquals("[]", tree.toArrayList().toString());
	}
	
	@Test
	public void testBSTtoArrayListWithOneNodeTree(){
		// A BST with one node should return a one node list from toArrayList
		tree = new BinarySearchTree<Integer>();
		tree.add(12);
		
		assertEquals("[12]", tree.toArrayList().toString());
	}

	//////// first() /////////
	@Test
	public void testBSTFirst() {
		// The first item in the tree should be the smallest
		assertEquals((Integer) 12, tree.first());
	}
	
	@Test
	public void testBSTFirstWithOneNodeTree() {
		// The first item in this tree should be 12 as it is the only item
		tree = new BinarySearchTree<Integer>();
		tree.add(12);
		
		assertEquals((Integer)12, tree.first());
	}
	
	@Test
	public void testBSTFirstWithEmptyTree() {
		// This test should throw an exception because the tree is empty
		tree = new BinarySearchTree<Integer>();
		
		exception.expect(NoSuchElementException.class);
		tree.first();
	}

	//////// last() /////////
	@Test
	public void testBSTLast() {
		// The last item in the tree should be the largest
		assertEquals((Integer) 93, tree.last());
	}
	
	@Test
	public void testBSTLastWithOneNodeTree() {
		// The last item in this tree should be 12 as it is the only item
		tree = new BinarySearchTree<Integer>();
		tree.add(12);
				
		assertEquals((Integer) 12, tree.last());
	}
	
	@Test
	public void testBSTLastWithEmptyTree() {
		// This test should throw an exception because the tree is empty
		tree = new BinarySearchTree<Integer>();
		
		exception.expect(NoSuchElementException.class);
		tree.last();
	}
	
	//////// size() /////////
	@Test
	public void testBSTSize() {
		// The size of this tree should be 4 items
		assertEquals(4, tree.size());
	}
	
	@Test
	public void testBSTSizeWithEmptyTree() {
		// The size of this tree empty tree should be 0 items
		tree = new BinarySearchTree<Integer>();
		
		assertEquals(0, tree.size());
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
	
	@Test
	public void testBSTContainsWithNonexistingNode() {
		// This tree does not contain '415' and should fail when asked if it exists
		assertFalse(tree.contains(415));
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
	
	@Test
	public void testBSTContainsAllWithNonexistingNode() {
		// This tree does not contain '415' and should fail when asked if it exists
		Collection<Integer> coll = new ArrayList<Integer>();
		
		coll.add(415);
		
		assertFalse(tree.containsAll(coll));
	}
	
	//////// isEmpty() /////////
	@Test
	public void testBSTisEmptyWithEmptyTree() {
		// A tree with zero items (size of 0), should return true when asked if the tree is empty
		tree = new BinarySearchTree<Integer>();
		
		assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());
	}
	
	@Test
	public void testBSTisEmptyWithNonTree() {
		// A tree with four nodes should return false when asked if empty
		assertEquals(4, tree.size());
		assertFalse(tree.isEmpty());
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
		tree.add(3);
		tree.add(78);
		tree.add(112);
		tree.add(113);
		tree.add(116);
		tree.add(31);	
		tree.add(10);
		
		tree.generateDotFromBST("src/assign9/ref/test.dot");
		
		tree.remove(12);
		tree.generateDotFromBST("src/assign9/ref/test2.dot");
	}

}
