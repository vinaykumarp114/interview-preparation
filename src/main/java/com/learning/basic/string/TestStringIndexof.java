/**
 * 
 */
package com.learning.basic.string;

import java.util.Hashtable;

/**
 * @author VINAY
 * 
 */
public class TestStringIndexof {

	public static void main(String[] args) {
		String source = "Hello World";
		System.out.println("Index Of : " + indexOf(source, "or"));
		System.out.println("Identify First Duplicate Occurance : "
				+ identifyFirstDuplicate("Vinay Kumar"));
		System.out.println("Identify First Non Duplicate Occurance : "
				+ identifyFirstNonDupilcate("Vinay Vijay"));
	}

	/**
	 * @param source
	 * @param target
	 * @return
	 */
	static int indexOf(String source, String target) {
		if (source != null && !"".equals(source) && target != null
				&& !"".equals(target)) {
			int fromIndex = 0;
			int sourceCount = source.length();
			int targetCount = target.length();

			char first = target.charAt(0);
			int max = sourceCount - targetCount;

			for (int i = fromIndex; i < sourceCount; i++) {
				if (source.charAt(i) != first) {
					while (++i <= max && source.charAt(i) != first)
						;
				}

				if (i <= max) {
					int j = i + 1;
					int end = j + targetCount - 1;

					for (int k = 1; j < end
							&& source.charAt(j) == target.charAt(k); j++, k++)
						;

					if (j == end) {
						/* Found whole string. */
						return i;
					}
				}
			}
		}

		return -1;
	}

	/**
	 * @param source
	 * @return
	 */
	static String identifyFirstDuplicate(String source) {
		String result = null;

		if (source != null && !"".equals(source)) {
			int start = 0;
			int end = source.length();

			for (int i = start; i < end; i++) {
				char temp = source.charAt(i);

				for (int j = i + 1; j < end; j++) {
					if (source.charAt(j) == temp) {
						return temp + "";
					}
				}
			}
		}
		return result;
	}

	/**
	 * @param source
	 * @return
	 */
	static String identifyFirstNonDupilcate(String source) {

		if (source == null || source.length() < 2) {
			return source;
		}

		int strLength = source.length();
		// create a new hashtable:
		Hashtable<Character, Integer> hashChar = new Hashtable<Character, Integer>();
		Integer intgr;

		for (int j = 0; j < strLength; j++) {
			char c = source.charAt(j);
			intgr = hashChar.get(c);
			if (intgr == null) {
				hashChar.put(c, new Integer(1));
			} else {
				hashChar.put(c, ++intgr);
			}
		}

		for (int j = 0; j < strLength; j++) {
			char c = source.charAt(j);
			if(hashChar.get(c) == 1){
				return ""+c;
			}
		}
		
		return "";
	}
}