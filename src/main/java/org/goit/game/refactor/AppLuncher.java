package org.goit.game.refactor;

import org.goit.game.refactor.controller.GameController;
import org.goit.game.refactor.model.GameModel;
import org.goit.game.refactor.model.state.StartState;
import org.goit.game.refactor.view.GameView;

public class AppLuncher {

    public static void main(String[] args) {
        //Game Luncher
        GameModel model = new GameModel();
        GameView view = new GameView(model);
        GameController controller = new GameController(model, view);
        controller.setState(new StartState(controller));
        controller.start();
    }
}
