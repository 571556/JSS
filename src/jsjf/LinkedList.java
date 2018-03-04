package jsjf;

public abstract class LinkedList<T> implements ListADT<T>, Iterable<T>{

	protected int count;
	protected DoublyLinearNode<T> head, tail;
	protected int modCount;
	
	public LinkedList() {
		count = modCount = 0;
		head = tail = null;
	}
	
}
