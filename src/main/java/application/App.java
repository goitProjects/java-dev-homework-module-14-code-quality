package application;

import application.impl.MessageServiceImpl;

import java.util.Scanner;

public class App {

    @SuppressWarnings("squid:S106")
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MessageService messageService = new MessageServiceImpl();
        Box box = new Box();
        messageService.printStartMessage();
        while (true) {
            messageService.printMessage(box);
            if (box.getWinner() != 0) {
                break;
            }
            box.cleanTheBox();
            Logic.inputDigitValidation(scan, box);
            byte winner = Logic.winnerSelector(box);
            if (winner == 1 || winner == 3) {
                box.setWinner(winner);
                continue;
            }
            Logic.randomBoxChooser(box);
            winner = Logic.winnerSelector(box);
            if (winner == 2) {
                box.setWinner(winner);
            }
        }
    }
}