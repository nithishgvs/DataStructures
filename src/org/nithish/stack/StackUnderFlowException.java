package org.nithish.stack;

public class StackUnderFlowException extends Exception {
	
	public StackUnderFlowException(){
		System.out.println("Stack has no Element");
	}

}
