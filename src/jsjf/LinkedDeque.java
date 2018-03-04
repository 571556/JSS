package jsjf;
import jsjf.exception.*;

public class LinkedDeque<T> implements DequeADT<T>{
	
	private int count;
	private DoublyLinearNode<T> head,tail;
	
	public LinkedDeque() {
		count = 0;
		head = tail = null;
	}

	public void insertFront(T element) {
		DoublyLinearNode<T> node = new DoublyLinearNode<T>(element);
		if (isEmpty()) {
			tail = node;
			head = node;
		}else {
			node.setNext(head);
			head.setPrevious(node);
			head = node;
		}
		count++;
	}

	public T removeFront() throws EmptyCollectionException{
		if(isEmpty())
			throw new EmptyCollectionException("deque");
		T result = head.getElement();
		head = head.getNext();
		head.setPrevious(null);
		count--;
		return result;
	}

	public void insertRear(T element) {
		DoublyLinearNode<T> node = new DoublyLinearNode<T>(element);
		if(isEmpty()) {
			head = node;
			tail = node;
		}
		node.setPrevious(tail);
		tail.setNext(node);
		tail = node;
		count++;
	}

	public T removeRear() throws EmptyCollectionException{
		if(isEmpty())
			throw new EmptyCollectionException("deque");
		
		T result = tail.getElement();
		tail = tail.getPrevious();
		tail.setNext(null);
		count--;
		return result;
	}

	public T first() {
		return head.getElement();
	}

	public T last() {
		return tail.getElement();
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
		DoublyLinearNode<T> temp = head;
		String rString = "";
		for(int i = 0; i < count; i++){
			rString += temp.getElement().toString() + "\n";
			temp = temp.getNext();
		}
		return rString;
	}
	
	

}
