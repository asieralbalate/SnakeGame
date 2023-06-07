/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author asier
 */
public class Obstacles {
     private List<Node> obstacles;
    private int numObstacles;

    public Obstacles(Snake snake) {
        obstacles = new ArrayList<>();
        Random r = new Random();
        numObstacles = getNumObstacles();
        Node node;
        while (obstacles.size() < numObstacles) {
            int row = r.nextInt(ConfigData.instance.getBoardRowCol());
            int col = r.nextInt(ConfigData.instance.getBoardRowCol());
            while (obstacleCanGenerate(snake, row, col)) {
                row = r.nextInt(ConfigData.instance.getBoardRowCol());
                col = r.nextInt(ConfigData.instance.getBoardRowCol());
            }
            node = new Node(row, col);
            obstacles.add(node);
        }
    }
    
    private boolean obstacleCanGenerate(Snake snake, int row, int col) {
        if (snake.containNode(row, col) && isInTheList(row, col)) {
            return true;
        } else {
            return false;
        }
    }
    
    private int getNumObstacles() {
        int level = ConfigData.instance.getLevel();
        if (level == 0) {
            return 6;
        } else if (level == 0) {
            return 8;
        } else {
            return 12;
        }
    }
    
    private boolean isInTheList(int row, int col) {
        Node node = new Node(row, col);
        Node nodeInList;
        for (int i = 0; i < obstacles.size(); i++) {
            nodeInList = obstacles.get(i);
            if (nodeInList == node) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isFood(Food food) {
        int foodRow = food.getRow();
        int foodCol = food.getCol();
        Node nodeInList;
        int nodeRow;
        int nodeCol;
        for (int i = 0; i < obstacles.size(); i++) {
            nodeInList = obstacles.get(i);
            nodeRow = nodeInList.getRow();
            nodeCol = nodeInList.getCol();
            if (foodRow == nodeRow && foodCol == nodeCol) {
                return true;
            }
        }
        return false;
    }
    
    public void printObstacles(Graphics g, int squareWidth, int squareHeight) {
        for(int i = 0; i < obstacles.size(); i++) {
            
            Node nodeToPrint = obstacles.get(i);
            
            int row = nodeToPrint.getRow();
            int col = nodeToPrint.getCol();
            
            Util.drawObstacles(g, row, col, squareWidth, squareHeight);
        }
    }

    public List<Node> getListObstacles() {
        return obstacles;
    }
}
