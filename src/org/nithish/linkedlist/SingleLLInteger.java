package org.nithish.linkedlist;

import java.util.HashSet;
import java.util.Stack;

public class SingleLLInteger {

	Node head;
	Node second_half = null;

	public Node getHead() {
		return this.head;
	}

	/**
	 * This method inserts Integer Data in a sorted LinkedList
	 * 
	 * @param data
	 */
	public void insertNodeInSortedLinkedList(Integer data) {
		Node newNode = new Node(data);
		if (head == null) {// Empty List
			head = newNode;
			return;
		}
		// NewNode(10<20(head) order 10->20)
		if (newNode.getData() <= head.getData()) {
			newNode.setNextNode(head);
			head = newNode;
			return;
		}
		Node current = head;
		Node previous = null;

		while (current != null) {
			if (current.getData() < newNode.getData()) {
				if (current.getNextNode() == null) {
					current.setNextNode(newNode);
					return;
				}
				previous = current;
				current = current.getNextNode();
			} else {
				previous.setNextNode(newNode);
				newNode.setNextNode(current);
				return;
			}

		}
	}

	/**
	 * This method deletes specific Node of a Linked List
	 * 
	 * @param deleteKey
	 * @return
	 */
	public Node deleteSpecificNode(int deleteKey) {
		// if list is empty
		if (head == null) {
			throw new LinkedListEmptyException("Empty Linked List");
		}
		// if deleteKey is head
		if (head.getData() == deleteKey) {
			Node tempNode = head;
			head = head.getNextNode();
			return tempNode;
		}

		// if deleteKey is in some other position other than head
		Node current = head;
		Node previous = null;
		while (current != null) {
			if (current.getData() == deleteKey) {
				previous.setNextNode(current.getNextNode());
				return current;
			} else {
				if (current.getNextNode() == null) {
					return null;
				}
			}
			previous = current;
			current = current.getNextNode();
		}
		return null;
	}

	public void reverseLinkedList() {
		Node current = head;
		Node previous = null;
		Node nextNode = head;
		while (nextNode != null) {
			nextNode = nextNode.getNextNode();
			current.setNextNode(previous);
			previous = current;
			current = nextNode;
		}
		head = previous;

	}

	/**
	 * Display Sorted Singly LinkedList
	 */
	public void displayLinkedList() {
		System.out.print("Displaying LinkedList (first--->last): ");
		Node tempDisplay = head; // start at the beginning of linkedList
		// Executes until we don't find end of list
		while (tempDisplay != null) {
			System.out.println(tempDisplay.toString());
			tempDisplay = tempDisplay.getNextNode(); // move to next Node
		}
		System.out.println();

	}

	/**
	 * This method returns the length of a Linked List
	 * 
	 * @param head
	 * @return
	 */
	public int lengthOFLL(Node head) {
		int length = 0;
		Node current = head;
		if (head == null) {
			System.out.println("Linked List is Empty");
		}
		while (current != null) {
			length++;
			current = current.getNextNode();
		}
		return length;
	}

	/**
	 * This method gives Nth node of a Linked List
	 * 
	 * @param index
	 * @return
	 */
	public int getNthNodeofLinkedList(int index) {
		int key = 0;
		Node current = head;
		if (head == null) {
			return 0;
		}
		if (lengthOFLL(head) < index) {
			System.out
					.println("Length of LL is less than the index you provided");
			return 0;
		}
		while (key < index) {
			current = current.getNextNode();
			key++;
		}
		System.out.println("Node at " + index + " position is :"
				+ current.getData());
		return current.getData();
	}

	/**
	 * This method prints middle of the Linked list
	 */
	public void getMiddleOfLinkedList() {
		Node slow_ptr = head;
		Node fast_ptr = head;
		if (head != null) {
			while (fast_ptr != null && fast_ptr.getNextNode() != null) {
				fast_ptr = fast_ptr.getNextNode().getNextNode();
				slow_ptr = slow_ptr.getNextNode();
			}
			System.out.println("Middle Node is: " + slow_ptr.getData());
		}

	}

	/**
	 * This method returns Nth node from the End
	 * 
	 * @param index
	 */
	public void printNthElementFromLastMethod1(int index) {
		int length = lengthOFLL(head);
		Node current = head;
		for (int i = 1; i < length - index + 1; i++) {
			current = current.getNextNode();
		}
		System.out.println(index + "th Node from then End is: "
				+ current.getData());
	}

	/**
	 * This method returns Nth node from the End
	 * 
	 * @param index
	 */
	public void printNthElementFromLastMethod2(int index) {
		Node reference_ptr = head;
		Node main_ptr = head;
		int iterator = 0;
		if (head != null) {
			while (iterator < index) {
				reference_ptr = reference_ptr.getNextNode();
				iterator++;
			}
			while (reference_ptr != null) {
				reference_ptr = reference_ptr.getNextNode();
				main_ptr = main_ptr.getNextNode();

			}
			System.out.println(index + "th Node from then End is: "
					+ main_ptr.getData());
		}

	}

	/**
	 * Returns number of times a particular data occured in a Linked List
	 * 
	 * @param data
	 * @return
	 */
	public int countTimesParticularDataOccured(int dataKey) {
		if (head == null) {
			return 0;
		}
		Node current = head;
		int count = 0;
		while (current != null) {
			if (current.getData() == dataKey) {
				count++;
			}
			current = current.getNextNode();
		}
		System.out.println("Number of times " + dataKey
				+ " occured in a Linked List: " + count);
		return count;
	}

	/**
	 * This method reverses a linked list
	 */
	public void reverseLinkedListRecursively(Node current, Node previous) {
		if (current.getNextNode() == null) {
			head = current;
			current.setNextNode(previous);
			return;
		}
		Node temp = current.getNextNode();
		current.setNextNode(previous);
		reverseLinkedListRecursively(temp, current);
		System.out.println("After reversing the Linked List");
		displayLinkedList();
	}

	/**
	 * Method1 to check if number is palindrome
	 * 
	 * @return
	 */
	public boolean isPalindromeMethod1() {
		Node fast_ptr = head;
		Node slow_ptr = head;
		Node mid_node = null;
		Node prev_of_slow_ptr = null;
		boolean res = true;
		if (head != null & head.getNextNode() != null) {
			// Here we find the middle of the list
			while (fast_ptr != null && fast_ptr.getNextNode() != null) {
				prev_of_slow_ptr = slow_ptr;
				slow_ptr = slow_ptr.getNextNode();
				fast_ptr = fast_ptr.getNextNode().getNextNode();
			}
			// This is case for odd elements fastpointer will not be null but
			// next of fast pointer will be null.Hence we save the mid node in
			// some Node(mid Node) and make slow_ptr point o next node exact
			// next half
			if (fast_ptr != null) {
				mid_node = slow_ptr;
				slow_ptr = slow_ptr.getNextNode();
			}
			// Now second_half points to slo_ptr which is half of Linked List.We
			// will reverse it
			second_half = slow_ptr;
			second_half = reverseLL(second_half);
			// Terminate the first half
			prev_of_slow_ptr.setNextNode(null);
			res = compareLists(head, second_half);
			// again reverse second half
			reverseLL(second_half);
			// Combining 2 Linked lists
			// If mid node present
			if (mid_node != null) {
				prev_of_slow_ptr.setNextNode(mid_node);
				mid_node.setNextNode(second_half);
			}
			// If mid node not present i.e. Even List
			else {
				prev_of_slow_ptr.setNextNode(second_half);
			}
		}
		return res;
	}

	/**
	 * This method compares two Linked Lists
	 * 
	 * @param head
	 * @param second_half
	 * @return
	 */
	private boolean compareLists(Node head, Node second_half) {
		Node temp1 = head;
		Node temp2 = second_half;
		while (temp1 != null && temp2 != null) {
			if (temp1.getData() == temp2.getData()) {
				temp1 = temp1.getNextNode();
				temp2 = temp2.getNextNode();
			} else {
				return false;
			}
		}
		if (temp1 == null && temp2 == null) {
			return true;
		}
		/*
		 * Will reach here when one is NULL and other is not
		 */
		return false;
	}

	/**
	 * This method reverses a Linked List
	 * 
	 * @param second_half
	 */
	private Node reverseLL(Node second_half) {
		Node prev = null;
		Node current = second_half;
		Node next;
		while (current != null) {
			next = current.getNextNode();
			current.setNextNode(prev);
			prev = current;
			current = next;
		}
		second_half = prev;
		return second_half;
	}

	/**
	 * Method1 to check if number is palindrome
	 * 
	 * @return
	 */
	public boolean isPalindromeMethod2() {
		Node current = head;
		// Count no of nodes matched
		int i = 0;
		int size = lengthOFLL(head);
		Stack<Integer> stack = new Stack<Integer>();

		// Copy all elements on to a Stack LIFO
		while (current != null) {
			stack.push(current.getData());
			current = current.getNextNode();
		}
		current = head;
		while (current != null) {
			if (stack.pop().equals(current.getData())) {
				current = current.getNextNode();
				i++;
			} else {
				return false;
			}
		}
		// If all nodes are matched return true
		if (i == size) {
			return true;
		}
		return false;

	}

	/**
	 * This method prints LL recursively from last to first
	 * 
	 * @param head
	 */
	public void printLLReverselyAndRecursively(Node head) {
		if (head == null) {
			return;
		}
		printLLReverselyAndRecursively(head.getNextNode());
		System.out.println("Data: " + head.getData());
	}

	/**
	 * This method removes duplicates from Sorted LL
	 */
	public void removeDuplicatesSortedLL() {
		Node current = head;
		Node next = null;
		while (current != null) {
			next = current.getNextNode();
			if (current.getData() == next.getData()) {
				current.setNextNode(next.getNextNode());
			}
			current = current.getNextNode();
		}
	}

	/**
	 * This method removes duplicates from UnSorted LL
	 */
	public void removeDuplicatesUnsortedLLMethod1() {
		Node current = head;
		Node prev = null;
		Node next = null;
		while (current != null && current.getNextNode() != null) {
			next = current.getNextNode();
			prev = current;
			while (next != null) {
				if (current.getData() == next.getData()) {
					prev.setNextNode(next.getNextNode());
				}
				prev = next;
				next = next.getNextNode();
			}
			current = current.getNextNode();
		}

	}

	/**
	 * Move last element to front of a given Linked List
	 */
	public void moveLastToFrontSLL() {
		Node last = head;
		Node second_last = null;
		while (last.getNextNode() != null) {
			second_last = last;
			last = last.getNextNode();
		}
		second_last.setNextNode(null);
		last.setNextNode(head);
		head = last;
	}

	/**
	 * Pairwise Swap Elements of a linked list
	 */
	public void pairwiseSwapIterativeApproach() {
		Node current = head;
		while (current != null && current.getNextNode() != null) {
			int data = current.getData();
			current.setData(current.getNextNode().getData());
			current.getNextNode().setData(data);
			current = current.getNextNode().getNextNode();
		}
		displayLinkedList();
	}

	/**
	 * Pairwise Swap Elements of a linked list
	 */
	public void pairwiseSwapRecursiveApproach(Node head) {
		Node current = head;
		if (current != null && current.getNextNode() != null) {
			head = current.getNextNode().getNextNode();
			swap(current, current.getNextNode());
			pairwiseSwapRecursiveApproach(head);
		}
	}

	private void swap(Node node1, Node node2) {
		int data = node1.getData();
		node1.setData(node2.getData());
		node2.setData(data);
	}

	/**
	 * Delete alternate nodes of a Linked List
	 */
	public void deleteAlternateNodesSLLIterativeApproach() {
		Node current = head;
		while (current != null && current.getNextNode() != null) {
			Node temp = current.getNextNode().getNextNode();
			current.setNextNode(current.getNextNode().getNextNode());
			current = temp;
		}
		displayLinkedList();
	}

	/**
	 * Delete alternate nodes of a Linked List
	 */
	public void deleteAlternateNodesSLLRecursiveApproach(Node head) {
		Node current = head;
		if (current != null && current.getNextNode() != null) {
			Node temp = current.getNextNode().getNextNode();
			current.setNextNode(current.getNextNode().getNextNode());
			deleteAlternateNodesSLLRecursiveApproach(temp);
		}
		displayLinkedList();
	}

	/**
	 * Alternating split of a given Singly Linked List
	 */
	public void alternateSplitSLL() {
		Node current = head;
		Node current2 = null;
		Node head2 = null;
		while (current != null && current.getNextNode() != null) {
			Node temp = current.getNextNode().getNextNode();
			if (head2 == null) {
				head2 = current.getNextNode();
				head2.setNextNode(null);
				current2 = head2;
			} else if (current2 != null) {
				current2.setNextNode(current.getNextNode());
				current2.getNextNode().setNextNode(null);
				current2 = current2.getNextNode();
			}
			current.setNextNode(temp);
			current = temp;
		}
		displayLinkedList(head);
		displayLinkedList(head2);
	}

	/**
	 * Display Sorted Singly LinkedList
	 */
	public void displayLinkedList(Node head) {
		System.out.print("Displaying LinkedList (first--->last): ");
		Node tempDisplay = head; // start at the beginning of linkedList
		// Executes until we don't find end of list
		while (tempDisplay != null) {
			System.out.println(tempDisplay.toString());
			tempDisplay = tempDisplay.getNextNode(); // move to next Node
		}
		System.out.println();

	}

	/**
	 * Merge two sorted linked lists
	 */
	public Node sortedMergeUsingDummyNode(Node linkedList1, Node linkedList2) {
		// Set one dummy node
		Node dummy = new Node(0);
		// Set another Node(tailNode) pointing to dummy
		Node tailNode = dummy;

		while (linkedList1 != null || linkedList2 != null) {
			if (linkedList1 == null) {
				tailNode.setNextNode(linkedList2);
				break;
			} else if (linkedList2 == null) {
				tailNode.setNextNode(linkedList1);
				break;
			} else if (linkedList1.getData() < linkedList2.getData()) {
				tailNode.setNextNode(linkedList1);
				linkedList1 = linkedList1.getNextNode();

			} else {
				tailNode.setNextNode(linkedList2);
				linkedList2 = linkedList2.getNextNode();
			}
			tailNode = tailNode.getNextNode();
		}
		return dummy.getNextNode();

	}

	/**
	 * Merge two sorted linked lists
	 * 
	 * Keep practicing this one often
	 */
	public Node MergeListsRecursively(Node list1, Node list2) {
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		}

		if (list1.getData() < list2.getData()) {
			list1.setNextNode(MergeListsRecursively(list1.getNextNode(), list2));
			return list1;

		} else {
			list2.setNextNode(MergeListsRecursively(list2.getNextNode(), list1));
			return list2;
		}
	}

	/**
	 * Identical Linked Lists check using Iterative approach
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public boolean identicalLinkedListsIterative(Node list1, Node list2) {
		boolean returnvalue = false;
		while (list1 != null && list2 != null) {
			if (list1.getData() == list2.getData()) {
				list1 = list1.getNextNode();
				list2 = list2.getNextNode();
				returnvalue = true;
			} else {
				return returnvalue = false;
			}
		}
		return returnvalue;

	}

	/**
	 * Identical Linked Lists check using Iterative Recursion
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public boolean identicalLinkedListsRecursion(Node list1, Node list2) {
		boolean returnvalue = false;
		if (list1 != null && list2 != null) {
			if (list1.getData() == list2.getData()) {
				list1 = list1.getNextNode();
				list2 = list2.getNextNode();
				returnvalue = true;
				return returnvalue
						&& identicalLinkedListsRecursion(list1, list2);
			}
		} else if (list1 == null && list2 == null) {
			return true;
		}
		return returnvalue;
	}

	/**
	 * Alternating split of a given Singly Linked List
	 * 
	 * @param list
	 */
	public void alternateSplitSingleLinkedList(Node list) {
		int count = 1;
		Node head1 = null;
		Node head2 = null;
		Node dummy1 = null;
		Node dummy2 = null;
		while (list != null) {
			if (count % 2 != 0) {
				if (head1 == null) {
					head1 = list;
					dummy1 = head1;
				} else {
					dummy1.setNextNode(new Node(list.getData()));
					dummy1 = dummy1.getNextNode();
				}

			} else {
				if (head2 == null) {
					head2 = list;
					dummy2 = head2;
				} else {
					dummy2.setNextNode(new Node(list.getData()));
					dummy2 = dummy2.getNextNode();
				}

			}
			list = list.getNextNode();
			count++;
		}
		displayLinkedList(head1);
		displayLinkedList(head2);
	}

	/**
	 * Reverse a Linked List in groups of given size
	 * 
	 * @param size
	 */
	public Node reverseLLIngivenSizeGroups(Node head, int size) {
		Node prevNode = null;
		Node current = head;
		Node nextNode = head;
		int count = 0;
		while (current != null && count < size) {
			nextNode = current.getNextNode();
			current.setNextNode(prevNode);
			prevNode = current;
			current = nextNode;
			count++;

		}
		if (nextNode != null) {
			head.setNextNode(reverseLLIngivenSizeGroups(nextNode, size));
		}
		return prevNode;
	}

	/**
	 * Segregate even and odd nodes in a Linked List
	 */
	public void evenOddSeggregationofLL() {
		Node current = head;
		Node oddHead = null;
		Node evenHead = null;
		Node oddCurr = null;
		Node evenCurr = null;
		while (current != null) {
			if (current.getData() % 2 != 0) {
				if (oddHead == null) {
					oddHead = current;
					oddCurr = current;

				} else {
					oddCurr.setNextNode(current);
					oddCurr = oddCurr.getNextNode();
				}

			} else {
				if (evenHead == null) {
					evenHead = current;
					evenCurr = current;
				} else {
					evenCurr.setNextNode(current);
					evenCurr = evenCurr.getNextNode();
				}
			}
			current = current.getNextNode();

		}
		evenCurr.setNextNode(oddHead);
		displayLinkedList(oddHead);
		displayLinkedList(evenHead);
		head = evenHead;
		displayLinkedList(head);
	}

	/**
	 * Detect and Remove Loop in a Linked List
	 */
	public boolean detectLoopinLL() {
		Node slow_ptr = head;
		Node fast_ptr = head;
		boolean hasLoop = false;
		while (fast_ptr != null && fast_ptr.getNextNode() != null) {
			if (slow_ptr == fast_ptr && slow_ptr != head) {
				hasLoop = true;
				break;
			}
			slow_ptr = slow_ptr.getNextNode();
			fast_ptr = fast_ptr.getNextNode().getNextNode();
		}
		return hasLoop;
	}

	/**
	 * Detect and Remove Loop in a Linked List
	 */
	public void detectandRemoveLoopinLL() {
		Node slow_ptr = head;
		Node fast_ptr = head;
		while (fast_ptr != null && fast_ptr.getNextNode() != null) {
			if (slow_ptr == fast_ptr && slow_ptr != head) {
				slow_ptr.setNextNode(null);
				displayLinkedList(head);
				break;
			}
			slow_ptr = slow_ptr.getNextNode();
			fast_ptr = fast_ptr.getNextNode().getNextNode();
		}
	}

	/**
	 * Add two numbers represented by linked lists
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	/**
	 * Input: First List: 5->6->3 // represents number 365 Second List: 8->4->2
	 * // represents number 248 Output Resultant list: 3->1->6 // represents
	 * number 613
	 */
	public Node addNumbersofSLL(Node list1, Node list2) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while (list1 != null) {
			sb.append(list1.getData());
			list1 = list1.getNextNode();
		}
		count = count + Integer.valueOf(sb.reverse().toString());
		System.out.println("After first list: " + count);
		sb.setLength(0);
		while (list2 != null) {
			sb.append(list2.getData());
			list2 = list2.getNextNode();
		}
		count = count + Integer.valueOf(sb.reverse().toString());
		System.out.println("After second list: " + count);
		Node head = null;
		Node current = null;
		while (count != 0) {
			int remainder = count % 10;
			Node newNode = new Node(remainder);
			if (head == null) {// Empty List
				head = newNode;
			} else {
				current.setNextNode(newNode);
			}
			current = newNode;
			count = count / 10;
		}
		displayLinkedList(head);
		return head;
	}

}
