package org.nithish.linkedlist;

public class RandomNodeLinkedList {

	static RandomNodeLinkedListNode head;

	public static RandomNodeLinkedListNode addDataToLL(int data) {
		RandomNodeLinkedListNode node = new RandomNodeLinkedListNode(data);
		if (head == null) {
			return node;
		}
		head.setNext(node);
		return head;
	}

	public static void main(String[] args) {
		RandomNodeLinkedListNode head = addDataToLL(5);
		// 5 Next->4
		head.setNext(new RandomNodeLinkedListNode(4));
		// 4 Next->3,Random->5
		head.getNext().setRandom(head);
		head.getNext().setNext(new RandomNodeLinkedListNode(3));
		// 5 Random->3
		head.setRandom(head.getNext().getNext());
		// 2 ,Next->1 Random->3
		head.getNext().getNext().setNext(new RandomNodeLinkedListNode(2));
		head.getNext().getNext().getNext().setRandom(head.getNext().getNext());
		// 1,Next points to null Random ->4
		head.getNext().getNext().setNext(new RandomNodeLinkedListNode(1));
		head.getNext().getNext().getNext().getNext().setRandom(head.getNext());
		RandomNodeLinkedListNode clone = addDataToLL(5);
		// 5 Next->4
		clone.setNext(new RandomNodeLinkedListNode(4));
		clone.getNext().setNext(new RandomNodeLinkedListNode(3));
		clone.getNext().getNext().setNext(new RandomNodeLinkedListNode(2));
		clone.getNext().getNext().setNext(new RandomNodeLinkedListNode(1));
		

	}

}
