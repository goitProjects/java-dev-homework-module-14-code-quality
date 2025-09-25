package game;

import java.util.Scanner;

public class Game {
    private final Scanner scan;
    private byte winner = 0;
    private final Byte[] startField;
    private final Cell[] field;


    public Game() {
        scan = new Scanner(System.in);
        startField = new Byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        field = new Cell[9];
        for (int i = 0; i < 9; i++) {
            field[i] = Cell.EMPTY;
        }
    }

    @SuppressWarnings("java:S106")
    public void startGame() {
        System.out.println("Enter box number to select. Enjoy!\n");
        printField(startField);
        do {
            if (winner > 0) {
                printField(field);
                overGame();
                break;
            }
            getPlaceForX();
            if (isWinner(Cell.X)) {
                winner = 1;
            } else if (!isGameAvailable()) {
                winner = 3;
            } else {
                getPlaceForO();
                if (isWinner(Cell.O)) {
                    winner = 2;
                } else {
                    printField(field);
                }
            }
        } while (true);
    }

    @SuppressWarnings("java:S106")
    private <T> void printField(T[] box) {
        if (!(box instanceof Byte[] || box instanceof Cell[])) {
            throw new IllegalArgumentException("Only Byte[] or Character[] are supported");
        }
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    @SuppressWarnings("java:S106")
    private void overGame() {
        switch (winner) {
            case 1 -> System.out.println("You won the game!");
            case 2 -> System.out.println("You lost the game!");
            case 3 -> System.out.println("It's a draw!");
            default -> System.out.println("Unexpected result!");
        }
        System.out.println("Created by Shreyas Saha. Thanks for playing!");
    }

    @SuppressWarnings("java:S106")
    private void getPlaceForX() {
        byte input;
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (field[input - 1] != Cell.EMPTY)
                    System.out.println("That one is already in use. Enter another.");
                else {
                    field[input - 1] = Cell.X;
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }

    private void getPlaceForO() {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * 9 + 1);
            if (field[rand - 1] == Cell.EMPTY) {
                field[rand - 1] = Cell.O;
                break;
            }
        }
    }

    private boolean isWinner(Cell cell) {
        return ((field[0] == cell && field[1] == cell && field[2] == cell)
                || (field[3] == cell && field[4] == cell && field[5] == cell)
                || (field[6] == cell && field[7] == cell && field[8] == cell)
                || (field[0] == cell && field[3] == cell && field[6] == cell)
                || (field[1] == cell && field[4] == cell && field[7] == cell)
                || (field[2] == cell && field[5] == cell && field[8] == cell)
                || (field[0] == cell && field[4] == cell && field[8] == cell)
                || (field[2] == cell && field[4] == cell && field[6] == cell));
    }

    private boolean isGameAvailable() {
        boolean isEmpty = false;
        int i = 0;
        while (!isEmpty && i < 10) {
            if (field[i] == Cell.EMPTY) {
                isEmpty = true;
            }
            i++;
        }
        return isEmpty;
    }
}
