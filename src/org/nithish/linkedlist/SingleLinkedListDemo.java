package org.nithish.linkedlist;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		SingleLinkedList<Integer> sll2 = new SingleLinkedList<Integer>();
		sll2.head = new NodeSLL<Integer>(1);
		sll2.head.setNextNode(new NodeSLL<Integer>(2));
		sll2.head.getNextNode().setNextNode(new NodeSLL<Integer>(3));
		sll2.head.getNextNode().getNextNode().setNextNode(new NodeSLL<Integer>(4));
		sll2.head.getNextNode().getNextNode().getNextNode().setNextNode(new NodeSLL<Integer>(5));
		sll2.printLinkedListWithHeadPointer(sll2.head);
		System.out.println("***************");
		//sll2.head.getNextNode().getNextNode().getNextNode().getNextNode().setNextNode(new NodeSLL<Integer>(6));
		SingleLinkedList<Integer> sll1 = new SingleLinkedList<Integer>();
		sll1.head = new NodeSLL<Integer>(6);
		sll1.head.setNextNode(new NodeSLL<Integer>(7));
		sll1.head.getNextNode().setNextNode(new NodeSLL<Integer>(8));
		sll1.head.getNextNode().getNextNode().setNextNode(sll2.head.getNextNode().getNextNode());
		sll1.printLinkedListWithHeadPointer(sll1.head);
		sll1.SingleLinkedListIntersection(sll2.head, sll1.head);
		

	}
}
