package CH6;
import jsjf.*;

public class LinkedListStackTEST {

	public static void main(String[] args) {

		LinkedListStack<String> stack= new LinkedListStack<String>();
		stack.push("Hallo");
		stack.push("Heihei");
		
		System.out.println(stack.toString()+"\n");
		System.out.println(stack.pop());
	}

}
