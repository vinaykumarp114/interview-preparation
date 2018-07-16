/**
 * 
 */
package com.learning.basic.collection.stack;

import java.util.Stack;

/**
 * How would you design a stack which, in addition to push and pop, also has a
 * function min which returns the minimum element? Push, pop and min should all
 * operate in O(1) time.
 * 
 * @author VINAY
 *
 */
public class StackWithMin extends Stack<Integer> {

	private static final long serialVersionUID = 5861251705909202477L;
	Stack<Integer> stack2;

	public StackWithMin() {
		stack2 = new Stack<Integer>();
	}

	public void push(int value) {
		if (value <= min()) {
			stack2.push(value);
		}
		super.push(value);
	}

	public Integer pop() {
		Integer val = peek();
		if (val == min()) {
			stack2.pop();
		}
		return super.pop();
	}

	public Integer min() {
		if (stack2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return stack2.peek();
		}
	}

	public Integer peek() {
		return super.peek();
	}
}
