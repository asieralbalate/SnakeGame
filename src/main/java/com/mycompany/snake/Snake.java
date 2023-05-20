/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import static com.mycompany.snake.Direction.DOWN;
import static com.mycompany.snake.Direction.LEFT;
import static com.mycompany.snake.Direction.UP;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;
import static com.mycompany.snake.Direction.RIGHT;

/**
 *
 * @author alu10191634
 */
public class Snake {

    private Direction direction;
    private List<Node> listOfNodes;
    private int initNodes;
    private int toGrow;

    public Snake(Direction direction, int initNodes) {
        this.direction = direction;
        this.initNodes = initNodes;
        initialSnake(initNodes);

    }

    public void initialSnake(int initNodes) {
        int rows = ConfigData.instance.getBoardRowCol();
        int cols = ConfigData.instance.getBoardRowCol();
        int initPos = cols / 4;
        listOfNodes = new ArrayList<>();
        for (int i = 0; i < initNodes; i++) {
            Node node = new Node(rows / 2, initPos);
            listOfNodes.add(node);
            initPos--;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    
    /*private boolean prevNodeLeft(int i){
        Node prevNode = listOfNodes.get(i + 1);
        Node nodeToPrint = listOfNodes.get(i);
        if((prevNode.getCol() + 1 == nodeToPrint.getCol()) || prevNode.getCol() == ConfigData.instance.getBoardRowCol()-1){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean prevNodeRight(int i){
        Node prevNode = listOfNodes.get(i + 1);
        Node nodeToPrint = listOfNodes.get(i);
        if((prevNode.getCol() - 1 == nodeToPrint.getCol()) || prevNode.getCol() == 0){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean prevNodeUp(int i){
        Node prevNode = listOfNodes.get(i + 1);
        Node nodeToPrint = listOfNodes.get(i);
        if((prevNode.getRow() + 1 == nodeToPrint.getRow())
                || prevNode.getRow() == ConfigData.instance.getBoardRowCol() - 1){
            return true;
        } else {
            return false;
        }
    
    }
    
    public boolean prevNodeDown(int i){
        Node prevNode = listOfNodes.get(i + 1);
        Node nodeToPrint = listOfNodes.get(i);
        if((prevNode.getRow() - 1 == nodeToPrint.getRow()) || prevNode.getRow() == 0){
            return true;
        } else {
            return false;
        }
    }
    
    private boolean nextNodeLeft(int i){
        Node nextNode = listOfNodes.get(i - 1);
        Node nodeToPrint = listOfNodes.get(i);
        if((nextNode.getCol() + 1 == nodeToPrint.getCol()) || nextNode.getCol() == ConfigData.instance.getBoardRowCol() -1 ){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean nextNodeRight(int i){
        Node nextNode = listOfNodes.get(i - 1);
        Node nodeToPrint = listOfNodes.get(i);
        if((nextNode.getCol() - 1 == nodeToPrint.getCol()) || nextNode.getCol() == 0){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean nextNodeUp(int i){
        Node nextNode = listOfNodes.get(i - 1);
        Node nodeToPrint = listOfNodes.get(i);
        if((nextNode.getRow() + 1 == nodeToPrint.getRow()) 
                ||  (nextNode.getRow() == ConfigData.instance.getBoardRowCol() - 1)){
            return true;
        } else {
            return false;
        }
    
    }
        
    public boolean nextNodeDown(int i){
        Node nextNode = listOfNodes.get(i - 1);
        Node nodeToPrint = listOfNodes.get(i);
        if((nextNode.getRow() - 1 == nodeToPrint.getRow()) || (nextNode.getRow() == 0)){
            return true;
        } else {
            return false;
        }
    }*/
    
    private boolean prevNodeLeft(int i){
        int prevCol = listOfNodes.get(i + 1).getCol();
        int colToPrint = listOfNodes.get(i).getCol();
        if (colToPrint != 0) {
            return prevCol < colToPrint;
        } else {
            return prevCol > colToPrint;
        }
    }
    
    public boolean prevNodeRight(int i){
        int prevCol = listOfNodes.get(i + 1).getCol();
        int colToPrint = listOfNodes.get(i).getCol();
        if (colToPrint != 0) {
            return prevCol > colToPrint;
        } else {
            return prevCol < colToPrint;
        }
    }
    
    public boolean prevNodeUp(int i){
        int prevRow = listOfNodes.get(i + 1).getRow();
        int rowToPrint = listOfNodes.get(i).getRow();
        if (rowToPrint != 0) {
            return prevRow < rowToPrint;
        } else {
            return prevRow > rowToPrint;
        }
    }
    
    public boolean prevNodeDown(int i){
        int prevRow = listOfNodes.get(i + 1).getRow();
        int rowToPrint = listOfNodes.get(i).getRow();
        if (rowToPrint != 0) {
            return prevRow > rowToPrint;
        } else {
            return prevRow < rowToPrint;
        }
    }
    
    private boolean nextNodeLeft(int i){
        int nextCol = listOfNodes.get(i - 1).getCol();
        int colToPrint = listOfNodes.get(i).getCol();
        if (colToPrint != 0) {
            return nextCol < colToPrint;
        } else {
            return nextCol > colToPrint;
        }
    }
    
    public boolean nextNodeRight(int i){
        int nextCol = listOfNodes.get(i - 1).getCol();
        int colToPrint = listOfNodes.get(i).getCol();
        if (colToPrint != 0) {
            return nextCol > colToPrint;
        } else {
            return nextCol < colToPrint;
        }
    }
    
    public boolean nextNodeUp(int i){
        int nextRow = listOfNodes.get(i - 1).getRow();
        int rowToPrint = listOfNodes.get(i).getRow();
        if (rowToPrint != 0) {
            return nextRow < rowToPrint;
        } else {
            return nextRow > rowToPrint;
        }
    }
        
    public boolean nextNodeDown(int i){
        int nextRow = listOfNodes.get(i - 1).getRow();
        int rowToPrint = listOfNodes.get(i).getRow();
        if (rowToPrint != 0) {
            return nextRow > rowToPrint;
        } else {
            return nextRow < rowToPrint;
        }
    }
        
    
    public void printSnake(Graphics g, int squareWidth, int squareHeight) {

        Node nodeToPrint;
        for (int i = 0; i < listOfNodes.size(); i++) {
            nodeToPrint = listOfNodes.get(i);
            //cabeza
            if (nodeToPrint == listOfNodes.get(0)) {
                switch (direction) {
                    case UP:
                        Util.drawSnake(g, nodeToPrint.getRow(), nodeToPrint.getCol(), squareWidth, squareHeight, BodyType.NHEAD);
                        break;
                    case DOWN:
                        Util.drawSnake(g, nodeToPrint.getRow(), nodeToPrint.getCol(), squareWidth, squareHeight, BodyType.SHEAD);
                        break;
                    case LEFT:
                        Util.drawSnake(g, nodeToPrint.getRow(), nodeToPrint.getCol(), squareWidth, squareHeight, BodyType.WHEAD);
                        break;
                    case RIGHT:
                        Util.drawSnake(g, nodeToPrint.getRow(), nodeToPrint.getCol(), squareWidth, squareHeight, BodyType.EHEAD);
                        break;
                }
                //cola
            } else if (nodeToPrint == listOfNodes.get(listOfNodes.size() - 1)) {
                Node previousNode = listOfNodes.get(listOfNodes.size() - 2);
                if (nodeToPrint.getRow() - 1 == previousNode.getRow() && nodeToPrint.getCol() == previousNode.getCol()) {
                    
                    Util.drawSnake(g, nodeToPrint.getRow(), nodeToPrint.getCol(), squareWidth, squareHeight, BodyType.NTAIL);
                    
                } else if (nodeToPrint.getRow() + 1 == previousNode.getRow() && nodeToPrint.getCol() == previousNode.getCol()) {
                    
                    Util.drawSnake(g, nodeToPrint.getRow(), nodeToPrint.getCol(), squareWidth, squareHeight, BodyType.STAIL);
                    
                } else if (nodeToPrint.getRow() == previousNode.getRow() && nodeToPrint.getCol() + 1 == previousNode.getCol()) {
                    
                    Util.drawSnake(g, nodeToPrint.getRow(), nodeToPrint.getCol(), squareWidth, squareHeight, BodyType.WTAIL);
                    
                } else if (nodeToPrint.getRow() == previousNode.getRow() && nodeToPrint.getCol() - 1 == previousNode.getCol()) {
                    
                    Util.drawSnake(g, nodeToPrint.getRow(), nodeToPrint.getCol(), squareWidth, squareHeight, BodyType.ETAIL);
                }
            } else {                
                Node prevNode = listOfNodes.get(i + 1);
                Node nextNode = listOfNodes.get(i - 1);
                if (prevNode.getRow() == nextNode.getRow()) {
                    //segmento horizontal
                    if (prevNode.getCol() < nextNode.getCol()) {
                        Util.drawSnake(g, nodeToPrint.getRow(), nodeToPrint.getCol(), squareWidth, squareHeight, BodyType.HBODY);
                    } else {
                        Util.drawSnake(g, nodeToPrint.getRow(), nodeToPrint.getCol(), squareWidth, squareHeight, BodyType.HBODY);
                    }
                } else if (prevNode.getCol() == nextNode.getCol()) {
                    //segmento vertical
                    if (prevNode.getRow() < nextNode.getRow()) {
                        Util.drawSnake(g, nodeToPrint.getRow(), nodeToPrint.getCol(), squareWidth, squareHeight, BodyType.VBODY);
                    } else {
                        Util.drawSnake(g, nodeToPrint.getRow(), nodeToPrint.getCol(), squareWidth, squareHeight, BodyType.VBODY);
                    }
                } else {
                    //esquinas
                    if (nextNodeUp(i) && prevNodeRight(i) || nextNodeRight(i) && prevNodeUp(i)) {
                        
                        Util.drawSnake(g, nodeToPrint.getRow(), nodeToPrint.getCol(), squareWidth, squareHeight, BodyType.NEBODY);

                    } else if (nextNodeUp(i) && prevNodeLeft(i)||nextNodeLeft(i)&&prevNodeUp(i)) {
                        
                        Util.drawSnake(g, nodeToPrint.getRow(), nodeToPrint.getCol(), squareWidth, squareHeight, BodyType.NOBODY);

                    } else if ((nextNodeDown(i)&& prevNodeRight(i)) || (nextNodeRight(i) && prevNodeDown(i)) || (prevNodeRight(i) && nextNodeDown(i) )) {
                        
                        Util.drawSnake(g, nodeToPrint.getRow(), nodeToPrint.getCol(), squareWidth, squareHeight, BodyType.SEBODY);

                    } else {
                        Util.drawSnake(g, nodeToPrint.getRow(), nodeToPrint.getCol(), squareWidth, squareHeight, BodyType.SOBODY);
                    }
                }
            }
        }
    }

    public boolean containNode(int row, int col) {
        for (int i = 0; i < listOfNodes.size(); i++) {
            Node nodeInSnake = listOfNodes.get(i);
            if (row == nodeInSnake.getRow() && col == nodeInSnake.getCol()) {
                return true;
            }
        }
        return false;
    }

    public void move() {
        Node node;
        int row = listOfNodes.get(0).getRow();
        int col = listOfNodes.get(0).getCol();
        if (ConfigData.instance.getWallLevel() == false) {
            int newRow = row;
            int newCol = col;
            switch (direction) {
                case UP:
                    newRow = (row - 1 < 0) ? ConfigData.instance.getBoardRowCol() - 1 : row - 1;      
                    break;
                case DOWN:
                    newRow = (row + 1 > ConfigData.instance.getBoardRowCol() - 1) ? 0 : row + 1;  
                    break;
                case LEFT:
                    newCol = (col - 1 < 0) ? ConfigData.instance.getBoardRowCol() - 1 : col - 1;
                    break;
                case RIGHT:
                    newCol = (col + 1 > ConfigData.instance.getBoardRowCol() - 1) ? 0 : col + 1;
                    break;
                default:
                    throw new AssertionError();
            }
            node = new Node(newRow, newCol);
            listOfNodes.add(0, node);
        } else {
            switch (direction) {
                case UP:
                    node = new Node(row - 1, col);
                    listOfNodes.add(0, node);
                    break;
                case DOWN:
                    node = new Node(row + 1, col);
                    listOfNodes.add(0, node);
                    break;
                case LEFT:
                    node = new Node(row, col - 1);
                    listOfNodes.add(0, node);
                    break;
                case RIGHT:
                    node = new Node(row, col + 1);
                    listOfNodes.add(0, node);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        if (toGrow <= 0) {
            listOfNodes.remove(listOfNodes.size() - 1);
        } else {
            toGrow--;
        }
    }

    
    public boolean canMove() {
        int row = listOfNodes.get(0).getRow();
        int col = listOfNodes.get(0).getCol();
        if (ConfigData.instance.getWallLevel() == false) {
            switch (direction) {
                case UP:
                    if (containNode(row - 1, col)) {
                        return false;
                    }
                    break;
                case DOWN:
                    if (containNode(row + 1, col)) {
                        return false;
                    }
                    break;
                case LEFT:
                    if (containNode(row, col - 1)) {
                        return false;
                    }
                    break;
                case RIGHT:
                    if (containNode(row, col + 1)) {
                        return false;
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            return true;
        } else {
            switch (direction) {
                case UP:
                    if (row - 1 < 0 || containNode(row - 1, col)) {
                        return false;
                    }
                    break;
                case DOWN:
                    if (row + 1 >= ConfigData.instance.getBoardRowCol() || containNode(row + 1, col)) {
                        return false;
                    }
                    break;
                case LEFT:
                    if (col - 1 < 0 || containNode(row, col - 1)) {
                        return false;
                    }
                    break;
                case RIGHT:
                    if (col + 1 >= ConfigData.instance.getBoardRowCol() || containNode(row, col + 1)) {
                        return false;
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            return true;
        }
    }


    public boolean eatFood(Food food) {
        int score = 0;
        if (food == null) {
            return false;
        }
        int foodRow = food.getRow();
        int foodCol = food.getCol();
        int headRow = listOfNodes.get(0).getRow();
        int headCol = listOfNodes.get(0).getCol();
        if (foodRow == headRow && foodCol == headCol) {
            toGrow += food.nodesWhenEat();
            return true;
        } else {
            return false;
        }
    }

}
