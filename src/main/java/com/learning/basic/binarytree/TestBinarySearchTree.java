/**
 * 
 */
package com.learning.basic.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * http://www.javabeat.net/binary-search-tree-traversal-java/
 * http://rosettacode.org/wiki/Tree_traversal#Java
 * 
 * 
 *   
 */
public class TestBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(40).insert(25).insert(78).insert(10).insert(32).insert(50).insert(93).insert(3).insert(17).insert(30)
				.insert(38);	
		System.out.println("Inorder traversal");
		bst.printInorder();

		System.out.println("Preorder Traversal");
		bst.printPreorder();

		System.out.println("Postorder Traversal");
		bst.printPostorder();

		System.out.println("The minimum value in the BST: " + bst.findMinimum());
		System.out.println("The maximum value in the BST: " + bst.findMaximum());
		
		bst.levelorder(bst.root);
	}

}

class BinarySearchTree {
	TreeNode<Integer> root;

	public BinarySearchTree insert(int value) {
		TreeNode<Integer> node = new TreeNode<Integer>(value);

		if (root == null) {
			root = node;
			return this;
		}

		insertRec(root, node);
		return this;
	}

	/**
	 * @param latestRoot
	 * @param node
	 */
	private void insertRec(TreeNode<Integer> latestRoot, TreeNode<Integer> node) {
		if (latestRoot.value > node.value) {

			if (latestRoot.left == null) {
				latestRoot.left = node;
				return;
			} else {
				insertRec(latestRoot.left, node);
			}
		} else {
			if (latestRoot.right == null) {
				latestRoot.right = node;
				return;
			} else {
				insertRec(latestRoot.right, node);
			}
		}
	}

	/**
	 * Printing the contents of the tree in an inorder way.
	 */
	public void printInorder() {
		printInOrderRec(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in an inorder way
	 */
	private void printInOrderRec(TreeNode<Integer> currRoot) {
		if (currRoot == null) {
			return;
		}

		printInOrderRec(currRoot.left);
		System.out.print(currRoot.value + ", ");

		printInOrderRec(currRoot.right);
	}

	public void printPreorder() {
		printPreOrderRec(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in an preorder way
	 */
	private void printPreOrderRec(TreeNode<Integer> currRoot) {
		if (currRoot == null) {
			return;
		}

		System.out.print(currRoot.value + ", ");
		printInOrderRec(currRoot.left);
		printInOrderRec(currRoot.right);
	}

	public void printPostorder() {
		printPostOrderRec(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in an postOrder way
	 */
	private void printPostOrderRec(TreeNode<Integer> currRoot) {
		if (currRoot == null) {
			return;
		}

		printInOrderRec(currRoot.left);
		printInOrderRec(currRoot.right);
		System.out.print(currRoot.value + ", ");
	}

	/**
	 * Returns the minimum value in the Binary Search Tree.
	 */
	public int findMinimum() {
		if (root == null) {
			return 0;
		}
		TreeNode<Integer> currNode = root;

		while (currNode.left != null) {
			currNode = currNode.left;
		}
		return currNode.value;
	}

	/**
	 * Returns the maximum value in the Binary Search Tree.
	 */
	public int findMaximum() {
		if (root == null) {
			return 0;
		}
		TreeNode<Integer> currNode = root;

		while (currNode.right != null) {
			currNode = currNode.right;
		}
		return currNode.value;
	}

	/**
	 * @param n1
	 * @param n2
	 * @return
	 */
	public boolean compareTrees(TreeNode<Integer> n1, TreeNode<Integer> n2) {

		if (n1 == null || n2 == null) {
			return n1 == n2; // i.e. both null
		}

		if (n1.value != n2.value) {
			return false;
		}

		return compareTrees(n1.left, n2.left) && compareTrees(n1.right, n2.right);
	}

	/**
	 * @param n
	 */
	public void levelorder(TreeNode<Integer> n) {
		Queue<TreeNode<Integer>> nodequeue = new LinkedList<TreeNode<Integer>>();
		if (n != null) {
			nodequeue.add(n);
		}
		while (!nodequeue.isEmpty()) {
			TreeNode<Integer> next = nodequeue.remove();
			System.out.print(next.value + " ");
			if (next.left != null) {
				nodequeue.add(next.left);
			}
			if (next.right != null) {
				nodequeue.add(next.right);
			}
		}
	}
}