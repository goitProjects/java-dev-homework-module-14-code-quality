import java.util.Scanner;

public class App {

    private static final char PLAYER = 'X';
    private static final char COMPUTER = 'O';
    private static final int BOARD_SIZE = 9;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] box = new char[BOARD_SIZE];
        byte winner = 0;

        for (int i = 0; i < BOARD_SIZE; i++) {
            box[i] = ' ';
        }

        System.out.println("Enter box number to select. Enjoy!\n");

        while (true) {
            printBoard(box);

            if (winner == 1) {
                System.out.println("You won the game!");
                break;
            } else if (winner == 2) {
                System.out.println("You lost the game!");
                break;
            } else if (winner == 3) {
                System.out.println("It's a draw!");
                break;
            }

            makePlayerMove(scan, box);

            if (hasWinner(box, PLAYER)) {
                winner = 1;
                continue;
            }

            if (!hasFreeCells(box)) {
                winner = 3;
                continue;
            }

            makeComputerMove(box);

            if (hasWinner(box, COMPUTER)) {
                winner = 2;
            }
        }
    }

    private static void printBoard(char[] box) {
        System.out.println("\n " + box[0] + " | " + box[1] + " | " + box[2]);
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5]);
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + "\n");
    }

    private static void makePlayerMove(Scanner scan, char[] box) {
        while (true) {
            byte input = scan.nextByte();
            if (input > 0 && input <= BOARD_SIZE) {
                if (box[input - 1] == ' ') {
                    box[input - 1] = PLAYER;
                    return;
                } else {
                    System.out.println("That one is already in use.");
                }
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

    private static void makeComputerMove(char[] box) {
        while (true) {
            int rand = (int) (Math.random() * BOARD_SIZE);
            if (box[rand] == ' ') {
                box[rand] = COMPUTER;
                return;
            }
        }
    }

    private static boolean hasFreeCells(char[] box) {
        for (char c : box) {
            if (c == ' ') {
                return true;
            }
        }
        return false;
    }

    private static boolean hasWinner(char[] box, char symbol) {
        return (box[0] == symbol && box[1] == symbol && box[2] == symbol)
            || (box[3] == symbol && box[4] == symbol && box[5] == symbol)
            || (box[6] == symbol && box[7] == symbol && box[8] == symbol)
            || (box[0] == symbol && box[3] == symbol && box[6] == symbol)
            || (box[1] == symbol && box[4] == symbol && box[7] == symbol)
            || (box[2] == symbol && box[5] == symbol && box[8] == symbol)
            || (box[0] == symbol && box[4] == symbol && box[8] == symbol)
            || (box[2] == symbol && box[4] == symbol && box[6] == symbol);
    }
}