package org.goit.game.refactor.model;

public class Board {

    private char [] box;

    public Board() {
        this(new char[]{ '1', '2', '3', '4', '5', '6', '7', '8', '9' });
    }

    public Board(char [] box) {
        this.box = box;
    }

    public void emptyBoard() {
        this.box = new char[]{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
    }

    public char[] getBox() {
        return box;
    }

    public void setBox(char[] box) {
        this.box = box;
    }
}
