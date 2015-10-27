package assign8;

import java.util.LinkedList;
import java.util.Iterator;

/**
 * A class representation of a vertex.
 *
 * @author Tim Ellenberger, ellenber
 * @author John Strasser
 * @author Erin Parker
 * @version 10/29/2015
 */
public class Vertex {

	/*
	 * Pg. 534 Data Structures: Problem Solving Using Java
	 * A vertex object should contain:
	 * 1. Name - Name corresponding to this vertex in the hashmap
	 * 2. Adj - List of adjacent vertices established when the graph is read
	 * 3. Dist - The length of the shortest path (either weighted or unweighted)
	 * 4. Prev - The previous vertex on the shortest path to this vertex
	 * 
	 * i.e.
	 * 1. public String name;
	 * 2. public List<Edge> adj;
	 * 3. public double dist;
	 * 4. public Vertex prev;
	 */
	private String name; // used to id the Vertex

	private LinkedList<Edge> adj; // adjacency list
	
	private int inDegree; // used in topo sort
	
	private int distanceFromStart; // used in BFS

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
	public int getDistanceFromStart() {
		return distanceFromStart;
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
	 * Verifies if the current vertex is connected to another vertex through an edge. 
	 * 
	 * @param vertex2 The destination vertex
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
	 * @param otherVertex The destination vertex
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

