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
	
	public LinkedBinaryTreeNoList(T element, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) {
		root = new BinaryTreeNode<T>(element);
		root.setLeft(left.root);
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
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		preOrder(root,tempList);
		return new TreeIterator(tempList.iterator());
	}
	
	private void preOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
		if(node != null) {
			tempList.addToRear(node.getElement());
			preOrder(node.getLeft(),tempList);
			preOrder(node.getRight(),tempList);
		}
	}

	@Override
	public Iterator<T> iteratorPostOrder() {
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		postOrder(root,tempList);
		return new TreeIterator(tempList.iterator());
	}
	
	private void postOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
		if(node != null) {
			postOrder(node.getLeft(),tempList);
			postOrder(node.getRight(),tempList);
			tempList.addToRear(node.getElement());
		}
	}

	@Override
	public Iterator<T> iteratorLevelOrder() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class TreeIterator implements Iterator<T>{

		private T[] array;
		private int current;
		private int iteratorModCount;
		
		public TreeIterator() {
			iteratorModCount = modCount;
			current = 0;
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
