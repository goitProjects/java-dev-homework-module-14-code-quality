package xogame;

public class GameInterface {
    private static boolean boxEmpty = false;

    private final char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    @SuppressWarnings("squid:S106")
    public void boxToDisplay() {


        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
        if (!boxEmpty) {
            for (int i = 0; i < box.length; i++) {
                box[i] = ' ';
            }
           boxEmpty = true;

        }

    }


    public boolean isBoxFull() {
        for (char b : box) {
            if (b != 'X' && b != '0') {
                return false;
            }
        }
        return true;
    }

    public boolean isBoxCellEmpty(int index) {
        return box[index] != 'X' && box[index] != '0';
    }

    public void setBoxCell(int index, char playerSymbol) {
        box[index] = playerSymbol;
    }

    public char[] getBox() {
        return box;
    }

    public boolean checkWinner(char symbol) {
        if ((box[0] == symbol && box[1] == symbol && box[2] == symbol) ||
                (box[3] == symbol && box[4] == symbol && box[5] == symbol) ||
                (box[6] == symbol && box[7] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[3] == symbol && box[6] == symbol) ||
                (box[1] == symbol && box[4] == symbol && box[7] == symbol) ||
                (box[2] == symbol && box[5] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[4] == symbol && box[8] == symbol) ||
                (box[2] == symbol && box[4] == symbol && box[6] == symbol)) {
            return true;
        }
        return false;
    }

}

