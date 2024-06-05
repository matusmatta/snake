package sk.matus.snake.objects;

import sk.matus.snake.enums.DirectionSnake;

import java.awt.*;

public class Snake {
    private DirectionSnake direction = DirectionSnake.UP;
    private final int[][] snake = new int[300][2];
    private final DirectionSnake[] directionSnakes = new DirectionSnake[300];
    private DirectionSnake directionOld = DirectionSnake.UP;
    private int snakeOldX = 0;
    private int snakeOldY = 0;
    private int score = 0;

    private boolean gameOver = false;

    public Snake() {
        //start position
        snake[0][0] = 300;
        snake[0][1] = 300;
    }

    public void direction(DirectionSnake direction){
        this.direction = direction;
    }

    public int getSnakeX(){
        return snake[0][0];
    }

    public int getSnakeY(){
        return snake[0][1];
    }

    public void snakeMove(){
        if(direction == DirectionSnake.UP){
            snake[0][1] = snake[0][1] - 20;
            directionSnakes[0] = DirectionSnake.UP;
        }
        if(direction == DirectionSnake.DOWN){
            snake[0][1] = snake[0][1] + 20;
            directionSnakes[0] = DirectionSnake.DOWN;
        }
        if(direction == DirectionSnake.LEFT){
            snake[0][0] = snake[0][0] - 20;
            directionSnakes[0] = DirectionSnake.LEFT;
        }
        if(direction == DirectionSnake.RIGHT){
            snake[0][0] = snake[0][0] + 20;
            directionSnakes[0] = DirectionSnake.RIGHT;
        }
    }

    public void snakePaint(Graphics g){
        g.setColor(Color.green);
        snake[1][0] = snakeOldX;
        snake[1][1] = snakeOldY;
        directionSnakes[1] = directionOld;
        //paint snake had
        g.fillRect(snake[0][0],snake[0][1],20,20);

        //paint snake body
        if(score >= 1) {
            for (int i = score; i >= 1; i--) {
                g.fillRect(snake[i][0],snake[i][1],20,20);
                snake[i][0] = snake[i - 1][0];
                snake[i][1] = snake[i - 1][1];
                directionSnakes[i] = directionSnakes[i - 1];
            }

        }
        checkCollisionBody();
        snakeOldX = snake[0][0];
        snakeOldY = snake[0][1];
        directionOld = directionSnakes[0];

    }

    private void checkCollisionBody(){
        for(int i = 2; i <= score; i++){
            if(snake[0][0] == snake[i][0] && snake[0][1] == snake[i][1]){
                gameOver = true;
            }
        }
        if(snake[0][0] < 0 || snake[0][1] < 0 || snake[0][0] > 600 || snake[0][1] > 600){
            System.out.println("game");
            gameOver = true;
        }
     }

    public void pointPosition(int pointX, int pointY){
        //check collision snake with point
        if(new Rectangle(pointX, pointY, 20, 20).intersects(snake[0][0],snake[0][1], 20,20)){
            score++;
            //add new part body snake
            if(score >= 2) {
                if (directionSnakes[score - 1] == DirectionSnake.DOWN) {
                    snake[score][0] = snake[score-1][0];
                    snake[score][1] = snake[score - 1][1] - 20;
                    directionSnakes[score] = directionSnakes[score - 1];
                }
                if (directionSnakes[score - 1] == DirectionSnake.UP) {
                    snake[score][0] = snake[score-1][0];
                    snake[score][1] = snake[score - 1][1] + 20;
                    directionSnakes[score] = directionSnakes[score - 1];
                }
                if (directionSnakes[score - 1] == DirectionSnake.LEFT) {
                    snake[score][0] = snake[score -1][0] + 20;
                    snake[score][1] = snake[score - 1][1];
                    directionSnakes[score] = directionSnakes[score - 1];
                }
                if (directionSnakes[score - 1] == DirectionSnake.RIGHT) {
                    snake[score][0] = snake[score - 1][0] - 20;
                    snake[score][1] = snake[score - 1][1];
                    directionSnakes[score] = directionSnakes[score - 1];
                }
            }
        }
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public int getScore(){
        return score;
    }

}
