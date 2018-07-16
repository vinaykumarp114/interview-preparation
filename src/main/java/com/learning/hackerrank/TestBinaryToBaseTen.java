package com.learning.hackerrank;

import java.util.Scanner;

/**
 * Given a binary (base-2) number, n, convert it to base-10. Then find and print
 * the base-10 integer denoting.
 * 
 * Input Format: A binary number, n Output Format: Print a single base-10
 * integer. Example: 
 * Sample Input - 101 Sample Output - 5 
 * Sample Input - 1111 Sample Output - 15
 * 
 * https://www.hackerrank.com/challenges/30-binary-numbers/tutorial
 * 
 * @author VINAY
 *
 */
public class TestBinaryToBaseTen {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNext()) {
			String binary = scanner.next();
			System.out.println("Binary Input : " + binary);
			int baseTen = convertBinaryToBaseTen(binary);
			System.out.println("Base 10 Output : " + baseTen);
		}
		scanner.close();
	}

	/**
	 * @param binary
	 * @return
	 */
	static int convertBinaryToBaseTen(String binary) {
		int result = 0;
		int n = 2;
		int len = binary.length();
		int count = 0;

		for (int i = len - 1; i >= 0; i--) {
			if (Integer.parseInt("" + binary.charAt(i)) == 1) {
				result += exponential(n, count);
			}
			count++;
		}

		return result;
	}

	/**
	 * @param n
	 * @param p
	 * @return
	 */
	static int exponential(int n, int p) {
		if (p <= 0) {
			return 1;
		}
		return n * exponential(n, p - 1);
	}
}
