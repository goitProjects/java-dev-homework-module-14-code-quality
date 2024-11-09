package goit.tic_tac_toe;

public class Field {
    private final int rows;
    private final int sizeField;
    private final String[] boxes;
    private boolean isFullField = false;

    public Field(int sizeFieldOn) {
        this.rows = sizeFieldOn;
        this.sizeField = sizeFieldOn * sizeFieldOn;
        this.boxes = new String[sizeFieldOn * sizeFieldOn];
        createField();
    }

    public String getValueBox(int index) {
        return boxes[index];
    }

    public void setValueBox(int index, String signPlayer) {
        this.boxes[index] = signPlayer;
        isFullField();
    }

    public int getSizeField() {
        return sizeField;
    }

    public int getRows() {
        return rows;
    }

    private void createField(){
        int endNumberInRow = 0;
        for (int row = 0; row < rows; row++){
            for (int column = 0; column < rows; column++){
                int numberBox = endNumberInRow + column;
                boxes[numberBox] = "" + (numberBox+1);
            }
            endNumberInRow += rows;
        }
    }

    public void viewField(){
        int startNumberRow = 0;
        for (int row = 0; row < rows; row++){
            viewRow(startNumberRow);
            startNumberRow += rows;
            if (row < rows-1){
                System.out.println("-----------");
            }
        }
    }

    private void viewRow(int startNumberRow){
        int numberBox = startNumberRow;
        System.out.print(" " + boxes[numberBox]);
        for (int column = 1; column < rows -1; column++){
            numberBox = startNumberRow + column;
            System.out.print(" | " + boxes[numberBox] + " | ");
        }
        System.out.println(boxes[numberBox+1] + " ");

    }

    public void clearField(){
        for(int i = 0; i < 9; i++)
            boxes[i] = " ";
    }

    public boolean isGameOver(Player player1, Player player2){
        if(player1.isWinner){
            System.out.println("You won the game!\nCreated by Shreya's Sahi. Thanks for playing!");
            return true;
        } else if(player2.isWinner){
            System.out.println("You lost the game!\nCreated by Shreya's Sahi. Thanks for playing!");
            return true;
        } else if(isFullField){
            System.out.println("It's a draw!\nCreated by Shreya's Sahi. Thanks for playing!");
            return true;
        }
        return false;
    }

    private void isFullField(){
        for(int i=0; i<sizeField; i++){
            if(boxes[i].equals(" ")){
                return;
            }
        }
        isFullField = true;
    }
}
