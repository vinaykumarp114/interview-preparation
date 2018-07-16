/**
 * 
 */
package com.learning.basic.binarytree;

/**
 * http://www.geeksforgeeks.org/print-binary-tree-vertical-order/
 * 
 * Print a Binary Tree in Vertical Order | Set 1 Given a binary tree, print it
 * vertically. The following example illustrates vertical order traversal.
 * 
 *     	   1
 *      /    \
 *     2      3
 *    / \    / \
 *   4   5  6   7
 *           \   \
 *            8   9 
 *
 * The output of print this tree vertically will be:
 * 4
 * 2
 * 1 5 6
 * 3 8
 * 7
 * 9 
 */
public class VeriticalOrderBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode<Integer> node = new TreeNode<Integer>(1);
		node.left = new TreeNode<Integer>(2);
		node.right = new TreeNode<Integer>(3);
		node.left.left = new TreeNode<Integer>(4);
		node.left.right = new TreeNode<Integer>(5);
		node.right.left = new TreeNode<Integer>(6);
		node.right.right = new TreeNode<Integer>(7);
		node.right.left.right = new TreeNode<Integer>(8);
		node.right.right.right = new TreeNode<Integer>(9);

		System.out.println("Following are the values of vertical order ");
		verticalOrder(node);
	}

	static void verticalOrder(TreeNode<Integer> node) {
		if (node == null) {
			return;
		}

		Values val = new Values();
		int level = 0;
		findMinMax(node, val, level);
		
		for(int pos = val.min; pos <= val.max; pos++ ){
			printVerticalLine(node, pos, level);
			System.out.println("");
		}
	}

	/**
	 * @param node
	 * @param min
	 * @param max
	 * @param level
	 */
	static void findMinMax(TreeNode<Integer> node, Values val, int level) {
		if (node == null) {
			return;
		}

		if (level < val.min) {
			val.min = level;
		} else if (level > val.max) {
			val.max = level;
		}

		findMinMax(node.left, val, level - 1);
		findMinMax(node.right, val, level + 1);
	}
	
	/**
	 * @param node
	 * @param position
	 * @param level
	 */
	static void printVerticalLine(TreeNode<Integer> node, int position, int level){
		if(node == null){
			return;
		}
		
		if(position == level){
			System.out.print(node.value+" ");
		}
		
		printVerticalLine(node.left, position, level - 1);
		printVerticalLine(node.right, position, level + 1);
	}
}

class Values {
	int min, max;
}
