package ch9;
import static jsjf.Sort.*;

public class BubbleSortTest {

	public static void main(String[] args) {

		String[] data = {"a","b","b","j","a","b","c","e","u","r"};
		
		bubbleSort(data);
		
		
		printArray(data);

	}
	
	private static void printArray(String[] data) {
		for(int i = 0; i < data.length; i++)
			System.out.println(data[i]);
	}

}
