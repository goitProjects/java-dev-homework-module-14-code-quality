package rewriteTheCode;

import java.util.Scanner;

public class CheckTheGame {
    private char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private boolean boxEmpty = false;
    private byte input;
    private byte rand;
    private byte i;

    private static final Scanner SCAN = new Scanner(System.in);
    private static final char PLAYER = 'X';
    private static final char COMPUTER = 'O';

    public byte winner = 0;

    public CheckTheGame(){
        clearBoard();
    }

    public void checkingForGame() {
        printingBoard();
        while (winner == 0) {
            if (!boxEmpty) {
                clearBoard();
                boxEmpty = true;
            }

            playerMore();
            computerOrPlayer();
            if(winner != 0){
                break;
            }

            computerMove();
            computerOrPlayer();
            if(winner != 0){
                break;
            }

            printingBoard();
        }
        printingBoard();
        switchForInfo();
    }

    private static char checkWinner(char[] box) {
        int[][] numbers = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };
        for (int[] number : numbers) {
            char firstSymbol = box[number[0]];
            if (firstSymbol != ' ' && firstSymbol == box[number[1]] && firstSymbol == box[number[2]]) {
                return firstSymbol;
            }
        }
        return '\0';
    }

    private void printingBoard(){
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    private boolean empyCells() {
        for (char c : box) {
            if (c != PLAYER && c != COMPUTER) {
                return true;
            }
        }
        return false;
    }

    private void computerOrPlayer(){
        char winnerChar = checkWinner(box);
        if (winnerChar == PLAYER) {
            winner = 1;
        } else if (winnerChar == COMPUTER) {
            winner = 2;
        } else if(!empyCells()){
            winner = 3;
        }
    }

    private  void switchForInfo(){
        switch (winner){
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
                System.out.println("Error");
                break;
        }
    }

    private void clearBoard() {
        for (int i = 0; i < 9; i++) {
            box[i] = (char) ('1' + i);
        }
        boxEmpty = true;
    }

    private void  playerMore(){
        while (true) {
            input = SCAN.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == PLAYER || box[input - 1] == COMPUTER)
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[input - 1] = PLAYER;
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }

    private void computerMove(){
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != PLAYER && box[rand - 1] != COMPUTER) {
                box[rand - 1] = COMPUTER;
                break;
            }
        }
    }
}