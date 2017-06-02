package org.nithish.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node {

	private int vertexNumber;
	private Set<Integer> adjacencySet = new HashSet<Integer>();

	public int getVertexNumber() {
		return vertexNumber;
	}

	public Node(int vertexNumber) {
		this.vertexNumber = vertexNumber;
	}

	public void addEdge(int vertexNumber) {
		adjacencySet.add(vertexNumber);
	}

	public List<Integer> getAdjacentVertices() {
		List<Integer> sortedList = new ArrayList<Integer>(adjacencySet);
		Collections.sort(sortedList);
		return sortedList;
	}

}
