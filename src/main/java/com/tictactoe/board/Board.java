package com.tictactoe.board;

public interface Board {
    void display();
    void reset();
    boolean isFull();
    boolean markCell(int cellNumber, char symbol);
    boolean isWinner(char symbol);
}