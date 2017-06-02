package org.nithish.trees;

import java.util.ArrayList;

import org.nithish.queue.Queue;
import org.nithish.queue.Queue.QueueOverFlowException;
import org.nithish.queue.Queue.QueueUnderFlowException;
import org.nithish.stack.Stack;
import org.nithish.stack.StackOverFlowException;
import org.nithish.stack.StackUnderFlowException;

public class BSTreeOperations {

	/**
	 * Recursive insertionn BST
	 * 
	 * @param root
	 * @param node
	 * @return
	 */
	public Node<Integer> insert(Node<Integer> root, Node<Integer> node) {
		if (root == null) {
			return node;
		}
		if (node.getData() < root.getData()) {
			root.setLeftChild(insert(root.getLeftChild(), node));
		} else if (node.getData() > root.getData()) {
			root.setRightChild(insert(root.getRightChild(), node));
		}
		return root;
	}

	public static void print(Node<Integer> node) {
		System.out.print(node.getData() + "->");
	}

	/**
	 * Depth first traversal
	 * 
	 * @param root
	 * @throws QueueOverFlowException
	 * @throws QueueUnderFlowException
	 */
	public void depthFirst(Node<Integer> root) throws QueueOverFlowException, QueueUnderFlowException {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new Queue<>(Node.class);
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			Node<Integer> node = queue.dequeue();
			print(node);
			if (node.getLeftChild() != null) {
				queue.enqueue(node.getLeftChild());
			}
			if (node.getRightChild() != null) {
				queue.enqueue(node.getRightChild());
			}
		}

	}

	public void preOrderTraversal(Node<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.println(root.getData());
		if (root.getLeftChild() != null) {
			preOrderTraversal(root.getLeftChild());
		}
		if (root.getRightChild() != null) {
			preOrderTraversal(root.getRightChild());
		}

	}

	public void postOrderTraversal(Node<Integer> root) {
		if (root == null) {
			return;
		}
		if (root.getLeftChild() != null) {
			postOrderTraversal(root.getLeftChild());
		}
		if (root.getRightChild() != null) {
			postOrderTraversal(root.getRightChild());
		}
		System.out.println(root.getData());
	}

	public void inOrderTraversal(Node<Integer> root) {
		if (root == null) {
			return;
		}
		if (root.getLeftChild() != null) {
			inOrderTraversal(root.getLeftChild());
		}
		System.out.println(root.getData());
		if (root.getRightChild() != null) {
			inOrderTraversal(root.getRightChild());
		}
	}

	/**
	 * Length of a BST
	 * 
	 * @param root
	 * @return
	 */
	public int lengthOfTree(Node<Integer> root) {
		if (root == null) {
			return 0;
		}
		int leftMax = 0;
		int rightMax = 0;
		Node<Integer> temp = root;

		while (root.getLeftChild() != null) {
			leftMax++;
			root = root.getLeftChild();
		}
		while (temp.getRightChild() != null) {
			rightMax++;
			temp = temp.getRightChild();
		}
		return Math.max(leftMax, rightMax);
	}

	/**
	 * Size of tree (total no of elements ) in a tree
	 * 
	 * @param root
	 * @return
	 */
	public int sizeOfTree(Node<Integer> root) {

		if (root == null) {
			return 0;
		}
		return sizeOfTree(root.getLeftChild()) + sizeOfTree(root.getRightChild()) + 1;
	}

	/*
	 * Iterative insertion in a binary search tree
	 */
	public Node<Integer> insertIterative(Node<Integer> root, Node<Integer> nodeToInsert) {
		if (root == null) {
			return nodeToInsert;
		}
		Node<Integer> parent = null;
		Node<Integer> current = root;
		while (current != null) {
			parent = current;
			if (current.getData() <= nodeToInsert.getData()) {
				current = current.getRightChild();
			} else {
				current = current.getLeftChild();
			}
		}
		if (parent.getData() <= nodeToInsert.getData()) {
			parent.setRightChild(nodeToInsert);
		} else {
			parent.setLeftChild(nodeToInsert);
		}
		return root;
	}

	/**
	 * PostOrder(left->right->root)
	 * 
	 * @param root
	 * @throws StackOverFlowException
	 * @throws StackUnderFlowException
	 */
	public void postOrderTraversalIterative(Node<Integer> root) throws StackOverFlowException, StackUnderFlowException {
		if (root == null) {
			return;
		}
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.push(root);
		while (!stack1.isEmpty()) {
			root = stack1.pop();
			stack2.push(root);
			if (root.getLeftChild() != null) {
				stack1.push(root.getLeftChild());
			}
			if (root.getRightChild() != null) {
				stack1.push(root.getRightChild());
			}
		}
		while (!stack2.isEmpty()) {
			root = stack2.pop();
			System.out.print(root.getData() + "->");
		}

	}

	/**
	 * Get minimum from a BST
	 * 
	 * @param root
	 * @return
	 */
	public Node<Integer> minValueBinarySearchTree(Node<Integer> root) {
		if (root == null) {
			return null;
		}
		Node<Integer> temp = root;
		while (temp.getLeftChild() != null) {
			temp = temp.getLeftChild();
		}
		return temp;
	}

	/**
	 * Check if a tree is BST
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBST(Node<Integer> root) {
		if (root == null) {
			return true;
		}
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBSTUtil(Node<Integer> root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		if (root.getData() <= minValue || root.getData() > maxValue) {
			return false;
		}
		return isBSTUtil(root.getLeftChild(), minValue, root.getData())
				&& isBSTUtil(root.getRightChild(), root.getData(), maxValue);
	}

	/**
	 * Inorder Successor in Binary Search Tree
	 * 
	 * @param root
	 * @return
	 */
	public Node<Integer> findInorderSuccessor(Node<Integer> root, Node<Integer> node) {
		if (root == null) {
			return null;
		}
		Node<Integer> successor = null;
		if (node.getRightChild() != null) {
			return minValueBinarySearchTree(node.getRightChild());
		}
		while (root != null) {
			if (node.getData() < root.getData()) {
				successor = root;
				root = root.getLeftChild();
			} else {
				root = root.getRightChild();
			}
		}
		return successor;
	}

	/**
	 * In order Traversal Iterative approach
	 * 
	 * @param root
	 * @throws StackOverFlowException
	 * @throws StackUnderFlowException
	 */
	public void inOrderTraversalIterative(Node<Integer> root) throws StackOverFlowException, StackUnderFlowException {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.getLeftChild();
			} else {
				if (stack.isEmpty()) {
					break;
				}
				root = stack.pop();
				System.out.println(root.getData());
				root = root.getRightChild();
			}
		}

	}

	/**
	 * Get Kth smallest element in a  Tree
	 * @param root
	 * @param K
	 * @return
	 * @throws StackOverFlowException
	 * @throws StackUnderFlowException
	 */
	public void getKthSmallestElement(Node<Integer> root, int K)
			throws StackOverFlowException, StackUnderFlowException {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		ArrayList<Integer> array=new ArrayList<>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.getLeftChild();
			} else {
				if (stack.isEmpty()) {
					break;
				}
				root = stack.pop();
				array.add(root.getData());
				root = root.getRightChild();
			}
		}
		System.out.println(K+"th Smallest Element is:"+array.get(K-1));

	}

}
