package ch10;

import java.util.Iterator;

import jsjf.BinaryTreeNode;
import jsjf.LinkedBinaryTree;

public class BinaryTreeTEST {

	public static void main(String[] args) {
		
		BinaryTreeNode<String> en = new BinaryTreeNode<String>("1");
		BinaryTreeNode<String> to = new BinaryTreeNode<String>("2");
		BinaryTreeNode<String> tre = new BinaryTreeNode<String>("3");
		BinaryTreeNode<String> fire = new BinaryTreeNode<String>("4");
		BinaryTreeNode<String> fem = new BinaryTreeNode<String>("5");
		BinaryTreeNode<String> syv = new BinaryTreeNode<String>("7");
		
		LinkedBinaryTree<String> syvt = new LinkedBinaryTree<String>("7");
		LinkedBinaryTree<String> tret = new LinkedBinaryTree<String>("3",null,syvt);
		LinkedBinaryTree<String> femt = new LinkedBinaryTree<String>("5");
		LinkedBinaryTree<String> firet = new LinkedBinaryTree<String>("4");
		LinkedBinaryTree<String> tot = new LinkedBinaryTree<String>("2",firet,femt);
		LinkedBinaryTree<String> ent = new LinkedBinaryTree<String>("1",tot,tret);
		
		Iterator<String> itr = ent.iteratorInOrder();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
}
