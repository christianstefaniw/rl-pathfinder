import java.util.ArrayList;
import java.util.Random;

public class Helpers {
    public static Random rand = new Random();

    public static void fill2DIntArray(int[][] array, int value) {
        for (int i = 0; i < array.length; i++)
            for (int k = 0; k < array[i].length; k++)
                array[i][k] = value;
    }

    public static void print2DIntArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println();

            for (int k = 0; k < array[i].length; k++) {
                System.out.print(array[i][k] + " ");
            }
        }

        System.out.println();
    }

    public static void printShortestPath(ArrayList<Position> shortestPath) {
        for (int i = 0; i < shortestPath.size(); i++) {
            System.out.printf("\nstep %s\n", i);
            System.out.println(shortestPath.get(i));
        }
    }

    public static void printQValues(double[][][] qTable) {
        for (int i = 0; i < qTable.length; i++) {
            for (int k = 0; k < qTable[i].length; k++) {
                System.out.printf("Q Values for row: %s, col %s\n", i, k);
                for (int h = 0; h < qTable[i][k].length; h++)
                    System.out.printf("%s: %s\n", h, qTable[i][k][h]);

                System.out.print("\n\n");
            }
        }

    }
}
