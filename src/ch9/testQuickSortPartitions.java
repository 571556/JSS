package ch9;

import static jsjf.Sort.*;

public class testQuickSortPartitions {

	public static void main(String[] args) {

		String[] data1 = {"v","q","e","s","g","v","z","q","p","u","k","d","b","k","r","t","a"
				,"v","r","p","n","b","c","x","z","y","j","l","o","r","q","c","v","j","q","q",
				"n","q","w","t","t","k","n","h","b","q","r","f","f","s"};
		
		String[] data2 = {"v","q","e","s","g","v","z","q","p","u","k","d","b","k","r","t","a"
				,"v","r","p","n","b","c","x","z","y","j","l","o","r","q","c","v","j","q","q",
				"n","q","w","t","t","k","n","h","b","q","r","f","f","s"};
		
		String[] dataaa1 = {"a","b","c","d","e","f","g"};
		
		String[] dataa1 = {"v","q","e","s","g","v","z","q","p","u","k","d","b","k","r","t","a"};
		String[] dataa2 = {"v","q","e","s","g","v","z","q","p","u","k","d","b","k","r","t","a"};
		
		System.out.println(quickSort(data1));
		printArray(data1);
		System.out.println(quickSort3pt(data2));
		printArray(data2);
		System.out.println(quickSort(dataa1));
		printArray(dataa1);
		System.out.println(quickSort3pt(dataa2));
		printArray(dataa2);
		System.out.println(quickSort(dataaa1));
		printArray(dataaa1);
		System.out.println(quickSort3pt(dataaa1));
		printArray(dataaa1);
		
		
	}
	
	private static void printArray(Object[] data) {
		for(int i = 0; i < data.length; i++)
			System.out.print(data[i] + " ");
		System.out.println();
	}

}
