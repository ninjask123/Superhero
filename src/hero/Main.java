/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hero;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author programming
 */
public class Main {
        //Like any good play, the main characters are introduced in the bill at the top
    private static String name;                             //define constant NAME with player input
    private static int power = 100;                         //define strength, effectively a mana system
    private static int hp = 100;                            //defines HP of the character
    private static Random rng = new Random();               //creates new randomizer object
    private static Scanner input = new Scanner(System.in);  //for taking player input
    
    public static void main(String[] args) {
        CombatInterface.combatInterface(); //currently the only runnable procedure for demo purposes
    }

    /**
     * @return the current name.  If there is no name, returns blank.
     */
    public static String getName() {
        if(name == null) {
            return "";
        }
        return name;
    }
    
    /**
     * @return the current HP
     */
    public static int getHP() {
        return hp;
    }
    
    /**
     * @param newHP the HP to change to
     * @return the new HP 
     */
    public static int changeHP( int newHP) {
        hp = (newHP >= 0)? newHP : 0;
        return hp;
    }
    
    /**
     * @return current power
     */
    public static int getPower() {
        return power;
    }
    
    /**
     * @param newPower the power value to change to
     * @return new power
     */
     public static int changePower( int newPower) {
         power = (newPower >= 0)? newPower : 0;
        return power;
    }
    
    /**
    initialize character name
    */
    public static void enterName() {
        String yn = "";
        
        do {
        System.out.print("What is your superhero name? ");
        name = input.nextLine();        //initialize superhero name
        
        System.out.println("is " + name + " correct? y/n");
        yn = input.nextLine();
        } while (yn.charAt(0) != 'y'); //if no, it'll loop back to asking you for the name
       
        System.out.println(name + " flies into the sunset!");  //and thus, your adventure has begun
    }
}