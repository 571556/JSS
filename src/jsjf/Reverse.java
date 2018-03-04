package jsjf;

public class Reverse<T>{

	private ArrayStack<T> stack;
	private Object[] set;
	private int elements;
	
	public Reverse(Object[] elNumber){
		
		set = elNumber;
		elements = set.length;
		stack = new ArrayStack<T>(elements);
		
	}
	
	public void executeReverse() {
		
		for (int i = 0; i < elements; i++)
			stack.push((T)set[i]);
			
		for (int i = 0; i < elements; i++)
			set[i] = stack.pop();
		
	}
	
	public Object[] getSet() {
		return this.set;
	}
	
}
