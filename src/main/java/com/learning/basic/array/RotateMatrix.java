package com.learning.basic.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * http://www.geeksforgeeks.org/amazon-interview-experience-set-202/
 * 
 * https://github.com/lotif/rotateMatrix/blob/master/RotateMatrix.java
 * 
 * Rotate/Shift the elements of a square array clockwise by one at a time. (Not
 * by 90 degrees, but by one element. Think of concentric circles)
 * 
 * The first line of input will be a number indicating how many rows are in the
 * matrix. This will be followed by lines of input one for each row of the
 * matrix each row will contain the same number of columns with each column
 * separated by a space. 
 * 
 * Example:
 * 3
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * 
 * Output:
 * 4 1 2
 * 7 5 3
 * 8 9 6
 * 
 * @author VINAY
 *
 */
public class RotateMatrix {

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);

		int d = s.nextInt();

		int[][] matrix = new int[d][d];
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {
				matrix[i][j] = Integer.parseInt(s.next());
			}
		}

		matrix = rotate(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		s.close();
	}

	/**
	 * @param matrix
	 * @return
	 */
	public static int[][] rotate(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix.length == 1) {
			return matrix;
		}
		
		List<Integer> outerCircle = getOuterCircle(matrix);
		matrix = removeOuterCircle(matrix);

		outerCircle.add(0, outerCircle.remove(outerCircle.size() - 1));

		matrix = rotate(matrix);

		matrix = addOuterCircle(outerCircle, matrix);

		return matrix;
	}

	/**
	 * @param outerCircle
	 * @param matrix
	 * @return
	 */
	private static int[][] addOuterCircle(List<Integer> outerCircle, int[][] matrix) {
		int len = matrix.length + 2;
		int[][] result = new int[len][len];

		for (int col = 0; col < len; col++) {
			result[0][col] = outerCircle.remove(0);
		}

		for (int row = 1; row < len; row++) {
			result[row][len - 1] = outerCircle.remove(0);
		}

		for (int col = len - 2; col >= 0; col--) {
			result[len - 1][col] = outerCircle.remove(0);
		}

		for (int row = len - 2; row >= 1; row--) {
			result[row][0] = outerCircle.remove(0);
		}

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix.length; col++) {
				result[row + 1][col + 1] = matrix[row][col];
			}
		}

		return result;
	}

	/**
	 * @param matrix
	 * @return
	 */
	private static List<Integer> getOuterCircle(int[][] matrix) {
		int len = matrix.length;
		List<Integer> outerCircle = new ArrayList<Integer>();

		for (int col = 0; col < len; col++) {
			outerCircle.add(matrix[0][col]);
		}

		for (int row = 1; row < len; row++) {
			outerCircle.add(matrix[row][len - 1]);
		}

		for (int col = len - 2; col >= 0; col--) {
			outerCircle.add(matrix[len - 1][col]);
		}

		for (int row = len - 2; row >= 1; row--) {
			outerCircle.add(matrix[row][0]);
		}

		return outerCircle;
	}

	/**
	 * @param matrix
	 * @return
	 */
	private static int[][] removeOuterCircle(int[][] matrix) {
		int len = matrix.length;
		int[][] result = new int[len - 2][len - 2];

		for (int row = 1; row < len - 1; row++) {
			for (int col = 1; col < len - 1; col++) {
				result[row - 1][col - 1] = matrix[row][col];
			}
		}

		return result;
	}
}