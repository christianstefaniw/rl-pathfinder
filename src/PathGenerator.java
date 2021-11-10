public class PathGenerator {
    private static boolean debug = true;

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

        if (debug)
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

        for (int i = 5; i < 10; i++)
            rewards[4][i] = Rewards.VALID_STEP_REWARD;

        rewards[5][9] = Rewards.VALID_STEP_REWARD;

        rewards[3][6] = Rewards.VALID_STEP_REWARD;
        rewards[3][7] = Rewards.VALID_STEP_REWARD;

        rewards[2][7] = Rewards.VALID_STEP_REWARD;

        if (debug)
            Helpers.print2DIntArray(rewards);
    }

    public static void hard(int[][] blankRewards) {
        int[][] rewards = blankRewards;

        rewards[5][4] = Rewards.WIN_REWARD;

        rewards[0][0] = Rewards.VALID_STEP_REWARD;
        rewards[0][1] = Rewards.VALID_STEP_REWARD;
        rewards[1][1] = Rewards.VALID_STEP_REWARD;
        rewards[2][1] = Rewards.VALID_STEP_REWARD;
        rewards[2][2] = Rewards.VALID_STEP_REWARD;
        rewards[2][3] = Rewards.VALID_STEP_REWARD;
        rewards[2][4] = Rewards.VALID_STEP_REWARD;
        rewards[3][0] = Rewards.VALID_STEP_REWARD;
        rewards[3][1] = Rewards.VALID_STEP_REWARD;
        rewards[3][2] = Rewards.VALID_STEP_REWARD;
        rewards[4][0] = Rewards.VALID_STEP_REWARD;
        rewards[4][2] = Rewards.VALID_STEP_REWARD;
        rewards[5][2] = Rewards.VALID_STEP_REWARD;
        rewards[5][0] = Rewards.VALID_STEP_REWARD;
        rewards[6][0] = Rewards.VALID_STEP_REWARD;
        rewards[6][2] = Rewards.VALID_STEP_REWARD;
        rewards[6][1] = Rewards.VALID_STEP_REWARD;
        rewards[7][1] = Rewards.VALID_STEP_REWARD;
        rewards[8][1] = Rewards.VALID_STEP_REWARD;
        rewards[9][1] = Rewards.VALID_STEP_REWARD;
        rewards[9][0] = Rewards.VALID_STEP_REWARD;
        rewards[6][3] = Rewards.VALID_STEP_REWARD;
        rewards[7][3] = Rewards.VALID_STEP_REWARD;
        rewards[7][4] = Rewards.VALID_STEP_REWARD;
        rewards[7][5] = Rewards.VALID_STEP_REWARD;
        rewards[7][6] = Rewards.VALID_STEP_REWARD;
        rewards[6][6] = Rewards.VALID_STEP_REWARD;
        rewards[5][6] = Rewards.VALID_STEP_REWARD;
        rewards[5][5] = Rewards.VALID_STEP_REWARD;
        rewards[7][7] = Rewards.VALID_STEP_REWARD;
        rewards[7][8] = Rewards.VALID_STEP_REWARD;
        rewards[7][9] = Rewards.VALID_STEP_REWARD;
        rewards[8][9] = Rewards.VALID_STEP_REWARD;
        rewards[9][9] = Rewards.VALID_STEP_REWARD;
        rewards[9][8] = Rewards.VALID_STEP_REWARD;
        rewards[9][7] = Rewards.VALID_STEP_REWARD;
        rewards[9][6] = Rewards.VALID_STEP_REWARD;
        rewards[9][5] = Rewards.VALID_STEP_REWARD;
        rewards[9][4] = Rewards.VALID_STEP_REWARD;
        rewards[6][9] = Rewards.VALID_STEP_REWARD;
        rewards[5][9] = Rewards.VALID_STEP_REWARD;
        rewards[4][9] = Rewards.VALID_STEP_REWARD;
        rewards[3][8] = Rewards.VALID_STEP_REWARD;
        rewards[2][8] = Rewards.VALID_STEP_REWARD;
        rewards[1][8] = Rewards.VALID_STEP_REWARD;
        rewards[1][9] = Rewards.VALID_STEP_REWARD;
        rewards[0][9] = Rewards.VALID_STEP_REWARD;
        rewards[1][7] = Rewards.VALID_STEP_REWARD;
        rewards[1][6] = Rewards.VALID_STEP_REWARD;
        rewards[1][5] = Rewards.VALID_STEP_REWARD;
        rewards[1][4] = Rewards.VALID_STEP_REWARD;
        rewards[3][4] = Rewards.VALID_STEP_REWARD;
        rewards[3][5] = Rewards.VALID_STEP_REWARD;
        rewards[3][6] = Rewards.VALID_STEP_REWARD;

        if (debug)
            Helpers.print2DIntArray(rewards);
    }
}
