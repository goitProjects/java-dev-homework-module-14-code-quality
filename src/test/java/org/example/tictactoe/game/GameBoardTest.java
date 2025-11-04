package org.example.tictactoe.game;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.tictactoe.GameBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameBoardTest {
    private GameBoard gameBoard;

    @BeforeEach
    void init() {
        gameBoard = new GameBoard();
    }

    @Test
    void testClearBoardCorrect() {
        // GIVEN
        char[] expectedBox = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        // WHEN
        gameBoard.clearBoard();
        // THEN
        assertArrayEquals(expectedBox, gameBoard.getBox());
    }

    @Test
    void testInitializeBox() {
        // GIVEN
        char[] expectedBox = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        // WHEN
        char[] actualBox = gameBoard.getBox();
        // THEN
        assertArrayEquals(expectedBox, actualBox);
    }

    @Test
    void testBoxIsFullTrue() {
        // GIVEN
        for (byte i = 0; i < gameBoard.getBox().length; i++) {
            gameBoard.updateBox(i % 2 == 0 ? 'X' : 'O', i);
        }
        // WHEN

        boolean actualIsFull = gameBoard.isFull();
        // THEN
        assertTrue(actualIsFull);
    }

    @Test
    void testBoxIsFullFalse() {
        // GIVEN
        gameBoard.clearBoard();
        // WHEN
        boolean actualIsFull = gameBoard.isFull();
        // THEN
        assertFalse(actualIsFull);
    }

    @Test
    void testIsWinningRowTrue() {
        // GIVEN
        gameBoard.updateBox('X', (byte) 0);
        gameBoard.updateBox('X', (byte) 1);
        gameBoard.updateBox('X', (byte) 2);
        // WHEN
        boolean actualIsWinning = gameBoard.isWinning();
        // THEN
        assertTrue(actualIsWinning);
    }

    @Test
    void testIsWinningColumnTrue() {
        // GIVEN
        gameBoard.updateBox('O', (byte) 0);
        gameBoard.updateBox('O', (byte) 3);
        gameBoard.updateBox('O', (byte) 6);
        // WHEN
        boolean actualIsWinning = gameBoard.isWinning();
        // THEN
        assertTrue(actualIsWinning);
    }

    @Test
    void testIsWinningDiagonalTrue() {
        // GIVEN
        gameBoard.updateBox('X', (byte) 2);
        gameBoard.updateBox('X', (byte) 4);
        gameBoard.updateBox('X', (byte) 6);
        // WHEN
        boolean actualIsWinning = gameBoard.isWinning();
        // THEN
        assertTrue(actualIsWinning);
    }

    @Test
    void testIsWinningFalse() {
        // GIVEN
        gameBoard.updateBox('X', (byte) 0);
        gameBoard.updateBox('O', (byte) 1);
        gameBoard.updateBox('X', (byte) 2);
        // WHEN
        boolean actualIsWinning = gameBoard.isWinning();
        // THEN
        assertFalse(actualIsWinning);
    }

    @Test
    void isBoxInUseTrue() {
        // GIVEN
        gameBoard.updateBox('X', (byte) 4);
        // WHEN
        boolean actualIsBoxInUse = gameBoard.isBoxFieldUsed((byte) 4);
        // THEN
        assertTrue(actualIsBoxInUse);
    }

    @Test
    void isBoxInUseFalse() {
        // GIVEN
        gameBoard.clearBoard();
        // WHEN
        boolean actualIsBoxInUse = gameBoard.isBoxFieldUsed((byte) 4);
        // THEN
        assertFalse(actualIsBoxInUse);
    }

    @Test
    void testUpdateBox() {
        // GIVEN
        gameBoard.clearBoard();
        // WHEN
        gameBoard.updateBox('X', (byte) 5);
        // THEN
        assertEquals('X', gameBoard.getBox()[5]);
    }

}
