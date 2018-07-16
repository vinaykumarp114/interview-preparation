/**
 * 
 */
package com.learning.basic.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author VINAY
 * 
 */
public class BinaryTreePathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RootToLeaf rootToLeaf = new RootToLeaf();

		TreeNode<Integer> leftLeaf1 = new TreeNode<Integer>(7);
		TreeNode<Integer> leftLeaf2 = new TreeNode<Integer>(2);
		TreeNode<Integer> leftnode2 = new TreeNode<Integer>(11);
		leftnode2.left = leftLeaf1;
		leftnode2.right = leftLeaf2;

		TreeNode<Integer> leftnode1 = new TreeNode<Integer>(4);
		leftnode1.left = leftnode2;

		TreeNode<Integer> rightLeaf1 = new TreeNode<Integer>(5);
		TreeNode<Integer> rightLeaf2 = new TreeNode<Integer>(1);
		TreeNode<Integer> rightnode2 = new TreeNode<Integer>(4);
		rightnode2.left = rightLeaf1;
		rightnode2.right = rightLeaf2;

		TreeNode<Integer> rightLeaf3 = new TreeNode<Integer>(13);
		TreeNode<Integer> rightnode1 = new TreeNode<Integer>(8);
		rightnode1.left = rightLeaf3;
		rightnode1.right = rightnode2;

		TreeNode<Integer> root = new TreeNode<Integer>(5);
		root.left = leftnode1;
		root.right = rightnode1;

		int sum = 22;
		System.out.println("Validate Path : ");
		System.out.println("original = " + rootToLeaf.hasPathSum(root, sum));
		System.out.println("bert     = " + rootToLeaf.hasPathSumBert(root, sum));
		System.out.println("mark     = " + rootToLeaf.hasPathSumMark(root, sum));
		System.out.println("=============================");
		System.out.println("Print Path : ");
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		rootToLeaf.pathSum(root, sum, new LinkedList<Integer>(), result);
		System.out.println(result);

		System.out.println("hasPathSumBert(null, 0): " + rootToLeaf.hasPathSumBert(null, 0));
		System.out.println("hasPathSumBert(null, 1): " + rootToLeaf.hasPathSumBert(null, 1));
	}

}

class RootToLeaf {
	/**
	 * @param node
	 * @param sum
	 * @return
	 */
	boolean hasPathSum(final TreeNode<Integer> node, final int sum) {
		// return true if we run out of tree and sum==0
		if (node == null) {
			return (sum == 0);
		} else {
			// otherwise check both subtrees
			final int subSum = sum - node.value;
			return (hasPathSum(node.left, subSum) || hasPathSum(node.right, subSum));
		}
	}

	/**
	 * @param node
	 * @param sum
	 * @return
	 */
	boolean hasPathSumBert(final TreeNode<Integer> node, final int sum) {
		// return true if we run out of tree and sum==0
		if (node == null) { // empty tree
			// choose one:
			return (sum == 0);
			// return false;
		} else if (node.left == null && node.right == null) { // leaf
			return (sum == node.value);
		} else if (sum <= node.value) { // sum used up
			return false;
		} else { // try children
			return (node.left != null && hasPathSumBert(node.left, sum - node.value))
					|| (node.right != null && hasPathSumBert(node.right, sum - node.value));
		}
	}

	/**
	 * @param node
	 * @param sum
	 * @return
	 */
	boolean hasPathSumMark(final TreeNode<Integer> node, final int sum) {
		final int subSum = sum - node.value;
		if (node.left == null && node.right == null) {
			return (subSum == 0);
		} else {
			// otherwise check both subtrees
			if (node.left != null && hasPathSumMark(node.left, subSum))
				return true;
			if (node.right != null && hasPathSumMark(node.right, subSum))
				return true;
			return false;
		}
	}

	/**
	 * @param root
	 * @param sum
	 * @param curList
	 * @param res
	 */
	void pathSum(TreeNode<Integer> root, int sum, List<Integer> curList, List<List<Integer>> res) {
		if (root == null) {
			return;
		}
		curList.add(root.value);

		if (root.left == null && root.right == null) {
			if (sum - root.value == 0) {
				res.add(new LinkedList<Integer>(curList));
			}
		}
		if (root.left != null) {
			pathSum(root.left, sum - root.value, curList, res);
		}
		if (root.right != null) {
			pathSum(root.right, sum - root.value, curList, res);
		}
		curList.remove(new Integer(root.value));
	}
}