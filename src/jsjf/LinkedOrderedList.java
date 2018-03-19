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
				newNode.setNext(head);
				head.setPrevious(newNode);
				tail = head;
				head = newNode;
			}else {
				newNode.setPrevious(head);
				head.setNext(newNode);
				tail = newNode;
			}
			
		}else {
			while((scan < size()) && (comparableElement.compareTo(current.getElement()) > 0)) {
				previous = current;
				current = current.getNext();
				scan++;
			}
			if(current == tail) {
				tail.setNext(newNode);
				newNode.setPrevious(tail);
				tail = newNode;
			}else if( previous == null) {
				newNode.setNext(head);
				head.setPrevious(newNode);
				head = newNode;
			}else {
				newNode.setPrevious(previous);
				newNode.setNext(current);
				previous.setNext(newNode);
				current.setPrevious(newNode);
			}
			
		}
		
		count++;
		modCount++;
		
	}
	


}
