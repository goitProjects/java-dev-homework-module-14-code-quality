package ua.kyrylo.bieliaiev;

import java.io.PrintStream;

import static ua.kyrylo.bieliaiev.Winner.*;

public class TicTacToePrinter {

    private final PrintStream out;

    public TicTacToePrinter(PrintStream out) {
        this.out = out;
    }

    public void println(String s) {
        out.println(s);
    }

    public void printBox(char[] box) {
        out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        out.println("-----------");
        out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        out.println("-----------");
        out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    public void printResult(Winner winner) {
        if(winner == PLAYER){
            out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if(winner == OPPONENT){
            out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if(winner == TIE){
            out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }
}
