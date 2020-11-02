package packag;

public class LArrayList<E> implements List <E> {
	
	public static class Node<E>{					//class for the creation of a Node
				
		private Node<E> next;						//variable that points to the next Node		
		private Node<E> prev;						//variable that points to the previous Node
		private E data;								//variable that stores the data that will be put into a Node
		
		/**constructor that makes a node*/
		public Node(Node<E> p, E d, Node<E> n) {
			this.prev = p;							//sets prev to the value of p
			this.data = d;							//sets data to the value of d
			this.next = n;							//sets next to the value of n
		}
	}
	
	private Node<E> header;							//variable for the head node
	private Node<E> trailer;						//variable for the tail node
	private int size = 0;		        			//variable that keeps track of the size of the linkedlist
	 
	
	/**constructor*/
	
//	public LArrayList() {
//		this.size = 0;								//sets the size to zero
//	}
	
	/**
	 * This method returns the number of elements in the array.
	 * This method also runs in O(1) time complexity since
	 * it takes only one basic operation to return the size of
	 * the array
	 */
	@Override
	public int size() {
		return this.size;							//return the size of the linked list
	}

	/**
	 * This method returns whether the list is empty or not.
	 * This method runs in O(4) which simplifies to O(1)
	 * time complexity since this method only  takes basic 
	 * operations to perform
	 */
	@Override
	public boolean isEmpty() {
		boolean empty;								//variable for the linkedlist having elements or not
		if (this.size == 0) {						//if the size of the linkedlist is equal to 0
			empty = true;							//set variable empty to true
		}
		else {
			empty = false;							//if the linkedlist is greater than 0 set variable empty to false
		}
		return empty;								//return empty
	}

	/**
	 * This method inserts an element e to be at index I, 
	 * shifting all elements after this. This method runs in
	 * O(n) time complexity since this method has two while loops
	 * that loop n amount of times
	 */
	@Override
	public void add(int I, E e) throws IndexOutOfBoundsException {
		if(I < 0 || I > this.size ) {									//if index is less than 0 or greater than the size of the linkedlist
			throw new IndexOutOfBoundsException("invalid index");		//throw exception
		}
		
		Node<E> newNode = new Node<E>(null, e, null);					//create a new Node with the element 'e'
		Node<E> first = header;											//variable that points to the header of the linkedlist
		Node<E> last = trailer;											//variable that points to the trailer of the linkedlist
		
		if(isEmpty()) {													//if linked list is empty
			header = newNode;											//set the header equal to the newly created Node
			trailer = newNode;											//set the trailer equal to the newly created Node
			//this.size++;
		}
		else {															//if linkedlist is not empty
			if(I == 0) {												//adding a node at the beginning of the linkedlist						
				newNode.next = header;									//the new node points to the same node that the header is pointing to
				header.prev = newNode;									//the header node then points back to the new node
				header = newNode;										//the header then becomes the newNode
			}
			else if(I == this.size - 1){								//adding a node at the end of the linkedlist
				newNode.prev = trailer;									//the prev link of the new node points to the trailer node
				trailer.next = newNode;									//the next link of the trailer node points the new node
				trailer = newNode;										//the trailer then becomes the newNode
			}
			int i = 0;													//i set to 0
			int j = this.size - 1;										//j set to the size of the linkedlist minus 1
			
			while (i < I - 1) {											//adding a node in the middle of a linkedlist
				first = first.next;										//move this link to the next node until it reaches the node that is before the specified index
				i++;													//increment i
			}
			while (j > I) {												//adding a node in the middle of a linkedlist											
				last = last.prev;										//move this link to the next node until it reaches the node that is after the specified index
				j--;													//decrement j
			}
			
			
			first.next = newNode;										//set the next link of the node that first points to, to the new node
			last.prev = newNode;										//set the prev link of the node that last points to, to the new node
			newNode.next = last;										//set the next link of the new node to the node that last points to
			newNode.prev = first;										//set the prev link of the new node to the node that first points to
			//this.size++;												//increment the size of the linkedlist by one
		}
		this.size++;
	}
	

	/**This method returns the element at index i, without 
	 * removing it
	 * 
	 * This method runs in O(n) time complexity if the index 
	 * is greater than 0, since the for loop within the 
	 * else block will loop for an unknown amount ('n' amount of times).
	 * If the index is equal to 0, then the method runs in
	 * O(1) time complexity since the if block only requires basic 
	 * operations to perform
	 */
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		if(i < 0 || i > this.size - 1) {								//if index is less than 0 or greater than the size of the array 
			throw new IndexOutOfBoundsException("invalid index");		//throw exception
		}
		
		E elem;															//variable that holds the data
		Node<E> first = header;											//variable that points to the header
		
		if(i == 0) {													//if the index is equal to the first node
			elem = first.data;											//elem is equal to the data of the first node	
		}
		else {															//if index is not equal to the first node
			for(int j = 0; j < i; j++) {								//loop until the pointer variable points to the node at the specified index
				first = first.next;
			}
			elem = first.data;											//elem is equal to data in the node at index i
		}
		return elem;													//return the element at index 'i'
	}

	/**This method removes and returns the element at index i, shifting 
	 * the elements after this
	 * If index 'i' is equal to 0 or the equal to the last index, then 
	 * the method runs in O(1) time complexity since it only takes 
	 * basic operations to perform the code in the if and else if block
	 * If index 'i' is in between 0 and the last index, then the method
	 * runs in O(n) time complexity since the for loop and the while loops
	 * will loop for an 'n' amount of times, in which 'n' is unknown
	 */
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		if(i < 0 || i > this.size - 1) {								//if index is less than 0 or greater than the size of the array 
			throw new IndexOutOfBoundsException("invalid index");		//throw exception
		}
		
		E elem;															//variable that holds the data
		Node<E> first = header;											//variable that points to the header
		Node<E> last = trailer;											//variable that points to the trailer
		
		if(i == 0) {													//if index is at header
			elem = first.data;											//elem is equal to the data at the header node
			first.data = null;											//the data in the header node becomes null
			header = first.next;										//header now becomes the next node
		}
		else if(i == this.size - 1) {									//if index is at trailer									
			elem = trailer.data;										//elem is equal to the data at the trailer node
			trailer.data = null;										//the data in the trailer node becomes null
			trailer = trailer.prev;										//trailer now becomes the previous node
		}
		else {															//if index is in between the header and trailer
			int j = 0;													//i set to 0
			int k = this.size - 1;										//j set to the size of the linkedlist minus 1
			Node<E> pointer = header;									//another variable that points the header
			
			for(int t = 0; t < i; t++) {								//this loop moves pointer to the specified node at index 'i'
				pointer = pointer.next;
			}
			
			elem = pointer.data;										//elem is equal to the data at the pointer node
			
			while(j < i - 1) {											//this loop moves first to the node whos next link points to the node at index 'i'
				first = first.next;
				j++;													//increment j by 1
			}
			while(k > i) {												//this loop moves last to the node who's prev link points to the node at index 'i'
				last = last.prev;
				k--;													//decrement k by 1
			}
			
			first.next = pointer.next;									//the node before the node at index 'i' points to the node after the node at index 'i'
			last.prev = pointer.prev;									//the node after the node at index 'i' points to the node before the node at index 'i'
			pointer.data = null;										//the element in the node at index 'i' becomes null
			
		}
		this.size--;
		return elem;													//returns the element in the node at index 'i'
	}

	/**This method replaces the element at index I with e, returning 
	 * the previous element at i.
	 * This method runs in O(1) time complexity if the index is 
	 * either 0 or the last index since the if and else if block
	 * in the method only needs basic operations to perform. If 
	 * the index is in between 0 and the last index, then 
	 * the method runs in O(n) time complexity since the else
	 * block in the method takes 'n' basic operations to complete
	 * due to the for loop
	 */
	@Override
	public E set(int I, E e) throws IndexOutOfBoundsException {
		if(I < 0 || I > this.size - 1) {								//if index is less than 0 or greater than the size of the array 
			throw new IndexOutOfBoundsException("invalid index");		//throw exception
		}
		
		E elem;															//variable that holds the data
		Node<E> pointer = header;										//variable that points to the header
		
		if(I == 0) {													//if index is at header
			elem = header.data;											//elem is equal to the data in the header node
			header.data = e;											//data in the header node becomes 'e'
		}
		else {															//if index is not the header
			for(int i = 1; i <= I; i++) {								//this loop moves pointer to the specified node at index 'i'
				pointer = pointer.next;
			}
			elem = pointer.data;										//elem is equal to the data at the pointer node
			pointer.data = e;											//the data in the pointer node is replaced with e
		}
		return elem;													//return the previous element
	}
	
	//For this class, a doubly linked list implementation was used instead of a singly linked list
	//for the arraylist since this implementation allows for the retrieval of any element possible, 
	//no matter what position of the list it is in. For example, in a singly linked list, it would 
	//be difficult to retrieve a previous element since each node only points to the next node, but 
	//in a doubly linked list, this operation is possible since each node not only points to the next 
	//node, but to the previous node as well.
	
	//In a properly implemented link list, the advantages of using that implementation over an array
	//implementation is that all the methods run in O(1) time complexity in the worst case. This is
	//due to the fact that elements do not need to be shifted in the add or remove methods when the index
	//is 0. The header of the linked list will be moved to the next element and in the set and get methods
	//since each node points to its previous and following node, an element can be retrieved or changed using
	//basic operations.
}
