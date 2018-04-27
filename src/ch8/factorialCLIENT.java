package ch8;

public class factorialCLIENT {

	public static void main(String[] args) {
		
		System.out.println(factorial(6));

	}
	
	private static int factorial(int num) {
		int result;
		
		if(num == 1)
			result = 1;
		else
			result = num * factorial(num-1);
		
		return result;
		
	}

}
