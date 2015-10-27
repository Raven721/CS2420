package assign8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Collection;

import java.util.Iterator;

/**
 * Utility class containing methods for operating on graphs.
 *
 * @author Tim Ellenberger, ellenber
 * @author John Strasser
 * @author Erin Parker
 * @version 10/29/2015
 */
public class GraphUtil {

	/**
	 * Performs a topological sort of the vertices in a directed acyclic graph.
	 * (See Lecture 14 for the algorithm.)
	 * 
	 * Throws an UnsupportedOperationException if the graph is undirected or
	 * cyclic.
	 * 
	 * @param filename
	 *            -- Name of a file in DOT format, which specifies the graph to
	 *            be sorted.
	 * @return a list of the vertex names in sorted order
	 */
	public static List<String> topologicalSort(String filename) {
		// Page 555 in Data Structures: Problem Solving Using Java
		// FILL IN -- do not return null
		
		Graph g = GraphUtil.buildGraphFromDot(filename);
		
		// Throw exception if the graph is undirected or cyclic
		if(!g.getDirected()) {
			throw new UnsupportedOperationException();
		}
		
		// Setup containers for all graph vertices and corresponding sorted list 
		Queue<Vertex> vertQueue = new LinkedList<Vertex>();
		List<String> orderedVert = new LinkedList<String>();
		
		// get the list of vertices
		Collection<Vertex> vertices = g.getVertices();
		
		// Find vertices with indegree 0
		for(Vertex v: vertices) {
			if(v.getInDegree() == 0) {
				vertQueue.add(v);
				orderedVert.add(v.getName());
			}
		}
		
		// Decrement
		while(!vertQueue.isEmpty()) {
			Vertex v = vertQueue.remove();

			Iterator<Edge> itr = v.edges();
			Edge tempEdge;
			Vertex destVertex;
			while (itr.hasNext()){
				tempEdge = itr.next();
				destVertex = tempEdge.getOtherVertex();
				destVertex.setInDegree(destVertex.getInDegree() - 1);
				
				if(destVertex.getInDegree() == 0) {
					vertQueue.add(destVertex);
					orderedVert.add(destVertex.getName());
				}
			}
		}
		
		for(Vertex v : vertices) {
			if(v.getInDegree() != 0) {
				throw new UnsupportedOperationException();
			}
		}
		
		return orderedVert;
	}

	/**
	 * Performs a breadth-first search of a graph to determine the shortest path
	 * from a starting vertex to an ending vertex. (See Lecture 14 for the
	 * algorithm.)
	 * 
	 * Throws an UnsupportedOperationException if the graph is undirected or if
	 * the starting or ending vertex does not exist in the graph.
	 * 
	 * @param filename
	 *            -- Name of a file in DOT format, which specifies the graph to
	 *            be sorted.
	 * @param start
	 *            -- Name of the starting vertex in the path.
	 * @param end
	 *            -- Name of the ending vertex in the path.
	 * @return a list of the vertices that make up the shortest path from the
	 *         starting vertex (inclusive) to the ending vertex (inclusive).
	 */
	public static List<String> breadthFirstSearch(String filename, String start, String end) {
		Graph g = GraphUtil.buildGraphFromDot(filename);
		
		g.initializeBFSVertices();
		
		// Setup containers for all graph vertices and corresponding sorted list 
		Queue<Vertex> vertQueue = new LinkedList<Vertex>();
		List<String> orderedVert = new LinkedList<String>();
		
		// Initialize 
		g.getVertex(start).setDistanceFromStart(0d);
		vertQueue.add(g.getVertex(start));
		
		Vertex startVertex;
		
		VertQueueProcessor:
		while(!vertQueue.isEmpty()) {
			startVertex = vertQueue.remove();
			
			Iterator<Edge> itr = startVertex.edges();
			Edge tempEdge;
			Vertex destVertex;
			while (itr.hasNext()){
				tempEdge = itr.next();
				destVertex = tempEdge.getOtherVertex();
				
				// Check that the destination vertex hasn't been visited
				if(destVertex.getDistanceFromStart() == Double.POSITIVE_INFINITY) {
					destVertex.setDistanceFromStart(startVertex.getDistanceFromStart() + 1);
					destVertex.setPreviousVertex(startVertex);
					
					// If the destination is found, quit searching the graph
					if(destVertex.equals(g.getVertex(end))) {
						break VertQueueProcessor;
					}
					
					vertQueue.add(destVertex);
				}

			}
			
		}

		return null;
	}

	/**
	 * Builds a graph according to the edges specified in the given DOT file
	 * (e.g., "a -- b" or "a -> b"). Accepts directed ("digraph") or undirected
	 * ("graph") graphs.
	 * 
	 * Accepts many valid DOT files (see examples posted with assignment).
	 * --accepts \\-style comments --accepts one edge per line or edges
	 * terminated with ; --does not accept attributes in [] (e.g., [label =
	 * "a label"])
	 * 
	 * @param filename
	 *            -- name of the DOT file
	 */
	//TODO : change back to private
	@SuppressWarnings("resource")
	public static Graph buildGraphFromDot(String filename) {
		// creates a new, empty graph (CHANGE AS NEEDED)
		Graph g = new Graph();

		Scanner s = null;
		try {
			s = new Scanner(new File(filename)).useDelimiter(";|\n");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// Determine if graph is directed or not (i.e., look for "digraph id {"
		// or
		// "graph id {")
		String line = "", edgeOp = "";
		while (s.hasNext()) {
			line = s.next();

			// Skip //-style comments.
			line = line.replaceFirst("//.*", "");

			if (line.indexOf("digraph") >= 0) {
				g.setDirected(true); // Denotes that graph is directed (CHANGE
										// AS NEEDED)
				edgeOp = "->";
				line = line.replaceFirst(".*\\{", "");
				break;
			}
			if (line.indexOf("graph") >= 0) {
				g.setDirected(false); // Denotes that graph is undirected
										// (CHANGE AS NEEDED)
				edgeOp = "--";
				line = line.replaceFirst(".*\\{", "");
				break;
			}
		}

		// Look for edge operators -- (or ->) and determine the left and right
		// vertices for each edge.
		while (s.hasNext()) {
			String[] substring = line.split(edgeOp);

			for (int i = 0; i < substring.length - 1; i += 2) {
				// remove " and trim whitespace from node string on the left
				String vertex1 = substring[0].replace("\"", "").trim();
				// if string is empty, try again
				if (vertex1.equals(""))
					continue;

				// do the same for the node string on the right
				String vertex2 = substring[1].replace("\"", "").trim();
				if (vertex2.equals(""))
					continue;

				// add edge between vertex1 and vertex2 (CHANGE AS NEEDED)
				g.addEdge(vertex1, vertex2);
			}

			// do until the "}" has been read
			if (substring[substring.length - 1].indexOf("}") >= 0)
				break;

			line = s.next();

			// Skip //-style comments.
			line = line.replaceFirst("//.*", "");
		}

		return g;
	}
}