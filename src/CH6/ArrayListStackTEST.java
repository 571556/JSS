package CH6;
import jsjf.*;
public class ArrayListStackTEST {

	public static void main (String[] args) {
		
		ArrayListStack<String> stack = new ArrayListStack<String>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		
		for(int i = 0; i < 3; i++)
			System.out.println(stack.pop());
		
	}
}
