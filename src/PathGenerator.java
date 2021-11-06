public class PathGenerator {
    private final int winReward = 100, validStepReward = -300;

    public void easy(int[][] blankRewards) {
        int[][] rewards = blankRewards;

        rewards[0][1] = winReward;

        for (int i = 1; i < 9; i++)
            rewards[i][1] = validStepReward;

        for (int i = 1; i < 5; i++)
            rewards[2][i] = validStepReward;

        for (int i = 3; i < 9; i++)
            rewards[i][4] = validStepReward;

        for (int i = 1; i < 5; i++)
            rewards[8][i] = validStepReward;
    }

    public void medium(int[][] blankRewards) {
    }

    public void hard(int[][] blankRewards) {
    }
}
