package source.sirnigelcogs.cabintown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WordFilter {
	
	public static String[] filter(String[] words) {
		var list = new ArrayList<String>();
		
		//Collections.addAll(n, words);
		
		for (String w : words) {
			if (w.equals("TAKE")) {
				list.add("GET");
			}
			else if (w.equals("INVENTORY")) {
				list.add("I");
			}
			else if (w.equals("TO") || w.equals("THE")) continue;
			else {
				list.add(w);
			}
		}
		
		String[] newList = new String[list.size()];
		
		return list.toArray(newList);
	}

}
