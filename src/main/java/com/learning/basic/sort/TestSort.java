/**
 * 
 */
package com.learning.basic.sort;

import java.util.Arrays;

/**
 * @author VINAY
 * 
 */
public class TestSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		System.out.println("Initial : " + Arrays.toString(array));
		array = orderByEven(array);
		System.out.println("Final : " + Arrays.toString(array));
	}

	static int[] orderByEven(int[] array) {
		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			if (!even(array[left]) && even(array[right])) {
				array = swap(left, right, array);
			}

			if (even(array[left])) {
				++left;
			}
			if (!even(array[right])) {
				--right;
			}
		}

		return array;
	}

	/**
	 * @param i
	 * @param j
	 * @param array
	 * @return
	 */
	public static int[] swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;

		return array;
	}

	/**
	 * @param val
	 * @return
	 */
	public static boolean even(int val) {
		return val % 2 == 0;
	}
}