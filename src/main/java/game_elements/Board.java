package game_elements;

import game.Game;
import java.util.logging.Logger;

public class Board {
    private char[] box;
    Logger log = Logger.getLogger(getClass().getName());

    public Board() {
        box = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }
    public void displayBoard(){
        for (int i = 0; i < box.length; i += 3) {
            String row = String.format(" %s | %s | %s ", box[i], box[i + 1], box[i + 2]);
            log.info(row);
            if (i <= 3) {
                log.info("\n-----------");
            }
        }
        log.info("\n");
    }
    public void clearBoard() {
        for(int i = 0; i < 9; ++i){
            box[i] = ' ';
        }
    }
    public boolean isCellFree(int moveIndex){
        return box[moveIndex] != Game.PLAYER_X && box[moveIndex] != Game.PLAYER_O;
    }
    public void fillCell(int index, char player){
        box[index] = player;
    }
    public boolean boxIsFull() {
        for(int i = 0; i < 9; i++){
            if(isCellFree(i)){
                return false;
            }
        }
        return true;
    }
    public boolean checkIfSomeoneWon(char player) {
        return checkRow(player, 0, 1, 2)
                || checkRow(player, 3, 4, 5)
                || checkRow(player, 6, 7, 8)

                || checkRow(player, 0, 3, 6)
                || checkRow(player, 1, 4, 7)
                || checkRow(player, 2, 5, 8)

                || checkRow(player, 0, 4, 8)
                || checkRow(player, 2, 4, 6);
    }
    private boolean checkRow(char player, int index1, int index2, int index3) {
        return box[index1] == player && box[index2] == player && box[index3] == player;
    }
}
