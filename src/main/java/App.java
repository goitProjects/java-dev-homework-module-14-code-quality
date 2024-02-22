import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static byte winner = 0;
    static Scanner scan = new Scanner(System.in);
    private static final char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) {
        Operations operator = new Operations(box);

        byte input;
        boolean boxAvailable = false;

        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;
        while (true) {
            operator.printBox();
            if (!boxEmpty) {
                Arrays.fill(box, ' ');
                boxEmpty = true;
            }

            if (operator.printResult(winner)) break;

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

            if (operator.isWinner(box, 'X')) {
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

            operator.setRandomCell();

            if (operator.isWinner(box, 'O')) {
                winner = 2;
            }
        }

    }


}