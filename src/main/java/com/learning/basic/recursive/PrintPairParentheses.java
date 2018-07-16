/**
 * 
 */
package com.learning.basic.recursive;

/**
 * @author VINAY
 *
 */
public class PrintPairParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int pair = 3;
		
		char[] a = new char[pair * 2];
		printPar(pair, pair, a, 0);
		System.out.println(a);
	}
	
	static void printPar(int left, int right, char[] a, int count){
		if(left < 0 || right < 1){
			return;
		}
				
		if(left > 0){ // try a left parentheses, if there are some available
			a[count] = '(';
			printPar(left - 1, right, a, count + 1);
		}
		if(right > 1){ // try a right parentheses, if there�s a matching left
			a[count] = ')';
			printPar(left, right - 1, a, count + 1);
		}
	}
}