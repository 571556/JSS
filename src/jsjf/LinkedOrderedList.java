package jsjf;

import jsjf.exception.*;

public class LinkedOrderedList<T> extends LinkedList<T> implements OrderedListADT<T>{

	public LinkedOrderedList(){

		super();
	}
	
	@Override
	public void add(T element) {


		if (!(element instanceof Comparable))
			throw new NonComparableElementException("LinkedOrderedList");
		
		Comparable<T> comparableElement = (Comparable<T>)element;
		

		DoubleNode<T> current = head;
		DoubleNode<T> previous = null;
		DoubleNode<T> newNode = new DoubleNode<T>(element);
		int scan = 0;

		
		if(size() == 0)
			head = tail = newNode;
		else if(size() == 1) {
			if(comparableElement.compareTo(head.getElement()) > 0) {
				newNode.setPrevious(head);
				head.setNext(newNode);
				tail = newNode;
			}else {
				newNode.setNext(head);
				head.setPrevious(newNode);
				tail = head;
				head = newNode;
			}
			
		}else {
			while((scan < size()) && (comparableElement.compareTo(current.getElement()) > 0)) {
				previous = current;
				current = current.getNext();
				scan++;
			}
			if(current.equals(tail) && comparableElement.compareTo(current.getElement()) > 0) {
				tail.setNext(newNode);
				newNode.setPrevious(tail);
				tail = newNode;
			}else if(current.equals(head)){
				newNode.setNext(current);
				current.setPrevious(newNode);
				head = newNode;
			}else {
				newNode.setNext(current);
				newNode.setPrevious(previous);
				current.setPrevious(newNode);
				previous.setNext(newNode);
			}
			
		}
		
		count++;
		modCount++;
		
	}
	


}
