package org.nithish.stack;

import org.nithish.queue.Queue.QueueOverFlowException;
import org.nithish.queue.Queue.QueueUnderFlowException;

public class StackTestCases {

	public static void main(String[] args) throws StackOverFlowException, StackUnderFlowException, QueueOverFlowException, QueueUnderFlowException {
		StackWithOneQueue stack=new StackWithOneQueue();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
	}

}
