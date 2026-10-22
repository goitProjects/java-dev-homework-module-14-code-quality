package org.goit.game.refactor.model.state;

import org.goit.game.refactor.view.GameView;

public interface GameState {

    void info(GameView view);

    default boolean isHandleInput() {
        return false;
    }

    void handleInput(Byte input);

    void execute();
}
