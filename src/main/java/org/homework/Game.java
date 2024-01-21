package org.homework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class Game {
    private static Scanner scan = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(Game.class);
    private char[] box;
    private byte i;
    private byte winner = 0;

    public Game() {
        initializeGame();
    }


    public void playGame() {
        boolean boxEmpty = false;
        while (true) {
            printBox();

            if (!boxEmpty) {
                clearBox();
                boxEmpty = true;
            }


            if (checkPresentWinner()) {
                break;
            }

            readUserXInput();

            if (checkIsUserWinner('X')) {
                winner = 1;
                continue;
            }

            if (notAvailableBox()){
                winner = 3;
                continue;
            }

            readUser0input();

            if (checkIsUserWinner('O')) {
                winner = 2;
                continue;
            }

            if (notAvailableBox()){
                winner = 3;
            }

        }
    }

    private boolean notAvailableBox(){
        boolean boxAvailable = false;
        for (i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                boxAvailable = true;
                break;
            }
        }
        return !boxAvailable;
    }



    private boolean checkPresentWinner() {
        if (winner == 1) {
            logger.info("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 2) {
            logger.info("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 3) {
            logger.info("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        return false;
    }

    private void readUserXInput() {
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
            } else
                logger.info("Invalid input. Enter again.");
        }
    }

    private void readUser0input(){
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * 9);
            if (box[rand] != 'X' && box[rand] != 'O') {
                box[rand] = 'O';
                break;
            }
        }
    }

    protected void printBox() {
        logger.info("\n\n {} | {} | {} ", box[0], box[1], box[2]);
        logger.info("-----------");
        logger.info(" {} | {} | {} ", box[3], box[4], box[5]);

        logger.info("-----------");
        logger.info(" {} | {} | {} \n", box[6], box[7], box[8]);

    }

    private boolean checkIsUserWinner(char charWinner) {
        return (box[0] == charWinner && box[1] == charWinner && box[2] == charWinner)
                || (box[3] == charWinner && box[4] == charWinner && box[5] == charWinner)
                || (box[6] == charWinner && box[7] == charWinner && box[8] == charWinner)
                || (box[0] == charWinner && box[3] == charWinner && box[6] == charWinner)
                || (box[1] == charWinner && box[4] == charWinner && box[7] == charWinner)
                || (box[2] == charWinner && box[5] == charWinner && box[8] == charWinner)
                || (box[0] == charWinner && box[4] == charWinner && box[8] == charWinner)
                || (box[2] == charWinner && box[4] == charWinner && box[6] == charWinner);
    }


    void initializeGame() {
        box = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        logger.info("Enter box number to select. Enjoy!\n");
    }

    private void clearBox() {
        for (i = 0; i < 9; i++)
            box[i] = ' ';
    }

}
