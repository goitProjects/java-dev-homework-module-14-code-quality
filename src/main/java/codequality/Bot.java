package codequality;

import java.util.Random;

public class Bot {
    private final Random random;
    private Board board;

    public Bot(Board board) {
        this.random = new Random();
        this.board = board;
    }

    public void doTurn() {
        int index;
        while (true) {
            index = random.nextInt(9);
            if (!board.isItemUsed(index)) {
                board.set(index, 'O');
                break;
            }
        }
    }
}
