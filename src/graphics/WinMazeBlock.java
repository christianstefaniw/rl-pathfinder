package graphics;

import java.awt.*;

public class WinMazeBlock extends MazeBlock {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
    }
}
