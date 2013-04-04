package frank.interview.ds.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie<T> {
	
	private Node<T> root;

	public Trie() {
		root = new Node<T>();
	}
	
	public Node<T> getRoot() {
		return root;
	}
	
	public void put(String key, T value) {
		FindResult<T> result = find(key);
		if (result.pos == key.length()) {
			if (result.node.getValue() == null) {
				result.node.setValue(value);
			} else {
				throw new IllegalArgumentException("key "+key+" is associated with value "+value+" already!");
			}
		} else {
			Node<T> node = result.node;
			for (int i = result.pos; i < key.length(); i++) {
				Node<T> next = new Node<T>();
				node.setChild(key.charAt(i), next);
				node = next;
			}
			node.setValue(value);
		}
	}
	
	public T get(String key) {
		FindResult<T> result = find(key);
		if (result.pos == key.length()) {
			return result.node.getValue();
		} else {
			return null;
		}
	}
	
	public List<T> list(String key) {
		FindResult<T> result = find(key);
		List<T> values = new ArrayList<T>();
		listValuesRecursively(result.node, values);
		return values;
	}
	
	private void listValuesRecursively(Node<T> node, List<T> values) {
		if (node == null)
			return;
		if (node.getValue() != null) {
			values.add(node.getValue());
		}
		for (Node<T> child : node.getChildren()) {
			if (child != null) {
				listValuesRecursively(child, values);
			}
		}
	}
	
	static class FindResult<T> {
		Node<T> node;
		int pos;
		FindResult(Node<T> node, int pos) {
			this.node = node;
			this.pos = pos;
		}
	}
	
	private FindResult<T> find(String key) {
		Node<T> node = root;
		Node<T> next = null;
		int index = 0;
		for (int i = 0; i < key.length() && node != null; i++, index++) {
			next = node.getChild(key.charAt(i));
			if (next != null) {
				node = next;
			} else {
				break;
			}
		}
		
		return new FindResult<T>(node, index);
	}
	
	public void printPreOrder() {
		doPrintPreOrder(this.root);
	}
	
	public void doPrintPreOrder(Node<T> node) {
		if (node == null) 
			return;
		System.out.println(node);
		for(Node<T> child : node.getChildren()) {
			doPrintPreOrder(child);
		}
	}
}
