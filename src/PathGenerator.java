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
        int[][] rewards = blankRewards;

        rewards[0][9] = Rewards.WIN_REWARD;

        for (int i = 0; i < 10; i++) {
            rewards[1][i] = Rewards.VALID_STEP_REWARD;
            rewards[9][i] = Rewards.VALID_STEP_REWARD;
        }

        for (int i = 2; i < 10; i++)
            rewards[i][0] = Rewards.VALID_STEP_REWARD;

        rewards[7][1] = Rewards.VALID_STEP_REWARD;
        rewards[7][2] = Rewards.VALID_STEP_REWARD;
        rewards[7][3] = Rewards.VALID_STEP_REWARD;

        for (int i = 3; i < 7; i++)
            rewards[i][2] = Rewards.VALID_STEP_REWARD;

        rewards[3][3] = Rewards.VALID_STEP_REWARD;

        rewards[6][3] = Rewards.VALID_STEP_REWARD;
        rewards[6][4] = Rewards.VALID_STEP_REWARD;

        rewards[5][4] = Rewards.VALID_STEP_REWARD;
        rewards[5][5] = Rewards.VALID_STEP_REWARD;
        ;

        for (int i = 5; i < 10; i++)
            rewards[4][i] = Rewards.VALID_STEP_REWARD;

        rewards[5][9] = Rewards.VALID_STEP_REWARD;

        rewards[3][6] = Rewards.VALID_STEP_REWARD;
        rewards[3][7] = Rewards.VALID_STEP_REWARD;

        rewards[2][7] = Rewards.VALID_STEP_REWARD;

        Helpers.print2DIntArray(rewards);
    }

    public static void hard(int[][] blankRewards) {
    }
}
