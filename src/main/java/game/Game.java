package game;

import game_elements.Board;
import constants.MessageConstants;

import java.util.Scanner;
import java.util.logging.Logger;

public class Game {
    Logger log = Logger.getLogger(getClass().getName());
    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = 'O';
    private boolean boxIsEmpty = false;
    private final Board board = new Board();
    public void startGame(Scanner scanner) {
        byte winner = 0;

        log.info(MessageConstants.ENTER_NUMBER);
        while (true) {
            board.displayBoard();

            if (!boxIsEmpty) {
                board.clearBoard();
                boxIsEmpty = true;
            }

            if (isGameEnded(winner)) {
                showWinner(winner);
                break;
            }

            winner = startRound(scanner);
        }
    }
    private byte startRound(Scanner scanner){
        byte winner;

        playerMakeMove(scanner);
        winner = findWinner(PLAYER_X);

        if (winner == 0) {
            if (!board.boxIsFull()) {
                computerMakeMove();
                winner = findWinner(PLAYER_O);
            } else {
                winner = 3;
            }
        }
        return winner;
    }
    private void showWinner(byte winner) {
        if(winner == 1) log.info(MessageConstants.WIN);
        else if(winner == 2) log.info(MessageConstants.LOSS);
        else log.info(MessageConstants.DRAW);
    }

    private void playerMakeMove(Scanner scanner){
        byte move;
        while (true) {
            log.info(MessageConstants.ENTER_MOVE);
            move = scanner.nextByte();
            if (move > 0 && move < 10) {
                if (board.isCellFree(move - 1)) {
                    board.fillCell(move - 1, PLAYER_X);
                    break;
                }
                else {
                    log.info(MessageConstants.CHOOSE_ANOTHER_CELL);
                }
            }
            else
                log.info(MessageConstants.INVALID_INPUT);
        }
    }
    private void computerMakeMove(){
        byte random;
        while (true) {
            random = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (board.isCellFree(random - 1)) {
                board.fillCell(random - 1, PLAYER_O);
                break;
            }
        }
    }
    private byte findWinner(char player) {
        if (board.checkIfSomeoneWon(player)) {
            if (player == PLAYER_X) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }
    private boolean isGameEnded(byte winner){
        return winner == 1 || winner == 2 || winner == 3;
    }
}
