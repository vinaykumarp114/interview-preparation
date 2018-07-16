/**
 * 
 */
package com.learning.basic.string;

import java.util.Arrays;

/**
 * @author viap
 * 
 */
public class TestString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String strReverse = "vinay";
		reverseString(strReverse);
		checkInstance();

		char[] str = removeDuplicates("FOLLOW UP".toCharArray());
		System.out.println("After Remove : " + Arrays.toString(str));

		char[] str1 = replaceSpace("FOLLOW UP".toCharArray());
		System.out.println("After Replace : " + Arrays.toString(str1));

		String s1 = "Hello Word";		
		String s2 = s1.substring(0, 3);
		System.out.println("SubString : " + s2);
		CharSequence c1 = s1.subSequence(0, 4);
		System.out.println("CharSequence : " + c1);
	}

	/**
	 * Reverse String
	 * 
	 * @param strReverse
	 */
	static void reverseString(String strReverse) {
		String reverseStr = "";
		System.out.println("String length : " + strReverse.length());
		for (int i = strReverse.length() - 1; i >= 0; i--) {
			reverseStr += strReverse.charAt(i);
		}
		System.out.println("Reverse String value : " + reverseStr);
		reverseStr = "";
		for (int i = 0; i < strReverse.length(); i++) {
			reverseStr = strReverse.charAt(i) + reverseStr;
		}
		System.out.println("Reverse String value 1 : " + reverseStr);
	}

	/**
	 * Check Instance and References
	 */
	static void checkInstance() {
		String s1 = "A";
		String s2 = s1;
		String s3 = new String("A");
		String s4 = s3;

		System.out.println("s1 == s2 : " + (s1 == s2));
		System.out.println("s1.equals(s2) : " + (s1.equals(s2)));
		System.out.println("s1 == s3 : " + (s1 == s3));
		System.out.println("s1.equals(s3) : " + (s1.equals(s3)));
		System.out.println("s1 == s4 : " + (s1 == s4));
		System.out.println("s1.equals(s4) : " + (s1.equals(s4)));
		System.out.println("s2 == s3 : " + (s2 == s3));
		System.out.println("s2.equals(s3) : " + (s2.equals(s3)));
		System.out.println("s2 == s4 : " + (s2 == s4));
		System.out.println("s2.equals(s4) : " + (s2.equals(s4)));
		System.out.println("s3 == s4 : " + (s3 == s4));
		System.out.println("s3.equals(s4) : " + (s3.equals(s4)));

		s4 = s1;
		System.out.println("s1 == s4 : " + (s1 == s4));
		System.out.println("s1.equals(s4) : " + (s1.equals(s4)));

		s4 = s3;
		s3 = s1;
		System.out.println("s1 == s3 : " + (s1 == s3));
		System.out.println("s4 == s3 : " + (s4 == s3));
		System.out.println("s1.equals(s3) : " + (s1.equals(s3)));
	}

	/**
	 * Design an algorithm and write code to remove the duplicate characters in
	 * a string without using any additional buffer. NOTE: One or two additional
	 * variables are fine
	 * 
	 * An extra copy of the array is not. FOLLOW UP
	 * 
	 * @param str
	 */
	public static char[] removeDuplicates(char[] str) {
		if (str == null || str.length < 2) {
			return str;
		}

		int tail = 1;

		for (int i = 1; i < str.length; ++i) {
			int j = 0;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j]) {
					break;
				}
			}

			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}

		char[] result = new char[tail];
		System.arraycopy(str, 0, result, 0, tail);

		return result;
	}

	/**
	 * Write a method to replace all spaces in a string with �%20�.
	 * 
	 * @param str
	 * @return
	 */
	public static char[] replaceSpace(char[] str) {
		char[] result = str;

		if (str == null || str.length < 2) {
			return result;
		}

		int spaceCount = 0, newLength = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}

		newLength = str.length + spaceCount * 2;
		result = new char[newLength];
		for (int j = str.length - 1; j >= 0; j--) {
			if (str[j] == ' ') {
				result[newLength - 1] = '0';
				result[newLength - 2] = '2';
				result[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				result[newLength - 1] = str[j];
				newLength = newLength - 1;
			}
		}

		return result;
	}

	/**
	 * Assume you have a method isSubstring which checks if one word is a
	 * substring of another. Given two strings, s1 and s2, write code to check
	 * if s2 is a rotation of s1 using only one call to isSubstring (i.e.,
	 * �waterbottle� is a rotation of �erbottlewat�).
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isRotation(String s1, String s2) {
		boolean flag = false;

		if (s1 != null && s2 != null && !s1.isEmpty() && !s2.isEmpty()) {
			/* concatenate s1 and s1 within new buffer */
			String s1s1 = s1 + s1;
			if (s1.length() == s2.length()) {
				flag = s1s1.contains(s2);
				// flag = isSubstring(s1s1, s2);
			}
		}

		return flag;
	}
}