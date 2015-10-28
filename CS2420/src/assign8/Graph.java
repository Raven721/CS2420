package assign8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Representation of an undirected, unweighted graph.
 * 
 * @author Tim Ellenberger, ellenber
 * @author John Strasser, strasser
 * @author Erin Parker
 * @version 10/29/2015
 */
public class Graph {

	// Recall that a map is a collection of entries.
	// Each entry is a key (vertex name) is mapped to its value (vertex).
	private Map<String, Vertex> vertices;

	private boolean isDirected; // tracks if graph is directed or undirected type

	/**
	 * Default constructor for Graph class
	 */
	public Graph() {
		// HashMap is an implementation of Map with fast running times, we will
		// learn why in a few weeks.
		vertices = new HashMap<String, Vertex>();
		this.isDirected = false;
	}	
	
	/**
	 * Sets the direction status of the graph.
	 * 
	 * @param b Specifies if the current graph is directed(true) or undirected(false)
	 */
	public void setDirected(boolean b) {
		this.isDirected = b;
	}
	
	/**
	 * Returns true if the graph is directed or false if the graph is undirected. 
	 * 
	 * @return True if the graph is directed, false if otherwise.
	 */
	public boolean getDirected() {
		return isDirected;
	}
	
	/**
	 * Returns all of the vertices from the input file in no particular order.
	 * 
	 * @return An unordered Collection<Vertex> of all vertices in the input file
	 */
	public Collection<Vertex> getVertices() {
		return vertices.values();
	}
	
	/**
	 * Returns the vertex stored in a map associated with the input string name.
	 * 
	 * @param name The name of the vertex to be returned
	 * @return The vertex associated with the specified name
	 */
	public Vertex getVertex(String name) {
		if(!vertices.containsKey(name)) {
			throw new UnsupportedOperationException();
		} 
		
		return vertices.get(name);
	}

	/**
	 * Adds an edge between the vertex identified using "name1" and the vertex
	 * identifies using "name2".
	 * 
	 * @param name1 The name of the starting vertex.
	 * @param name2 The name of the destination vertex.
	 */
	public void addEdge(String name1, String name2) {
		Vertex vertex1;
		// If the vertex is already in our collection, get it.
		if (vertices.containsKey(name1))
			vertex1 = vertices.get(name1);
		// If the vertex is not already in our collection, add it.
		else {
			vertex1 = new Vertex(name1);
			vertices.put(name1, vertex1);
		}

		// Do the same for other vertex.
		Vertex vertex2;
		if (vertices.containsKey(name2))
			vertex2 = vertices.get(name2);
		else {
			vertex2 = new Vertex(name2);
			vertices.put(name2, vertex2);
		}
		
		// Undirected graph we go ahead and add edges to both vertices if the edge does not exist
		if (!isDirected) {
			if(!vertex1.containsEdge(vertex2)) {
				vertex1.addEdge(vertex2);
				vertex2.addEdge(vertex1);
			}
		}
		// For directed graph we add edge from V1, and we increment V2's inDegree (if edge does not already
		// exist
		else {
			if(!vertex1.containsEdge(vertex2)) {
				vertex1.addEdge(vertex2); 
				vertex2.setInDegree(vertex2.getInDegree() + 1); 
			}
		}
	}

	/**
	 * Returns true is there is a path (i.e., a list of edges) connecting vertex
	 * identified using "name1" to vertex identified using "name2".
	 * 
	 * @return Returns true if a path exists between two specified vertices.
	 */
	public boolean thereIsAPath(String name1, String name2) {
		// Check to see if the vertices are in our collection.
		if (!vertices.containsKey(name1))
			return false;

		if (!vertices.containsKey(name2))
			return false;

		// Keep track of the vertices left to visit and those already visited.
		Queue<Vertex> verticesToBeVisited = new LinkedList<Vertex>();
		List<Vertex> verticesAlreadyVisited = new ArrayList<Vertex>();

		Vertex v = vertices.get(name1);
		verticesToBeVisited.offer(v); // enqueue

		while (!verticesToBeVisited.isEmpty()) {
			v = verticesToBeVisited.poll(); // dequeue
			verticesAlreadyVisited.add(v);

			Iterator<Edge> itr = v.edges();
			while (itr.hasNext()) {
				v = itr.next().getOtherVertex();

				if (v.getName().equals(name2))
					return true;

				if (!verticesAlreadyVisited.contains(v))
					verticesToBeVisited.offer(v); // enqueue
			}
		}

		// Is the verticesAlreadyVisited list an efficient way to keep track of
		// whether a vertex has already been visited? Is not, what is a better
		// way?

		return false;
	}

	/**
	 * Override the toString method for better information on the Graph object
	 */
	public String toString() {
		Object[] arr = vertices.values().toArray();

		String str = "";
		for (int i = 0; i < arr.length; i++)
			str += arr[i] + "\n";
		return str;
	}

	/**
	 * Initializes all vertices in a Breadth-First-Search graph to positive infinity
	 */
	public void initializeBFSVertices() {
		Collection<Vertex> verticeList = getVertices();
		
		for(Vertex v: verticeList) {
			v.setDistanceFromStart(Double.POSITIVE_INFINITY);
		}
	}
}