package sk.matus.snake.objects;

import java.awt.*;
import java.util.Random;

public class Point {
    Random random;
    private int pointX = 100;
    private int pointY = 100;
    private int snakePositionX = 0;
    private int snakePositionY = 0;

    public Point() {
        random = new Random();
    }

    public void pointPaint(Graphics g){

        //if snake had intersects with point than generate new point
        if(new Rectangle(pointX, pointY, 20, 20).intersects(snakePositionX, snakePositionY, 20,20)){
           pointX = random.nextInt(400);
           int x = pointX % 20;
           pointX = pointX - x;
           pointY = random.nextInt(400);
           int y = pointY % 20;
           pointY = pointY - y;
        }

        //draw point
        g.setColor(Color.MAGENTA);
        g.fillRect(pointX ,pointY,20,20);
    }

    public void snakePosition(int snakePositionX, int snakePositionY){
        this.snakePositionX = snakePositionX;
        this.snakePositionY = snakePositionY;
    }

    public int getPointX(){
        return pointX;
    }

    public int getPointY(){
        return pointY;
    }

}
