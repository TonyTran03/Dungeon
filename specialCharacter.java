import java.util.*;

//this specialCharacer file is creating main characeter
public class specialCharacter  {
    
    Hashtable<String, Integer> stats = new Hashtable<>(); // creating dictionary
    ArrayList<String> spellBook = new ArrayList<>();
    String name;
    
    public specialCharacter(String name) {
       this.name = name;
       spellBook.add("Fireball");
       spellBook.add("Heal");
    }
    
    public void statrolls() {
        stats.put("HP", 10); // .put method assigns a key to the value (key, value)
        stats.put("currentHP", stats.get("HP")); //tracking HP
        stats.put("ATK", 10);
        stats.put("LCK", 10);
        stats.put("DEF", 10);
        stats.put("MP", 10);
        stats.put("currentMP", stats.get("MP") ); //Tracking Mana
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
        this.stats.put("currentMP", this.stats.get("MP"));
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
        System.out.println("DEF: " + stats.get("DEF"));
        System.out.println("MP:  " + stats.get("MP"));
        System.out.println("LCK: " + stats.get("LCK"));
    }
    // public void testing() {
    //     stats.put("Lvl", 1);
    //     stats.put("HP", 105); // .put method assigns a key to the value (key, value)
    //     stats.put("currentHP", stats.get("HP")); //tracking HP
    //     stats.put("ATK", 20);
    //     stats.put("LCK", 999);
    //     stats.put("DEF", 0);
    //     stats.put("MP", 999);
    //     stats.put("currentMP", stats.get("MP") ); //Tracking Mana
    //     stats.put("EXP", 0);
    // }


    public boolean engage(int monster) { //passing in which mosnter we are going to fight 

		creature opponent = new creature(monster); 
		storyBoard.clearScreen();
        System.out.println(this.name + " engaged combat with a " + opponent.name + "!");
		System.out.println(opponent.name+ " ———————————— " +  opponent.sprite);
        System.out.println(opponent.stats.get("currentHP") + "/" + opponent.stats.get("HP"));
        System.out.println(this.name +" HP: " + this.stats.get("currentHP") +"/" + this.stats.get("HP"));
        System.out.println(this.name +" MP: " + this.stats.get("currentMP") +"/" + this.stats.get("MP"));

        boolean notLose = true; //If returned true back into storyBoard -> continue game. Otherwise, if notLose returns false -> restart game.
		boolean battle = true;
        int turn = 0;
		while(battle == true){
            int myTotalDamage = (this.stats.get("ATK")*6)/5 - opponent.stats.get("DEF");  // Damage calculator (you onto enemy) —> 20% modifier on attack (this line is here for us to
                                                                                        //show total damage next to attack in the game)
            int theirTotalDamage = (opponent.stats.get("ATK")*6)/5 - this.stats.get("DEF");                                       
			if(opponent.stats.get("currentHP") <= 0){
				System.out.println("You Win!");
                int totalEXP = this.stats.get("EXP") + opponent.stats.get("EXP");
				
                this.stats.put("EXP", totalEXP);
                //if level up 
                if(this.stats.get("EXP") >= 10){
                    this.stats.put("Lvl", this.stats.get("Lvl") + 1); //increase level by 1
                    this.stats.put("HP", this.stats.get("HP") + 2); //max HP increases by 2 points
                    this.stats.put("currentHP", this.stats.get("HP")); //heal to full after level
                    for(int i = 5; i > 0; i--){
                        storyBoard.clearScreen();
                        System.out.println("LEVEL UP!");
                        printStat();
                        System.out.println("\nIncrease one stat (" + i + ")");
                        System.out.println("1. ATK");
                        System.out.println("2. DEF");
                        System.out.println("3. MP");
                        System.out.println("4. LCK");

                        Scanner scan = new Scanner(System.in);
                        int num = scan.nextInt();   
                        String[] roller = { "ATK", "DEF", "MP", "LCK" };
                        String iv = roller[num - 1];
                        this.stats.put(iv, this.stats.get(iv) + 1);
                    }
                    this.stats.put("EXP", totalEXP - 10);
                    this.stats.put("currentMP", this.stats.get("MP"));
                }
                battle = false; //stop fighting opponent
                notLose = true; //exit the battle screen
                
			}
			else if (this.stats.get("currentHP") <= 0){
				battle = false;
				System.out.println("You Lose");
                notLose = false;
			}
			//battle system
			else{
                if(turn % 2 == 0){
                    if(myTotalDamage < 0){
                        myTotalDamage = 0;
                    }
                    Scanner scan = new Scanner(System.in);
                    System.out.println("1. Attack —> "+ myTotalDamage);
                    System.out.println("2. Use Spell");
                    System.out.println("3. Use Item");
                    System.out.println("4. Run Away");
    
                    int attack = scan.nextInt();
                    switch(attack){
                        case 1: 
                        turn++;
                        opponent.stats.put("currentHP", opponent.stats.get("currentHP") - myTotalDamage);//calculates total damage done to enemy
                        break;
                
                        case 2:
                            turn++;
                            int spellNumber = 1;
                            for(String spell : spellBook){
                                System.out.println(spellNumber + ". " + spell);
                                spellNumber++;
                            }
                            int num = scan.nextInt();
                            int[] points = spell.useSpell(this, opponent, num);// passing through character, opponent, and spell)
                            this.stats.put("currentHP", points[0]);           // Return Player HP
                            opponent.stats.put("currentHP", points[1]);       // Return enemy HP
                            this.stats.put("currentMP", points[2]);           // Return Player MP
                            System.out.println("The " + opponent.name + " Readies its Attack For "+ theirTotalDamage + " Damage!");
                            System.out.println("\n\n\n\n\n");
                            System.out.println(this.name +" HP: " + this.stats.get("currentHP") +"/" + this.stats.get("HP"));
                            System.out.println(this.name +" MP: " + this.stats.get("currentMP") +"/" + this.stats.get("MP"));       
                            try {
                                Thread.sleep(2000); //wait 2 seconds
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                            break;
                        case 3: 
                            System.out.println("Items are not out yet!");
                            break;
                        
                        case 4:                 
                        battle = false;
                        System.out.println("You Ran Away");
                        break;
    
                        default: 
                            break;
                    }

                }else{
                    if(theirTotalDamage < 0){
                        theirTotalDamage = 0;
                    }
                    storyBoard.clearScreen();
                    this.stats.put("currentHP", this.stats.get("currentHP") - theirTotalDamage);
                    turn++;
                    System.out.println(opponent.name + " Attacked for "+ theirTotalDamage + "!");
                    System.out.println( opponent.name + " HP: "+opponent.stats.get("currentHP") + "/" + opponent.stats.get("HP"));
                    System.out.println("\n\n\n\n\n");

                    System.out.println(this.name +" HP: " + this.stats.get("currentHP") +"/" + this.stats.get("HP"));
                    System.out.println(this.name +" MP: " + this.stats.get("currentMP") +"/" + this.stats.get("MP"));
                }
			}
		}
        return notLose;
	}
}