package com.learning.basic.binarytree;

/**
 * Given a sorted (increasing order) array, write an algorithm to create a
 * binary tree with minimal height
 * 
 * @author VINAY
 *
 */
public class BinarySearchTreeArray {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		createMinimalBST(array);
	}

	public static void createMinimalBST(int array[]) {
		BSTArray bst = new BSTArray();
		TreeNode<Integer> node = bst.addToTree(array, 0, array.length - 1);
		bst.printNode(node);
	}
}

class BSTArray {
	public TreeNode<Integer> addToTree(int[] array, int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode<Integer> node = new TreeNode<Integer>(array[mid]);
		node.left = addToTree(array, start, mid - 1);
		node.right = addToTree(array, mid + 1, end);
		return node;
	}
	
	public void printNode(TreeNode<Integer> node) {
		if(node == null){
			return;
		}
		System.out.print(node.value +" ");
		printNode(node.left);		
		printNode(node.right);
	}
}