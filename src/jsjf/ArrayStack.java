package jsjf;

import java.util.Arrays;
import jsjf.exception.*;

public class ArrayStack<T> implements StackADT<T> {
	
	private final static int DEFAULT_CAPACITY = 100;
	
	private int top;
	private T[] stack;
	
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayStack(int initialCapacity) {
		stack = (T[])(new Object[initialCapacity]);
		top = 0;
	}


	public void push(T element) {
		if (size() == stack.length)
			expandCapacity();
		
		stack[top] = element;
		top++;
		
	}


	public T pop() {
		if (isEmpty())
			throw new EmptyCollectionException("stack");
		
		top--;
		T result = stack[top];
		stack[top] = null;
		
		return result;
	}


	public T peek() {
		if (isEmpty())
			throw new EmptyCollectionException("stack");
		
		return stack[top-1];
	}


	public boolean isEmpty() {
		boolean empty = false;
		if ( top == 0 )
			empty = true;
		return empty;
	}


	public int size() {
		return top;
	}
	
	public String toString() {	
		String string = "";
		for (int i = 0; i < this.size(); i++)
			string += stack[i] + " \n";
		
		return string;
	}
	
	public int getLength() {
		return stack.length;
	}
	
	private void expandCapacity() {
		stack = Arrays.copyOf(stack, stack.length * 2);
	}
	
	

	
	
}
