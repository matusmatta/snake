package sk.matus.snake.screen;

import java.awt.*;

public class MenuScreen {
    public MenuScreen() {
    }

    public void menuPaint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.MAGENTA);
        g.setFont(new Font("Serif",Font.BOLD,100));
        g2d.drawString("SNAKE", 125,220);

        g2d.setColor(Color.GREEN);
        g.setFont(new Font("Serif",Font.BOLD,40));
        g2d.drawString("Tap space to play", 145,300);

    }
}
