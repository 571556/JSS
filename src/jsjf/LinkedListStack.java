package jsjf;

public class LinkedListStack<T> extends LinkedList<T> implements StackADT<T> {
	
	public LinkedListStack() {
		super();
	}
	
	@Override
	public void push(T element) {
		DoublyLinearNode<T> temp = new DoublyLinearNode<T>(element);
		temp.setNext(head);
		head = temp;
		count++;
	}

	@Override
	public T pop() {
		return removeFirst();
	}

	@Override
	public T peek() {
		return first();
	}

	
	
}
