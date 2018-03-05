package jsjf;

import java.util.Iterator;
import jsjf.exception.*;

public abstract class LinkedList<T> implements ListADT<T>, Iterable<T>{

	protected int count;
	protected DoublyLinearNode<T> head, tail;
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
		
		head = head.getNext();
		count--;
		modCount++;
			
		return result;
	}

	@Override
	public T removeLast() {
		if (count == 0)
			throw new EmptyCollectionException("LinkedList");
		
		T result = tail.getElement();
		
		if(count == 1)
			head = tail = null;
		
		
		return null;
	}

	@Override
	public T remove(T element) throws EmptyCollectionException, ElementNotFoundException{
		if(isEmpty())
			throw new EmptyCollectionException("LinkedList");
		
		boolean found = false;
		DoublyLinearNode<T> previous = null;
		DoublyLinearNode<T> current = head;
		
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
		
		return false;
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
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
