/**
 * 
 */
package com.learning.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Calculate the hour glass sum for every hour glass in A, then print the
 * maximum hour glass sum.
 * 
 * Input Format : There are 6 lines of input, where each line contains 6
 * space-separated integers describing 2D Array A; every value in A will be in
 * the inclusive range of -9 to 9.
 * 
 * Output Format: Print the largest (maximum) hour glass sum found in A.
 * 
 * https://www.hackerrank.com/challenges/30-2d-arrays
 * 
 * @author VINAY
 *
 */
public class ArrayHourGlass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		if (in.hasNext()) {
			int size = in.nextInt();
			int[][] matrix = new int[size][size];

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					matrix[i][j] = in.nextInt();
				}
			}

			int maxValue = getMaxHoursGlass(matrix);
			System.out.println(maxValue);
		}

		in.close();
	}

	static int getMaxHoursGlass(int[][] matrix) {
		int result = Integer.MIN_VALUE;

		int rows = (matrix.length / 2) + 1;
		int cols = (matrix[0].length / 2) + 1;

		int[][] hoursglass = new int[3][3];

		for (int rowpos = 0; rowpos < rows; rowpos++) {
			for (int colpos = 0; colpos < cols; colpos++) {
				hoursglass = getHoursGlass(rowpos, colpos, matrix);
				System.out.print(Arrays.deepToString(hoursglass));
				int temp = calculateSum(hoursglass);
				System.out.println(" = "+temp);
				if(result < temp){
					result = temp;
				}
			}
		}

		return result;
	}

	static int[][] getHoursGlass(int rowpos, int colpos, int[][] matrix) {
		int rowsize = rowpos + 2;
		int colsize = colpos + 2;

		int[][] hoursglass = new int[3][3];
		
		int rowCnt = 0;
		int colCnt = 0;

		if (rowsize < matrix.length && colsize < matrix[0].length) {
			for (int i = rowpos; i <= rowsize; i++) {
				for (int j = colpos; j <= colsize; j++) {
					if(rowCnt == 1 && (colCnt == 0 || colCnt == 2)) {
						hoursglass[rowCnt][colCnt++] = 0;
					} else {
						hoursglass[rowCnt][colCnt++] = matrix[i][j];
					}
				}
				colCnt = 0;
				rowCnt++;
			}
		}

		return hoursglass;
	}

	static int calculateSum(int[][] matrix) {
		int sum = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				sum += matrix[i][j];
			}
		}

		return sum;
	}
}
