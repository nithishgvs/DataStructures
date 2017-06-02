package org.nithish.stack;

public class StackPrograms {

	public void reverseStack(Stack<Integer> stack) throws StackUnderFlowException, StackOverFlowException {
		if (!stack.isEmpty()) {
			int top = (Integer) stack.pop();
			reverseStack(stack);
			insertAtBottom(stack, top);
		}

	}

	private void insertAtBottom(Stack<Integer> stack, Integer top)
			throws StackOverFlowException, StackUnderFlowException {
		if (stack.isFull()) {
			throw new StackOverFlowException();
		}
		stack.push(top);
	}
	
	public void InfixtoPrefix(String expression){
		
	}
}
