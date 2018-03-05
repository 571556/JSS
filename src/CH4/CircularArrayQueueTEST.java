package CH4;
import jsjf.*;

public class CircularArrayQueueTEST {

	public static void main(String[] args) {

		CircularArrayQueue<String> queue = new CircularArrayQueue<String>();
		for (int i = 0; i < 11; i++)
			queue.enqueue("Element nummer " + i);
		
		System.out.println(queue.toString());
	}
	

}
