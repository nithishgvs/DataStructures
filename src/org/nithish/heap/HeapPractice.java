package org.nithish.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.nithish.graphs.PrimsAlgorithm.VertexInfo;

public class HeapPractice {

	public static void HeapMaxNElements(int[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(5, new Comparator<Integer>() {
			@Override
			public int compare(Integer a1, Integer a2) {
				return a1 - a2;
			}

		});
		
		for (Integer elem:arr){
			minHeap.add(elem);
		}
		System.out.println(minHeap.peek());

	}

	public static void main(String[] args) {
		int [] arr={1,3,4,5,6};
		HeapMaxNElements(arr,5);

	}

}
