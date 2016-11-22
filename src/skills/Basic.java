package skills;

import hero.Main;
import java.util.Random;

/**
 * This class is one of the Skill classes.  By accessing this method, the hero will
 * be able to learn and use skills from this class.  This class has no prerequisites,
 * and most of the moves learned here are taught in the demo.
 * @author Blake Scammahorn
 */
public class Basic {
    
    private static Random rng = new Random();
    
    private static String[] moves = { "Punch", 
                                      "Kick", 
                                      "Tackle", 
                                      "Bandage", 
                                      "Recover", 
                                      "Block",
                                      "Dodge",
                                      "Wait" };
    
    public Basic() {}
    
    /**
     * Checks the input attack to see if it is a valid attack.  This early method does
     * not check for misspelled words- the words must be spelled correctly to work here.
     * @param input the user input attack
     * @return true if the attack is a learnable skill.
     */
    public static boolean checkMove(String input) {
        for(String u : moves) {
            if (u.toUpperCase().equals(input.toUpperCase()))
                return true;
        }
            return false;
    }
    
    /**
     * 
     * @param input
     * @return 
     */
    public static int moveDamage(String input) {
        switch(input.toUpperCase()) {
            case "PUNCH":   Main.changePower(Main.getPower() - 2); return 5 + rng.nextInt(5);
            case "KICK":    Main.changePower(Main.getPower() - 3); return 7 + rng.nextInt(5);
            case "TACKLE":  Main.changePower(Main.getPower() - 3); return 10;
            default: return 0;
        }
    }
    
    public static int moveAccuracy(String input) {
        switch(input.toUpperCase()) {
            case "PUNCH":   Main.changePower(Main.getPower() - 2); return 5 + rng.nextInt(5);
            case "KICK":    Main.changePower(Main.getPower() - 3); return 7 + rng.nextInt(5);
            case "TACKLE":  Main.changePower(Main.getPower() - 3); return 10;
            default: return 0;
        }
    }
    
    public static void moveEffect(String input) {
        switch(input.toUpperCase()) {
            case "BANDAGE": Main.changePower(Main.getPower() - 2); Main.changeHP(rng.nextInt(5)); break;
            case "BLOCK": break;
            case "DODGE": break;
            case "WAIT": Main.changePower(Main.getPower() + 3 + rng.nextInt(3)); break;
        }
    }
    
}