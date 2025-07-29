import java.util.Scanner;

public class App {

    private static final char PLAYER_SYMBOL = 'X';
    private static final char COMPUTER_SYMBOL = 'O';
    private static final int BOARD_SIZE = 9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] board = initializeBoard();
        int winner = 0;

        System.out.println("Welcome to Tic-Tac-Toe!\nEnter a number (1-9) to place your symbol.\n");

        while (true) {
            printBoard(board);

            if (winner != 0) {
                printResult(winner);
                break;
            }

            int playerMove = getPlayerMove(scanner, board);
            board[playerMove] = PLAYER_SYMBOL;

            if (checkWinner(board, PLAYER_SYMBOL)) {
                winner = 1;
                continue;
            }

            if (isDraw(board)) {
                winner = 3;
                continue;
            }

            int computerMove = getComputerMove(board);
            board[computerMove] = COMPUTER_SYMBOL;

            if (checkWinner(board, COMPUTER_SYMBOL)) {
                winner = 2;
            }

            if (isDraw(board)) {
                winner = 3;
            }
        }

        scanner.close();
    }

    private static char[] initializeBoard() {
        char[] board = new char[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = ' ';
        }
        return board;
    }

    private static void printBoard(char[] board) {
        System.out.println("\n");
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    private static int getPlayerMove(Scanner scanner, char[] board) {
        int move;
        while (true) {
            System.out.print("Your move (1-9): ");
            if (scanner.hasNextInt()) {
                move = scanner.nextInt() - 1;
                if (move >= 0 && move < BOARD_SIZE) {
                    if (board[move] == ' ') {
                        return move;
                    } else {
                        System.out.println("Cell already taken. Try another.");
                    }
                } else {
                    System.out.println("Please enter a number between 1 and 9.");
                }
            } else {
                System.out.println("Invalid input. Enter a number.");
                scanner.next(); // clear non-integer input
            }
        }
    }

    private static int getComputerMove(char[] board) {
        int move;
        while (true) {
            move = (int) (Math.random() * BOARD_SIZE);
            if (board[move] == ' ') {
                return move;
            }
        }
    }

    private static boolean checkWinner(char[] board, char symbol) {
        return (board[0] == symbol && board[1] == symbol && board[2] == symbol) ||
               (board[3] == symbol && board[4] == symbol && board[5] == symbol) ||
               (board[6] == symbol && board[7] == symbol && board[8] == symbol) ||
               (board[0] == symbol && board[3] == symbol && board[6] == symbol) ||
               (board[1] == symbol && board[4] == symbol && board[7] == symbol) ||
               (board[2] == symbol && board[5] == symbol && board[8] == symbol) ||
               (board[0] == symbol && board[4] == symbol && board[8] == symbol) ||
               (board[2] == symbol && board[4] == symbol && board[6] == symbol);
    }

    private static boolean isDraw(char[] board) {
        for (char c : board) {
            if (c == ' ') {
                return false;
            }
        }
        return true;
    }

    private static void printResult(int winner) {
        switch (winner) {
            case 1 -> System.out.println("🎉 You won the game!");
            case 2 -> System.out.println("😞 You lost the game!");
            case 3 -> System.out.println("🤝 It's a draw!");
        }
        System.out.println("Created by Shreyas Saha. Thanks for playing!");
    }
}
