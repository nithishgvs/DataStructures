package org.nithish.linkedlist;

public class LinkedListEmptyException extends RuntimeException {
	public LinkedListEmptyException() {
		super();
	}

	public LinkedListEmptyException(String message) {
		super(message);
	}
}
