
package hero;

import static hero.Main.enterName;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import skills.Basic;

  /**___________________________________________________________**\
 /==/                                                           \==\
 |//|  Project:     Superhero proto-prototype			|//|
 |//|  Name:        Blake Scammahorn                            |//|
 |//|  Date:        long ago, in a distant land			|//|
 |//|  Description: Creates a short... toy which prompts input	|//|
 |//|		    from the user in order to deal attacks,     |//| 
 |//|               heal, or exit the game.             	|//|
 |//|               There is no enemy coded yet, so using attack|//|
 |//|               too many times in a row should result in the|//| 
 |//|               hero death for now.                         |//|
 \==\___________________________________________________________/==/
  \*////////////////////////////|\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\*/
public class CombatInterface {

    private static String userInput;                        //holds user input
    private static Random rng = new Random();               //creates new randomizer object
    private static Scanner input = new Scanner(System.in);  //for taking player input
    private static ArrayList activePowers = new ArrayList();//holds valid attacks
    
    public static void combatInterface() {
         // TODO code application logic here
        int userCheck;      //stores user input
        boolean truthCheck = false; //checks checkStats for values
        
        enterName();
        do {
            System.out.println("|-------commands-------|"); //22 characters long
            System.out.println("| skill list=1  rest=2 |");
            System.out.println("| exit=0               |");
            System.out.println("|---------stats--------|");
            System.out.printf("| hp: %-3d    power: %-3d|%n", Main.getHP(), Main.getPower());
            System.out.println("|----------------------|");
                
                userInput = input.next();
                
            if(Basic.checkMove(userInput)) { //checks the move against the move database
                if(!activePowers.contains(userInput)) //if there is a match
                    activePowers.add(userInput);
                
            }
            else {
                try {
                    userCheck = Integer.parseInt(userInput);
                } 
                catch (Exception e) {
                    userCheck = 3; //causes invalid entry
                
                }
            
                //0 should cause the loop to stop.  1 uses powers, 2 uses rest, and anything else calls invalid entry, and loops again
                switch (userCheck) {
                    case 0 : truthCheck = true; break;
                    case 1 : usePower(); truthCheck = checkStats(); break;
                    case 2 : System.out.println("Sorry, this feature isnt availible yet"); truthCheck = false; break;
                    default: System.out.println("Invalid entry!  Try again!"); truthCheck = false;
                }
            }        
            
        } while (truthCheck == false);
        
        System.out.println("G A M E   O V E R");
    }
    
    /**
     * Check to see if you die
     */
    public static boolean checkStats() {
        if (Main.getHP() <= 0 || Main.getPower() <= 0) {//if power is below 0 or hp is below 0
            System.out.println("You have been defeated by your nemesis!");
            return true;    //return true if he ded (for use in checking to end program)
        } else
            return false;
    }
    
    /**
     * use a superpower to beat the bad guys
     */
    public static void usePower() {
        int hit = rng.nextInt(10);      //checks for misses and critical hits
        int damage = rng.nextInt(10);   //checks for the damage the attack deals
        
        if (Main.getHP() <= 5 || Main.getPower() <= 5) {//if youve taken a lot of damage, or you've used up too much power
                System.out.println("in desperation, " + Main.getName() + " used one last attack!");
           System.out.println(Main.getName() + " " /*+ attacks[rng.nextInt(10)]*/);
           
           int finalStrike = damage * 3; //Re-roll RNG, then multiply by 3 for a final attack
           
           while (hit == 0){ //check RNG variable for the hit-check to see if it's zero.  If it is, re-roll it
               hit = rng.nextInt(10);
           }
           
           System.out.println( Main.getName() + " did " + finalStrike + " damage!");
        } else { //that is, if the HP/srength isnt low
        
            if (hit == 1) {//if the random number for hit-check is a 1
                System.out.println( Main.getName() + " tripped!");
                Main.changeHP(Main.getHP() - rng.nextInt(5)); //reduce HP by no more than 5, and no attack goes off.  effectively a critical fail
            } else {   //that is, if the hit-check roll wasn't 1
                System.out.println(Main.getName() + " " /*+ attacks[rng.nextInt(10)]*/);//output name + " " + array output(RNG)
                
                if (damage == 0) {//if the random damage number is 0
        
                    System.out.println("but the attack seemed to do nothing at all!");
                }
                else{  //that is, if the damage check wasnt 0
                    
                    if (hit >= 10) { //if the hit was critical
                        damage *= 2;
                        System.out.print("Critical hit! ");
                    }
                    System.out.println(Main.getName() + " did " + damage + " damage!");
                }//end if statement for damage
            }//end  statement for hit-checking
        }//end desperation check
        Main.changePower(Main.getPower() - 5);//reduce strength by 5, as a cost to attack
    }
    
}