package org.nithish.graphs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Dijkstra {

	public static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
		Map<Integer, DistanceInfo> distanceTable = new HashMap<Integer, Dijkstra.DistanceInfo>();
		PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
			// Ascending Order Sorting
			@Override
			public int compare(VertexInfo v1, VertexInfo v2) {
				return ((Integer) v1.getDistance()).compareTo(v2.getDistance());
			}
		});
		Map<Integer, VertexInfo> vertexInfoMap = new HashMap<Integer, Dijkstra.VertexInfo>();
		// Setup Distance Table
		for (int j = 0; j < graph.getNumVertices(); j++) {
			distanceTable.put(j, new DistanceInfo());
		}
		// Set up source in Distance Table
		distanceTable.get(source).setDistance(0);
		distanceTable.get(source).setLastVertex(source);
		// Adding source to Priority Queue by creating VertexInfo object for the
		// Source
		VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
		queue.add(sourceVertexInfo);

		vertexInfoMap.put(source, sourceVertexInfo);

		while (!queue.isEmpty()) {
			VertexInfo vertexInfo = queue.poll();
			int currentVertex = vertexInfo.getVertexId();
			for (Integer neighbour : graph.getAdjacentVertices(currentVertex)) {
				// Get the new distance, account for the weighted edge.
				int distance = distanceTable.get(currentVertex).getDistance()
						+ graph.getWeightedEdge(currentVertex, neighbour);
				// If we find a new shortest path to the neighbour update
				// the distance and the last vertex.
				if (distanceTable.get(neighbour).getDistance() > distance) {
					distanceTable.get(neighbour).setDistance(distance);
					distanceTable.get(neighbour).setLastVertex(currentVertex);
					// We've found a new short path to the neighbour so remove
					// the old node from the priority queue.
					VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
					if (neighbourVertexInfo != null) {
						queue.remove(neighbourVertexInfo);
					}
					neighbourVertexInfo = new VertexInfo(neighbour, distance);
					queue.add(neighbourVertexInfo);
					vertexInfoMap.put(neighbour, neighbourVertexInfo);
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
			// The initial distance to all nodes is assumed
			// infinite.
			distance = Integer.MAX_VALUE;
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

	/**
	 * A simple class which holds the vertex id and the weight of the edge that
	 * leads to that vertex from its neighbour.The purpose of this is we add
	 * this info to the priority queue
	 */
	public static class VertexInfo {

		private int vertexId;
		private int distance;

		public VertexInfo(int vertexId, int distance) {
			this.vertexId = vertexId;
			this.distance = distance;
		}

		public int getVertexId() {
			return vertexId;
		}

		public int getDistance() {
			return distance;
		}
	}

}
