/**
 * 
 */
package com.learning.basic.string;

/**
 * @author VINAY
 * 
 */
public class WordBreak {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean result = wordBreak("ilikesamsung");
		System.out.println("ilikesamsung : "+result);
		
		result = wordBreak("iiiiiiii");
		System.out.println("iiiiiiii : "+result);
		
		result = wordBreak("");
		System.out.println(" : "+result);
		
		result = wordBreak("ilikelikeimangoiii");
		System.out.println("ilikelikeimangoiii : "+result);
		
		result = wordBreak("samsungandmango");
		System.out.println("samsungandmango : "+result);
		
		result = wordBreak("samsungandmangok");
		System.out.println("samsungandmangok : "+result);
	}

	/**
	 * @param str
	 * @return
	 */
	static boolean wordBreak(String str) {
		int size = str.length();

		// Base case
		if (size == 0)
			return true;

		// Try all prefixes of lengths from 1 to size
		for (int i = 1; i <= size; i++) {
			// The parameter for dictionaryContains is str.substr(0, i)
			// str.substr(0, i) which is prefix (of input string) of
			// length 'i'. We first check whether current prefix is in
			// dictionary. Then we recursively check for remaining string
			// str.substr(i, size-i) which is suffix of length size-i
			if (dictionaryContains(str.substring(0, i))
					&& wordBreak(str.substring(i, size - i)))
				return true;
		}

		// If we have tried all prefixes and none of them worked
		return false;
	}

	/**
	 * @param word
	 * @return
	 */
	static boolean dictionaryContains(String word) {
		String dictionary[] = { "mobile", "samsung", "sam", "sung", "man",
				"mango", "icecream", "and", "go", "i", "like", "ice", "cream" };
		for (int i = 0; i < dictionary.length -1; i++)
			if (dictionary[i].compareTo(word) == 0)
				return true;
		return false;
	}
}
