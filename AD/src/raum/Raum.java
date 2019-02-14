package raum;

import java.util.Set;

import java.util.HashMap;

import java.util.Iterator;

/**
 * 006 Class Room - a room in an adventure game.
 *
 *
 * 
 * 
 * 
 * A "Room" represents one location in the scenery of the game. It is
 * 
 * connected to other rooms via exits. For each existing exit, the room
 * 
 * stores a reference to the neighboring room.
 *
 *
 * 
 * 
 * 
 */

public class Raum

{

	
	private HashMap<String, Raum> ausgaenge; // speichert Ausgänge dieses Raumes.

	private HashMap<Gegenstand, String> itemList;

	private String name;

	private String kurzBeschreibung;
	
	private String langBeschreibung;

	/**

	     * Create a room described "description". Initially, it has

	     * no exits. "description" is something like "a kitchen" or

	     * "an open court yard".

	     * @param description The room's description.

	     */

	    public Raum(String kurzBeschreibung)

	    {

	        this.kurzBeschreibung = kurzBeschreibung;

	        ausgaenge = new HashMap<String, Raum>();
	        itemList= new HashMap<Gegenstand, String>();

	         

	    }

	public Raum(String kurzBeschreibung,String name)

	    {

	        this.kurzBeschreibung = kurzBeschreibung;

	        ausgaenge = new HashMap<String, Raum>();

	        itemList= new HashMap<Gegenstand, String>();

	        this.name = name;

	        

	}

	/**
	 * 
	 * Define an exit from this room.
	 * 
	 * @param direction The direction of the exit.
	 * 
	 * @param neighbor  The room to which the exit leads.
	 * 
	 */

	public void addAusgang(Raum naher, String direction)

	{
		//??
		//ausgaenge.put(direction, naher);

	}

	/**
	 * 
	 * @return The short description of the room
	 * 
	 *         (the one that was defined in the constructor).
	 * 
	 */

	public String getKurzBeschreibung()

	{

		return kurzBeschreibung;

	}

	/**
	 * 
	 * Return a description of the room in the form:
	 * 
	 * You are in the kitchen.
	 * 
	 * Exits: north west
	 * 
	 * @return A long description of this room
	 * 
	 */

	
	public void setlangBeschreibung() {
		this.langBeschreibung = "Du bist " + kurzBeschreibung + ".\n" + getAusgangeString();
	}
	
	
	
	public String getlangBeschreibung()

	{

		return langBeschreibung;

	}

	/**
	 * 
	 * Return a string describing the room's exits, for example
	 * 
	 * "Exits: north west".
	 * 
	 * @return Details of the room's exits.
	 * 
	 */

	private String getAusgangeString()

	{

		String returnString = "Ausgaenge:";

		Set<String> keys = ausgaenge.keySet();

		for (String ausgaeng : keys) {

			returnString += " " + ausgaenge;

		}

		return returnString;

	}

	/**
	 * 
	 * Return the room that is reached if we go from this room in direction
	 * 
	 * "direction". If there is no room in that direction, return null.
	 * 
	 * @param direction The exit's direction.
	 * 
	 * @return The room in the given direction.
	 * 
	 */

	public Raum getExit(String direction)

	{

		return ausgaenge.get(direction);

	}

	public void addItem(Gegenstand item)

	{

		itemList.put(item.getName(), item.getKurzBeschreibung);

	}

	

}