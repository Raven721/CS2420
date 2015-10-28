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
		// Time breadth-first search where the #edges = 4 * #vertices
		 timeGraphMethod("src/assign8/Tests/GeneratedGraphs/BFSearch",
		 "breadth-first search", 20, 1000, 10000, 1000, 1);
		
		 // Time breadth-first search where the #edges = 3 * #vertices
		 timeGraphMethod("src/assign8/Tests/GeneratedGraphs/BFSearch",
		 "breadth-first search", 20, 1000, 10000, 1000, 3);

		// Time topological sort
		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/topoSort", "topological", 50, 100, 1000, 100, 10);
	}

	/**
	 * 
	 * @param filename
	 * @param timingMethod
	 * @param timesToLoop
	 * @param nStart
	 * @param nStop
	 * @param nStep
	 * @param edgeFactor
	 * @param start
	 * @param end
	 */
	private static void timeGraphMethod(String filename, String timingMethod, int timesToLoop, int nStart, int nStop,
			int nStep, int edgeFactor) {
		long startTime, midptTime, stopTime;
		boolean retry = false;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out
				.println("------------------- GraphUtil Timing Analysis: " + timingMethod + " ----------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | " + "Number of Edges: " + edgeFactor + " * N");
		System.out.println("\nN\tT(N)\t\t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");

		for (int vertexCount = nStart; vertexCount <= nStop; vertexCount += nStep) {

			String fullPathName = filename + vertexCount + ".dot";

			// Create a data set to work with
			if (timingMethod.equals("topological")) {
				generateRandomDotFile(fullPathName, vertexCount, edgeFactor, "acyclic");
			} else if (timingMethod.equals("breadth-first search")) {
				generateRandomDotFile(fullPathName, vertexCount, edgeFactor, "cyclic");
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
					GraphUtil.breadthFirstSearch(fullPathName, startVert, destVert);
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
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

			if (avgTime <= 0) {
				retry = true;
				vertexCount -= nStep;
				continue;
			} else {
				retry = false;
			}

			System.out.println(formatter.format(avgTime) + "\t\t|\t"
					+ formatter.format(avgTime / (Math.log10(vertexCount) / Math.log10(2))) + "\t\t"
					+ formatter.format(avgTime / (vertexCount * (Math.log10(vertexCount) / Math.log10(2)))) + "\t\t"
					+ formatter.format(avgTime / vertexCount) + "\t\t"
					+ formatter.format(avgTime / (vertexCount * vertexCount)) + "\t\t"
					+ formatter.format(avgTime / (vertexCount * vertexCount * vertexCount)));
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");
	}

	/**
	 * 
	 * @param filename
	 * @param vertexCount
	 * @param edgeFactor
	 */
	public static void generateRandomDotFile(String filename, int vertexCount, int edgeFactor, String graphType) {
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

				out.println("\t" + "\"" + vertex[rand1] + "\"" + edgeOp + "\"" + vertex[rand2] + "\"");
				
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

					out.println("\t" + "\"" + vertex[i] + "\"" + edgeOp + "\"" + vertex[nextVert] + "\"");
				}
			}
		}

		out.println("}");
		out.close();
	}
}
