package goit.tic_tac_toe;

import java.util.Scanner;

public class Player {
    Field field;
    String signPlayer;
    boolean isWinner = false;

    public Player(Field field, String signPlayer) {
        this.field = field;
        this.signPlayer = signPlayer;
    }

    public void goPlayer(Scanner scan){
        byte input;
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input <= field.getSizeField()) {
                if (!field.getValueBox(input - 1).equals(" "))
                    System.out.println("That one is already in use. Enter another.");
                else {
                    field.setValueBox(input - 1, signPlayer);
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
        isWinner();
    }

    public void goComputer(){
        while (true) {
            byte rand = (byte) (Math.random() * field.getSizeField() + 1);
            if (field.getValueBox(rand - 1).equals(" ")) {
                field.setValueBox(rand - 1, signPlayer);
                break;
            }
        }
        isWinner();
    }

    private void isWinner(){
        if (isFullByRow()) return;
        if (isFullByColumn()) return;

        if (isFullDiagonalLeftRight()){
            isWinner = true;
            return;
        }
        if (isFullDiagonalRightLeft()) {
            isWinner = true;
        }
    }

    private boolean isFullByRow(){
        int startNumberRow = 0;
        for (int row = 0; row < field.getRows(); row++){
            if (fullRow(startNumberRow)){
                isWinner = true;
                return true;
            }
            startNumberRow += field.getRows();
        }
        return false;
    }

    private boolean fullRow(int startNumberRow){
        for (int column = 0; column < field.getRows(); column++){
            int numberBox = startNumberRow + column;
            if (!field.getValueBox(numberBox).equals(signPlayer)) return false;
        }
        return true;
    }

    private boolean isFullByColumn(){
        for (int column = 0; column < field.getRows(); column++){
            if (fullColumn(column)) {
                isWinner = true;
                return true;
            }
        }
        return false;
    }

    private boolean fullColumn(int startNumberColumn){
        for (int row = 0; row < field.getRows(); row++){
            int numberBox = startNumberColumn + row * field.getRows();
            if (!field.getValueBox(numberBox).equals(signPlayer)) return false;
        }
        return true;
    }

    private boolean isFullDiagonalLeftRight(){
        for (int diagonal = 0; diagonal < field.getRows(); diagonal++){
            int numberBox = diagonal * ((field.getSizeField()-1) / (field.getRows()-1));
            if (!field.getValueBox(numberBox).equals(signPlayer)) return false;
        }
        return true;
    }

    private boolean isFullDiagonalRightLeft(){
        for (int diagonal = field.getRows()-1; diagonal >= 0; diagonal--){
            int numberBox = (field.getRows()-1) * (field.getRows()-diagonal);
            if (!field.getValueBox(numberBox).equals(signPlayer)) return false;
        }
        return true;
    }
}
