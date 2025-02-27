import java.util.Scanner;

public class App {
    private static final char PLAYER_SYMBOL = 'X';
    private static final char COMPUTER_SYMBOL = 'O';
    private static final char EMPTY_CHAR = ' ';
    private static final int BOARD_SIZE = 9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gameStatus = 0; //статус игры 0 - игра идёт;
        char board[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9'}; //первоначальное заполнение для туториала
        System.out.println("Enter box number to select. Enjoy!\n");
        boolean flagInitialize = false; //Флаг который позволит вывести туториал(не пустое поле) один раз за игру.

        while (true) {
            printBoard(board);

            if(flagInitialize !=true){
                initializeBoard(board);
                flagInitialize = true;
            }

            if (gameStatus != 0) { //проверка на исход игры.
                printGameResult(gameStatus);
                break;
            }

            playerMove(scanner, board);
            gameStatus = checkWinner(board);
            if (gameStatus != 0){
                continue;
            }

            if (isBoardFull(board)) { //проверка на ничью
                gameStatus = 3;
                continue;
            }

            computerMove(board);
            gameStatus = checkWinner(board);
        }
        scanner.close();
    }

    private static void printBoard(char[] board) {

        System.out.println("\n");

        for (int i = 0; i < 9; i += 3) {  //Вывод поля в цикле
            System.out.println(" " + board[i] + " | " + board[i + 1] + " | " + board[i + 2] + " ");

            if (i < 6) { //после каждой строки разделитель кроме последнего
                System.out.println("-----------");
            }

        }
        System.out.println("\n");

    }

    private static void initializeBoard(char[] board) { //подготовить поле к старту игры(очистить)
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = EMPTY_CHAR;
        }
    }

    private static int checkWinner(char[] board) { //проверка на победу
        int[][] winningCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //по горизонтали
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //по вертикали
                {0, 4, 8}, {2, 4, 6} // по диагонали
        };

        for (int[] combination : winningCombinations) {
            if (board[combination[0]] != EMPTY_CHAR && //проверка на одинаковые символы в комбинациях.
                    board[combination[0]] == board[combination[1]] &&
                    board[combination[1]] == board[combination[2]]) {
                return (board[combination[0]] == PLAYER_SYMBOL) ? 1 : 2; //Если последний символ 'X' = 1 else 2.
            }
        }
        return 0;
    }

    private static void playerMove(Scanner scanner, char[] board) {
        while (true) {
            byte input = scanner.nextByte(); //считывание ввода пользователя
            if (input >= 1 && input <= 9 && board[input - 1] == EMPTY_CHAR) { //проверка на "выход за рамки" и пустая ли ячейка
                board[input - 1] = PLAYER_SYMBOL;
                break;
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }

    private static void computerMove(char[] board) {
        while (true) {
            int rand = (int) (Math.random() * BOARD_SIZE);
            if (board[rand] == EMPTY_CHAR) { //ввод компьютера, если ячейка занята, подбираем другое число
                board[rand] = COMPUTER_SYMBOL;
                break;
            }
        }
    }

    private static boolean isBoardFull(char[] board) {
        for (char cell : board) {
            if (cell == EMPTY_CHAR) { //если хотябы одно поле пустое, значит поле не заполненное
                return false;
            }
        }
        return true;
    }

    private static void printGameResult(int winner) {
        switch (winner) {
            case 1 -> System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            case 2 -> System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            case 3 -> System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }
}
