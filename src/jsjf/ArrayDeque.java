package jsjf;
import jsjf.exception.*;

public class ArrayDeque<T> implements DequeADT<T>{

	private T[] deque;
	private int front, rear, count;
	
	public ArrayDeque() {
		this(100);
	}
	
	public ArrayDeque(int capacity) {
		deque = (T[])(new Object[capacity]);
		front = rear = count = 0;
	}

	public void insertFront(T element) {
		if (size() == deque.length)
			expandCapacity();
		
		deque[front] = element;
		
		if (front == rear) {
			rear = (rear + 1) % deque.length;
		}
		if ( front == 0) {
			front = 99;
			count++;
		}
		else {
			front = (front - 1) % deque.length;
			count++;
		}
			
			
	}

	
	public T removeFront() throws EmptyCollectionException{
		
		if(size() == 0)
			throw new EmptyCollectionException("deque");
		
		T result = deque[front];
		deque[front] = null;
		front = (front + 1) % deque.length;
		count--;
		
		return result;
	}

	
	public void insertRear(T element) {
		if(size() == deque.length)
			expandCapacity();
		
		deque[rear] = element;
		if(front == rear)
			front = (front - 1) % deque.length;
		
		rear = (rear + 1) % deque.length;
		count++;
		
	}


	public T removeRear() throws EmptyCollectionException{
		if(isEmpty())
			throw new EmptyCollectionException("deque");
		
		T result = deque[rear];
		rear = (rear - 1) % deque.length;
		count--;
		
		return result;
	}

	public T first() {
		return deque[front];
	}

	public T last() {
		return deque[rear];
	}

	public boolean isEmpty() {
		boolean empty = false;
		if (count == 0)
			empty = true;
		return empty;
	}

	public int size() {
		return count;
	}
	
	public String toString() {
		String rString = "";
		for (int i = 0; i < count; i++) {
			rString += deque[(front + 1) % deque.length].toString() + "\n";
			front++;
		}
		return rString;
	}
	
	private void expandCapacity() {
		 
		T[] deque2 = (T[])(new Object[deque.length]);
		
		for(int i = 0; i < count; i++) {
			deque2[i] = deque[front];
			front = (front + 1) % deque.length;
		}
		front = 0;
		front = (front - 1) % deque2.length;
		rear = count;
		
		deque = deque2;
		
	}
	
	
	
}
