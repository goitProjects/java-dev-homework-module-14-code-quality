package org.example.tictactoe;

import lombok.Getter;
import lombok.Setter;
import org.example.tictactoe.states.CheckWinState;
import org.example.tictactoe.states.ComputerMoveState;
import org.example.tictactoe.states.GameState;
import org.example.tictactoe.states.InitialState;
import org.example.tictactoe.states.TerminateState;
import org.example.tictactoe.states.UserMoveState;

@Getter
@Setter
public class GameContext {
    private final GameBoard gameBoard;
    private final GameView view;
    private GameState currentState;

    public GameContext(GameBoard gameBoard, GameView view) {
        this.gameBoard = gameBoard;
        this.view = view;
        this.currentState = new InitialState(this);
    }

    public void humanTurn() {
        this.currentState = new UserMoveState(this);
    }

    public void computerTurn() {
        this.currentState = new ComputerMoveState(this);
    }

    public void checkWin(char player) {
        this.currentState = new CheckWinState(this, player);
    }

    public void toResult(String message) {
        this.currentState = new TerminateState(this, message);
    }

    public void handle() {
        currentState.handle();
    }
}
