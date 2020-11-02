package packag;


public class LQueue<E> implements Queue<E> {
	
	public static class Node<E>{					//class for the creation of a Node
		
		private Node<E> next;						//variable that points to the next Node		
		private E data;								//variable that stores the data that will be put into a Node
		
		/**constructor that makes a node*/
		public Node(E d, Node<E> n) {
			this.data = d;							//sets data to the value of d
			this.next = n;							//sets next to the value of n
		}
	}
	
	private Node<E> header;							//variable for the head node
	private Node<E> trailer;						//variable for the tail node
	private int size;								//variable that keeps track of the size of the Queue
	//private int f = 0;
	private int space = 10;							//default amount of space in the array
	
	public LQueue() {
		this.size = 0;								//this.size is initialized to 0
	}

	/**This method returns the number of elements in the queue
	 * This method also runs in O(1) time complexity since
	 * it takes only one basic operation to return the size of
	 * the array
	 **/
	@Override
	public int size() {
		return this.size;							//return the size of the linked list
	}

	/**This method tests whether the queue is empty
	 * This method runs in O(4) which simplifies to O(1)
	 * time complexity since this method only  takes basic 
	 * operations to perform
	 */
	@Override
	public boolean isEmpty() {
		boolean empty;								//variable for the Queue having elements or not
		if(this.size == 0) {						//if the size of the Queue is equal to 0
			empty = true;							//set variable empty to true
		}
		else {
			empty = false;							//if the Queue is greater than 0 set variable empty to false
		}
		return empty;								//return empty
	}

	/**This method inserts an element at the rear of the queue
	 * This method runs in O(1) time complexity since the method
	 * only takes basic operations to perform
	 */
	@Override
	public void enqueue(E e) throws FullQueueException {
		if(size() == space) {											//if the number of elements in the Queue is equal to the value space
			throw new FullQueueException("Queue is full");				//throw exception
		}
		
		Node<E> newNode = new Node<E>(e, null);							//create a new Node with the element 'e'
		
		if(isEmpty()) {													//if linked list is empty
			header = newNode;											//set the header equal to the newly created Node
			trailer = newNode;											//set the trailer equal to the newly created Node
		}
		else {
			trailer.next = newNode;										//the next link of the trailer node points the new node
			trailer = newNode;											//the trailer then becomes the newNode
		}
		this.size++;													//increase the size of the linked list by one
		
	}

	/**This method returns, but does not remove, the first element of the queue
	 * This method runs in O(1) time complexity since the method
	 * only takes basic operations to perform
	 **/
	@Override
	public E first() throws EmptyQueueException {
		if(isEmpty()) {												//if the Queue is empty
			throw new EmptyQueueException("Queue is empty");		//throw exception
		}
		return header.data;											//return the first element of the queue
	}

	/**This method removes and returns the first element of the queue
	 * This method runs in O(1) time complexity since the method
	 * only takes basic operations to perform
	 * */
	@Override
	public E dequeue() throws EmptyQueueException {
		if(isEmpty()) {												//if the Queue is empty
			throw new EmptyQueueException("Queue is empty");		//throw exception
		}
		
		Node<E> pointer = header;									//variable that points to the first node
		E elem = header.data;										//elem is equal to the data in the header node
		header.data = null;											//the data in the header node becomes null
		header = pointer.next;										//the next available becomes the new header
		this.size--;												//decrease the size of the linked list
		return elem;												//returns that was held in the previous header node
	}
	
//The advantages of using a linked list implementation instead of an array implementation is that you do not need
//a set size. For an array, a default size is needed for the Queue, but by implementing a linked list, you can add
//as much nodes as you want without worrying about the size of the Queue
}
