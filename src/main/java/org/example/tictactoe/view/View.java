package org.example.tictactoe.view;

public class View {
    public static final String ENTER_BOX_NUMBER = "Enter box number to select. Enjoy!\n";
    public static final String INVALID_INPUT = "Invalid input. Enter again.\n";
    public static final String BOX_FIELD_IN_USE = "That one is already in use. Enter another.\n";
    public static final String YOU_WON =
            "You won the game!\nCreated by Shreyas Saha. Thanks for playing!";
    public static final String YOU_LOST =
            "You lost the game!\nCreated by Shreyas Saha. Thanks for playing!";
    public static final String DRAW_MESSAGE =
            "It's a draw!\nCreated by Shreyas Saha. Thanks for playing!";
    public static final char X = 'X';
    public static final char O = 'O';

    private View() {

    }

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printBoard(char[] box) {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }
}
