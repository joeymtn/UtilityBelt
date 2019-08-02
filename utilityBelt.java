/**
 * @(#)utilityBelt.java
 *
 * utilityBelt application for CS 112 students to help with their homework menus. I am not responsible for the actions of
 * 112 students that use this to plagiarize their homework, I simply demonstrate this utilityBelt as an educational guide for
 * students to make their own.
 *
 * @author Joey Martin, GitHub: joeymtn
 * @version 1.00 2018/9/29
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class utilityBelt

{
    /**
     * static method that asks user for an integer input such that first Val < value < SecondVal, everything inbetween are valid choices
     * @param key(Scanner, passed in via outside variable)
     * @return user's input
     */



    public static int  intChecker(Scanner key, int firstVal, int secondVal,  String prompt) throws InputMismatchException
    {
        int value;
        boolean invalid;
        value = 0;
        do
        {
            System.out.println(prompt);
            value = key.nextInt();
            invalid = (value < firstVal || value > secondVal);
            if(invalid) {
                System.out.println("invalid entry! please choose a value between " + firstVal + " and " + secondVal);
            }
        }
        while(invalid);
        key.nextLine();
        System.out.println(value);
        return value;
    }


    /**
     * Utility Belt char checker that asks users for values
     * @param key Scanner key you pass in as an independent object.
     * @param correctCharChoices list of correct choices  you'd like to ask the user
     * @param prompt(message you send to the user asking for data
     * @return choice of char from the list
     */
	public static char charChecker(Scanner key, String correctCharChoices, String prompt) {
        String value;
        boolean invalid;
        value = "*";
        do {
            System.out.println(prompt);
            value = key.nextLine();
            invalid = !(correctCharChoices.toLowerCase().contains(value.toLowerCase()));
            if (invalid) {
                System.out.println("Your choice is invalid! please between these values \n" + correctCharChoices);
            }
        }
        while (invalid);
        return value.charAt(0);
    }

    /**
     * Static method that asks user for string input, keeps user in infinite loop if user does not choose proper values
     * PRECONDITION: Choices are denoted by a space
     * @param key
     * @param choices
     * @param prompt
     * @return valid user choice
     */
    public static String stringChecker(Scanner key, String choices, String prompt) {
        boolean invalid;
        String value;
        do {
            System.out.println(prompt);
            value = key.nextLine();
            String[] arrChoices = value.split(" ");
            invalid = !stringArrContains(arrChoices, value);
            if(invalid) {
                System.out.println("Your choice is invalid! please pick between these values " + choices);
            }

        }
        while(invalid);

        return value;

    }

    /**
     * helper method that searches array for string, returns true if present, else returns false
     * @param arr
     * @param value
     * @return true/false
     */
    private static boolean stringArrContains(String[] arr, String value) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
   
}
