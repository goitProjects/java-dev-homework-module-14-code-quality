package rewriteTheCode;


public class CheckTheGame  {
     public static void CheckingForGame(){

         while (true) {
             System.out.println("\n\n " + App.box[0] + " | " + App.box[1] + " | " + App.box[2] + " ");
             System.out.println("-----------");
             System.out.println(" " + App.box[3] + " | " + App.box[4] + " | " + App.box[5] + " ");
             System.out.println("-----------");
             System.out.println(" " + App.box[6] + " | " + App.box[7] + " | " + App.box[8] + " \n");

             if(App.boxEmpty == false){
                 for(App.i = 0; App.i < 9; App.i++)
                     App.box[App.i] = ' ';
                 App.boxEmpty = true;
             }

             if(App.winner == 1){
                 System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                 break;
             } else if(App.winner == 2){
                 System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                 break;
             } else if(App.winner == 3){
                 System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                 break;
             }

             while (true) {
                 App.input = App.scan.nextByte();
                 if (App.input > 0 && App.input < 10) {
                     if (App.box[App.input - 1] == 'X' || App.box[App.input - 1] == 'O')
                         System.out.println("That one is already in use. Enter another.");
                     else {
                         App.box[App.input - 1] = 'X';
                         break;
                     }
                 }
                 else
                     System.out.println("Invalid input. Enter again.");
             }

             if((App.box[0]=='X' && App.box[1]=='X' && App.box[2]=='X') || (App.box[3]=='X' && App.box[4]=='X' && App.box[5]=='X') || (App.box[6]=='X' && App.box[7]=='X' && App.box[8]=='X') ||
                     (App.box[0]=='X' && App.box[3]=='X' && App.box[6]=='X') || (App.box[1]=='X' && App.box[4]=='X' && App.box[7]=='X') || (App.box[2]=='X' && App.box[5]=='X' && App.box[8]=='X') ||
                     (App.box[0]=='X' && App.box[4]=='X' && App.box[8]=='X') || (App.box[2]=='X' && App.box[4]=='X' && App.box[6]=='X')){
                 App.winner = 1;
             }

             App.boxAvailable = false;
             for(App.i=0; App.i<9; App.i++){
                 if(App.box[App.i] != 'X' && App.box[App.i] != 'O'){
                     App.boxAvailable = true;
                     break;
                 }
             }

             if(!App.boxAvailable ){
                 App.winner = 3;
             }

             while (true) {
                 App.rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                 if (App.box[App.rand - 1] != 'X' && App.box[App.rand - 1] != 'O') {
                     App.box[App.rand - 1] = 'O';
                     break;
                 }
             }

             if((App.box[0]=='O' && App.box[1]=='O' && App.box[2]=='O') || (App.box[3]=='O' && App.box[4]=='O' && App.box[5]=='O') || (App.box[6]=='O' && App.box[7]=='O' && App.box[8]=='O') ||
                     (App.box[0]=='O' && App.box[3]=='O' && App.box[6]=='O') || (App.box[1]=='O' && App.box[4]=='O' && App.box[7]=='O') || (App.box[2]=='O' && App.box[5]=='O' && App.box[8]=='O') ||
                     (App.box[0]=='O' && App.box[4]=='O' && App.box[8]=='O') || (App.box[2]=='O' && App.box[4]=='O' && App.box[6]=='O')){
                 App.winner = 2;
             }
         }
     }
}
