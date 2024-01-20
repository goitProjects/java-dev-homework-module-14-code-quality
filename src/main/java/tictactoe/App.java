package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.*;

public class App {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(App.class));
    Scanner scan;
    boolean boxAvailable = false;
    byte winner = 0;
    boolean boxEmpty = false;
    char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};


    /*setting up the LOGGER*/
    static {
        LogManager.getLogManager().reset();
        ConsoleHandler customHandler = new ConsoleHandler();

        customHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord logRecord) {
                return logRecord.getMessage() + "\n";
            }
        });

        LOGGER.setLevel(Level.FINEST);
        LOGGER.addHandler(customHandler);
    }

    public App() {
        this.scan = new Scanner(System.in);
    }

    public void mainLoop() {
        LOGGER.info("Enter box number to select. Enjoy!\n");

        while (true) {
            printBoard();

            if (isGameEnded())
                break;

            playersMove();
            checkIfPlayerWon();
            checkIfItsDraw();
            computersMove();
            checkIfComputerWon();
        }
    }


    private boolean isGameEnded() {
        if (winner == 1) {
            LOGGER.info("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 2) {
            LOGGER.info("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 3) {
            LOGGER.info("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }

        return false;
    }


    private void checkIfItsDraw() {
        for (byte i = 0; i < 9; i++) {
            if (board[i] != 'X' && board[i] != 'O') {
                boxAvailable = true;
                break;
            }
        }

        if (!boxAvailable)
            winner = 3;
    }


    private void checkIfComputerWon() {
        if (checkRows('O'))
            winner = 2;
    }


    private void checkIfPlayerWon() {
        if (checkRows('X'))
            winner = 1;
    }

    /**
     * checks whether conditions of victory are met
     * i.e. whether there is row of the same chars
     **/
    private boolean checkRows(char character) {
        return checkRow(character, 0, 1, 2) ||
                checkRow(character, 3, 4, 5) ||
                checkRow(character, 6, 7, 8) ||
                checkRow(character, 0, 3, 6) ||
                checkRow(character, 1, 4, 7) ||
                checkRow(character, 2, 5, 8) ||
                checkRow(character, 0, 4, 8) ||
                checkRow(character, 2, 4, 6);
    }


    private boolean checkRow(char character, int index1, int index2, int index3) {
        return board[index1] == character && board[index2] == character && board[index3] == character;
    }


    private void computersMove() {
        if (winner != 0) return;

        while (true) {
            byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (board[rand - 1] != 'X' && board[rand - 1] != 'O') {
                board[rand - 1] = 'O';
                break;
            }
        }
    }


    private void playersMove() {
        if (winner != 0) return;

        while (true) {

            byte input = scan.nextByte();

            if (input > 0 && input < 10) {
                if (board[input - 1] == 'X' || board[input - 1] == 'O')
                    LOGGER.info("That one is already in use. Enter another.");
                else {
                    board[input - 1] = 'X';
                    break;
                }
            } else
                LOGGER.info("Invalid input. Enter again.");
        }
    }



    private void printBoard() {
        LOGGER.info("\n\n " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        LOGGER.info("-----------");
        LOGGER.info(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        LOGGER.info("-----------");
        LOGGER.info(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");

        if (!boxEmpty) {
            for (byte i = 0; i < 9; i++)
                board[i] = ' ';
            boxEmpty = true;
        }
    }
}