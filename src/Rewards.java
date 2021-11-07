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

    public boolean isInTerminalState(Position pos) {
        return rewards[pos.getRow()][pos.getCol()] == -100 || rewards[pos.getRow()][pos.getCol()] == 100 ? true : false;
    }

    public int getRewardAtCoords(int row, int col) {
        return rewards[row][col];
    }
}
