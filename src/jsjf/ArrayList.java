package jsjf;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import jsjf.exception.*;

public abstract class ArrayList<T> implements ListADT<T>, Iterable<T>{
	
	private final static int DEFAULT_CAPACITY = 100;
	private final static int NOT_FOUND = -1;
	protected int rear;
	protected T[] list;
	protected int modCount;
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayList(int capacity) {
		list = (T[])(new Object[capacity]);
		rear = modCount = 0;
	}

	@Override
	public T removeFirst() throws EmptyCollectionException{
		T result;
		if(isEmpty())
			throw new EmptyCollectionException("ArrayList");
		
		result = list[0];
		rear--;
		
		for (int i = 0; i < rear; i++)
			list[i] = list[i + 1];
		
		list[rear] = null;
		modCount++;
		return result;
	}

	@Override
	public T removeLast() {
		T result;
		
		if (isEmpty())
			throw new EmptyCollectionException("ArrayList");
		
		rear--;
		result = list[rear];
		list[rear] = null;
		modCount++;
		return result;
	}

	@Override
	public T remove(T element){
		T result;
		int index = find(element);
		if(index == NOT_FOUND)
			throw new ElementNotFoundException("ArrayList");
		
		result = list[index];
		rear--;
		
		for(int scan = index; scan < rear; scan++)
			list[scan] = list[scan+1];
		list[rear] = null;
		modCount++;
		return result;
	}

	@Override
	public T first() {
		T result;
		if (isEmpty())
			result = null;
		else
			result = list[0];
		return result;
	}

	@Override
	public T last() {
		T result;
		if (isEmpty())
			result = null;
		else
			result = list[rear];
		return result;
	}

	@Override
	public boolean contains(T target) {
		return (find(target) != NOT_FOUND);
	}

	@Override
	public boolean isEmpty() {
		return (size() == 0);
	}

	@Override
	public int size() {
		return rear;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> itr = new ArrayListIterator<T>();
		return itr;
	}
	
	private int find(T target) {
		int scan = 0;
		int result = NOT_FOUND;
		if(!isEmpty())
			while(result == NOT_FOUND && scan < rear) {
				if(target.equals(list[scan]))
					result = scan;
				else
					scan++;
			}
		return result;
	}
	
	public String toString() {
		String string = "";
		for(int i = 0; i < rear; i++)
			string += list[i].toString() + "\n";
		
		return string;
	}
	
	private class ArrayListIterator<T> implements Iterator<T>{

		private T[] iteratorList;
		private int current;
		private int iteratorModCount;
		
		public ArrayListIterator() {
			iteratorList = (T[]) list;
			current = 0;
			iteratorModCount = modCount;
		}
		
		@Override
		public boolean hasNext() throws ConcurrentModificationException{
			
			if(iteratorModCount != modCount)
				throw new ConcurrentModificationException();
			
			return (iteratorList[current] != null);
		}

		@Override
		public T next() throws ConcurrentModificationException, NoSuchElementException{
			
			if(!hasNext())
				throw new NoSuchElementException();
			
			T result = iteratorList[current];
			current++;
			return result;
		}
		
		
		
		
	}

}
