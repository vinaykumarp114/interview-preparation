/**
 * 
 */
package com.learning.basic.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * Horizontal (level) sum of a binary tree
 *      5
 *    /  \
 *   3    8
 *  / \  / \
 * 1  4 6  10
 *
 */
public class HorizontalSumBinaryTree {

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
		
		System.out.println("Print Horizontal (level) Sum of a binary tree");
		int level = 0;
		Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		horizontalSum(node, level, hmap);
		System.out.println(hmap);
		
		System.out.println("Print Horizontal (level) Sum of a binary tree - 1");
		int h = height(node);
		for(int l = 1; l <= h; l++){
			int val = printLevelOrderSum(node,l);
			System.out.println("Level - "+l+" :: Sum :: "+val);
		}
	}
	
	static void horizontalSum(TreeNode<Integer> node, int level, Map<Integer, Integer> hmap) {
		if(node == null){
			return;
		}
		
		int prev = (hmap.containsKey(level)) ? hmap.get(level): 0;
		hmap.put(level, prev + node.value);
		
		horizontalSum(node.left, level + 1, hmap);
		horizontalSum(node.right, level + 1, hmap);
	}
	
	static int height(TreeNode<Integer> node){
		if(node == null){
			return 0;
		} else {
			int lHeight = height(node.left);
			int rHeight = height(node.right);
			
			return Math.max((lHeight + 1),(rHeight + 1));
		}
	}
	
	static int printLevelOrderSum(TreeNode<Integer> node, int level){
		if(node == null || level <= 0){
			return 0;
		}
		if(level == 1){
			return node.value;
		}
		
		return printLevelOrderSum(node.left, level - 1) + printLevelOrderSum(node.right, level - 1);
		
	}
}
