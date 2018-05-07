package ch8;

public class Palindrome {

	public static void main(String[] args) {
		
		System.out.println(palindrom("deded"));

	}
	
	
	
	private static boolean palindrom(String s) {
		boolean result = false;
		
		if(s.length() <= 2) {
			if(s.length() == 1)
				result = true;
			else if(s.length() == 2)
				result = s.charAt(0) == s.charAt(1);
		}else
			result = s.charAt(0) == s.charAt(s.length()-1) && palindrom(s.substring(1, s.length()-1));
		
		return result;
	}

}
