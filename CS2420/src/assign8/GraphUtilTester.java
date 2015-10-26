package assign8;

import static org.junit.Assert.*;

import java.util.List;

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
	
	//////////// breadthFirstSearch(String filename, String start, String end) //////////// 
	@Test
	public void testBreadthFirstSearch() {
		List<String> path = GraphUtil.breadthFirstSearch("src\\Tests\\ExampleTests\\examplegraph.dot", "Vertex 1", "Vertex 2");
		System.out.println(path.toString());
	}
	
	//////////// topologicalSort(String filename) //////////// 
	@Test
	public void testTopographical() {
		List<String> path =  GraphUtil.topologicalSort("src\\Tests\\ExampleTests\\examplegraph.dot");
		System.out.println(path.toString());
	}
}
