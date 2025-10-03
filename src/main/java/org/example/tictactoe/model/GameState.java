package org.example.tictactoe.model;

/**
 * Enum representing the state of the game.
 */
public enum GameState {
    /** Game has just started */
    STARTED,
    /** Game is still ongoing */
    ONGOING,
    /** Game ended in a draw */
    DRAW,
    /** Game has been won by one of a players */
    WIN
}
