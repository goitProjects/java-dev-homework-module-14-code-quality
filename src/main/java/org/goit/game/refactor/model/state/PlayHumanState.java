package org.goit.game.refactor.model.state;

import org.goit.game.refactor.controller.GameController;
import org.goit.game.refactor.view.GameView;

public class PlayHumanState implements GameState {

    private final GameController ctx;

    private Byte input;

    public PlayHumanState(GameController ctx) {
        this.ctx = ctx;
    }

    @Override
    public void info(GameView view) {
        view.showBoard(ctx.getModel().getBoard().getBox());
    }

    public boolean isHandleInput() {
        return true;
    }

    @Override
    public void handleInput(Byte input) {
        this.input = input;
    }

    @Override
    public void execute() {
        char[] box = ctx.getModel().getBoard().getBox();

        int inputInt = input;//use -1 as mark wrong or invalid input

        if (inputInt > 0 && inputInt < 10) {
            if (box[inputInt - 1] == 'X' || box[inputInt - 1] == 'O') {
                inputInt = -1;
                ctx.getView().message("That one is already in use. Enter another.");
            } else {
                box[inputInt - 1] = 'X';

            }
        } else {
            inputInt = -1;
            ctx.getView().message("Invalid input. Enter again.");
        }

        ctx.getModel().getBoard().setBox(box);
        if (inputInt == -1) {//use -1 as mark wrong or invalid input
            ctx.setState(new PlayHumanState(ctx));//try again
        } else {
            ctx.setState(new CheckStepState(ctx));//check win state
        }
    }
}
