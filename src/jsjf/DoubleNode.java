package jsjf;

public class DoubleNode<T> {

	private T element;
	private DoubleNode<T> next;
	private DoubleNode<T> previous;
	
	public DoubleNode() {
		this(null);
	}
	
	public DoubleNode(T element) {
		next = previous = null;
		this.element = element;
	}
	
	public void setElement(T element) {
		this.element = element;
	}
	
	public T getElement() {
		return element;
	}
	
	public void setNext(DoubleNode<T> n) {
		next = n;
	}
	
	public DoubleNode<T> getNext() {
		return next;
	}
	
	public void setPrevious(DoubleNode<T> p) {
		previous = p;
	}
	
	public DoubleNode<T> getPrevious() {
		return previous;
	}
	
}
