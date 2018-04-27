package kladd;

public class kladd {
	
	public static void main (String[] args) {
		
		String s1 = "a";
		String s2 = "b";
		String s3 = "c";
		String s4 = "a";
		String s5 = "d";
		Comparable comparableElement = (Comparable)s1;
		Comparable comparableElement2 = (Comparable)s2;
		Comparable comparableElement3 = (Comparable)s3;
		Comparable comparableElement4 = (Comparable)s4;
		
		System.out.println(s1.compareTo(s5));
	}

}
