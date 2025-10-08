package com.example;

import java.util.Random;
import java.util.Scanner;

public class App {
    private static final String WELCOME_TEMPLATE = "%n%n %c | %c | %c ";
    private static final Random randomGenerator = new Random();
    private static final char PLAYER_SIGN = 'X';
    private static final char COMPUTER_SIGN = 'O';
    private static final int ZERO_CELL_NUMBER = 0;
    private static final int LAST_CELL_NUMBER = 8;

    private static void printWelcomeMsg(char[] box) {
        // here we use 'sout' because logger will make the output ugly
        // ignore Sonar remarks on this matter
        System.out.println(String.format(WELCOME_TEMPLATE, box[0], box[1], box[2]));
        System.out.println("-----------");
        System.out.println(String.format(WELCOME_TEMPLATE, box[3], box[4], box[5]));
        System.out.println("-----------");
        System.out.println(String.format(WELCOME_TEMPLATE, box[6], box[7], box[8]));

    }

    private static void printResultMsg(int winner) {
        switch (winner) {
            case 1:
                System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            case 2:
                System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            case 3:
                System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            default:
                System.out.println(String.format("Wrong variable value: %d (expected 1, 2, or 3)", winner));
                break;
        }
    }

    private static boolean allMatch(char[] arr, char value) {
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != value) {
                return false;
            }
        }
        return true;
    }

    // private static void makeBoxEmpty(char[] box) {
    //     for(int i = ZERO_CELL_NUMBER; i < LAST_CELL_NUMBER + 1; i++)
    //         box[i] = ' ';
    // }

    private static int generateRandomIntValue(int size) {
        return (int) randomGenerator.nextInt(size);
    }

    private static void askForCell(Scanner scan, char[] box) {
        int input;
        while (true) {
            input = scan.nextInt();
            if (input > ZERO_CELL_NUMBER && input < 10) {
                if (box[input - 1] == PLAYER_SIGN || box[input - 1] == COMPUTER_SIGN)
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[input - 1] = PLAYER_SIGN;
                    break;
                }
            }
            else
                System.out.println("Invalid input. Enter again.");
        }
    }

    private static boolean boxFull(char[] box) {
        for(int i = ZERO_CELL_NUMBER; i < LAST_CELL_NUMBER + 1; i++){
            if(box[i] != PLAYER_SIGN && box[i] != COMPUTER_SIGN){
                return false;
            }
        }
        return true;
    }

    private static void computerMove(char[] box) {
        int rand;
        while (true) {
            rand = generateRandomIntValue(box.length);
            if (box[rand] != PLAYER_SIGN && box[rand] != COMPUTER_SIGN) {
                box[rand] = COMPUTER_SIGN;
                return;
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
            System.out.println("Enter box number to select. Enjoy!\n");
    
            // boolean needToEmptyBox = true;
            while (true) {
                printWelcomeMsg(box);
                // if(needToEmptyBox){
                //     makeBoxEmpty(box);
                //     needToEmptyBox = false;
                // }
    
                askForCell(scan, box);
    
                if(allMatch(box, PLAYER_SIGN)){
                    printResultMsg(1);
                    return;
                }
    
                if(boxFull(box)){
                    printResultMsg(3);
                    return;
                }
    
                computerMove(box);
    
                if(allMatch(box, COMPUTER_SIGN)) {
                    printResultMsg(2);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
