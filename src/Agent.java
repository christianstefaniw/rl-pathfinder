import java.util.Arrays;

public class Agent {
    private Environment env;
    private int epochs;

    private static final float discountFactor = 0.9f, learningRate = 0.9f, epsilon = 0.9f;

    public Agent(Environment env, int epochs) {
        this.env = env;
        this.epochs = epochs;
    }

    public void train() {
        for (int epoch = 0; epoch < epochs; epoch++) {
            env.state = env.getStartingPosition();

            while (!env.isInTerminalState()) {
                int actionIndex = env.getNextAction(epsilon);
                Position newState = env.updatedState(actionIndex);

                int reward = env.rewards.getRewardAtCoords(newState.getRow(), newState.getCol());
                double oldQValue = env.qValues.qTable[env.state.getRow()][env.state.getCol()][actionIndex];
                double temporalDifference = calculateTemporalDifference(reward, oldQValue);

                double newQValue = oldQValue + (learningRate * temporalDifference);
                env.qValues.qTable[env.state.getRow()][env.state.getCol()][actionIndex] = newQValue;

                env.state = newState;
            }
        }
    }

    private double calculateTemporalDifference(int reward, double oldQValue) {
        return reward
                + (discountFactor
                        * Arrays.stream(env.qValues.qTable[env.state.getRow()][env.state.getCol()]).max().getAsDouble())
                - oldQValue;
    }
}
