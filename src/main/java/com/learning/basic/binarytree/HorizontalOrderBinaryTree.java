/**
 * 
 */
package com.learning.basic.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * Horizontal (level) order of a binary tree
 *      5
 *    /  \
 *   3    8
 *  / \  / \
 * 1  4 6  10
 *
 */
public class HorizontalOrderBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode<Integer> node = new TreeNode<Integer>(5);
		node.left = new TreeNode<Integer>(3);
		node.right = new TreeNode<Integer>(8);
		node.left.left = new TreeNode<Integer>(1);
		node.left.right = new TreeNode<Integer>(4);
		node.right.left = new TreeNode<Integer>(6);
		node.right.right = new TreeNode<Integer>(10);
		
		System.out.println("Print Horizontal (level) order of a binary tree - 0");
		int level = 0;
		Map<Integer, String> hmap = new HashMap<Integer, String>();
		horizontalOrder(node, level, hmap);
		System.out.println(hmap);
		
		System.out.println("Print Horizontal (level) order of a binary tree - 1");
		// Without using space
		int h = height(node);
		for(int l = 1; l <= h; l++){
			printLevelOrder(node,l);
			System.out.println("");
		}
	}
	
	static void horizontalOrder(TreeNode<Integer> node, int level, Map<Integer, String> hmap) {
		if(node == null){
			return;
		}
		
		String prev = (hmap.containsKey(level)) ? hmap.get(level):"";
		hmap.put(level, prev + " " + node.value);
		
		horizontalOrder(node.left, level + 1, hmap);
		horizontalOrder(node.right, level + 1, hmap);
	}
	
	static int height(TreeNode<Integer> node) {
		if (node == null) {
			return 0;
		} else {
			int lHeight = height(node.left);
			int rHeight = height(node.right);

			return Math.max((lHeight + 1),(rHeight + 1));
		}
	}
	
	static void printLevelOrder(TreeNode<Integer> node, int level){
		if(node == null || level <= 0){
			return;
		}
		
		if(level == 1){
			System.out.print(node.value + " ");
		}
		
		printLevelOrder(node.left, level - 1);
		printLevelOrder(node.right, level - 1);
	}
}
