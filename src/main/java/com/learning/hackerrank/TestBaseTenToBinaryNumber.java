package com.learning.hackerrank;

import java.util.Scanner;

/**
 * Given a base-10 integer, n, convert it to binary (base-2). Then find and print
 * the base-10 integer denoting the maximum number of consecutive 1's in n's binary
 * representation.
 * 
 * Input Format: A single integer, n 
 * Output Format: Print a single base-10 integer denoting the maximum number of consecutive 1's in the binary representation of n.
 * Example:
 * 	Sample Input - 5	Sample Output - 1
 * 	Sample Input - 13	Sample Output - 2
 * 	
 * https://www.hackerrank.com/challenges/30-binary-numbers/tutorial
 * 
 * @author VINAY
 *
 */
public class TestBaseTenToBinaryNumber {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNext()) {
			int input = scanner.nextInt();
			System.out.println("Base 10 Input : "+input);
			String val = getBinaryValue(input);
			System.out.println("Binary Num : "+val);
			int result = getMaxConsecutiveOne(val);

			System.out.println("Max Consecutive One : "+result);
		}
		scanner.close();
	}

	static String getBinaryValue(int input) {

		if (input <= 1) {
			return Integer.toString(input);
		}

		int reminder = input % 2;
		int div = input / 2;

		return getBinaryValue(div) + reminder;
	}

	static int getMaxConsecutiveOne(String input) {
		int result = 0;

		if (input != null && !input.isEmpty()) {
			int length = input.length();
			int count = 1;
			for (int i = 0; i < length; i++) {
				char c = input.charAt(i);
				if (c == '1') {
					while ((i + 1) < length && c == input.charAt(i + 1)) {
						i++;
						++count;
					}
					if (result < count) {
						result = count;
					}
				} else {
					count = 1;
				}
			}
		}

		return result;
	}

}
