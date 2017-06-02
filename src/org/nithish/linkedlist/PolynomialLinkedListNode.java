package org.nithish.linkedlist;

public class PolynomialLinkedListNode {

	private int coefficient;
	private int xExponent;
	private int yExponent;
	// Next Node
	private PolynomialLinkedListNode next;

	public PolynomialLinkedListNode getNext() {
		return next;
	}

	public void setNext(PolynomialLinkedListNode next) {
		this.next = next;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public int getxExponent() {
		return xExponent;
	}

	public int getyExponent() {
		return yExponent;
	}
    //Constructor
	public PolynomialLinkedListNode(int coefficient, int xExponent, int yExponent) {
		this.coefficient = coefficient;
		this.xExponent = xExponent;
		this.yExponent = yExponent;
	}
	//Constructor
	public PolynomialLinkedListNode(int coefficient, int xExponent) {
		this.coefficient = coefficient;
		this.xExponent = xExponent;
	}

}
