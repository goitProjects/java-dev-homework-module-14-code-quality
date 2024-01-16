package org.example;

import java.util.Scanner;

import static org.example.Messages.*;

public class Game {
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private boolean boxEmpty = false;
    private final Board board = new Board();

    public void startGame() {
        Scanner scan = new Scanner(System.in);
        byte winner = 0;

        printMessage(ENTER_NUMBER);

        while (true) {
            board.display();

            if (!boxEmpty) {
                board.clear();
                boxEmpty = true;
            }

            if (isGameOver(winner)) {
                displayResult(winner);
                break;
            }

            winner = playGame(scan);
        }
        scan.close();
    }

    private void displayResult(byte winner) {
        switch (winner) {
            case 1 -> printMessage(WIN);
            case 2 -> printMessage(LOSS);
            default -> printMessage(DRAW);
        }
    }

    private byte playGame(Scanner scan) {
        byte winner;
        playerMove(scan);
        winner = checkWinner(PLAYER_X);

        if (winner == 0) {
            if (!board.isFull()) {
                computerMove();
                winner = checkWinner(PLAYER_O);
            } else {
                winner = 3;
            }
        }
        return winner;
    }

    private void playerMove(Scanner scan) {
        byte input;
        while (true) {
            printMessage(ENTER_MOVE);
            input = scan.nextByte();
            if (input > 0 && input < 10 && board.isCellOccupied(input - 1)) {
                board.markCell(input - 1, PLAYER_X);
                break;
            } else {
                printMessage(INVALID_INPUT);
            }
        }
    }

    private void computerMove() {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * 9);
            if (board.isCellOccupied(rand)) {
                board.markCell(rand, PLAYER_O);
                break;
            }
        }
    }

    private byte checkWinner(char player) {
        if (board.hasWinner(player)) {
            if (player == PLAYER_X) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }

    private boolean isGameOver(byte winner) {
        return winner == 1 || winner == 2 || winner == 3;
    }

    private void printMessage(Messages message) {
        System.out.println(message.getMessage());
    }
}
