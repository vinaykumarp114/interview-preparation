/**
 * 
 */
package com.learning.basic.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author VINAY
 * 
 */
public class TestCollection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		removeListData();

	}

	static void removeListData() {
		List<Integer> val = new ArrayList<Integer>();

		int count = 0;
		while (count < 10) {
			val.add(count);
			count++;
		}
		System.out.println("Inital Value : "+val);
		
		Iterator<Integer> iterate = val.iterator();
		Random r = new Random();
		count = 0;
		while (iterate.hasNext() && count < 4) {
			val.remove(r.nextInt(val.size()));
			count++;
		}
		System.out.println("Final Value : "+val);
	}
}