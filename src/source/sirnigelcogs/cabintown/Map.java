package source.sirnigelcogs.cabintown;

import java.util.HashMap;

public class Map {

	static final int PLAYER_STARTING_LOCATION = 1;

	private HashMap<Integer, Room> rooms;

	private Player player;

	public Map() {
		rooms = new HashMap<Integer, Room>();
		player = new Player(PLAYER_STARTING_LOCATION);
		
		var room = new Room("A Test Room", "This is a test room.");
		room.setExit(Room.N, 3);
		var item = new Item("item", "A test item", "This is a test item");
		room.addItem(item.getId(), item);
		item = new Item("door", "A door", "A wooden door");
		item.setGetable(false);
		item.setDoorway(3);
		room.addItem(item);
		room.setTreasureRoom(true);
		rooms.put(1, room);
		
		room = new Room("A Second Room", "This is a second room.");
		room.setExit(Room.S, 1);
		item = new Item("book", "A test book", "This is a test book");
		room.addItem(item.getId(), item);
		rooms.put(3, room);
	}
	
	public Room getCurrentRoom() {
		return rooms.get(player.getLocation());
	}
	
	public Player getPlayer() {
		return player;
	}

	public HashMap<Integer, Room> getRooms() {
		return rooms;
	}
}
