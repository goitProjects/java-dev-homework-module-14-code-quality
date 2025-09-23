package rewriteTheCode;

import java.util.Scanner;
import java.util.logging.Logger;

public class App {
    static Logger logger = Logger.getLogger(App.class.getName());
    static char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
   static boolean boxEmpty = false;
   static Scanner scan = new Scanner(System.in);
    static byte winner = 0;
    static byte input;
    static byte rand;
    static byte i ;
   static boolean boxAvailable = false;

    public static void main(String[] args) {
        System.out.println("Enter box number to select. Enjoy!\n");

       CheckTheGame.CheckingForGame();

    }
}
