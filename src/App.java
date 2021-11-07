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

        final ArrayList<int[]> shortestPath = env.getShortestPath(new Position(8, 1));

        for (int i = 0; i < shortestPath.size(); i++) {
            for (int k = 0; k < shortestPath.get(i).length; k++) {
                System.out.print(shortestPath.get(i)[k]);
                System.out.print(", ");
            }
            System.out.println();
        }
    }
}
