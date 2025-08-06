package com.example;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static Logger logger = Logger.getLogger("");
    private static String welcomeTemplate = "%n%n %c | %c | %c ";
    private static Random randomGenerator = new Random();

    private static void printWelcomeMsg(char[] box) {
        // here we use 'sout' because logger will make the output ugly
        // ignore Sonar remarks on this matter
        System.out.println(String.format(welcomeTemplate, box[0], box[1], box[2]));
        System.out.println("-----------");
        System.out.println(String.format(welcomeTemplate, box[3], box[4], box[5]));
        System.out.println("-----------");
        System.out.println(String.format(welcomeTemplate, box[6], box[7], box[8]));

    }

    private static void printResultMsg(int winner) {
        switch (winner) {
            case 1:
                logger.info("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            case 2:
                logger.info("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            case 3:
                logger.info("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            default:
                logger.log(Level.WARNING, "Wrong variable value: {} (expected 1, 2, or 3)", winner);
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

    private static void makeBoxEmpty(char[] box) {
        for(int i = 0; i < 9; i++)
            box[i] = ' ';
    }

    private static byte generateRandomByteValye(int size) {
        return (byte) randomGenerator.nextInt(size);
    }

    private static void askForCell(Scanner scan, char[] box) {
        byte input;
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    logger.info("That one is already in use. Enter another.");
                else {
                    box[input - 1] = 'X';
                    break;
                }
            }
            else
                logger.info("Invalid input. Enter again.");
        }
    }

    private static boolean boxFull(char[] box) {
        for(int i=0; i<9; i++){
            if(box[i] != 'X' && box[i] != 'O'){
                return false;
            }
        }
        return true;
    }

    private static void computerMove(char[] box) {
        byte rand;
        while (true) {
            rand = generateRandomByteValye(box.length);
            if (box[rand] != 'X' && box[rand] != 'O') {
                box[rand] = 'O';
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        logger.info("Enter box number to select. Enjoy!\n");

        boolean needToEmptyBox = true;
        while (true) {
            printWelcomeMsg(box);
            if(needToEmptyBox){
                makeBoxEmpty(box);
                needToEmptyBox = false;
            }

            askForCell(scan, box);

            if(allMatch(box, 'X')){
                printResultMsg(1);
                return;
            }

            if(boxFull(box)){
                printResultMsg(3);
                return;
            }

            computerMove(box);

            if(allMatch(box, 'O')) {
                printResultMsg(2);
                return;
            }
        }

    }
}
