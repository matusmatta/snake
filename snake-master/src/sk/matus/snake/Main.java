package sk.matus.snake;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame obj = new JFrame();
        GamePlay gamePlay = new GamePlay();

        obj.setBounds(0,0,600,600);
        obj.setTitle("SNAKE");
        obj.setLocationRelativeTo(obj);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.add(gamePlay);

        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
