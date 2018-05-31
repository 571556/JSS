package jsjf;

import java.util.*;
import jsjf.exception.*;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T>{

	protected BinaryTreeNode<T> root;
	protected int modCount;
	
	public LinkedBinaryTree() {
		root = null;
	}
	
	public LinkedBinaryTree(T element) {
		root = new BinaryTreeNode<T>(element);
	}
	
	public LinkedBinaryTree(T element, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) {
		root = new BinaryTreeNode<T>(element);
		root.setLeft(left.root);
		root.setRight(right.root);
	}

	@Override
	public T getRootElement() {
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

	@Override
	public boolean contains(T targetElement) {
		// TODO Auto-generated method stub
		return false;
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
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorInOrder() {
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		inOrder(root, tempList);
		
		return new TreeIterator(tempList.iterator());
	}
	
	protected void inOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
		if(node != null) {
			inOrder(node.getLeft(), tempList);
			tempList.addToRear(node.getElement());
			inOrder(node.getRight(), tempList);
		}
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
	
	private class TreeIterator implements Iterator<T>{

		private Iterator<T> iterator;
		private int iteratorModCount;
		
		public TreeIterator(Iterator<T> iterator) {
			this.iterator = iterator;
			iteratorModCount = modCount;
		}
		
		
		@Override
		public boolean hasNext() throws ConcurrentModificationException {
			
			if(iteratorModCount != modCount)
				throw new ConcurrentModificationException();
			
			return (iterator.hasNext());
		}

		@Override
		public T next() throws ConcurrentModificationException, NoSuchElementException{
			
			if(!(iterator.hasNext()))
				throw new NoSuchElementException();
			
			T result = iterator.next();
			return result;

		}
		
		
		
	}
	
	
	
}
