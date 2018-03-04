package jsjf;
import jsjf.exception.*;

public class LinkedDropoutStack<T> implements StackADT<T>{
	
	private int count;
	private int size;
	private LinearNode<T> top;
	private LinearNode<T> secondLast;
	
	public LinkedDropoutStack() {
		this(10);
	}
	
	public LinkedDropoutStack(int size) {
		count = 0;
		top = null;
		this.size = size;
	}

	
	public void push(T element) {
		LinearNode<T> temp = new LinearNode<T>(element);
		if (count == 1)
			secondLast = temp;
		else if (count == size) {
			dropOut();
		}		
			temp.setNext(top);
			top = temp;
			count++;
		
	}

	public T pop() {
		LinearNode<T> temp = new LinearNode<T>();
		temp = top;
		top = top.getNext();
		return temp.getElement();
	}


	public T peek() {
		return top.getElement();
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if (count == 0)
			empty = true;
		return empty;
	}

	@Override
	public int size() {
		return size;
	}
	
	public String toString() {
		LinearNode<T> temp = top;
		String string = "";
		for ( int i = 0; i < size; i++) {
			string += temp.getElement() + "\n";
			temp = temp.getNext();
		}
		
		return string;	
	}
	
	private void dropOut() {
		LinearNode<T> temp = top;
		for(int i = 0; i < size - 1; i++) {
			temp = temp.getNext();
		}
		temp.setNext(null);
		count--;
		
	}
	

}
