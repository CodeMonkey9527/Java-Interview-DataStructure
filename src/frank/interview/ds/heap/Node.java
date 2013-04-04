package frank.interview.ds.heap;

@SuppressWarnings("hiding")
public class Node<Comparable> {
	private Node<Comparable> left;
	private Node<Comparable> right;
	private Comparable value;
	
	public Node<Comparable> getLeft() {
		return left;
	}
	public void setLeft(Node<Comparable> left) {
		this.left = left;
	}
	public Node<Comparable> getRight() {
		return right;
	}
	public void setRight(Node<Comparable> right) {
		this.right = right;
	}
	public Comparable getValue() {
		return value;
	}
	public void setValue(Comparable value) {
		this.value = value;
	}
}
