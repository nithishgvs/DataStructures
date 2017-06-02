package org.nithish.trees;

import java.util.ArrayList;

import org.nithish.queue.Queue.QueueOverFlowException;
import org.nithish.queue.Queue.QueueUnderFlowException;
import org.nithish.stack.StackOverFlowException;
import org.nithish.stack.StackUnderFlowException;

public class PracticeTreeSetTest {

	public static void main(String[] args) throws QueueOverFlowException, QueueUnderFlowException, StackOverFlowException, StackUnderFlowException {
		PracticeTreesSet1 tree1=new PracticeTreesSet1();
		Node<Integer> root1=tree1.insert(null, new Node<>(25));
		tree1.insert(root1, new Node<>(12));
		tree1.insert(root1, new Node<>(27));
		//tree1.inorderTraversalIterative(root1);
		System.out.println("No of leaf nodes: "+tree1.printNoofLeafNodes(root1));
        //tree1.inOrderTraversal(root1);
        //System.out.println(tree1.maxHeightOfTree(root1));
        //tree1.inOrderTraversal(root1);
        //System.out.println(tree1.checkChildSumProperty(root1));
        //tree1.printBSTPathsRecursively(root1, new ArrayList<>());
        
        PracticeTreesSet1 tree2=new PracticeTreesSet1();
		Node<Integer> root2=tree2.insert(null, new Node<>(10));
		tree2.insert(root2, new Node<>(-10));
		tree2.insert(root2, new Node<>(8));
		tree2.insert(root2, new Node<>(6));
		tree2.insert(root2, new Node<>(9));
		tree2.insert(root2, new Node<>(30));
		tree2.insert(root2, new Node<>(25));
		tree2.insert(root2, new Node<>(28));
		tree2.insert(root2, new Node<>(60));
		tree2.insert(root2, new Node<>(78));
		//tree2.levelOrderTraversal(root2);
		//System.out.println("No of leaf nodes: "+tree1.printNoofLeafNodes(root2));
		//tree2.printBSTPathsRecursively(root2, new ArrayList<>());
		//System.out.println("LCA is: "+tree2.lowestCommonAncestor(root2, 8, 6).data);
		/*PracticeTreesSet1 tree3=new PracticeTreesSet1();
		Node<Integer> root3=tree2.insert(null, new Node<>(10));
		root3.setLeftChild(new Node<>(8));
		root3.setRightChild(new Node<>(2));
		root3.getLeftChild().setLeftChild(new Node<>(3));
		root3.getLeftChild().setRightChild(new Node<>(5));
		root3.getRightChild().setLeftChild(new Node<>(2));
		System.out.println(tree3.checkChildSumProperty(root3));*/
		
		
		PracticeTreesSet1 tree3=new PracticeTreesSet1();
		Node<Integer> root3=tree3.insertIterative(null, new Node<Integer>(52));
		tree3.insertIterative(root3, new Node<Integer>(33));
		tree3.insertIterative(root3, new Node<Integer>(25));
		tree3.insertIterative(root3, new Node<Integer>(12));
		tree3.insertIterative(root3, new Node<Integer>(27));
		tree3.insertIterative(root3, new Node<Integer>(39));
		tree3.insertIterative(root3, new Node<Integer>(34));
		tree3.insertIterative(root3, new Node<Integer>(48));
		tree3.insertIterative(root3, new Node<Integer>(65));
		tree3.insertIterative(root3, new Node<Integer>(60));
		tree3.insertIterative(root3, new Node<Integer>(78));
		tree3.insertIterative(root3, new Node<Integer>(72));
		tree3.insertIterative(root3, new Node<Integer>(90));
		System.out.println("Preorder Traversal");
		tree3.preorderTraversalIterative(root3);
	}

}
