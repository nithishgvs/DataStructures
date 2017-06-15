package org.nithish.trees;

import org.nithish.queue.Queue.QueueOverFlowException;
import org.nithish.queue.Queue.QueueUnderFlowException;
import org.nithish.stack.StackOverFlowException;
import org.nithish.stack.StackUnderFlowException;

public class PracticeTreeSetTest {

	public static void main(String[] args)
			throws QueueOverFlowException, QueueUnderFlowException, StackOverFlowException, StackUnderFlowException {
		PracticeTreesSet tree1 = new PracticeTreesSet();
		Node<Integer> root1=tree1.insert(null, new Node<Integer>(20));
		tree1.insert(root1, new Node<Integer>(10));
		tree1.insert(root1, new Node<Integer>(30));
		tree1.insert(root1, new Node<Integer>(11));
		tree1.insert(root1, new Node<Integer>(9));
		tree1.insert(root1, new Node<Integer>(25));
		tree1.insert(root1, new Node<Integer>(32));
		Node<Integer> node=tree1.mirrorTreeWithoutRecursion(root1);
		tree1.inOrderTraversal(node);
		String str=new String();
	}

}
