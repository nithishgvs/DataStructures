package org.nithish.heap;

import java.lang.reflect.Array;

public abstract class Heap<T extends Comparable<T>> {
	public static int MAX_SIZE = 40;
	private int count = 0;
	private T[] array;

	public Heap(Class<T> clazz) {
		this(clazz, MAX_SIZE);
	}

	public Heap(Class<T> clazz, int size) {
		array = (T[]) Array.newInstance(clazz, MAX_SIZE);
	}

	public int getLeftChildIndex(int index) {
		int leftChildIndex = 2 * index + 1;
		if (leftChildIndex >= count) {
			return -1;
		}
		return leftChildIndex;
	}

	public int getRightChildIndex(int index) {
		int rightChildIndex = 2 * index + 2;
		if (rightChildIndex >= count) {
			return -1;
		}
		return rightChildIndex;
	}

	public int getParentIndex(int index) {
		if (index <0 || index > count) {
            return -1;
        }

        return (index - 1) / 2;
	}

	protected void swap(int index1, int index2) {
        T tempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = tempValue;
    }

	public int getCount() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == array.length;
	}

	public T getElementAtIndex(int index) {
		return array[index];
	}

	protected abstract void siftDown(int index);

	protected abstract void siftUp(int index);

	public void insert(T value) throws HeapFullException {
		if (count > array.length) {
			throw new HeapFullException();
		}
		array[count] = value;
		siftUp(count);
		count++;
	}

	public T removeHighestPriority() throws HeapEmptyException {
		T min = getHighestPriority();
		array[0] = array[count - 1];
		count--;
		siftDown(0);
		return min;

	}

	public T getHighestPriority() throws HeapEmptyException {
		if (count == 0) {
			throw new HeapEmptyException();
		}
		return array[0];
	}

	public static class HeapFullException extends Exception {
	}

	public static class HeapEmptyException extends Exception {
	}

	public void printHeapArray() {
		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println();

		try {
			System.out.println("Highest priority: " + getHighestPriority());
		} catch (HeapEmptyException ex) {

		}
	}
}
