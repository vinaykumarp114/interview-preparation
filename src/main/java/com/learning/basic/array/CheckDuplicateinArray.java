/**
 * 
 */
package com.learning.basic.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * http://www.geeksforgeeks.org/amazon-interview-experience-set-202/
 * 
 * Write a function that determines whether a two dimensional array contains
 * duplicate values within k indices of each other
 * 
 * The first line of input will be a number indicating how many rows are in the
 * matrix. This will be followed by lines of input one for each row of the
 * matrix each row will contain the same number of columns with each column
 * separated by a space. Following the matrix will be a single line of input
 * containing a number indicating the k value.
 * 
 * Output should be �YES� or �NO� 
 * 
 * example: 
 * 4
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 3
 * 
 * Output: No
 * 
 * @author VINAY
 *
 */
public class CheckDuplicateinArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int rows = s.nextInt();
		int count = rows + 1;
		String[] split = null;
		List<Integer> input = new ArrayList<Integer>();

		while (count > 0) {
			split = s.nextLine().split(" ");
			for (String v : split) {
				if (v != null && !v.isEmpty()) {
					input.add(Integer.parseInt(v));
				}
			}
			count--;
		}

		int k = s.nextInt();
		if (k <= rows) {
			Integer[] arr = input.toArray(new Integer[input.size()]);

			if (checkDuplicatesWithinK(arr, k)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		} else {
			System.out.println("Yes");
		}

		s.close();
	}

	static boolean checkDuplicatesWithinK(Integer arr[], int k) {
		// Creates an empty hashset
		Set<Integer> set = new HashSet<Integer>();

		// Traverse the input array
		for (int i = 0; i < arr.length; i++) {
			// If already present n hash, then we found
			// a duplicate within k distance
			if (set.contains(arr[i]))
				return true;

			// Add this item to hashset
			set.add(arr[i]);

			// Remove the k+1 distant item
			if (i >= k)
				set.remove(arr[i - k]);
		}
		return false;
	}
}