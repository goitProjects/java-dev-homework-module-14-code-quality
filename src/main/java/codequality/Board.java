package codequality;

import java.util.Arrays;
import java.util.Optional;

public class Board {
    private static final String LINE_SEPARATOR = "-----------\n";

    private Character[] box;

    public Board() {
        this.box = new Character[9];
        Arrays.fill(box, ' ');
    }

    public void set(int index, char c) {
        box[index] = c;
    }

    public Optional<Character> getFirstEmptyItem() {
        return Arrays.stream(box).filter(c -> c != 'X' && c != 'O').findAny();
    }

    public boolean isItemUsed(int index) {
        return box[index] == 'X' || box [index] == 'O';
    }

    public boolean isBoxRowSet(int row, char c) {
        int index = row * 3;
        return box[index] == c && box[index + 1] == c && box[index + 2] == c;
    }

    public boolean isBoxColumnSet(int col, char c) {
        return box[col] == c && box[col + 3] == c && box[col + 6] == c;
    }

    public boolean isBoxDiagonalSet(char c) {
        return (box[0] == c && box[4] == c && box[8] == c) || (box[2] == c && box[4] == c && box[6] == c);
    }

    @Override
    public String toString() {
        // Too many concatenations waste memory for strings, so use StringBuilder instead
        // I don't use StringBuffer here as this code doesn't use threads.
        StringBuilder builder = new StringBuilder();
        builder.append("\n\n ").append(box[0]).append(" | ").append(box[1]).append(" | ").append(box[2]).append(" \n");
        builder.append(LINE_SEPARATOR);
        builder.append(" ").append(box[3]).append(" | ").append(box[4]).append(" | ").append(box[5]).append(" \n");
        builder.append(LINE_SEPARATOR);
        builder.append(" ").append(box[6]).append(" | ").append(box[7]).append(" | ").append(box[8]).append(" \n");
        return builder.toString();
    }
}
