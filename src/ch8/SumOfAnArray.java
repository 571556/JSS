package ch8;

public class SumOfAnArray {

	public static void main(String[] args) {
		
		int[] argay = {1,3,4,5,6,23,4,1,2,4,2,3,5,6,4,2,1,7,8};
		System.out.println("The array length: " + argay.length);
		int sum = sumOfArray(argay,0,4);
		System.out.println("The sum: " + sum);

	}
	
	public static int sumOfArray(int[] array, int lRange, int uRange) {
		int s = 0;
		if(lRange == uRange)
			return array[lRange];
		else {
			s = array[lRange] + sumOfArray(array,lRange + 1,uRange);
		}
		
		return s;
	}

}
