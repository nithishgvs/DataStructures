package org.nithish.stack;

public class Stack<T> {

	private static int MAX_SIZE = 100;
	public int size = 0;
	private Element<T> top;

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (size == MAX_SIZE) {
			return true;
		}
		return false;
	}

	public void push(T data) throws StackOverFlowException {
		if (isFull()) {
			throw new StackOverFlowException();
		}
		Element elem = new Element<T>(data, top);
		top = elem;
		size++;
	}

	public T pop() throws StackUnderFlowException {
		if (size == 0) {
			throw new StackUnderFlowException();
		}
		T data = top.getData();
		top = top.getNext();
		size--;
		return data;
	}

	public T peek() throws StackUnderFlowException {
		if (size == 0) {
			throw new StackUnderFlowException();
		}
		return top.getData();

	}
}
