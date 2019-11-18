/*
 * File: AdvObject.java
 * --------------------
 * This file defines a class that models an object in the
 * Adventure game.
 */

import java.io.*;
import java.util.Scanner;

/* Class: AdvObject */
/**
 * This class defines an object in the Adventure game.  An object is
 * characterized by the following properties:
 *
 * <ul>
 * <li>Its name, which is the noun used to refer to the object
 * <li>Its description, which is a string giving a short description
 * <li>The room number in which the object initially lives
 * </li>
 *
 * The external format of the objects file is described in the
 * assignment handout.  The comments on the methods exported by
 * this class show how to use the initialized data structure.
 */

public class AdvObject extends AdvObjectStub {

/* Method: getName() */
/**
 * Returns the object name, which is the word used to refer to it.
 *
 * @usage String name = obj.getName();
 * @return The name of the object
 */
	public String getName() {
		return this.name; // Replace with your code
	}

/* Method: getDescription() */
/**
 * Returns the one-line description of the object.  This description
 * should start with an article, as in "a set of keys" or "an emerald
 * the size of a plover's egg."
 *
 * @usage String name = obj.getDescription();
 * @return The description of the object
 */
	public String getDescription() {
		return this.desc; // Replace with your code
	}


/* Method: getInitialLocation() */
/**
 * Returns the initial location of the object.
 *
 * @usage int roomNumber = obj.getInitialLocation();
 * @return The room number in which the object initially resides
 */
	public int getInitialLocation() {
		return this.room; // Replace with your code
	}

	/* Method: readFromFile(scan) */
	/**
	 * Reads the data for this object from the Scanner scan, which must have
	 * been opened by the caller. This method returns the object if the object
	 * initialization is successful; if there are no more objects to read,
	 * readFromFile returns null
	 * 
	 * @usage AdvObject object = AdvObject.readFromFile(scan);
	 * @param scan
	 *            A Scanner open on the objects data file
	 * @return the object if an object is successfully read; null at end of file
	 */
	public static AdvObject readFromFile(Scanner scan) {
		while(scan.hasNext()) {//create a loop to continue while there are still lines in the file to read
			String temp = scan.nextLine();//grab the next line and store as temp.
			if(temp.length() != 0) {//if temp is not an empty string then start reading the data
				String newName = temp;//first line is the name

				String newDesc = scan.nextLine();//next line has the description

				int newRoom = Integer.parseInt(scan.nextLine());//last line has the room, parse to integer

				return new AdvObject(newName, newDesc, newRoom);//create a new object and return that value
			}
		}
		//if we made it to the end of the file then no new objects to create 
		//so return null
		return null;
	}
	 
	private String name;
	private String desc;
	private int room;
	public AdvObject(String name, String desc, int room) {
		this.name = name;
		this.room = room;
		this.desc = desc;
	}

/* Private instance variables */
	// Add your own instance variables here

}

