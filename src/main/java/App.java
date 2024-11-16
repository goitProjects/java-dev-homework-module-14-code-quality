import java.util.Scanner;

public class App {
    private char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    private boolean boxAvailable = false;
    private boolean boxEmpty = false;

    public static void main(String[] args) {
        App app = new App();
        app.startGame();
    }

    public void printBox(){
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " " +
                "\n-----------\n "
                + box[3] + " | " + box[4] + " | " + box[5] + " " +
                "\n-----------\n" +
                " " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    public void checkBoxAvalability(){
        boxAvailable = false;
        for(int i=0; i<9; i++){
            if(box[i] != 'X' && box[i] != 'O'){
                boxAvailable = true;
                break;
            }
        }
    }

    public void setBoxEmpty(){
        if(!boxEmpty){
            for(int i = 0; i < 9; i++)
                box[i] = ' ';
            boxEmpty = true;
        }
    }

    public void player2(){
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    public void player1(Scanner scan){
        byte input;
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[input - 1] = 'X';
                    break;
                }
            }
            else
                System.out.println("Invalid input. Enter again.");
        }
    }

    public boolean winningCombination(char c){
        return (box[0]==c && box[1]==c && box[2]==c) || (box[3]==c && box[4]==c && box[5]==c) || (box[6]==c && box[7]==c && box[8]==c) ||
                (box[0]==c && box[3]==c && box[6]==c) || (box[1]==c && box[4]==c && box[7]==c) || (box[2]==c && box[5]==c && box[8]==c) ||
                (box[0]==c && box[4]==c && box[8]==c) || (box[2]==c && box[4]==c && box[6]==c);
    }

    public boolean checkWinner1(){
        if(winningCombination('X')){
            printBox();
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        return false;
    }

    public boolean checkWinner2(){
        if(winningCombination('O')){
            printBox();
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        return false;
    }

    public boolean checkDraw(){
        if(!boxAvailable){
            printBox();
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        return false;
    }

    public void startGame(){
        System.out.println("Enter box number to select. Enjoy!\n");
        Scanner scan = new Scanner(System.in);
        while (true) {
            printBox();
            setBoxEmpty();

            player1(scan);

            checkBoxAvalability();

            player2();
            if (checkWinner1() || checkWinner2() || checkDraw()) {
                break;
            }
        }
        scan.close();
    }
}