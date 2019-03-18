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
			parse(input.split(" "));
		}

		in.close();

	}
	
	static void look(Map map) {
		Room room = map.getCurrentRoom();
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

	static void parse(String s[]) {
		String[] words = WordFilter.filter(s);
		switch (words.length) {
		case 1:
			if (words[0].equals("QUIT")) {
				State.playing = false;
			}
		}
	}
	static void p(String s) {
		System.out.print(s);
	}

	static void pl(String s) {
		System.out.println(s);
	}
}
