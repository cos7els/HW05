import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Tasks {
    public static Scanner in = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        //taskOne();
        //taskTwo();
        //taskThree();
        //taskFour();
        //taskFive();
        //taskSix();
        //taskSeven();
        //taskEight();
        //taskNine();
        //taskTen();
        //taskEleven();
        //taskTwelve();
        //taskThirteen();
        chess();
    }

    public static void chess() {
        System.out.print("Enter the name of figure (king, queen, bishop, rook, knight): ");
        String figure = in.nextLine().trim();
        System.out.printf("Enter the line of %s's position: ", figure);
        int line = in.nextInt();
        System.out.printf("Enter the column of %s's position: ", figure);
        int column = in.nextInt();
        String[][] chessDesk = new String[8][8];
        for (int i = 0; i < chessDesk.length; i++) {
            for (int j = 0; j < chessDesk[i].length; j++) {
                chessDesk[i][j] = "_";
                if (i == line && j == column) {
                    chessDesk[i][j] = "H";
                }
            }
        }
        if (figure.equalsIgnoreCase("knight")) {
            for (int i = 0; i < chessDesk.length; i++) {
                for (int j = 0; j < chessDesk[i].length; j++) {
                    if ((line - 2) == i && (column - 1) == j || (line - 2) == i && (column + 1) == j ||
                            (line + 2) == i && (column - 1) == j || (line + 2) == i && (column + 1) == j ||
                            (column - 2) == j && (line + 1) == i || (column - 2) == j && (line - 1) == i ||
                            (column + 2) == j && (line + 1) == i || (column + 2) == j && (line - 1) == i) {
                        chessDesk[i][j] = "X";
                    }
                }
            }
        } else if (figure.equalsIgnoreCase("rook")) {
            for (int i = 0; i < chessDesk.length; i++) {
                for (int j = 0; j < chessDesk[i].length; j++) {
                    if (column == j && i != line || line == i && j != column) {
                        chessDesk[i][j] = "X";
                    }
                }
            }
        } else if (figure.equalsIgnoreCase("bishop")) {
            int c = column;
            int l = line;
            while (c-- > 0 && l-- > 0) {
                chessDesk[l][c] = "X";
            }
            c = column;
            l = line;
            while (++c < chessDesk.length && ++l < chessDesk.length) {
                chessDesk[l][c] = "X";
            }
            c = column;
            l = line;
            while (++c < chessDesk.length && --l >= 0) {
                chessDesk[l][c] = "X";
            }
            c = column;
            l = line;
            while (--c >= 0 && ++l <= chessDesk.length) {
                chessDesk[l][c] = "X";
            }
        } else if (figure.equalsIgnoreCase("queen")) {
            int c = column;
            int l = line;
            while (c-- > 0 && l-- > 0) {
                chessDesk[l][c] = "X";
            }
            c = column;
            l = line;
            while (++c < chessDesk.length && ++l < chessDesk.length) {
                chessDesk[l][c] = "X";
            }
            c = column;
            l = line;
            while (++c < chessDesk.length && --l >= 0) {
                chessDesk[l][c] = "X";
            }
            c = column;
            l = line;
            while (--c >= 0 && ++l <= chessDesk.length) {
                chessDesk[l][c] = "X";
            }
            for (int i = 0; i < chessDesk.length; i++) {
                for (int j = 0; j < chessDesk[i].length; j++) {
                    if (column == j && i != line || line == i && j != column) {
                        chessDesk[i][j] = "X";
                    }
                }
            }
        } else if (figure.equalsIgnoreCase("king")) {
            for (int i = 0; i < chessDesk.length; i++) {
                for (int j = 0; j < chessDesk[i].length; j++) {
                    if ((line + 1) == i && (column + 1) == j || (line - 1) == i && (column - 1) == j ||
                            (line + 1) == j && (column - 1) == i || (line - 1) == j && (column + 1) == i ||
                            (line + 1) == i && column == j || (line - 1) == i && column == j ||
                            (column + 1) == j && line == i || (column - 1) == j && line == i) {
                        chessDesk[i][j] = "X";
                    }
                }
            }
        }
        for (String[] i : chessDesk) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void taskThirteen() {
        int[][] array = initialArray(7, 4);
        int maxElement = Integer.MIN_VALUE;
        String lineMaxElement = "";
        String columnMaxElement = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (maxElement < array[i][j]) {
                    maxElement = array[i][j];
                    lineMaxElement = String.valueOf(i);
                    columnMaxElement = String.valueOf(j);
                } else if (maxElement == array[i][j]) {
                    lineMaxElement += ", " + i;
                    columnMaxElement += ", " + j;
                }
            }
        }
        System.out.printf("The max element of array: %d, \nline(s): %s, \ncolumn(s): %s.\n", maxElement, lineMaxElement,
                columnMaxElement);
    }

    public static void taskTwelve() {
        int[][] array = initialArray(5, 5);
        int sumDiagonalElements = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    sumDiagonalElements += array[i][j];
                    break;
                }
            }
        }
        System.out.printf("The sum of diagonal elements array: %d.\n", sumDiagonalElements);
    }

    public static void taskEleven() {
        int[][] array = initialArray(4, 8);
        int sumEvenElements = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] % 2 == 0) {
                    sumEvenElements += array[i][j];
                }
            }
        }
        System.out.printf("The sum of even elements array: %d.\n", sumEvenElements);
    }

    public static void taskTen() {
        int[][] array = initialArray(4, 6);
        int maxSum = 0;
        String maxIndex = "";
        int currentSum = 0;
        int i = 0;
        int j = 0;
        for (j = 0; j < array[i].length; j++) {
            for (i = 0; i < array.length; i++) {
                currentSum += array[i][j];
            }
            if (maxSum < currentSum) {
                maxSum = currentSum;
                maxIndex = String.valueOf(j);
            } else if (maxSum == currentSum) {
                maxIndex += ", " + j;
            }
            currentSum = 0;
            i = 0;
        }
        System.out.printf("The max sum: %d in column: %s.\n", maxSum, maxIndex);
    }

    public static void taskNine() {
        int[][] array = initialArray(4, 6);
        int maxSum = 0;
        int maxIndex = 0;
        int currentSum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j : array[i]) {
                currentSum += j;
            }
            if (maxSum < currentSum) {
                maxSum = currentSum;
                maxIndex = i;
            }
            currentSum = 0;
        }
        System.out.printf("The max sum: %d in line: %d.\n", maxSum, maxIndex);
    }

    public static void taskEight() {
        //int[][] array = initialArray(5, 5);
        int[][] array = {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 6}};
        System.out.println("Initialized array: ");
        printArray(array);
        for (int i = 0; i < array.length; i++) {
            swap(array, i, 0, array[i].length - 1);
        }
        System.out.println("Current array: ");
        printArray(array);
    }

    public static void taskSeven() {
        //int[][] array = initialArray(5, 5);
        int[][] array = {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 6}};
        System.out.println("Initialized array: ");
        printArray(array);
        int[] temp = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = temp;
        System.out.println("Current array: ");
        printArray(array);
    }

    public static void taskSix() {
        int[][] array = initialArray(5, 5);
        for (int i = 0; i < array.length; i++) {
            for (int j = array[i].length - 1; j > 0; j--) {
                for (int k = 0; k < j; k++) {
                    if (array[i][k] > array[i][k + 1]) {
                        swap(array, i, k, k + 1);
                    }
                }
            }
        }
        System.out.println("Current array: ");
        printArray(array);
    }

    public static void swap(int[][] array, int line, int curPosition, int newPosition) {
        int temp = array[line][curPosition];
        array[line][curPosition] = array[line][newPosition];
        array[line][newPosition] = temp;
    }

    public static void taskFive() {
        int[][] array = initialArray(5, 5);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i + j == array.length - 1) {
                    System.out.print(array[i][j] + "  ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    public static void taskFour() {
        int[][] array = initialArray(5, 5);
        int sum = 0;
        for (int[] i : array) {
            for (int j : i) {
                sum += j;
            }
        }
        System.out.printf("The sum of array elements: %d.\n", sum);
    }

    public static void taskThree() {
        //int[][] arrayFirst = initialArray(3, 3);
        //int[][] arraySecond = initialArray(3, 3);
        int[][] arrayFirst = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}};
        int[][] arraySecond = {{1, 2, 3}, {1, 1, 1}, {0, 0, 0}, {2, 1, 0}};
        int[][] result = new int[arrayFirst.length][arraySecond[0].length];
        for (int k = 0; k < result.length; k++) {
            for (int i = 0; i < result[k].length; i++) {
                for (int j = 0; j < arraySecond.length; j++) {
                    result[k][i] += arrayFirst[k][j] * arraySecond[j][i];
                }
            }
        }
        System.out.println("Result array: ");
        printArray(result);
    }

    public static void taskTwo() {
        String[][] chessDesk = new String[8][8];
        for (int i = 0; i < chessDesk.length; i++) {
            for (int j = 0; j < chessDesk[i].length; j++) {
                chessDesk[i][j] = i % 2 == 0 ? j % 2 == 0 ? "W" : "B" : j % 2 == 0 ? "B" : "W";
            }
        }
        for (String[] i : chessDesk) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void taskOne() {
        System.out.print("Enter the size of array: ");
        int size = in.nextInt();
        System.out.print("Enter the value for increase elements: ");
        int value = in.nextInt();
        int array[][][] = new int[size][size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    array[i][j][k] = random.nextInt(10);
                }
            }
        }
        System.out.println("Origin array: ");
        for (int[][] i : array) {
            for (int[] j : i) {
                System.out.print(Arrays.toString(j));
            }
            System.out.println();
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    array[i][j][k] *= value;
                }
            }
        }
        System.out.println("Increased array: ");
        for (int[][] i : array) {
            for (int[] j : i) {
                System.out.print(Arrays.toString(j));
            }
            System.out.println();
        }
    }

    public static int[][] initialArray(int lines, int columns) {
        int[][] array = new int[lines][columns];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(10);
            }
        }
        System.out.println("Initialized array: ");
        printArray(array);
        return array;
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

}