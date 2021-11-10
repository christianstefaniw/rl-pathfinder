import java.util.ArrayList;

public class Environment {
    public static int numRows = 10, numCols = 10;

    private Position state;
    private Rewards rewards;
    private QValues qValues = new QValues();

    public Environment(Rewards rewards) {
        this.rewards = rewards;
    }

    public int getCurrRow() {
        return this.state.getRow();
    }

    public int getCurrCol() {
        return this.state.getCol();
    }

    public Position getState() {
        return state.copy();
    }

    public Rewards getRewards() {
        return rewards;
    }

    public QValues getQValues() {
        return qValues;
    }

    public double getMaxQAtCurrState() {
        return qValues.getMaxQAtPos(state);
    }

    public void putInRandStartingPosition() {
        Position pos = new Position(Helpers.rand.nextInt(Environment.numRows),
                Helpers.rand.nextInt(Environment.numCols));

        while (rewards.isInTerminalState(pos)) {
            pos.setRow(Helpers.rand.nextInt(Environment.numRows));
            pos.setCol(Helpers.rand.nextInt(Environment.numCols));
        }

        state = pos;
    }

    public boolean isInTerminalState() {
        return this.rewards.isInTerminalState(state);
    }

    // epsilon greedy algorithm
    public int getNextAction(double epsilon) {
        if (Math.random() > epsilon)
            return qValues.getIndexOfMaxQAtPos(state);

        return Helpers.rand.nextInt(4);
    }

    public void updateState(int actionIndex) {
        ActionType action = Actions.allActions[actionIndex];

        if (action == ActionType.UP && state.getRow() > 0)
            state.setRow(state.getRow() - 1);
        else if (action == ActionType.RIGHT && state.getCol() < numCols - 1)
            state.setCol(state.getCol() + 1);
        else if (action == ActionType.DOWN && state.getRow() < numRows - 1)
            state.setRow(state.getRow() + 1);
        else if (action == ActionType.LEFT && state.getCol() > 0)
            state.setCol(state.getCol() - 1);
    }

    public ArrayList<Position> getShortestPath(Position startPos) {
        state = startPos;

        if (isInTerminalState())
            return new ArrayList<Position>();

        ArrayList<Position> shortestPath = new ArrayList<Position>();
        shortestPath.add(startPos);

        while (!isInTerminalState()) {
            int actionIndex = getNextAction(0.);
            updateState(actionIndex);
            shortestPath.add(state.copy());
        }

        return shortestPath;
    }
}
