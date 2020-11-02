package packag;

public class Tests_LQueue {

	public static void main(String[] args) throws FullQueueException, EmptyQueueException {
//---------------test for LQueue class-------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
			LQueue<Integer> mylinkedque = new LQueue<Integer>();
				
			mylinkedque.enqueue(1);
			mylinkedque.enqueue(2);
			mylinkedque.enqueue(3);
			mylinkedque.enqueue(4);
			mylinkedque.enqueue(5);
				
			System.out.println("----------Linkedlist implementation for Queue----------");
				
//-------------test for add method------------------------------------------------------------------------------------
			System.out.println("Added elements");
			int size2 = mylinkedque.size();
			for(int i = 0; i < size2; i++) {
				System.out.println(mylinkedque.first());
				mylinkedque.dequeue();
			}	
				
			System.out.println("");
			System.out.println("Number of elements:" + " " + mylinkedque.size());
			System.out.println("");
			System.out.println("Is the Queue empty? ");
			System.out.println(mylinkedque.isEmpty());
	}

}
