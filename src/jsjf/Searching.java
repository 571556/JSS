package jsjf;

public class Searching {

	public static <T extends Comparable<T>> boolean linearSearch(T[] data,int min,int max,T target) {
		
		int index = min;
		boolean found = false;
		
		while(!found && index <= max) {
			found = data[index].equals(target);
			index++;
		}
		
		return found;
	}
	
	public static <T extends Comparable<T>> boolean binarySearch(T[] data,int min,int max,T target) {
		boolean found = false;
		int mid = (min + max)/2;
		
		if(min > max)
			return found;
		
		if(data[mid].compareTo(target) == 0)
			found = true;
		else if(data[mid].compareTo(target) < 0)
			found = binarySearch(data,min,mid-1,target);
		else if(data[mid].compareTo(target) > 0)
			found = binarySearch(data,mid+1,max,target);
		
		return found;
	}
	
	
}
