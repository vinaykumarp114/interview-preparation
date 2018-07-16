/**
 * 
 */
package com.learning.basic.collection.queue;

import java.util.Stack;

/**
 * @author VINAY
 * 
 */
public class CustomeQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		TestQueue<String> testQueue = new TestQueue<String>();
		testQueue.queue("A");
		testQueue.queue("B");
		testQueue.queue("C");
		testQueue.queue("D");

		System.out.println("TestQueue First Time : " + testQueue.dequeue());
		System.out.println("TestQueue Second Time : " + testQueue.dequeue());
		System.out.println("TestQueue Thrid Time : " + testQueue.dequeue());
		System.out.println("TestQueue Fourth Time : " + testQueue.dequeue());

		SimulatedQueue<String> simulatedQueue = new SimulatedQueue<String>();
		simulatedQueue.insert("A");
		simulatedQueue.insert("B");
		simulatedQueue.insert("C");
		simulatedQueue.insert("D");

		System.out.println("SimulatedQueue First Time : " + simulatedQueue.remove());
		System.out.println("SimulatedQueue Second Time : " + simulatedQueue.remove());
		System.out.println("SimulatedQueue Thrid Time : " + simulatedQueue.remove());
		System.out.println("SimulatedQueue Fourth Time : " + simulatedQueue.remove());
	}

}

class TestQueue<E> {
	private Stack<E> inbox = new Stack<E>();
	private Stack<E> outbox = new Stack<E>();

	public void queue(E item) {
		inbox.push(item);
	}

	public E dequeue() {
		if (outbox.isEmpty()) {
			while (!inbox.isEmpty()) {
				outbox.push(inbox.pop());
			}
		}
		return outbox.pop();
	}
}

class SimulatedQueue<E> {
	private Stack<E> stack = new Stack<E>();

	public void insert(E elem) {
		if (!stack.empty()) {
			E topElem = stack.pop();
			insert(elem);
			stack.push(topElem);
		} else
			stack.push(elem);
	}

	public E remove() {
		return stack.pop();
	}
}