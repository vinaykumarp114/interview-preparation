/**
 * 
 */
package com.learning.basic.recursive;

/**
 * @author VINAY
 * 
 */
public class TestFibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(fibonacci(9));
		System.out.println(fibonacci2(9));
	}

	public static int fibonacci(int x) {
		if (x == 0) {
			return 0;
		} else if (x == 1) {
			return 1;
		}

		return fibonacci(x - 1) + fibonacci(x - 2);
	}

	public static int fibonacci2(int n) {
		if (n == 0) {
			return n;
		}
		int a = 1, b = 1;
		for (int i = 3; i <= n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
}
