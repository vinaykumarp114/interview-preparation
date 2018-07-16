/**
 * 
 */
package com.learning.basic.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author VINAY
 *
 */
public class RotateMatrixCircle90 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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

	private static int[][] rotate(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix.length == 1) {
			return matrix;
		}

		int len = matrix.length;
		
		List<Integer> outercircle = getOuterCircle(matrix);
		matrix = removeOuter(matrix);
		
		for(int i = 0; i < len - 1 ; i++){
			outercircle.add(0, outercircle.remove(outercircle.size() - 1));
		}
		
		matrix = rotate(matrix);
		matrix = addOuterCircle(outercircle, matrix);

		return matrix;
	}

	private static int[][] addOuterCircle(List<Integer> outercircle, int[][] matrix) {
		int len = matrix.length + 2;
		int[][] result = new int[len][len];

		for (int col = 0; col < len; col++) {
			result[0][col] = outercircle.remove(0);
		}

		for (int row = 1; row < len; row++) {
			result[row][len - 1] = outercircle.remove(0);
		}

		for (int col = len - 2; col >= 0; col--) {
			result[len - 1][col] = outercircle.remove(0);
		}

		for (int row = len - 2; row >= 1; row--) {
			result[row][0] = outercircle.remove(0);
		}

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix.length; col++) {
				result[row + 1][col + 1] = matrix[row][col];
			}
		}

		return result;
	}

	private static List<Integer> getOuterCircle(int[][] matrix) {
		int len = matrix.length;
		List<Integer> outercircle = new ArrayList<Integer>();

		for (int col = 0; col < len; col++) {
			outercircle.add(matrix[0][col]);
		}

		for (int row = 1; row < len; row++) {
			outercircle.add(matrix[row][len - 1]);
		}

		for (int col = len - 2; col >= 0; col--) {
			outercircle.add(matrix[len - 1][col]);
		}

		for (int row = len - 2; row >= 1; row--) {
			outercircle.add(matrix[row][0]);
		}

		return outercircle;
	}

	private static int[][] removeOuter(int[][] matrix) {
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
