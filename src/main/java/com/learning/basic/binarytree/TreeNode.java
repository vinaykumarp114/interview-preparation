/**
 * 
 */
package com.learning.basic.binarytree;

/**
 * @author VINAY
 *
 */
public class TreeNode<T> {
	T value;
	TreeNode<T> left;
	TreeNode<T> right;

	TreeNode(T x) {
		this.value = x;
	}
}