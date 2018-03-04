package jsjf;
import jsjf.exception.*;
import java.util.Iterator.*;

public class LinkedStackWDummy<T> implements StackADT<T> {

	private int count;
	private LinearNode<T> top;
	
	public LinkedStackWDummy(){
		count = 0;
		top = null;
	}
	
	public LinkedStackWDummy(T element) {
		count = 0;
		top = 
	}
	
	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
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
	
}
