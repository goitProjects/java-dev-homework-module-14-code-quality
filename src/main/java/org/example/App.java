package org.example;

import java.util.Random;
import java.util.Scanner;

public class App {

    private static final char PLAYER_SYMBOL = 'X';
    private static final char COMPUTER_SYMBOL = 'O';

    private static final char[] BOX = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    private static final Scanner scan = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        byte winner = 0;
        boolean isBoxEmpty = false;

        System.out.println("Enter box number to select. Enjoy!\n");


        while (true){
            showBox();

            if (!isBoxEmpty){
                clearBox();
                isBoxEmpty = true;
            }

            if (winner == 1 || winner == 2 || winner == 3){
                System.out.println(endGameMessage(winner) + " reworked by Dmitriy.");
                break;
            }

            playersMove();

            if (checkForWin(PLAYER_SYMBOL)){
                winner = 1;
                continue;
            }

            if (isBoxFull()){
                winner = 3;
                continue;
            }

            computersMove();

            if(checkForWin(COMPUTER_SYMBOL)){
                winner = 2;
            }
        }
    }

    private static void computersMove() {
        int rand;
        do {
            rand = random.nextInt(9);
        } while (BOX[rand] == PLAYER_SYMBOL || BOX[rand] == COMPUTER_SYMBOL);
        BOX[rand] = COMPUTER_SYMBOL;
    }

    private static boolean isBoxFull() {
        for(char cell: BOX) {
            if (cell != PLAYER_SYMBOL && cell != COMPUTER_SYMBOL){
                return false;
            }
        }
        return true;
    }

    private static boolean checkForWin(char symbol) {
        return (BOX[0]==symbol && BOX[1]==symbol && BOX[2]==symbol) || (BOX[3]==symbol && BOX[4]==symbol && BOX[5]==symbol) || (BOX[6]==symbol && BOX[7]==symbol && BOX[8]==symbol) ||
                (BOX[0]==symbol && BOX[3]==symbol && BOX[6]==symbol) || (BOX[1]==symbol && BOX[4]==symbol && BOX[7]==symbol) || (BOX[2]==symbol && BOX[5]==symbol && BOX[8]==symbol) ||
                (BOX[0]==symbol && BOX[4]==symbol && BOX[8]==symbol) || (BOX[2]==symbol && BOX[4]==symbol && BOX[6]==symbol);
    }

    private static void playersMove() {
        byte input;

        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (BOX[input - 1] == 'X' || BOX[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    BOX[input - 1] = 'X';
                    break;
                }
            }
            else
                System.out.println("Invalid input. Enter again.");
        }
    }

    private static String endGameMessage(byte winner) {
        if (winner == 1){
            return "You won the game!";
        }
        if (winner == 2){
            return "You lost the game!";
        }
        else {
            return "It's a draw!";
        }

    }

    private static void clearBox() {
        for(byte i = 0; i < 9; i++) {
            BOX[i] = ' ';
        }

    }

    private static void showBox(){

        System.out.println("\n\n " + BOX[0] + " | " + BOX[1] + " | " + BOX[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + BOX[3] + " | " + BOX[4] + " | " + BOX[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + BOX[6] + " | " + BOX[7] + " | " + BOX [8] + " \n");


    }

}