package org.goit.game.refactor.model.state;

import org.goit.game.refactor.controller.GameController;
import org.goit.game.refactor.model.Player;
import org.goit.game.refactor.view.GameView;

public class EndState implements GameState {

    private final GameController ctx;

    public EndState(GameController ctx) {
        this.ctx = ctx;
    }

    @Override
    public void info(GameView view) {
        view.showBoard(ctx.getModel().getBoard().getBox());
        Player player = ctx.getModel().getPlayers()
                .stream().filter(Player::isWin)
                .findAny().orElse(null);
        if (player != null) {
            if (player.isHuman()) {
                view.message("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            } else {
                view.message("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            }
        } else {
            view.message("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }

    @Override
    public void handleInput(Byte input) {
        //used only for human input
    }

    @Override
    public void execute() {
        ctx.setRunning(false);
    }
}
