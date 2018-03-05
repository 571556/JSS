package CH4;
import jsjf.*;

public class LinkedDequeTEST {

	public static void main(String[] args) {

		LinkedDeque<String> deque = new LinkedDeque<String>();
		deque.insertFront("Hallo");
		deque.insertFront("Hallo");
		deque.insertFront("Hallo");
		deque.insertRear("Heihei");
		deque.insertRear("Heihei");
		deque.insertRear("Heihei");
		deque.removeRear();
		deque.removeFront();
		String s = deque.removeFront();
		System.out.println(deque.toString());
		System.out.println("\n" + s);
	}

}
