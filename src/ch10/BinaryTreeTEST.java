package ch10;

import java.util.Iterator;

import jsjf.BinaryTreeNode;
import jsjf.LinkedBinaryTreeNoList;

public class BinaryTreeTEST {

	public static void main(String[] args) {
		
		LinkedBinaryTreeNoList<String> syvt = new LinkedBinaryTreeNoList<String>("7");
		LinkedBinaryTreeNoList<String> tret = new LinkedBinaryTreeNoList<String>("3",null,syvt);
		LinkedBinaryTreeNoList<String> femt = new LinkedBinaryTreeNoList<String>("5");
		LinkedBinaryTreeNoList<String> firet = new LinkedBinaryTreeNoList<String>("4");
		LinkedBinaryTreeNoList<String> tot = new LinkedBinaryTreeNoList<String>("2",firet,femt);
		LinkedBinaryTreeNoList<String> ent = new LinkedBinaryTreeNoList<String>("1",tot,tret);
		
		Iterator<String> itr = ent.iteratorLevelOrder();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
}
