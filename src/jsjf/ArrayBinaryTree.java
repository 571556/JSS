package jsjf;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import jsjf.exception.ElementNotFoundException;

public class ArrayBinaryTree<T> implements Iterable<T>, BinaryTreeADT<T>{
	
	private T[] treeArray;
	private int modCount;
	private final static int ROOT = 0;
	
	public ArrayBinaryTree() {
		treeArray = (T[])(new Object[100]);
		modCount = 0;
	}
	
	public ArrayBinaryTree(T element) {
		treeArray = (T[])(new Object[100]);
		treeArray[0] = element;
		modCount = 0;
	}
	
	public ArrayBinaryTree(T element, ArrayBinaryTree<T> left, ArrayBinaryTree<T> right) {
		treeArray = (T[])(new Object[100]);
		treeArray[0] = element; 
		modCount = 0;
		
		if(left != null)
			insertLeftTree(left.treeArray, left.ROOT, getLeft(ROOT));
		
		if(right != null)
			insertRightTree(right.treeArray, right.ROOT, getRight(ROOT));
	}
	
	private void insertLeftTree(T[] leftTree, int leftTreePosition, int newTreePosition) {
		
		if(leftTree[leftTreePosition] != null) {
			treeArray[newTreePosition] = leftTree[leftTreePosition];
			insertLeftTree(leftTree, getLeft(leftTreePosition), getLeft(newTreePosition));
			insertLeftTree(leftTree, getRight(leftTreePosition), getRight(newTreePosition));
		}
		
	}
	
	private void insertRightTree(T[] rightTree, int rightTreePosition, int newTreePosition) {
		
		if(rightTree[rightTreePosition] != null) {
			treeArray[newTreePosition] = rightTree[rightTreePosition];
			insertRightTree(rightTree, getLeft(rightTreePosition), getLeft(newTreePosition));
			insertRightTree(rightTree, getRight(rightTreePosition), getRight(newTreePosition));
		}
	}
	
	private void expand(){
		T[] array = (T[])(new Object[this.treeArray.length * 2]);
		for(int i = 0; i < this.treeArray.length; i++) {
			array[i] = this.treeArray[i];
		}
		this.treeArray = array;
	}
	
	public int getLeft(int node) {
		return 2 * node + 1;
	}
	
	public void setLeft(int node, T element) {
		treeArray[2 * node + 1] = element;
	}
	
	public int getRight(int node) {
		return 2 * (node + 1);
	}
	
	public void setRight(int node, T element) {
		treeArray[2 * (node + 1)] = element;
	}
	
	@Override
	public T getRootElement() {
		return treeArray[0];
	}
	
	public int getRoot() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return (size() == 0);
	}

	@Override
	public int size() {
		int size = 0;
		
		return size;
	}

	@Override
	public boolean contains(T targetElement) {
		boolean result = false;
		
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		queue.enqueue(0);
		while(!queue.isEmpty() && !result) {
			int e = queue.dequeue();
			T element = treeArray[e];
			
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
		
		return treeArray[current];
	}
	
	private int findNode(T targetElement,int node) {
		
		if(treeArray[node] == null)
			return -1;
		
		if(treeArray[node].equals(targetElement))
			return node;
		
		int temp = findNode(targetElement, getLeft(node));
		
		if(temp == -1)
			temp = findNode(targetElement, getRight(node));
		
		return temp;
	}

	@Override
	public Iterator<T> iteratorInOrder() {
		T[] iArray = (T[])(new Object[size()]);
		LinkedQueue<T> queue = new LinkedQueue<T>();
		int position = 0;
		
		inOrder(queue,position);
		
		for(int i = 0; i < iArray.length; i++)
			iArray[i] = queue.dequeue();
		
		return new TreeIterator(iArray);
		
	}
	
	private void inOrder(LinkedQueue<T> queue, int position) {
		if(treeArray[position] != null) {
			inOrder(queue,getLeft(position));
			queue.enqueue(treeArray[position]);
			inOrder(queue,getRight(position));
		}
	}
	

	@Override
	public Iterator<T> iteratorPreOrder() {
		T[] iArray = (T[])(new Object[size()]);
		LinkedQueue<T> queue = new LinkedQueue<T>();
		int position = 0;
		
		preOrder(queue, position);
		
		for(int i = 0; i < iArray.length; i++)
			iArray[i] = queue.dequeue();
		
		return new TreeIterator(iArray);
	}
	
	private void preOrder(LinkedQueue<T> queue, int position) {
		if(treeArray[position] != null) {
			queue.enqueue(treeArray[position]);
			preOrder(queue,getLeft(position));
			preOrder(queue,getRight(position));
		}
	}

	@Override
	public Iterator<T> iteratorPostOrder() {
		T[] iArray = (T[])(new Object[size()]);
		LinkedQueue<T> queue = new LinkedQueue<T>();
		int position = 0;
		
		postOrder(queue, position);
		
		for(int i = 0; i < iArray.length; i++)
			iArray[i] = queue.dequeue();
		
		return new TreeIterator(iArray);
	}
	
	private void postOrder(LinkedQueue<T> queue, int position) {
		if(treeArray[position] != null) {
			postOrder(queue,getLeft(position));
			postOrder(queue,getRight(position));
			queue.enqueue(treeArray[position]);
		}
	}

	@Override
	public Iterator<T> iteratorLevelOrder() {
		return new TreeIterator(treeArray);
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class TreeIterator implements Iterator<T>{

		private T[] iteratorArray;
		private int iteratorModCount;
		private int current;
		
		public TreeIterator(T[] iArray) {
			iteratorArray = iArray;
			iteratorModCount = modCount;
			current = 0;
		}
		
		@Override
		public boolean hasNext() throws ConcurrentModificationException{
			
			if(iteratorModCount != modCount)
				throw new ConcurrentModificationException("ArrayBinaryTree");
			
			return (iteratorArray[current] != null);
		}

		@Override
		public T next() throws ConcurrentModificationException, NoSuchElementException{
			
			if(!hasNext()) {
				throw new NoSuchElementException("ArrayBinaryTree");
			}
			
			T result = iteratorArray[current];
			current++;
			return result;
		}
		
	}

}
