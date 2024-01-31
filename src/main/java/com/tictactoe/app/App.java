package com.tictactoe.app;

import com.tictactoe.board.SimpleBoard;
import com.tictactoe.players.Player;
import com.tictactoe.messages.MessageService;
import com.tictactoe.players.ComputerPlayer;
import com.tictactoe.players.HumanPlayer;
import com.tictactoe.logic.TicTacToeGame;
public class App {
    public static void main(String[] args) {
        SimpleBoard board = new SimpleBoard();
        MessageService messageService = new MessageService();
        Player player1 = new HumanPlayer();
        Player player2 = new ComputerPlayer();

        TicTacToeGame game = new TicTacToeGame(board, player1, player2, messageService);
        game.start();
    }
}
