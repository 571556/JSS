package CH4;
import jsjf.*;

public class LinkedDropoutsStackTEST {

	public static void main(String[] args) {

		LinkedDropoutStack<String> dStack = new LinkedDropoutStack<>(5);
		
		for (int i = 0; i < 8; i++) {
			dStack.push("he" + i);
		}
		System.out.println(dStack.toString());
	}

}
