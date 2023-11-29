package application;

import application.impl.MessageServiceImpl;

import java.util.Scanner;


public class App {

    @SuppressWarnings("squid:S106")
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        MessageService messageService = new MessageServiceImpl();
        Box box = new Box();
        byte rand;

        byte winner = 0;
        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;
        while (true) {
            messageService.printMessage(box);

            if(winner != 0) {
                break;
            }

            if(!boxEmpty){
                for(int i = 0; i < 9; i++)
                    box.getBoxArray()[i] = ' ';
                boxEmpty = true;
            }



            // input digit validation
            while (true) {
                byte input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (box.getBoxArray()[input - 1] == 'X' || box.getBoxArray()[input - 1] == 'O')
                        System.out.println("That one is already in use. Enter another.");
                    else {
                        box.getBoxArray()[input - 1] = 'X';
                        break;
                    }
                }
                else
                    System.out.println("Invalid input. Enter again.");
            }


            if(Logic.winnerSelector(box) == 1) {
                box.setWinner((byte) 1);
                continue;
            }


            //search for an empty box

            box.setBoxAvailable(false);
            for(int i=0; i<9; i++){
                if(box.getBoxArray()[i] != 'X' && box.getBoxArray()[i] != 'O'){
                    box.setBoxAvailable(true);
                    break;
                }
            }

            if(box.isBoxAvailable() == false){
                box.setWinner((byte) 3);
                continue;
            }

            while (true) {
                rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                if (box.getBoxArray()[rand - 1] != 'X' && box.getBoxArray()[rand - 1] != 'O') {
                    box.getBoxArray()[rand - 1] = 'O';
                    break;
                }
            }

            if(Logic.winnerSelector(box) == 2) {
                box.setWinner((byte) 2);
            }
        }

    }
}