/**
 * 
 */
package com.learning.basic.binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author vinay
 *
 */
public class LowestCommonAnchestorBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LowestCommonAnchestorBinaryTree lcaBt = new LowestCommonAnchestorBinaryTree();
		Node<String> root = lcaBt.createBinaryTree();
		String output = lcaBt.lca(root, "B", "C");
		System.out.println("LCA for B & C => "+output);
		System.out.println("==============");
		output = lcaBt.lca(root, "D", "E");
		System.out.println("LCA for D & E => "+output);
		System.out.println("==============");
		output = lcaBt.lca(root, "D", "F");
		System.out.println("LCA for D & F => "+output);
		System.out.println("==============");
		output = lcaBt.lca(root, "D", "J");
		System.out.println("LCA for D & J => "+output);
		System.out.println("==============");
		output = lcaBt.lca(root, "G", "J");
		System.out.println("LCA for G & J => "+output);
		System.out.println("==============");
	}

	private String lca(Node<String> root, String s1, String s2) {
		List<String> path1 = new LinkedList<>();
		List<String> path2 = new LinkedList<>();

		findPath(root, s1, new LinkedList<>(), path1);
		findPath(root, s2, new LinkedList<>(), path2);
		System.out.println(path1 + " - " + path2);
		List<String> intersect = path1.stream().filter(path2::contains).collect(Collectors.toList());
		return intersect.get(intersect.size()-1);
	}

	private void findPath(Node<String> node, String val, List<String> curList, List<String> path) {
		if (node == null) {
			return;
		}

		curList.add(node.value);

		if (node.value.equals(val)) {
			path.addAll(curList);
			return;
		}

		if (node.next != null) {
			Iterator<Node<String>> it = node.next.iterator();
			while (it.hasNext()) {
				findPath(it.next(), val, curList, path);
			}
		}
		curList.remove(node.value);
	}

	public Node<String> createBinaryTree() {
		Node<String> root = new Node<String>("A");
		Node<String> b = new Node<String>("B");
		Node<String> c = new Node<String>("C");
		Node<String> d = new Node<String>("D");
		Node<String> e = new Node<String>("E");
		Node<String> f = new Node<String>("F");
		Node<String> g = new Node<String>("G");
		Node<String> h = new Node<String>("H");
		Node<String> i = new Node<String>("I");
		Node<String> j = new Node<String>("J");

		g.setNextNode(h);
		g.setNextNode(i);
		g.setNextNode(j);

		c.setNextNode(f);
		c.setNextNode(g);

		b.setNextNode(d);
		b.setNextNode(e);

		root.setNextNode(b);
		root.setNextNode(c);

		return root;
	}

}

class Node<T> {
	T value;
	List<Node<T>> next;

	public Node(T val) {
		this.value = val;
	}

	public void setNextNode(Node<T> n) {
		if (next == null) {
			next = new LinkedList<>();
		}
		next.add(n);
	}
}
