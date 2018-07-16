/**
 * 
 */
package com.learning.hackerrank;

import java.util.Scanner;

/**
 * @author VINAY
 *
 */
public class TestDouble {

	int[] testScores = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		if (in.hasNextLine()) {
			int size = in.nextInt();

			TestDouble testDouble = new TestDouble();
			testDouble.testScores = new int[size];

			int count = 0;
			while (size > 0 && in.hasNext()) {
				testDouble.testScores[count++] = in.nextInt();
				size--;
			}

			System.out.println(testDouble.calculate());
		}
		in.close();
	}

	public char calculate() {
		char result = ' ';

		double avg = 0;
		if (this.testScores != null && this.testScores.length > 0) {
			double sum = 0;
			for (Integer val : this.testScores) {
				sum += val;
			}

			avg = sum / this.testScores.length;
		}
		
		System.out.println(avg);

		if (avg >= 90) {
			result = 'O';
		} else if (avg >= 80 && avg < 90) {
			result = 'E';
		} else if (avg >= 70 && avg < 80) {
			result = 'A';
		} else if (avg >= 55 && avg < 70) {
			result = 'P';
		} else if (avg >= 40 && avg < 55) {
			result = 'D';
		} else {
			result = 'T';
		}

		return result;
	}
}
