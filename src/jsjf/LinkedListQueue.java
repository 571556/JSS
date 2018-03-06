package jsjf;

public class LinkedListQueue<T> extends LinkedList<T> implements QueueADT<T>{

	public LinkedListQueue() {
		super();
	}
	
	@Override
	public void enqueue(T element) {
		DoublyLinearNode<T> temp = new DoublyLinearNode<T>(element);
		if(count == 0) {
			head = tail = temp;
			count++;
		}else {
			temp.setPrevious(tail);
			tail.setNext(temp);
			tail = temp;
			count++;			
		}
		
		temp.setPrevious(tail);
		tail.setNext(temp);
		tail = temp;
		count++;
	}

	@Override
	public T dequeue() {
		return removeFirst();
	}
	
	

}
