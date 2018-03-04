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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(T element) throws EmptyCollectionException, ElementNotFoundException{
		if(isEmpty())
			throw new EmptyCollectionException("LinkedList");
		
		boolean found = false;
		DoublyLinearNode<T> previous = null;
		DoublyLinearNode<T> current = head;
		
		while ( current != null && !found)
			if(element.equals(current.getElement()))
				found = true;
			else {
				previous = current;
				current = current.getNext();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T target) {
		
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
