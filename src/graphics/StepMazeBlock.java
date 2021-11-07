package graphics;

import java.awt.*;

public class StepMazeBlock extends MazeBlock {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
    }
}
