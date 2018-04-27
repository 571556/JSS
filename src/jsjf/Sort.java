package jsjf;

public class Sort {

	public static <T extends Comparable<T>> void selectionSort(T[] data) {
		int min;
		
		for(int index = 0; index < data.length-1; index++) {
			min = index;
			for(int scan = index+1; scan < data.length; scan++)
				if(data[scan].compareTo(data[min])<0)
					min = scan;
			
			swap(data,min,index);
		}
		
	}
	
	public static <T extends Comparable<T>> void insertionSort(T[] data) {
		for(int index = 1; index < data.length; index++) {
			T key = data[index];
			int position = index;
			
			while(position > 0 && data[position-1].compareTo(key) > 0) {
				data[position] = data[position-1];
				position--;
				}
			
			data[position] = key;
			
			}
		
	}
	
	public static <T extends Comparable<T>> void bubbleSort(T[] data) {
		
		int position, scan;
		
		for(position = data.length-1; position >= 0; position--) {
			for(scan = 0; scan <= position-1; scan++) {
				if(data[scan].compareTo(data[scan+1]) > 0)
					swap(data,scan,scan+1);
			}
		}
		
	}
	
	public static <T extends Comparable<T>> void quickSort(T[] data) {
		quickSort(data,0,data.length-1);
	}
	
	private static <T extends Comparable<T>> void quickSort(T[] data,int min,int max) {
		if(min < max) {
			int indexofpartition = partition(data,min,max);
			quickSort(data,min,indexofpartition-1);
			quickSort(data,indexofpartition+1,max);
		}
	}
	
	private static <T extends Comparable<T>> int partition(T[] data,int min,int max) {
		T partitionelement;
		int left,right;
		int middle = (min + max)/2;
		
		partitionelement = data[middle];
		
		swap(data,middle,min);
		left = min;
		right = max;
		
		while(left < right) {
		
			while(left < right && data[left].compareTo(partitionelement) <= 0)
				left++;
		
			while(data[right].compareTo(partitionelement) > 0)
				right--;
		
			if(left < right)
				swap(data,left,right);
		
		}
		
		swap(data,min,right);
		return right;
	}
	
	private static <T extends Comparable<T>> void swap(T[] data, int index1,int index2) {
		
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
		
	}
	
}
