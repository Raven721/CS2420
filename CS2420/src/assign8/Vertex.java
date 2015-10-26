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

	public Vertex(String _name) {
		this.name = _name;
		this.adj = new LinkedList<Edge>();
	}

	public String getName() {
		return name;
	}

	public void addEdge(Vertex otherVertex) {
		adj.add(new Edge(otherVertex));
	}

	public Iterator<Edge> edges() {
		return adj.iterator();
	}

	public String toString() {
		String s = "Vertex " + name + " adjacent to ";
		Iterator<Edge> itr = adj.iterator();
		while (itr.hasNext())
			s += itr.next() + "  ";
		return s;
	}
}