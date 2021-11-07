package graphics;

import java.awt.*;

public class LoseMazeBlock extends MazeBlock {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
    }
}
