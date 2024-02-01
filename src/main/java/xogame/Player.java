package xogame;

import java.util.Scanner;

public class Player {


    private char playerSymbol;

    public Player(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }
    @SuppressWarnings("squid:S106")
    public void move(Scanner scanner, GameInterface gameInterface) {
        while (true) {
            int input = scanner.nextInt();
            if (input > 0 && input < 10) {
                if (gameInterface.getBox()[input - 1] == 'X' || gameInterface.getBox()[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    gameInterface.getBox()[input - 1] = 'X';
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }

    }

    public void move(GameInterface gameInterface) {
        while (true) {
            int rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (gameInterface.getBox()[rand - 1] != 'X' && gameInterface.getBox()[rand - 1] != 'O') {
                gameInterface.getBox()[rand - 1] = 'O';
                break;
            }
        }

    }
}
