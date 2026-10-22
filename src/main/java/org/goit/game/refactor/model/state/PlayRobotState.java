package org.goit.game.refactor.model.state;

import org.goit.game.refactor.controller.GameController;
import org.goit.game.refactor.view.GameView;

public class PlayRobotState implements GameState {

    private final GameController ctx;

    public PlayRobotState(GameController ctx) {
        this.ctx = ctx;
    }

    @Override
    public void info(GameView view) {
        view.showBoard(ctx.getModel().getBoard().getBox());
    }

    @Override
    public void handleInput(Byte input) {
        //used only for human input
    }

    @Override
    public void execute() {
        char[] box = ctx.getModel().getBoard().getBox();
        while (true) {
            byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
        ctx.getModel().getBoard().setBox(box);
        ctx.setState(new CheckStepState(ctx));
    }

}
