package org.nithish.heap;

public class MinHeapMaxElement {

	public static int getMaximum(MinHeap<Integer> minHeap) {

		int lastIndex = minHeap.getCount() - 1;
		int lastParent = minHeap.getParentIndex(lastIndex);
		int firstChildIndex = lastParent + 1;

		int maxElement = (int) minHeap.getElementAtIndex(firstChildIndex);
		for (int i = firstChildIndex; i <= lastIndex; i++) {
			if (maxElement < (int) minHeap.getElementAtIndex(i)) {
				maxElement = (int) minHeap.getElementAtIndex(i);
			}
		}

		return maxElement;

	}

}
