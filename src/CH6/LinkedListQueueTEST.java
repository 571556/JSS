package CH6;
import jsjf.*;

public class LinkedListQueueTEST {

	public static void main(String[] args) {
		LinkedListQueue<String> queue = new LinkedListQueue<String>();
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		
		for(int i = 0; i < 4; i++)
			System.out.println(queue.dequeue());
	}

}
