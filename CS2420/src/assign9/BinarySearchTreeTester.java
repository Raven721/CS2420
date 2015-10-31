package assign9;

import static org.junit.Assert.*;

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
	}

	@Test
	public void testBSTtoArrayList() {
		// Returning the nodes of an in-order traversal should return a sorted list of the tree items
		tree.add(12);
		tree.add(45);
		tree.add(93);
		tree.add(32);

		assertEquals("[12, 32, 45, 93]", tree.toArrayList().toString());
	}

	@Test
	public void testBSTFirst() {
		// The first item in the tree should be the smallest
		tree.add(12);
		tree.add(45);
		tree.add(93);
		tree.add(32);

		assertEquals((Integer) 12, tree.first());
	}

	@Test
	public void testBSTLast() {
		// The last item in the tree should be the largest
		tree.add(12);
		tree.add(45);
		tree.add(93);
		tree.add(32);

		assertEquals((Integer) 93, tree.last());
	}

}
