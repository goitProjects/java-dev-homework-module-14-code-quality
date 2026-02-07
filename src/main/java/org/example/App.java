package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    private static final char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    static boolean boxAvailable = true;

    private static void showMap() {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    private static boolean lineCheck(char chr) {
        for (int i = 0; i < 6; i += 3) {
            if(box[i] == chr && box[i] == box[i + 1] && box[i] == box[i + 2]) {
                    return true;
            }
        }

        return false;
    }
    private static boolean columCheck(char chr) {
        for (int i = 0; i < 3; i++) {
            if (box[i] == chr && box[i] == box[i + 3] && box[i] == box[i + 6]) {
                return true;
            }
        }
        return false;
    }
    private static boolean diagonalCheck(char chr) {
        for (int i = 0; i < 3; i += 2) {
            if (box[i]== chr && box[i] == box[4] && box[i] == box[8 - i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isThatWin(char chr) {
        return  lineCheck(chr) || columCheck(chr) || diagonalCheck(chr);
    }
    private static boolean whoWon() {
        if(isThatWin('X')) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        if (isThatWin('O')) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        if (!boxAvailable) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        return false;
    }

    private static boolean setCharInBox(int cord, char chr) {
        if (box[cord - 1] == ' ') {
            box[cord - 1] = chr;
            return true;
        }
        return false;
    }
    private static boolean setXInBox(byte cord) {
        if (cord > 0 && cord < 10) {
            return setCharInBox(cord, 'X');
        }
        System.out.println("Invalid input. Enter again.");
        return false;
    }
    private static void setOInBox() {
        boolean end = false;
        while (!end) {
            end = setCharInBox((byte) (Math.random() * 9 + 1), 'O');
        }
    }

    private static void isItDraw() {
        boxAvailable = false;
        for(byte i = 0; i < 9; i++) {
            if(box[i] == ' ') {
                boxAvailable = true;
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean gameIsEnd;

        System.out.println("Enter box number to select. Enjoy!\n");
        showMap();

        Arrays.fill(box, ' ');

        do {
            showMap();

            for (boolean end = false; !end;) {
                end = setXInBox(scan.nextByte());
            }
            gameIsEnd = whoWon();
            isItDraw();
            if (boxAvailable && !gameIsEnd) {
                setOInBox();
                gameIsEnd = whoWon();
            }

        } while (!gameIsEnd);
        scan.close();
    }
}
