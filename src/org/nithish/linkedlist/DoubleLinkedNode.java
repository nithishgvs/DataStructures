package org.nithish.linkedlist;

public class DoubleLinkedNode {

	private int data;
	private DoubleLinkedNode nextNode;
	private DoubleLinkedNode previousNode;

	public DoubleLinkedNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(DoubleLinkedNode nextNode) {
		this.nextNode = nextNode;
	}

	public DoubleLinkedNode getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(DoubleLinkedNode previousNode) {
		this.previousNode = previousNode;
	}

	public DoubleLinkedNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}
	 /**
     * Display Node's data
     */
    public void displayNode() {
           System.out.print( data + " ");
    }
}
