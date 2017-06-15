package org.nithish.linkedlist;

public class RandomNodeLinkedListNode {

	private int data;
	private RandomNodeLinkedListNode next;
	private RandomNodeLinkedListNode random;

	public RandomNodeLinkedListNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public RandomNodeLinkedListNode getNext() {
		return next;
	}

	public void setNext(RandomNodeLinkedListNode next) {
		this.next = next;
	}

	public RandomNodeLinkedListNode getRandom() {
		return random;
	}

	public void setRandom(RandomNodeLinkedListNode random) {
		this.random = random;
	}

}
