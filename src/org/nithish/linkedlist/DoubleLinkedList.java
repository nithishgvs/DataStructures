package org.nithish.linkedlist;

public class DoubleLinkedList {
	private DoubleLinkedNode first;
	private DoubleLinkedNode last;

	/**
	 * This method inserts Node at First node of a Double LinkedList
	 * 
	 * @param data
	 */
	public void insertFirst(int data) {
		DoubleLinkedNode newNode = new DoubleLinkedNode(data);
		if (this.first == null) {
			this.last = newNode;
		} else {
			first.setPreviousNode(newNode);
		}
		newNode.setNextNode(first);
		this.first = newNode;
	}

	/**
	 * This method deletes first node of a Double LinkedList
	 */
	public DoubleLinkedNode deleteFirst() {
		if (this.first == null) {
			throw new LinkedListEmptyException("Linked List is Empty");
		}
		DoubleLinkedNode tempNode = first;
		if (first.getNextNode() == null) {
			last = null;
		} else {
			first.getNextNode().setPreviousNode(null);
		}
		first = this.first.getNextNode();
		return tempNode;
	}

	/**
	 * Display Linked list Nodes from first to last
	 */
	public void displayForward() {
		System.out.println("Displaying LinkedList First----->Last");
		DoubleLinkedNode tempDisplay = first;
		while (tempDisplay != null) {
			tempDisplay.displayNode();
			tempDisplay = tempDisplay.getNextNode();
		}
		System.out.println("");
	}

	/**
	 * Display Linked list Nodes from last to first
	 */
	public void displayReverse() {
		System.out.println("Displaying LinkedList Last----->First");
		DoubleLinkedNode tempDisplay = last;
		while (tempDisplay != null) {
			tempDisplay.displayNode();
			tempDisplay = tempDisplay.getPreviousNode();
		}
		System.out.println("");
	}

	public void insertSorted(int data) {
		DoubleLinkedNode newNode = new DoubleLinkedNode(data);
		if (first == null) {
			first = last = newNode;
			return;
		}
		DoubleLinkedNode current = first;
		// New Node can be placed at first
		if (current.getData() >= newNode.getData()) {
			newNode.setNextNode(current);
			current.setPreviousNode(newNode);
			first = newNode;
			return;
		}
		// find the position which is other than first and insert the Node
		while (true) {
			if (newNode.getData() > current.getData()) {
				// if New Node is the biggest and inserted at the end
				if (current.getNextNode() == null) {
					current.setNextNode(newNode);
					newNode.setPreviousNode(current);
					last = newNode;
					return;
				}
				current = current.getNextNode();
			} else {
				current = current.getPreviousNode();
				newNode.setPreviousNode(current);
				newNode.setNextNode(current.getNextNode());
				current.getNextNode().setPreviousNode(newNode);
				current.setNextNode(newNode);
				return;
			}
		}
	}

	/**
	 * Method deletes specific Node from DoublyLinkedList.
	 */
	public void deleteSpecificNode(int deleteKey) {
		if (first == null) {
			throw new LinkedListEmptyException("No elements in LinkedList");
		}
		DoubleLinkedNode current = first;
		while (current.getData() != deleteKey) {
			if (current.getNextNode() == null) {
				System.out.println("Node with data=" + deleteKey
						+ " wasn't found for deletion.");
				return;
			}
			current = current.getNextNode();
		}
		if (current == first) {
			first = current.getNextNode();
			current.setPreviousNode(null);
			return;
		} else if (current == last) {
			last = current.getPreviousNode();
			last.setNextNode(null);
			return;
		} else {
			current.getPreviousNode().setNextNode(current.getNextNode());
			current.getNextNode().setPreviousNode(current.getPreviousNode());
			current = null;
			return;
		}

	}

	/**
	 * This method reverses a double linked list
	 */
	public void reverseDoubleLinkedList() {
		DoubleLinkedNode current = first;
		DoubleLinkedNode prev = null;
		while (current != null ) {
			DoubleLinkedNode temp = current.getNextNode();
			current.setNextNode(prev);
			current.setPreviousNode(temp);
			prev=current;
			current = temp;
		}
		first = prev;

	}

}
