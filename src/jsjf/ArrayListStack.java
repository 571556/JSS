package jsjf;
import jsjf.exception.*;

public class ArrayListStack<T> extends ArrayList<T> implements StackADT<T>{
	
	public ArrayListStack() {
		super();
	}

	@Override
	public void push(T element) {
		list[rear] = element;
		rear++;
	}

	@Override
	public T pop() throws EmptyCollectionException{
		if(rear == 0)
			throw new EmptyCollectionException("stack");
		
		return removeLast();
	}

	@Override
	public T peek() {
		return last();
	}
	
	

}
