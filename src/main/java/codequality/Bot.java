package codequality;

import java.util.Random;

public class Bot {
    private static final Random random = new Random();
    private final Board board;

    public Bot(Board board) {
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
