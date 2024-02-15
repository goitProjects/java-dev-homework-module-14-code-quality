package constants;

public class MessageConstants {
    public static final String ENTER_NUMBER = ("Enter box number to select. Enjoy!\n");
    public static final String WIN = "You won the game!\nCreated by Shreyas Saha. Thanks for playing!";
    public static final String LOSS = "You lost the game!\nCreated by Shreyas Saha. Thanks for playing!";
    public static final String DRAW = "It's a draw!\nCreated by Shreyas Saha. Thanks for playing!";
    public static final String ENTER_MOVE = "Enter your move (1-9): ";
    public static final String INVALID_INPUT = "Invalid input. Please enter again.";
    public static final String CHOOSE_ANOTHER_CELL = ("That one is already in use. Enter another.");
    private MessageConstants() {
        throw new IllegalStateException("Constants class");
    }
}
