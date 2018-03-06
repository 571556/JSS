package jsjf;

public class ArrayListQueue<T> extends ArrayList<T> implements QueueADT<T>{

	private int front;
	private int count;
	
	public ArrayListQueue() {
		super();
		front = count = 0;
	}

	@Override
	public void enqueue(T element) {
		if(rear == list.length)
			expandCapacity();
		
		list[rear] = element;
		rear = (rear+1) % list.length;
		count++;
	}

	@Override
	public T dequeue() {
		T result = list[front];
		front = (front + 1) % list.length;
		count--;
		return result;
	}
	
	private void expandCapacity() {
		T[] newList = (T[])(new Object[list.length * 2]);
		int copy = front;
		for(int i = 0; i < count; i++) {
			newList[i] = list[copy];
			copy = (copy + 1) % list.length;
		}
		list = newList;
	}
	
	
}
