package ch8;

public class sumOfSquaresCLIENT {

	public static void main(String[] args) {

		System.out.println(sumOfSquares(154));
		
	}
	
	private static int sumOfSquares(int a) {
		int result;
		
		if(a == 1)
			result = 1;
		else
			result = a * a + sumOfSquares(a-1);
			
		return result;
	}

}
