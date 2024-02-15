package main;

import game.Game;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        game.startGame(scanner);

        scanner.close();
    }
}