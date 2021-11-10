import java.util.Arrays;

public class QValues {
    private double[][][] qTable;

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

    public double getMaxQAtPos(Position state) {
        return Arrays.stream(qTable[state.getRow()][state.getCol()]).max().getAsDouble();
    }

    public double getQValue(Position state, int actionIndex) {
        return qTable[state.getRow()][state.getCol()][actionIndex];
    }

    public void setQValue(Position state, int actionIndex, double qValue) {
        qTable[state.getRow()][state.getCol()][actionIndex] = qValue;
    }
}
