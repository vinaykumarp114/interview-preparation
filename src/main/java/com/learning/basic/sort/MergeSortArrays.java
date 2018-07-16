/**
 * 
 */
package com.learning.basic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author VINAY
 *
 */
public class MergeSortArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mergeTwoArray();
		mergeThreeArray();
	}

	/**
	 * How to merge two sorted arrays into a sorted array?
	 */
	private static void mergeTwoArray() {
		int[] arr1 = new int[] { 1, 3, 4, 5, 7, 7, 9, 11, 13, 15, 17, 19 };
		int[] arr2 = new int[] { 2, 4, 6, 8, 10, 12, 14, 14, 16, 18, 20, 22 };

		int FirstArrayLocation = 0;
		int SecondArrayLocation = 0;
		int[] mergeArr = new int[arr1.length + arr2.length];

		for (int i = 0; i <= arr1.length + arr2.length; i++) {
			if ((FirstArrayLocation < arr1.length) && (SecondArrayLocation < arr2.length)) {
				if (arr1[FirstArrayLocation] <= arr2[SecondArrayLocation]) {
					mergeArr[i] = arr1[FirstArrayLocation];
					FirstArrayLocation++;
				} else {
					mergeArr[i] = arr2[SecondArrayLocation];
					SecondArrayLocation++;
				}
			} else if (SecondArrayLocation < arr2.length) {
				mergeArr[i] = arr2[SecondArrayLocation];
				SecondArrayLocation++;
			} else if (FirstArrayLocation < arr1.length) {
				mergeArr[i] = arr1[FirstArrayLocation];
				FirstArrayLocation++;
			}
		}
		System.out.println("mergeTwoArray ->" + Arrays.toString(mergeArr));
	}

	/**
	 * Given three sorted arrays, how will you sort all the three arrays into one array
	 */
	public static void mergeThreeArray() {
		List<Integer[]> arrays = new ArrayList<Integer[]>();
		arrays.add(new Integer[] { 10, 15, 17, 20 });
		arrays.add(new Integer[] { 5, 7, 11, 19, 22 });
		arrays.add(new Integer[] { 1, 8, 12 });

		Integer[] p = mergeArrays(arrays);
		System.out.print("mergeThreeArray -->" + Arrays.toString(p));
	}

	/**
	 * @param arrays
	 * @return
	 */
	private static Integer[] mergeArrays(List<Integer[]> arrays) {
		if (arrays == null || arrays.size() == 0) {
			return null;
		}
		Integer[] p;
		if (arrays.size() >= 2) {
			p = arrays.get(0);
			for (int i = 1; i < arrays.size(); i++) {
				p = merge(p, arrays.get(i));
			}
		} else {
			return arrays.get(0);
		}
		return p;
	}

	private static Integer[] merge(Integer[] a, Integer[] b) {
		Integer[] c = new Integer[a.length + b.length];
		int i = 0, j = 0, k = 0;

		while (i < a.length && j < b.length) {
			if (a[i] <= b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}

		while (i < a.length) {
			c[k++] = a[i++];
		}

		while (j < b.length) {
			c[k++] = b[j++];
		}

		return c;
	}
}
