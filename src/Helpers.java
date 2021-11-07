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

    public static int getIndexOfMaxValue(double[] array) {
        int maxAt = 0;

        for (int i = 0; i < array.length; i++) {
            maxAt = array[i] > array[maxAt] ? i : maxAt;
        }

        return maxAt;
    }

}
