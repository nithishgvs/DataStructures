package org.nithish.queue;

import org.nithish.queue.Queue.QueueOverFlowException;
import org.nithish.queue.Queue.QueueUnderFlowException;
import org.nithish.stack.Stack;
import org.nithish.stack.StackOverFlowException;
import org.nithish.stack.StackUnderFlowException;

public class QueueWithTwoStacks<T> {

	private Stack<T> forwardStack;
	private Stack<T> reverseStack;

	public boolean isFull() {
		return (forwardStack.isFull() || reverseStack.isFull());
	}

	public boolean isEmpty() {
		return (forwardStack.isEmpty() && reverseStack.isEmpty());
	}

	public void enqueue(T data) throws QueueOverFlowException {
		if (isFull()) {
			throw new Queue.QueueOverFlowException();
		}
		try {
			if (forwardStack.isEmpty()) {
				while (!reverseStack.isEmpty()) {
					forwardStack.push(reverseStack.pop());
				}
			}
			forwardStack.push(data);
		} catch (StackOverFlowException | StackUnderFlowException se) {
			throw new Queue.QueueOverFlowException();
		}

	}

	public T dequeue() throws QueueUnderFlowException {
		if (isEmpty()) {
			throw new Queue.QueueUnderFlowException();
		}
		try {
			if (reverseStack.isEmpty()) {
				while (!forwardStack.isEmpty()) {
					reverseStack.push(forwardStack.pop());
				}
			}
			return reverseStack.pop();
		} catch (StackOverFlowException | StackUnderFlowException se) {
			throw new Queue.QueueUnderFlowException();
		}
	}
}
