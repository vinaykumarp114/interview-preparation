/**
 * 
 */
package com.learning.basic.binarytree;


/**
 * @author VINAY
 * 
 */
public class BinaryTreeKNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Identify Fifth Smallest Node in BST
		program1();
		
	}

	/**
	 * Consider below assumption
	 * 1) Left node value is less than root node
	 * 2) Right node value are greater than root node
	 *   Example : input [1,4,7,10,12,14,16]
	 *             Root Node - 14
	 *             Left Node - 12 -> 10 -> 7 
	 *                      Parent Node - 7 Right Node -> 4 Left Node -> 1
	 *             Right Node - 16
	 *             
	 *   input: head of balanced BST containing [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] output: 5
	 *   input: head of balanced BST containing [10, 11, 31, 51, 71, 72] output: 71
	 *   input: head of balanced BST containing [1, 2, 3] output: -1 
	 **/
	public static void program1() {
		BSTSearch bst = new BSTSearch();
		bst.insert(18).insert(15).insert(19).insert(13).insert(8).insert(10)
				.insert(5).insert(21).insert(23).insert(25);

		// Print BST data
		bst.printInorder();
		// Search for 5th Smallest Node
		bst.printKthSmallestNode(5);
		System.out.println(""+bst.printKthSmallestNode1(bst.root, 5));
	}
}

/**
 * @author VINAY
 *
 */
class BSTSearch {
	TreeNode<Integer> root;

	public BSTSearch insert(int value) {
		TreeNode<Integer> node = new TreeNode<Integer>(value);

		if (root == null) {
			root = node;
			return this;
		}

		insertRec(root, node);
		return this;
	}

	/**
	 * @param latestRoot
	 * @param node
	 */
	private void insertRec(TreeNode<Integer> latestRoot, TreeNode<Integer> node) {
		if (latestRoot.value > node.value) {

			if (latestRoot.left == null) {
				latestRoot.left = node;
				return;
			} else {
				insertRec(latestRoot.left, node);
			}
		} else {
			if (latestRoot.right == null) {
				latestRoot.right = node;
				return;
			} else {
				insertRec(latestRoot.right, node);
			}
		}
	}

	/**
	 * Printing the contents of the tree in an inorder way.
	 */
	public void printInorder() {
		printInOrderRec(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in an inorder way
	 */
	private void printInOrderRec(TreeNode<Integer> currRoot) {
		if (currRoot == null) {
			return;
		}

		printInOrderRec(currRoot.left);
		System.out.print(currRoot.value + ", ");
		
		printInOrderRec(currRoot.right);
	}
	
	/**
	 * @param k
	 */
	public void printKthSmallestNode(int k) {
		printKthSmallestNode(root, k);
	}

	private static int count = 0;
	/**
	 * @param rootPackageNode
	 * @param k
	 */
	private void printKthSmallestNode(TreeNode<Integer> rootPackageNode, int k) {
		if (rootPackageNode == null) {
			return;
		}

		printKthSmallestNode(rootPackageNode.left, k);
		count++;
		if (count == k) {
			System.out.println(rootPackageNode.value + ", count=" + count+ ", k=" + k);
		}

		if (count < k)
			printKthSmallestNode(rootPackageNode.right, k);
	}
	
	private static int count1 = 0;
	/**
	 * @param rootPackageNode
	 * @param k
	 */
	int printKthSmallestNode1(TreeNode<Integer> rootPackageNode, int k) {		
		int i = -1;
		
		if(rootPackageNode != null) {
			if(count1 < k){
				i = printKthSmallestNode1(rootPackageNode.left, k);
			}
			count1++;
			if (count1 == k) {
				i = rootPackageNode.value;
			}

			if (count1 < k)
				i = printKthSmallestNode1(rootPackageNode.right, k);
		}
		
		return i;
	}
}