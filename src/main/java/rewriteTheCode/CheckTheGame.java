package rewriteTheCode;


import java.util.Scanner;


public class CheckTheGame {

    private char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private boolean boxEmpty = false;
    private Scanner scan = new Scanner(System.in);
    public byte winner = 0;
    private byte input;
    private byte rand;
    private byte i;
    private boolean boxAvailable = false;
    private final char player = 'X';
    private final char computer = 'O';

    private static char checkWinner(char[] box) {
        int[][] numbers = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };
        for (int[] number : numbers) {
            char firstSymbol = box[number[0]];
            if (firstSymbol != ' ' && firstSymbol == box[number[1]] && firstSymbol == box[number[2]]) {
                return firstSymbol;
            }
        }
        return '\0';

    }

    public void checkingForGame() {
        while (true) {
            System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
            System.out.println("-----------");
               System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
            System.out.println("-----------");
            System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");

            if (!boxEmpty) {
                for (int i = 0; i < 9; i++) {
                    box[i] = ' ';
                }
                boxEmpty = true;
            }

            while (true) {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (box[input - 1] == player || box[input - 1] == computer)
                        System.out.println("That one is already in use. Enter another.");
                    else {
                        box[input - 1] = player;
                        break;
                    }
                } else
                    System.out.println("Invalid input. Enter again.");
            }

            char winnerChar = checkWinner(box);
            if (winnerChar == player) {
                winner = 1;
            } else if(winnerChar == computer){
                winner = 2;
            }

            boxAvailable = false;
            for (i = 0; i < 9; i++) {
                if (box[i] != player && box[i] != computer) {
                    boxAvailable = true;
                    break;
                }
            }

            if (!boxAvailable) {
                winner = 3;
            }
            if (winner != 0){
                break;
            }

            while (true) {
                rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                if (box[rand - 1] != player && box[rand - 1] != computer) {
                    box[rand - 1] = computer;
                    break;
                }
            }
            winnerChar = checkWinner(box);
            if (winnerChar == player){
                winner = 1;
            } else if (winnerChar == computer) {
                winner = 2;
            }
            if (winner != 0){
                break;
            }

        }
        switch (winner){
            case 1:
                System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            case 2:
                System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            case 3:
                System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
        }

    }
}