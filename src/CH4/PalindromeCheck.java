package CH4;
import jsjf.*;
import java.util.Scanner;

public class PalindromeCheck {

	public static void main(String[] args) {

		LinkedQueue<String> palQ = new LinkedQueue<>();
		ArrayStack<String> palS = new ArrayStack();
		Scanner write = new Scanner(System.in);
		String toCheck = write.nextLine();
		String[] check = toCheck.split("");
		
		String palQs = "";
		String palSs = "";
		
		for (int i = 0; i < check.length; i++) {
			palQ.enqueue(check[i]);
			palS.push(check[i]);
		}
		
		for (int i = 0; i < check.length; i++) {
			palQs += palQ.dequeue();
			palSs += palS.pop();
		}
		
		boolean palindrom = (palQs.equals(palSs));
		
		System.out.println("Stack reversed:   " + palSs + "\n" + "Queue unreversed: " + palQs + 
				"\n" + "The word is a palindrom: " + palindrom);
		
		
	}

}
