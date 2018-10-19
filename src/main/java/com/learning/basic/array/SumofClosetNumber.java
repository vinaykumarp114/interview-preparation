/**
 * 
 */
package com.learning.basic.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vinay Finding three elements in an array whose sum is closest to a
 *         given number
 *         https://stackoverflow.com/questions/2070359/finding-three-elements-in-an-array-whose-sum-is-closest-to-a-given-number
 *
 */
public class SumofClosetNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SumofClosetNumber closetNumber = new SumofClosetNumber();
		int[] inputs = new int[] {2,3,5,7,1,3,9,-1,4,-3};
		List<Integer> output = closetNumber.sumofclosetnumber(inputs);
		System.out.println(output);
	}

	private List<Integer> sumofclosetnumber(int[] input) {
		List<Integer> result = new ArrayList<>();
		if (input != null && input.length > 1) {
			for (int i = 0; i < input.length; i++) {
				int j = i + 1;
				int k = input.length - 1;

				while (k >= j) {
					// We got a match! All done.
					if (input[i] + input[j] + input[k] == 0) {
						result.add(input[i]);
						result.add(input[j]);
						result.add(input[k]);
						break;
					}

					// We didn't match. Let's try to get a little closer:
					// If the sum was too big, decrement k.
					// If the sum was too small, increment j.
					if (input[i] + input[j] + input[k] > 0) {
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

}
