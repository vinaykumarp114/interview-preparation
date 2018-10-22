/**
 * 
 */
package com.learning.basic.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author vinay
 * 
 *         Michelle has created a word game for her students. The word game
 *         begins with Michelle writing a string and a number, K, on th board.
 *         The student has to find sub strings of size K with the K distinct
 *         character.
 * 
 *         Write a program to help the students find the correct answer. If the
 *         given string does not have K distinct characters then the output an
 *         empty list.
 * 
 *         Input: The input to the function/method consist of two arguments -
 *         inputStr, representing the string written by teacher; num, an integer
 *         representing the number, K, written by the teacher on the board.
 * 
 *         Output: Return distinct string of an input string of the size K with
 *         K distinct character
 * 
 *         Example: Input : inputStr = awaglknagawunagwkwagl, num = 4 Output:
 *         {wagl, aglk, glkn, lkna, knag, gawu, awun, wuna, unag, nagw, agwk,
 *         kwag}
 * 
 *         Input: inputStr = abcd, num = 3 Output: {abc, bcd}
 * 
 */
public class SubStringAndDistinct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "abcd";
		int num = 3;
		List<String> output = listofStringArray(input, num);
		System.out.println("Output 1 -> "+output);
		
		input = "awaglknagawunagwkwagl";
		num = 4;
		output = listofStringArray(input, num);
		System.out.println("Output 2 -> "+output);
	}

	static List<String> listofStringArray(String inputStr, int num) {
		List<String> output = new ArrayList<>();
		
		if(inputStr == null || inputStr.isEmpty() || inputStr.length() < num) {
			return Collections.emptyList();
		}
		
		int size = inputStr.length() - num;
		
		for(int i =0; i <= size; i++) {
			String s1 = inputStr.substring(i,  i+num);
			char[] c = s1.toCharArray();
			boolean flag = checkDuplicateChar(c);
			if(!flag && !output.contains(s1)) {
				output.add(s1);
			}
		}		
		return output;
	}
	
	static boolean checkDuplicateChar(char[] cs) {
		Set<String> hashSet = new HashSet<>();
		for(Character c: cs) {
			if(!hashSet.add(""+c)) {
				return true;
			}
		}
		return false;
	}
}
