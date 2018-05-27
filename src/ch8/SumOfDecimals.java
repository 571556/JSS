package ch8;

import static java.lang.Integer.*;
import static java.lang.Double.*;

public class SumOfDecimals {

	public static void main(String[] args) {
		
		System.out.println(sumOfDecimals(2.323453901));

	}
	
	private static int sumOfDecimals(double d) {
	
		int result;
		String decimal = d + "";
		
		if(decimal.length() == 3)
			result = parseInt(decimal.substring(2, 3));
		else {
			result = parseInt(decimal.substring(decimal.length()-1, decimal.length()))
					+ sumOfDecimals(parseDouble(decimal.substring(0, decimal.length()-1)));
		}
		
		return result;
	}

}
