package kladd;

import jsjf.LinkedList;
import static jsjf.Sort.*;
import jsjf.ListADT;

public class kladd {
	
	public static void main (String[] args) {

		
		Integer[] tall = {1,2,6,3,5,8,9};
		bubbleSort(tall);
		
		for(int i = 0; i < tall.length; i++)
			System.out.println(tall[i] + " ");
	}
	
}
