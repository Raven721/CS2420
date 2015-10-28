package assign8;

/**
 * A class representation of an edge in a graph.
 *
 * @author Tim Ellenberger, ellenber
 * @author John Strasser, strasser
 * @author Erin Parker
 * @version 10/29/2015
 */
public class Edge {

	private Vertex other; // 2nd vertex in Edge
	
	public Edge(Vertex _other) {
		this.other = _other;
	}
	
	/**
	 * Returns the complementary vertex to the current vertex, from the 
	 * opposite end of a shared edge.
	 * 
	 * @return The complementary vertex to the current vertex, from the
	 * opposite end of a shared edge.
	 */
	public Vertex getOtherVertex() {
		return other;
	}

	/**
	 * Returns the name of the vertex on the opposite end of a shared edge
	 * to the current vertex.
	 * 
	 * @return Returns the name of the vertex on the opposite end of a shared 
	 * edge to the current vertex.
	 */
	public String toString() {
		return other.getName();
	}
}