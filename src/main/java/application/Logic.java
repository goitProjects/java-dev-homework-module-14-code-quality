package application;

public class Logic {

    public static byte winnerSelector(Box box) {
        byte aiIsWinner = lineInspector(box, 'O');
        byte playerIsWinner = lineInspector(box, 'X');
        if(playerIsWinner != 1) {
            if (aiIsWinner == 2) {
                return aiIsWinner;
            }
            return 0;
        }
        return playerIsWinner;

    }
    private static byte lineInspector(Box box, char playersSymbol) {
        char[] boxArray = box.getBoxArray();
        if((boxArray[0]==boxArray[1] && boxArray[1] == boxArray[2] && boxArray[2] == playersSymbol)
                || (boxArray[3] == boxArray[4] && boxArray[4] == boxArray[5] && boxArray[5]== playersSymbol)
                || (boxArray[6] == boxArray[7] && boxArray[7] == boxArray[8] && boxArray[8]== playersSymbol)
                || (boxArray[0] == boxArray[3] && boxArray[3] == boxArray[6] && boxArray[6]== playersSymbol)
                || (boxArray[1] == boxArray[4] && boxArray[4] == boxArray[7] && boxArray[7]== playersSymbol)
                || (boxArray[2] == boxArray[5] && boxArray[5] == boxArray[8] && boxArray[8]== playersSymbol)
                || (boxArray[0] == boxArray[4] && boxArray[4] == boxArray[8] && boxArray[8]== playersSymbol)
                || (boxArray[2] == boxArray[4] && boxArray[4] == boxArray[6] && boxArray[6]== playersSymbol)) {
            if(playersSymbol == 'X') {
                return 1;
            } else if(playersSymbol == 'O'){
                return 2;
            }
        }
        return  0;
    }

}
