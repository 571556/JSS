package jsjf;
import jsjf.exception.*;

public class LinkedUnorderedList<T> extends LinkedList<T> implements UnorderedListADT<T>{

	public LinkedUnorderedList() {
		super();
	}

	@Override
	public void addToFront(T element) {
		DoubleNode<T> newNode = new DoubleNode<T>(element);
		if(isEmpty())
			head = tail = newNode;
		
		newNode.setNext(head);
		head.setPrevious(newNode);
		head = newNode;
		count++;
		modCount++;
	}

	@Override
	public void addToRear(T element) {
		DoubleNode<T> newNode = new DoubleNode<T>(element);
		if(isEmpty())
			head = tail = newNode;
		
		newNode.setPrevious(tail);
		tail.setNext(newNode);
		tail = newNode;
		count++;
		modCount++;
		
	}

	@Override
	public void addAfter(T element, T target) {
		if(isEmpty())
			throw new ElementNotFoundException("LinkedUnorderedList");
		
		DoubleNode newNode = new DoubleNode<T>(element);
		DoubleNode current = head;
		DoubleNode afterCurrent = null;
		boolean found = false;
		
		while(current != null && !found)
			if(target.equals(current.getElement()))
				found = true;
			else
				current = current.getNext();
		
		if(!found)
			throw new ElementNotFoundException("LinkedUnorderedList");
		
		if(size() == 1)
			head = tail = newNode;
		else if(current.equals(head)) {
			afterCurrent = current.getNext();
			newNode.setNext(afterCurrent);
			newNode.setPrevious(head);
			head.setNext(newNode);
			afterCurrent.setPrevious(newNode);
		}else if(current.equals(tail)) {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
		}else {
			afterCurrent = current.getNext();
			newNode.setNext(afterCurrent);
			newNode.setPrevious(current);
			afterCurrent.setPrevious(newNode);
			current.setNext(newNode);
		}
		
		count++;
		modCount++;
		
	}
	
	private int countInstancesOf(T element) {
		
		return 0;
	}
	
	
	
	
}

