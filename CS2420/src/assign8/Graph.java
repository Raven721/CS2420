package assign8;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * @author John Strasser
 * @author Erin Parker
 * @version 10/29/2015
 */
public class Graph {

	/*
	 * Pg. 536 Data Structures: Problem Solving Using Java
	 * 
	 * Example Graph class and graph methods
	 */

	// Recall that a map is a collection of entries.
	// Each entry is a key (vertex name) is mapped to its value (vertex).
	private Map<String, Vertex> vertices;

	private boolean isDirected;

	public Graph() {
		// HashMap is an implementation of Map with fast running times, we will
		// learn why in a few weeks.
		vertices = new HashMap<String, Vertex>();
		this.isDirected = false;
	}	
	public Graph(boolean _isDirected) {
		// HashMap is an implementation of Map with fast running times, we will
		// learn why in a few weeks.
		vertices = new HashMap<String, Vertex>();
		this.isDirected = _isDirected;
	}

	/**
	 * Adds an edge between the vertex identified using "name1" and the vertex
	 * identifies using "name2".
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

		if (!isDirected) {

			vertex1.addEdge(vertex2); // undirected graph: add edge to both
			vertex2.addEdge(vertex1); // adj-lists
		}
		else {
			vertex1.addEdge(vertex2); // directed graph: add edge to V1
		}
	}

	/**
	 * Returns true is there is a path (i.e., a list of edges) connecting vertex
	 * identified using "name1" to vertex identified using "name2".
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

	public String toString() {
		Object[] arr = vertices.values().toArray();

		String str = "";
		for (int i = 0; i < arr.length; i++)
			str += arr[i] + "\n";
		return str;
	}

	public void checkForPath(String vertexName1, String vertexName2) {
		if (thereIsAPath(vertexName1, vertexName2))
			System.out.println("There is a path from " + vertexName1 + " to " + vertexName2 + ".");
		else
			System.out.println("There is not a path from " + vertexName1 + " to " + vertexName2 + ".");
	}

	public void generateDotFile(String filename) {
		try {
			PrintWriter out = new PrintWriter(filename);
			out.println("graph G {");

			if (vertices.isEmpty())
				out.println("");
			else {
				List<Vertex> alreadyVisited = new LinkedList<Vertex>();

				for (Vertex v : vertices.values()) {
					Iterator<Edge> edges = v.edges();
					while (edges.hasNext()) {
						Vertex x = edges.next().getOtherVertex();

						if (!alreadyVisited.contains(x))
							out.println("\t\"" + v.getName() + "\" -- \"" + x.getName() + "\"");
					}
					alreadyVisited.add(v);
				}
			}

			out.println("}");
			out.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		// build a sample graph
		Graph g = new Graph();

		g.addEdge("V1", "V3");
		g.addEdge("V1", "V4");
		g.addEdge("V2", "V4");
		g.addEdge("V2", "V1");
		g.addEdge("V4", "V5");
		g.addEdge("V5", "V3");
		g.addEdge("V6", "V7");

		g.checkForPath("V2", "V3");
		g.checkForPath("V4", "V3");
		g.checkForPath("V6", "V5");

		g.generateDotFile("graph.dot");

		// build another sample graph
		g = new Graph();

		g.addEdge("0", "1");
		g.addEdge("0", "2");
		g.addEdge("0", "7");
		g.addEdge("1", "2");
		g.addEdge("2", "3");
		g.addEdge("3", "4");
		g.addEdge("3", "5");
		g.addEdge("3", "6");
		g.addEdge("4", "5");
		g.addEdge("5", "6");
		g.addEdge("7", "1");
		g.addEdge("7", "6");

		g.checkForPath("3", "1");

		g.generateDotFile("graph2.dot");
	}

	public void setDirected(boolean b) {
		// TODO Auto-generated method stub

	}
}