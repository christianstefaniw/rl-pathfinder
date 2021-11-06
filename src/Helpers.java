public class Helpers {
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
}
