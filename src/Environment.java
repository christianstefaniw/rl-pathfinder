import java.util.Random;

public final class Environment {
    public static int numRows = 10, numCols = 10;

    private Actions actions;
    private Rewards rewards;
    private Position state;

    public Environment(Actions actions, Rewards rewards, Position state) {
        this.actions = actions;
        this.rewards = rewards;
        this.state = state;
    }

    public Environment() {
        this.actions = new Actions();
        this.rewards = new Rewards(PathDifficulty.EASY);
        this.state = getStartingPosition();
    }

    public void setRewards(Rewards rewards) {
        this.rewards = rewards;
    }

    public void setState(Position states) {
        this.state = states;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }

    public Position getStartingPosition() {
        Random rand = new Random();

        int row = rand.nextInt(Environment.numRows), col = rand.nextInt(Environment.numCols);

        while (rewards.isInTerminalState(row, col)) {
            row = rand.nextInt(Environment.numRows);
            col = rand.nextInt(Environment.numCols);
        }

        return new Position(col, row);
    }
}
