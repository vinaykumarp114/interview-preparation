/**
 * 
 */
package com.learning.basic.search;

import java.util.Arrays;

/**
 *
 */
public class ArraySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		searchInt();
		searchString();
	}

	/**
	 * Given a sorted array of n integers that has been rotated an unknown
	 * number of times, give an O(log n) algorithm that finds an element in the
	 * array. You may assume that the array was originally sorted in increasing
	 * order.
	 * 
	 * EXAMPLE:	 * 
	 * Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14) 
	 * Output: 8 (the index of 5 in the array)
	 */
	public static void searchInt() {
		int[] a = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
		int k = 25;
		
		int result = search(a, k);
		System.out.println("Input : "+Arrays.toString(a));
		System.out.println("Output Index : "+result);
	}
	
	private static int search(int[] a, int k) {
		int indx = -1;
		int left = 0;
		int right = a.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (k == a[mid]) {
				return mid;
			} else if (a[left] <= a[mid]) {
				if (k > a[mid]) {
					left = mid + 1;
				} else if (k >= a[left]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (k < a[mid]) {
				right = mid - 1;
			} else if (k <= a[right]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return indx;
	}	
	
	/**
	 * Given a sorted array of strings which is interspersed with empty strings,
	 * write a method to find the location of a given string. 
	 * 
	 * Example: 
	 * find �ball� in [�at�, ��, ��, ��, �ball�, ��, ��, �car�, ��, ��, �dad�, ��, ��] will return 4 
	 * Example: 
	 * find �ballcar� in [�at�, ��, ��, ��, ��, �ball�, �car�, ��, ��, �dad�, ��, ��] will return -1
	 */
	public static void searchString() {
		String[] input = {"at", "","","","ball","","","car","","","dad","",""};
		String key = "ball";
		int result = searchString(input, key);
		System.out.println("Input : "+Arrays.toString(input));
		System.out.println("Output Index : "+result);
		
		String[] input1 = {"at", "","","","ball","car","","","","dad","",""};
		key = "ballcar";
		result = searchString(input1, key);
		System.out.println("Input : "+Arrays.toString(input1));
		System.out.println("Output Index : "+result);
	}
	
	private static int searchString(String[] input, String key){
		int indx = -1;
		int left = 0;
		int right = input.length - 1;
		
		while(left <= right){
			while(left <= right && input[--right] == "");
			
			if(right < left){
				return indx;
			}
			
			int mid = (left + right) / 2;
			
			while (mid < right  && input[mid] == "") {
				++mid;
			}
			
			int r = input[mid].compareTo(key);
			if(r == 0){
				return mid;
			} 
			if (r < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}		
		return indx;
	}
	
	/**
	 * Given a matrix in which each row and each column is sorted, write a
	 * method to find an element in it.
	 */
	boolean findElement(int[][] matrix, int elem, int m, int n) {
		int row = 0;
		int col = n - 1;
		
		while(row <= col){
			if(matrix[row][col] == elem){
				return true;
			} else if(matrix[row][col] > elem){
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
}