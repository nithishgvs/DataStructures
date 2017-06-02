package org.nithish.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ShortestPathUnweighted {

	// Build Distance Info Table
	public static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
		Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
		for (int i = 0; i < graph.getNumVertices(); i++) {
			distanceTable.put(i, new DistanceInfo());
		}
		// Setting Distance from Source to Source in Table to 0
		distanceTable.get(source).setDistance(0);
		// Setting last destination of source to itself (A 0 A) in table
		distanceTable.get(source).setDistance(source);
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(source);
		while (!queue.isEmpty()) {
			int currentVertex = queue.pollFirst();
			List<Integer> adjacentVertices = graph.getAdjacentVertices(currentVertex);
			for (Integer adjacentVertex : adjacentVertices) {
				int currentDistance = distanceTable.get(adjacentVertex).getDistance();
				if (currentDistance == -1) {
					currentDistance = 1 + distanceTable.get(source).getDistance();
					distanceTable.get(adjacentVertex).setDistance(currentDistance);
					distanceTable.get(adjacentVertex).setLastVertex(currentVertex);
					// Enqueue the neighbour only if it has other adjacent
					// vertices.
					if (!graph.getAdjacentVertices(adjacentVertex).isEmpty()) {
						queue.add(adjacentVertex);
					}
				}
			}
		}
		return distanceTable;
	}

	// BackTracking and adding them into Stack
	public static void shortestPath(int source, int destination, Graph graph) {
		Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);
		Stack<Integer> stack = new Stack<>();
		stack.add(destination);
		int previousVertex = distanceTable.get(destination).getLastVertex();
		while (previousVertex != -1 && previousVertex != source) {
			stack.add(previousVertex);
			previousVertex = distanceTable.get(previousVertex).getLastVertex();
		}
		if (previousVertex == -1) {
			System.out.println("There is no path from node: " + source + " to node: " + destination);
		} else {
			System.out.print("Smallest path is " + source);
			while (!stack.isEmpty()) {
				System.out.print(" -> " + stack.pop());
			}
			System.out.println(" Shortest Path Unweighted DONE!");
		}
	}

	/**
	 * A class which holds the distance information of any vertex. The distance
	 * specified is the distance from the source node and the last vertex is the
	 * last vertex just before the current one while traversing from the source
	 * node.
	 */
	public static class DistanceInfo {

		private int distance;
		private int lastVertex;

		public DistanceInfo() {
			distance = -1;
			lastVertex = -1;
		}

		public int getDistance() {
			return distance;
		}

		public int getLastVertex() {
			return lastVertex;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public void setLastVertex(int lastVertex) {
			this.lastVertex = lastVertex;
		}
	}
}
