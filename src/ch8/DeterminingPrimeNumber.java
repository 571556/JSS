package ch8;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
public class DeterminingPrimeNumber {

	public static void main(String[] args) {
		
		int number = parseInt(showInputDialog("Enter a number to check if \n it is a prime number:"));
		
		System.out.println(isPrimeNumber(number));

	}
	
	public static boolean isPrimeNumber(int n) {
		
		
		if((n % 2) == 0 || (n % 3) == 0) 
			return false;
		
		return true;
		
		

	}
}
