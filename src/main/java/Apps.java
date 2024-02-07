import java.util.Scanner;

public class Apps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        App.playGame(scanner,new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'} );
        scanner.close();
    }
}
