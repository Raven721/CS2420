package assign8;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * A testing suite for the GraphUtil class
 *
 * @author Tim Ellenberger, ellenber
 * @author John Strasser
 * @author Erin Parker
 * @version 10/29/2015
 */
public class GraphUtilTester {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testGraphUtilWithValidInput() {
		GraphUtil.topologicalSort("src\\Tests\\ExampleTests\\examplegraph.dot");
	}
}
