package application;

import java.util.Scanner;

public class Logic {
    @SuppressWarnings("squid:S106")

    private static final int[] firstLine = new int[]{0, 1, 2};
    private static final int[] secondLine = new int[]{3, 4, 5};
    private static final int[] thirdLine = new int[]{6, 7, 8};
    private static final int[] firstColumn = new int[]{0, 3, 6};
    private static final int[] secondColumn = new int[]{1, 4, 7};
    private static final int[] thirdColumn = new int[]{2, 5, 8};
    private static final int[] firstDiagonal = new int[]{0, 4, 8};
    private static final int[] secondDiagonal = new int[]{2, 4, 6};

    private Logic() {

    }

    public static byte winnerSelector(Box box) {
        searchAvailableBox(box);
        char[] boxArray = box.getBoxArray();


        int[][] allTheLines = new int[][]{firstLine, secondLine, thirdLine, firstColumn, secondColumn, thirdColumn,
                firstDiagonal, secondDiagonal};
        for (int i = 0; i < 8; i++) {
            boolean isEquals = false;
            int j = 0;
            while (j < 2) {
                isEquals = boxArray[allTheLines[i][j]] == boxArray[allTheLines[i][j + 1]];
                if (!isEquals) {
                    break;
                }
                j++;
            }
            if (isEquals) {
                if (boxArray[allTheLines[i][j]] == 'X') {
                    return 1;
                } else if (boxArray[allTheLines[i][j]] == 'O') {
                    return 2;
                }
            }
        }
        if (!box.isBoxAvailable()) {
            return 3;
        }
        return 0;
    }

    public static void inputDigitValidation(Scanner scanner, Box box) {
        while (true) {
            byte input = scanner.nextByte();
            if (input > 0 && input < 10) {
                if (box.getBoxArray()[input - 1] != ' ')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box.getBoxArray()[input - 1] = 'X';
                    break;
                }
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }

    public static void searchAvailableBox(Box box) {
        box.setBoxAvailable(false);
        for (int i = 0; i < 9; i++) {
            if (box.getBoxArray()[i] == ' ') {
                box.setBoxAvailable(true);
                break;
            }
        }
    }

    public static void randomBoxChooser(Box box) {
        while (true) {
            byte rand = (byte) (Math.random() * 9 + 1);
            if (box.getBoxArray()[rand - 1] == ' ') {
                box.getBoxArray()[rand - 1] = 'O';
                break;
            }
        }
    }
}
