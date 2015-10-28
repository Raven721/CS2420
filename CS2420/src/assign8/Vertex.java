package assign8;

import java.util.LinkedList;
import java.util.Iterator;

/**
 * A class representation of a vertex.
 *
 * @author Tim Ellenberger, ellenber
 * @author John Strasser, strasser
 * @author Erin Parker
 * @version 10/29/2015
 */
public class Vertex {

	private String name; // used to id the Vertex
	private LinkedList<Edge> adj; // adjacency list
	private int inDegree; // used in topo sort
	private double distanceFromStart; // used in BFS
	private Vertex prev; // used in BFS

	/**
	 * Constructor for Vertex class
	 * 
	 * @param _name
	 * 			Name of the Vertex being constructed
	 */
	public Vertex(String _name) {
		this.name = _name;
		this.adj = new LinkedList<Edge>();
		this.inDegree = 0;
	}

	/**
	 * Returns the name of this vertex.
	 * 
	 * @return The name of this vertex.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the distance of this vertex(the number of edges) from the beginning of the graph.
	 *  
	 * @return The number of edges from the beginning of the graph to the current vertex.
	 */
	public double getDistanceFromStart() {
		return distanceFromStart;
	}
	
	/**
	 * Sets the distance of the current vertex from the starting point in the graph
	 * 
	 * @param distance The specified distance of the current vertex to the starting point
	 * in the graph.
	 */
	public void setDistanceFromStart(Double distance) {
		distanceFromStart = distance;
	}
	
	/**
	 * Returns the number of edges directed at the current vertex.
	 * 
	 * @return The number of edges directed at the current vertex.
	 */
	public int getInDegree() {
		return inDegree;
	}

	/**
	 * Sets the in-degree of the current vertex.
	 * 
	 * @param inDegree The number of edges directed at this vertex.
	 */
	public void setInDegree(int inDegree) {
		this.inDegree = inDegree;
	}
	
	/**
	 * Returns the previously traversed vertex in the graph.
	 * 
	 * @return The previously traversed vertex in the graph.
	 */
	public Vertex getPreviousVertex() {
		return prev;
	}

	/**
	 * Sets the reference of this vertex's previously traversed vertex to the specified vertex.
	 * 
	 * @param prev The vertex for the current vertex to reference as its previously traversed vertex.
	 */
	public void setPreviousVertex(Vertex prev) {
		this.prev = prev;
	}

	/**
	 * Verifies if the current vertex is connected to another vertex through an edge. 
	 * 
	 * @param vertex2 The destination vertex.
	 * 
	 * @return True if the current vertex is connected to a specified destination vertex.
	 */
	public boolean containsEdge(Vertex vertex2) {
		for(Edge e : adj){
			if(vertex2.name.equals(e.getOtherVertex())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Adds an edge between the current vertex and a given destination vertex.
	 * 
	 * @param otherVertex The destination vertex.
	 */
	public void addEdge(Vertex otherVertex) {
		adj.add(new Edge(otherVertex));
	}

	/**
	 * Returns an iterator object containing this vertex's adjacency list.
	 * 
	 * @return An iterator object containing this vertex's adjacency list.
	 */
	public Iterator<Edge> edges() {
		return adj.iterator();
	}

	/**
	 * Returns a string containing this vertex and its adjacent indexes.
	 * 
	 * @return s A string containing this vertex and its adjacent indexes.
	 */
	public String toString() {
		String s = "Vertex " + name + " adjacent to ";
		Iterator<Edge> itr = adj.iterator();
		while (itr.hasNext())
			s += itr.next() + "  ";
		return s;
	}
}

