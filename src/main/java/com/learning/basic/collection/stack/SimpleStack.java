/**
 * 
 */
package com.learning.basic.collection.stack;

import java.util.LinkedList;

/**
 * @author VINAY
 * 
 */
public class SimpleStack implements Stack<Integer> {
	private LinkedList<Integer> list = new LinkedList<Integer>();

	public void push(Integer item) {
		list.addFirst(item);
	}

	public Integer pop() {
		return list.removeFirst();
	}

	public Integer peek() {
		return list.getFirst();
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
}
