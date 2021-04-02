import java.util.*;

//this specialCharacer file is creating main characeter
public class specialCharacter extends nameCreation {
    String weapon;
    Hashtable<String, Integer> stats = new Hashtable<>(); // creating dictionary

    public specialCharacter(String name) {
        super(name); // inheritance of name (found in mob.java)
    }

    public void statrolls() {
        stats.put("HP", 10); // .put method assigns a key to the value (key, value)
        stats.put("ATTACK", 10);
        stats.put("LUCK", 10);
        stats.put("DEFENCE", 10);
        stats.put("MP", 10);

        Random ran = new Random();
        // this section randomizes the value in each stat
        String[] roller = { "ATTACK", "LUCK", "DEFENCE", "MP" };
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
        System.out.println("ATK: 10 → " + stats.get("ATTACK"));
        System.out.println("Lck: 10 → " + stats.get("LUCK"));
        System.out.println("MP:  10 → " + stats.get("MP"));
        System.out.println("DEF: 10 → " + stats.get("DEFENCE"));
    }

    public void printStat() {
        System.out.println("HP:  " + stats.get("HP"));
        System.out.println("ATK: " + stats.get("ATTACK"));
        System.out.println("LCK: " + stats.get("LUCK"));
        System.out.println("MP:  " + stats.get("MP"));
        System.out.println("DEF: " + stats.get("DEFENCE"));
    }
}