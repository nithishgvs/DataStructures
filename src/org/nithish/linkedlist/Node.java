package org.nithish.linkedlist;

public class Node {

	private int data;
	private Node nextNode;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public Node(int data) {
		this.data = data;
	}
	@Override 
	public String toString(){
		return "DATA:"+(this.data);
	}

}
