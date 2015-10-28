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
 * @author John Strasser, strasser
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
	
		// Create our graph from the supplied DOT file
		Graph g = GraphUtil.buildGraphFromDot(filename);
		
		// Throw exception if the graph is undirected
		if(!g.getDirected()) {
			throw new UnsupportedOperationException();
		}
		
		// Setup containers for all graph vertices and corresponding sorted list 
		Queue<Vertex> vertQueue = new LinkedList<Vertex>();
		List<String> orderedVert = new LinkedList<String>();
		
		// get the list of vertices
		Collection<Vertex> vertices = g.getVertices();

		// if no vertices, just return empty list
		if(vertices.size() == 0) {
			return orderedVert;
		}
		
		// Find vertices with inDegree 0 and add them to the vertQueue and to the output list
		for(Vertex v: vertices) {
			if(v.getInDegree() == 0) {
				vertQueue.add(v);
				orderedVert.add(v.getName());
			}
		}
		
		// Decrement
		while(!vertQueue.isEmpty()) {
			// grab next vertex to process
			Vertex v = vertQueue.remove();

			// create edge iterator to visit all edges
			Iterator<Edge> itr = v.edges();
			Edge tempEdge;
			Vertex destVertex;
			// visit each edge and decrement inDegree of the destination
			while (itr.hasNext()){
				tempEdge = itr.next();
				destVertex = tempEdge.getOtherVertex();
				destVertex.setInDegree(destVertex.getInDegree() - 1);
				// if destination is now of inDegree zero queue it up and add to output list
				if(destVertex.getInDegree() == 0) {
					vertQueue.add(destVertex);
					orderedVert.add(destVertex.getName());
				}
			}
		}
		
		// If any vertices had inDegree >0 after running topoSort algorithm, we have a
		// cycle or we had disconnected parts of the graph
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
		
		// Throw exception if the graph is undirected
		if(!g.getDirected()) {
			throw new UnsupportedOperationException();
		}
		
		// Initialize all vertices to POSINFINITY
		g.initializeBFSVertices();
		
		// Setup containers for all graph vertices and corresponding sorted list 
		Queue<Vertex> vertQueue = new LinkedList<Vertex>();
		
		
		// Initialize the starting vertex
		g.getVertex(start).setDistanceFromStart(0d);
		vertQueue.add(g.getVertex(start));
		
		Vertex startVertex;
		
		VertQueueProcessor: // name this loop to break out early when destination reached
		while(!vertQueue.isEmpty()) {
			// grab the next vertex to process
			startVertex = vertQueue.remove();
			
			// iterate through the edges and update the distance for the destination vertices
			Iterator<Edge> itr = startVertex.edges();
			Edge tempEdge;
			Vertex destVertex;
			while (itr.hasNext()){
				tempEdge = itr.next();
				destVertex = tempEdge.getOtherVertex();
				
				// Check that the destination vertex hasn't been visited, then update distance and prev
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
		
		// If there is not a path from start to end, then the end is still infinity
		if(g.getVertex(end).getDistanceFromStart() == Double.POSITIVE_INFINITY) {
			return new LinkedList<String>();
		}
		
		// Create list to hold the ordered vertices from start to end
		LinkedList<String> orderedVert = new LinkedList<String>();
		
		// Begin at the destination vertex
		Vertex currentVertex = g.getVertex(end);
		
		// Process previous pointers until we find the start
		while(currentVertex != g.getVertex(start)) {
			orderedVert.addFirst(currentVertex.getName());
			currentVertex = currentVertex.getPreviousVertex();
		}
		// Finally add the start vertex
		orderedVert.addFirst(start);
		
		return orderedVert;
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
	@SuppressWarnings("resource")
	public static Graph buildGraphFromDot(String filename) {
		// creates a new, empty graph 
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
				g.setDirected(true); // Denotes that graph is directed 
				edgeOp = "->";
				line = line.replaceFirst(".*\\{", "");
				break;
			}
			if (line.indexOf("graph") >= 0) {
				g.setDirected(false); // Denotes that graph is undirected
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