/**
 * 
 */
package com.learning.basic.collection.linkedlist;

import java.util.Map;
import java.util.WeakHashMap;

import com.learning.basic.collection.Node;

/**
 * @author VINAY
 * 
 */
public class TestSinglyLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testRemoveNode();
	}

	static void testRemoveNode() {
		Node<String> nodeE = new Node<String>("E", null);
		Node<String> nodeD = new Node<String>("D", nodeE);
		Node<String> nodeC = new Node<String>("C", nodeD);
		Node<String> nodeB = new Node<String>("B", nodeC);
		Node<String> nodeA = new Node<String>("A", nodeB);

		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		System.out.print("Initial List : ");
		singlyLinkedList.printNode(nodeA);
		System.out.println("Delete Middle Node : " + nodeD.data);
		singlyLinkedList.deleteMiddleNode(nodeD);
		System.out.print("Modified List : ");
		singlyLinkedList.printNode(nodeA);

		System.out.print("Reverse List : ");
		singlyLinkedList.reverse(nodeA);
		singlyLinkedList.printNode(nodeD);

		System.out.print("Recursive Reverse List : ");
		singlyLinkedList.recursiveReverse(nodeD);
		singlyLinkedList.printNode(nodeA);

		Node<String> node1 = new Node<String>("CD", null);
		Node<String> node2 = new Node<String>("BC", node1);
		Node<String> node3 = new Node<String>("AB", node2);
		Node<String> node4 = new Node<String>("CD", node3);
		Node<String> node5 = new Node<String>("BC", node4);
		Node<String> node6 = new Node<String>("AB", node5);

		System.out.print("Initial List : ");
		singlyLinkedList.printNode(node6);
		singlyLinkedList.deleteNode(node6, "CD");
		System.out.print("Modified List : ");
		singlyLinkedList.printNode(node6);

		System.out.print("Delete Duplicate : ");
		singlyLinkedList.deleteDups(node6);
		singlyLinkedList.printNode(node6);
	}
}

class SinglyLinkedList {

	public void printNode(Node<String> node) {
		StringBuilder result = new StringBuilder();

		while (node != null) {
			result.append(node.data);
			result.append(" -> ");
			node = node.next;
		}
		result.append("null");
		System.out.println(result.toString());
	}

	/**
	 * Implement an algorithm to delete a node in the middle of a single linked
	 * list, given only access to that node.
	 * 
	 * EXAMPLE Input: the node �c� from the linked list a->b->c->d->e Result:
	 * nothing is returned, but the new linked list looks like a->b->d->e
	 * 
	 * @param middleNode
	 * @return
	 */
	public boolean deleteMiddleNode(Node<String> middleNode) {
		// error check:
		if (middleNode == null || middleNode.next == null)
			return false;

		/*
		 * middleNode is x in our example data above, but is now changed to hold
		 * the data of node y:
		 */
		middleNode.data = middleNode.next.data;

		/*
		 * tempNode now holds node z if following the example above:
		 */
		Node<String> tempNode = middleNode.next.next;
		/*
		 * reset pointer so that the new "y" points to z
		 */
		middleNode.next = tempNode;

		return true;
	}

	/**
	 * @param head
	 */
	public void reverse(Node<String> head) {
		Node<String> prev = null;
		Node<String> current = head;
		Node<String> next = current.next;
		while (current.next != null) {
			current.next = prev;
			prev = current;
			current = next;
			next = current.next;
		}
		current.next = prev;
		head = current;
	}

	/**
	 * @param node
	 * @return
	 */
	public Node<String> recursiveReverse(Node<String> node) {
		if (node == null) {
			return node;
		}
		Node<String> next = node.next;
		if (next == null) {
			return node;
		}
		node.next = null;
		Node<String> reverseList = recursiveReverse(next);
		next.next = node;
		return reverseList;
	}

	/**
	 * Append Node to tail
	 * 
	 * @param head
	 * @param val
	 */
	public void appendTail(Node<String> head, String val) {
		Node<String> end = new Node<String>(val);
		Node<String> n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	/**
	 * Delete Node based on value
	 * 
	 * @param head
	 * @param val
	 * @return
	 */
	public void deleteNode(Node<String> head, String val) {
		Node<String> n = head;

		if (val.equals(n.data)) {
			head = head.next; /* moved head */
			return;
		}

		while (n.next != null) {
			if (val.equals(n.next.data)) {
				n.next = n.next.next;
				return; /* head didn�t change */
			}
			n = n.next;
		}
	}

	/**
	 * Write code to remove duplicates from an unsorted linked list. How would
	 * you solve this problem if a temporary buffer is not allowed?
	 * 
	 * @param nodes
	 */
	public void deleteDups(Node<String> node) {
		if (node == null || node.next == null) {
			return;
		}
		Map<String, Boolean> temp = new WeakHashMap<String, Boolean>();
		Node<String> previous = null;
		while (node != null) {
			if (temp.containsKey(node.data)) {
				previous.next = node.next;
			} else {
				temp.put(node.data, true);
				previous = node;
			}
			node = node.next;
		}
	}

	public void deleteDups2(Node<String> node) {
		if (node == null) {
			return;
		}
		Node<String> previous = node;
		Node<String> current = previous.next;

		while (current != null) {
			Node<String> runner = node;
			while (runner != current) { // Check for earlier dups
				if (current.data == runner.data) {
					Node<String> temp = current.next; // remove current
					previous.next = temp;
					current = temp; // update current to next node
					break; // all other dups have already been removed
				}
				runner = runner.next;
			}

			if (runner == current) { // current not updated - update now
				previous = current;
				current = current.next;
			}
		}
	}

	/**
	 * Implement an algorithm to find the nth to last element of a singly linked
	 * list.
	 * 
	 * @return
	 */
	public Node<String> nthToLast(Node<String> head, int n) {
		if (head == null || n < 1) {
			return null;
		}
		Node<String> p1 = head;
		Node<String> p2 = head;

		for (int i = 0; i < n - 1; ++i) { // skip n-1 steps ahead
			if (p2.next == null) {
				return null; // not found since list size < n
			}
			p2 = p2.next;
		}

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	/**
	 * You have two numbers represented by a linked list, where each node
	 * contains a single digit. The digits are stored in reverse order, such
	 * that the 1�s digit is at the head of the list. Write a function that adds
	 * the two numbers and returns the sum as a linked list. EXAMPLE Input: (3
	 * -> 1 -> 5), (5 -> 9 -> 2) Output: 8 -> 0 -> 8
	 * 
	 * @param n1
	 * @param n2
	 * @param carry
	 * @return
	 */
	public Node<Integer> addLists(Node<Integer> n1, Node<Integer> n2, int carry) {
		if (n1 == null && n2 == null) {
			return null;
		}

		Node<Integer> result = new Node<Integer>(carry);
		int value = carry;
		if (n1 != null) {
			value += n1.data;
		}
		if (n2 != null) {
			value += n2.data;
		}
		result.data = value % 10;
		Node<Integer> more = addLists((n1 == null) ? null : n1.next, (n2 == null) ? null : n2.next, value > 10 ? 1 : 0);
		result.next = more;
		return result;
	}
	
	
}