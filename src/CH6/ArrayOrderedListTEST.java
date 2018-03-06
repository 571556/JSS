package CH6;
import jsjf.*;

public class ArrayOrderedListTEST {

	public static void main(String[] args) {
		
		ArrayOrderedList<String> list = new ArrayOrderedList<String>();
		list.add("b");
		list.add("e");
		list.add("a");

		System.out.println(list.toString());
	}

}
