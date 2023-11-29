package application;

public class Box {
    private char[] boxArray =  { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    private boolean boxAvailable = false;
    private byte winner = 0;

    public char[] getBoxArray() {
        return boxArray;
    }

    public void setBoxArray(char[] boxArray) {
        this.boxArray = boxArray;
    }

    public boolean isBoxAvailable() {
        return boxAvailable;
    }

    public byte getWinner() {
        return winner;
    }

    public void setWinner(byte winner) {
        this.winner = winner;
    }

    public void setBoxAvailable(boolean boxAvailable) {
        this.boxAvailable = boxAvailable;
    }

    public void cleanTheBox() {
        boxArray = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

    }
}
