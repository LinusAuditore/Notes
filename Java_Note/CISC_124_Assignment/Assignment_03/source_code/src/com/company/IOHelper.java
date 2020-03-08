package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This is a simple IOHelper class
 * It can be used to:
 * obtain an int from the user
 * obtain a String from the user
 * It accept:
 * the low legal limit
 * the high legal limit
 * a String prompt
 *
 * @author Xinghao ZUo
 */
public class IOHelper{
    // First, instantiate the scanner to let user make input.
    private static Scanner input = new Scanner(System.in);


    /**
     * This method is used to turn user input to a String.
     * @param content the user input
     * @return the String of the user's input
     */
    public static String getString(String content) {
        String userInput;
        System.out.println(content);
        userInput = input.nextLine();
        return userInput;
    }


    /**
     * This method is used to turn user input to a int.
     * @param l the minimum value of the number
     * @param s the description which is gave to user
     * @param h the maximum value of the number
     * @return userNum the int form value user input
     */
    public static int getInt(int l, String s, int h) {
        int usrNum;
        boolean correctEnter;
        String usrInpt;
        do {
            System.out.print(s);
            correctEnter = false;
            try {
                usrNum = input.nextInt();
                correctEnter = true;
                input.nextLine();
            } catch (InputMismatchException e) {
                usrInpt = input.nextLine();
                System.out.println("Your input <"+ usrInpt + "> isn't an integer!");
                usrNum = l;
            }
            if (usrNum < l || usrNum > h) {
                System.out.println("The number <"+usrNum+"> is outside the rage");
            }
        } while (!correctEnter || usrNum < l || usrNum > h);
        return usrNum;
    }
}
