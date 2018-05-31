package ch9;

import static jsjf.Sort.*;

public class SortsMeasured {

	public static void main(String[] args) {
		
		String[] data1 = {"v","q","e","s","g","v","z","q","p","u","k","d","b","k","r","t","a"};
		String[] data2 = {"v","q","e","s","g","v","z","q","p","u","k","d","b","k","r","t","a"};
		String[] data3 = {"v","q","e","s","g","v","z","q","p","u","k","d","b","k","r","t","a"};
		String[] data4 = {"v","q","e","s","g","v","z","q","p","u","k","d","b","k","r","t","a"};
		String[] data5 = {"v","q","e","s","g","v","z","q","p","u","k","d","b","k","r","t","a"};
		String[] data6 = {"v","q","e","s","g","v","z","q","p","u","k","d","b","k","r","t","a"};
		
		String[] dataa1 = {"v","q","e","s","g","v","z","q","p","u","k","d","b","k","r","t","a"
				,"v","r","p","n","b","c","x","z","y","j","l","o","r","q","c","v","j","q","q",
				"n","q","w","t","t","k","n","h","b","q","r","f","f","s"};
		
		String[] dataa2 = {"v","q","e","s","g","v","z","q","p","u","k","d","b","k","r","t","a"
				,"v","r","p","n","b","c","x","z","y","j","l","o","r","q","c","v","j","q","q",
				"n","q","w","t","t","k","n","h","b","q","r","f","f","s"};
		String[] dataa3 = {"v","q","e","s","g","v","z","q","p","u","k","d","b","k","r","t","a"
				,"v","r","p","n","b","c","x","z","y","j","l","o","r","q","c","v","j","q","q",
				"n","q","w","t","t","k","n","h","b","q","r","f","f","s"};
		String[] dataa4 = {"v","q","e","s","g","v","z","q","p","u","k","d","b","k","r","t","a"
				,"v","r","p","n","b","c","x","z","y","j","l","o","r","q","c","v","j","q","q",
				"n","q","w","t","t","k","n","h","b","q","r","f","f","s"};
		String[] dataa5 = {"v","q","e","s","g","v","z","q","p","u","k","d","b","k","r","t","a"
				,"v","r","p","n","b","c","x","z","y","j","l","o","r","q","c","v","j","q","q",
				"n","q","w","t","t","k","n","h","b","q","r","f","f","s"};
		String[] dataa6 = {"v","q","e","s","g","v","z","q","p","u","k","d","b","k","r","t","a"
				,"v","r","p","n","b","c","x","z","y","j","l","o","r","q","c","v","j","q","q",
				"n","q","w","t","t","k","n","h","b","q","r","f","f","s"};
		
		String[] dataaa1 = {"a","b","c","d","e","f","g"};
		
		System.out.println(selectionSort(data1));
		printArray(data1);
		System.out.println(insertionSort(data2));
		printArray(data2);
		System.out.println(bubbleSort(data3));
		printArray(data3);
		System.out.println(gapSort(data4));
		printArray(data4);
		System.out.println(mergeSort(data5));
		printArray(data5);
		System.out.println(quickSort(data6));
		printArray(data6);
		
		System.out.println("\n" + "\n");
		
		System.out.println(selectionSort(dataa1));
		printArray(dataa1);
		System.out.println(insertionSort(dataa2));
		printArray(dataa2);
		System.out.println(bubbleSort(dataa3));
		printArray(dataa3);
		System.out.println(gapSort(dataa4));
		printArray(dataa4);
		System.out.println(mergeSort(dataa5));
		printArray(dataa5);
		System.out.println(quickSort(dataa6));
		printArray(dataa6);

		System.out.println("\n" + "\n");
		
		System.out.println(selectionSort(dataaa1));
		printArray(dataaa1);
		System.out.println(insertionSort(dataaa1));
		printArray(dataaa1);
		System.out.println(bubbleSort(dataaa1));
		printArray(dataaa1);
		System.out.println(gapSort(dataaa1));
		printArray(dataaa1);
		System.out.println(mergeSort(dataaa1));
		printArray(dataaa1);
		System.out.println(quickSort(dataaa1));
		printArray(dataaa1);

	}
	
	private static void printArray(Object[] data) {
		for(int i = 0; i < data.length; i++)
			System.out.print(data[i] + " ");
		System.out.println();
	}

}
