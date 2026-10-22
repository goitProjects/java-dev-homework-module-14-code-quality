package org.goit.game.refactor.model.state;

import org.goit.game.refactor.controller.GameController;
import org.goit.game.refactor.model.Player;
import org.goit.game.refactor.view.GameView;

public class CheckStepState implements GameState {

    private final GameController ctx;

    public CheckStepState(GameController ctx) {
        this.ctx = ctx;
    }

    @Override
    public void info(GameView view) {

    }

    @Override
    public void handleInput(Byte input) {
        //used only for human input
    }

    @Override
    public void execute() {
        char[] box = ctx.getModel().getBoard().getBox();

        Player player = ctx.getModel().getPlayers().get(ctx.getModel().getCurrentPlayerIndex());
        boolean boxAvailable = false;
        boolean winner = false;
        if ((box[0] == 'X' && box[1] == 'X' && box[2] == 'X')
                || (box[3] == 'X' && box[4] == 'X' && box[5] == 'X')
                || (box[6] == 'X' && box[7] == 'X' && box[8] == 'X')
                || (box[0] == 'X' && box[3] == 'X' && box[6] == 'X')
                || (box[1] == 'X' && box[4] == 'X' && box[7] == 'X')
                || (box[2] == 'X' && box[5] == 'X' && box[8] == 'X')
                || (box[0] == 'X' && box[4] == 'X' && box[8] == 'X')
                || (box[2] == 'X' && box[4] == 'X' && box[6] == 'X')) {
            winner = true;
            player.setWin(true);
        }

        for (int i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                boxAvailable = true;
                break;
            }
        }

        if ((box[0] == 'O' && box[1] == 'O' && box[2] == 'O')
                || (box[3] == 'O' && box[4] == 'O' && box[5] == 'O')
                || (box[6] == 'O' && box[7] == 'O' && box[8] == 'O')
                || (box[0] == 'O' && box[3] == 'O' && box[6] == 'O')
                || (box[1] == 'O' && box[4] == 'O' && box[7] == 'O')
                || (box[2] == 'O' && box[5] == 'O' && box[8] == 'O')
                || (box[0] == 'O' && box[4] == 'O' && box[8] == 'O')
                || (box[2] == 'O' && box[4] == 'O' && box[6] == 'O')) {
            winner = true;
            player.setWin(true);
        }
        if (!boxAvailable || winner) {
            ctx.setState(new EndState(ctx));//end game
        } else {
            if (player.isHuman()) {//next turn to robot
                ctx.setState(new PlayRobotState(ctx));
            } else {
                ctx.setState(new PlayHumanState(ctx));
            }

            ctx.getModel().changeCurrentPlayer();
        }

    }
}
