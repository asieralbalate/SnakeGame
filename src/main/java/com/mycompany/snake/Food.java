/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author alu10191634
 */
public class Food extends Node{

    private static final int POINTS = 5;
      
    public Food(Snake snake) {
        super(0,0);
        Random r = new Random();
        int row = r.nextInt(ConfigData.instance.getBoardRowCol());
        int col = r.nextInt(ConfigData.instance.getBoardRowCol());
        
        while (snake.containNode(row, col)) {
            row = r.nextInt(ConfigData.instance.getBoardRowCol());
            col = r.nextInt(ConfigData.instance.getBoardRowCol()); 
        }
        
        setRow(row);
        setCol(col);
    }
    
    public void printFood(Graphics g, int squareWidht, int squareHeight){
       Util.drawImage(g, getRow(), getCol(), squareWidht, squareHeight, FoodType.FOOD);
    }
    
    public void remove(){     
    }
    
    public int getPoints(){
        return POINTS;
    }

    public int nodesWhenEat(){
        return 1;
    }

}
