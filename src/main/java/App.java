
import java.util.Scanner;

public class App {
    private static final int BOARD_SIZE = 9;
    private static final char PLAYER_SYMBOL = 'X';
    private static final char COMPUTER_SYMBOL = 'O';

    private App() {
    }

    /**
     * Метод playGame відповідає за виконання основного циклу гри, в якому гравець і комп'ютер чергуються
     * у виконанні ходів до завершення гри.
     *
     * @param scanner Об'єкт Scanner для зчитування введення з консолі.
     * @param board   Масив символів, що представляє стан дошки гри.
     */
    public static void playGame(Scanner scanner, char[] board) {
        boolean playerTurn = true;
        while (true) {
            displayBoard(board);

            char symbol = playerTurn ? PLAYER_SYMBOL : COMPUTER_SYMBOL;
            makeMove(scanner, board, symbol);

            if (checkWinner(board, symbol)) {
                displayBoard(board);
                announceWinner(playerTurn);
                break;
            } else if (isBoardFull(board)) {
                displayBoard(board);
                System.out.println("It's a draw!");
                break;
            }

            playerTurn = !playerTurn;
        }
    }

    /**
     * Метод isBoardFull перевіряє, чи вся дошка гри заповнена.
     *
     * @param board Масив символів, що представляє стан дошки гри.
     * @return Повертає true, якщо дошка повністю заповнена (всі клітинки зайняті), інакше - false.
     */
    private static boolean isBoardFull(char[] board) {
        for (char cell : board) {
            if (cell >= '1' && cell <= '9') {
                return false;
            }
        }
        return true;
    }


    /**
     * Метод displayBoard виводить поточний стан дошки гри у консоль.
     *
     * @param board Масив символів, що представляє стан дошки гри.
     */
    private static void displayBoard(char[] board) {
        System.out.println("\n " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + "\n");
    }


    /**
     * Метод makeMove дозволяє гравцеві або комп'ютеру здійснити хід у грі.
     *
     * @param scanner Об'єкт Scanner для зчитування введення з консолі.
     * @param board   Масив символів, що представляє стан дошки гри.
     * @param symbol  Символ, який використовується для позначення ходу гравця (X або O).
     */
    private static void makeMove(Scanner scanner, char[] board, char symbol) {
        int input;
        while (true) {
            System.out.println("Enter box number to select:");
            input = scanner.nextInt();
            if (input > 0 && input <= BOARD_SIZE && board[input - 1] == (char) input + '0') {
                board[input - 1] = symbol;
                break;
            }
            else {
                System.out.println("Invalid input. Enter again.");}
        }
    }

    /**
     * Перевірити рядки, стовпці і діагоналі на переможця
     * Повернути true, якщо є переможець
     */
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

    /**
     * Виведення повідомлення про результат гри: перемогу гравця або його поразку.
     *
     * @param playerTurn true, якщо гравець виграв, false - якщо програв.
     */
    private static void announceWinner(boolean playerTurn) {
        if (playerTurn) {
            System.out.println("Congratulations! You won the game!");
        } else {
            System.out.println("You lost the game. Better luck next time!");
        }
        System.out.println("Thanks for playing!");
    }
}