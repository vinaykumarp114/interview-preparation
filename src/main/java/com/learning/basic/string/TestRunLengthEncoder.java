/**
 * 
 */
package com.learning.basic.string;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author VINAY
 * 
 */
public class TestRunLengthEncoder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String value = "aaaabbcddde";
		String encodeValue = encodeString(value);
		System.out.println("Encode Value : " + encodeValue);
		String decodeValue = decodeString(encodeValue);
		System.out.println("Decode Value : " + decodeValue);
	}

	/**
	 * @param source
	 * @return
	 */
	public static String encodeString(String source) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < source.length(); i++) {
			int runLength = 1;
			while (i + 1 < source.length()
					&& source.charAt(i) == source.charAt(i + 1)) {
				runLength++;
				i++;
			}
			
			result.append(source.charAt(i));
			result.append(runLength);
		}
		return result.toString();
	}

	/**
	 * @param value
	 * @return
	 */
	static String decodeString(String value) {
		int count = 0;
		char temp = ' ';
		char current = ' ';
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < value.length(); i++) {
			current = value.charAt(i);
			if (Character.isDigit(current)) {
				count = Integer.parseInt("" + current);
				while (count > 0) {
					result.append(temp + "");
					--count;
				}
				continue;
			}
			temp = current;
		}
		return result.toString();
	}

	/**
	 * @param source
	 * @return
	 */
	public static String decode(String source) {
		StringBuffer result = new StringBuffer();
		Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
		Matcher matcher = pattern.matcher(source);
		while (matcher.find()) {
			int number = Integer.parseInt(matcher.group());
			matcher.find();
			while (number-- != 0) {
				result.append(matcher.group());
			}
		}
		return result.toString();
	}

	
	/**
	 * @param src
	 * @param delimiter
	 * @return
	 */
	static List<String> splitValue(String src, String delimiter) {
		String[] val = src.split(delimiter);
		return Arrays.asList(val);
	}
}
