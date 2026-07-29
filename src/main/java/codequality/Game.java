package codequality;

import java.time.temporal.ValueRange;
import java.util.Scanner;
import java.util.logging.Logger;

import static codequality.State.STATE_CONTINUE;
import static codequality.State.STATE_WIN;
import static codequality.State.STATE_LOSE;
import static codequality.State.STATE_DRAW;

public class Game {
    private static final Logger logger = Logger.getLogger(Game.class.getName());
    private final Scanner scanner;
    private final Board board;
    private final Bot bot;
    private State state;

    private static final String CREDITS = "Created by Shreyas Saha. Thanks for playing!";
    private static final String[] END_MESSAGE = {
            "You won the game!",
            "You lost the game!",
            "It's a draw!"
    };

    public Game() {
        this.scanner = new Scanner(System.in);
        this.state = STATE_CONTINUE;
        this.board = new Board();
        this.bot = new Bot(board);
    }

    public void run() {
        int index;
        println("Enter box number to select. Enjoy!");
        println(board.toString());

        while (true) {
            index = nextIndex();

            // Merged two conditions into a single one
            // as at most one continue/break statement must be in a loop

            if (!ValueRange.of(0, 8).isValidIntValue(index) || board.isItemUsed(index)) {
                println("Invalid input or that one is already in use. Enter again.");
                continue;
            }

            board.set(index, 'X');

            // First check if there is no choice for the opponent's turn

            state = STATE_DRAW;
            if (board.getFirstEmptyItem().isPresent()) {
                state = STATE_CONTINUE;
            }

            setStateOnRow('X', STATE_WIN);
            if (state == STATE_CONTINUE) {
                bot.doTurn();
                setStateOnRow('O', STATE_LOSE);
            }

            println(board.toString());

            // Here the if-chain is changed by String[] indexing
            // as values are in range [1...3]:

            if (state != STATE_CONTINUE) {
                println(END_MESSAGE[state.ordinal()] + "\n" + CREDITS);
                return;
            }
        }
    }

    private void println(String msg) {
        logger.info(msg);
    }

    private int nextIndex() {
        while(true) {
            String input;
            try {
                input = scanner.next();
                return Integer.parseInt(input) - 1;
            } catch (NumberFormatException e) {
                println("Invalid input. Enter again.");
            }
        }
    }

    private void setStateOnRow(char c, State winner) {
        if(board.isBoxRowSet(0, c)
                || board.isBoxRowSet(1, c)
                || board.isBoxRowSet(2, c)
                || board.isBoxColumnSet(0, c)
                || board.isBoxColumnSet(1, c)
                || board.isBoxColumnSet(2, c)
                || board.isBoxDiagonalSet(c)
        ) {
            this.state = winner;
        }
    }
}
