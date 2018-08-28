package ch10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jsjf.ArrayBinaryTree;

import org.junit.jupiter.api.*;

	class ArrayBinaryTreeTestJUNIT {

		ArrayBinaryTree<String> syvt = new ArrayBinaryTree<String>("7");
		ArrayBinaryTree<String> tret = new ArrayBinaryTree<String>("3",null,syvt);
		ArrayBinaryTree<String> femt = new ArrayBinaryTree<String>("5");
		ArrayBinaryTree<String> firet = new ArrayBinaryTree<String>("4");
		ArrayBinaryTree<String> tot = new ArrayBinaryTree<String>("2",firet,femt);
		ArrayBinaryTree<String> ent = new ArrayBinaryTree<String>("1",tot,tret);
		
		@BeforeEach
		public void setUp() {
			
		}
		
		@AfterEach
		public void tearDown() {
			
		}
	
	
}
