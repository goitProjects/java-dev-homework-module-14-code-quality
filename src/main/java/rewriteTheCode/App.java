package rewriteTheCode;

import java.util.Scanner;
import java.util.logging.Logger;

public class App {
    static Logger logger = Logger.getLogger(App.class.getName());

    static Scanner scan = new Scanner(System.in);
    static byte input;
    static byte rand;
    static byte i ;
    static boolean boxAvailable = false;
    static byte winner = 0;
    static char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    static boolean boxEmpty = false;

    public static void main(String[] args) {
        logger.info("Enter box number to select. Enjoy!\n");

        CheckTheGame.CheckingForGame();

    }
}
