/**
 * 
 */
package com.learning.basic.array;

/**
 * @author VINAY
 *
 */
public class NonRepeatingArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 3, 4, 1, 3, 1, 7, 2, 4 };

		System.out.println("Index : "+nonRepeatingElement(a));
		System.out.println("Value : "+a[nonRepeatingElement(a)]);
	}

	private static int nonRepeatingElement(int[] a) {
		int element = 0;

		for (int i = 0; i < a.length; i++) {
			element ^= a[i];
		}

		return element;
	}
}
