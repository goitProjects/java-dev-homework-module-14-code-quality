import java.util.Arrays;
import java.util.Scanner;

public class App {

    private static final char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static byte winner = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte input;
        boolean boxAvailable = false;

        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;
        while (true) {
            printBox();
            if (!boxEmpty) {
                Arrays.fill(box, ' ');
                boxEmpty = true;
            }

            if (printResult(winner)) break;

            while (true) {
                input = scan.nextByte();
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

            if (isWinner(box, 'X')) {
                winner = 1;
                continue;
            }


            boxAvailable = false;
            for (char c : box) {
                if (c != 'X' && c != 'O') {
                    boxAvailable = true;
                    break;
                }
            }

            if (!boxAvailable) {
                winner = 3;
                continue;
            }

            setRandomCell();

            if (isWinner(box, 'O')) {
                winner = 2;
            }
        }

    }

    //print out the box with cells numbers
    public static void printBox() {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " "
                + "\n-----------"
                + "\n " + box[3] + " | " + box[4] + " | " + box[5] + " "
                + "\n-----------"
                + "\n " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    static boolean printResult(byte winner) {
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        return false;
    }

    //search for the winner
    public static boolean isWinner(char[] box, char player) {
        return (box[0] == player && box[1] == player && box[2] == player) || (box[3] == player && box[4] == player && box[5] == player) || (box[6] == player && box[7] == player && box[8] == player) ||
                (box[0] == player && box[3] == player && box[6] == player) || (box[1] == player && box[4] == player && box[7] == player) || (box[2] == player && box[5] == player && box[8] == player) ||
                (box[0] == player && box[4] == player && box[8] == player) || (box[2] == player && box[4] == player && box[6] == player);
    }

    public static void setRandomCell() {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * 9 + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

}