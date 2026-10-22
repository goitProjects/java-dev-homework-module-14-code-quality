package org.goit.game.refactor.model;

import java.util.Arrays;
import java.util.List;

public class GameModel {

    private Board board;
    private Integer currentPlayerIndex;
    private List<Player> players;

    public GameModel() {
        board = new Board();
        players = Arrays.asList(new Player(true), new Player(false));
        currentPlayerIndex = 0;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Integer getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    //round robin
    public void changeCurrentPlayer() {
        currentPlayerIndex++;
        if (currentPlayerIndex >= players.size()) {
            currentPlayerIndex = 0;
        }
    }
}
