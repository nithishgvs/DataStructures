package org.nithish.heap;

import org.nithish.heap.Heap.HeapEmptyException;
import org.nithish.heap.Heap.HeapFullException;

public class kthSmallLargeElement {

	public static int[] arr = { 7, 10, 4, 3, 20, 15 };

	public static void kthSmallest(int[] arr, int k) throws HeapFullException, HeapEmptyException {
		MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			minHeap.insert(arr[i]);
		}
		for (j = 1; j <= k; j++) {
			if (j == k) {
				System.out.println((int) minHeap.removeHighestPriority());
			} else {
				minHeap.removeHighestPriority();
			}
		}
	}

	public static void kthLargest(int[] arr, int k) throws HeapFullException, HeapEmptyException {
		MaxHeap<Integer> maxHeap = new MaxHeap<>(Integer.class);
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			maxHeap.insert(arr[i]);
		}
		for (j = 1; j <= k; j++) {
			if (j == k) {
				System.out.println((int) maxHeap.removeHighestPriority());
			} else {
				maxHeap.removeHighestPriority();
			}
		}
	}

	public static void main(String[] args) throws HeapFullException, HeapEmptyException {
		kthSmallest(arr, 3);

	}

}
