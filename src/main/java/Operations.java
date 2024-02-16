public class Operations {

    private final char[] box;

    public Operations(char[] box) {
        this.box = box;
    }

    //print out the box with cells numbers
    public void printBox() {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " "
                + "\n-----------"
                + "\n " + box[3] + " | " + box[4] + " | " + box[5] + " "
                + "\n-----------"
                + "\n " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    boolean printResult(byte winner) {
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        return false;
    }

    //search for the winner
    public boolean isWinner(char[] box, char player) {
        return (box[0] == player && box[1] == player && box[2] == player) || (box[3] == player && box[4] == player && box[5] == player) || (box[6] == player && box[7] == player && box[8] == player) ||
                (box[0] == player && box[3] == player && box[6] == player) || (box[1] == player && box[4] == player && box[7] == player) || (box[2] == player && box[5] == player && box[8] == player) ||
                (box[0] == player && box[4] == player && box[8] == player) || (box[2] == player && box[4] == player && box[6] == player);
    }

    public void setRandomCell() {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * 9 + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }
}
