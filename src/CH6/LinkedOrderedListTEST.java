package CH6;

import jsjf.*;

public class LinkedOrderedListTEST {

	public static void main(String[] args) {
		
		LinkedOrderedList<String> list = new LinkedOrderedList<String>();
		list.add("b");
		list.add("e");
		list.add("a");
		list.add("f");
		list.add("c");
		list.add("b");
		list.add("a");

		System.out.println(list.toString());

	}
	
}
