package org.example.tictactoe;

/**
 * Main application class to start the Tic-Tac-Toe game.
 */
public class App {
    public static void main(String[] args) {
        GameBoard model = new GameBoard();
        GameView view = new GameView();
        GameContext context = new GameContext(model, view);

        context.handle();
    }
}
