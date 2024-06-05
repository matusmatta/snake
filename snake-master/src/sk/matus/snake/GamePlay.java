package sk.matus.snake;

import sk.matus.snake.enums.DirectionSnake;
import sk.matus.snake.enums.Screen;
import sk.matus.snake.objects.Point;
import sk.matus.snake.objects.Snake;
import sk.matus.snake.screen.GameOverScreen;
import sk.matus.snake.screen.MenuScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private final Timer timer;
    private int yPositionMove = 0;

    private Screen screenActive;

    private final MenuScreen menu;
    private  final GameOverScreen gameOverScreen;

    private Snake snake;
    private Point point;

    private boolean horizontalMoveActive = false;
    private boolean verticalMoveActive = false;

    public GamePlay() {
        int delay = 150;
        screenActive = Screen.MENU;
        menu = new MenuScreen();
        gameOverScreen = new GameOverScreen();
        snake = new Snake();
        point = new Point();
        timer = new Timer(delay,this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    public void paint(Graphics g){
        //set background color
        g.setColor(Color.black);
        g.fillRect(0,0,600,600);

        //menu screen active
        if(screenActive == Screen.MENU){
            menu.menuPaint(g);
        }

        //gameplay active
        if(screenActive == Screen.PLAY) {
            snake.snakePaint(g);
            point.pointPaint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.cyan);
            g.setFont(new Font("Serif",Font.BOLD,30));
            g2d.drawString(String.valueOf(snake.getScore()), 280,40);
        }

        //game over screen active
        if(screenActive == Screen.GAMEOVER){
            gameOverScreen.gameOverPaint(g, snake.getScore());
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(screenActive == Screen.PLAY) {
            yPositionMove = yPositionMove + 5;
            snake.snakeMove();
            snake.pointPosition(point.getPointX(), point.getPointY());
            point.snakePosition(snake.getSnakeX(), snake.getSnakeY());
        }

        if(snake.isGameOver()){
            screenActive = Screen.GAMEOVER;
        }

        requestFocus();
        timer.start();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP && !verticalMoveActive) {
            snake.direction(DirectionSnake.UP);
            verticalMoveActive = true;
            horizontalMoveActive = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN && !verticalMoveActive){
            snake.direction(DirectionSnake.DOWN);
            verticalMoveActive = true;
            horizontalMoveActive = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT && !horizontalMoveActive){
            snake.direction(DirectionSnake.LEFT);
            horizontalMoveActive = true;
            verticalMoveActive = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT && !horizontalMoveActive){
            snake.direction(DirectionSnake.RIGHT);
            horizontalMoveActive = true;
            verticalMoveActive = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE && screenActive == Screen.MENU){
            screenActive = Screen.PLAY;
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE && screenActive == Screen.GAMEOVER){
            screenActive =  Screen.PLAY;
            snake = new Snake();
            point = new Point();
        }

    }





    @Override
    public void keyReleased(KeyEvent e) {

    }
}
