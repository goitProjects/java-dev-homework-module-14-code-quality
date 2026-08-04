package org.example;

import java.util.Scanner;
import java.util.logging.Logger;


public class App {
    private static final Logger logger = Logger.getLogger (App.class.getName ());

    private static final char PLAYER_SYMBOL = 'X';
    private static final char BOT_SYMBOL = 'O';
    private static final char EMPTY_SYMBOL = ' ';

    private static final int[][] WIN_CONDITIONS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };

    private static void printBoard (char[] box) {
        String textFormat = "\n\n %c | %c | %c ";
        logger.info (() -> String.format (textFormat, box[0], box[1], box[2]));
        logger.info ("-----------");
        logger.info (() -> String.format (textFormat, box[3], box[4], box[5]));
        logger.info ("-----------");
        logger.info (() -> String.format (textFormat, box[6], box[7], box[8]));
    }

    private static void printGameResult (int winner) {
        if (winner == 1) {
            logger.info ("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 2) {
            logger.info ("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 3) {
            logger.info ("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }

    private static void processPlayerTurn (Scanner scan, char[] box) {
        while (true) {
            byte input = scan.nextByte ();
            if (input > 0 && input < 10) {
                if (box[input - 1] == PLAYER_SYMBOL || box[input - 1] == BOT_SYMBOL)
                    logger.info ("That one is already in use. Enter another.");
                else {
                    box[input - 1] = PLAYER_SYMBOL;
                    break;
                }
            } else logger.info ("Invalid input. Enter again.");
        }
    }

    private static void processBotTurn (char[] box) {
        while (true) {
            byte rand = (byte) (Math.random () * (9 - 1 + 1) + 1);
            if (box[rand - 1] != PLAYER_SYMBOL && box[rand - 1] != BOT_SYMBOL) {
                box[rand - 1] = BOT_SYMBOL;
                break;
            }
        }
    }

    private static boolean isBoardFull (char[] box) {
        for (int i = 0; i < 9; i++) {
            if (box[i] != PLAYER_SYMBOL && box[i] != BOT_SYMBOL) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkWin (char[] box, char symbol) {
        for (int[] condition : WIN_CONDITIONS) {
            if (box[condition[0]] == symbol && box[condition[1]] == symbol && box[condition[2]] == symbol) {
                return true;
            }
        }

        return false;
    }

    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);
        byte winner = 0;
        char[] box = {EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL};
        logger.info ("Enter box number to select. Enjoy!\n");

        while (winner == 0) {
            printBoard (box);

            processPlayerTurn (scan, box);

            if (checkWin (box, PLAYER_SYMBOL)) {
                winner = 1;
            } else if (isBoardFull (box)) {
                winner = 3;
            } else {
                processBotTurn (box);

                if (checkWin (box, BOT_SYMBOL)) {
                    winner = 2;
                }
            }
        }

        printBoard (box);
        printGameResult (winner);
    }
}
