/**
 * 
 */
package com.learning.basic.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author VINAY
 * 
 */
public class FindIntersection {

	private List<Integer> listOne = new LinkedList<Integer>();
	private List<Integer> listTwo = new LinkedList<Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindIntersection findIntersection = new FindIntersection();
		findIntersection.createData();
		System.out.println(findIntersection.findIntersectionPoint());
	}

	/**
	 * 
	 */
	private void createData() {
		listOne.add(1);
		listOne.add(2);
		listOne.add(3);
		listOne.add(7);
		listOne.add(8);
		listOne.add(9);
		listOne.add(4);
		listOne.add(5);
		listOne.add(6);

		listTwo.add(-1);
		listTwo.add(-3);
		listTwo.add(9);
		listTwo.add(4);
		listTwo.add(5);
		listTwo.add(6);
	}

	/**
	 * @return
	 */
	public Integer findIntersectionPoint() {

		List<Integer> biggerList = listTwo;
		List<Integer> smallerList = listOne;

		int diffInSize = listTwo.size() - listOne.size();
		int count = 0;

		// if diffInSize is negative then interchange the references.
		if (diffInSize < 0) {
			biggerList = listOne;
			smallerList = listTwo;
			diffInSize = Math.abs(diffInSize);
		}

		Iterator<Integer> two = smallerList.iterator();

		for (Integer one : biggerList) {
			if (count < diffInSize) {
				count++;
				continue;
			}
			if (one == two.next())
				return one;
		}

		return null;
	}
}