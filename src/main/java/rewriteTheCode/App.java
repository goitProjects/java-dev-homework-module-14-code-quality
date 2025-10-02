package rewriteTheCode;

import java.util.Scanner;
import java.util.logging.Logger;

public class App {
    static Logger logger = Logger.getLogger(App.class.getName());


    public static void main(String[] args) {
        System.out.println("Enter box number to select. Enjoy!\n");

       CheckTheGame game = new CheckTheGame();
       game.checkingForGame();

    }
}
