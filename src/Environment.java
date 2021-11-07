import java.util.ArrayList;

public class Environment {
    public static int numRows = 10, numCols = 10;
    public Rewards rewards;
    public QValues qValues = new QValues();

    private Position state;

    public Environment(Rewards rewards, Position state) {
        this.rewards = rewards;
        this.state = state;
    }

    public Environment() {

    }

    public void setState(Position state) {
        this.state = state;
    }

    public int getCurrRow() {
        return this.state.getRow();
    }

    public int getCurrCol() {
        return this.state.getCol();
    }

    public Position getStartingPosition() {
        Position pos = new Position(Helpers.rand.nextInt(Environment.numRows),
                Helpers.rand.nextInt(Environment.numCols));

        while (rewards.isInTerminalState(pos)) {
            pos.setRow(Helpers.rand.nextInt(Environment.numRows));
            pos.setCol(Helpers.rand.nextInt(Environment.numCols));
        }

        return pos;
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
        switch (Actions.allActions[actionIndex]) {
        case UP:
            state.setRow(state.getRow() - 1);
            break;
        case DOWN:
            state.setRow(state.getRow() + 1);
            break;
        case RIGHT:
            state.setCol(state.getCol() + 1);
            break;
        case LEFT:
            state.setCol(state.getCol() - 1);
            break;
        }
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
