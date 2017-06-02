package org.nithish.stack;

public class StackOverFlowException extends Exception {

	public StackOverFlowException() {
		System.out.println("Stack has reached its maximum size");
	}
}
