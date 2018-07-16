/**
 * 
 */
package com.learning.basic.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column is set to 0.
 * 
 * @author VINAY
 *
 */
public class MatrixValueZero {

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

		matrix = setZeros(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		s.close();
	}

	static int[][] setZeros(int[][] matrix) {
		int[] row = new int[matrix.length];
		int[] col = new int[matrix[0].length];
		
		for(int i=0; i < matrix.length; i++){
			for(int j=0; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		System.out.println("Rows : "+Arrays.toString(row));
		System.out.println("Columns : "+Arrays.toString(col));
		// Set arr[i][j] to 0 if either row i or column j has a 0
		for(int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if ((row[i] == 1 || col[j] == 1)) {
					matrix[i][j] = 0;
				}
			}
		}
		
		return matrix;
	}

}
