package source.sirnigelcogs.cabintown;

import java.util.HashMap;

public class Room {
	
	static final int N = 0;
	static final int S = 1;
	static final int E = 2;
	static final int W = 3;

	private int id;
	
	private int[] exits = new int[4];
	
	private HashMap<String, Item> items;

	private String title;
	private boolean treasureRoom;
	private String description;
	
	public Room(String title, String description) {
		this.title = title;
		this.description = description;
		items = new HashMap<String, Item>();
		treasureRoom = false;
	}
	
	public void addItem(String id, Item item) {
		items.put(id, item);
	}
	
	public HashMap<String, Item> getItemList() {
		return items;
	}

	public String getDesc() {
		return description;
	}
	
	public int[] getExits() {
		return exits;
	}
	
	public void setExit(int exit, int value) {
		exits[exit] = value;
	}

	public String getTitle() {
		return title;
	}
	
	public boolean isTreasureRoom() {
		return treasureRoom;
	}
	
	public void setTreasureRoom(boolean t) {
		treasureRoom = t;
	}
}
