package rewriteTheCode;


import static rewriteTheCode.App.*;

public class CheckTheGame {

    public static char checkWinner(char[] box) {
        int[][] numbers = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };
        for (int[] number : numbers) {
            char firstSymbol = App.box[number[0]];
            if (firstSymbol != ' ' && firstSymbol == App.box[number[1]] && firstSymbol == App.box[number[2]]) {
                return firstSymbol;
            }
        }
        return '\0';

    }

    public static void CheckingForGame() {

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
                    App.input = scan.nextByte();
                    if (App.input > 0 && App.input < 10) {
                        if (box[App.input - 1] == 'X' || box[App.input - 1] == 'O')
                            System.out.println("That one is already in use. Enter another.");
                        else {
                            box[App.input - 1] = 'X';
                            break;
                        }
                    } else
                        System.out.println("Invalid input. Enter again.");
                }


                char winnerChar = checkWinner(box);
                if (winnerChar == 'X') {
                    winner = 1;
                } else if(winnerChar == 'O'){
                    winner = 2;
                }

                App.boxAvailable = false;
                for (App.i = 0; App.i < 9; App.i++) {
                    if (box[App.i] != 'X' && box[App.i] != 'O') {
                        App.boxAvailable = true;
                        break;
                    }
                }

                if (!App.boxAvailable) {
                    winner = 3;
                }
                if (winner != 0){
                    break;
                }

                while (true) {
                    App.rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                    if (box[App.rand - 1] != 'X' && box[App.rand - 1] != 'O') {
                        box[App.rand - 1] = 'O';
                        break;
                    }
                }
                winnerChar = checkWinner(box);
                if (winnerChar == 'X'){
                    winner = 1;
                } else if (winnerChar == 'O') {
                    winner = 2;
                }
                if (winner != 0){
                    break;
                }

        }
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }
}
