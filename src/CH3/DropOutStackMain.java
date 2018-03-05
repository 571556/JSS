package CH3;
import jsjf.*;
import java.io.*;
import java.util.Scanner;

public class DropOutStackMain {

	public static void main(String[] args) {

		DropOutStack<String> dos = new DropOutStack<String>(5);
		Scanner write = new Scanner(System.in);
		String insert;
		for (int i = 0; i < 6; i++) {
			insert = write.nextLine();
			dos.push(insert);
		}
		for(int j = 0; j < dos.getLength(); j++) {
			System.out.println(dos.pop());
		}
		
	}
	

}
