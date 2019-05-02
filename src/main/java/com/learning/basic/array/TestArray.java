/**
 * 
 */
package com.learning.basic.array;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author VINAY
 * 
 */
public class TestArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Find the two repeating elements in a given array
		int[] a = new int[] { 1, 2, 4, 7, 2, 3 };
		printRepeating(a);
		a = new int[] { 3, 1 };
		printRepeating(a);

		int[] val = generateRandomNumber();

		LocalDateTime start = LocalDateTime.now();
		printSecondHighest(val);
		LocalDateTime end = LocalDateTime.now();
		long t1 = ChronoUnit.NANOS.between(start, end);
		System.out.println("Time take ->  printSecondHighest:: " + t1);

		start = LocalDateTime.now();
		printSecondHighestPerf(val);
		end = LocalDateTime.now();
		long t2 = ChronoUnit.NANOS.between(start, end);
		System.out.println("Time take ->  printSecondHighestPerf :: " + t2);

		findMissingNumber();
		findMissingNumbers();

		String[] input = { "1", "2", "3", "4" };
		String output = loopArray(input, input.length - 1);
		System.out.println("Array Recursive : " + output);
	}

	private static void printRepeating(int[] a) {
		System.out.println("Print two repeating elements in a given array - Method1 ");
		Set<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			if (!hashSet.add(a[i])) {
				System.out.println("Index ::" + i + " - val:: " + a[i]);
			}
		}
		
		System.out.println("Print two repeating elements in a given array - Method2 ");
		int[] count = new int[10];
		for (int i = 0; i < a.length; i++) {
			if(count[a[i]] == 1) {
				System.out.println("Index ::" + i + " - val:: " + a[i]);
			} else {
				count[a[i]]++;
			}			
		}
	}

	/**
	 * 
	 */
	private static int[] generateRandomNumber() {
		Random r = new Random();
		int i = 0;
		int[] val = new int[10000000];

		while (i < 10000000) {
			val[i] = r.nextInt(10000000);
			i++;
		}
		return val;
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
		System.out.println("missing number = " + (sumNaturalNumbers - sumOurSeries));
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

	private static void printSecondHighest(int[] val) {
		int first = 0;
		int second = 0;

		for (Integer j : val) {
			if (j > first) {
				second = first;
				first = j;
			} else if (first > j && j > second) {
				second = j;
			}
		}

		System.out.println("First : " + first + " , Second : " + second);
	}

	private static void printSecondHighestPerf(int[] val) {
		int first = 0;
		int second = 0;

		int left = 0;
		int right = val.length - 1;

		while (left <= right) {
			int res = val[left] > val[right] ? val[left] : val[right];

			if (res > first) {
				if (second == 0 && first == 0) {
					second = val[left] < res ? val[left] : val[right] < res ? val[right] : second;
				} else {
					second = first;
				}
				first = res;
			} else if (first < res && res > second) {
				second = res;
			}

			left++;
			right--;
		}

		System.out.println("First : " + first + " , Second : " + second);
	}

	private static String loopArray(String[] input, int size) {
		String output = "";
		if (size < 0) {
			return "";
		}
		output = input[size] + "," + loopArray(input, size - 1);
		return output;
	}
}
