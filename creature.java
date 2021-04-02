import java.util.*;
class creature {
	String [] mob  = {"Slime", "Camel", "Helicopter", "Policeman"};
	Random ran = new Random();
	String name;
	Hashtable<String, Integer> stats = new Hashtable<>(); //creating dictionary 

	public creature(){
		int i = ran.nextInt(4);
		this.name = mob[i]; 

		switch (i){

			case (0): //Slime
				stats.put("HP", 5); //.put method assigns a key to the value (key, value) 
				stats.put("ATTACK", 3);
				stats.put("LUCK", 0);
				stats.put("DEFENCE", 0);
				stats.put("MP", 0);
				stats.put("EXP", 3);
				break;
			case (1): //Camel
				stats.put("HP", 5); //.put method assigns a key to the value (key, value) 
				stats.put("ATTACK", 5);
				stats.put("LUCK", 0);
				stats.put("DEFENCE", 3);
				stats.put("MP", 0);
				stats.put("EXP", 7);
				break;
			case (2): //Helicopter
				stats.put("HP", 20); //.put method assigns a key to the value (key, value) 
				stats.put("ATTACK", 0);
				stats.put("LUCK", 0);
				stats.put("DEFENCE", 15);
				stats.put("MP", 0);
				stats.put("EXP", 12);
				break;
			case (3): //Policeman
				stats.put("HP", 10); //.put method assigns a key to the value (key, value) 
				stats.put("ATTACK", 100);
				stats.put("LUCK", 100);
				stats.put("DEFENCE", 15);
				stats.put("MP", 0);
				stats.put("EXP", 0);
				break;
		}
	}
	
	public creature(int i){
		this.name = mob[i]; 

		switch (i){

			case (0): //Slime
				stats.put("HP", 5); //.put method assigns a key to the value (key, value) 
				stats.put("ATTACK", 3);
				stats.put("LUCK", 0);
				stats.put("DEFENCE", 0);
				stats.put("MP", 0);
				stats.put("EXP", 3);
				break;
			case (1): //Camel
				stats.put("HP", 5); //.put method assigns a key to the value (key, value) 
				stats.put("ATTACK", 5);
				stats.put("LUCK", 0);
				stats.put("DEFENCE", 3);
				stats.put("MP", 0);
				stats.put("EXP", 7);
				break;
			case (2): //Helicopter
				stats.put("HP", 20); //.put method assigns a key to the value (key, value) 
				stats.put("ATTACK", 0);
				stats.put("LUCK", 0);
				stats.put("DEFENCE", 15);
				stats.put("MP", 0);
				stats.put("EXP", 12);
				break;
			case (3): //Policeman
				stats.put("HP", 10); //.put method assigns a key to the value (key, value) 
				stats.put("ATTACK", 100);
				stats.put("LUCK", 100);
				stats.put("DEFENCE", 15);
				stats.put("MP", 0);
				stats.put("EXP", 0);
				break;
		}
	}
}