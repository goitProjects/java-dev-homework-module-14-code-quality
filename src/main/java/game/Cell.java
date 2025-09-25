package game;

public enum Cell {
    X("X"),
    O("O"),
    EMPTY(" ");

    private final String symbol;

    Cell(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
