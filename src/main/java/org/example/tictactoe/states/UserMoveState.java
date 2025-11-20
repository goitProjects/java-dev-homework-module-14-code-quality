package org.example.tictactoe.states;

import static org.example.tictactoe.GameView.BOX_FIELD_IN_USE;

import org.example.tictactoe.GameContext;

public class UserMoveState extends GameState {
    private static final char X = 'X';

    public UserMoveState(GameContext context) {
        super(context);
    }

    @Override
    public void handle() {
        context.getGameBoard().updateBox(X, inputNumber());

        context.checkWin(X);
        context.handle();
    }

    /**
     * Handles user input for selecting a box number.
     * Ensures the selected box is not already in use.
     * Updates the game board with the user's move.
     */
    private byte inputNumber() {
        byte move = context.getView().inputCorrectNumber();
        while (context.getGameBoard().isBoxFieldUsed(move)) {
            context.getView().printMessage(BOX_FIELD_IN_USE);
            move = context.getView().inputCorrectNumber();
        }
        return move;
    }
}
