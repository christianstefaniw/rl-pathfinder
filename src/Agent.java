public class Agent {
    private Environment env;
    private int epochs;

    // models that future rewards are worth less than immediate rewards
    private static final float discountFactor = 0.9f;

    // determines how fast agent learns
    private static final float learningRate = 0.9f;

    // probability that the agent takes an exploratory action
    private static final float epsilon = 0.1f;

    public Agent(Environment env, int epochs) {
        this.env = env;
        this.epochs = epochs;
    }

    public void train() {
        for (int epoch = 0; epoch < epochs; epoch++) {
            env.putInRandStartingPosition();

            while (!env.isInTerminalState()) {
                Position oldState = env.getState();
                int actionIndex = env.getNextAction(epsilon);

                env.updateState(actionIndex);
                Position newState = env.getState();

                int reward = env.getRewards().getRewardAtState(newState);
                double oldQValue = env.getQValues().getQValue(oldState, actionIndex);
                double temporalDifference = calculateTemporalDifference(reward, oldQValue);

                double newQValue = calculateQValue(oldQValue, temporalDifference);
                env.getQValues().setQValue(oldState, actionIndex, newQValue);
            }
        }
    }

    /**
     * Bellman equation to calculate new Q value
     * 
     * @param oldQValue
     * @param temporalDifference
     * @return
     */
    private double calculateQValue(double oldQValue, double temporalDifference) {
        return oldQValue + (learningRate * temporalDifference);
    }

    /**
     * Calculate how much the previous Q value for the action taken should change
     * based on what the agent has learned about the Q values for the current state
     * 
     * @param reward
     * @param oldQValue
     * @return
     */
    private double calculateTemporalDifference(int reward, double oldQValue) {
        return reward + (discountFactor * (env.getMaxQAtCurrState())) - oldQValue;
    }
}
