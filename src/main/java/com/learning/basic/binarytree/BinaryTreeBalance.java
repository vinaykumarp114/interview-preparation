/**
 * 
 */
package com.learning.basic.binarytree;

/**
 * @author VINAY
 * 
 */
public class BinaryTreeBalance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Implement a function to check if a tree is balanced. For the purposes of this
 * question, a balanced tree is defined to be a tree such that no two leaf nodes
 * differ in distance from the root by more than one.
 * 
 * @author VINAY
 * 
 */
class BSTBalanced {
	public static int maxDepth(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public static int minDepth(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	public static boolean isBalanced(TreeNode<Integer> root) {
		return (maxDepth(root) - minDepth(root) <= 1);
	}
}