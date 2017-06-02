package org.nithish.linkedlist;

public class DoublyLinkedListInsertDeleteAtFirstExample {

	public static void main(String[] args) {
		DoubleLinkedList linkedList = new DoubleLinkedList(); // creation of Linked List
        
        linkedList.insertFirst(14);
        linkedList.insertFirst(39);
        linkedList.insertSorted(50);
         
        linkedList.displayForward();
        //linkedList.deleteSpecificNode(59);
        //linkedList.displayReverse();
        linkedList.reverseDoubleLinkedList();
        System.out.println("After reversing");
        linkedList.displayForward();
        
	}

}
