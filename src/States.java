public class States {
    private int[][][] qValues;

    public States() {
        this.qValues = new int[Environment.numRows][Environment.numCols][Actions.allActions.length];
    }
}
