package org.nithish.heap;

import org.nithish.heap.Heap.HeapEmptyException;
import org.nithish.heap.Heap.HeapFullException;

public class HeapsKLargestElements {

	public static int[] randomNumberArray = new int[] { 2, 5, 6, 21, 67, 88, 4, 1, 3, 9, 99 };

	public static void printMaximumKElements(int k) throws HeapFullException, HeapEmptyException {
		MinHeap<Integer> minHeap = new MinHeap<>(Integer.class, k);
		for (int number : randomNumberArray) {
			if (minHeap.isEmpty()) {
				minHeap.insert(number);
			} else if (!minHeap.isFull() || (int) minHeap.getHighestPriority() < number) {
				if (minHeap.isFull()) {
					minHeap.removeHighestPriority();
				}
				minHeap.insert(number);
			}

		}
		minHeap.printHeapArray();
	}
	public static void main(String[] args) throws HeapFullException, HeapEmptyException{
		HeapsKLargestElements kk=new HeapsKLargestElements();
		kk.printMaximumKElements(5);
	}

}
