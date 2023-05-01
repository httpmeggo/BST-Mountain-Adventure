/**
 * This class represents a hiker traveling down the
 * mountain. An object of this class is able to keep
 * track of all the supplies that the hiker owns, and
 * this information is updated as the hiker travels 
 * down the mountain and consumes supplies.
 * 
 * @author Megan Nicius
 * 
 * @version 24 April 2021
 */
package project5;

import java.util.ArrayList;

public class Hiker {

	private ArrayList bag = new ArrayList(); //Array List variable that stores supplies
	private RestStop location = new RestStop(); //variable of type RestStop that is later used to
	//check if necessary supplies are in bag
	
	/**
	 * This method allows for the hiker's bag to be accessed
	 * outside of this class.
	 * @return bag
	 */
	public ArrayList getBag() {
		return bag;
	}

	/**
	 * This method allows for the hiker's bag to be set to
	 * an object.
	 * @param bag
	 */
	public void setBag(String bag) {
		this.bag.add(bag);
	}

	/**
	 * This method allows for the hiker's location to be accessed
	 * outside of this class.
	 * @return location
	 */
	public RestStop getLocation() {
		return location;
	}

	/**
	 * This method allows for the hiker's location to be set.
	 * @param location
	 */
	public void setLocation(RestStop location) {
		this.location = location;
	}

	/**
	 * This method demonstrates the hiker eating
	 * by removing one food item from the hiker's
	 * bag when invoked.
	 * @return true if food is found in the bag and
	 * is consumed, false if no food is eaten
	 */
	boolean eat() {
		if(bag.contains("food")) {
			bag.remove("food"); //eat food from bag
			return true;
		}
		return false;
	}
	
	/**
	 * This method determines if hiker travels to
	 * next node or not.
	 * @return true if hiker travels, false if hiker
	 * cannot go to next node.
	 */
	boolean travels() {
		if(eat()) //if hiker eats, hiker travels
			return true;
		else
			return false;
	}
	
	/**
	 * This method checks if a fallen tree is present
	 * and uses the hiker's axe to bypass a fallen tree
	 * if axe is available
	 * @return true if axe is used or if fallen tree is not
	 * present in obstacles, false otherwise.
	 */
	boolean useAxe() {
		if(bag == null) //check if bag is null
			return false;
		if(location.getObstacles() == null) //check if location
			//is null
			return false;
		if(location.getObstacles().contains("fallen tree")) {
			//check if location contains fallen tree
			if(bag.contains("axe")) { //if bag has axe, use axe
				bag.remove("axe");
				return true;
			}
		}
		else if(!location.getObstacles().contains("fallen tree")) {
			return true; //if location does not have river, return true
			//without removing axe
		}
		return false;
	}
	
	/**
	 * This method checks if a river is present and uses the 
	 * raft to bypass the river if a raft is available in the 
	 * hiker's bag
	 * @return true if raft is used or if river is not present, 
	 * false otherwise.
	 */
	boolean useRaft() {
		if(bag == null) //check if bag is null
			return false; 
		if(location.getObstacles() == null) //check if location
			//is null
			return false;
		if(location.getObstacles().contains("river")) { 
			//check if location contains a river
			if(bag.contains("raft")) { //if bag has raft, use raft
				bag.remove("raft");
				return true;
			}
		}
		else if(!location.getObstacles().contains("river")){
			return true; //if no river, return true without using raft
		}
		return false;
	}
	
	
}
