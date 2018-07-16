/**
 * 
 */
package com.learning.basic.collection.stack;

import java.util.NoSuchElementException;

import com.learning.basic.collection.Node;

/**
 * @author VINAY
 * 
 */
public class LinkedStack implements Stack<Integer> {

	private Node<Integer> top = null;

	public void push(Integer item) {
		top = new Node<Integer>(item, top);
	}

	public Integer pop() {
		Integer item = peek();
		top = top.next;
		return item;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public Integer peek() {
		if (top == null) {
			throw new NoSuchElementException();
		}
		return top.data;
	}

	public int size() {
		int count = 0;
		for (Node<Integer> node = top; node != null; node = node.next) {
			count++;
		}
		return count;
	}

	/**
	 * @return
	 */
	public Stack<Integer> sort() {
		Stack<Integer> result = new LinkedStack();

		while (!isEmpty()) {
			int tmp = peek();
			while (!result.isEmpty() && result.peek() > tmp) {
				push(result.pop());
			}
			result.push(pop());
		}

		return result;
	}
}