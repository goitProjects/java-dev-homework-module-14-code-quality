package ua.kyrylo.bieliaiev;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static ua.kyrylo.bieliaiev.Winner.*;

public class App {

    private final Scanner scan = new Scanner(System.in);
    private final TicTacToePrinter printer = new TicTacToePrinter(System.out);
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();
    char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        Winner winner = NOT_DECIDED;
        printer.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;
        while (true) {
            printer.printBox(box);
            if (!boxEmpty) {
                for (int i = 0; i < 9; i++)
                    box[i] = ' ';
                boxEmpty = true;
            }

            if (winner != NOT_DECIDED) {
                printer.printResult(winner);
                break;
            }

            inputPlayerChoice();
            if (isPlayerWon('X')) {
                winner = PLAYER;
                continue;
            }

            if (!isBoxAvailable()) {
                winner = TIE;
                continue;
            }

            opponentChoice();
            if (isPlayerWon('O')) {
                winner = OPPONENT;
            }
        }
    }

    private void opponentChoice() {
        while (true) {
            int rand = random.nextInt(9) + 1;
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    private boolean isBoxAvailable() {
        for (int i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                return true;
            }
        }
        return false;
    }

    private boolean isPlayerWon(char x) {
        return (box[0] == x && box[1] == x && box[2] == x) || (box[3] == x && box[4] == x && box[5] == x)
                || (box[6] == x && box[7] == x && box[8] == x) || (box[0] == x && box[3] == x && box[6] == x)
                || (box[1] == x && box[4] == x && box[7] == x) || (box[2] == x && box[5] == x && box[8] == x)
                || (box[0] == x && box[4] == x && box[8] == x) || (box[2] == x && box[4] == x && box[6] == x);
    }

    private void inputPlayerChoice() {
        while (true) {
            int input = scan.nextInt();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O') {
                    printer.println("That one is already in use. Enter another.");
                } else {
                    box[input - 1] = 'X';
                    break;
                }
            } else {
                printer.println("Invalid input. Enter again.");
            }
        }
    }
}