package ch8;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		
		System.out.println(gcd(10,20));

	}
	
	public static int gcd(int a, int b) {
		
		int result;
		if(a >= b && a % b == 0)
			result = b;
		else if(a < b)
			result = gcd(b,a);
		else
			result = gcd(b,a % b);
		
		return result;
		
	}
	
	
	

}
