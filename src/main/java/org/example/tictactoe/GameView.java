package org.example.tictactoe;

import java.util.Scanner;

public class GameView {
    public static final String INVALID_INPUT = "Invalid input. Enter again.\n";
    public static final String BOX_FIELD_IN_USE = "That one is already in use. Enter another.\n";
    private final Scanner scanner = new Scanner(System.in);

    public void printBoard(char[] box) {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

    /**
     * Prompts the user to input a valid box number (1-9).
     * Continues to prompt until a valid input is received.
     *
     * @return A byte representing the valid box number selected by the user.
     */
    public byte inputCorrectNumber() {
        byte move;
        while (!scanner.hasNextByte()
                || !isValidBoxField(move = scanner.nextByte())) {
            printMessage(INVALID_INPUT);
            scanner.next();
        }
        return (byte) (move - 1);
    }

    /**
     * Checks if the provided box number is valid (between 1 and 9).
     *
     * @param number The box number to validate.
     * @return true if the number is valid, false otherwise.
     */
    private boolean isValidBoxField(byte number) {
        return number > 0 && number < 10;
    }

    /**
     * Closes the scanner resource to prevent resource leaks.
     * Should be called when input handling is no longer needed.
     */
    public void closeResources() {
        scanner.close();
    }
}
