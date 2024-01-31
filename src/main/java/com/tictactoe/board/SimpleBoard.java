package com.tictactoe.board;

public class SimpleBoard implements Board{

    private char[] cells;

    public SimpleBoard() {
        this.cells = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    }

    @Override
    public void display() {
        System.out.println("\n\n " + cells[0] + " | " + cells[1] + " | " + cells[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + cells[3] + " | " + cells[4] + " | " + cells[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + cells[6] + " | " + cells[7] + " | " + cells[8] + " \n");
    }

    @Override
    public void reset() {
        // Reset the board
        for (int i = 0; i < cells.length; i++) {
            cells[i] = (char) ('1' + i);
        }
    }
    @Override
    public boolean isFull() {
        // Check if the board is full
        for (char cell : cells) {
            if (cell >= '1' && cell <= '9') {
                return false; // Found an empty cell
            }
        }
        return true;
    }

    @Override
    public boolean markCell(int cellNumber, char symbol) {
        // Mark the specified cell with the symbol
        // Check if the cellNumber is valid
        if (cellNumber < 1 || cellNumber > 9) {
            return false; // Invalid cell number
        }

        // Convert cellNumber to array index
        int index = cellNumber - 1;

        // Check if the cell is already marked
        if (cells[index] == 'X' || cells[index] == 'O') {
            return false; // Cell already marked
        }

        // Mark the cell with the symbol
        cells[index] = symbol;
        return true;
    }
    @Override
    public boolean isWinner(char symbol) {
        // Check if the specified symbol has won
        // Check rows, columns, and diagonals for winning combinations
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (cells[i * 3] == symbol && cells[i * 3 + 1] == symbol && cells[i * 3 + 2] == symbol) {
                return true;
            }
            // Check columns
            if (cells[i] == symbol && cells[i + 3] == symbol && cells[i + 6] == symbol) {
                return true;
            }
        }
        // Check diagonals
        if (cells[0] == symbol && cells[4] == symbol && cells[8] == symbol) {
            return true;
        }
        return cells[2] == symbol && cells[4] == symbol && cells[6] == symbol;
    }
}