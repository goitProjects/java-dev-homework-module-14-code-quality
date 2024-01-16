package org.example;

import java.util.Arrays;

public class Board {
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private final char[] box;

    public Board() {
        box = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public void clear() {
        Arrays.fill(box, ' ');
    }

    public void display() {
        for (int i = 0; i < box.length; i += 3) {
            System.out.printf(" %s | %s | %s ", box[i], box[i + 1], box[i + 2]);
            if (i <= 3) {
                System.out.println("\n-----------");
            }
        }
        System.out.println("\n");
    }

    public boolean isCellOccupied(int index) {
        return box[index] != PLAYER_X && box[index] != PLAYER_O;
    }

    public void markCell(int index, char player) {
        box[index] = player;
    }

    public boolean isFull() {
        for (char value : box) {
            if (value != PLAYER_X && value != PLAYER_O) {
                return false;
            }
        }
        return true;
    }

    public boolean hasWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if ((box[i * 3] == player && box[i * 3 + 1] == player && box[i * 3 + 2] == player) ||
                    (box[i] == player && box[i + 3] == player && box[i + 6] == player)) {
                return true;
            }
        }

        return (box[0] == player && box[4] == player && box[8] == player) ||
                (box[2] == player && box[4] == player && box[6] == player);
    }
}