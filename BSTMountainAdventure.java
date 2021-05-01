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
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BSTMountainAdventure {

	public static void main(String[] args) {
		
		//verify that the command line argument exists 
		if (args.length == 0 ) {
			System.err.println("Usage Error: the program expects file name as an argument.\n");
			System.exit(1);
		}
		
		File projectFile = new File(args[0]);
		if(projectFile.exists() == false) {
			System.err.println("File " + projectFile.getAbsolutePath() + " does not exist");
			System.exit(1);
		}
		if(projectFile.canRead() == false) {
			System.err.println("Cannot read " + projectFile.getAbsolutePath());
			System.exit(1);
		}
		
		Scanner readFile = null;
		
		try {
			readFile = new Scanner(projectFile);
		}
		catch(FileNotFoundException ex) {
			System.err.println(projectFile.getAbsolutePath() + "cannot"
					+ " be read.");
			System.exit(1);
		}
		
		String line = null;
		Scanner parseLine = null;
		String label = null;
		String suppliesAndObstacles = null;
		while(readFile.hasNextLine()) {
			try {
				line = readFile.nextLine();
				parseLine = new Scanner(line);
				parseLine.useDelimiter(" ");
				label = parseLine.next();
				while(parseLine.hasNext())
					suppliesAndObstacles = parseLine.next();
			}
			catch(NoSuchElementException e) {
				System.err.println("Line" + line + " contains an error.");
				continue;
			}
		}
		System.out.println(suppliesAndObstacles);
		BSTMountain mountain = new BSTMountain();
		RestStop stop = new RestStop();
		if(stop.checkSuppliesAndObstacles(suppliesAndObstacles) == true) {
			mountain.add(stop);
			mountain.add(stop);
		}
		System.out.println(mountain.toStringTree());
	}
}
