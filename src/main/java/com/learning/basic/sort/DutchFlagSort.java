/**
 * 
 */
package com.learning.basic.sort;

import java.util.Arrays;

/**
 * @author VINAY
 *         http://codesam.blogspot.com/2011/04/sorting-array-of-three-kinds
 *         -or-dutch.html
 * 
 */
public class DutchFlagSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inArray = { 1, 2, 0, 2, 1 };
		System.out.println("Initial : " + Arrays.toString(inArray));
		DutchFlagSort dutchFlagSort = new DutchFlagSort();
		dutchFlagSort.dutchFlagSort(inArray, 2, 0);
		System.out.println("Final : " + Arrays.toString(inArray));
	}

	/**
	 * @param inArray
	 * @param arraySize
	 * @param high
	 * @param low
	 */
	void dutchFlagSort(int inArray[], int high, int low) {
		int arraySize = inArray.length;
		if (arraySize == 0)
			return;

		int lower = 0;
		while (inArray[lower] == low && lower < arraySize) {
			lower++;
		}

		int upper = arraySize - 1;
		while (inArray[upper] == high && upper >= 0) {
			upper--;
		}
		for (int pivot = lower; pivot <= upper;) {
			if (inArray[pivot] == low) {
				inArray = swap(inArray, pivot, lower);
				pivot++;
				lower++;
			} else if (inArray[pivot] == high) {
				inArray = swap(inArray, pivot, upper);
				upper--;
			} else
				pivot++;
		}
	}

	int[] swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return array;
	}
}
