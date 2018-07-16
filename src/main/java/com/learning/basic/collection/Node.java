/**
 * 
 */
package com.learning.basic.collection;


/**
 * @author VINAY
 *
 */
public class Node<T> {
	public T data;
	public Node<T> next;

	public Node(T data) {
		this.data = data;
	}

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	public T getValue() {
		return data;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> next() {
		return next;
	}
}
