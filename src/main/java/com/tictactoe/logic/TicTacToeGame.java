package com.tictactoe.logic;
import com.tictactoe.board.Board;
import com.tictactoe.messages.MessageService;
import com.tictactoe.players.Player;
import java.util.Scanner;

public class TicTacToeGame {

    private Board board;
    private Player player1;
    private Player player2;
    private MessageService messageService;
    private Scanner scanner;

    public TicTacToeGame(Board board, Player player1, Player player2, MessageService messageService) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.messageService = messageService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        Player currentPlayer = player1;
        boolean gameOver = false;

        while (!gameOver) {
            // Prompt the current player to make a move
            messageService.displayMessage(currentPlayer.getClass().getSimpleName() + "'s turn:");
            currentPlayer.makeMove(board);

            // Display the current state of the board
            board.display();

            // Check if the current player has won
            if (board.isWinner('X')) {
                messageService.displayMessage("Player 1 wins!");
                gameOver = true;
                break;
            } else if (board.isWinner('O')) {
                messageService.displayMessage("Player 2 wins!");
                gameOver = true;
                break;
            }

            // Check if the board is full (draw)
            if (board.isFull()) {
                messageService.displayMessage("It's a draw!");
                gameOver = true;
                break;
            }

            // Switch players for the next turn
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}
