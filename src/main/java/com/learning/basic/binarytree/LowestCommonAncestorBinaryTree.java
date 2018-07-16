/**
 * 
 */
package com.learning.basic.binarytree;

/**
 * @author VINAY
 * 
 */
public class LowestCommonAncestorBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Create a sample Binary Tree. A Binary tree does not have to maintain
		 * left <root < right relationship.
		 */
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.left = new TreeNode<Integer>(2);
		root.right = new TreeNode<Integer>(4);
		root.left.left = new TreeNode<Integer>(6);
		root.left.right = new TreeNode<Integer>(5);

		root.right.left = new TreeNode<Integer>(9);
		root.right.right = new TreeNode<Integer>(11);
		root.right.right.left = new TreeNode<Integer>(7);
		root.right.right.right = new TreeNode<Integer>(3);

		BinarySearchTreeLCA binarySearchTreeLCA = new BinarySearchTreeLCA();

		TreeNode<Integer> result = binarySearchTreeLCA.findLowestCommonAncestor(root, root.right.right.right,
				root.right.left);
		if (result != null) {
			System.out.println("Lowest Common Ancestor of Node 3 and 9 is: " + result.value);
		}

		result = binarySearchTreeLCA.findLowestCommonAncestor(root, root.left.right, root.right.right.left);
		if (result != null) {
			System.out.println("Lowest Common Ancestor of Node 5 and 3 is: " + result.value);
		}
		result = binarySearchTreeLCA.findLowestCommonAncestor(root, root.right.right.right, null);
		if (result != null) {
			System.out.println("Lowest Common Ancestor of Node 3 and null is: " + result.value);
		}

		result = binarySearchTreeLCA.findLowestCommonAncestor(root, root.right.right, null);
		if (result != null) {
			System.out.println("Lowest Common Ancestor of Node 11 and null is : " + result.value);
		}

		result = binarySearchTreeLCA.findLowestCommonAncestor(root, null, null);
		System.out.println("Lowest Common Ancestor of null and null is : " + result);
	}
}

class BinarySearchTreeLCA {

	/**
	 * Recursive approach to find the Lowest Common Ancestor
	 * 
	 * @param root
	 * @param a
	 *            - first Node
	 * @param b
	 *            - second Node
	 * @return Node that is lowest common ancestor of both a and b
	 */
	public TreeNode<Integer> findLowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> a,
			TreeNode<Integer> b) {

		if (root == null) {
			return null;
		}

		/**
		 * If Node a or Node b is also the root, then the root itself is lowest
		 * common ancestor
		 */
		if (root == a || root == b) {
			return root;
		}

		TreeNode<Integer> left = findLowestCommonAncestor(root.left, a, b);
		TreeNode<Integer> right = findLowestCommonAncestor(root.right, a, b);

		/**
		 * If Node a and Node b lie in the left, their Lowest Common Ancestor is
		 * in the left. If Node a and Node b lie in the right,their Lowest
		 * Common Ancestor is in the right.
		 * 
		 * Otherwise, root is the Lowest common ancestor.
		 */
		if (left != null && right != null) {
			return root;
		}

		return (left != null) ? left : right;
	}

	/**
	 * @param root
	 * @param a
	 * @param b
	 * @return
	 */
	public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, int a, int b) {
		if (root == null) {
			return null;
		}

		if (root.value > a && root.value > b) {
			// both targets are left
			return lowestCommonAncestor(root.left, a, b);
		} else if (root.value < a && root.value < b) {
			// both targets are right
			return lowestCommonAncestor(root.right, a, b);
		} else {
			// either we are diverging or both targets are equal
			// in both cases so we've found the LCA
			// check for actual existence of targets here, if you like
			return root;
		}
	}
}