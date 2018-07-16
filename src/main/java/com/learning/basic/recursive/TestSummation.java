/**
 * 
 */
package com.learning.basic.recursive;

/**
 * @author VINAY
 *
 */
public class TestSummation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int result = summation(5);
		System.out.println("Summation of 5 : "+result);
		result = summation(3);
		System.out.println("Summation of 3 : "+result);
	}

	/**
	 * 5 => 5+4+3+2+1
	 * 3 => 3+2+1
	 * 
	 * @param x
	 * @return
	 */
	static int summation(int x) {
		if (x <= 0) {
			return 0;
		} else {
			return x + summation(x - 1);
		}
	}
}
