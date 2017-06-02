package org.nithish.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

	public static List<Integer> sort(Graph graph) {
		Map<Integer, Integer> indegreeMap = new HashMap<Integer, Integer>();
		LinkedList<Integer> queue = new LinkedList<>();

		// Preparing map of Vertices as key and Indegree as value pairs
		for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
			int indegree = graph.getIndegree(vertex);
			indegreeMap.put(vertex, indegree);
			if (indegree == 0) {
				queue.add(vertex);
			}
		}
		List<Integer> sortedList = new LinkedList<Integer>();
		// Dequeue of the nodes from the list if there are more than one.
		// If more than one element exists then it means that the graph
		// has more than one topological sort solution.
		while (!queue.isEmpty()) {
			int vertex = queue.pollLast();
			sortedList.add(vertex);
			List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);
			for (Integer adjVertex : adjacentVertices) {
				int updatedIndegree = indegreeMap.get(adjVertex) - 1;
				indegreeMap.remove(adjVertex);
				indegreeMap.put(adjVertex, updatedIndegree);
				if (updatedIndegree == 0) {
					queue.add(vertex);
				}
			}

		}
		if (sortedList.size() != graph.getNumVertices()) {
			throw new RuntimeException("The Graph had a cycle!");
		}

		return sortedList;
	}

}
