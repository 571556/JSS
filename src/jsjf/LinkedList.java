package jsjf;

import java.util.Iterator;
import jsjf.exception.*;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;


public abstract class LinkedList<T> implements ListADT<T>, Iterable<T>{

	protected int count;
	protected DoubleNode<T> head, tail;
	protected int modCount;
	
	public LinkedList() {
		count = modCount = 0;
		head = tail = null;
	}

	@Override
	public T removeFirst() {
		if (count == 0)
			throw new EmptyCollectionException("LinkedList");
		
		T result = head.getElement();
		
		if (count == 1)
			head = tail = null;
		else
			head = head.getNext();
		
		count--;
		modCount++;
			
		return result;
	}

	@Override
	public T removeLast() {
		if (count == 0)
			throw new EmptyCollectionException("LinkedList");
	
		DoubleNode<T> current = tail;
		T result = current.getElement();

		
		if(count == 1)
			head = tail = null;
		else {
			tail = current.getPrevious();
			tail.setNext(null);
		}
		
		count--;
		modCount++;
		
		return result;
	}

	@Override
	public T remove(T element) throws EmptyCollectionException, ElementNotFoundException{
		if(isEmpty())
			throw new EmptyCollectionException("LinkedList");
		
		boolean found = false;
		DoubleNode<T> previous = null;
		DoubleNode<T> current = head;
		
		while ( current != null && !found) {
			if(element.equals(current.getElement()))
				found = true;
			else {
				previous = current;
				current = current.getNext();
				}
			}
		
		if (!found)
			throw new ElementNotFoundException("LinkedList");
		
		if (size() == 1)
			head = tail = null;
		else if (current.equals(head))
			head = current.getNext();
		else if (current.equals(tail)) {
			tail = previous;
			tail.setNext(null);
		}
		else
			previous.setNext(current.getNext());
		count--;
		modCount++;
		
		return current.getElement();
	}

	@Override
	public T first() {
		return head.getElement();
	}

	@Override
	public T last() {
		return tail.getElement();
	}

	@Override
	public boolean contains(T target) {
		DoubleNode<T> current = head;
		boolean found = false;
		while(current != null && !found) {
			if(current.getElement().equals(target))
				found = true;
			else 
				current = current.getNext();
		}
			
		return found;
	}

	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> itr = new LinkedListIterator();
		return itr;
	}
	
	public String toString() {
		String string = "";
		DoubleNode<T> temp = head;
		int scan = 0;
		while(scan < size()) {
			string += temp.getElement().toString() + "\n";
			temp = temp.getNext();
			scan++;
		}
		return string;
	}
	
	private class LinkedListIterator implements Iterator<T>{

		private DoubleNode<T> current;
		private int iteratorModCount;
		
		public LinkedListIterator() {
			current = head;
			iteratorModCount = modCount;
		}
		
		@Override
		public boolean hasNext() throws ConcurrentModificationException{
			
			if(iteratorModCount != modCount)
				throw new ConcurrentModificationException();
			
			return (current != null);
			
		}

		@Override
		public T next() throws ConcurrentModificationException{
			
			if(!hasNext())
				throw new NoSuchElementException();
			
			T result = current.getElement();
			current = current.getNext();
			return result;
		}
		
		@Override
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
		
	}
	
}
