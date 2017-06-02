package org.nithish.linkedlist;

/**
 * This class makes SLL circular and find number of nodes in Circular Linked
 * List
 * 
 * @author Nithish
 *
 */
public class SingleLinkedList_Circular {

	Node head;
	// Nodes to make SLL circular
	Node circularPoint1;
	Node circularPoint2;
	// Pointers to be used
	Node slowPointer;
	Node fastPointer;

	public void insert(int data) {
		Node newNode = new Node(data);
		newNode.setNextNode(head);
		head = newNode;
		// Here we are making SLL circular so I kept track of two Nodes I am
		// adding to make it circular
		// Here I know I am adding 33 & 66
		if (data == 33) {
			circularPoint1 = newNode;
		}
		if (data == 66) {
			circularPoint2 = newNode;
		}
	}

	public void makeSLLCircular() {
		circularPoint2.setNextNode(circularPoint1);
		System.out.println("We made SLL Circular");
	}

	public void isCircularOrNot() {
		slowPointer = head;
		fastPointer = head;
		// At start Slow==Fast and we have to make checks to skip NPE
		while ((slowPointer != fastPointer || slowPointer == head)
				&& fastPointer.getNextNode() != null
				&& fastPointer.getNextNode().getNextNode() != null) {
			slowPointer = slowPointer.getNextNode();
			fastPointer = fastPointer.getNextNode().getNextNode();
		}

		// we will exit above while loop when we have detected LinkedList is
		// circular

		/*
		 * make one of the pointer point to first, and let other pointer
		 * continue to point to same node. Than make both pointers step over
		 * LinkedList by 1 Node, they will meet at intersection point.
		 */
		slowPointer = head;
		int noOFNonLoopNodes = 0;
		while (slowPointer != fastPointer) {
			slowPointer = slowPointer.getNextNode(); // step over LinkedList by
														// 1 Node.
			fastPointer = fastPointer.getNextNode(); // step over LinkedList by
														// 1 Node.
			noOFNonLoopNodes++;
		}
		System.out.println("No of Nodes in Non Circular Loop: "
				+ noOFNonLoopNodes);
		/*
         *Make  slow pointer step over LinkedList by 1 Node.
         *& Make  slow pointer step over LinkedList by 2 Node.
         *They both will meet after certain number of iterations giving length of loop.
         */
		boolean pointersJustMet = true;
		int noOFLoopNodes = 0;
		while (slowPointer != fastPointer || pointersJustMet) {
			slowPointer = slowPointer.getNextNode(); // step over LinkedList by
			// 1 Node.
			fastPointer = fastPointer.getNextNode().getNextNode(); // step over
																	// LinkedList
																	// by 2
																	// Nodes.
			noOFLoopNodes++;
			pointersJustMet=false;
		}
		System.out.println("No of Nodes in Circular Loop: " + noOFLoopNodes);
		System.out.println("Total No of Elements in Circular Linked List: "
				+ (noOFNonLoopNodes + noOFLoopNodes));

	}

	/**
	 * Display LinkedList
	 */
	public void displayLinkedList() {
		Node tempDisplay = head;
		int displayLimiterCtr = 0; // as our LinkedList is circular it will keep
									// on displaying nodes till infinity...
									// so this variable will help us in limiting
									// the display to specific count.
		System.out.print("Displaying LinkedList [first--->last]: ");
		while (tempDisplay != null) {
			System.out.println(tempDisplay.getData());
			tempDisplay = tempDisplay.getNextNode();
			if (++displayLimiterCtr >= 12) // stops displaying after 12 Nodes.
				break;
		}
		System.out.println();
	}

	public static void main(String[] main) {
		SingleLinkedList_Circular sll_c1 = new SingleLinkedList_Circular();
		sll_c1.insert(66);
		sll_c1.insert(55);
		sll_c1.insert(44);
		sll_c1.insert(33);
		sll_c1.insert(22);
		sll_c1.insert(11);
		sll_c1.displayLinkedList();
		sll_c1.makeSLLCircular();
		sll_c1.displayLinkedList();
		sll_c1.isCircularOrNot();
	}

}
