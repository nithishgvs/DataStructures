package org.nithish.graphs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class KruskalAlgorithm {

	public static void spanningTree(Graph graph) {
		// A priority queue to store and retrieve the edges on the basis of
		// their
		// weights.
		PriorityQueue<EdgeInfo> queue = new PriorityQueue<>(new Comparator<EdgeInfo>() {
			@Override
			public int compare(EdgeInfo o1, EdgeInfo o2) {
				return o1.getWeight() - o2.getWeight();
			}
		});
		// Add all edges to the priority queue.
		for (int i = 0; i < graph.getNumVertices(); i++) {
			for (Integer neighbour : graph.getAdjacentVertices(i)) {
				queue.add(new EdgeInfo(i, neighbour, graph.getWeightedEdge(i, neighbour)));
			}
		}
		Set<Integer> visitedVertices = new HashSet<>();
		Set<EdgeInfo> spanningTree = new HashSet<>();
		// EdgeMap tracks edges added to spanning tree to make sure there is no
		// Cycle
		Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
		for (int v = 0; v < graph.getNumVertices(); v++) {
			edgeMap.put(v, new HashSet<>());
		}
		while (!queue.isEmpty() && spanningTree.size() < graph.getNumVertices() - 1) {
			EdgeInfo currentEdge = queue.poll();
			// Add the new edge to the edge map and see if it ends up with a
			// cycle.
			// If yes then discard this edge and get the next edge from the
			// priority
			// queue.
			edgeMap.get(currentEdge.getVertex1()).add(currentEdge.getVertex2());
			if (hasCycle(edgeMap)) {
				edgeMap.get(currentEdge.getVertex1()).remove(currentEdge.getVertex2());
				continue;
			}
			spanningTree.add(currentEdge);
			// Add both vertices to the visited list, the set will ensure
			// that only one copy of the vertex exists.
			visitedVertices.add(currentEdge.getVertex1());
			visitedVertices.add(currentEdge.getVertex2());

		}
		// Check whether all vertices have been covered with the spanning tree.
		if (visitedVertices.size() != graph.getNumVertices()) {
			System.out.println("Minimum Spanning Tree is not possible");
		} else {
			System.out.println("Minimum Spanning Tree using Kruskal's Algorithm");
			for (EdgeInfo edgeInfo : spanningTree) {
				System.out.println(edgeInfo);
			}
		}
	}

	private static boolean hasCycle(Map<Integer, Set<Integer>> edgeMap) {
        for (Integer sourceVertex : edgeMap.keySet()) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(sourceVertex);
            Set<Integer> visitedVertices = new HashSet<>();
            while (!queue.isEmpty()) {
                int currentVertex = queue.pollFirst();
                if (visitedVertices.contains(currentVertex)) {
                    return true;
                }

                visitedVertices.add(currentVertex);
                queue.addAll(edgeMap.get(currentVertex));
            }
        }

        return false;
    }

	/**
	 * A class which represents an edge in an undirected weighted graph.
	 */
	public static class EdgeInfo {
		public Integer vertex1;
		public Integer vertex2;
		public Integer weight;

		public Integer getVertex1() {
			return vertex1;
		}

		public Integer getVertex2() {
			return vertex2;
		}

		public Integer getWeight() {
			return weight;
		}

		public EdgeInfo(Integer vertex1, Integer vertex2, Integer weight) {
			this.vertex1 = vertex1;
			this.vertex2 = vertex2;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return String.valueOf(vertex1) + String.valueOf(vertex2);

		}
	}

}
