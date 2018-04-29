package ch8;

public class Palindrome {

	public static void main(String[] args) {
		
		System.out.println(palindrom("hallo"));

	}
	
	private static boolean palindrom(String s) {
		boolean result = false;
		String reverse = reverse(s);
		if()
			
			
	}
	
	private static void palindrom(String s,String d) {
		
	}
	
	private static String reverse(String s) {
		String result;
		
		if(s.length() == 1) 
			result = s;
		else
			result = s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
		
		return result;
	}

}
