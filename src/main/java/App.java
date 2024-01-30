import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class App {

    private static String[][] box = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

    private static byte winner = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte input;
        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;
        while (true) {

            printBox(box);


            if (!boxEmpty) {
                for (int i = 0; i < box.length; i++) {
                    Arrays.fill(box[i], " ");
                }
                boxEmpty = true;
            }

            //print the result
            if (printResult(winner)) break;

            a:
            while (true) {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    for (int k = 0; k < box.length; k++) {
                        if (box[k][input - 1].equals("X") || box[k][input - 1].equals("O")) {
                            System.out.println("That one is already in use. Enter another.");
                        } else {
                            box[k][input - 1] = "X";
                            break a;
                        }
                    }
                } else
                    System.out.println("Invalid input. Enter again.");
            }

            setRandom();
            getWinner();
        }

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

    //to print out the result of used array. Streams view
    public static void printBox(String[][] arr) {
        StringJoiner joiner = new StringJoiner("\n---------\n");
        for (String[] k : arr) {
            String join = String.join(" | ", k);
            joiner.add(join);
        }
        System.out.println(joiner.toString());
    }

    //to define a winner
    public static byte getWinner() {
        for (int j = 0; j < box.length; j++) {
            for (int k = 0; k < box[j].length; k++) {
                if (box[j][k].equals("X")) {
                    winner = 1;
                } else if (box[j][k].equals("0")) {
                    winner = 2;
                } else winner = 3;
            }
        }
        return winner;
    }

    //to set the opposite values in a random box
    public static void setRandom() {
        byte rand;
        b:
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            for (int j = 0; j < box.length; j++) {
                if (!box[j][rand - 1].equals("X") && !box[j][rand - 1].equals("O")) {
                    box[j][rand - 1] = "O";
                    break b;
                }
            }
        }
    }
}