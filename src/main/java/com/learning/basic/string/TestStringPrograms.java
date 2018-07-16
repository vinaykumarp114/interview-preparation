/**
 * 
 */
package com.learning.basic.string;

/**
 * @author VINAY
 *
 */
public class TestStringPrograms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "";
		String s2 = "";

		s1 = "1011000011";
		s2 = "1101110001";
		System.out.println("Compare 2 String index : " + maxIndex(s1, s2));

		s1 = "ABCDEFGH";
		s2 = "PFGRACBT";
		System.out.println("Count 1: " + maxCharSeqCount(s1, s2));
		s1 = "ABCDEFGH";
		s2 = "PFGRABCT";
		System.out.println("Count 2: " + maxCharSeqCount(s1, s2));
		s1 = "ABCDEFGH";
		s2 = "AEFGBCABCD";
		System.out.println("Count 3: " + maxCharSeqCount(s1, s2));

		s1 = "10110111110111101";
		System.out.println("String index of Max 1's in between 0's: " + maxIndexZero(s1));

		s1 = "11110000001";
		System.out.println("String index of Max 1's in between 0's: " + maxIndexZero(s1));
		
		s1 = "0100000001";
		System.out.println("String index of Max 1's in between 0's: " + maxIndexZero(s1));
	}

	public static int maxIndex(String s1, String s2) {
		int max = 0;

		int length = s1.length();
		int sumS1 = 0;
		int sumS2 = 0;

		for (int i = 0; i < length; i++) {
			if (i < s1.length()) {
				sumS1 += Integer.parseInt("" + s1.charAt(i));
			}
			if (i < s2.length()) {
				sumS2 += Integer.parseInt("" + s2.charAt(i));
			}

			if (sumS1 == sumS2) {
				max = i;
			}
		}

		return max;
	}

	public static int maxCharSeqCount(String s1, String s2) {
		int count = 0;

		int length = s2.length();
		int prevIdx = -1;

		String temp = "";
		char c = ' ';

		for (int i = 0; i < length; i++) {
			c = s2.charAt(i);

			if (s1.contains("" + c)) {
				if (prevIdx < s1.indexOf("" + c)) {
					prevIdx = s1.indexOf("" + c);
					temp += c;
					continue;
				}
			}

			if (temp.length() > 1 && temp.length() > count) {
				count = temp.length();
			}
			temp = "";
			prevIdx = -1;
		}

		return count;
	}

	public static int maxIndexZero(String input) {
		int result = -1;
		int len = input.length();
		int count = 0;
		int temp = 0;
		int indx = 0;

		for (int i = 0; i < len; i++) {
			if (input.charAt(i) == '0') {
				if (temp > count) {
					count = temp;
					result = indx + 1;
					temp = 0;
				}

				indx = i;
				while ((i + 1) < len && input.charAt(i + 1) == '1') {
					temp++;
					i++;
				}
			}
		}

		return result;
	}
}
