package jsjf;

import java.util.Iterator;

import jsjf.exception.ElementNotFoundException;

public class ArrayBinaryTree<T> implements Iterable<T>, BinaryTreeADT<T>{
	
	private T[] array;
	private int size;
	private int modCount;
	
	public ArrayBinaryTree() {
		array = (T[])(new Object[100]);
		modCount = 0;
	}
	
	public ArrayBinaryTree(T element) {
		array = (T[])(new Object[100]);
		array[0] = element;
		modCount = 0;
	}
	
	private void expand(){
		T[] array = (T[])(new Object[this.array.length * 2]);
		for(int i = 0; i < this.array.length; i++) {
			array[i] = this.array[i];
		}
		this.array = array;
	}
	
	public int getLeft(int node) {
		return 2 * node + 1;
	}
	
	public void setLeft(int node, T element) {
		array[2 * node + 1] = element;
	}
	
	public int getRight(int node) {
		return 2 * (node + 1);
	}
	
	public void setRight(int node, T element) {
		array[2 * (node + 1)] = element;
	}
	
	@Override
	public T getRootElement() {
		return array[0];
	}
	
	public int getRoot() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(T targetElement) {
		boolean result = false;
		
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		queue.enqueue(0);
		while(!queue.isEmpty() && !result) {
			int e = queue.dequeue();
			T element = array[e];
			
			if(element.equals(targetElement))
				result = true;
			else {
				queue.enqueue(getLeft(e));
				queue.enqueue(getRight(e));
			}
			
		}
		
		return result;
	}

	@Override
	public T find(T targetElement) throws ElementNotFoundException{
		
		int current = findNode(targetElement, 0);
		
		if(current == -1)
			throw new ElementNotFoundException("ArrayBinaryTree");
		
		return array[current];
	}
	
	private int findNode(T targetElement,int node) {
		
		if(array[node] == null)
			return -1;
		
		if(array[node].equals(targetElement))
			return node;
		
		int temp = findNode(targetElement, getLeft(node));
		
		if(temp == -1)
			temp = findNode(targetElement, getRight(node));
		
		return temp;
	}

	@Override
	public Iterator<T> iteratorInOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorPreOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorPostOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorLevelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
