package frank.interview.ds.trie;

public class Node<T> {

	static final int NUM = 26;
	private T value;
	private Node<T> [] children;

	public Node() {
		this.setValue(null);
		this.children = new Node[NUM];
	}

	public Node(T value) {
		this.setValue(value);
		this.children = new Node[NUM];
	}

	public Node<T>[] getChildren() {
		return children;
	}

	public void setChildren(Node<T>[] children) {
		this.children = children;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
	
	public Node<T> getChild(char ch) {
		if (ch >= 'a' && ch <= 'z') {
			return children[ch - 'a'];
		} else if (ch >= 'A' && ch <= 'Z') {
			return children[ch - 'A'];
		} else {
			throw new IllegalArgumentException(ch+" is not [a-z|A-Z]!");
		}
	}
	
	public void setChild(char ch, Node<T> child) {
		if (ch >= 'a' && ch <= 'z') {
			if (children[ch - 'a'] == null) {
				children[ch - 'a'] = child;
			}
		} else if (ch >= 'A' && ch <= 'Z') {
			if (children[ch - 'A'] == null) {
				children[ch - 'A'] = child;
			}
		} else {
			throw new IllegalArgumentException(ch+" is not [a-z|A-Z]!");
		}
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		int count = 0;
		int index = 0;
		for (Node<T> child: this.children) {
			if (child != null) {
				char ch = (char) ('a' + index);
				if (count != 0) {
					buffer.append(", ");
				}
				buffer.append(ch);
				count++;
			}
			index++;
		}
		return String.format("[Value=%s, children=%s]", value, buffer.toString());
	}
}
