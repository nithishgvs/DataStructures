package org.nithish.trees;

public class Node<T> {

	public T data;
	public Node<T> leftChild;
	public Node<T> rightChild;

	// Setters and Getters
	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Node<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}

	public T getData() {
		return data;
	}

	public Node(T data) {
		this.data = data;
	}

}
