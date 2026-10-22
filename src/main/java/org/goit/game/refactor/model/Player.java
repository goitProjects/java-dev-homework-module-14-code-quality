package org.goit.game.refactor.model;

public class Player {

    private boolean win = false;
    private boolean human; // used for player to get input value

    public Player(boolean human) {
        this.human = human;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isHuman() {
        return human;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }
}
