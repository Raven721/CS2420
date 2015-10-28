package assign8;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
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
	
	List<String> path;
	Graph graph;
	String Expected, Actual;

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		graph = new Graph();
	}
	
	//////////// breadthFirstSearch(String filename, String start, String end) //////////// 
	@Test
	public void testBreadthFirstSearch() {
		path = GraphUtil.breadthFirstSearch("src\\assign8\\Tests\\ExampleTests\\examplegraph5.dot", "1", "5");
		System.out.println("Example2graph with BFS.dot:");
		System.out.println("\t" + path.toString());
	}
	
	@Test
	public void testBFSWithSameStartAndEndVertex() {
		// If the Start and End vertices are the same, the output string should be that vertex.
		path = GraphUtil.breadthFirstSearch("src\\assign8\\Tests\\ExampleTests\\examplegraph5.dot", "1", "1");
		System.out.println("Example2graph with BFS.dot:");
		System.out.println("\t" + path.toString());
		
		Expected = "[1]";
		Actual = path.toString();
		
		assertEquals(Expected, Actual);
	}
	
	@Test
	public void testBFSWithNonExistentStartingVertex(){
		// This test should fail because the input file does not contain the specified start vertex
		exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.breadthFirstSearch("src\\assign8\\Tests\\ExampleTests\\examplegraph5.dot", "0", "5");
	}
	
	@Test
	public void testBFSWithNonExistentEndingVertex(){
		// This test should fail because the input file does not contain the specified end vertex
		exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.breadthFirstSearch("src\\assign8\\Tests\\ExampleTests\\examplegraph5.dot", "1", "6");
	}
	
	@Test
	public void testBFSWithNonExistentEndingAndEndingVertex(){
		// This test should fail because the input file does not contain the specified start or end vertex
		exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.breadthFirstSearch("src\\assign8\\Tests\\ExampleTests\\examplegraph5.dot", "0", "6");
	}
	
	@Test
	public void testBFSWithCreatedUndirectedGraph() {
		// This test should fail because the input graph is undirected
		exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\CreatedTests\\undirectedGraph.dot");
	}
	
	//////////// topologicalSort(String filename) //////////// 
	@Test
	public void testTopographicalSortWithExampleGraph() {
		// This test should fail because the specified graph contains a cycle
		exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph.dot");
	}
	
	@Test
	public void testTopographicalSortWithExampleGraph2() {
		// This test should fail because the specified graph contains a cycle
		exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph2.dot");
	}
	
	@Test
	public void testTopographicalSortWithExampleGraph3() {
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph3.dot");
		System.out.println("Example3graph.dot:");
		System.out.println("\t" + path.toString());
		
		Expected = "[n1, n2, n3, n4, n5, n0]";
		Actual = path.toString();
		
		assertEquals(Expected, Actual);
	}

	@Test
	public void testTopographicalSortWithExampleGraph4() {
		// This test should fail because the specified graph contains a cycle
		exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph4.dot");
	}
	
	@Test
	public void testTopographicalSortWithExampleGraph5() {
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph5.dot");
		System.out.println("Example5graph.dot:");
		System.out.println("\t" + path.toString());
		
		Expected = "[1, 2, 3, 4, 5]";
		Actual = path.toString();
		
		assertEquals(Expected, Actual);
	}
	
	@Test
	public void testTopographicalSortWithExampleGraph6() {
		// This test should fail because the specified graph contains a cycle
		exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph6.dot");
	}
	
	@Test
	public void testTopographicalSortWithExampleGraph7() {
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph7.dot");
		System.out.println("Example7graph.dot:");
		System.out.println("\t" + path.toString());

		Expected = "[MATH 2250, CS 1410, CS 2420, CS 2100, CS 3200*, CS 3500, CS 3810, CS 3100*, CS 4150, CS 3505, CS 4400, CS 4500]";
		Actual = path.toString();
		
		assertEquals(Expected, Actual);
	}
	
	@Test
	public void testTopographicalSortWithExampleGraph8() {
		// This test should fail because the specified graph contains a cycle
		exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph8.dot");
	}
	
	@Test
	public void testTopographicalSortWithExampleGraph9() {
		// This test should fail because the specified graph contains a cycle
		exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\ExampleTests\\examplegraph9.dot");
	}
	
	//TODO Add special case for Zero and One vertex, return the single vertex or empty brackets
	//TODO Figure out what to do if the file exists but contains no vertices, currently GraphUtil returns an empty list
	@Test
	public void testTopographicalSortWithCreatedZeroVertexGraph() {
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\CreatedTests\\graphWithNoVerts.dot");
		System.out.println("graphWithZeroVerts.dot:");
		System.out.println("\t" + path.toString());
	}
	
	@Test
	public void testTopographicalSortWithCreatedOneVertexGraph() {
		//exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\CreatedTests\\graphWithOneVert.dot");
		System.out.println("graphWithOneVert.dot:");
		System.out.println("\t" + path.toString());
	}
	
	@Test
	public void testTopographicalSortWithCreatedTwoVertexGraph() {
		//exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\CreatedTests\\graphWithTwoVerts.dot");
		System.out.println("graphWithTwoVerts.dot:");
		System.out.println("\t" + path.toString());
		
		Expected = "[vertex 1, vertex 2]";
		Actual = path.toString();
		
		assertEquals(Expected, Actual);
	}
	
	@Test
	public void testTopographicalSortWithCreatedUndirectedGraph() {
		// This test should fail because the graph is undirected
		exception.expect(UnsupportedOperationException.class);
		path = GraphUtil.topologicalSort("src\\assign8\\Tests\\CreatedTests\\undirectedGraph.dot");
	}
	
	//TODO: Remove these tests after changing buildGraphFromDot method back to private
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
