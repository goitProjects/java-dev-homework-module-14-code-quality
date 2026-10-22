package org.goit.game.refactor.model.state;

import org.goit.game.refactor.controller.GameController;
import org.goit.game.refactor.view.GameView;

public class StartState implements GameState {

    private final GameController ctx;

    public StartState(GameController ctx) {
        this.ctx = ctx;
    }

    @Override
    public void info(GameView view) {
        view.message("Enter box number to select. Enjoy!\n");
        view.showBoard(ctx.getModel().getBoard().getBox());
    }

    @Override
    public void handleInput(Byte input) {
        //used only for human input
    }

    @Override
    public void execute() {
        ctx.getModel().getBoard().emptyBoard();
        ctx.setState(new PlayHumanState(ctx));
    }
}
