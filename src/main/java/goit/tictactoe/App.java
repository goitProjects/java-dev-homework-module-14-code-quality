package goit.tictactoe;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    private static final char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final Scanner scan = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        logger.info("Enter box number to select. Enjoy!\n");
        int winner;
        resetBoard();
        winner = 0;
        do {
            updateBoard();
            playerMove();

            if (checkWinner('X')) {
                winner = 1;
            } else if (!isBoxAvailable()) {
                winner = 3;
            } else {
                computerMove();
                if (checkWinner('O')) {
                    winner = 2;
                }
            }
        } while (!exitGame(winner));

    }

    private static void resetBoard(){
        for (int i = 0; i < 9; i++) {
            box[i] =  ' ';
        }
    }


    private static boolean exitGame(int winner) {
        if(winner != 0){
            printWinner(winner);
            scan.close();
            return true;
        }
        return false;
    }

    private static void updateBoard() {
        logger.info(() -> String.format(
                "%n%n %c | %c | %c %n"
                        + "-----------%n %c | %c | %c %n"
                        + "-----------%n %c | %c | %c %n",
                box[0], box[1], box[2],
                box[3], box[4], box[5],
                box[6], box[7], box[8]
        ));
    }

    private static boolean isBoxAvailable() {
        return IntStream.range(0, 9)
                .anyMatch(i -> box[i] != 'X' && box[i] != 'O');
    }

    private static void computerMove() {
        int rand;
        do{
            rand = ThreadLocalRandom.current().nextInt(0, 9);
        }while(box[rand] == 'X' || box[rand] == 'O');
        box[rand] = 'O';
    }

    private static void playerMove() {
        int input;
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

    private static void printWinner(int winner) {
        switch (winner) {
            case 1 -> logger.info("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            case 2 -> logger.info("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            case 3 -> logger.info("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            default -> logger.info("Error");
        }
    }

    private static boolean checkWinner(char player) {
        int[][] winPattern = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},    // Горизонтально
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},    // Вертикально
                {0, 4, 8}, {2, 4, 6}                // Діагонально
        };

        return Stream.of(winPattern)
                .anyMatch(pattern ->
                        box[pattern[0]] == player &&
                        box[pattern[1]] == player &&
                        box[pattern[2]] == player);
    }
}
