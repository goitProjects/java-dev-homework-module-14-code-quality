package app;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private static final char EMPTY_CELL = ' ';
    private static final char PLAYER_SYMBOL = 'X';
    private static final char COMPUTER_SYMBOL = 'O';
    private static final int BOARD_SIZE = 9;
    private static final int MAX_CELL_INDEX = 9;
    private static final int MIN_CELL_INDEX = 1;

    private final Scanner scan = new Scanner(System.in);
    private final char[] box = new char[BOARD_SIZE];
    private final Random random = new Random();

    public void start() {
        Arrays.fill(box, EMPTY_CELL);
        int winner = 0;

        System.out.println("Enter box number to select. Enjoy!\n");

        while (true) {
            printBoard();

            if (winner != 0) {
                printGameOverMessage(winner);
                break;
            }

            playerMove();

            if (isWinner(PLAYER_SYMBOL)) {
                winner = 1;
            } else if (isDraw()) {
                winner = 3;
            } else {
                computerMove();

                if (isWinner(COMPUTER_SYMBOL)) {
                    winner = 2;
                }
            }
        }
    }

    private void printBoard() {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    private void playerMove() {
        while (true) {
            byte input = scan.nextByte();
            if (input >= MIN_CELL_INDEX && input <= MAX_CELL_INDEX) {
                if (box[input - 1] == PLAYER_SYMBOL || box[input - 1] == COMPUTER_SYMBOL) {
                    System.out.println("That one is already in use. Enter another.");
                } else {
                    box[input - 1] = PLAYER_SYMBOL;
                    break;
                }
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }

    private void computerMove() {
        while (true) {
            byte rand = (byte) (random.nextInt(MAX_CELL_INDEX) + 1);
            if (box[rand - 1] != PLAYER_SYMBOL && box[rand - 1] != COMPUTER_SYMBOL) {
                box[rand - 1] = COMPUTER_SYMBOL;
                break;
            }
        }
    }

    private boolean isWinner(char symbol) {
        return (box[0] == symbol && box[1] == symbol && box[2] == symbol)
                || (box[3] == symbol && box[4] == symbol && box[5] == symbol)
                || (box[6] == symbol && box[7] == symbol && box[8] == symbol)
                || (box[0] == symbol && box[3] == symbol && box[6] == symbol)
                || (box[1] == symbol && box[4] == symbol && box[7] == symbol)
                || (box[2] == symbol && box[5] == symbol && box[8] == symbol)
                || (box[0] == symbol && box[4] == symbol && box[8] == symbol)
                || (box[2] == symbol && box[4] == symbol && box[6] == symbol);
    }

    private boolean isDraw() {
        for (char c : box) {
            if (c != PLAYER_SYMBOL && c != COMPUTER_SYMBOL) {
                return false;
            }
        }
        return true;
    }

    private static void printGameOverMessage(int winner) {
        switch (winner) {
            case 1 -> System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            case 2 -> System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            case 3 -> System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            default -> System.out.println("Unexpected game status.");
        }
        System.exit(0);
    }
}
