package org.goit.game.refactor.view;

import org.goit.game.refactor.model.GameModel;

public class GameView {

    private GameModel model;

    public GameView(GameModel model) {
        this.model = model;
    }

    public void showBoard(char[] board) {
        System.out.println("\n\n " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
    }

    public void message(String s) {
        System.out.println(s);
    }
}
