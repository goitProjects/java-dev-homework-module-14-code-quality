package org.example.tictactoe.states;

import org.example.tictactoe.GameContext;

public class InitialState extends GameState {
    public static final String ENTER_BOX_NUMBER = "Enter box number to select. Enjoy!\n";

    public InitialState(GameContext context) {
        super(context);
    }

    @Override
    public void handle() {
        context.getView().printBoard(context.getGameBoard().getBox());
        context.getView().printMessage(ENTER_BOX_NUMBER);
        context.getGameBoard().clearBoard();

        context.humanTurn();
        context.handle();
    }
}
