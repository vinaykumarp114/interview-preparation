/**
 * 
 */
package com.learning.basic.sort;

import java.util.Arrays;

/**
 * 
 * @author VINAY
 *
 */
public class MergeTwoArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int m = 5;
		int n = 4;
		int[] b = { 2, 5, 7, 9 };
		int[] a = new int[m + n];
		a[0] = 0;
		a[1] = 1;
		a[2] = 3;
		a[3] = 4;
		a[4] = 8;

		merge(a, b, m, n);
		System.out.println(Arrays.toString(a));
	}

	/**
	 * You are given two sorted arrays, A and B, and A has a large enough buffer
	 * at the end to hold B. Write a method to merge B into A in sorted order.
	 * 
	 * Approach - This code is a part of the standard merge-sort code. We merge
	 * A and B from the back, by comparing each element.
	 * 
	 * @param a
	 * @param b
	 */
	static void merge(int[] a, int[] b, int m, int n) {
		int i = m - 1; // Index of last element in array a
		int j = n - 1; // Index of last element in array b
		int k = m + n - 1;

		// Start comparing from the last element and merge a and b
		while (i >= 0 && j >= 0) {
			if (a[i] > b[j]) {
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}
		}

		while (j >= 0) {
			a[k--] = b[j--];
		}
	}
}
