package packag;

public class Tests_LArrayList {
	
	public static void main(String[] args) {
//---------------test for LArrayList class---------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
			LArrayList<Integer> mylinkedlist = new LArrayList<Integer>();
				
			mylinkedlist.add(0, 0);
			mylinkedlist.add(1, 1);
			mylinkedlist.add(2, 2);
			mylinkedlist.add(3, 3);
				
			System.out.println("----------Linkedlist implementation for Arraylist----------");
				
//-------------test for add method------------------------------------------------------------------------------------
			System.out.println("Added elements");
			for(int i = 0; i < mylinkedlist.size(); i++) {
				System.out.println(mylinkedlist.get(i));
			}
					
			System.out.println("");
			System.out.println("Number of elements:" + " " + mylinkedlist.size());
				
//-------------test for remove method---------------------------------------------------------------------------------
			System.out.println("Element(s) that are removed:");
			System.out.println(mylinkedlist.remove(0));
			System.out.println(mylinkedlist.remove(1));
				
			System.out.println("");
			System.out.println("Elements that are still in the arraylist");	
			for(int i = 0; i < mylinkedlist.size(); i++) {
				System.out.println(mylinkedlist.get(i));
			}
				
			System.out.println("");
			System.out.println("Number of elements:" + " " + mylinkedlist.size());

//---------------test for set method--------------------------------------------------------------------------------------
			mylinkedlist.set(0, 2);
			mylinkedlist.set(1, 4);
				
			System.out.println("Elements in the arraylist:");
			for(int i = 0; i < mylinkedlist.size(); i++) {
				System.out.println(mylinkedlist.get(i));
			}
//---------------test for isEmpty method-----------------------------------------------------------------------------------
			System.out.println("");
			System.out.println("Is the Arraylist empty? ");
			System.out.println(mylinkedlist.isEmpty());
	}
}
