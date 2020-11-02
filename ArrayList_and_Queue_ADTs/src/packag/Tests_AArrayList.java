package packag;

public class Tests_AArrayList {

	public static void main(String[] args) {
//---------------test for AArrayList class---------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
			AArrayList<Integer> myarraylist = new AArrayList<Integer>();
			myarraylist.add(0, 0);
			myarraylist.add(1, 1);
			myarraylist.add(2, 3);
			myarraylist.add(3, 4);
			myarraylist.add(4, 5);
			myarraylist.add(5, 6);
			myarraylist.add(6, 7);
			myarraylist.add(7, 8);
			myarraylist.add(8, 9);
			myarraylist.add(9, 10);
			myarraylist.add(10, 11);
			myarraylist.add(11, 12);
				
//-------------test for add method------------------------------------------------------------------------------------
			System.out.println("----------Array implementation for Arraylist----------");
			System.out.println("Added elements");
			for(int i = 0; i < myarraylist.size(); i++) {
				System.out.println(myarraylist.get(i));
			}
				
			System.out.println("");
			System.out.println("Number of elements:" + " " + myarraylist.size());
				
//-------------test for remove method---------------------------------------------------------------------------------
			System.out.println("Elements that are removed");
				
			System.out.println(myarraylist.remove(0));
			System.out.println(myarraylist.remove(1));
				
			System.out.println("");
			System.out.println("Elements that are still in the arraylist");
			for(int i = 0; i < myarraylist.size(); i++) {
				System.out.println(myarraylist.get(i));
			}
				
			System.out.println("");
			System.out.println("Number of elements:" + " " + myarraylist.size());

//---------------test for set method--------------------------------------------------------------------------------------
			myarraylist.set(0, 4);
			myarraylist.set(1, 5);
			System.out.println("1st element is changed to 4 and 2nd element is changed to 5");
			System.out.println("Elements in the arraylist:");
			for(int i = 0; i < myarraylist.size(); i++) {
				System.out.println(myarraylist.get(i));
			}
//---------------test for isEmpty method-----------------------------------------------------------------------------------
			System.out.println("");
			System.out.println("Is the Arraylist empty? ");
			System.out.println(myarraylist.isEmpty());
	}

}
