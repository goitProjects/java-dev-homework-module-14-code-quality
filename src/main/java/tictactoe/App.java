package tictactoe;

import java.util.Scanner;
import java.util.logging.*;

public class App {

    private static final Logger LOGGER = Logger.getLogger("App");

    static {
        LogManager.getLogManager().reset();
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord logRecord) {
                return logRecord.getMessage() + "\n";
            }
        });

        LOGGER.setLevel(Level.FINEST);
        LOGGER.addHandler(consoleHandler);
    }

    Scanner scan = new Scanner(System.in);
    byte input;
    byte rand;
    byte i;
    boolean boxAvailable = false;
    byte winner = 0;
    boolean boxEmpty = false;

    char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };


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
        if(winner == 1){
            LOGGER.info("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if(winner == 2){
            LOGGER.info("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if(winner == 3){
            LOGGER.info("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }

        return false;
    }

    private void checkIfItsDraw() {
        boxAvailable = false;
        for(i=0; i<9; i++){
            if(box[i] != 'X' && box[i] != 'O'){
                boxAvailable = true;
                break;
            }
        }

        if(!boxAvailable){
            winner = 3;
        }
    }

    private void checkIfComputerWon() {
        if (checkRows('O'))
            winner = 2;
    }

    private void checkIfPlayerWon() {
        if (checkRows('X'))
            winner = 1;
    }


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

    private boolean checkRow(char character, int index1, int index2, int index3 ) {
        return box[index1] == character && box[index2] == character && box[index3] == character;
    }

    private void computersMove() {
        if (winner != 0) return;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    private void playersMove() {
        if (winner != 0) return;
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    LOGGER.info("That one is already in use. Enter another.");
                else {
                    box[input - 1] = 'X';
                    break;
                }
            }
            else
                LOGGER.info("Invalid input. Enter again.");
        }
    }

    private void printBoard() {
        LOGGER.info("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        LOGGER.info("-----------");
        LOGGER.info(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        LOGGER.info("-----------");
        LOGGER.info(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");

        if(!boxEmpty){
            for(i = 0; i < 9; i++)
                box[i] = ' ';
            boxEmpty = true;
        }
    }
}