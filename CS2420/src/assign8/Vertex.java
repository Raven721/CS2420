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