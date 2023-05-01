/**
 * This class is responsible for parsing and validating
 * the command line arguments, reading and parsing the
 * input file, producing any error messages, handling
 * any exceptions thrown by other classes, and producing
 * output.
 * 
 * @author Megan Nicius
 *
 * @version 24 April 2021
 */

package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class BSTMountainAdventure {

	/**
	 * This program's main() method.
	 * @param args array of Strings from command line input, where the first
	 * String one each line provides a label for the rest stop and any
	 * following strings on the line should represent supplies and obstacles
	 * found at the rest stop
	 */
	public static void main(String[] args) {
		
		//verify that the command line argument exists 
		if (args.length == 0 ) {
			System.err.println("Usage Error: the program expects file name as an argument.\n");
			System.exit(1);
		}
		//verify file exists
		File projectFile = new File(args[0]);
		if(projectFile.exists() == false) {
			System.err.println("File " + projectFile.getAbsolutePath() + " does not exist");
			System.exit(1);
		}
		//verify file can be read
		if(projectFile.canRead() == false) {
			System.err.println("Cannot read " + projectFile.getAbsolutePath());
			System.exit(1);
		}
		
		Scanner readFile = null;
		//try to read file and catch FileNotFoundException
		try {
			readFile = new Scanner(projectFile);
		}
		catch(FileNotFoundException ex) {
			System.err.println(projectFile.getAbsolutePath() + "cannot"
					+ " be read.");
			System.exit(1);
		}
		
		//the mountain that the hiker will travel down
		BSTMountain mountain = new BSTMountain(); 
		//array list containing pathway traveled
		ArrayList pathway = new ArrayList(); 
		//boolean for if a path exists
		boolean hasPath = true;

		
		Hiker thisGuy = new Hiker(); //hiker object
		ArrayList bag = new ArrayList(); //hiker's bag

				
		//while the file has a next line, read each line of the file at a time
		while(readFile.hasNextLine()) {
			ArrayList supplies = new ArrayList();
			//array list containing supplies at each rest stop
			ArrayList obstacles = new ArrayList();
			//array list containing obstacles at each rest stop
			
			readFile.useDelimiter("\n");
			String[] line = readFile.nextLine().split(" ");
			ArrayList<String> currentLine = new ArrayList();
			for(String s:line)
				currentLine.add(s); //store each item in line in array list
			
			RestStop currentStop = new RestStop();
			//RestStop object representing current rest stop
			currentStop.setLabel(currentLine.get(0)); //set label for current rest stop
			
			//variables to locate obstacles and supplies in file line
			int obstacleIndex = 1;
			int supplyIndex = 1;
			
			//find where obstacles begin in text line
			for(int i = obstacleIndex; i < currentLine.size(); i++) {
				if((currentLine.get(i).equals("tree") && currentLine.get(i-1).equals("fallen")) ||
						currentLine.get(i).equals("river")) {
					obstacleIndex = i;
					break;
				}
			}
			
			//add obstacles from line to array list
			for(String s: currentLine) {
				int i = 0;
				while(i < obstacleIndex) {
					obstacles.add(s);
					i++;
				}
			}
			
			//add obstacles from text file to current stop
			currentStop.setObstacles(obstacles);
			
			//find where the list of supplies begins
			for(int i = supplyIndex; (i < currentLine.size() || i < obstacleIndex); i++) {
				if(currentLine.get(i).equals("food") || currentLine.get(i).equals("raft") ||
						currentLine.get(i).equals("axe")) {
					supplyIndex = i;
					break;
				}
			}
			
			//add supplies from line to array list
			for(String s: currentLine) {
				int i = 0;
				while(i < supplyIndex) {
					supplies.add(s);
					i++;
				}
			}
			
			//add supplies from text file to current stop
			currentStop.setSupplies(supplies);
			
			//the hiker takes all of the supplies from the current stop
			thisGuy.setBag(currentStop.getSupplies().toString());
			
			//the current stop is stored as a node in the mountain BST
			mountain.insert(mountain.getRoot(), currentStop);
			
			//if the hiker is able to bypass any possible obstacles and the hiker
			//is able to eat, the hiker can move on to the next stop
			//the label of the current stop is added to an array list that
			//holds working pathways
			if(thisGuy.useAxe() && thisGuy.useRaft() && thisGuy.travels()) {
				pathway.add(currentStop.getLabel());
				hasPath = true;
			}
			else if(thisGuy.travels() == false)
				hasPath = false;
		}
		//if no path, print nothing and exit program
		if(hasPath == false)
			System.exit(-1);
		else
			//else print path
			System.out.println(pathway.toString());
	}
}
