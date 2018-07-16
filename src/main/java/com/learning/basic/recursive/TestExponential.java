/**
 * 
 */
package com.learning.basic.recursive;

/**
 * @author VINAY
 *
 */
public class TestExponential {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = exponentiation(5, 3);
		System.out.println("Exponential of 5 ^ 3 = "+result);
	}

	/**
	 * 5^3 = 5 * 5 * 5
	 * 
	 * @param n
	 * @param p
	 * @return
	 */
	static int exponentiation(int n, int p) {
		if (p <= 0) {
			return 1;
		} else {
			return n * exponentiation(n, p - 1);
		}
	}

}
