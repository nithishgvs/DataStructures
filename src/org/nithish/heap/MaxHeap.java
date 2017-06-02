package org.nithish.heap;

public class MaxHeap<T extends Comparable<T>> extends Heap {

	public MaxHeap(Class clazz) {
		super(clazz);
	}

	public MaxHeap(Class clazz, int size) {
		super(clazz, size);
	}

	@Override
	protected void siftDown(int index) {
		int largerIndex = -1;
		int leftChildIndex = getLeftChildIndex(index);
		int rightChildIndex = getRightChildIndex(index);
		if (leftChildIndex != -1 && rightChildIndex != -1) {
			largerIndex = getElementAtIndex(leftChildIndex).compareTo(getElementAtIndex(rightChildIndex)) > 0
					? leftChildIndex : rightChildIndex;
		} else if (leftChildIndex != -1) {
			largerIndex = leftChildIndex;
		} else if (rightChildIndex != -1) {
			largerIndex = rightChildIndex;
		}
		if (largerIndex == -1) {
			return;
		}
		if (getElementAtIndex(largerIndex).compareTo(getElementAtIndex(index)) > 0) {
			swap(largerIndex, index);
			siftDown(largerIndex);
		}

	}

	@Override
	protected void siftUp(int index) {
		int parentIndex = getParentIndex(index);
		if (parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) > 0) {
			swap(parentIndex, index);
			siftUp(parentIndex);
		}

	}
}
