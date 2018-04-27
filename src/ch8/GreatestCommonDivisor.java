package ch8;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		
		System.out.println(gcd(10,20));

	}
	
	public static int gcd(int a, int b) {
		
		int result;
		int var1;
		int var2;
		
		if ( a % b == 0 )
			result = b;
		else
			result = gcd(b,a);
		
		return result;	
		
	}
	
	private static int help(int a, int b) {
		return 0;
	}
	
	

}
