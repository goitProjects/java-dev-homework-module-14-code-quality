package com.tictactoe.players;
import com.tictactoe.board.Board;
import java.util.Scanner;
public class HumanPlayer implements Player{
    private Scanner scanner;

    public HumanPlayer() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void makeMove(Board board) {
        // Human player's move logic
        // Display prompt to enter cell number
        System.out.println("Enter the cell number where you want to make a move (1-9):");
        int cellNumber = scanner.nextInt();

        // Check if the cellNumber is valid
        if (cellNumber < 1 || cellNumber > 9) {
            System.out.println("Invalid cell number. Please enter a number between 1 and 9.");
            return;
        }

        // Attempt to mark the cell with the player's symbol ('X')
        boolean moveMade = board.markCell(cellNumber, 'X');
        if (!moveMade) {
            System.out.println("That cell is already occupied. Please choose another cell.");
            return;
        }

        // Display the updated board
        board.display();
    }
}
