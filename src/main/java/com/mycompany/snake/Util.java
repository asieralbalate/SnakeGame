/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 *
 * @author alu10191634
 */
public class Util {

    public static void drawSquare(Graphics g, int row, int col, int squareWidth, int squareHeight, SquareType squareType) {
        Color colors[] = {new Color(64, 81, 59),
            new Color(93, 156, 89)};
        int x = col * squareWidth;
        int y = row * squareHeight;
        Color color = colors[squareType.ordinal()];
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth - 2,
                squareHeight - 2);
        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight - 1, x, y);
        g.drawLine(x, y, x + squareWidth - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight - 1,
                x + squareWidth - 1, y + squareHeight - 1);
        g.drawLine(x + squareWidth - 1,
                y + squareHeight - 1,
                x + squareWidth - 1, y + 1);
    }

    public static void drawImage(Graphics g, int row, int col, int squareWidth, int squareHeight, FoodType foodType) {
        ImageIcon icons[] = {
            new ImageIcon(Util.class.getResource("/images/fresa.png")),
        new ImageIcon(Util.class.getResource("/images/banana.png"))
        };
        Image image = icons[foodType.ordinal()].getImage();
        g.drawImage(image, col * squareWidth, row * squareHeight, squareWidth, squareHeight, null);
    }
    
    public static void drawSnake(Graphics g, int row, int col, int squareWidth, int squareHeight, BodyType bodyType) {
        ImageIcon icons[] = {
           new ImageIcon(Util.class.getResource("/images/snake_cabezaArriba.png")),
           new ImageIcon(Util.class.getResource("/images/snake_cabezaDerecha.png")),
           new ImageIcon(Util.class.getResource("/images/snake_cabezaIzquierda.png")),
           new ImageIcon(Util.class.getResource("/images/snake_cabezaAbajo.png")),
           new ImageIcon(Util.class.getResource("/images/snake_cuerpo.png")),
           new ImageIcon(Util.class.getResource("/images/snake_cuerpoDeLado.png")),
           new ImageIcon(Util.class.getResource("/images/snake_colaArriba.png")),
           new ImageIcon(Util.class.getResource("/images/snake_colaIzquierda.png")),
           new ImageIcon(Util.class.getResource("/images/snake_colaDerecha.png")),
           new ImageIcon(Util.class.getResource("/images/snake_colaAbajo.png")),
           new ImageIcon(Util.class.getResource("/images/snake_giroIzquierdaArriba.png")),
           new ImageIcon(Util.class.getResource("/images/snake_giroIzquierdaDerecha.png")),
           new ImageIcon(Util.class.getResource("/images/snake_giroIzquierdaAbajo.png")),
           new ImageIcon(Util.class.getResource("/images/snake_giroIzquierda.png")),
        };
        Image image = icons[bodyType.ordinal()].getImage();
        g.drawImage(image, col * squareWidth, row * squareHeight, squareWidth, squareHeight, null);
    }
}
