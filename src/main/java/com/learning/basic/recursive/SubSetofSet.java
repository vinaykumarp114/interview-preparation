/**
 * 
 */
package com.learning.basic.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a method that returns all subsets of a set
 * 
 * @author VINAY
 *
 */
public class SubSetofSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);

		List<List<Integer>> result = getSubsets(set, 0);
		System.out.println(result);
	}

	static List<List<Integer>> getSubsets(List<Integer> set, int index) {
		List<List<Integer>> allSubset = null;

		if (index == set.size()) {
			allSubset = new ArrayList<List<Integer>>();
			allSubset.add(new ArrayList<Integer>());
		} else {
			allSubset = getSubsets(set, index + 1);
			int item = set.get(index);

			List<List<Integer>> moresubsets = new ArrayList<List<Integer>>();
			for (List<Integer> subset : allSubset) {
				List<Integer> newset = new ArrayList<Integer>();
				newset.addAll(subset);
				newset.add(item);
				moresubsets.add(newset);
			}
			allSubset.addAll(moresubsets);
		}

		return allSubset;
	}
}
