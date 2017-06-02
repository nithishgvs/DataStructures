package org.nithish.stack;

import org.nithish.queue.Queue;
import org.nithish.queue.Queue.QueueOverFlowException;
import org.nithish.queue.Queue.QueueUnderFlowException;

public class StackWithOneQueue {
	Queue<Integer> queue = new Queue<Integer>(Integer.class);

	public boolean isFull() {
		return (queue.isFull());
	}

	public boolean isEmpty() {
		return (queue.isEmpty());
	}

	public void push(Integer data) throws QueueOverFlowException, QueueUnderFlowException {
		queue.enqueue(data);
		int size = queue.size();
		if (size>1) {
			int elem=queue.dequeue();
			queue.enqueue(elem);
			size--;
		}
	}

	public Integer pop() throws QueueUnderFlowException {
		if (!queue.isEmpty()) {
			return queue.dequeue();
		}
		else{
			throw new QueueUnderFlowException();
		}
	}

}
