package application;

import application.impl.MessageServiceImpl;

import java.util.Scanner;

public class App {

    @SuppressWarnings("squid:S106")
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MessageService messageService = new MessageServiceImpl();
        Box box = new Box();
        Logic.startGame(box, messageService, scan);
    }
}