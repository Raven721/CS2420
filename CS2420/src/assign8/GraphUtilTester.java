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
 * @author John Strasser, strasser
 * @author Erin Parker
 * @version 10/29/2015
 */
public class GraphUtilTester {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
//	//////////// breadthFirstSearch(String filename, String start, String end) //////////// 
//	@Test
//	public void testBreadthFirstSearch() {
//		List<String> path = GraphUtil.breadthFirstSearch("src\\Tests\\ExampleTests\\examplegraph.dot", "Vertex 1", "Vertex 2");
//		System.out.println(path.toString());
//	}
//	
	//////////// topologicalSort(String filename) //////////// 
	@Test
	public void testTopographical() {
		List<String> path =  GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph3.dot");
		System.out.println(path.toString());
	}
	
	//////////// buildGraphFromDot ////////////
	@Test
	public void testBuildGraphFromDotWithDirectedInput() {
		Graph g = new Graph();
		System.out.println(System.getProperty("user.dir"));
		g = GraphUtil.buildGraphFromDot("src\\assign8\\Tests\\ExampleTests\\examplegraph.dot");
		
		assertTrue(g.getDirected());
	}
	
	@Test
	public void testBuildGraphFromDotWithUndirectedInput() {
		Graph g = new Graph();
		g = GraphUtil.buildGraphFromDot("src\\assign8\\Tests\\ExampleTests\\examplegraph9.dot");
		
		assertFalse(g.getDirected());
	}
}
