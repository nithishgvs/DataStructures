package org.nithish.stack;

import org.nithish.queue.Queue;
import org.nithish.queue.Queue.QueueOverFlowException;
import org.nithish.queue.Queue.QueueUnderFlowException;

public class StackWithTwoQueues {

	Queue<Integer> forwardQueue = new Queue<Integer>(Integer.class);
	Queue<Integer> reverseQueue = new Queue<Integer>(Integer.class);

	public boolean isFull() {
		return (forwardQueue.isFull() || reverseQueue.isFull());
	}

	public boolean isEmpty() {
		return (forwardQueue.isEmpty() && reverseQueue.isEmpty());
	}

	public void push(Integer data) throws QueueOverFlowException, QueueUnderFlowException {
		if (forwardQueue.isEmpty()) {
			forwardQueue.enqueue(data);
			while (!reverseQueue.isEmpty()) {
				forwardQueue.enqueue(reverseQueue.dequeue());
			}
		} else {
			reverseQueue.enqueue(data);
			while (!forwardQueue.isEmpty()) {
				reverseQueue.enqueue(forwardQueue.dequeue());
			}
		}
	}

	public Integer pop() throws QueueOverFlowException, QueueUnderFlowException {

		if (forwardQueue.isEmpty()) {
			return reverseQueue.dequeue();
		} else {
			return forwardQueue.dequeue();
		}
	}
}
