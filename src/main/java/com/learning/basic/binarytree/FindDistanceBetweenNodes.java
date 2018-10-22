/**
 * 
 */
package com.learning.basic.binarytree;

/**
 * @author vinay
 *
 *         Find distance between two nodes of a Binary Tree.
 *         https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
 * 
 *         Question: Given a list of n unique integers, construct a BST by
 *         inserting each integer in the given order without re-balancing the
 *         tree. Then, find the distance between two given nodes, node1 and
 *         node2 of the BST. In case, either node1 and node2 is not present in
 *         the tree then return -1
 * 
 *         Solution: The distance between two nodes can be obtained in terms of
 *         lowest common ancestor. Following is the formula.
 * 
 *         Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
 *         'n1' and 'n2' are the two given keys 'root' is root of given Binary Tree.
 *         'lca' is lowest common ancestor of n1 and n2 
 *         Dist(n1, n2) is the distance between n1 and n2.
 * 
 */
public class FindDistanceBetweenNodes {

	int distance1 = -1;
	int distance2 = -1;
	int dist = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindDistanceBetweenNodes test = new FindDistanceBetweenNodes();

		int[] values1 = new int[] { 5, 6, 3, 1, 2, 4 };
		int n = 6, node1 = 2, node2 = 4;

		int output = test.bstDistanceBetweenNodes(values1, n, node1, node2);
		System.out.println("Output 1 -> " + output);
		
		int[] values2 = new int[] { 9, 7, 5, 3,1 };
		n =5;
		node1 = 7;
		node2 = 20;

		output = test.bstDistanceBetweenNodes(values2, n, node1, node2);
		System.out.println("Output 2 -> " + output);
	}

	/**
	 * 
	 * @param values - list of integers
	 * @param n      - number of elements in the list
	 * @param node1  - first node
	 * @param node2  - second node
	 * @return
	 */
	public int bstDistanceBetweenNodes(int[] values, int n, int node1, int node2) {
		TreeNode<Integer> root = constructBST(values, n);
		return findDistance(root, node1, node2);
	}

	// Returns level of value k if it is present in tree,
	// otherwise returns -1
	int findLevel(TreeNode<Integer> root, int k, int level) {
		if (root == null)
			return -1;

		// If key is present at root, or in left subtree or right subtree,
		// return true;
		if (root.value == k)
			return level;

		int left = findLevel(root.left, k, level + 1);
		return (left != -1) ? left : findLevel(root.right, k, level + 1);
	}

	// This function returns pointer to LCA of two given values n1 and n2.
	// It also sets d1, d2 and dist if one key is not ancestor of other
	// d1 --> To store distance of n1 from root
	// d2 --> To store distance of n2 from root
	// lvl --> Level (or distance from root) of current node
	// dist --> To store distance between n1 and n2
	TreeNode<Integer> findLeastCommonAnchester(TreeNode<Integer> root, int n1, int n2, int lvl) {

		// Base case
		if (root == null)
			return null;

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (root.value == n1) {
			distance1 = lvl;
			return root;
		}
		if (root.value == n2) {
			distance2 = lvl;
			return root;
		}

		// Look for n1 and n2 in left and right subtrees
		TreeNode<Integer> left_lca = findLeastCommonAnchester(root.left, n1, n2, lvl + 1);
		TreeNode<Integer> right_lca = findLeastCommonAnchester(root.right, n1, n2, lvl + 1);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left_lca != null && right_lca != null) {
			dist = (distance1 + distance2) - 2 * lvl;
			return root;
		}

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
	}

	// The main function that returns distance between n1 and n2
	// This function returns -1 if either n1 or n2 is not present in
	// Binary Tree.
	int findDistance(TreeNode<Integer> root, int n1, int n2) {
		distance1 = -1;
		distance2 = -1;
		dist = 0;
		TreeNode<Integer> lca = findLeastCommonAnchester(root, n1, n2, 1);

		// If both n1 and n2 were present in Binary Tree, return dist
		if (distance1 != -1 && distance2 != -1)
			return dist;

		// If n1 is ancestor of n2, consider n1 as root and find level
		// of n2 in subtree rooted with n1
		if (distance1 != -1) {
			dist = findLevel(lca, n2, 0);
			return dist;
		}

		// If n2 is ancestor of n1, consider n2 as root and find level
		// of n1 in subtree rooted with n2
		if (distance2 != -1) {
			dist = findLevel(lca, n1, 0);
			return dist;
		}

		return -1;
	}

	private TreeNode<Integer> constructBST(int[] values, int n) {
		BinarySearchTree bst = new BinarySearchTree();

		for (Integer i : values) {
			bst.insert(i);
		}
		return bst.root;
	}
}
