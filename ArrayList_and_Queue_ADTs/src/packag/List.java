package packag;

public interface List<E> {
	
	/**returns the number of elements*/
	public int size();
	
	/**Returns whether the list is empty*/
	public boolean isEmpty();
	
	/**Inserts an element e to be at index I, shifting all elements after this*/
	public void add(int I, E e) throws IndexOutOfBoundsException;
	
	/**Returns the element at index I, without removing it*/
	public E get(int i) throws IndexOutOfBoundsException;
	
	/**Removes and returns the element at index I, shifting the elements after this*/
	public E remove(int i) throws IndexOutOfBoundsException;
	
	/**Replaces the element at index I with e, returning the previous element at i*/
	public E set(int I, E e) throws IndexOutOfBoundsException;

}
