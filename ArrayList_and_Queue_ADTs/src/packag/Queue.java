package packag;

public interface Queue<E> {

	/**Returns the number of elements in the queue*/
	public int size();
	
	/**Tests whether the queue is empty*/
	public boolean isEmpty();
	
	/**Inserts an element at the rear of the queue*/
	public void enqueue(E e) throws FullQueueException;
	
	/**Returns, but does not remove, the first element of the queue*/
	public E first() throws EmptyQueueException;
	
	/**Removes and returns the first element of the queue*/
	public E dequeue() throws EmptyQueueException;
}
