package org.nithish.graphs;

import java.util.List;

import org.nithish.queue.Queue;
import org.nithish.queue.Queue.QueueOverFlowException;
import org.nithish.queue.Queue.QueueUnderFlowException;

public class GraphBreadthFirstTraversal {

	private static int N = 5;

	public static void main(String[] args) throws QueueOverFlowException, QueueUnderFlowException {
		Graph graph = new AdjacencyMatrixGraph(N, Graph.GraphType.DIRECTED);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 1);
		graph.addEdge(4, 3);

		int[] visited = new int[] { 0, 0, 0, 0, 0 };

		// This for-loop ensures that all nodes are covered even for an
		// unconnected
		// graph.
		for (int i = 0; i < N; i++) {
			breadthFirstTraversal(graph, visited, i);
		}

	}

	/**
	 * 
	 * @param graph
	 * @param visited
	 * @param currentVertex
	 * @throws QueueOverFlowException
	 * @throws QueueUnderFlowException
	 */
	private static void breadthFirstTraversal(Graph graph, int[] visited, int currentVertex)
			throws QueueOverFlowException, QueueUnderFlowException {
		Queue<Integer> queue = new Queue(Integer.class);
		queue.enqueue(currentVertex);
		while (!queue.isEmpty()) {
			int vertex = queue.dequeue();
			if (visited[currentVertex] == 1) {
				continue;
			}
			System.out.print(currentVertex + "->");
			visited[vertex] = 1;
			List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);
			for (int v : adjacentVertices) {
				if (visited[v] != 1) {
					queue.enqueue(v);
				}
			}
		}

	}

}
