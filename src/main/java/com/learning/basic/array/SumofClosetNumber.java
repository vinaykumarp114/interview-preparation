/**
 * 
 */
package com.learning.basic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author vinay
 * 
 *         Finding three elements in an array whose sum is closest to a given
 *         number
 *         https://stackoverflow.com/questions/2070359/finding-three-elements-in-an-array-whose-sum-is-closest-to-a-given-number
 * 
 * 
 *         Given an array and a value, find if there is a triplet in array whose
 *         sum is equal to the given value. If there is such a triplet present
 *         in array, then print the triplet and return true. Else return false.
 *         For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum
 *         is 24, then there is a triplet (12, 3 and 9) present in array whose
 *         sum is 24.
 *
 */
public class SumofClosetNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SumofClosetNumber closetNumber = new SumofClosetNumber();
		int[] input1 = new int[] { 2, 3, 5, 7, 1, 3, 9, -1, 4, -3 };
		List<Integer> output1 = closetNumber.sumofclosetnumber(input1, 0);
		System.out.println("Input 1 -> " + output1);

		int[] input2 = new int[] { 12, 3, 4, 1, 6, 9 };
		output1 = closetNumber.sumofclosetnumber(input2, 24);
		System.out.println("Input 2 -> " + output1);

		int[] input3 = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };
		List<List<Integer>> output2 = closetNumber.findThreeElement(input3, 8);
		System.out.println("Input 3 -> " + output2);
	}

	private List<Integer> sumofclosetnumber(int[] input, int sum) {
		List<Integer> result = new ArrayList<>();
		if (input != null && input.length > 1) {
			for (int i = 0; i < input.length - 2; i++) {
				int j = i + 1;
				int k = input.length - 1;

				while (k >= j) {
					// We got a match! All done.
					if (input[i] + input[j] + input[k] == sum) {
						result.add(input[i]);
						result.add(input[j]);
						result.add(input[k]);
						break;
					}
					// We didn't match. Let's try to get a little closer:
					// If the sum was too big, decrement k.
					// If the sum was too small, increment j.
					else if (input[i] + input[j] + input[k] > sum) {
						k--;
					} else {
						j++;
					}
				}
				// When the while-loop finishes, j and k have passed each other and there's
				// no more useful combinations that we can try with this i.
			}
		}

		return result;
	}

	private List<List<Integer>> findThreeElement(int[] input, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		int count = 0;
		if (input != null && input.length > 1) {
			for (int i = 0; i < input.length - 2; i++) {
				int j = i + 1;
				int k = input.length - 1;

				while (k >= j) {
					// We got a match! All done.
					if (input[i] + input[j] + input[k] == sum) {
						result.add(Arrays.asList(input[i], input[j], input[k]));
						count++;
					}
					// We didn't match. Let's try to get a little closer:
					// If the sum was too big, decrement k.
					// If the sum was too small, increment j.
					if (input[i] + input[j] + input[k] > sum) {
						k--;
					} else {
						j++;
					}
				}
				// When the while-loop finishes, j and k have passed each other and there's
				// no more useful combinations that we can try with this i.
			}
		}
		System.out.println("Total Count :: " + count);
		return result;
	}

}
