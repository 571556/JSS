package jsjf;

public class Sort {

	public static <T extends Comparable<T>> String selectionSort(T[] data) {
		long startTime = System.nanoTime();
		int min;
		int comparisons = 0;
		
		for(int index = 0; index < data.length-1; index++) {
			min = index;
			for(int scan = index+1; scan < data.length; scan++) {
				comparisons++;
				if(data[scan].compareTo(data[min])<0)
					min = scan;
				
			}
			
			swap(data,min,index);
		}
		
		long endTime = System.nanoTime();
		long time = (endTime - startTime);
		return "Number of comparisons: " + comparisons + " | Time used: " + time;
		
	}
	
	public static <T extends Comparable<T>> String insertionSort(T[] data) {
		long startTime = System.nanoTime();
		int comparisons = 0;
		for(int index = 1; index < data.length; index++) {
			T key = data[index];
			int position = index;
			
			while(position > 0 && data[position-1].compareTo(key) > 0) {
				comparisons++;
				data[position] = data[position-1];
				position--;
				}
			
			data[position] = key;
			
			}
		
		long endTime = System.nanoTime();
		long time = (endTime - startTime);
		return "Number of comparisons: " + comparisons + " | Time used: " + time;
		
	}
	
	public static <T extends Comparable<T>> String bubbleSort(T[] data) {
		long startTime = System.nanoTime();
		int comparisons = 0;
		int position, scan, swaps;
		boolean pass;
		
		for(position = data.length-1; position >= 0; position--) {
			pass = false;
			swaps = 0;
			for(scan = 0; scan <= position-1; scan++) {
				comparisons++;
				if(data[scan].compareTo(data[scan+1]) > 0) {
					swap(data,scan,scan+1);
					swaps++;
				}
				
			}
			pass = true;
			if(swaps == 0 && pass == true)
				position = 0;
		}
		long endTime = System.nanoTime();
		long time = (endTime - startTime);
		return "Number of comparisons: " + comparisons + " | Time used: " + time;
		
	}
	
	public static <T extends Comparable<T>> String gapSort(T[] data) {
		long startTime = System.nanoTime();
		int comparisons = 0;
		int position, scan;
		for(position = data.length - 1; position > 0; position = position - 2) {
			for(scan = 0; scan < data.length; scan++) {
				if((scan + position) < data.length) {
					comparisons++;
					if(data[scan].compareTo(data[scan + position]) > 0)
						swap(data ,scan ,scan + position);
				}
			}
		}
		
		long endTime = System.nanoTime();
		long time = (endTime - startTime);
		return "Number of comparisons: " + comparisons + " | Time used: " + time;
	}
	
	public static <T extends Comparable<T>> String mergeSort(T[] data) {
		long startTime = System.nanoTime();
		int comparisons = mergeSort(data, 0, data.length - 1);
		long endTime = System.nanoTime();
		long time = (endTime - startTime);
		return "Number of comparisons: " + comparisons + " | Time used: " + time;
	}
	
	private static <T extends Comparable<T>> int mergeSort(T[] data, int min, int max) {
		int comparisons = 0;
		if(min < max) {
			int mid = (min + max) / 2;
			int comparisons1 = mergeSort(data, min, mid);
			int comparisons2 = mergeSort(data, mid + 1, max);
			comparisons = merge(data,min,mid,max) + comparisons1 + comparisons2;
		}
		return comparisons;
	}
	
	private static <T extends Comparable<T>> int merge(T[] data, int first, int mid, int last) {
		T[] temp = (T[])(new Comparable[data.length]);
		
		int comparisons = 0;
		int first1 = first, last1 = mid;
		int first2 = mid+1, last2 = last;
		int index = first1;
		
		while (first1 <= last1 && first2 <= last2) {
			comparisons++;
			if(data[first1].compareTo(data[first2]) < 0) {
				temp[index] = data[first1];
				first1++;
			}else {
				temp[index] = data[first2];
				first2++;
			}
			
			index++;
		}
		
		while(first1 <= last1) {
			temp[index] = data[first1];
			first1++;
			index++;
		}
		
		while(first2 <= last2) {
			temp[index] = data[first2];
			first2++;
			index++;
		}
		
		for(index = first; index <= last; index++) {
			data[index] = temp[index];
		}
		
		return comparisons;
		
	}
	
	public static <T extends Comparable<T>> String quickSort(T[] data) {
		long startTime = System.nanoTime();
		int comparisons = quickSort(data,0,data.length-1);
		long endTime = System.nanoTime();
		long time = (endTime - startTime);
		return "Number of comparisons: " + comparisons + " | Time used: " + time;
	}
	
	private static <T extends Comparable<T>> int quickSort(T[] data,int min,int max) {
		int comparisons = 0;
		int[] cip = new int[2];
		cip[1] = 0;
		if(min < max) {
			cip = partition(data,min,max);
			int indexofpartition = cip[0];
			comparisons = cip[1];
			comparisons += quickSort(data,min,indexofpartition-1);
			comparisons += quickSort(data,indexofpartition+1,max);
		}
		return comparisons;
	}
	
	private static <T extends Comparable<T>> int[] partition(T[] data,int min,int max) {
		int[] cip = new int[2];
		int comparisons = 0;
		T partitionelement;
		int left,right;
		int middle = (min + max)/2;
		
		partitionelement = data[middle];
		
		swap(data,middle,min);
		left = min;
		right = max;
		
		while(left < right) {
		
			while(left < right && data[left].compareTo(partitionelement) <= 0) {
				left++;
				comparisons++;
			}
				
		
			while(data[right].compareTo(partitionelement) > 0) {
				right--;
				comparisons++;
			}
		
			if(left < right)
				swap(data,left,right);
		
		}
		
		swap(data,min,right);
		cip[0] = right;
		cip[1] = comparisons;
		return cip;
	}
	
	public static <T extends Comparable<T>> String quickSort3pt(T[] data) {
		long startTime = System.nanoTime();
		int comparisons = quickSort3pt(data,0,data.length-1);
		long endTime = System.nanoTime();
		long time = (endTime - startTime);
		return "Number of comparisons: " + comparisons + " | Time used: " + time;
	}
	
	private static <T extends Comparable<T>> int quickSort3pt(T[] data,int min,int max) {
		int comparisons = 0;
		int[] cip = new int[2];
		cip[1] = 0;
		if(min < max) {
			cip = partition3(data,min,max);
			int indexofpartition = cip[0];
			comparisons = cip[1];
			comparisons += quickSort3pt(data,min,indexofpartition-1);
			comparisons += quickSort3pt(data,indexofpartition+1,max);
		}
		return comparisons;
	}
	
	private static <T extends Comparable<T>> int[] partition3(T[] data,int min,int max) {
		int[] cip = new int[2];
		int comparisons = 0;
		T partitionelement;
		int left,right;
		int middle = (min + max)/2;
		
		if(((data[min].compareTo(data[middle]) > 0) && (data[min].compareTo(data[max]) <= 0)) ||
				((data[min].compareTo(data[max]) > 0) && (data[min].compareTo(data[middle]) <= 0)))
			partitionelement = data[min];
		else if(((data[middle].compareTo(data[min]) > 0) && (data[middle].compareTo(data[max]) <= 0)) ||
				((data[middle].compareTo(data[max]) > 0) && (data[middle].compareTo(data[min]) <= 0)))
			partitionelement = data[middle];
		else
			partitionelement = data[max];
		
		swap(data,middle,min);
		left = min;
		right = max;
		
		while(left < right) {
		
			while(left < right && data[left].compareTo(partitionelement) <= 0) {
				left++;
				comparisons++;
			}
				
		
			while(data[right].compareTo(partitionelement) > 0) {
				right--;
				comparisons++;
			}
		
			if(left < right)
				swap(data,left,right);
		
		}
		
		swap(data,min,right);
		cip[0] = right;
		cip[1] = comparisons;
		return cip;
	}
	
	private static <T extends Comparable<T>> void swap(T[] data, int index1,int index2) {
		
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
		
	}
	
}
