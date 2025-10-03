package org.example.tictactoe.model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
    private Game game;

    @BeforeEach
    void init() {
        game = new Game();
    }

    @Test
    void testClearBoardCorrect() {
        // GIVEN
        char[] expectedBox = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        // WHEN
        game.clearBoard();
        // THEN
        assertArrayEquals(expectedBox, game.getBox());
    }

    @Test
    void testInitializeBox() {
        // GIVEN
        char[] expectedBox = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        // WHEN
        char[] actualBox = game.getBox();
        // THEN
        assertArrayEquals(expectedBox, actualBox);
    }

    @Test
    void testBoxIsFullTrue() {
        // GIVEN
        for (byte i = 0; i < game.getBox().length; i++) {
            game.setCharAtPosition(i % 2 == 0 ? 'X' : 'O', i);
        }
        // WHEN

        boolean actualIsFull = game.isFull();
        // THEN
        assertTrue(actualIsFull);
    }

    @Test
    void testBoxIsFullFalse() {
        // GIVEN
        game.clearBoard();
        // WHEN
        boolean actualIsFull = game.isFull();
        // THEN
        assertFalse(actualIsFull);
    }

    @Test
    void testIsWinningRowTrue() {
        // GIVEN
        game.setCharAtPosition('X', (byte) 0);
        game.setCharAtPosition('X', (byte) 1);
        game.setCharAtPosition('X', (byte) 2);
        // WHEN
        boolean actualIsWinning = game.isWinning();
        // THEN
        assertTrue(actualIsWinning);
    }

    @Test
    void testIsWinningColumnTrue() {
        // GIVEN
        game.setCharAtPosition('O', (byte) 0);
        game.setCharAtPosition('O', (byte) 3);
        game.setCharAtPosition('O', (byte) 6);
        // WHEN
        boolean actualIsWinning = game.isWinning();
        // THEN
        assertTrue(actualIsWinning);
    }

    @Test
    void testIsWinningDiagonalTrue() {
        // GIVEN
        game.setCharAtPosition('X', (byte) 2);
        game.setCharAtPosition('X', (byte) 4);
        game.setCharAtPosition('X', (byte) 6);
        // WHEN
        boolean actualIsWinning = game.isWinning();
        // THEN
        assertTrue(actualIsWinning);
    }

    @Test
    void testIsWinningFalse() {
        // GIVEN
        game.setCharAtPosition('X', (byte) 0);
        game.setCharAtPosition('O', (byte) 1);
        game.setCharAtPosition('X', (byte) 2);
        // WHEN
        boolean actualIsWinning = game.isWinning();
        // THEN
        assertFalse(actualIsWinning);
    }

    @Test
    void isBoxInUseTrue() {
        // GIVEN
        game.setCharAtPosition('X', (byte) 4);
        // WHEN
        boolean actualIsBoxInUse = game.isBoxFieldUsed((byte) 4);
        // THEN
        assertTrue(actualIsBoxInUse);
    }

    @Test
    void isBoxInUseFalse() {
        // GIVEN
        game.clearBoard();
        // WHEN
        boolean actualIsBoxInUse = game.isBoxFieldUsed((byte) 4);
        // THEN
        assertFalse(actualIsBoxInUse);
    }

    @Test
    void testGenerateMove() {
        // GIVEN
        game.clearBoard();
        // WHEN
        byte move = game.generateMove();
        // THEN
        assertTrue(move >= 0 && move < 9);
    }

    @Test
    void testSetCharAtPosition() {
        // GIVEN
        game.clearBoard();
        // WHEN
        game.setCharAtPosition('X', (byte) 5);
        // THEN
        assertEquals('X', game.getBox()[5]);
    }

}
