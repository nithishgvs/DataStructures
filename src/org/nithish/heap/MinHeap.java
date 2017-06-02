package org.nithish.heap;

public class MinHeap<T extends Comparable<T>> extends Heap {

	public MinHeap(Class clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	public MinHeap(Class clazz, int size) {
		super(clazz, size);
	}

	@Override
	protected void siftDown(int index) {
		int leftIndex = getLeftChildIndex(index);
		int rightIndex = getRightChildIndex(index);
		int smallerIndex = -1;
		if (leftIndex != -1 && rightIndex != -1) {
			smallerIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0 ? leftIndex
					: rightIndex;
		} else if (leftIndex != -1) {
			smallerIndex = leftIndex;
		} else if (rightIndex != -1) {
			smallerIndex = rightIndex;
		}
		if (smallerIndex == -1) {
			return;
		}

		if (getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index)) < 0) {
			swap(smallerIndex, index);
			siftDown(smallerIndex);
		}

	}

	@Override
	protected void siftUp(int index) {
		  int parentIndex = getParentIndex(index);
	        if (parentIndex != -1 &&
	                getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0) {
	            swap(parentIndex, index);

	            siftUp(parentIndex);
	        }
		}


}
