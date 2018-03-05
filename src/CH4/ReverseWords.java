package CH4;
import jsjf.*;
import java.io.*;
import java.util.Scanner;

public class ReverseWords {

	public static void main(String[] args) {

		Scanner write = new Scanner(System.in);
		String sentence = write.nextLine();
		String[] senWords = sentence.split(" ");
		String[] senReverse;
		LinkedStack<String> reversing = new LinkedStack<String>();
		String reversed;
		
		for (int i = 0; i < senWords.length; i++) {
			reversed = "";
			senReverse = senWords[i].split("");
			for (int j = 0; j < senReverse.length; j++) {
				reversing.push(senReverse[j]);
			}
			for (int k = 0; k < senReverse.length; k++) {
				reversed += reversing.pop();
			}
			reversed += " ";
			System.out.print(reversed);
		}
		write.close();
		
	}

}
