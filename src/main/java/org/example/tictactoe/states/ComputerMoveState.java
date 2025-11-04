package org.example.tictactoe.states;

import org.example.tictactoe.GameContext;

public class ComputerMoveState extends GameState {
    private static final char O = 'O';

    public ComputerMoveState(GameContext context) {
        super(context);
    }

    @Override
    public void handle() {
        byte move = generateMove();
        context.getGameBoard().updateBox(O, move);
        context.checkWin(O);
        context.handle();
    }

    private byte generateMove() {
        byte rand;
        do {
            rand = (byte) (Math.random() * context.getGameBoard().getLength());
        } while (context.getGameBoard().isBoxFieldUsed(rand));
        return rand;
    }
}
