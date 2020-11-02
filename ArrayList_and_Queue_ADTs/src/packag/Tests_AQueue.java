package packag;

public class Tests_AQueue {

	public static void main(String[] args) throws FullQueueException, EmptyQueueException {
//---------------test for AQueue class-------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
			AQueue<Integer> myarrayque = new AQueue<Integer>();
				
			myarrayque.enqueue(1);
			myarrayque.enqueue(2);
			myarrayque.enqueue(3);
			myarrayque.enqueue(4);	
			myarrayque.enqueue(5);
			myarrayque.enqueue(6);
			myarrayque.enqueue(7);
			myarrayque.enqueue(8);
			myarrayque.enqueue(9);
			myarrayque.enqueue(10);
				
			System.out.println("----------Array implementation for Queue----------");
				
			System.out.println("Added elements");
			int size = myarrayque.size();
			for(int i = 0; i < size; i++) {	
				System.out.println(myarrayque.first());
				myarrayque.dequeue();
			}	
				
			System.out.println("");
			System.out.println("Number of elements:" + " " + myarrayque.size());
			
			System.out.println("");
			System.out.println("Is the Queue empty? ");
			System.out.println(myarrayque.isEmpty());
	}
}
