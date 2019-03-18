package source.sirnigelcogs.cabintown;

import java.util.HashMap;

public class Player {
	
	private int location;
	
	private HashMap<String, Item> inv;
	
	public Player(int location) {
		this.setLocation(location);
		
		inv = new HashMap<String, Item>();
	}
	
	public HashMap<String, Item> getInv() {
		return inv;
	}
	
	public void addItem(Item item) {
		inv.put(item.getId(), item);
	}
	
	public Item getItem(String id) {
		return inv.get(id);
	}
	
	public boolean hasItem(String id) {
		return inv.containsKey(id);
	}
	
	public void removeItem(String id) {
		inv.remove(id);
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

}
