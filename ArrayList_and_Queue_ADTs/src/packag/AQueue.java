package packag;

public class AQueue<E> implements Queue<E> {

	private E[] arraylist;											//array used for storage
	private int size = 0;											//variable that keeps track of the size of the array
	private int f = 0;												//variable for the front of the Queue												
	private int space = 10;											//default amount of space in the array
	
	/**constructor*/
	public AQueue() {
		this.arraylist = (E[]) new Object[space];					//initialize the array with the size of 'space'
	}
	
	/**
	 * This method returns the number of elements in the array.
	 * This method also runs in O(1) time complexity since
	 * it takes only one basic operation to return the size of
	 * the array
	 */
	@Override
	public int size() {
		return this.size;											//returns the size of the array
	}

	/**
	 * This method returns whether the list is empty or not.
	 * This method runs in O(4) which simplifies to O(1)
	 * time complexity since this method only  takes basic 
	 * operations to perform
	 */
	@Override
	public boolean isEmpty() {
		boolean empty;												//variable for the Queue having elements or not
		if(this.size == 0) {										//if the size of the Queue is equal to 0
			empty = true;											//set variable empty to true
		}
		else {
			empty = false;											//if the Queue is greater than 0 set variable empty to false
		}
		return empty;												//return empty
	}

	/**This method inserts an element at the rear of the queue.
	 * This method runs in O(1) time complexity since the
	 * method only requires basic operations to perform.
	 */
	@Override
	public void enqueue(E e) throws FullQueueException {
		if(this.size == space) {									//if the number of elements in the Queue is equal to the value space
			throw new FullQueueException("Queue is full");			//throw exception
		}

		
		int next = (f + this.size) % space;							//variable 'next' is equal to the next available cell
		this.arraylist[next] = e;									//insert the element 'e' into index 'next'
		this.size++;												//increment the size by 1
	}

	/**This method returns, but does not remove, the first 
	 * element of the queue. This method runs in O(1) time
	 * complexity since the method only requires basic
	 * operations to perform.
	 */
	@Override
	public E first() throws EmptyQueueException {
		if(isEmpty()) {												//if the Queue is empty
			throw new EmptyQueueException("Queue is empty");		//throw exception
		}
		return this.arraylist[f];									//return the first element.
	}

	/**This method removes and returns the first element of the queue.
	 * This method runs in O(1) time complexity since the method only
	 * requires basic operations to perform.
	 */
	@Override
	public E dequeue() throws EmptyQueueException {
		if(isEmpty()) {												//if the Queue is empty
			throw new EmptyQueueException("Queue is empty");		//throw exception
		}
		E elem = this.arraylist[f];									//elem is equal to the first element in the Queue
		this.arraylist[f] = null;									//the first element in the Queue is equal to null
		f = (f + 1) % space;										//'f' is moved to the next index
		this.size--;												//decrement size by 1
		return elem;												//return elem
	}

//The advantages of using an array implementation instead of a linked list implementation is that you do not have to create
//a new node when the add method is called, since the size of the Queue is fixed. By creating a new node for every add method
//call, it uses up unnecessary memory, that could slow down the algorithm
}
