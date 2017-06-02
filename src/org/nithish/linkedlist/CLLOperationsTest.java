package org.nithish.linkedlist;

public class CLLOperationsTest {

	public static void main(String[] args) {
		CLLOperations cll=new CLLOperations();
		cll.sortedInsertinCLL(new CLLNode(0));
		cll.sortedInsertinCLL(new CLLNode(10));
		cll.sortedInsertinCLL(new CLLNode(20));
		cll.sortedInsertinCLL(new CLLNode(3));
		cll.sortedInsertinCLL(new CLLNode(9));
		cll.printCircularLinkedList();
		
		//cll.headNode=new CLLNode(0);
		//cll.headNode.setNext(cll.headNode);
		/*cll.insertAtFirstCLL(cll.headNode, new CLLNode(1));
		cll.insertAtFirstCLL(cll.headNode, new CLLNode(2));
		cll.insertAtFirstCLL(cll.headNode, new CLLNode(3));
		cll.insertAtFirstCLL(cll.headNode, new CLLNode(4));
		*/
		//System.out.println("Length of CLL: "+cll.CLLLength(cll.headNode));
		//cll.spiltCircularTwoHalves();
		//cll.printList(cll.headNode);
		
		

	}

}
