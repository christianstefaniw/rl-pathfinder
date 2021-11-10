
import javax.swing.*;

import graphics.LoseMazeBlock;
import graphics.MazeBlock;
import graphics.StepMazeBlock;
import graphics.WinMazeBlock;

import java.awt.*;

public class Graphics {
    private JFrame mainFrame;
    private Environment env;
    private MazeBlock[][] mazeBlocks = new MazeBlock[Environment.numRows][Environment.numCols];

    public Graphics(Environment env) {
        this.env = env;
        prepareGUI();
        // drawMaze();
        mainFrame.add(new StepMazeBlock());
        mainFrame.setVisible(true);
    }

    private void prepareGUI() {
        mainFrame = new JFrame("RL Path Finder");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(Environment.numRows, Environment.numCols));
    }

    private void drawMaze() {
        switch (env.rewards.difficulty) {
        case EASY:
            drawEasyMaze();
            break;
        case MEDIUM:
            break;
        case HARD:
            break;
        }
    }

    private void drawEasyMaze() {
        int[][] maze = env.rewards.deepCopy();

        for (int i = 0; i < maze.length; i++) {
            for (int k = 0; k < maze[i].length; k++) {
                int reward = maze[i][k];
                MazeBlock mazeBlock;

                switch (reward) {
                case Rewards.VALID_STEP_REWARD:
                    mazeBlock = new StepMazeBlock();
                case Rewards.WIN_REWARD:
                    mazeBlock = new WinMazeBlock();
                case Rewards.LOSE_REWARD:
                    mazeBlock = new LoseMazeBlock();
                default:
                    mazeBlock = new StepMazeBlock();
                }

                mainFrame.add(mazeBlock);
                mazeBlocks[i][k] = mazeBlock;
            }
        }
    }
}
