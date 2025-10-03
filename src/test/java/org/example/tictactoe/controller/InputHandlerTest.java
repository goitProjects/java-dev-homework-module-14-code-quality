package org.example.tictactoe.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

class InputHandlerTest {
    private InputHandler inputHandler;

    @Test
    void testReadBoxNumber_ValidInput() {
        // GIVEN
        ByteArrayInputStream testIn = new ByteArrayInputStream("5\n".getBytes());
        System.setIn(testIn);
        inputHandler = new InputHandler();
        byte expected = 4;
        // WHEN
        byte actual = inputHandler.inputCorrectNumber();
        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void testReadBoxNumber_InvalidInput() {
        // GIVEN
        System.setIn(new ByteArrayInputStream("abc\n7\n".getBytes()));
        inputHandler = new InputHandler();
        byte expected = 6;
        // WHEN
        int actual = inputHandler.inputCorrectNumber();
        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void testCloseResources() {
        // GIVEN
        inputHandler = new InputHandler();
        // WHEN & THEN
        assertDoesNotThrow(() -> inputHandler.closeResources());
    }
}
