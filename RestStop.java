/**
 * This class represents a single rest stop. It
 * stores the label of the rest stop, as well as
 * a list of the supplies that the hiker can collect
 * at the rest stop, and a list of obstacles that the
 * hiker may encounter at the rest stop. It implements
 * the Comparable interface.
 * 
 * @author Megan Nicius
 * 
 * @version 24 April 2021
 */
package project5;

import java.util.ArrayList;

public class RestStop implements Comparable {
	
	public boolean checkSuppliesAndObstacles(String item) {
		//from int 1 (so after label)
			//if item is food or raft or axe, store in supply
			//array list
			//else if item is fallen tree or river, store in
			//obstacle array list
			//else if item is not "\n", error: invalid item
		boolean check = false;	
		if(compareTo(item) == 1)
			//System.out.println("Obstacles and supplies are okay.");
			check = true;
		else
			//System.err.println("HMM SOMETHINGS NOT RIGHT");
			check = false;
		return check;
	}
	

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		ArrayList suppliesAndObstacles = new ArrayList();
		if(o == "food" || o == "raft" || o == "axe" 
				|| o == "fallen river" || o == "river") {
			suppliesAndObstacles.add(o);
			return 1;
		}
		else
			return 0;
	}

}
