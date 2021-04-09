import java.util.*;

class creature {
	String[] mob = { "Slime", "Camel", "Helicopter", "Policeman" };
	Random ran = new Random();
	String name;
	Hashtable<String, Integer> stats = new Hashtable<>(); // creating dictionary
	String sprite;
	public creature(int i) {
		if (i == -999) { // i == -999 = random encounter
			i = ran.nextInt(4);
		}

		this.name = mob[i];
		switch (i) {

		case (0): // Slime
			sprite = "(• w •)";
			stats.put("HP", 30); // .put method assigns a key to the value (key, value)
			stats.put("currentHP", stats.get("HP"));
			stats.put("ATK", 3);
			stats.put("LCK", 0);
			stats.put("DEF", 15);
			stats.put("MP", 0);
			stats.put("EXP", 3);
			break;
		case (1): // Camel
			sprite = "/^—^\\(•-•)";
			stats.put("HP", 5); // .put method assigns a key to the value (key, value)
			stats.put("currentHP", stats.get("HP"));
			stats.put("ATK", 5);
			stats.put("LCK", 0);
			stats.put("DEF", 3);
			stats.put("MP", 0);
			stats.put("EXP", 7);
			break;
		case (2): // Helicopter
			sprite = " ([] L)";
			stats.put("HP", 20); // .put method assigns a key to the value (key, value)
			stats.put("currentHP", stats.get("HP"));
			stats.put("ATK", 0);
			stats.put("LCK", 0);
			stats.put("DEF", 15);
			stats.put("MP", 0);
			stats.put("EXP", 12);
			break;
		case (3): // Policeman
			stats.put("HP", 10); // .put method assigns a key to the value (key, value)
			stats.put("currentHP", stats.get("HP"));
			stats.put("ATK", 100);
			stats.put("LCK", 100);
			stats.put("DEF", 15);
			stats.put("MP", 0);
			stats.put("EXP", 0);
			break;
		}
	}
}