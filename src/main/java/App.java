import java.util.Scanner;
import java.util.stream.Stream;

public class App {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final char[] BOX = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };


    public static void main(String[] args) {
        byte winner = 0;
        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;
        while (true) {
            printBoard();

            boxEmpty = isBoxEmpty(boxEmpty);

            if (printWinner(winner)) break;

            playerMove();

            if (checkWinner('X')) {
                winner = 1;
            }

            if(!isBoxAvailable()){
                winner = 3;
            }

            computerMove();

            if (checkWinner('O')) {
                winner = 2;
            }
        }

    }

    private static boolean isBoxEmpty(boolean boxEmpty) {
        byte i;
        if(!boxEmpty){
            for(i = 0; i < 9; i++)
                BOX[i] = ' ';
            boxEmpty = true;
        }
        return boxEmpty;
    }

    private static boolean isBoxAvailable() {
        boolean boxAvailable = false;
        byte i;
        for(i=0; i<9; i++){
            if(BOX[i] != 'X' && BOX[i] != 'O'){
                boxAvailable = true;
                break;
            }
        }
        return boxAvailable;
    }

    private static void playerMove() {
        byte input;
        while (true) {
            input = SCANNER.nextByte();
            if (input > 0 && input < 10) {
                if (BOX[input - 1] == 'X' || BOX[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    BOX[input - 1] = 'X';
                    break;
                }
            }
            else
                System.out.println("Invalid input. Enter again.");
        }
    }

    private static void computerMove() {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (BOX[rand - 1] != 'X' && BOX[rand - 1] != 'O') {
                BOX[rand - 1] = 'O';
                break;
            }
        }
    }



    private static boolean checkWinner(char player) {
        int[][] winPattern = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},    // Горизонтально
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},    // Вертикально
                {0, 4, 8}, {2, 4, 6}                // Діагонально
        };

        return Stream.of(winPattern)
                .anyMatch(pattern ->
                        BOX[pattern[0]] == player &&
                                BOX[pattern[1]] == player &&
                                BOX[pattern[2]] == player);
    }

    private static boolean printWinner(byte winner) {
        switch (winner) {
            case 1 -> {
                System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                return true;
            }
            case 2 -> {
                System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                return true;
            }
            case 3 -> {
                System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    private static void printBoard() {
        System.out.println("\n\n " + BOX[0] + " | " + BOX[1] + " | " + BOX[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + BOX[3] + " | " + BOX[4] + " | " + BOX[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + BOX[6] + " | " + BOX[7] + " | " + BOX[8] + " \n");
    }
}