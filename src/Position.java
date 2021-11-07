public class Position {
    private int row, col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position() {
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int[] asList() {
        int[] posAsList = { row, col };
        return posAsList;
    }

    public Position copy() {
        return new Position(row, col);
    }

    public String toString() {
        return String.format("row: " + row + " col: " + col);
    }
}
