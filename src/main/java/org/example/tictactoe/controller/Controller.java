package org.example.tictactoe.controller;

import static org.example.tictactoe.model.GameState.DRAW;
import static org.example.tictactoe.model.GameState.ONGOING;
import static org.example.tictactoe.model.GameState.STARTED;
import static org.example.tictactoe.model.GameState.WIN;
import static org.example.tictactoe.view.View.BOX_FIELD_IN_USE;
import static org.example.tictactoe.view.View.DRAW_MESSAGE;
import static org.example.tictactoe.view.View.ENTER_BOX_NUMBER;
import static org.example.tictactoe.view.View.O;
import static org.example.tictactoe.view.View.X;
import static org.example.tictactoe.view.View.YOU_LOST;
import static org.example.tictactoe.view.View.YOU_WON;
import static org.example.tictactoe.view.View.printBoard;
import static org.example.tictactoe.view.View.printMessage;

import org.example.tictactoe.model.Game;
import org.example.tictactoe.model.GameState;

/**
 * Controller class to manage the game flow and user interactions.
 */
public class Controller {
    private final Game game;
    private final InputHandler inputHandler;
    private GameState state;
    private boolean isHumanMove;

    public Controller(Game game, InputHandler inputHandler) {
        this.game = game;
        this.inputHandler = inputHandler;
        this.state = STARTED;
        this.isHumanMove = false;
    }

    /**
     * Starts and manages the game process.
     * Handles user input, game state updates, and displays messages.
     * The game continues until it ends in a win or a draw.
     * The user plays against the computer, taking turns to make moves.
     * At the end of the game, a message is displayed indicating the result.
     * Closes input resources after the game ends.
     */
    public void processUser() {
        printMessage(ENTER_BOX_NUMBER);
        do {
            if (!isHumanMove) {
                printBoard(game.getBox());
            }
            if (state == STARTED) {
                game.clearBoard();
            }
            isHumanMove = !isHumanMove;

            makeMove();
            state = updateGameState();
        } while (state.equals(ONGOING));

        printBoard(game.getBox());
        printResult();
        inputHandler.closeResources();
    }

    /**
     * Makes a move for the current player.
     * If it's the human's turn, it prompts for input.
     * If it's the computer's turn, it generates a move automatically.
     */
    private void makeMove() {
        if (isHumanMove) {
            game.setCharAtPosition(X, inputNumber());
        } else {
            game.setCharAtPosition(O, (game.generateMove()));
        }
    }

    /**
     * Prints the result of the game based on the final state.
     * Displays a message indicating whether the user won, lost, or if it was a draw.
     */
    private void printResult() {
        if (state.equals(DRAW)) {
            printMessage(DRAW_MESSAGE);
        } else if (isHumanMove) {
            printMessage(YOU_WON);
        } else {
            printMessage(YOU_LOST);
        }
    }

    /**
     * Updates the current game state by checking for win or draw conditions.
     * @return the current GameState (WIN, DRAW, or ONGOING).
     */
    private GameState updateGameState() {
        if (game.isWinning()) {
            return WIN;
        }
        if (game.isFull()) {
            return DRAW;
        }
        return ONGOING;
    }

    /**
     * Handles user input for selecting a box number.
     * Ensures the selected box is not already in use.
     * Updates the game board with the user's move.
     */
    private byte inputNumber() {
        byte move = inputHandler.inputCorrectNumber();
        while (game.isBoxFieldUsed(move)) {
            printMessage(BOX_FIELD_IN_USE);
            move = inputHandler.inputCorrectNumber();
        }
        return move;
    }
}
