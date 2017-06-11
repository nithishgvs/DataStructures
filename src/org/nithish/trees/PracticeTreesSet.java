package org.nithish.trees;

import java.util.ArrayList;
import java.util.List;

import org.nithish.queue.Queue;
import org.nithish.queue.Queue.QueueOverFlowException;
import org.nithish.queue.Queue.QueueUnderFlowException;
import org.nithish.stack.Stack;
import org.nithish.stack.StackOverFlowException;
import org.nithish.stack.StackUnderFlowException;

public class PracticeTreesSet {

	/**
	 * Size Of a Tree
	 * 
	 * @param root
	 * @return
	 */
	public int sizeOfTree(Node<Integer> root) {
		if (root == null) {
			return 0;
		}
		return 1 + sizeOfTree(root.getLeftChild()) + sizeOfTree(root.getRightChild());
	}

	/**
	 * Check if both Trees are Same
	 * 
	 * @param tree1
	 * @param tree2
	 * @return
	 */
	public boolean sameTrees(Node<Integer> tree1, Node<Integer> tree2) {
		if (tree1 == null && tree2 == null) {
			return true;
		}
		if (tree1 != null && tree2 != null) {
			return (tree1.getData() == tree2.getData()) && sameTrees(tree1.getLeftChild(), tree2.getLeftChild())
					&& sameTrees(tree1.getRightChild(), tree2.getRightChild());
		}
		return false;
	}

	/**
	 * Max Height or Depth of a Tree
	 * 
	 * @param root
	 * @return
	 */
	public int maxHeightOfTree(Node<Integer> root) {
		if (root == null) {
			return 0;
		}
		if (root.leftChild == null && root.rightChild == null) {
			return 0;
		}
		int leftMaxDepth = 1 + maxHeightOfTree(root.leftChild);
		int rightMaxDepth = 1 + maxHeightOfTree(root.rightChild);

		return Math.max(leftMaxDepth, rightMaxDepth);

	}

	/**
	 * Mirror for a Tree
	 * 
	 * @param root
	 */
	public void mirrorTree(Node<Integer> root) {
		if (root == null) {
			return;
		}
		mirrorTree(root.getLeftChild());
		mirrorTree(root.getRightChild());

		Node<Integer> temp = root.getLeftChild();
		root.setLeftChild(root.getRightChild());
		root.setRightChild(temp);
	}

	/**
	 * Print all Root to Leaf paths one Per line in a BST
	 * 
	 * @param root
	 * @param array
	 */
	public void printBSTPathsRecursively(Node<Integer> root, ArrayList<Integer> array) {
		if (root == null) {
			return;
		}
		array.add(root.getData());
		if (root.getLeftChild() == null && root.getRightChild() == null) {
			printArrayList(array);
			return;
		} else {
			printBSTPathsRecursively(root.getLeftChild(), new ArrayList<Integer>(array));
			printBSTPathsRecursively(root.getRightChild(), new ArrayList<Integer>(array));

		}
	}

	public void printArrayList(ArrayList<Integer> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + "->");
		}
		System.out.println("#####");
	}

	/**
	 * Returns Lowest Common Ancestor for two nodes
	 * 
	 * @param root
	 * @param x1
	 * @param x2
	 * @return
	 */
	public Node<Integer> lowestCommonAncestor(Node<Integer> root, int x1, int x2) {
		if (root.getData() > x1 && root.getData() > x2) {
			return lowestCommonAncestor(root.getLeftChild(), x1, x2);
		} else if (root.getData() < x1 && root.getData() < x2) {
			return lowestCommonAncestor(root.getRightChild(), x1, x2);
		} else {
			return root;
		}

	}

	/**
	 * Diameter of a Tree
	 * 
	 * @param root
	 * @return
	 */
	public int diamterOfBST(Node<Integer> root) {
		if (root == null) {
			return 0;
		}
		int lHeight = maxHeightOfTree(root.leftChild);
		int rHeight = maxHeightOfTree(root.rightChild);
		int lDiameter;
		int diameter = 2 + maxHeightOfTree(root.leftChild) + maxHeightOfTree(root.rightChild);
		return 0;
	}

	/**
	 * @throws QueueOverFlowException
	 * @throws QueueUnderFlowException
	 * 
	 */
	public void levelOrderTraversal(Node<Integer> root) throws QueueOverFlowException, QueueUnderFlowException {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new Queue<>(Node.class);
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			Node<Integer> elem = queue.dequeue();
			System.out.print(elem.data + "->");
			if (elem.getLeftChild() != null) {
				queue.enqueue(elem.getLeftChild());
			}
			if (elem.getRightChild() != null) {
				queue.enqueue(elem.getRightChild());
			}
		}
	}

	/**
	 * Print Number of leaf Nodes in a BST
	 * 
	 * @param root
	 * @return
	 */
	public int printNoofLeafNodes(Node<Integer> root) {
		if (root == null) {
			return 0;
		}
		if (root.leftChild == null && root.rightChild == null) {
			return 1;
		}
		return printNoofLeafNodes(root.leftChild) + printNoofLeafNodes(root.rightChild);

	}

	/**
	 * Check Child sum Property of Binary Tree(Not BST)
	 * 
	 * @param root
	 * @return
	 */
	public boolean checkChildSumProperty(Node<Integer> root) {

		if (root == null || root.getLeftChild() == null && root.getRightChild() == null) {
			return true;
		}
		int leftChildData = 0;
		int rightChildData = 0;
		if (root.getLeftChild() != null) {
			leftChildData = root.getLeftChild().getData();
		}
		if (root.getRightChild() != null) {
			rightChildData = root.getRightChild().getData();
		}

		if (root.getData() == (leftChildData + rightChildData)) {
			return true && checkChildSumProperty(root.getLeftChild()) && checkChildSumProperty(root.getRightChild());
		}
		return false;
	}

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
	 * Insert Elements Iteratively in BST
	 * 
	 * @param root
	 * @param node
	 * @return
	 */
	public Node<Integer> insertIterative(Node<Integer> root, Node<Integer> node) {
		if (root == null) {
			return node;
		}
		Node<Integer> current = root;
		Node<Integer> parent = null;
		while (current != null) {
			parent = current;
			if (current.data > node.data) {
				current = current.getLeftChild();
			} else {
				current = current.getRightChild();
			}
		}
		if (parent.getData() <= node.getData()) {
			parent.setRightChild(node);
		} else {
			parent.setLeftChild(node);
		}
		return root;
	}

	/**
	 * In Order Traversal Iterative Approach
	 * 
	 * @param root
	 * @throws StackOverFlowException
	 * @throws StackUnderFlowException
	 */
	public void inorderTraversalIterative(Node<Integer> root) throws StackOverFlowException, StackUnderFlowException {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		Node<Integer> current = root;
		while (current != null) {
			stack.push(current);
			current = current.leftChild;
		}
		while (!stack.isEmpty()) {
			Node<Integer> temp = stack.pop();
			System.out.println(temp.data + "->");
			if (temp.rightChild != null) {
				temp = temp.rightChild;
				stack.push(temp);
				if (temp.leftChild != null) {
					stack.push(temp.leftChild);
				}
			}

		}
	}

	/**
	 * Post Order Traversal Iterative Approach
	 * 
	 * @param root
	 * @throws StackOverFlowException
	 * @throws StackUnderFlowException
	 */
	public void postorderTraversalIterative(Node<Integer> root) throws StackOverFlowException, StackUnderFlowException {
		if (root == null) {
			return;
		}
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(root);
		while (!stack1.isEmpty()) {
			Node<Integer> temp = stack1.pop();
			stack2.push(temp);
			if (temp.leftChild != null) {
				stack1.push(temp.leftChild);
			}
			if (temp.rightChild != null) {
				stack1.push(temp.rightChild);
			}
		}
		while (!stack2.isEmpty()) {
			System.out.println(stack2.pop().data + "->");
		}
	}

	/**
	 * Pre Order Traversal Iterative Approach
	 * 
	 * @param root
	 * @throws StackOverFlowException
	 * @throws StackUnderFlowException
	 */
	public void preorderTraversalIterative(Node<Integer> root) throws StackOverFlowException, StackUnderFlowException {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node<Integer> temp = stack.pop();
			System.out.print(temp.data + "->");
			if (temp.rightChild != null) {
				stack.push(temp.rightChild);
			}
			if (temp.leftChild != null) {
				stack.push(temp.leftChild);
			}
		}
	}

	/**
	 * 
	 * @param root
	 * @param al
	 */
	public void rootToLeafPaths(Node<Integer> root, ArrayList<Integer> al) {
		if (root == null) {
			return;
		}
		al.add(root.data);
		if (root.leftChild == null && root.rightChild == null) {
			printArrayList(al);
			return;
		}

		if (root.leftChild != null) {
			rootToLeafPaths(root.leftChild, new ArrayList<Integer>(al));
		}
		if (root.rightChild != null) {
			rootToLeafPaths(root.rightChild, new ArrayList<Integer>(al));
		}

	}

	/**
	 * 
	 * @param root
	 * @param sum
	 * @param path
	 * @return
	 */
	public boolean pathsEqualToSum(Node<Integer> root, int sum, List<Node> path) {
		if (root == null) {
			return false;
		}

		if (root.leftChild == null && root.rightChild == null) {
			if (root.data == sum) {
				path.add(root);
				return true;
			} else {
				return false;
			}
		}
		if (pathsEqualToSum(root.leftChild, sum - root.data, path)
				|| pathsEqualToSum(root.rightChild, sum - root.data, path)) {
			path.add(root);
			return true;
		}
		return false;

	}
}
