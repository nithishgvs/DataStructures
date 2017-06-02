package org.nithish.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.nithish.graphs.Dijkstra.DistanceInfo;

public class BellmanFord {

	public static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
		Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
		for (int j = 0; j < graph.getNumVertices(); j++) {
			distanceTable.put(j, new DistanceInfo());
		}
		// Set up the distance of the specified source.
		distanceTable.get(source).setDistance(0);
		distanceTable.get(source).setLastVertex(source);

		LinkedList<Integer> queue = new LinkedList<>();
		// Relaxing (processing) all the edges numVertices - 1 times
		for (int numofvertices = 0; numofvertices < graph.getNumVertices() - 1; numofvertices++) {
			// Add every vertex to the queue so we're sure to access all the
			// edges
			// in the graph.
			for (int v = 0; v < graph.getNumVertices(); v++) {
				queue.add(v);
			}
			// Keep track of the edges visited so we visit each edge just once
			// in every iteration.
			Set<String> visitedEdges = new HashSet<>();
			while (!queue.isEmpty()) {
				int currentVertex = queue.pollFirst();
				for (Integer neighbour : graph.getAdjacentVertices(currentVertex)) {
					String edge = String.valueOf(currentVertex) + String.valueOf(neighbour);
					// Do not visit edges more than once in each iteration.
					if (visitedEdges.contains(edge)) {
						continue;
					}
					visitedEdges.add(edge);
					int distance = distanceTable.get(currentVertex).getDistance()
							+ graph.getWeightedEdge(currentVertex, neighbour);
					// If we find a new shortest path to the neighbour update
					// the distance and the last vertex.
					if (distanceTable.get(neighbour).getDistance() > distance) {
						distanceTable.get(neighbour).setDistance(distance);
						distanceTable.get(neighbour).setLastVertex(currentVertex);
					}
				}
			}
		}
		// Add all the vertices to the queue one last time to check for
		// a negative cycle.
		for (int v = 0; v < graph.getNumVertices(); v++) {
			queue.add(v);
		}
		while (!queue.isEmpty()) {
			int currentVertex = queue.pollFirst();
			for (Integer neighbour : graph.getAdjacentVertices(currentVertex)) {
				int distance = distanceTable.get(currentVertex).getDistance()
						+ graph.getWeightedEdge(currentVertex, neighbour);
				if (distanceTable.get(neighbour).getDistance() > distance) {
					throw new IllegalArgumentException("The Graph has a -ve cycle");
				}
			}
		}

		return distanceTable;
	}

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
			System.out.print("Smallest Path is " + source);
			while (!stack.isEmpty()) {
				System.out.print(" -> " + stack.pop());
			}
			System.out.println(" Dijkstra  DONE!");
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
			// The initial distance to all nodes is assumed infinite. Set it to
			// a very large value rather than the maximum integer value. Bellman
			// Ford
			// supports negative weights and adding anything to this distance
			// can
			// make it a negative value which interferes with the algorithm.
			distance = 100000;
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
