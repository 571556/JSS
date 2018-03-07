package CH6;
import jsjf.LinkedUnorderedList;
public class LinkedUnorderedListTEST {

	public static void main(String[] args) {
		
		LinkedUnorderedList<String> list = new LinkedUnorderedList<String>();
		list.addToFront("a");
		list.addToRear("e");
		list.addToRear("e");
		list.addToFront("a");
		list.addAfter("g", "e");
		System.out.println(list.toString());
	}
}
