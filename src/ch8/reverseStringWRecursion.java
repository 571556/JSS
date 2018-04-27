package ch8;

public class reverseStringWRecursion {

	public static void main(String[] args) {
		
		System.out.println(reverse("hallo"));

	}
	
	private static String reverse(String word) {
		
		String result;
		if(word.length() == 1)
			result = word;
		else {
			result = word.charAt(word.length()-1) + reverse(word.substring(0,word.length()-1));	
		}
		
		
		return result;
	}

}
