package jsjf;

import jsjf.exception.*;

import java.util.Arrays;
import java.util.Arrays.*;

public class DropOutStack<T> implements StackADT<T>{

	private final static int DEFAULT_CAPACITY = 15;
	
	private T[] stack;
	private int top;
	
	public DropOutStack() {
		this(DEFAULT_CAPACITY);
	}
	
	
	public DropOutStack(int initial_capacity) {
		stack = (T[])(new Object[initial_capacity]);
		top = 0;
	}

	
	public void push(T element) {
		if ( size() == stack.length) {
			dropOut();
		}
		
		stack[top] = element;
		top++;
		
	}

	@Override
	public T pop() {
		if (isEmpty()) 
			throw new EmptyCollectionException("stack");
		else if (top == 0)
			top = stack.length;
		
		top--;
		T result = stack[top];
		stack[top] = null;
		return result;
	}

	@Override
	public T peek() {
		return stack[top-1];
	}

	@Override
	public boolean isEmpty() {
		if (size() > 0) {
			return false;
		}
		return true;
	}

	@Override
	public int size() {
		int telle = 0;
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] != null)
				telle += 1;
		}
		return telle;
	}
	
	public int getLength() {
		return stack.length;
	}
	
	private void dropOut() {
		top = 0;
	}
	
}
