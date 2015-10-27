package assign8;

import static org.junit.Assert.*;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import assign6.MyLinkedList;

/**
 * A testing suite for the GraphUtil class
 *
 * @author Tim Ellenberger, ellenber
 * @author John Strasser, strasser
 * @author Erin Parker
 * @version 10/29/2015
 */
public class GraphUtilTester {
	
	List<String> path;
	Graph graph;

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		graph = new Graph();
	}
	
//	//////////// breadthFirstSearch(String filename, String start, String end) //////////// 
//	@Test
//	public void testBreadthFirstSearch() {
//		List<String> path = GraphUtil.breadthFirstSearch("src\\Tests\\ExampleTests\\examplegraph.dot", "Vertex 1", "Vertex 2");
//		System.out.println(path.toString());
//	}
//	
	//////////// topologicalSort(String filename) //////////// 
	@Test
	public void testTopographicalSortWithExampleGraph() {
		exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph.dot");
	}
	
	@Test
	public void testTopographicalSortWithExampleGraph2() {
		exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph2.dot");
	}
	
	@Test
	public void testTopographicalSortWithExampleGraph3() {
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph3.dot");
		System.out.println("Example3graph.dot:");
		System.out.println("\t" + path.toString());
	}

	@Test
	public void testTopographicalSortWithExampleGraph4() {
		exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph4.dot");
	}
	
	@Test
	public void testTopographicalSortWithExampleGraph5() {
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph5.dot");
		System.out.println("Example5graph.dot:");
		System.out.println("\t" + path.toString());
	}
	
	@Test
	public void testTopographicalSortWithExampleGraph6() {
		exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph6.dot");
		System.out.println(path.toString());
	}
	
	@Test
	public void testTopographicalSortWithExampleGraph7() {
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph7.dot");
		System.out.println(path.toString());
	}
	
	@Test
	public void testTopographicalSortWithExampleGraph8() {
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph8.dot");
		System.out.println(path.toString());
	}
	
	@Test
	public void testTopographicalSortWithExampleGraph9() {
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph9.dot");
		System.out.println(path.toString());
	}
	
	//////////// buildGraphFromDot ////////////
	@Test
	public void testBuildGraphFromDotWithDirectedInput() {
		graph = GraphUtil.buildGraphFromDot("src\\assign8\\Tests\\ExampleTests\\examplegraph.dot");
		
		assertTrue(graph.getDirected());
	}
	
	@Test
	public void testBuildGraphFromDotWithUndirectedInput() {
		graph = GraphUtil.buildGraphFromDot("src\\assign8\\Tests\\ExampleTests\\examplegraph9.dot");
		
		assertFalse(graph.getDirected());
	}
}
