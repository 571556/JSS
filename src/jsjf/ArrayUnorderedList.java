package jsjf;
import jsjf.exception.*;

public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T>{

	public ArrayUnorderedList() {
		super();
	}
	
	@Override
	public void addToFront(T element) {
		
		if (isEmpty())
			list[0] = element;
		
		for(int i = rear; i > 0; i--) {
			list[i] = list[i - 1];
		}
		list[0] = element;
		rear++;
		modCount++;
		
	}

	@Override
	public void addToRear(T element) {
		
		list[rear] = element;
		rear++;
		modCount++;
		
	}

	@Override
	public void addAfter(T element, T target) throws ElementNotFoundException{
		
		if (size() == list.length)
			expandCapacity();
		
		int scan = 0;
		
		while (scan < rear && !target.equals(list[scan]))
			scan++;
		
		if (scan == rear)
			throw  new ElementNotFoundException("UnorderedList");
		
		for (int shift = rear; shift > scan; shift--)
			list[shift] = list[shift-1];
		
		list[scan] = element;
		rear++;
		modCount++;
	}
	
	private void expandCapacity() {
		T[] nevv = (T[])(new Object[list.length * 2]);
		
		for ( int i = 0; i < nevv.length; i++) {
			nevv[i] = list[i];
		}
		list = nevv;
	}
	
	

}
