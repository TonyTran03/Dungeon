import java.util.*;
//this specialCharacer file is creating main characeter
public class specialCharacter  {
    
    Hashtable<String, Integer> stats = new Hashtable<>(); // creating dictionary
    ArrayList<spell> SpellBook = new ArrayList<>();
    String name;
    public specialCharacter(String name) {
       this.name = name;
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
                                              // overwrite the previous value (key, value) by adding +1
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
        stats.put("HP", 105); // .put method assigns a key to the value (key, value)
        stats.put("currentHP", stats.get("HP") - 100); //tracking HP
        stats.put("ATK", 20);
        stats.put("LCK", 999);
        stats.put("DEF", 0);
        stats.put("MP", 999);
        stats.put("currentMP", stats.get("MP") - 999); //Tracking Mana
        stats.put("EXP", 0);
        
    }


    public boolean engage(int monster) { //passing in which mosnter we are going to fight 

		creature opponent = new creature(monster); 
		storyBoard.clearScreen();
        System.out.println(this.name + " engaged combat with a " + opponent.name + "!");
		System.out.println(opponent.name+ " ———————————— " +  opponent.sprite);
        System.out.println(opponent.stats.get("HP") );

        //print out mana visual
        System.out.print("Mana: " + this.stats.get("currentMP") + "/" + this.stats.get("MP") + " "); 
		for (int i = 0; i < this.stats.get("currentMP"); i++) {
			System.out.print("■");
		}for (int i = 0; i < this.stats.get("MP") - this.stats.get("currentMP"); i++) {
			System.out.print("▢");
		}


        
        boolean notLose = true; //If returned true into storyBoard, continue game. Otherwise, if notLose returns false, restart game.
		boolean battle = true;
		while(battle == true){
            int myTotalDamage = (this.stats.get("ATK")*6)/5 - opponent.stats.get("DEF");  // Damage calculator (you onto enemy) —> 20% modifier on attack (this line is here for us to
                                                                                        //show total damage next to attack in the game)
            int theirTotalDamage = (opponent.stats.get("ATK")*6)/5 - this.stats.get("DEF");                                       
			if(opponent.stats.get("currentHP") <= 0){
				battle = false;
                int totalEXP = this.stats.get("EXP") + opponent.stats.get("EXP");
				this.stats.put("EXP", totalEXP);
                System.out.println("You Win!");
                notLose = true;
			}
			else if (this.stats.get("currentHP") <= 0){
				battle = false;
				System.out.println("You Lose");
                notLose = false;
			}
			//battle system
			else{

                Scanner scan = new Scanner(System.in);
                System.out.println("\n 1. Attack —> "+ myTotalDamage +"\n 2. Use Spell \n 3. Use Item \n 4. Run Away");
                int attack = scan.nextInt();
                switch(attack){
                    case 1: 

                    opponent.stats.put("currentHP", opponent.stats.get("currentHP") - myTotalDamage); //calculates total damage done to enemy
                    // System.out.println(totalDamage);
                    // System.out.println(opponent.stats.get("HP"));
                    this.stats.put("currentHP", this.stats.get("currentHP") - theirTotalDamage); //TODO what if we strike together?
                    break;
                    

                    case 2:
                        int[] points = spell.useSpell(this, opponent, 1); // passing through character, opponent, and spell)
                        this.stats.put("currentHP", points[0]);
                        opponent.stats.put("currentHP", points[1]);
                        this.stats.put("currentMP", points[2]);
                        break;
        
                    case 3: 
                       System.out.println(this.stats.get("currentHP"));
                       break;
                    
                    //use item
                    case 4:
                    break;
                    //run away

                    default: 
                        System.out.println(this.stats.get("currentMP"));
                        break;

                    
                }
               
			}
		}
        return notLose;
	}
}