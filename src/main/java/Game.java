import java.util.Scanner;

public class Game {
    private static final Scanner SCANNER = new Scanner(System.in);
    private byte i;
    private boolean boxAvailable = false;
    private byte winner = 0;
    private final char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public void playGame() {

        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;
        do {
            showBox();
            if (!boxEmpty) {
                cleanBox();

                boxEmpty = true;
            }

            if (hasWinner()) {
                break;
            }

            readData();

            if (isWinnerOne()) {
                continue;
            }

            hasBoxAvailable();

            if (!boxAvailable) {
                winner = 3;
                continue;
            }

            makeComputerMove();

            isWinnerTwo();
        } while (true);

    }

    private void isWinnerTwo() {
        if ((box[0] == 'O' && box[1] == 'O' && box[2] == 'O') ||
                (box[3] == 'O' && box[4] == 'O' && box[5] == 'O') ||
                (box[6] == 'O' && box[7] == 'O' && box[8] == 'O') ||
                (box[0] == 'O' && box[3] == 'O' && box[6] == 'O') ||
                (box[1] == 'O' && box[4] == 'O' && box[7] == 'O') ||
                (box[2] == 'O' && box[5] == 'O' && box[8] == 'O') ||
                (box[0] == 'O' && box[4] == 'O' && box[8] == 'O') ||
                (box[2] == 'O' && box[4] == 'O' && box[6] == 'O')) {
            winner = 2;
        }
    }

    private void makeComputerMove() {
        while (true) {
            byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    private void hasBoxAvailable() {
        boxAvailable = false;
        for (i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                boxAvailable = true;
                break;
            }
        }
    }

    private boolean isWinnerOne() {
        if ((box[0] == 'X' && box[1] == 'X' && box[2] == 'X') ||
                (box[3] == 'X' && box[4] == 'X' && box[5] == 'X') ||
                (box[6] == 'X' && box[7] == 'X' && box[8] == 'X') ||
                (box[0] == 'X' && box[3] == 'X' && box[6] == 'X') ||
                (box[1] == 'X' && box[4] == 'X' && box[7] == 'X') ||
                (box[2] == 'X' && box[5] == 'X' && box[8] == 'X') ||
                (box[0] == 'X' && box[4] == 'X' && box[8] == 'X') ||
                (box[2] == 'X' && box[4] == 'X' && box[6] == 'X')) {
            winner = 1;
            return true;
        }
        return false;
    }

    private void readData() {
        while (true) {
            byte input = SCANNER.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[input - 1] = 'X';
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }

    private boolean hasWinner() {
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by My. Thanks for playing!");
            return true;
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by My. Thanks for playing!");
            return true;
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by My. Thanks for playing!");
            return true;
        }
        return false;
    }

    private void cleanBox() {
        for (i = 0; i < 9; i++) {
            box[i] = ' ';
        }
    }

    private void showBox() {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }
}
