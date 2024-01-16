package org.example;

public enum Messages {
    ENTER_NUMBER("Enter box number to select. Enjoy!\n"),
    WIN("You won the game!\nCreated by Shreyas Saha. Thanks for playing!"),
    LOSS("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!"),
    DRAW("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!"),
    ENTER_MOVE("Enter your move (1-9): "),
    INVALID_INPUT("Invalid input. Please enter again.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
