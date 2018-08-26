package jsjf;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import jsjf.exception.ElementNotFoundException;

public class LinkedBinaryTreeNoList<T> implements BinaryTreeADT<T>, Iterable<T>{

	protected BinaryTreeNode<T> root;
	protected int modCount;
	
	public LinkedBinaryTreeNoList() {
		root = null;
	}
	
	public LinkedBinaryTreeNoList(T element) {
		root = new BinaryTreeNode<T>(element);
	}
	
	public LinkedBinaryTreeNoList(T element, LinkedBinaryTreeNoList<T> left, LinkedBinaryTreeNoList<T> right) {
		root = new BinaryTreeNode<T>(element);
		if(left != null)
			root.setLeft(left.root);
		
		if(right != null)
			root.setRight(right.root);
	}

	@Override
	public T getRootElement() {
		return root.getElement();
	}
	
	public BinaryTreeNode<T> getRoot(){
		return root;
	}

	@Override
	public boolean isEmpty() {
		if(size() == 0)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		return inOrderCount(root);
	}
	
	private int inOrderCount(BinaryTreeNode<T> node) {
		int count = 0;
		if(node != null) {
			count++;
			count += inOrderCount(node.getLeft());
			count += inOrderCount(node.getRight());
		}
		return count;
		
	}

	@Override
	public boolean contains(T targetElement) {
		T element = find(targetElement);
		
		if(element.equals(targetElement))
			return true;
		else
			return false;
	}
	
	public boolean containss(T targetElement) {
		return containsInOrderSearch(root,targetElement);
	}
	
	private boolean containsInOrderSearch(BinaryTreeNode<T> node,T targetElement) {
		
		if(node != null) {
			
			if(node.getElement().equals(targetElement))
				return true;
			else if(containsInOrderSearch(node.getLeft(),targetElement))
				return true;
			else if(containsInOrderSearch(node.getRight(),targetElement))
				return true;
			
		}
		return false;
	}
	
	public int depth(BinaryTreeNode<T> node, int level) {
		return depth(root,node,-1);
	}
	
	private int depth(BinaryTreeNode<T> currentNode, BinaryTreeNode<T> nodeToFind, int level) {
		int depth = level;
		int deeper = -1;
		
		if(currentNode != null) {
			depth++;
			if(currentNode.equals(nodeToFind))
				return depth;
			else {
				deeper = depth(currentNode.getLeft(),nodeToFind,depth);
				deeper = depth(currentNode.getRight(),nodeToFind,depth);
			}
			
		}
		
		return deeper;
		
	}

	@Override
	public T find(T targetElement) throws ElementNotFoundException{
		
		BinaryTreeNode<T> current = findNode(targetElement, root);
		
		if(current == null)
			throw new ElementNotFoundException("LinkedBinaryTree");
		
		return current.getElement();
		
	}
	
	private BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> next){
		
		if(next == null)
			return null;
		
		if(next.getElement().equals(targetElement))
			return next;
		
		BinaryTreeNode<T> temp = findNode(targetElement, next.getLeft());
		
		if(temp == null)
			temp = findNode(targetElement, next.getRight());
		
		return temp;
	}
	
	@Override
	public String toString() {
		Iterator<T> itr = iteratorInOrder();
		String s = "";
		
		while(itr.hasNext()) {
			s += itr.next().toString() + "\n";
		}
		return s;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorInOrder() {
		CircularArrayQueue<T> queue = new CircularArrayQueue<T>();

		inOrder(root, queue);
	
		T[] array = (T[])(new Object[queue.size()]);
		
		for(int i = 0; i < array.length; i++)
			array[i] = queue.dequeue();
		
		return new TreeIterator(array);
	}
	
	protected void inOrder(BinaryTreeNode<T> node, CircularArrayQueue<T> queue) {
		if(node != null) {
			inOrder(node.getLeft(), queue);
			queue.enqueue(node.getElement());
			inOrder(node.getRight(), queue);
		}
	}

	@Override
	public Iterator<T> iteratorPreOrder() {
		CircularArrayQueue<T> queue = new CircularArrayQueue<T>();
		preOrder(root,queue);
		T[] array = (T[])(new Object[queue.size()]);
		
		for(int i = 0; i < array.length; i++)
			array[i] = queue.dequeue();
		
		return new TreeIterator(array);
	}
	
	private void preOrder(BinaryTreeNode<T> node, CircularArrayQueue<T> queue) {
		if(node != null) {
			queue.enqueue(node.getElement());
			preOrder(node.getLeft(),queue);
			preOrder(node.getRight(),queue);
		}
	}

	@Override
	public Iterator<T> iteratorPostOrder() {
		CircularArrayQueue<T> queue = new CircularArrayQueue<T>();
		postOrder(root,queue);
		T[] array = (T[])(new Object[queue.size()]);
		
		for(int i = 0; i < array.length; i++)
			array[i] = queue.dequeue();
		
		return new TreeIterator(array);
	}
	
	private void postOrder(BinaryTreeNode<T> node, CircularArrayQueue<T> queue) {
		if(node != null) {
			postOrder(node.getLeft(),queue);
			postOrder(node.getRight(),queue);
			queue.enqueue(node.getElement());
		}
	}

	@Override
	public Iterator<T> iteratorLevelOrder() {
		CircularArrayQueue<BinaryTreeNode<T>> queue = new CircularArrayQueue<BinaryTreeNode<T>>();
		CircularArrayQueue<T> eQueue = new CircularArrayQueue<T>();
		BinaryTreeNode<T> node = root;
		queue.enqueue(node);
		
		while(!queue.isEmpty()) {
			node = queue.dequeue();
			if(node != null) {
				if(node.getElement() != null)
					eQueue.enqueue(node.getElement());
				queue.enqueue(node.getLeft());
				queue.enqueue(node.getRight());
			}
		}
		
		T[] elements = (T[])(new Object[eQueue.size()]);
		
		for (int i = 0; i < elements.length; i++) {
			elements[i] = eQueue.dequeue();
		}
		
		
		return new TreeIterator(elements);
	}
	
	private class TreeIterator implements Iterator<T>{

		private T[] array;
		private int current;
		private int iteratorModCount;
		
		public TreeIterator(T[] array) {
			this.array = (T[]) array;
			iteratorModCount = modCount;
			current = 0;
		}
		
		
		@Override
		public boolean hasNext() throws ConcurrentModificationException {
			
			if(iteratorModCount != modCount)
				throw new ConcurrentModificationException();
			
			if(current == array.length)
				return false;
			
			return (array[current] != null);
		}

		@Override
		public T next() throws ConcurrentModificationException, NoSuchElementException{
			
			if(!hasNext())
				throw new NoSuchElementException();
			
			T result = array[current];
			current++;
			return result;

		}
		
		
		
	}
	
}
