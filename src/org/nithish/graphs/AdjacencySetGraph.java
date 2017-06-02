package org.nithish.graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencySetGraph implements Graph {

	private List<Node> vertexList = new ArrayList<Node>();
	private GraphType graphType = GraphType.DIRECTED;
	private int numVertices = 0;

	public AdjacencySetGraph(int numVertices, GraphType graphType) {
		this.numVertices = numVertices;
		for (int i = 0; i < numVertices; i++) {
			vertexList.add(new Node(i));
		}
		this.graphType = graphType;
	}

	@Override
	public void addEdge(int v1, int v2) {
		if (v1 >= numVertices || v1 < 0 | v2 >= numVertices | v2 < 0) {
			throw new IllegalArgumentException("Vertices are not valid: " + v1 + "," + v2);
		}
		vertexList.get(v1).addEdge(v2);
		if (graphType == GraphType.UNDIRECTED) {
			vertexList.get(v2).addEdge(v1);
		}
	}

	@Override
	public List<Integer> getAdjacentVertices(int v) {
		if (v >= numVertices || v < 0) {
			throw new IllegalArgumentException("Vertices are not valid");
		}
		return vertexList.get(v).getAdjacentVertices();
	}

	@Override
	public int getNumVertices() {
		return numVertices;
	}

	@Override
	public int getIndegree(int v) {
		if (v < 0 || v >= numVertices) {
			throw new IllegalArgumentException("Vertex is not valid");
		}
		int indegree = 0;
		for (int i = 0; i < getNumVertices(); i++) {
			if (getAdjacentVertices(i).contains(v)) {
				indegree++;
			}
		}
		return indegree;
	}

	@Override
	public int getWeightedEdge(int v1, int v2) {
		throw new IllegalArgumentException("Weight not implemented in Adjacency Set");
	}

}
