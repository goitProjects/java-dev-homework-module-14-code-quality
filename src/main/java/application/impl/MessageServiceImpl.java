package application.impl;

import application.Box;
import application.MessageService;

public class MessageServiceImpl implements MessageService {
    @SuppressWarnings("squid:S106")
    @Override
    public void printMessage(Box box) {
        byte winner = box.getWinner();
        char[] boxArray = box.getBoxArray();
        String format = "\n\n %s | %s | %s \n-----------\n %s | %s | %s \n-----------\n %s | %s | %s \n";
        String message = String.format(format, boxArray[0], boxArray[1], boxArray[2], boxArray[3], boxArray[4],
                boxArray[5], boxArray[6], boxArray[7], boxArray[8]);
        switch (winner) {
            case 0:
                System.out.println(message);
                break;
            case 1:
                System.out.println(message + "\n\nYou won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            case 2:
                System.out.println(message + "\n\nYou lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            case 3:
                System.out.println(message + "\n\nIt's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            default:
                break;
        }
    }

    public void printStartMessage() {
        System.out.println("Enter box number to select. Enjoy!\n");
    }
}
