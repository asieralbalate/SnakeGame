/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 *
 * @author alu10191634
 */
public class Util {

    public static void drawFood(Graphics g, int row, int col, int squareWidth, int squareHeight, FoodType foodType) {
        ImageIcon icons[] = {
            new ImageIcon(Util.class.getResource("/images/fresa.png")),
            new ImageIcon(Util.class.getResource("/images/banana.png"))
        };
        Image image = icons[foodType.ordinal()].getImage();
        g.drawImage(image, col * squareWidth, row * squareHeight, squareWidth, squareHeight, null);
    }

    public static void drawSnake(Graphics g, int row, int col, int squareWidth, int squareHeight, BodyType bodyType) {
        ImageIcon imageIcons[] = {new ImageIcon(Util.class.getResource("/images/snake_cabezaArriba.png")),
            new ImageIcon(Util.class.getResource("/images/snake_cabezaAbajo.png")),
            new ImageIcon(Util.class.getResource("/images/snake_cabezaDerecha.png")),
            new ImageIcon(Util.class.getResource("/images/snake_cabezaIzquierda.png")),
            new ImageIcon(Util.class.getResource("/images/snake_colaArriba.png")),
            new ImageIcon(Util.class.getResource("/images/snake_colaAbajo.png")),
            new ImageIcon(Util.class.getResource("/images/snake_colaDerecha.png")),
            new ImageIcon(Util.class.getResource("/images/snake_colaIzquierda.png")),
            new ImageIcon(Util.class.getResource("/images/snake_cuerpoHaciaArriba.png")),
            new ImageIcon(Util.class.getResource("/images/snake_cuerpoDeLado.png")),
            new ImageIcon(Util.class.getResource("/images/snake_giroNO.png")),
            new ImageIcon(Util.class.getResource("/images/snake_giroNE.png")),
            new ImageIcon(Util.class.getResource("/images/snake_giroSO.png")),
            new ImageIcon(Util.class.getResource("/images/snake_giroSE.png"))};
        Image image = imageIcons[bodyType.ordinal()].getImage();
        g.drawImage(image, col * squareWidth, row * squareHeight, squareWidth, squareHeight, null);
    }

    public static void drawObstacles(Graphics g, int row, int col, int squareWidth, int squareHeight) {
        ImageIcon imageIcons = new ImageIcon(Util.class.getResource("/images/cactus.png"));
        Image image = imageIcons.getImage();
        g.drawImage(image, col * squareWidth, row * squareHeight, squareWidth, squareHeight, null);
    }
}
