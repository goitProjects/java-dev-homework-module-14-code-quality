import java.util.Scanner;

import static java.lang.System.out;

public class App {
    private byte winner = 0;
    private final char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private boolean boxAvailable = false;
    private final Scanner scan = new Scanner(System.in);

    void startGame() {
        out.println("Enter box number to select. Enjoy!\n");

        while (true) {
            printBoard();

            if (!boxAvailable) {
                clearBoard();
                boxAvailable = true;
            }

            if (winner != 0) {
                printResult();
                break;
            }

            playerMove();
            if (checkWinner('X')) {
                winner = 1;
                continue;
            }

            if (!boxAvailable) {
                winner = 3;
                continue;
            }

            computerMove();
            if (checkWinner('O')) {
                winner = 2;
            }
        }
    }

    private void printBoard() {
        String horizontalLine = "-----------";
        String template = "\n\n %c | %c | %c \n%s\n %c | %c | %c \n%s\n %c | %c | %c \n";

        out.printf(template, box[0], box[1], box[2], horizontalLine, box[3], box[4], box[5], horizontalLine, box[6], box[7], box[8]);
    }

    private void clearBoard() {
        byte i;
        for (i = 0; i < 9; i++) {
            box[i] = ' ';
        }
    }

    private void printResult() {
        if (winner == 1) {
            out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 2) {
            out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 3) {
            out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }

    private void playerMove() {
        while (true) {
            byte input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O') {
                    out.println("That one is already in use. Enter another.");
                } else {
                    box[input - 1] = 'X';
                    break;
                }
            } else {
                out.println("Invalid input. Enter again.");
            }
        }
    }

    private void computerMove() {
        int center = 4;

        if (box[center] != 'X' && box[center] != 'O') {
            box[center] = 'O';
        } else {
            while (true) {
                byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                    box[rand - 1] = 'O';
                    break;
                }
            }
        }
    }

    private boolean checkWinner(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (box[i * 3] == symbol && box[i * 3 + 1] == symbol && box[i * 3 + 2] == symbol) {
                return true;
            }
            if (box[i] == symbol && box[i + 3] == symbol && box[i + 6] == symbol) {
                return true;
            }
        }
        if (box[0] == symbol && box[4] == symbol && box[8] == symbol) {
            return true;
        }
        return box[2] == symbol && box[4] == symbol && box[6] == symbol;
    }
}