package org.nithish.linkedlist;

public class CLLOperations {
	public CLLNode headNode;

	/**
	 * Printing the length of CircularLinkedList
	 * 
	 * @param headNode
	 * @return
	 */
	public int CLLLength(CLLNode headNode) {
		int length = 0;
		CLLNode current = headNode;
		while (current != null) {
			length++;
			current = current.getNext();
			if (current == headNode) {
				break;
			}
		}
		return length;
	}

	/**
	 * Printing the CircularLinkedList
	 * 
	 * @param headNode
	 */
	public void printCircularLinkedList() {
		CLLNode current = headNode;
		while (current != null) {
			System.out.print(current.getData() + "--->");
			current = current.getNext();
			if (current == headNode) {
				return;
			}
		}
		System.out.println(current.getData());
	}

	/**
	 * Insert at end of CircularLinkedList
	 * 
	 * @param headNode
	 * @param nodeToInsert
	 */
	public void insertAtEndCLL(CLLNode headNode, CLLNode nodeToInsert) {
		CLLNode current = headNode;
		if (headNode == null) {
			headNode = nodeToInsert;
			headNode.setNext(headNode);
			return;
		}
		while (current.getNext() != headNode) {
			current = current.getNext();
		}
		nodeToInsert.setNext(headNode);
		current.setNext(nodeToInsert);
	}

	/**
	 * Insert at first of CircularLinkedList
	 * 
	 * @param headNode
	 * @param nodeToInsert
	 */
	public void insertAtFirstCLL(CLLNode headNode, CLLNode nodeToInsert) {
		CLLNode current = headNode;
		if (headNode == null) {
			headNode = nodeToInsert;
			headNode.setNext(headNode);
			return;
		}
		while (current.getNext() != headNode) {
			current = current.getNext();
		}
		nodeToInsert.setNext(headNode);
		current.setNext(nodeToInsert);
		headNode = nodeToInsert;
	}

	/**
	 * Delete at End of CircularLinkedList
	 * 
	 * @param headNode
	 */
	public void deleteLastNodeCLL(CLLNode headNode) {
		CLLNode current = headNode;
		CLLNode previous = null;
		if (headNode == null) {
			System.out.println("CircularLinkedList is Empty");
			return;
		}
		while (current.getNext() != headNode) {
			previous = current;
			current = current.getNext();
		}
		previous.setNext(headNode);
		current = null;
	}

	/**
	 * Delete at First of CircularLinkedList
	 * 
	 * @param headNode
	 */
	public void deleteFirstNodeCLL(CLLNode headNode) {
		CLLNode current = headNode;
		CLLNode temp = headNode;
		if (headNode == null) {
			System.out.println("CircularLinkedList is Empty");
			return;
		}
		while (current.getNext() != headNode) {
			current = current.getNext();
		}
		current.setNext(headNode.getNext());
		headNode = headNode.getNext();
		temp = null;
	}

	/**
	 * This method splits linked list into two halves
	 * 
	 */
	public void spiltCircularTwoHalves() {
		CLLNode head1 = null;
		CLLNode head2 = null;
		CLLNode fast_ptr = headNode;
		CLLNode slow_ptr = headNode;
		if (headNode == null) {
			return;
		}
		while (fast_ptr.getNext() != headNode
				&& fast_ptr.getNext().getNext() != headNode) {
			slow_ptr = slow_ptr.getNext();
			fast_ptr = fast_ptr.getNext().getNext();
		}
		// if the list is even
		if (fast_ptr.getNext().getNext() == headNode) {
			fast_ptr = fast_ptr.getNext();
		}
		if (headNode.getNext() != headNode) {
			head2 = slow_ptr.getNext();
		}
		fast_ptr.setNext(head2);
		slow_ptr.setNext(headNode);
		head1 = headNode;
	}

	/* Function to print nodes in a given Circular linked list */
	public void printList(CLLNode node) {
		CLLNode temp = node;
		if (node != null) {
			do {
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			} while (temp != node);
		}
	}

	/**
	 * Sorted Insertion in CLL
	 * @param nodeToInsert
	 */
	public void sortedInsertinCLL(CLLNode nodeToInsert) {
		CLLNode prev = null;
		if (headNode == null) {
			headNode = nodeToInsert;
			headNode.setNext(headNode);
			return;
		}
		CLLNode currentNode = headNode;
		if (nodeToInsert.getData() < headNode.getData()) {
			nodeToInsert.setNext(headNode);
			headNode = nodeToInsert;
			return;
		}
		// Incoming node is greater or equal to head Node
		else {
			while (currentNode != null) {
				if (nodeToInsert.getData() < currentNode.getData()) {
					prev.setNext(nodeToInsert);
					nodeToInsert.setNext(currentNode);
					return;
				}
				prev = currentNode;
				if (currentNode.getNext() != headNode) {
					currentNode = currentNode.getNext();
				} else {
					currentNode = null;
				}
			}
			prev.setNext(nodeToInsert);
			nodeToInsert.setNext(headNode);
			return;
		}
	}

}
