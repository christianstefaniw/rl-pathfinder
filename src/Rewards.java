public class Rewards {
    public PathDifficulty difficulty;

    private int[][] rewards = new int[Environment.numRows][Environment.numCols];
    private PathGenerator pathGenerator = new PathGenerator();
    private final int loseReward = -100;

    public Rewards(PathDifficulty difficulty) {
        this.difficulty = difficulty;
        Helpers.fill2DIntArray(rewards, loseReward);
        genPath();
    }

    private void genPath() {
        switch (difficulty) {
        case EASY:
            this.pathGenerator.easy(rewards);
        case MEDIUM:
            this.pathGenerator.medium(rewards);
        case HARD:
            this.pathGenerator.hard(rewards);
        }
    }

    public boolean isInTerminalState(int currRow, int currCol) {
        return rewards[currRow][currCol] == -100 ? true : false;
    }
}
