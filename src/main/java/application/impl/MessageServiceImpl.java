package application.impl;

import application.Box;
import application.MessageService;

public class MessageServiceImpl implements MessageService {




    @Override
    public void printMessage(Box box) {
        byte winner = box.getWinner();
        char[] boxArray = box.getBoxArray();
        switch (winner) {
            case 0: System.out.println("\n\n "
                    + boxArray[0] + " | " + boxArray[1] + " | " + boxArray[2] +
                    " \n-----------\n "
                    + boxArray[3] + " | " + boxArray[4] + " | " + boxArray[5] +
                    " \n-----------\n "
                    + boxArray[6] + " | " + boxArray[7] + " | " + boxArray[8] + " \n");
            break;
            case 1: System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            break;
            case 2: System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            break;
            case 3: System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            break;
            default: break;
        }

    }
}
