/*
 * File: AdvRoom.java
 * ------------------
 * This file defines a class that models a single room in the
 * Adventure game.
 */

import java.io.*;
import java.util.*;

/* Class: AdvRoom */
/**
 * This class defines a single room in the Adventure game. A room is
 * characterized by the following properties:
 * 
 * <ul>
 * <li>A room number, which must be greater than zero
 * <li>Its name, which is a one-line string identifying the room
 * <li>Its description, which is a multiline array describing the room
 * <li>A list of objects contained in the room
 * <li>A flag indicating whether the room has been visited
 * <li>A motion table specifying the exits and where they lead </li>
 * 
 * The external format of the room data file is described in the assignment
 * handout. The comments on the methods exported by this class show how to use
 * the initialized data structure.
 */

public class AdvRoom extends AdvRoomStub {
	
	private int roomNum;
	private String name;
	private ArrayList<String> desc;
	private ArrayList<AdvObject> objects;
	private boolean visited;
	private ArrayList<AdvMotionTableEntry> motionTable;

	/* Method: getRoomNumber() */
	/**
	 * Returns the room number.
	 * 
	 * @usage int roomNumber = room.getRoomNumber();
	 * @return The room number
	 */
	public int getRoomNumber() {
		return this.roomNum; // Replace with your code
	}

	/* Method: getName() */
	/**
	 * Returns the room name, which is its one-line description.
	 * 
	 * @usage String name = room.getName();
	 * @return The room name
	 */
	public String getName() {
		return this.name; // Replace with your code
	}

	/* Method: getDescription() */
	/**
	 * Returns an array of strings that correspond to the long description of
	 * the room (including the list of the objects in the room).
	 * 
	 * @usage String[] description = room.getDescription();
	 * @return An array of strings giving the long description of the room
	 */
	public String[] getDescription() {
		return this.desc.toArray(new String[this.desc.size()]); // Replace with your code
	}

	/* Method: addObject(obj) */
	/**
	 * Adds an object to the list of objects in the room.
	 * 
	 * @usage room.addObject(obj);
	 * @param The
	 *            AdvObject to be added
	 */
	public void addObject(AdvObject obj) {
		this.objects.add(obj);
	}

	/* Method: removeObject(obj) */
	/**
	 * Removes an object from the list of objects in the room.
	 * 
	 * @usage room.removeObject(obj);
	 * @param The
	 *            AdvObject to be removed
	 */
	public void removeObject(AdvObject obj) {
		this.objects.remove(obj);
	}

	/* Method: containsObject(obj) */
	/**
	 * Checks whether the specified object is in the room.
	 * 
	 * @usage if (room.containsObject(obj)) . . .
	 * @param The
	 *            AdvObject being tested
	 * @return true if the object is in the room, and false otherwise
	 */
	public boolean containsObject(AdvObject obj) {
		return this.objects.contains(obj);
	}

	/* Method: getObjectCount() */
	/**
	 * Returns the number of objects in the room.
	 * 
	 * @usage int nObjects = room.getObjectCount();
	 * @return The number of objects in the room
	 */
	public int getObjectCount() {
		return this.objects.size();
	}

	/* Method: getObject(index) */
	/**
	 * Returns the specified element from the list of objects in the room.
	 * 
	 * @usage AdvObject obj = room.getObject(index);
	 * @return The AdvObject at the specified index position
	 */
	public AdvObject getObject(int index) {
		return this.objects.get(index);
	}

	/* Method: setVisited(flag) */
	/**
	 * Sets the flag indicating that this room has been visited according to the
	 * value of the parameter. Calling setVisited(true) means that the room has
	 * been visited; calling setVisited(false) restores its initial unvisited
	 * state.
	 * 
	 * @usage room.setVisited(flag);
	 * @param flag
	 *            The new state of the "visited" flag
	 */
	public void setVisited(boolean flag) {
		this.visited = flag;// Replace with your code
	}

	/* Method: hasBeenVisited() */
	/**
	 * Returns true if the room has previously been visited.
	 * 
	 * @usage if (room.hasBeenVisited()) . . .
	 * @return true if the room has been visited; false otherwise
	 */
	public boolean hasBeenVisited() {
		return this.visited; // Replace with your code
	}

	/* Method: getMotionTable() */
	/**
	 * Returns the motion table associated with this room, which is an array of
	 * directions, room numbers, and enabling objects stored in a
	 * AdvMotionTableEntry.
	 * 
	 * @usage AdvMotionTableEntry[] motionTable = room.getMotionTable();
	 * @return The array of motion table entries associated with this room
	 */
	public AdvMotionTableEntry[] getMotionTable() {//do this last(might be complicated)
		return this.motionTable.toArray(new AdvMotionTableEntry[this.motionTable.size()]); // Replace with your code
	}

	/* Method: readFromFile(rd) */
	/**
	 * Reads the data for this room from the Scanner scan, which must have been
	 * opened by the caller. This method returns a room if the room
	 * initialization is successful; if there are no more rooms to read,
	 * readFromFile returns null.
	 * 
	 * @usage AdvRoom room = AdvRoom.readFromFile(scan);
	 * @param scan
	 *            A scanner open on the rooms data file
	 * @return a room if successfully read; null if at end of file
	 */
	public static AdvRoom readFromFile(Scanner scan) {
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			if(line.length() != 0) {
				int room = Integer.parseInt(line);
				String name = scan.nextLine();
				ArrayList<String> desc = new ArrayList<String>();
				String descLine = scan.nextLine();
				while(!descLine.equals("-----")) {
					desc.add(descLine);
					descLine = scan.nextLine();
				}
				ArrayList<AdvMotionTableEntry> motionTable = new ArrayList<AdvMotionTableEntry>();
				while(scan.hasNextLine()) {
					String[] lines = scan.nextLine().split("\\s+"); // pattern matcher(Found online) we split based on blank spaces. 
					if(lines.length == 1)break;
					String key = null;
					if(lines[1].contains("/")) {
						String[] split = lines[1].split("/");
						lines[1] = split[0];
						key = split[1];
					}
					AdvMotionTableEntry entry = new AdvMotionTableEntry(lines[0], Integer.parseInt(lines[1]), key); 
					motionTable.add(entry);
				}
				return new AdvRoom(room,name,desc,motionTable);
			}
			
			
		}
		return null;
		
		// Replace with your code
	}
	private AdvRoom(int roomNum, String name, ArrayList<String> desc, ArrayList<AdvMotionTableEntry> motionTable) {
		this.roomNum = roomNum;
		this.name = name;
		this.desc = desc;
		this.objects = new ArrayList<AdvObject>();
		this.motionTable = motionTable;
		this.visited = false;
	}
	
	//make a new constructor

	/* Private instance variables */
	// Add your own instance variables here
}
