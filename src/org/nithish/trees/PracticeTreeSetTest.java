package org.nithish.trees;

import java.util.ArrayList;
import java.util.List;

import org.nithish.queue.Queue.QueueOverFlowException;
import org.nithish.queue.Queue.QueueUnderFlowException;
import org.nithish.stack.StackOverFlowException;
import org.nithish.stack.StackUnderFlowException;

public class PracticeTreeSetTest {

	public static void main(String[] args)
			throws QueueOverFlowException, QueueUnderFlowException, StackOverFlowException, StackUnderFlowException {
		PracticeTreesSet tree1 = new PracticeTreesSet();
		Node<Integer> root1 = tree1.insert(null, new Node<>(25));
		tree1.insert(root1, new Node<>(12));
		tree1.insert(root1, new Node<>(27));
		// tree1.inorderTraversalIterative(root1);
		System.out.println("No of leaf nodes: " + tree1.printNoofLeafNodes(root1));
		// tree1.inOrderTraversal(root1);
		// System.out.println(tree1.maxHeightOfTree(root1));
		// tree1.inOrderTraversal(root1);
		// System.out.println(tree1.checkChildSumProperty(root1));
		// tree1.printBSTPathsRecursively(root1, new ArrayList<>());

		PracticeTreesSet tree2 = new PracticeTreesSet();
		Node<Integer> root2 = tree2.insert(null, new Node<>(10));
		tree2.insert(root2, new Node<>(-10));
		tree2.insert(root2, new Node<>(8));
		tree2.insert(root2, new Node<>(6));
		tree2.insert(root2, new Node<>(9));
		tree2.insert(root2, new Node<>(30));
		tree2.insert(root2, new Node<>(25));
		tree2.insert(root2, new Node<>(28));
		tree2.insert(root2, new Node<>(60));
		tree2.insert(root2, new Node<>(78));

		PracticeTreesSet tree3 = new PracticeTreesSet();
		Node<Integer> root3 = tree3.insertIterative(null, new Node<Integer>(2));
		root3.setLeftChild(new Node<Integer>(3));
		root3.getLeftChild().setLeftChild(new Node<Integer>(4));
		root3.getLeftChild().setRightChild(new Node<Integer>(8));
		root3.setRightChild(new Node<Integer>(5));
		root3.getRightChild().setLeftChild(new Node<Integer>(6));
		root3.getRightChild().setRightChild(new Node<Integer>(-2));
		root3.getRightChild().getRightChild().setRightChild(new Node<Integer>(2));
		System.out.println("Preorder Traversal");
		tree3.preorderTraversalIterative(root3);
		System.out.println("#########");
		tree3.rootToLeafPaths(root3,new ArrayList());
		
	}

}
