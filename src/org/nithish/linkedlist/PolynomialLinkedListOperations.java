package org.nithish.linkedlist;

public class PolynomialLinkedListOperations {

	PolynomialLinkedListNode head;

	public void insertTwoVariablePolynomial(int coefficient, int xExponent, int yExponent) {
		if (head == null && coefficient != 0) {
			head = new PolynomialLinkedListNode(coefficient, xExponent, yExponent);
		} else if (coefficient != 0) {
			PolynomialLinkedListNode newNode = new PolynomialLinkedListNode(coefficient, xExponent, yExponent);
			newNode.setNext(head);
			head = newNode;
		}
	}

	public void insertOneVariablePolynomial(int coefficient, int xExponent) {
		if (head == null && coefficient != 0) {
			head = new PolynomialLinkedListNode(coefficient, xExponent);
		} else if (coefficient != 0) {

			PolynomialLinkedListNode newNode = new PolynomialLinkedListNode(coefficient, xExponent);
			newNode.setNext(head);
			head = newNode;
		}
	}

	public void displayTwoVariablePolynomial() {
		PolynomialLinkedListNode current = head;
		while (current != null) {
			System.out.print(current.getCoefficient() + "x^" + current.getxExponent() + "y^" + current.getyExponent());
			current = current.getNext();
			if (current != null && current.getCoefficient() > 0) {
				System.out.print("+");
			}
		}
		System.out.println();
	}

	public void displayOneVariablePolynomial() {
		PolynomialLinkedListNode current = head;
		while (current != null) {
			System.out.print(current.getCoefficient() + "x^" + current.getxExponent());
			current = current.getNext();
			if (current != null && current.getCoefficient() > 0) {
				System.out.print("+");
			}
		}
		System.out.println();
	}

	/*public void addTwoOneVariablePolynomials(PolynomialLinkedListOperations p1, PolynomialLinkedListOperations p2) {
		PolynomialLinkedListOperations sum;
		while(p1.getHead()!=null && p2.getHead()!=null){
			if(p1.getHead().getCoefficient()==p2.getHead().getCoefficient()){
				int co=p1.getHead().getCoefficient()+p2.getHead().getCoefficient();
				sum=new PolynomialLinkedListNode(co,0,0)
			}
		}
	}*/

	public PolynomialLinkedListNode getHead() {
		return head;
	}

}
