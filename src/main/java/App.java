import java.util.Random;
import java.util.Scanner;


public class App {

    // Позбуваємося Magic Characters за допомогою констант.
    private static final char PLAYER_SYMBOL = 'X';
    private static final char BOT_SYMBOL = 'O';
    private static final char EMPTY_CELL = ' ';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Скобки [] перенесені до типу даних (char[] board), що відповідає стандартам Java Code Conventions
        char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        System.out.println("Enter box number to select. Enjoy!\n");

        // Виводим початкове поле з цифрами для підказки
        printBoard(board);

        // Очищаємо поле для початку гри
        resetBoard(board);

        // Запуск основного ігрового циклу
        playGame(scanner, random, board);
    }

    /**
     * Основний ігровий цикл.
     * Замість одного великого методу логіка розбита на невеликі методи.
     */
    private static void playGame(Scanner scanner, Random random, char[] board) {
        boolean gameOver = false;

        // Замість while(true) з break/continue використовуємо прозору умову завершення циклу
        while (!gameOver) {
            makePlayerMove(scanner, board);
            printBoard(board);

            gameOver = checkAndDisplayGameResult(board);

            // Якщо гравець не виграв і немає нічиєї — ходить бот
            if (!gameOver) {
                makeBotMove(random, board);
                System.out.println("Bot made a move:");
                printBoard(board);

                gameOver = checkAndDisplayGameResult(board);
            }
        }
    }

    /**
     * Заповнює ігрове поле порожніми символами
     */
    private static void resetBoard(char[] board) {
        for (int i = 0; i < board.length; i++) {
            board[i] = EMPTY_CELL;
        }
    }

    /**
     * Вивод ігрової дошки в консоль
     */
    private static void printBoard(char[] board) {
        System.out.println("\n " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
    }

    /**
     * Обробка ходу гравця з валідацією введення
     */
    private static void makePlayerMove(Scanner scanner, char[] board) {
        boolean validMove = false;

        while (!validMove) {
            if (scanner.hasNextByte()) {
                byte input = scanner.nextByte();

                if (input >= 1 && input <= 9) {
                    if (board[input - 1] == PLAYER_SYMBOL || board[input - 1] == BOT_SYMBOL) {
                        System.out.println("That one is already in use. Enter another.");
                    } else {
                        board[input - 1] = PLAYER_SYMBOL;
                        validMove = true;
                    }
                } else {
                    System.out.println("Invalid input. Enter again.");
                }
            } else {
                System.out.println("Invalid input. Enter again.");
                scanner.next(); // Очищення некоректного введення
            }
        }
    }

    /**
     * Генерація ходу бота
     */
    private static void makeBotMove(Random random, char[] board) {
        boolean botMoved = false;

        while (!botMoved) {
            int rand = random.nextInt(9);
            if (board[rand] != PLAYER_SYMBOL && board[rand] != BOT_SYMBOL) {
                board[rand] = BOT_SYMBOL;
                botMoved = true;
            }
        }
    }

    /**
     * Перевіряє стан гри та виводить повідомлення про переможця
     * @return true, якщо гру завершено
     */
    private static boolean checkAndDisplayGameResult(char[] board) {
        if (checkWin(board, PLAYER_SYMBOL)) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        if (checkWin(board, BOT_SYMBOL)) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        if (isBoardFull(board)) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        return false;
    }

    /**
     * Перевірка виграшних комбінацій
     */
    private static boolean checkWin(char[] board, char symbol) {
        int[][] winCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Горизонталі
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Вертикалі
                {0, 4, 8}, {2, 4, 6}             // Діагоналі
        };

        for (int[] combo : winCombinations) {
            if (board[combo[0]] == symbol && board[combo[1]] == symbol && board[combo[2]] == symbol) {
                return true;
            }
        }
        return false;
    }

    /**
     * Перевірка, чи залишилися вільні клітинки
     */
    private static boolean isBoardFull(char[] board) {
        for (char cell : board) {
            if (cell != PLAYER_SYMBOL && cell != BOT_SYMBOL) {
                return false;
            }
        }
        return true;
    }
}