package org.example.tictactoe.states;

import org.example.tictactoe.GameContext;

public abstract class GameState {
    protected GameContext context;

    protected GameState(GameContext context) {
        this.context = context;
    }

    public abstract void handle();
}
