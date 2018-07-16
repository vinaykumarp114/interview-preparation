/**
 * 
 */
package com.learning.basic.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
 * 
 * Sum all the values of the nodes of a Binary tree that fall on the same column and print them
 * OR
 * Vertical Sum in a given Binary Tree
 * 
 * Given a Binary Tree, find vertical sum of the nodes that are in same vertical
 * line. Print all sums through different vertical lines.
 *	      1
 *	    /   \
 *	  2      3
 *	 / \    / \
 *	4   5  6   7
 *
 * Vertical-Line-1 has only one node 4 => vertical sum is 4
 * Vertical-Line-2: has only one node 2=> vertical sum is 2
 * Vertical-Line-3: has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12
 * Vertical-Line-4: has only one node 3 => vertical sum is 3
 * Vertical-Line-5: has only one node 7 => vertical sum is 7
 * 
 * So expected output is 4, 2, 12, 3 and 7
 *
 */
public class VerticleSumBinaryTree {

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

		System.out.println("Following are the values of vertical sums with "
				+ "the positions of the columns with respect to root ");
		verticalSum(node);
	}

	/**
	 * @param node
	 */
	static void verticalSum(TreeNode<Integer> node) {
		if (node == null) {
			return;
		}
		Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		verticalSum(node, 0, hmap);

		// Prints the values stored by VerticalSumUtil()
		if (hmap != null) {
			System.out.println(hmap.entrySet());
		}

		// No using space
		Values1 val = new Values1();
		int level = 0;
		findMinMax(node, val, level);
		for (int pos = val.min; pos <= val.max; pos++) {
			int r = printVerticalSum(node, pos, level);
			System.out.println("Column ::" + pos + ":: Sum ::" + r);
		}

	}

	/**
	 * @param node
	 * @param level
	 * @param hmap
	 */
	static void verticalSum(TreeNode<Integer> node, int level, Map<Integer, Integer> hmap) {
		if (node == null) {
			return;
		}

		int prevSum = (hmap.containsKey(level)) ? hmap.get(level) : 0;
		hmap.put(level, prevSum + node.value);

		// Store the values in hmap for left subtree
		verticalSum(node.left, level - 1, hmap);
		verticalSum(node.right, level + 1, hmap);
	}

	static void findMinMax(TreeNode<Integer> node, Values1 val, int level) {
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

	static int printVerticalSum(TreeNode<Integer> node, int pos, int level) {
		int sum = 0;
		if (node == null) {
			return 0;
		}

		if (pos == level) {
			sum += node.value;
		}

		sum += printVerticalSum(node.left, pos, level - 1);
		sum += printVerticalSum(node.right, pos, level + 1);
		return sum;
	}
}

class Values1 {
	int min, max;
}