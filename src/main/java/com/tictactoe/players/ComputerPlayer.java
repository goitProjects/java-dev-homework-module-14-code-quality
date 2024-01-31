package com.tictactoe.players;

import com.tictactoe.board.Board;
import com.tictactoe.board.SimpleBoard;

import java.util.Random;
public class ComputerPlayer implements Player {

    private Random randomMove = new Random();

    public void makeMove(Board board) {
        if (board instanceof SimpleBoard simpleBoard) {

            if (simpleBoard.isFull()) {
                System.out.println("The board is full. No more moves can be made.");
                return;
            }

            int randomCell;
            do {
                randomCell = this.randomMove.nextInt(9) + 1;
            } while (!simpleBoard.markCell(randomCell, 'O'));

            simpleBoard.display();
        }
    }
}
