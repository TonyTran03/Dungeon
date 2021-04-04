import java.util.*;
//this specialCharacer file is creating main characeter
public class specialCharacter extends nameCreation {
    Hashtable<String, Integer> stats = new Hashtable<>(); // creating dictionary
    ArrayList<Spell> spellBook = new ArrayList<>();
    

    public specialCharacter(String name) {
        super(name); // inheritance of name (found in mob.java)
    }
    
    public void statrolls() {
        stats.put("HP", 10); // .put method assigns a key to the value (key, value)
        stats.put("ATK", 10);
        stats.put("LCK", 10);
        stats.put("DEF", 10);
        stats.put("MP", 10);
        stats.put("EXP", 0);
        stats.put("Lvl", 1);

        Random ran = new Random();
        // this section randomizes the value in each stat
        String[] roller = { "ATK", "LCK", "DEF", "MP" };
        for (int i = 0; i < 22; i++) { // points generator
            int dice = ran.nextInt(4); // .nextInt is inclusive of 0 but exclusive of value- pick a random number in
                                       // the range
            String iv = roller[dice]; // made an instance of the array, selecting a random index [0,4)
            stats.put(iv, stats.get(iv) + 1); // we use .put method again to reassign a new key to the value. This works
                                              // because "iv" variable shares the same name as the key. In this case, we
                                              // overwrite the previous value (key, value) to be +1
        }
        // stats.put("currentMP", stats.get("MP"));
        stats.put("currentMP", stats.get("MP") - 2);
    }

    // .get method gets the value using the key from the dictionary
    public void printStatReroll() {
        System.out.println("ATK: 10 → " + stats.get("ATK"));
        System.out.println("LCK: 10 → " + stats.get("LCK"));
        System.out.println("MP:  10 → " + stats.get("MP"));
        System.out.println("DEF: 10 → " + stats.get("DEF"));
    }

    public void printStat() {
        System.out.println("LVL: " + stats.get("Lvl"));
        System.out.println("HP:  " + stats.get("HP"));
        System.out.println("ATK: " + stats.get("ATK"));
        System.out.println("LCK: " + stats.get("LCK"));
        System.out.println("MP:  " + stats.get("MP"));
        System.out.println("DEF: " + stats.get("DEF"));
    }
    public void testing() {
        stats.put("HP", 999); // .put method assigns a key to the value (key, value)
        stats.put("ATK", 20);
        stats.put("LCK", 999);
        stats.put("DEF", 999);
        stats.put("MP", 999);
        stats.put("currentMP", stats.get("MP") - 2);
        stats.put("EXP", 0);
    }


    public boolean engage(int monster) { //passing in which mosnter we are going to fight 

		creature opponent = new creature(monster); 
		storyBoard.clearScreen();
        System.out.println(getName() + " engaged combat with a " + opponent.name + "!");
		System.out.println(opponent.name+ " ———————————— " +  opponent.sprite);
        System.out.println(opponent.stats.get("HP") );

        //print out mana visual
        System.out.print("Mana: " + this.stats.get("currentMP") + "/" + this.stats.get("MP") + " "); 
		for (int i = 0; i < this.stats.get("currentMP"); i++) {
			System.out.print("■");
		}for (int i = 0; i < this.stats.get("MP") - this.stats.get("currentMP"); i++) {
			System.out.print("▢");
		}

        
        
        boolean notLose = true;
		boolean battle = true;
		while(battle == true){
            int totalDamage = (this.stats.get("ATK")*6)/5 - opponent.stats.get("DEF");  // Damage calculator —> 20% modifier on attack 
			if(opponent.stats.get("HP") <= 0){
				battle = false;
                int totalEXP = this.stats.get("EXP") + opponent.stats.get("EXP");
				this.stats.put("EXP", totalEXP);
                System.out.println("You Win!");
                notLose = true;
			}
			else if (this.stats.get("HP") <= 0){
				battle = false;
				System.out.println("You Lose");
                notLose = false;
			}
			//battle system
			else{
                Scanner scan = new Scanner(System.in);
                System.out.println("\n 1. Attack —>"+ totalDamage +"\n 2. Use Spell \n 3. Use Item \n 4. Run Away");
                int attack = scan.nextInt();
                switch(attack){
                    case 1: 


                    opponent.stats.put("HP", opponent.stats.get("HP") - totalDamage); //calculates total damage done to enemy
                    // System.out.println(totalDamage);
                    // System.out.println(opponent.stats.get("HP"));
                    
                    break;
                    

                    case 2:
                        
        
                    case 3: 
                        //use item
                    case 4:
                    //run away

                    default: storyBoard.clearScreen();
                    System.out.println("\n 1. Attack \n 2. Use Spell \n 3. Use Item \n 4. Run Away");
                    
                }
               
			}
		}
        return notLose;
	}
}