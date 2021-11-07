public class PathGenerator {
    public static void easy(int[][] blankRewards) {
        int[][] rewards = blankRewards;

        rewards[0][1] = Rewards.WIN_REWARD;

        for (int i = 1; i < 9; i++)
            rewards[i][1] = Rewards.VALID_STEP_REWARD;

        for (int i = 1; i < 5; i++)
            rewards[2][i] = Rewards.VALID_STEP_REWARD;

        for (int i = 3; i < 9; i++)
            rewards[i][4] = Rewards.VALID_STEP_REWARD;

        for (int i = 1; i < 5; i++)
            rewards[8][i] = Rewards.VALID_STEP_REWARD;

        Helpers.print2DIntArray(rewards);
    }

    public static void medium(int[][] blankRewards) {
    }

    public static void hard(int[][] blankRewards) {
    }
}
