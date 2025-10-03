package org.example.tictactoe.controller;

import static org.example.tictactoe.view.View.*;
import static org.example.tictactoe.view.View.YOU_LOST;
import static org.example.tictactoe.view.View.YOU_WON;
import static org.example.tictactoe.view.View.printMessage;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import org.example.tictactoe.model.Game;
import org.example.tictactoe.view.View;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class ControllerTest {

    private Controller controller;
    private Game gameMock;
    private InputHandler inputHandlerMock;
    private MockedStatic<View> viewMock;

    @BeforeEach
    void setUp() {
        gameMock = mock(Game.class);
        inputHandlerMock = mock(InputHandler.class);
        controller = new Controller(gameMock, inputHandlerMock);
        viewMock = Mockito.mockStatic(View.class);
    }

    @Test
    void testProcessUser_Draw() {
        // GIVEN
        given(gameMock.isFull()).willReturn(true);
        given(gameMock.isWinning()).willReturn(false);
        // WHEN
        controller.processUser();
        // THEN
        viewMock.verify(() -> printMessage(ENTER_BOX_NUMBER), atLeastOnce());
        viewMock.verify(() -> printMessage(DRAW_MESSAGE), atLeastOnce());
        verify(inputHandlerMock).closeResources();
    }

    @Test
    void testProcessUser_Win() {
        // GIVEN
        given(gameMock.isFull()).willReturn(false);
        given(gameMock.isWinning()).willReturn(true);
        // WHEN
        controller.processUser();
        // THEN
        viewMock.verify(() -> printMessage(YOU_WON), atLeastOnce());
        verify(inputHandlerMock).closeResources();
    }

    @Test
    void testProcessUser_Lose() {
        // GIVEN
        given(gameMock.isFull()).willReturn(false);
        given(gameMock.isWinning()).willReturn(false, true);
        // WHEN
        controller.processUser();
        // THEN
        viewMock.verify(() -> printMessage(YOU_LOST), atLeastOnce());
        verify(inputHandlerMock).closeResources();
    }

    @AfterEach
    void tearDown() {
        viewMock.close();
    }
}
