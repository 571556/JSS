package jsjf;

public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {

	public ArrayOrderedList() {
		super();
	}

	@Override
	public void add(T element) {
		
		list[rear] = element;
		rear++;
		modCount++;
		
	}
	
	
	
	
}
