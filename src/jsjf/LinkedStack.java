package jsjf;

import jsjf.exception.*;
import java.util.Iterator.*;

public class LinkedStack<T> implements StackADT<T>{
	
	private int count;
	private LinearNode<T> top;
	
	public LinkedStack() {
		count = 0;
		top = null;
	}
	

	public void push(T element) {
		LinearNode<T> temp = new LinearNode<T>(element);
		
		temp.setNext(top);
		top = temp;
		count++;
	}

	public T pop() throws EmptyCollectionException {
		if (isEmpty()) 
			throw new EmptyCollectionException("stack");
		
		T result = top.getElement();
		top = top.getNext();
		count--;
		
		return result;
	}

	@Override
	public T peek() {
		return top.getElement();
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if(top == null) 
			empty = true;
		
		return empty;
	}

	@Override
	public int size() {
		return count;
	}
	
	public String toString() {
		String stackk = "";
		LinearNode<T> copyStack = top;
		for (int i = 0; i < count; i++) {
			stackk += copyStack.getElement().toString() + "\n";
			copyStack = copyStack.getNext();
		}
		return stackk;
	}

}
