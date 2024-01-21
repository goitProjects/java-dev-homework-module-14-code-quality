package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private Scanner scan = new Scanner(System.in);
    private byte winner = 0;
    private char [] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    private char [][] board = new char [3][3];

    public void start() {
        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;
        byte i;
        while (true) {
            displayBoard();
            if(!boxEmpty){
                for(i = 0; i < 9; i++)
                    box[i] = ' ';
                boxEmpty = true;
            }

            checkWinner();

            if(winner != 0)
                break;

            playerMove();
            computerMove();

        }
    }

    private void displayBoard() {
        System.out.println("\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    private void playerMove() {
        while (true) {
            try {
                byte input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (box[input - 1] == 'X' || box[input - 1] == 'O')
                        System.out.println("That one is already in use. Enter another.");
                    else {
                        box[input - 1] = 'X';
                        break;
                    }
                } else {
                    System.out.println("Invalid input. Enter again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.next();
            }
        }
    }

    private void computerMove() {
        byte rand = 0;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    private void checkWinner() {
        int[][] winningCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] combination : winningCombinations) {
            if (checkCombination(combination, 'X')) {
                winner = 1;
                System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                return;
            } else if (checkCombination(combination, 'O')) {
                winner = 2;
                System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                return;
            }
        }

        if (isDraw()) {
            winner = 3;
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }

    private boolean checkCombination(int[] combination, char player) {
        return box[combination[0]] == player && box[combination[1]] == player && box[combination[2]] == player;
    }

    private boolean isDraw() {
        for (char c : box) {
            if (c != 'X' && c != 'O') {
                return false;
            }
        }
        return true;
    }
}

