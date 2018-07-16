/**
 * 
 */
package com.learning.basic.binarytree;

/**
 * http://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
 * 
 * @author VINAY
 *
 */
public class MaximumWidthBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaximumWidthBinaryTree binaryTree = new MaximumWidthBinaryTree();
		TreeNode<Integer> tree = new TreeNode<Integer>(3);
		tree.left = new TreeNode<Integer>(2);
		tree.right = new TreeNode<Integer>(5);
		tree.left.left = new TreeNode<Integer>(1);
		tree.right.right = new TreeNode<Integer>(6);
		tree.right.left = new TreeNode<Integer>(4);
		tree.right.right.right = new TreeNode<Integer>(7);

		System.out.println("Maximum width is " + binaryTree.getMaxWidth(tree));
	}

	/* Function to get the maximum width of a binary tree */
	int getMaxWidth(TreeNode<Integer> node) {
		int maxWidth = 0;
		int width;
		int h = height(node);
		System.out.println("Height : "+h);
		int i;

		/*
		 * Get width of each level and compare the width with maximum width so
		 * far
		 */
		for (i = 1; i <= h; i++) {
			width = getWidth(node, i);
			if (width > maxWidth) {
				maxWidth = width;
			}
		}
		return maxWidth;
	}

	/* Get width of a given level */
	int getWidth(TreeNode<Integer> node, int level) {
		if (node == null) {
			return 0;
		}
		if (level == 1) {
			return 1;
		} else if (level > 1) {
			return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
		}
		return 0;
	}

	/* UTILITY FUNCTIONS */
	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	int height(TreeNode<Integer> node) {
		if (node == null) {
			return -1;
		} else {
			/* compute the height of each subtree */
			int lHeight = height(node.left);
			int rHeight = height(node.right);

			/* use the larger one */
			return Math.max((lHeight + 1),(rHeight + 1));
		}
	}
}