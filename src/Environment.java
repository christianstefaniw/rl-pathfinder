import java.util.ArrayList;

public final class Environment {
    public static int numRows = 10, numCols = 10;
    public Rewards rewards;
    public Position state;
    public QValues qValues = new QValues();

    public Environment(Rewards rewards, Position state) {
        this.rewards = rewards;
        this.state = state;
    }

    public Environment() {

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

    public Position updatedState(int actionIndex) {
        Position newState = new Position(state.getRow(), state.getCol());

        switch (Actions.allActions[actionIndex]) {
        case UP:
            newState.setRow(state.getRow() - 1);
            break;
        case DOWN:
            newState.setRow(state.getRow() + 1);
            break;
        case RIGHT:
            newState.setCol(state.getCol() + 1);
            break;
        case LEFT:
            newState.setCol(state.getCol() - 1);
            break;
        }
        return newState;
    }

    public ArrayList<int[]> getShortestPath(Position startPos) {
        state = startPos;
        if (isInTerminalState())
            return new ArrayList<int[]>();

        ArrayList<int[]> shortestPath = new ArrayList<int[]>();
        shortestPath.add(state.asList());
        System.out.println(state);

        while (!isInTerminalState()) {
            int actionIndex = getNextAction(0.);
            Position newPos = updatedState(actionIndex);
            System.out.println(newPos);
            shortestPath.add(newPos.asList());
            state = newPos;
        }

        return shortestPath;
    }
}
