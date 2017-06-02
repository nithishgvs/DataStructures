package org.nithish.linkedlist;

import java.util.Stack;

public class SingleLinkedList<T> {

	public NodeSLL<T> head;

	public NodeSLL<T> getHead() {
		return this.head;
	}

	/**
	 * This method adds element as Head
	 * 
	 * @param data
	 */
	public void addAtStart(T data) {
		NodeSLL<T> newNode = new NodeSLL<T>(data);
		newNode.setNextNode(this.head);
		this.head = newNode;
	}

	/**
	 * This method deletes headNode adjusting pointers and returns head
	 * node(removes it and returns)
	 * 
	 * @return
	 */
	public NodeSLL<T> deleteAtStart() {
		NodeSLL<T> toDel = this.head;
		this.head = this.head.getNextNode();
		return toDel;
	}

	/**
	 * This method adds a node at end of a Linked List
	 * 
	 * @param data
	 */
	public void addAtLast(T data) {
		NodeSLL<T> newNode = new NodeSLL<T>(data);
		if (head == null) {
			head = newNode;
			return;
		}
		NodeSLL<T> current = this.head;
		while (current.getNextNode() != null) {
			current = current.getNextNode();
		}
		current.setNextNode(newNode);
	}

	/**
	 * This method returns head node(removes it and returns)
	 * 
	 * @return
	 * @throws Exception
	 */
	public NodeSLL<T> deleteAtLast() {
		if (head == null) {
			throw new LinkedListEmptyException("List is Empty");
		}
		if (head.getNextNode() == null) {// One Element present
			NodeSLL<T> tempNode = head;// Return the element via tempNode
			head.setNextNode(null);// Head Node is null
			return tempNode;
		}

		NodeSLL<T> current = this.head;
		NodeSLL<T> previous = null;
		while (current.getNextNode() != null) {
			previous = current;
			current = current.getNextNode();
		}
		previous.setNextNode(null);
		return current;
	}

	/**
	 * This method finds the data required and returns the node of it
	 * 
	 * @param data
	 * @return
	 */
	public NodeSLL<T> find(T data) {
		NodeSLL<T> current = this.head;
		while (current != null) {
			if (current.getData() == data) {
				return current;
			}
			current = current.getNextNode();
		}
		return null;
	}

	/**
	 * Returns length of a Linked List
	 * 
	 * @return
	 */
	public int length() {
		if (head == null) {
			return 0;
		}
		NodeSLL<T> current = this.head;
		int length = 0;
		while (current != null) {
			length++;
			current = current.getNextNode();
		}
		return length;
	}

	/**
	 * Check if list is empty
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return this.head == null;
	}

	/**
	 * Printing a Linked List
	 */
	public void printLinkedList() {
		NodeSLL<T> current = head;
		while (current != null) {
			System.out.println(current.toString());
			current = current.getNextNode();
		}
	}

	/**
	 * This method reverses a linked list
	 */
	public void reverseLinkedList() {
		NodeSLL<T> current = head;
		NodeSLL<T> temp = null;
		NodeSLL<T> next = null;
		while (current != null) {
			next = current.getNextNode();
			current.setNextNode(temp);
			temp = current;
			current = next;
		}
		head = temp;
		System.out.println("After reversing the Linked List");
		printLinkedList();
	}

	/**
	 * This method reverses a linked list
	 */
	public void reverseLinkedListRecursively(NodeSLL<T> current, NodeSLL<T> previous) {
		if (current.getNextNode() == null) {
			head = current;
			current.setNextNode(previous);
			return;
		}
		NodeSLL<T> temp = current.getNextNode();
		current.setNextNode(previous);
		reverseLinkedListRecursively(temp, current);
		System.out.println("After reversing the Linked List");
		printLinkedList();
	}

	// April 1st code
	/**
	 * Write a function to get Nth node in a Linked List
	 * 
	 * @param index
	 * @return
	 */
	public NodeSLL<T> getNthNodeSLL(int index) {
		if (head == null) {
			return null;
		}
		int count = 1;
		NodeSLL<T> current = head;
		while (count != index) {
			current = current.getNextNode();
			count++;
		}
		return current;
	}

	/**
	 * No of Elements in SLL
	 * 
	 * @return
	 */
	public int lengthOfSLL() {
		if (head == null) {
			return 0;
		}
		int length = 0;
		NodeSLL<T> current = head;
		while (current != null) {
			current = current.getNextNode();
			length++;
		}
		return length;
	}

	/**
	 * Find the middle of a given linked list in Java
	 * 
	 * @return
	 */
	public NodeSLL<T> getMiddleofSLL() {
		if (head == null) {
			return null;
		}
		int length = lengthOfSLL();
		int middle = length / 2 + length % 2;
		int temp = 1;
		NodeSLL<T> current = head;
		while (temp != middle) {
			current = current.getNextNode();
			temp++;
		}
		return current;
	}

	/**
	 * Find n’th node from the end of a Linked List
	 * 
	 * @param n
	 * @return
	 */
	public NodeSLL<T> getNthFromEndSLL(int n) {
		if (head == null) {
			return null;
		}
		NodeSLL<T> current = head;
		int length = lengthOfSLL();
		// length-n+1 from first=nth element from the end
		int endTarget = length - n + 1;
		int temp = 1;
		while (temp != endTarget) {
			current = current.getNextNode();
			temp++;
		}
		return current;
	}

	/**
	 * Write a function that counts the number of times a given int occurs in a
	 * Linked List
	 * 
	 * @param val
	 * @return
	 */
	public int givenintOccurence(int val) {
		int count = 0;
		NodeSLL<T> current = head;
		while (current != null) {
			if ((int) current.getData() == val) {
				count++;
			}
			current = current.getNextNode();
		}

		return count;
	}

	/**
	 * Write a function to reverse a linked list
	 * 
	 * @return
	 */
	public NodeSLL<T> reverseSLL() {
		if (head == null) {
			return null;
		}
		NodeSLL<T> current = head;
		NodeSLL<T> temp1 = null;
		NodeSLL<T> temp2 = null;

		while (current != null) {
			temp1 = current;
			current = current.getNextNode();
			temp1.setNextNode(temp2);
			temp2 = temp1;
		}
		head = temp1;
		printLinkedList();
		return temp1;
	}

	/**
	 * Write a program function to detect loop in a linked list
	 */
	public void detectLoopSLL(NodeSLL<T> head) {
		NodeSLL<T> oneHopPointer = head;
		NodeSLL<T> twoHopPointer = head;
		while (twoHopPointer.getNextNode() != null) {
			oneHopPointer = oneHopPointer.getNextNode();
			twoHopPointer = twoHopPointer.getNextNode().getNextNode();
			if (oneHopPointer == twoHopPointer) {
				System.out.println("Loop Detected");
				return;
			}
		}
		System.out.println("No Loop Found");
	}

	/**
	 * Function to check if a singly linked list is palindrome
	 */
	public void palindromeCheckStack() {
		Stack<String> stack = new Stack<String>();
		NodeSLL<T> current = head;
		while (current != null) {
			stack.push((String) current.getData());
			current = current.getNextNode();
		}
		NodeSLL<T> current2 = head;
		while (current2 != null) {
			if (stack.pop() != current2.getData()) {
				System.out.println("Not a Palindrome");
				return;
			}
			System.out.println(current2.getData());
			current2 = current2.getNextNode();
		}
		System.out.println("Given Input is a Palindrome");

	}

	/**
	 * Insert in sorted way
	 * 
	 * @param data
	 */
	public void insertSortedLinkedList(T data) {
		if (head == null) {
			NodeSLL<T> newNode = new NodeSLL<T>(data);
			this.head = newNode;
			return;
		}
		if ((int) data < (int) head.getData()) {
			NodeSLL<T> newNode = new NodeSLL<T>(data);
			newNode.setNextNode(head);
			this.head = newNode;
			return;
		}
		NodeSLL<T> current = head;
		NodeSLL<T> prev = null;
		while (current != null && (int) data > (int) current.getData()) {
			prev = current;
			current = current.getNextNode();
		}
		NodeSLL<T> newNode = new NodeSLL<T>(data);
		prev.setNextNode(newNode);
		newNode.setNextNode(current);
	}

	/**
	 * Write a recursive function to print reverse of a Linked List
	 */
	public void printSLLRecursive(NodeSLL<T> head) {
		if (head == null) {
			return;
		}
		if (head.getNextNode() != null) {
			printSLLRecursive(head.getNextNode());
		}
		System.out.print(head.getData() + "->");
	}

	public NodeSLL<T> deleteEvenNodes(NodeSLL<T> head) {
		NodeSLL<T> current = head;
		NodeSLL<T> tempHead = head;
		NodeSLL<T> prev = null;
		boolean flag = false;
		if ((int) current.getData() % 2 == 0 && current == head) {
			tempHead = current.getNextNode();
			current = tempHead;
		}
		while (current != null) {
			if ((int) current.getData() % 2 == 0) {
				if (prev != null) {
					prev.setNextNode(current.getNextNode());
					flag = true;
				}
			}
			if (!flag) {
				prev = current;
			}
			current = current.getNextNode();
            flag=false;
		}

		return tempHead;

	}

}
