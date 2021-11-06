public class QValues {
    private int[][][] qValues;

    public QValues() {
        this.qValues = new int[Environment.numRows][Environment.numCols][Actions.allActions.length];
    }
}
