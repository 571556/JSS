package jsjf;

import java.util.Iterator;

public class ArrayBinaryTree<T> implements Iterable<T>, BinaryTreeADT<T>{
	
	private T[] array;
	private int size;
	private int modCount;
	
	public ArrayBinaryTree() {
		array = (T[])(new Object[100]);
	}
	
	public ArrayBinaryTree(T element) {
		array = (T[])(new Object[100]);
		array[0] = element;
	}
	
	public ArrayBinaryTree(T element, ArrayBinaryTree<T> right, ArrayBinaryTree<T> left) {
		array[0] = element;
		array[1] = left.array[0];
		array[2] = right.array[0];
		int position = 1;
		for(int i = 0; i < left.size; i++) {
			
		}
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
	
	public int getRight(int node) {
		return 2 * (node + 1);
	}
	
	@Override
	public T getRootElement() {
		return array[0];
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
		
		return false;
	}

	@Override
	public T find(T targetElement) {
		
		return null;
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
