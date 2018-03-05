package CH3;
import java.io.*;
import java.util.Scanner;
import jsjf.*;

public class Baklengs {

	public static void main(String[] args) {

		Scanner skriver = new Scanner(System.in);
		String lesInn = skriver.nextLine();
		String[] ord = lesInn.split("");
		ArrayStack<String> baklengs = new ArrayStack<String>();
		for (int i = 0; i < ord.length; i++) {
			baklengs.push(ord[i]);
		}
		for (int i = 0; i < ord.length; i++) {
			System.out.print(baklengs.pop());
		}
		skriver.close();
		
		
	}

}
