package org.nithish.graphs;

import java.util.List;

public interface Graph {

	enum GraphType {
		DIRECTED, UNDIRECTED
	}

	void addEdge(int v1, int v2);

	List<Integer> getAdjacentVertices(int v);

	int getNumVertices();

	int getIndegree(int v);

	int getWeightedEdge(int v1, int v2);
}
