package org.nithish.trees;

import org.nithish.queue.Queue.QueueOverFlowException;
import org.nithish.queue.Queue.QueueUnderFlowException;
import org.nithish.stack.StackOverFlowException;
import org.nithish.stack.StackUnderFlowException;

public class BSTreeOperationsTest {

	public static void main(String[] args) throws QueueOverFlowException, QueueUnderFlowException, StackOverFlowException, StackUnderFlowException {
		BSTreeOperations bstreeOperations = new BSTreeOperations();
		Node<Integer> head = bstreeOperations.insertIterative(null, new Node<Integer>(52));
		bstreeOperations.insertIterative(head, new Node<Integer>(33));
		bstreeOperations.insertIterative(head, new Node<Integer>(25));
		bstreeOperations.insertIterative(head, new Node<Integer>(12));
		bstreeOperations.insertIterative(head, new Node<Integer>(27));
		bstreeOperations.insertIterative(head, new Node<Integer>(39));
		bstreeOperations.insertIterative(head, new Node<Integer>(34));
		bstreeOperations.insertIterative(head, new Node<Integer>(48));
		bstreeOperations.insertIterative(head, new Node<Integer>(65));
		bstreeOperations.insertIterative(head, new Node<Integer>(60));
		bstreeOperations.insertIterative(head, new Node<Integer>(78));
		bstreeOperations.insertIterative(head, new Node<Integer>(72));
		bstreeOperations.insertIterative(head, new Node<Integer>(90));
		//bstreeOperations.inOrderTraversalIterative(head);
 
		
		Node<Integer> head2 = bstreeOperations.insertIterative(null, new Node<Integer>(52));
		head2.setLeftChild(new Node<Integer>(93));
		head2.setRightChild(new Node<Integer>(3));
		bstreeOperations.getKthSmallestElement(head,4);
		System.out.println(bstreeOperations.isBST(head2));
		

	}

}
