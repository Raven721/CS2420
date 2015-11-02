package assign9;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *  ???? 
 * 
 * @author Tim Ellenberger, ellenber
 * @author John Strasser, strasser
 * @author Erin Parker
 * @version 10/29/2015
 */
public class TimingAnalysis {

	public static void main(String[] args) {
		int timesToLoop = 2000;
		int startSize = 1000;
		boolean rand = false;
		int stepSize = 10*startSize;
		
		//Time a sorted BST for finding all elements
		timeBSTContains(timesToLoop, 2000, 22000, 2000, rand, "Contains");
		
		//Time a random BST for finding all elements
		rand = true;
		timeBSTContains(timesToLoop, 2000, 22000, 2000, rand, "Contains");
		
//		// Time breadth-first search where the #edges = 4 * #vertices
//		 timeGraphMethod("src/assign8/Tests/GeneratedGraphs/BFSearch",
//		 "breadth-first search", timesToLoop, vStart, 10*vStart, vStart, eFactor);
//		
//		 // Time breadth-first search where the #edges = 3 * #vertices
//		eFactor = 3;
//		vFactor = 1;
//		vStart = vFactor * 10000;
//		 timeGraphMethod("src/assign8/Tests/GeneratedGraphs/BFSearch",
//		 "breadth-first search", timesToLoop, vStart, 10*vStart, vStart, eFactor);
//		
////		 // Time breadth-first search where the #edges = 4 * #vertices
////		vFactor = 2;
////		eFactor = 1;
////		vStart = vFactor * 10000;
////		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/BFSearch",
////		"breadth-first search", timesToLoop, vStart, 10*vStart, vStart, eFactor);
//	
////		// Time breadth-first search where the #edges = 4 * #vertices
////		vFactor = 4;
////		eFactor = 1;
////		vStart = vFactor * 10000;
////		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/BFSearch",
////		"breadth-first search", timesToLoop, vStart, 10*vStart, vStart, eFactor);
//		
//		// Time breadth-first search where the #edges = 4 * #vertices
//		vFactor = 1;
//		eFactor = 7;
//		vStart = vFactor * 10000;
//		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/BFSearch",
//		"breadth-first search", timesToLoop, vStart, 10*vStart, vStart, eFactor);
//				
//		
//		// Time topological sort
//		vFactor = 1;
//		eFactor = 10;
//		vStart = vFactor * 100;
//		timeGraphMethod("src/assign8/Tests/GeneratedGraphs/topoSort", "topological", timesToLoop, vStart, 10*vStart, vStart, eFactor);
	}

	private static void timeBSTContains(int timesToLoop, int startSize, int stopSize, int stepSize, boolean random, String timingMethod) {
		long startTime, midptTime, stopTime;
		
		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out
				.println("------------------- GraphUtil Timing Analysis: " + timingMethod + (random ? " Inserted Radomized" : " Inserted in-order") + " ----------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | ");
		System.out.println("\nN\tT(N)\t\t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");

		for (int n = startSize; n <= stopSize; n += stepSize) {

			// Create a data set to work with
			List<Integer> setData = new LinkedList<>();
			for (int i = 0; i <n; i++) {
				setData.add(i);
			}
			// random will randomly permute the elements
			if(random) {
				Collections.shuffle(setData);
			}
			
			BinarySearchTree<Integer> myBST = new BinarySearchTree<>();
			myBST.addAll(setData);
			
			System.out.print(n + "\t");

			// Let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;

			// Time the routine
			Random rnd = new Random();
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				myBST.contains(rnd.nextInt(n));
			}

			midptTime = System.nanoTime();
			int temp;
			// Time the empty loops
			for (int i = 0; i < timesToLoop; i++) {
				temp = rnd.nextInt(n);
			}

			stopTime = System.nanoTime();

			// Compute the average time
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

			System.out.println(formatter.format(avgTime) + "\t\t|\t"
					+ formatter.format(avgTime / (Math.log10(n) / Math.log10(2))) + "\t\t"
					+ formatter.format(avgTime / (n * (Math.log10(n) / Math.log10(2)))) + "\t\t"
					+ formatter.format(avgTime / n) + "\t\t"
					+ formatter.format(avgTime / (n * n)) + "\t\t"
					+ formatter.format(avgTime / (n * n * n)));
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");	
	}

//	/**
//	 * 
//	 * @param filename
//	 * @param timingMethod
//	 * @param timesToLoop
//	 * @param nStart
//	 * @param nStop
//	 * @param nStep
//	 * @param edgeFactor
//	 * @param start
//	 * @param end
//	 */
//	private static void timeGraphMethod(String filename, String timingMethod, int timesToLoop, int nStart, int nStop,
//			int nStep, int edgeFactor) {
//		long startTime, midptTime, stopTime;
//		boolean retry = false;
//
//		// try computing T(N)/F(N), see if it converges
//		DecimalFormat formatter = new DecimalFormat("0000E0");
//
//		System.out
//				.println("------------------- GraphUtil Timing Analysis: " + timingMethod + " ----------------------");
//		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | " + "Number of Edges: " + edgeFactor + " * N");
//		System.out.println("\nN\tT(N)\t\t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
//		System.out.println(
//				"---------------------------------------------------------------------------------------------------------");
//
//		for (int vertexCount = nStart; vertexCount <= nStop; vertexCount += nStep) {
//
//			String fullPathName = filename + vertexCount + ".dot";
//
//			// Create a data set to work with
//			if (timingMethod.equals("topological")) {
//				generateRandomDotFile(fullPathName, vertexCount, edgeFactor, "acyclic");
//			} else if (timingMethod.equals("breadth-first search")) {
//				generateRandomDotFile(fullPathName, vertexCount, edgeFactor, "cyclic");
//			}
//
//			if (!retry) {
//				System.out.print(vertexCount + "\t");
//			}
//
//			// Let things stabilize
//			startTime = System.nanoTime();
//			while (System.nanoTime() - startTime < 1000000000)
//				;
//
//			// Time the routine
//			startTime = System.nanoTime();
//			if (timingMethod.equals("topological")) {
//				for (int i = 0; i < timesToLoop; i++) {
//					GraphUtil.topologicalSort(fullPathName);
//				}
//			} else if (timingMethod.equals("breadth-first search")) {
//				for (int i = 0; i < timesToLoop; i++) {
//					GraphUtil.breadthFirstSearch(fullPathName, startVert, destVert);
//				}
//			}
//
//			midptTime = System.nanoTime();
//
//			// Time the empty loops
//			if (timingMethod.equals("topological")) {
//				for (int i = 0; i < timesToLoop; i++) {
//					GraphUtil.buildGraphFromDot(fullPathName);
//				}
//			} else if (timingMethod.equals("breadth-first search")) {
//				for (int i = 0; i < timesToLoop; i++) {
//					GraphUtil.buildGraphFromDot(fullPathName);
//				}
//			}
//
//			stopTime = System.nanoTime();
//
//			// Compute the average time
//			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;
//
//			if (avgTime <= 0) {
//				retry = true;
//				vertexCount -= nStep;
//				continue;
//			} else {
//				retry = false;
//			}
//
//			System.out.println(formatter.format(avgTime) + "\t\t|\t"
//					+ formatter.format(avgTime / (Math.log10(vertexCount) / Math.log10(2))) + "\t\t"
//					+ formatter.format(avgTime / (vertexCount * (Math.log10(vertexCount) / Math.log10(2)))) + "\t\t"
//					+ formatter.format(avgTime / vertexCount) + "\t\t"
//					+ formatter.format(avgTime / (vertexCount * vertexCount)) + "\t\t"
//					+ formatter.format(avgTime / (vertexCount * vertexCount * vertexCount)));
//		}
//		System.out.println(
//				"---------------------------------------------------------------------------------------------------------");
//	}
//
//	/**
//	 * 
//	 * @param filename
//	 * @param vertexCount
//	 * @param edgeFactor
//	 */
//	public static void generateRandomDotFile(String filename, int vertexCount, int edgeFactor, String graphType) {
//		PrintWriter out = null;
//		try {
//			out = new PrintWriter(filename);
//		} catch (IOException e) {
//			System.out.println(e);
//		}
//
//		Random rng = new Random();
//
//		// randomly construct a digraph
//		String edgeOp = "->";
//		out.println("digraph G {");
//
//		// generate a list of vertices
//		if (vertexCount < 0) {
//			System.out.println("VertexCount negative: " + vertexCount);
//		}
//		String[] vertex = new String[vertexCount];
//		for (int i = 0; i < vertexCount; i++) {
//			vertex[i] = "v" + i;
//		}
//
//		// randomly connect the vertices using 2 * |V| edges
//		if (graphType.equals("cyclic")) {
//			int rand1, rand2;
//			for (int i = 0; i < edgeFactor * vertexCount; i++) {
//				rand1 = rng.nextInt(vertexCount);
//				rand2 = rng.nextInt(vertexCount);
//
//				out.println("\t" + "\"" + vertex[rand1] + "\"" + edgeOp + "\"" + vertex[rand2] + "\"");
//				
//				if (i == 0) {
//					startVert = "v" + Integer.toString(rand1);
//				}
//				destVert = "v" + Integer.toString(rand2);
//				
//			}
//		}
//		// Randomly connect vertex to vertices below it in the graph
//		else if (graphType.equals("acyclic")) {
//			int nextVert;
//			for (int j = 0; j < edgeFactor; j++) {
//				for (int i = 0; i < vertexCount - 1; i++) {
//					do {
//						nextVert = rng.nextInt(vertexCount - i) + (i + 1) - 1;
//					} while (nextVert <= i || nextVert > vertex.length - 1);
//
//					out.println("\t" + "\"" + vertex[i] + "\"" + edgeOp + "\"" + vertex[nextVert] + "\"");
//				}
//			}
//		}
//
//		out.println("}");
//		out.close();
//	}
}
