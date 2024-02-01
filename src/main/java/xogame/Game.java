package xogame;

import java.util.Scanner;

public class Game {
    @SuppressWarnings("squid:S106")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameInterface gameInterface = new GameInterface();
        Player player = new Player('X');
        Player computer = new Player('0');

        System.out.println("Enter box number to select. Enjoy!\n");
        while (true) {
            gameInterface.boxToDisplay();
            player.move(scanner, gameInterface);
            if (gameInterface.checkWinner(player.getPlayerSymbol())) {
                gameInterface.boxToDisplay();
                System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }
            if (gameInterface.isBoxFull()) {
                gameInterface.boxToDisplay();
                System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            }
            computer.move(gameInterface);
            if (gameInterface.checkWinner(computer.getPlayerSymbol())) {
                gameInterface.boxToDisplay();
                System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }
        }
    }
}



