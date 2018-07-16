/**
 * 
 */
package com.learning.basic.array;

/**
 * @author VINAY
 * 
 */
public class TestArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printSecondHighest();
		findMissingNumber();
		findMissingNumbers();
		
		String[] input = {"1","2","3", "4"};
		String output = loopArray(input, input.length -1);
		System.out.println("Array Recursive : "+output);
	}

	/**
	 * http://java-espresso.blogspot.com/2011/04/tricky-java-question-finding-
	 * missing.html
	 */
	private static void findMissingNumber() {
		// in the below jumbles series of 1-10, 7 is missing
		int[] val = new int[] { 9, 4, 5, 1, 10, 2, 6, 3, 8 };

		int sumOurSeries = 0;
		for (int i = 0; i < val.length; ++i) {
			sumOurSeries += val[i];
		}

		// sum = N * (N + 1) / 2 where N = 10
		int sumNaturalNumbers = 10 * (10 + 1) / 2;

		System.out.println("Sum of our series: " + sumOurSeries);
		System.out.println("missing number = "+ (sumNaturalNumbers - sumOurSeries));
	}

	public static void findMissingNumbers() {
		// two numbers are missing: 2, 6, 10
		int a[] = { 3, 5, 7, 1, 4, 8, 9 };
		int countOfMissingDigits = 3;
		int b[] = new int[a.length + countOfMissingDigits];
		for (int i = 0; i < a.length; i++) {
			b[(a[i] - 1)] = a[i];
		}
		for (int i = 0; i < b.length; i++) {
			if (b[i] == 0) {
				System.out.println("missing numbers = " + (i + 1));
			}
		}
	}

	private static void printSecondHighest() {
		int[] val = new int[] { 101, 12, 56, 65, 10, 50, 100 };
		
		int first = 0;
		int second = 0;
		
		for (Integer i : val) {
			if (i > first) {
				second = first;
				first = i;
			} else if (i > second) {
				second = i;
			}
		}

		System.out.println("First : " + first + " , Second : " + second);
	}
	
	private static String loopArray(String[] input, int size){
		String output = "";
		if(size < 0){
			return "";
		}
		output  = input[size] + "," +loopArray(input, size-1);
		return output;
	}
}
