package org.nithish.stack;

public class MinimumStack {

	public Stack<Integer> originalStack = new Stack<Integer>();
	public Stack<Integer> minimumStack = new Stack<Integer>();

	public void push(Integer data) throws StackOverFlowException, StackUnderFlowException {
		int min = data;
		if (!minimumStack.isEmpty()) {
			if (min > minimumStack.peek()) {
				min = minimumStack.peek();
			}
		}
		minimumStack.push(min);
		originalStack.push(data);
	}

	public int pop() throws StackUnderFlowException {
		minimumStack.pop();
		return originalStack.pop();
	}

	public int peek() throws StackUnderFlowException {
		return originalStack.peek();
	}

	public int getMinimum() throws StackUnderFlowException {
		return minimumStack.peek();
	}

}
