public class QValues {
    public double[][][] qTable;

    public QValues() {
        this.qTable = new double[Environment.numRows][Environment.numCols][Actions.allActions.length];
    }

    public int getIndexOfMaxQAtPos(Position pos) {
        double[] qValues = qTable[pos.getRow()][pos.getCol()];
        return Helpers.getIndexOfMaxValue(qValues);
    }
}
