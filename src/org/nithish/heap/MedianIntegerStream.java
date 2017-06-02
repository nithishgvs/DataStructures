package org.nithish.heap;

import org.nithish.heap.Heap.HeapEmptyException;
import org.nithish.heap.Heap.HeapFullException;

public class MedianIntegerStream {

	public static int[] randomNumberArray = new int[] { 5, 15, 1, 3 };

	public static int medianIntegerStream(int[] array) throws HeapFullException, HeapEmptyException {
		MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);
		MaxHeap<Integer> maxHeap = new MaxHeap<>(Integer.class);
		for (Integer i : array) {
			if (minHeap.isEmpty() && maxHeap.isEmpty()) {
				maxHeap.insert(i);
			} else if (i < (int) maxHeap.getHighestPriority()) {
				maxHeap.insert(i);
			} else {
				minHeap.insert(i);
			}
		}
		System.out.println("Min Heap");
		minHeap.printHeapArray();
		System.out.println("Max Heap");
		maxHeap.printHeapArray();
		while (minHeap.getCount() - maxHeap.getCount() > 1) {
			int elem = (int) minHeap.removeHighestPriority();
			maxHeap.insert(elem);
		}
		while (maxHeap.getCount() - minHeap.getCount() > 1) {
			int elem = (int) maxHeap.removeHighestPriority();
			minHeap.insert(elem);
		}
		System.out.println("Min Heap");
		minHeap.printHeapArray();
		System.out.println("Max Heap");
		maxHeap.printHeapArray();
		if (minHeap.getCount() == maxHeap.getCount()) {
			return ((int) minHeap.getHighestPriority() + (int) maxHeap.getHighestPriority()) / 2;
		} else if (minHeap.getCount() > maxHeap.getCount()) {
			return (int) minHeap.getHighestPriority();
		} else {
			return (int) maxHeap.getHighestPriority();
		}
	}

	public static void main(String[] args) throws HeapFullException, HeapEmptyException {
		System.out.println(medianIntegerStream(randomNumberArray));

	}

}
