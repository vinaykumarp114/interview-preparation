/**
 * 
 */
package com.learning.basic.recursive;

/**
 * @author viap
 * 
 */
public class TestFactorial {

	static int y = 4;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factorial factorial = new Factorial();

		int x = factorial.fact(y);
		System.out.println("x value : " + x);

		int z = factorial.factIter(y);
		System.out.println("z value : " + z);
	}

}

class Factorial {
	public int fact(int x) {
		if (x < 1)
			return 1;
		else
			return x * fact(x - 1);
	}

	public int factIter(int y) {
		int result = 1;
		for (int i = 1; i <= y; i++) {
			result = result * i;
		}
		return result;
	}
}