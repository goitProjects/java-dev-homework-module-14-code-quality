import java.util.Scanner;

public class TicTacToe {

    private static Scanner scanner = new Scanner(System.in);
    private static char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static boolean isFirstPlayerTurn = true;

    public static void main(String[] args) {
        displayInstructions();

        while (true) {
            displayBoard();

            char currentPlayerSymbol = isFirstPlayerTurn ? 'X' : 'O';
            if (isFirstPlayerTurn) {
                makeMove(currentPlayerSymbol);
            } else {
                makeComputerMove();
            }

            if (checkWinner(currentPlayerSymbol)) {
                displayBoard();
                announceWinner(currentPlayerSymbol);
                break;
            } else if (isBoardFull()) {
                displayBoard();
                announceDraw();
                break;
            }

            isFirstPlayerTurn = !isFirstPlayerTurn;
        }

        scanner.close();
    }

    private static void displayInstructions() {
        System.out.println("Welcome to Tic-Tac-Toe! Enter a number to make your move.\n");
    }

    private static void displayBoard() {
        System.out.println("\n " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
    }

    private static void makeMove(char playerSymbol) {
        while (true) {
            System.out.print("Player X, enter your move (1-9): ");
            int move = scanner.nextInt();

            if (isValidMove(move)) {
                board[move - 1] = playerSymbol;
                break;
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
    }

    private static void makeComputerMove() {
        while (true) {
            int move = (int) (Math.random() * 9) + 1;
            if (isValidMove(move)) {
                board[move - 1] = 'O';
                break;
            }
        }
    }

    private static boolean isValidMove(int move) {
        return move >= 1 && move <= 9 && board[move - 1] != 'X' && board[move - 1] != 'O';
    }

    private static boolean checkWinner(char playerSymbol) {
        return checkRows(playerSymbol) || checkColumns(playerSymbol) || checkDiagonals(playerSymbol);
    }

    private static boolean checkRows(char playerSymbol) {
        for (int i = 0; i < 9; i += 3) {
            if (board[i] == playerSymbol && board[i + 1] == playerSymbol && board[i + 2] == playerSymbol) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns(char playerSymbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i] == playerSymbol && board[i + 3] == playerSymbol && board[i + 6] == playerSymbol) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals(char playerSymbol) {
        return (board[0] == playerSymbol && board[4] == playerSymbol && board[8] == playerSymbol) ||
                (board[2] == playerSymbol && board[4] == playerSymbol && board[6] == playerSymbol);
    }

    private static boolean isBoardFull() {
        for (char cell : board) {
            if (cell != 'X' && cell != 'O') {
                return false;
            }
        }
        return true;
    }

    private static void announceWinner(char playerSymbol) {
        System.out.println("Player " + (playerSymbol == 'X' ? "X" : "O") + " wins! Thanks for playing!");
    }

    private static void announceDraw() {
        System.out.println("It's a draw! Thanks for playing!");
    }
}