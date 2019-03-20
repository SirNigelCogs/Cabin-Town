package source.sirnigelcogs.cabintown;

import java.util.Scanner;
import java.util.HashMap;

public class CabinTown {

	static final double VERSION = 0.2;

	public static void main(String[] args) {
		var in = new Scanner(System.in);
		var map = new Map();

		pl("Welcome to Cabin Town v" + VERSION);
		pl("");

		while(State.playing) {
			if (State.look) {
				look(map);
			}
			pl("");
			p(">");
			String input = in.nextLine().toUpperCase();
			parse(input.split(" "), map);
		}

		in.close();

	}
	
	static void look(Map map) {
		Room room = map.getCurrentRoom();
		pl("");
		pl(room.getTitle());
		pl(room.getDesc());
		pl("");
		HashMap<String, Item> items = room.getItemList();
		if (!items.isEmpty()) {
			pl("");
			pl("You also see here:");
			for (Item item : items.values()) {
				pl(item.getTitle());
			}
			pl("");
		}
		pl("Obvious Exits:");
		int[] exits = room.getExits();
		if (exits[Room.N] != 0) pl("North ");
		if (exits[Room.S] != 0) pl("South ");
		if (exits[Room.E] != 0) pl("East ");
		if (exits[Room.W] != 0) pl("West");
		pl("");
		State.look = false;
	}

	static void parse(String s[], Map map) {
		String[] words = WordFilter.filter(s);
		switch (words.length) {
		case 1:
			if (words[0].equals("L")) {
				State.look = true;
			}
			else if (words[0].equals("N")) {
				checkExit(Room.N, map);
			}
			else if (words[0].equals("S")) {
				checkExit(Room.S, map);
			}
			else if (words[0].equals("E")) {
				checkExit(Room.E, map);
			}
			else if (words[0].equals("W")) {
				checkExit(Room.W, map);
			}
			else if (words[0].equals("I")) {
				pl("\nYou are carrying:");
				for (Item item : map.getPlayer().getInv().values()) {
					pl(item.getTitle());
				}
			}
			else if (words[0].equals("SCORE")) {
				if (map.getCurrentRoom().isTreasureRoom()) {
					pl("\nScore:  " + State.score);
				}
			}
			else if (words[0].equals("QUIT")) {
				State.playing = false;
			}
			break;
		case 2:
			if (words[0].equals("GET")) {
				var room = map.getCurrentRoom();
				var items = room.getItemList();
				var item = items.get(words[1]);
				if (item != null) {
					if (item.isGetable()) {
						items.remove(words[1]);
						map.getPlayer().addItem(item);
						pl("\nYou get it.");
					}
					else {
						pl("\nYou can't lift it.");
					}
				}
				else {
					pl("\nYou don't see that here.");
				}
			}
			else if (words[0].equals("DROP")) {
				var room = map.getCurrentRoom();
				var player = map.getPlayer();
				var items = player.getInv();
				var item = items.get(words[1]);
				if (item != null) {
					items.remove(words[1]);
					room.addItem(item.getId(), item);
					pl("\nYou drop it.");
				}
				else {
					pl("\nYou're not carrying that.");
				}
			}
			else if (words[0].equals("EXAMINE")) {
				var item = map.getCurrentRoom().getItemList().get(words[1]);
				if (item != null) {
					pl("\n" + item.getDescription());
				}
				else {
					item = map.getPlayer().getItem(words[1]);
					if (item != null) {
						pl("\n" + item.getDescription());
					}
					else {
						pl("\nYou don't see that here.");
					}
				}
			}
			else if (words[0].equals("ENTER")) {
				var item = map.getCurrentRoom().getItemList().get(words[1]);
				if (item != null) {
					int loc = item.getDoorway();
					if (loc != 0) {
						map.getPlayer().setLocation(loc);
						State.look = true;
					}
					else {
						pl("\nYou can't enter that.");
					}
				}
				else {
					pl("\nYou don't see that here.");
				}
			}
			break;
		default:
			pl("\nWhat?");
		}
	}
	static void checkExit(int exit, Map map) {
		var exits = map.getCurrentRoom().getExits();
		if (exits[exit] != 0) {
			map.getPlayer().setLocation(exits[exit]);
			State.look = true;
		}
		else {
			pl("\nThat doesn't appear to be an exit.");
		}
	}
	static void p(String s) {
		System.out.print(s);
	}

	static void pl(String s) {
		System.out.println(s);
	}
}
