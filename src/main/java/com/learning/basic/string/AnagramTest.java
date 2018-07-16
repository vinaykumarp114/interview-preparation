/**
 * 
 */
package com.learning.basic.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * http://www.java-fries.com/2014/05/check-if-two-strings-are-anagrams-or-not/
 * 
 * @author VINAY
 * 
 */
public class AnagramTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "rat";
		String str2 = "art";
		Anagram1 anagram1 = new Anagram1();
		if (anagram1.isAnagram(str1, str2)) {
			System.out.println(str2 + " is anagram of " + str1);
		} else {
			System.out.println("Strings are not anagrams.");
		}

		List<String> values = anagram1.getAnagram("ARMY");
		System.out.println("Construct Anagram : " + values.toString());

		Anagram2 anagram2 = new Anagram2();
		if (anagram2.isAnagram(str1, str2)) {
			System.out.println(str2 + " is anagram of " + str1);
		} else {
			System.out.println("Strings are not anagrams.");
		}
	}
}

class Anagram1 {
	/**
	 * Checks if two strings are anagrams.
	 * 
	 * @param str1
	 *            , not null
	 * @param str2
	 *            , not null
	 * 
	 * @return true if <code>str1</code> and <code>str2</code> are anagram
	 */
	boolean isAnagram(String str1, String str2) {

		// If string lengths are not same, the strings are not anagrams.
		if (str1.length() != str2.length()) {
			return false;
		}

		// Sort characters of both the strings.
		str1 = sortCharacters(str1.toLowerCase());
		str2 = sortCharacters(str2.toLowerCase());

		// After sorting if strings are equal then they are anagrams.
		if (str1.equals(str2)) {
			return true;
		}
		return false;
	}

	/**
	 * Sorts characters of string and returns new string with sorted characters.
	 * 
	 * @param str
	 *            , not null
	 * @return string with sorted characters
	 */
	String sortCharacters(String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return String.valueOf(charArray);
	}

	/**
	 * @param s1
	 * @return
	 */
	public List<String> getAnagram(String s1) {
		List<String> result = new ArrayList<String>();
		anag(s1, "", result);
		return result;
	}

	/**
	 * @param s1
	 * @param s2
	 * @param addData
	 */
	private void anag(String s1, String s2, List<String> addData) {
		if (s1.length() == 0) {
			addData.add(s2);
		}

		for (int i = 0; i < s1.length(); i++) {
			CharSequence c = s1.subSequence(0, i);
			String temp = s1.substring(i + 1, s1.length());
			String concat = c + temp;

			anag(concat, s1.charAt(i) + s2, addData);
		}

	}
}

class Anagram2 {
	/**
	 * This method checks if str2 is anagram of str1
	 * 
	 * @param str1
	 *            , not null
	 * @param str2
	 *            , not null
	 * 
	 * @return true if two strings are anagram, false otherwise
	 */
	boolean isAnagram(String str1, String str2) {
		// If length of strings are not same, the strings are not anagrams.
		if (str1.length() != str2.length()) {
			return false;
		}
		// Convert Strings to lower case.
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		char[] str1Chars = str1.toCharArray();
		List<Character> str2CharsList = createCharList(str2);
		// Iterate over characters of the first string.
		for (Character c : str1Chars) {
			// If the character list of the second string does not contain
			// the character from first string, then the strings are not
			// anagrams.
			if (!str2CharsList.contains(c)) {
				return false;
			}
			// Remove the character from character list of the second string so
			// that multiple occurrences of a character in the first string will
			// be matched with equal number of occurrences of the character in
			// the second string.
			// For ex: 'aan' and 'an'
			// Here 'a' occurs twice in first string and once in second string.
			// If we don't remove 'a' from the character list of second string
			// then two occurrences of 'a' in first string will be matched with
			// one occurrence 'a' in the second string
			str2CharsList.remove(c);
		}
		return true;
	}

	/**
	 * This method creates a list of characters from the string characters.
	 * 
	 * @param str
	 *            , not null
	 * @return list of string characters.
	 */
	List<Character> createCharList(final String str) {
		char[] charArray = str.toCharArray();
		// Linked list is used because there will be lot of removals from the
		// list.
		List<Character> charList = new LinkedList<Character>();
		for (char c : charArray) {
			charList.add(c);
		}
		return charList;
	}
}

/**
 * Write a method to sort an array of strings so that all the anagrams are next
 * to each other.
 * 
 * Approach - The basic idea is to implement a normal sorting algorithm where
 * you override the compareTo method to compare the �signature� of each string.
 * In this case, the signature is the alphabetically sorted string.
 *
 */
class AnagramComparator implements Comparator<String> {

	public int compare(String s1, String s2) {
		return sortString(s1).compareTo(sortString(s2));
	}

	public String sortString(String s1) {
		char[] c = s1.toCharArray();
		Arrays.sort(c);
		return String.valueOf(c);
	}
}