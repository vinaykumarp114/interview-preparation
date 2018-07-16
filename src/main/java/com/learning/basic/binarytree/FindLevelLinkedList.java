/**
 * 
 */
package com.learning.basic.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary search tree, design an algorithm which creates a linked list
 * of all the nodes at each depth (eg, if you have a tree with depth D, you�ll
 * have D linked lists).
 * 
 * @author VINAY
 *
 */
public class FindLevelLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static List<LinkedList<TreeNode<Integer>>> findlevelLinkList(TreeNode<Integer> root) {
		List<LinkedList<TreeNode<Integer>>> result = null;

		if (root != null) {
			result = new LinkedList<LinkedList<TreeNode<Integer>>>();

			int level = 0;
			LinkedList<TreeNode<Integer>> list = new LinkedList<TreeNode<Integer>>();
			list.add(root);

			result.add(level, list);

			while (true) {
				list = new LinkedList<TreeNode<Integer>>();
				for (int i = 0; i < result.get(level).size(); i++) {
					TreeNode<Integer> n = result.get(level).get(i);

					if (n != null) {
						if (n.left != null) {
							list.add(n.left);
						}
						if (n.right != null) {
							list.add(n.right);
						}
					}
				}
				if(list.size() > 0){
					result.add(level + 1, list);
				} else {
					break;
				}
				level++;
			}
		}

		return result;
	}
}
