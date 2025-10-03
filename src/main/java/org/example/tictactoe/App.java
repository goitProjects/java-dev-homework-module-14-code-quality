package org.example.tictactoe;

import org.example.tictactoe.controller.Controller;
import org.example.tictactoe.controller.InputHandler;
import org.example.tictactoe.model.Game;

/**
 * Main application class to start the Tic-Tac-Toe game.
 */
public class App {
    public static void main(String[] args) {
        Controller controller = new Controller(
                new Game(),
                new InputHandler()
        );
        controller.processUser();
    }
}
