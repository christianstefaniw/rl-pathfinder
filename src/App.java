import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Environment env = new Environment();

        Rewards rewards = new Rewards(PathDifficulty.MEDIUM);
        env.rewards = rewards;

        Agent aiAgent = new Agent(env, 10000);
        aiAgent.train();

        System.out.println("done!");

        final ArrayList<Position> shortestPath = env.getShortestPath(new Position(9, 0));
        Helpers.printShortestPath(shortestPath);
    }
}
