/**
 * 
 */
package com.learning.basic.search;

import java.util.Arrays;
import java.util.Random;

/**
 * @author VINAY
 * 
 */
public class BinarySearch {

	/**
	 * This class should not be instantiated.
	 */
	private BinarySearch() {
	}

	/**
	 * Searches for the integer key in the sorted array a[].
	 * 
	 * @param key
	 *            the search key
	 * @param a
	 *            the array of integers, must be sorted in ascending order
	 * @return index of key in array a[] if present; -1 if not present
	 */
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			// Key is in a[lo..hi] or not present.
			int mid = (lo + hi) / 2;
			if (a[mid] < key) {
				lo = mid + 1;
			} else if (a[mid] > key) {
				hi = mid - 1;
			} else {
				return lo;
			}
		}
		return -1;
	}

	/**
	 * Reads in a sequence of integers from the whitelist file, specified as a
	 * command-line argument. Reads in integers from standard input and prints
	 * to standard output those integers that do *not* appear in the file.
	 */
	public static void main(String[] args) {

		// read the integers from a file
		int[] whitelist = { 5, 4, 7, 2, 9, 10, 1, 3, 6, 8 };

		// sort the array
		Arrays.sort(whitelist);

		// read integer key from standard input; print if not in whitelist
		Random random = new Random();
		int key = random.nextInt(whitelist.length - 1);
		System.out.println("key : " + key);
		int index = rank(key, whitelist);
		System.out.println("whitelist [ " + index + " ] : "+whitelist[index]);
		if (index == -1) {
			System.out.println("Not Found");
		}
	}

}
