import java.util.Arrays;

public class Rewards {
    public static final int LOSE_REWARD = -100, WIN_REWARD = 100, VALID_STEP_REWARD = -1;

    private int[][] rewards = new int[Environment.numRows][Environment.numCols];
    private PathDifficulty difficulty;

    public Rewards(PathDifficulty difficulty) {
        this.difficulty = difficulty;
        Helpers.fill2DIntArray(rewards, LOSE_REWARD);
        genPath();
    }

    private void genPath() {
        switch (difficulty) {
        case EASY:
            PathGenerator.easy(rewards);
        case MEDIUM:
            PathGenerator.medium(rewards);
        case HARD:
            PathGenerator.hard(rewards);
        }
    }

    public PathDifficulty getPathDifficulty() {
        return difficulty;
    }

    public boolean isInTerminalState(Position pos) {
        return rewards[pos.getRow()][pos.getCol()] == -100 || rewards[pos.getRow()][pos.getCol()] == 100 ? true : false;
    }

    public int getRewardAtState(Position state) {
        return rewards[state.getRow()][state.getCol()];
    }

    public int[][] deepCopy() {
        return Arrays.stream(rewards).map(int[]::clone).toArray(int[][]::new);
    }
}
