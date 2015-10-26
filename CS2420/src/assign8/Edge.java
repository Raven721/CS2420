package assign8;

/**
 * A class representation of an edge in a graph.
 *
 * @author Tim Ellenberger, ellenber
 * @author John Strasser
 * @author Erin Parker
 * @version 10/29/2015
 */
public class Edge {

	private Vertex other; // 2nd vertex in Edge

	public Edge(Vertex _other) {
		this.other = _other;
	}

	public Vertex getOtherVertex() {
		return other;
	}

	public String toString() {
		return other.getName();
	}
}