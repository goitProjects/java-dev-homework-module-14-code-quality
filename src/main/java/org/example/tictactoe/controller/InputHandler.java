package org.example.tictactoe.controller;

import static org.example.tictactoe.view.View.printMessage;

import java.util.Scanner;
import org.example.tictactoe.view.View;

/**
 * Class responsible for handling user input.
 * It ensures that the input is valid and within the expected range.
 */
public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

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
            printMessage(View.INVALID_INPUT);
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
