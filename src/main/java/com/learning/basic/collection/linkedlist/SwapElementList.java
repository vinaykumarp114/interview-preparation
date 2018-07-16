/**
 * 
 */
package com.learning.basic.collection.linkedlist;

import com.learning.basic.collection.Node;

/**
 * Given a singly linked list, write a function to swap elements pairwise. For
 * example, if the linked list is 1->2->3->4->5 then the function should change
 * it to 2->1->4->3->5, and if the linked list is 1->2->3->4->5->6 then the
 * function should change it to 2->1->4->3->6->5. 
 * pairWiseSwap() or pairWiseSwapRecursive()
 * 
 * Reverse alternate K nodes in a Singly Linked List Given a linked list, write
 * a function to reverse every alternate k nodes (where k is an input to the
 * function) in an efficient way. Give the complexity of your algorithm.
 * Example:
 * Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
 * Output:   3->2->1->4->5->6->9->8->7->NULL. 
 * 
 * @author VINAY
 *
 */
public class SwapElementList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwapLinkedList llist = new SwapLinkedList();

		/* Created Linked List 1->2->3->4->5 */
		llist.push(10);
		llist.push(9);
		llist.push(8);
		llist.push(7);
		llist.push(6);
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);

		System.out.println("Linked List before calling pairWiseSwap() ");
		llist.printList(llist.head);

		// llist.pairWiseSwap();
		//llist.pairWiseSwapRecursive(llist.head);
		
		/*System.out.println("Linked List after calling pairWiseSwap() ");
		llist.printList(llist.head);*/
		
		Node<Integer> node = llist.kAltReverse(llist.head, 3);
		llist.printList(node);
	}
}

class SwapLinkedList {
	Node<Integer> head;

	/**
	 * @param data
	 */
	public void push(int data) {
		/* Put in the data */
		Node<Integer> node = new Node<Integer>(data);
		/* 3. Make next of new Node as head */
		node.next = head;
		/* 4. Move the head to point to new Node */
		head = node;
	}

	/**
	 * 
	 */
	public void pairWiseSwap() {
		Node<Integer> node = head;
		while (node != null && node.next != null) {
			int k = node.data;
			node.data = node.next.data;
			node.next.data = k;
			node = node.next.next;
		}
	}

	/**
	 * @param node
	 */
	public void pairWiseSwapRecursive(Node<Integer> node) {
		/* There must be at-least two nodes in the list */
		if (node == null || node.next == null) {
			return;
		}

		/* Swap the node's data with data of next node */
		int k = node.data;
		node.data = node.next.data;
		node.next.data = k;

		/* Call pairWiseSwap() for rest of the list */
		pairWiseSwapRecursive(node.next.next);

	}

	/**
	 * 
	 */
	public void printList(Node<Integer> node) {
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	/*
	 * Reverses alternate k nodes and returns the pointer to the new head node
	 */
	Node<Integer> kAltReverse(Node<Integer> node, int k) {
		Node<Integer> current = node;
		Node<Integer> next = null, prev = null;
		int count = 0;

		/* 1) reverse first k nodes of the linked list */
		while (current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * 2) Now head points to the kth node. So change next of head to (k+1)th
		 * node
		 */
		if (node != null) {
			node.next = current;
		}

		/*
		 * 3) We do not want to reverse next k nodes. So move the current
		 * pointer to skip next k nodes
		 */
		count = 0;
		while (count < k - 1 && current != null) {
			current = current.next;
			count++;
		}

		/*
		 * 4) Recursively call for the list starting from current->next. And
		 * make rest of the list as next of first node
		 */
		if (current != null) {
			current.next = kAltReverse(current.next, k);
		}

		/* 5) prev is new head of the input list */
		return prev;
	}
}
