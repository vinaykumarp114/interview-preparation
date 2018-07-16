/**
 * 
 */
package com.learning.basic.array;

import java.util.Arrays;

/**
 * A sorted array has been rotated so that the elements might appear in the
 * order 3 4 5 6 7 1 2. How would you find the minimum element?
 * 
 * Output = 1
 * 
 * @author VINAY
 *
 */
public class FindMinimumArrayElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 3, 4, 5, 6, 7, 1, 2 };
		System.out.println("Input : " + Arrays.toString(input));

		int result = method1(input);
		System.out.println("Output : " + result);

		result = method2(input);
		System.out.println("Output : " + result);
	}

	static int method1(int[] input) {
		int result = input[0];

		for (int i = 0; i < input.length; i++) {
			if (result > input[i]) {
				result = input[i];
			}
		}

		return result;
	}

	static int method2(int[] input) {
		int result = input[0];

		int left = 0;
		int right = input.length - 1;

		while (left < right) {
			int mid = (left + right) / 2;
			if (input[mid] > result) {				
				left = mid + 1;	
			} else {
				result = input[mid];
				right = mid - 1;
			}
		}

		return result;
	}
}
