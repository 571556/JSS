package jsjf;
import jsjf.exception.*;

public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {

	public ArrayOrderedList() {
		super();
	}

	@Override
	public void add(T element) {
		
		if(!(element instanceof Comparable))
			throw new NonComparableElementException("element");
		
		Comparable<T> comparableElement = (Comparable<T>)element;
		
		if(size() == list.length)
			expandCapacity();
		int scan = 0;
		
		while (scan < rear && comparableElement.compareTo(list[scan]) > 0)
			scan++;
		
		for(int shift = rear; shift > scan; shift--)
			list[shift] = list[shift-1];
		
		list[scan] = element;
		rear++;
		modCount++;
		
	}
	
	private void expandCapacity() {
		T[] newList = (T[])(new Object[list.length * 2]);
		for(int i = 0; i < list.length; i++)
			newList[i] = list[i];
		
		list = newList;
	}
	
	
	
	
}
