import java.util.Scanner;

public class TicTacToeGame {

    private static final int BOARD_SIZE = 9;
    private static final char EMPTY_CELL = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private char[] board = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.play();
    }

    public void play() {
        boolean gameOver = false;
        boolean boxEmpty = false;

        while (!gameOver) {
            displayBoard();

            if (!boxEmpty) {
                resetBoard();
                boxEmpty = true;
            }

            if (checkWinner(PLAYER_X)) {
                gameOver = true;
                displayResult("You won the game!");
            } else if (checkWinner(PLAYER_O)) {
                gameOver = true;
                displayResult("You lost the game!");
            } else if (isBoardFull()) {
                gameOver = true;
                displayResult("It's a draw!");
            }

            if (!gameOver) {
                playerMove(PLAYER_X);
                if (!gameOver) {
                    computerMove(PLAYER_O);
                }
            }
        }
    }

    private void displayBoard() {
        System.out.println("\n\n " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
    }

    private void resetBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = EMPTY_CELL;
        }
    }

    private void displayResult(String message) {
        System.out.println(message + "\nCreated by Shreyas Saha. Thanks for playing!");
    }

    private boolean checkWinner(char player) {
        for (int i = 0; i < BOARD_SIZE; i += 3) {
            if (board[i] == player && board[i + 1] == player && board[i + 2] == player) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i] == player && board[i + 3] == player && board[i + 6] == player) {
                return true;
            }
        }

        if (board[0] == player && board[4] == player && board[8] == player) {
            return true;
        }

        return board[2] == player && board[4] == player && board[6] == player;
    }

    private boolean isBoardFull() {
        for (char cell : board) {
            if (cell != PLAYER_X && cell != PLAYER_O) {
                return false;
            }
        }
        return true;
    }

    private void playerMove(char player) {
        int input;
        while (true) {
            System.out.println("Enter box number to select.");
            input = scanner.nextInt();
            if (isValidMove(input)) {
                board[input - 1] = player;
                break;
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }

    private boolean isValidMove(int move) {
        return move > 0 && move <= BOARD_SIZE && board[move - 1] == EMPTY_CELL;
    }

    private void computerMove(char player) {
        int randomMove;
        while (true) {
            randomMove = (int) (Math.random() * BOARD_SIZE) + 1;
            if (isValidMove(randomMove)) {
                board[randomMove - 1] = player;
                break;
            }
        }
    }
}