package assign8;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * Timing Analysis of the Topological Sort and Breadth-First Search methods of
 * the GraphUtil class. Graphs are generated randomly using a specified number
 * of edges and vertices.
 * 
 * This class uses formulas to compare and display the empirically observed
 * running time of a method/algorithm to the expected Big-O behavior.
 * 
 * @author Tim Ellenberger, ellenber
 * @author John Strasser, strasser
 * @author Erin Parker
 * @version 10/29/2015
 */
public class TimingAnalysis {

	private static String startVert;
	private static String destVert;

	public static void main(String[] args) {
		int vFactor;
		@SuppressWarnings("unused")
		int vStart;
		int eFactor;
		int timesToLoop = 10;

		////////////// Increase Edge count ///////////////////////
		// Time breadth-first search where the #edges = 4 * #vertices
		eFactor = 10;
		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/BFSearch",
				"breadth-first search", timesToLoop, 10000, 410000, 40000,
				eFactor);

		// Time breadth-first search where the #edges = 3 * #vertices
		eFactor = 5;
		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/BFSearch",
				"breadth-first search", timesToLoop, 10000, 410000, 40000,
				eFactor);

		// Time breadth-first search where the #edges = 2 * #vertices
		eFactor = 2;
		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/BFSearch",
				"breadth-first search", timesToLoop, 10000, 410000, 40000,
				eFactor);

		// Time breadth-first search where the # edges = # vertices
		eFactor = 1;
		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/BFSearch",
				"breadth-first search", timesToLoop, 10000, 410000, 40000,
				eFactor);

		//////////////Increase Vertex count ///////////////////////
		
		// Time breadth-first search where the #vertices = 4 * #edges
		eFactor = 1;
		vFactor = 4;
		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/BFSearch",
				"breadth-first search", timesToLoop, vFactor *10000, vFactor * 410000, vFactor * 40000,
				eFactor);

		// Time breadth-first search where the #vertices = 3 * #edges
		eFactor = 1;
		vFactor = 3;
		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/BFSearch",
				"breadth-first search", timesToLoop, vFactor *10000, vFactor * 410000, vFactor * 40000,
				eFactor);

		// Time breadth-first search where the #vertices = 2 * #edges
		eFactor = 1;
		vFactor = 2;
		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/BFSearch",
				"breadth-first search", timesToLoop, vFactor *10000, vFactor * 410000, vFactor * 40000,
				eFactor);

		// Time breadth-first search where the #vertices = #edges
		eFactor = 1;
		vFactor = 1;
		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/BFSearch",
				"breadth-first search", timesToLoop, vFactor *10000, vFactor * 410000, vFactor * 40000,
				eFactor);

		// // Time breadth-first search where the #edges = 4 * #vertices
		// vFactor = 1;
		// eFactor = 7;
		// vStart = vFactor * 10000;
		// timeGraphMethod("src/assign8/Tests/GeneratedGraphs/BFSearch",
		// "breadth-first search", timesToLoop, vStart, 20*vStart, vStart,
		// eFactor);

		// Time topological sort
		vFactor = 1;
		eFactor = 10;
		vStart = vFactor * 100;
		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/topoSort",
				"topological", timesToLoop, 10000, 200000, 20000, eFactor);

		// Time topological sort
		vFactor = 1;
		eFactor = 5;
		vStart = vFactor * 100;
		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/topoSort",
				"topological", timesToLoop, 10000, 200000, 20000, eFactor);

		// Time topological sort
		vFactor = 1;
		eFactor = 2;
		vStart = vFactor * 100;
		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/topoSort",
				"topological", timesToLoop, 10000, 200000, 20000, eFactor);

		// Time topological sort
		vFactor = 1;
		eFactor = 1;
		vStart = vFactor * 100;
		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/topoSort",
				"topological", timesToLoop, 10000, 200000, 20000, eFactor);
	}

	/**
	 * Performs a timing analysis on an automatically generated graph. 
	 * 
	 * @param filename The path where the generated graph will be created.
	 * @param timingMethod The name of the method to be timed.
	 * @param timesToLoop The number of times to average the running time per problem size.
	 * @param nStart The starting problem size.
	 * @param nStop The ending problem size.
	 * @param nStep The factor by which to increment the problem size per iteration.
	 * @param edgeFactor The factor by which to multiply the number of edges in the analysis.
	 */
	private static void timeGraphMethod(String filename, String timingMethod,
			int timesToLoop, int nStart, int nStop, int nStep, int edgeFactor) {
		long startTime, midptTime, stopTime;
		boolean retry = false;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println("------------------- GraphUtil Timing Analysis: "
				+ timingMethod + " ----------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | "
				+ "Number of Edges: " + edgeFactor + " * N");
		System.out
				.println("\nN\tT(N)\t\t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out
				.println("---------------------------------------------------------------------------------------------------------");

		for (int vertexCount = nStart; vertexCount <= nStop; vertexCount += nStep) {

			String fullPathName = filename + vertexCount + ".dot";

			// Create a data set to work with
			if (timingMethod.equals("topological")) {
				generateRandomDotFile(fullPathName, vertexCount, edgeFactor,
						"acyclic");
			} else if (timingMethod.equals("breadth-first search")) {
				generateRandomDotFile(fullPathName, vertexCount, edgeFactor,
						"cyclic");
			}

			if (!retry) {
				System.out.print(vertexCount + "\t");
			}

			// Let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;

			// Time the routine
			startTime = System.nanoTime();
			if (timingMethod.equals("topological")) {
				for (int i = 0; i < timesToLoop; i++) {
					GraphUtil.topologicalSort(fullPathName);
				}
			} else if (timingMethod.equals("breadth-first search")) {
				for (int i = 0; i < timesToLoop; i++) {
					GraphUtil.breadthFirstSearch(fullPathName, startVert,
							destVert);
				}
			}

			midptTime = System.nanoTime();

			// Time the empty loops
			if (timingMethod.equals("topological")) {
				for (int i = 0; i < timesToLoop; i++) {
					GraphUtil.buildGraphFromDot(fullPathName);
				}
			} else if (timingMethod.equals("breadth-first search")) {
				for (int i = 0; i < timesToLoop; i++) {
					GraphUtil.buildGraphFromDot(fullPathName);
				}
			}

			stopTime = System.nanoTime();

			// Compute the average time
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime))
					/ timesToLoop;

			if (avgTime <= 0) {
				retry = true;
				vertexCount -= nStep;
				continue;
			} else {
				retry = false;
			}

			System.out.println(formatter.format(avgTime)
					+ "\t\t|\t"
					+ formatter.format(avgTime
							/ (Math.log10(vertexCount) / Math.log10(2)))
					+ "\t\t"
					+ formatter.format(avgTime
							/ (vertexCount * (Math.log10(vertexCount) / Math
									.log10(2))))
					+ "\t\t"
					+ formatter.format(avgTime / vertexCount)
					+ "\t\t"
					+ formatter.format(avgTime / (vertexCount * vertexCount))
					+ "\t\t"
					+ formatter.format(avgTime
							/ (vertexCount * vertexCount * vertexCount)));
		}
		System.out
				.println("---------------------------------------------------------------------------------------------------------");
	}

	/**
	 * Randomly generates a cyclic or acyclic graph containing a specified amount of vertices and edges.
	 * 
	 * @param filename The name of the file to create, which will contain the generated graph.
	 * @param vertexCount The number of vertices to include in the generated graph.
	 * @param edgeFactor The number of edges to include in the graph, as a factor of the number of vertices.
	 * @param graphType The type of graph to be created. (Either cyclic or acyclic)
	 */
	public static void generateRandomDotFile(String filename, int vertexCount,
			int edgeFactor, String graphType) {
		PrintWriter out = null;

		try {
			out = new PrintWriter(filename);
		} catch (IOException e) {
			System.out.println(e);
		}

		Random rng = new Random();

		// randomly construct a digraph
		String edgeOp = "->";
		out.println("digraph G {");

		// generate a list of vertices
		if (vertexCount < 0) {
			System.out.println("VertexCount negative: " + vertexCount);
		}
		String[] vertex = new String[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			vertex[i] = "v" + i;
		}

		// randomly connect the vertices using 2 * |V| edges
		if (graphType.equals("cyclic")) {
			int rand1, rand2;
			for (int i = 0; i < edgeFactor * vertexCount; i++) {
				rand1 = rng.nextInt(vertexCount);
				rand2 = rng.nextInt(vertexCount);

				out.println("\t" + "\"" + vertex[rand1] + "\"" + edgeOp + "\""
						+ vertex[rand2] + "\"");

				if (i == 0) {
					startVert = "v" + Integer.toString(rand1);
				}
				destVert = "v" + Integer.toString(rand2);

			}
		}
		// Randomly connect vertex to vertices below it in the graph
		else if (graphType.equals("acyclic")) {
			int nextVert;
			for (int j = 0; j < edgeFactor; j++) {
				for (int i = 0; i < vertexCount - 1; i++) {
					do {
						nextVert = rng.nextInt(vertexCount - i) + (i + 1) - 1;
					} while (nextVert <= i || nextVert > vertex.length - 1);

					out.println("\t" + "\"" + vertex[i] + "\"" + edgeOp + "\""
							+ vertex[nextVert] + "\"");
				}
			}
		}

		out.println("}");
		out.close();
	}
}
