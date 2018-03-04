package jsjf;

public interface DequeADT<T> {
	
	public void insertFront(T element);
	
	public T removeFront();
	
	public void insertRear(T element);
	
	public T removeRear();
	
	public T first();
	
	public T last();
	
	public boolean isEmpty();
	
	public int size();
	
	public String toString();

}
