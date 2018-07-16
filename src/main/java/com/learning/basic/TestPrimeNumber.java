/**
 * 
 */
package com.learning.basic;

/**
 * @author VINAY
 * 
 */
public class TestPrimeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestPrimeNumber primeNumber = new TestPrimeNumber();
		int start = 0;
		int end = 15;
		System.out.println("List of prime numbers between " + start + " and "
				+ end);
		for (int i = start; i <= end; i++) {
			if (primeNumber.isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	public boolean isPrime(int number) {
		int sqrt = (int) Math.sqrt(number) + 1;
		for (int i = 2; i < sqrt; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
