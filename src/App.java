import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Environment env = new Environment();

        Rewards rewards = new Rewards(PathDifficulty.EASY);
        env.rewards = rewards;

        Position startPosition = env.getStartingPosition();
        env.state = startPosition;

        Agent aiAgent = new Agent(env, 10000);
        aiAgent.train();

        System.out.println("done!");

        final ArrayList<Position> shortestPath = env.getShortestPath(new Position(8, 3));
        Helpers.printShortestPath(shortestPath);
    }
}
