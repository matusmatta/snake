package sk.matus.snake.screen;

import java.awt.*;

public class GameOverScreen {
    public GameOverScreen() {
    }

    public void gameOverPaint(Graphics g, int score){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.MAGENTA);
        g.setFont(new Font("Serif",Font.BOLD,70));
        g2d.drawString("GAME OVER", 80,220);

        g2d.setColor(Color.GREEN);
        g.setFont(new Font("Serif",Font.BOLD,40));
        g2d.drawString("Your score is "+ score, 160,280);

        g.setFont(new Font("Serif",Font.BOLD,40));
        g2d.drawString("Tap space to restart", 120,330);

    }
}
