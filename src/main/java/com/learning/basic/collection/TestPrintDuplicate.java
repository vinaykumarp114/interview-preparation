/**
 * 
 */
package com.learning.basic.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author VINAY
 * 
 */
public class TestPrintDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = prepareDuplicate();

		System.out.println("\nHere are the duplicate elements from list : "
				+ findDuplicates(list));
		
		System.out.println("\nHere are the duplicate elements from Collection : "
				+ findDuplicate(list));
	}

	/**
	 * 
	 */
	public static List<String> prepareDuplicate() {
		List<String> list = new LinkedList<String>();
		for (int i = 0; i < 10; i++) {
			list.add(String.valueOf(i));
		}
		for (int i = 0; i < 5; i++) {
			list.add(String.valueOf(i));
		}

		System.out.println("My List : " + list);
		return list;
	}

	/**
	 * @param listContainingDuplicates
	 * @return
	 */
	public static Set<String> findDuplicates(
			List<String> listContainingDuplicates) {

		final Set<String> setToReturn = new HashSet<String>();
		final Set<String> set1 = new HashSet<String>();

		for (String yourInt : listContainingDuplicates) {
			if (!set1.add(yourInt)) {
				setToReturn.add(yourInt);
			}
		}
		return setToReturn;
	}

	/**
	 * @param input
	 * @return
	 */
	public static Collection<String> findDuplicate(Collection<String> input) {
		Collection<String> output = new ArrayList<String>();

		if (input != null && !input.isEmpty()) {
			Iterator<String> iterate = input.iterator();
			String temp = "";
			while (iterate.hasNext()) {
				temp = iterate.next();
				if (Collections.frequency(input, temp) > 1
						&& !output.contains(temp)) {
					output.add(temp);
				}
			}
		}

		return output;
	}
}
