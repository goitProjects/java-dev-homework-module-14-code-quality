package goit.tic_tac_toe;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Field field = new Field(3);
        Player player1 = new Player(field,"X");
        Player player2 = new Player(field,"O");

        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;
        while (true) {
            field.viewField();

            if(!boxEmpty){
                field.clearField();
                boxEmpty = true;
            }

            if (field.isGameOver(player1, player2)) break;

            player1.goPlayer(scan);
            player2.goComputer();
        }

    }
}