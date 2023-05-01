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

public class RestStop implements Comparable<RestStop>{

	private String label; //represents rest stop label
	private ArrayList supplies; //array list that holds
	//supplies found at rest stop
	private ArrayList obstacles; //array list that holds
	//obstacles found at rest stop
	
	/**
	 * Default constructor for this class
	 */
	public RestStop() {
		this.label = label;
		this.supplies = supplies;
		this.obstacles = obstacles;
	}


	/**
	 * This method allows for other classes
	 * to access the label.
	 * @return label
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * This method allows for other classes
	 * to set the label.
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * This method allows for other classes
	 * to access the list of supplies.
	 * @return supplies
	 */
	public ArrayList getSupplies() {
		return supplies;
	}
	
	/**
	 * This method allows for other classes to
	 * set the list of supplies
	 * @param supplies
	 */
	public void setSupplies(ArrayList supplies) {
		this.supplies = supplies;
	}
	
	/**
	 * This method allows for other classes
	 * to access the list of obstacles.
	 * @return obstacles
	 */
	public ArrayList getObstacles() {
		return obstacles;
	}
	
	/**
	 * This method allows for other classes to
	 * set the list of obstacles.
	 * @param obstacles
	 */
	public void setObstacles(ArrayList obstacles) {
		this.obstacles = obstacles;
	}


	/**
	 * This method sorts rest stops according to label.
	 */
	@Override
	public int compareTo(RestStop o) {
		return this.getLabel().compareTo(o.getLabel());
	}

	
}
