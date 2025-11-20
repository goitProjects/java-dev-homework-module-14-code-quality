package org.example.tictactoe.states;

import org.example.tictactoe.GameContext;

public class CheckWinState extends GameState {
    public static final String YOU_LOST =
            "You lost the game!\nCreated by Shreyas Saha. Thanks for playing!";
    public static final String DRAW_MESSAGE =
            "It's a draw!\nCreated by Shreyas Saha. Thanks for playing!";
    public static final String YOU_WON =
            "You won the game!\nCreated by Shreyas Saha. Thanks for playing!";
    private static final char X = 'X';
    private final char player;

    public CheckWinState(GameContext context, char player) {
        super(context);
        this.player = player;
    }

    @Override
    public void handle() {
        if (context.getGameBoard().isWinning()) {
            if (player == X) {
                context.toResult(YOU_WON);
            } else {
                context.toResult(YOU_LOST);
            }
        } else if (context.getGameBoard().isFull()) {
            context.toResult(DRAW_MESSAGE);
        } else {
            context.getView().printBoard(context.getGameBoard().getBox());
            if (player == X) {
                context.computerTurn();
            } else {
                context.humanTurn();
            }
        }

        context.handle();
    }
}
