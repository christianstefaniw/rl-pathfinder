public class QValues {
    public double[][][] qTable;

    public QValues() {
        this.qTable = new double[Environment.numRows][Environment.numCols][Actions.allActions.length];
    }

    public int getIndexOfMaxQAtPos(Position pos) {
        double[] qValues = qTable[pos.getRow()][pos.getCol()];
        return getIndexOfMaxQ(qValues);
    }

    private int getIndexOfMaxQ(double[] qValues) {
        int maxAt = 0;

        for (int i = 0; i < qValues.length; i++) {
            maxAt = qValues[i] > qValues[maxAt] ? i : maxAt;
        }

        return maxAt;
    }
}
