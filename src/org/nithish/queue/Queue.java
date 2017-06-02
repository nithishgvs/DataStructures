package org.nithish.queue;

import java.lang.reflect.Array;

public class Queue<T> {

	public static final int SPECIAL_EMPTY_VALUE = -1;
	public static final int MAX_SIZE = 40;
	private T[] elements;

	private int headIndex = SPECIAL_EMPTY_VALUE;
	private int tailIndex = SPECIAL_EMPTY_VALUE;

	// Creating generic array
	public Queue(Class<T> clazz) {
		elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
	}

	public boolean isEmpty() {
		return (headIndex == SPECIAL_EMPTY_VALUE);
	}

	public boolean isFull() {
		int nextIndex = (tailIndex + 1) % elements.length;
		return (nextIndex == headIndex);
	}

	public void enqueue(T data) throws QueueOverFlowException {
		if (isFull()) {
			throw new QueueOverFlowException();
		}
		tailIndex = (tailIndex + 1) % elements.length;
		elements[tailIndex] = data;
		// If this is the first element enqueued
		// Head index equals Tail Index
		if (headIndex == SPECIAL_EMPTY_VALUE) {
			headIndex = tailIndex;
		}

	}

	public T dequeue() throws QueueUnderFlowException {
		if (isEmpty()) {
			throw new QueueUnderFlowException();
		}
		T data = elements[headIndex];
		// If this was last element in the Queue
		if (headIndex == tailIndex) {
			headIndex = SPECIAL_EMPTY_VALUE;
		} else {
			headIndex = (headIndex + 1) % elements.length;
		}
		return data;
	}

	public static class QueueUnderFlowException extends Exception {
	}

	public static class QueueOverFlowException extends Exception {

	}

	public int size() {
		return (tailIndex + 1) % elements.length;
	}
	public T peek() throws QueueUnderFlowException {
        if (isEmpty()) {
            throw new QueueUnderFlowException();
        }

        return elements[headIndex];        
    }


}
