package org.nithish.linkedlist;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		SingleLinkedList<Integer> sll2 = new SingleLinkedList<Integer>();
		sll2.head = new NodeSLL<Integer>(5);
		sll2.head.setNextNode(new NodeSLL<Integer>(1));
		sll2.head.getNextNode().setNextNode(new NodeSLL<Integer>(2));
		sll2.head.getNextNode().getNextNode().setNextNode(new NodeSLL<Integer>(3));
		sll2.head.getNextNode().getNextNode().getNextNode().setNextNode(new NodeSLL<Integer>(4));
		sll2.head.getNextNode().getNextNode().getNextNode().getNextNode().setNextNode(new NodeSLL<Integer>(6));
		sll2.printLinkedList();
		sll2.deleteEvenNodes(sll2.head);
		System.out.println("After Deleting Evens:");
		sll2.printLinkedList();

	}
}
