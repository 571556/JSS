package CH4;
import jsjf.*;

public class ArrayDequeTEST {

	public static void main(String[] args) {

		ArrayDeque<String> deque = new ArrayDeque<String>();
		
		deque.insertFront("hallo");
		deque.insertRear("Heihei");
		System.out.println(deque.toString());
		
		
	}

}
