/**
 * 
 */
package com.learning.basic.program;

import java.util.LinkedList;
import java.util.List;

/**
 * @author VINAY
 * 
 */
public class TestProgram2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NodeIterator _instance = new NodeIterator();
		Node a = _instance.add();
		_instance.iterateNodes(a, 0);
		System.out.println("Max Path length : "+_instance.maxVal);
	}
}

class NodeIterator {
	String node = "";
	int i = 0;
	int maxVal = 0;
	
	/**
	 * Construct Node Structure
	 * 
	 * @return
	 */
	public Node add() {		
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");

		d.getChildren().add(e);
		b.getChildren().add(d);
		c.getChildren().add(e);

		a.getChildren().add(e);
		a.getChildren().add(b);		
		a.getChildren().add(c);
		
		return a;
	}

	/**
	 * Loop Node Structure  
	 * 
	 * @param currNode
	 */
	public void iterateNodes(Node currNode, int count) {
		int offset = 0;

		List<Node> nodes = currNode.getChildren();

		if (!"".equals(node)) {
			node = node + " -> " + currNode.name;
		} else {
			node = currNode.name;
		}

		if (nodes.isEmpty()) {
			System.out.println("Nodes : " + node + " : count : " + count);
			if(count > maxVal) {
				maxVal = count;
			}
			return;
		}

		while (nodes.size() > offset) {
			if(offset > 0) {
				count = 0;
				node = currNode.name;
			}
			iterateNodes(nodes.get(offset), ++count);
			++offset;
		} 
	}
}

/**
 * @author VINAY
 *
 */
class Node {
	List<Node> children;
	String name;

	/**
	 * @param name
	 */
	Node(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public List<Node> getChildren() {
		if (children == null) {
			children = new LinkedList<Node>();
		}
		return children;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}