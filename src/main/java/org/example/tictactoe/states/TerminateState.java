package org.example.tictactoe.states;

import org.example.tictactoe.GameContext;

public class TerminateState extends GameState {
    private final String result;

    public TerminateState(GameContext context, String result) {
        super(context);
        this.result = result;
    }

    @Override
    public void handle() {
        context.getView().printBoard(context.getGameBoard().getBox());
        context.getView().printMessage(result);
        context.getView().closeResources();
    }
}
