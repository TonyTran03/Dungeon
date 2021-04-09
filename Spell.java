import java.util.*;

public class spell {

    public static int[] useSpell(specialCharacter me, creature it, int spellNumber){
        while(true){ //going to loops this until person decides to break out of this loop
            storyBoard.clearScreen();
        switch (spellNumber){
            case 1:
                if(me.stats.get("currentMP") >= 7){
                    System.out.println("You casted Fireball");
                    me.stats.put("currentMP", me.stats.get("currentMP") - 7);
                    it.stats.put("currentHP", it.stats.get("currentHP") - 10);
                    break;
                }
                else{
                    System.out.println("You Don't Have Enough Mana (" + me.stats.get("currentMP") +"/7)");
                    break;
                }

            
            case 2:
                System.out.println("You Healed (+10)");
                me.stats.put("currentHP", me.stats.get("currentHP")+10);
                if(me.stats.get("currentHP") > me.stats.get("HP")){
                    me.stats.put("currentHP", me.stats.get("HP")); // I want to heal, not gain HP. This line makes sure the player heals, and that health will not go past max HP.
                }
                break;


            default: 
                System.out.println("Do nothing");
                break;
        }
        int[] points = {me.stats.get("currentHP"), it.stats.get("currentHP"), me.stats.get("currentMP")};
        return points;
        }
    }   
}
