package packag;

public class AArrayList<E> implements List <E> {

	private E[] arraylist;					//array used for storage
	private int size = 0;					//variable that keeps track of the size of the array
	private int space = 10;					//default amount of space in the array
	
	/**constructor*/
	public AArrayList() {
		this.arraylist = (E[]) new Object[space];			//initialize the array with the size of 'space'
	}
	
	/**
	 * This method returns the number of elements in the array.
	 * This method also runs in O(1) time complexity since
	 * it takes only one basic operation to return the size of
	 * the array
	 */
	@Override
	public int size() {
		return this.size;			//returns the size of the array
	}

	/**
	 * This method returns whether the list is empty or not.
	 * This method runs in O(4) which simplifies to O(1)
	 * time complexity since this method only  takes basic 
	 * operations to perform
	 */
	@Override
	public boolean isEmpty() {
		boolean empty;				//variable for the array having elements or not
		if (this.size == 0) {		//if the size of the array is equal to 0
			empty = true;			//set variable empty to true
		}
		else {
			empty = false;			//if the array is greater than 0 set variable empty to false
		}
		return empty;				//return empty
	}

	/**
	 * This method inserts an element e to be at index I, shifting all elements after this
	 * This method runs in O(n) time complexity since the for loop takes 'n' basic 
	 * operations to perform
	 * */
	@Override
	public void add(int I, E e) throws IndexOutOfBoundsException {
		if(I < 0 || I > this.size) {										//if index is less than 0 or greater than the size of the array, 
			throw new IndexOutOfBoundsException("invalid index");			//throw exception
		}
		this.size++;														//the size of the array is then increased by 1
		
		if(this.size == space) {											//if the number of elements in the array is equal to the default amount
			E[] tmplist = (E[]) new Object[2*space];						//apply the doubling method (make new array that is double the size of the original
			for(int i = 0; i < this.size; i++) {							//this loop adds the elements from the original array into the new array
				tmplist[i] = arraylist[i];
			}
			this.arraylist = tmplist;										//the original array now points to the new array
			space*= 2;														//the default space in the array gets doubled
		}
		
		int sizeCpy = this.size - 1;										//variable sizeCpy is equal to the last index of the array
		for(int i = 0; i < this.size; i++) {								//loops through the entire array
			if(i == I) {													//if 'i' is equal to 'I'
				while(sizeCpy > i) {										//while sizeCpy is greater than 'i'
					this.arraylist[sizeCpy] = this.arraylist[sizeCpy - 1];	//shift elements to the right
					sizeCpy--;
				}
			}
			continue;														//continue through the loop
		}
		this.arraylist[I] = e;												//the space at index 'I' then becomes the element 'e'
	}

	/**
	 * This method returns the element at index i, without removing it
	 * This method runs in O(1) time complexity since it only takes basic
	 * operations to perform
	 */
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		if(i < 0 || i > this.size - 1) {									//if index is less than 0 or greater than the size of the array
			throw new IndexOutOfBoundsException("invalid index");			//throw exception
		}
		return this.arraylist[i];											//return the element in the array at index 'i'
	}

	/**
	 * This method removes and returns the element at index I, shifting 
	 * the elements after this. This method runs in O(n) time complexity 
	 * since the for loop takes 'n' basic operations to perform
	 * */
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		if(i < 0 || i > this.size - 1) {							//if index is less than 0 or greater than the last index, 
			throw new IndexOutOfBoundsException("invalid index");	//throw exception
		}
		
		E elem = arraylist[i];										//This variable stores the element at the specified index
		
		int sizeCpy = this.size - 1;								//variable sizeCpy is equal to the last index of the array
		for(int j = 0; j < this.size; j++) {						//loops through the entire array
			if(j == i) {											//if j is equal to i
				int k = j;											//set k to equal j
				while(k < sizeCpy) {								//while k is less than sizeCpy
					this.arraylist[k] = this.arraylist[k + 1];		//shift elements to the left
					k++;											//increment k by 1
				}
			}
			continue;												//continue through the loop
		}
		arraylist[this.size - 1] = null;							//the last element gets updated to null as it gets copied to the index before it
		this.size--;												//the size of the array decreases by 1
		return elem;												//returns the element that was removed
	}

	/**
	 * Replaces the element at index I with e, returning 
	 * the previous element at i. This method runs in O(1) time
	 * complexity since it only takes basic operations to 
	 * perform the task
	 */
	@Override
	public E set(int I, E e) throws IndexOutOfBoundsException {
		if(I < 0 || I > this.size - 1) {							//if index is less than 0 or greater than the size of the array, 
			throw new IndexOutOfBoundsException("invalid index");	//throw exception
		}
		
		E elem = arraylist[I];										//This variable stores the element at the specified index
		arraylist[I] = e;											//Element at index 'I' is set to 'e'
		return elem;												//returns the previous element
	}
	
//The advantages of an array based implementation over a linked list implementation is that the get and set methods run in O(1)
//time complexity in the worst case. This is possible since in the get and set methods only contain basic operations such as 
//retrieving from memory, assigning a value to a variable, and returning a value. These operations do not require that the 
//algorithm loop through the array of 'n' elements, 'n' times.
	
//The disadvantages of an array based implementation is that the add and remove methods run in O(n) time complexity in the worst
//case. A worst case scenario for add is when index 'i' is 0. This will cause the 'n' number of elements within the array to be 
//shifted forward to make space. The worst case scenario for remove is when index 'i' is 0 as well. This will cause the (n - 1)
//number of elements to shifted backward to fill the space of removed element.
}
