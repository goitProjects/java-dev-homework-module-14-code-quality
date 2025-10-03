package org.example.tictactoe.model;

import java.util.Arrays;

/**
 * Class representing the Tic-Tac-Toe game logic.
 * It manages the game board, checks for winning conditions,
 * and handles moves for both players.
 */
public class Game {
    private static final byte SIZE = 3;
    private final char[] box;

    /**
     * Constructor to initialize the game board with default SIZE 3x3.
     * The board is filled with characters '1' to '9' representing available positions.
     */
    public Game() {
        box = new char[SIZE * SIZE];
        initializeBox();
    }

    /**
     * Initializes the game board with characters '1' to '9'.
     */
    private void initializeBox() {
        for (byte i = 0; i < box.length; i++) {
            box[i] = (char) ('1' + i);
        }
    }

    /**
     * Returns the current state of the game board.
     *
     * @return char array representing the game board.
     */
    public char[] getBox() {
        return box;
    }

    /**
     * Clears the game board by filling it with spaces.
     */
    public void clearBoard() {
        Arrays.fill(box, ' ');
    }

    /**
     * Checks if the game board is full, meaning all positions are occupied by 'X' or 'O'.
     *
     * @return true if the board is full, false otherwise.
     */
    public boolean isFull() {
        for (char c : box) {
            if (c != 'X' && c != 'O') {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if there is a winning condition on the board.
     * A win is defined as having three of the same symbols ('X' or 'O') in a row,
     * column, or diagonal.
     *
     * @return true if there is a winning condition, false otherwise.
     */
    public boolean isWinning() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    /**
     * Checks the two diagonals of the board for a winning condition.
     * @return true if a diagonal has the same non-empty symbol, false otherwise.
     */
    private boolean checkDiagonals() {
        return (box[0] != ' ' && box[4] == box[0] && box[8] == box[0])
                || (box[2] != ' ' && box[4] == box[2] && box[6] == box[2]);
    }

    /**
     * Checks each column of the board for a winning condition.
     * @return true if any column has the same non-empty symbol, false otherwise.
     */
    private boolean checkColumns() {
        for (byte col = 0; col < SIZE; col++) {
            if (isBoxFieldUsed(col)
                    && box[col + SIZE] == box[col]
                    && box[col + 2 * SIZE] == box[col]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks each row of the board for a winning condition.
     * @return true if any row has the same non-empty symbol, false otherwise.
     */
    private boolean checkRows() {
        for (byte row = 0; row < SIZE; row++) {
            if (isBoxFieldUsed((byte) (row * SIZE))
                    && box[row * SIZE + 1] == box[row * SIZE]
                    && box[row * SIZE + 2] == box[row * SIZE]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a specific position on the board is already occupied by 'X' or 'O'.
     *
     * @param number the position to check (1-9).
     * @return true if the position is occupied, false otherwise.
     */
    public boolean isBoxFieldUsed(byte number) {
        return box[number] != ' ';
    }

    /**
     * Generates a random move for the computer player ('O').
     * The method selects a random position on the board that is not already occupied.
     * It continues to generate random positions until an available one is found.
     */
    public byte generateMove() {
        byte rand;
        do {
            rand = (byte) (Math.random() * box.length);
        } while (isBoxFieldUsed(rand));
        return rand;
    }

    /**
     * Sets the character ('X' or 'O') at the specified position on the board.
     *
     * @param ch  the character to place ('X' or 'O').
     * @param pos the position on the board (0-8).
     */
    public void setCharAtPosition(char ch, byte pos) {
        box[pos] = ch;
    }
}
