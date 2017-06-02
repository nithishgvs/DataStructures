package org.nithish.trees;

public class BinarySearchTreeOperations {
	public BinarySearchTreeNode FindWithRecursion(BinarySearchTreeNode root, int data) {
		if (root == null) {
			return null;
		}
		if (root.getData() < data) {
			FindWithRecursion(root.getLeft(), data);
		} else if (data > root.getData()) {
			FindWithRecursion(root.getRight(), data);
		}
		return root;
	}

	public BinarySearchTreeNode FindWithoutRecursion(BinarySearchTreeNode root, int data) {
		if (root == null) {
			return null;
		}
		while (root != null) {
			if (root.getData() == data) {
				return root;
			} else if (data > root.getData()) {
				root = root.getRight();
			} else {
				root = root.getLeft();
			}
		}
		return null;
	}

	public BinarySearchTreeNode FindMinRecursion(BinarySearchTreeNode root) {
		if (root == null) {
			return null;
		} else if (root.getLeft() == null) {
			return root;
		} else {
			return FindMinRecursion(root.getLeft());
		}
	}

	public BinarySearchTreeNode FindMinWithoutRecursion(BinarySearchTreeNode root) {
		if (root == null) {
			return null;
		}
		while (root.getLeft() != null) {
			root = root.getLeft();
		}
		return root;
	}

	public BinarySearchTreeNode FindMaxRecursion(BinarySearchTreeNode root) {
		if (root == null) {
			return null;
		} else if (root.getRight() == null) {
			return root;
		} else {
			return FindMaxRecursion(root.getRight());
		}
	}

	public BinarySearchTreeNode FindMaxWithoutRecursion(BinarySearchTreeNode root) {
		if (root == null) {
			return null;
		}
		while (root.getRight() != null) {
			root = root.getRight();
		}
		return root;
	}

	public BinarySearchTreeNode Insertion(BinarySearchTreeNode root, int data) {
		if (root == null) {
			root = new BinarySearchTreeNode();
			if (root == null) {
				System.out.println("Memory Error");
				return root;
			} else {
				root.setData(data);
				root.setLeft(null);
				root.setRight(null);
			}
		} else {
			if (data < root.getData()) {
				root.setLeft(Insertion(root.getLeft(), data));
				System.out.println(root.getLeft());
				System.out.println(root.getRight());
			} else if (data > root.getData()) {
				root.setRight(Insertion(root.getRight(), data));
			}

		}
		return root;
	}

}
