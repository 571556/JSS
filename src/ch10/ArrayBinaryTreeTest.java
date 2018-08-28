package ch10;

import java.util.Iterator;
import jsjf.*;

public class ArrayBinaryTreeTest {
	
	public static void main (String[] args) {

	ArrayBinaryTree<String> syvt = new ArrayBinaryTree<String>("7");
	ArrayBinaryTree<String> tret = new ArrayBinaryTree<String>("3",null,syvt);
	ArrayBinaryTree<String> femt = new ArrayBinaryTree<String>("5");
	ArrayBinaryTree<String> firet = new ArrayBinaryTree<String>("4");
	ArrayBinaryTree<String> tot = new ArrayBinaryTree<String>("2",firet,femt);
	ArrayBinaryTree<String> ent = new ArrayBinaryTree<String>("1",tot,tret);
	
	Iterator<String> itr = ent.iteratorLevelOrder();
	
	while(itr.hasNext()) {
		System.out.println(itr.next());
	  }
	
	}
	
}
