public class App {
    public static void main(String[] args) {
        Environment env = new Environment();

        Rewards rewards = new Rewards(PathDifficulty.EASY);

        env.setRewards(rewards);

        Position startPosition = env.getStartingPosition();

        System.out.println(startPosition.getRow());
        System.out.println(startPosition.getCol());
    }
}
