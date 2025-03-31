import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    private static final int BOARD_SIZE = 9;
    private static final char EMPTY_CELL = ' ';
    private static final char PLAYER_MARK = 'X';
    private static final char COMPUTER_MARK = 'O';
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        char[] board = initializeBoard();
        boolean firstMove = true;
        boolean gameRunning = true;

        System.out.println("Enter box number to select. Enjoy!\n");

        while (gameRunning) {
            printBoard(board);

            int gameStatus = getGameStatus(board);
            if (gameStatus != 0) {
                gameRunning = false;
            } else {
                playerMove(board);
                if (firstMove) {
                    clearBoard(board);
                    firstMove = false;
                }

                gameStatus = getGameStatus(board);
                if (gameStatus == 0) {
                    computerMove(board);
                } else {
                    gameRunning = false;
                }
            }
        }

        printBoard(board);
        displayGameResult(getGameStatus(board));

        scan.close();
    }

    private static char[] initializeBoard() {
        char[] board = new char[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = (char) ('1' + i);
        }
        return board;
    }

    private static void clearBoard(char[] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i] != PLAYER_MARK && board[i] != COMPUTER_MARK) {
                board[i] = EMPTY_CELL;
            }
        }
    }

    private static void printBoard(char[] board) {
        System.out.printf("%n %c | %c | %c %n", board[0], board[1], board[2]);
        System.out.println("-----------");
        System.out.printf(" %c | %c | %c %n", board[3], board[4], board[5]);
        System.out.println("-----------");
        System.out.printf(" %c | %c | %c %n%n", board[6], board[7], board[8]);
    }

    private static int getGameStatus(char[] board) {
        if (checkWinner(board, PLAYER_MARK)) {
            return 1;
        }
        if (checkWinner(board, COMPUTER_MARK)) {
            return 2;
        }
        if (isDraw(board)) {
            return 3;
        }
        return 0;
    }

    private static void displayGameResult(int gameStatus) {
        switch (gameStatus) {
            case 1 -> System.out.println("You won the game!\nThanks for playing!");
            case 2 -> System.out.println("You lost the game!\nThanks for playing!");
            case 3 -> System.out.println("It's a draw!\nThanks for playing!");
            default -> System.out.println("Unexpected game status.");
        }
    }

    private static boolean checkWinner(char[] board, char mark) {
        return (board[0] == mark && board[1] == mark && board[2] == mark)
                || (board[3] == mark && board[4] == mark && board[5] == mark)
                || (board[6] == mark && board[7] == mark && board[8] == mark)
                || (board[0] == mark && board[3] == mark && board[6] == mark)
                || (board[1] == mark && board[4] == mark && board[7] == mark)
                || (board[2] == mark && board[5] == mark && board[8] == mark)
                || (board[0] == mark && board[4] == mark && board[8] == mark)
                || (board[2] == mark && board[4] == mark && board[6] == mark);
    }

    private static boolean isDraw(char[] board) {
        for (char cell : board) {
            if (cell != PLAYER_MARK && cell != COMPUTER_MARK) {
                return false;
            }
        }
        return true;
    }

    private static void playerMove(char[] board) {
        while (true) {
            System.out.print("Enter a box number (1-9): ");
            if (scan.hasNextInt()) {
                int move = scan.nextInt();
                if (move >= 1 && move <= 9 && board[move - 1] != PLAYER_MARK && board[move - 1] != COMPUTER_MARK) {
                    board[move - 1] = PLAYER_MARK;
                    break;
                }
            } else {
                scan.next();
            }
            System.out.println("That one is already in use. Enter another.");
        }
    }

    private static void computerMove(char[] board) {
        while (true) {
            int move = ThreadLocalRandom.current().nextInt(0, BOARD_SIZE);
            if (board[move] != PLAYER_MARK && board[move] != COMPUTER_MARK) {
                board[move] = COMPUTER_MARK;
                break;
            }
        }
    }
}
